package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.handler.codec.http2.Http2FrameWriter;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.collection.CharObjectMap;
import io.netty.util.internal.ObjectUtil;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DefaultHttp2FrameWriter implements Http2FrameWriter, Http2FrameSizePolicy, Http2FrameWriter.Configuration {
    private static final String STREAM_DEPENDENCY = "Stream Dependency";
    private static final String STREAM_ID = "Stream ID";
    private static final ByteBuf ZERO_BUFFER = Unpooled.unreleasableBuffer(Unpooled.directBuffer(255).writeZero(255)).asReadOnly();
    private final Http2HeadersEncoder headersEncoder;
    private int maxFrameSize;

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static final class DataFrameHeader {
        private final ByteBuf buffer;
        private final Http2Flags flags = new Http2Flags();
        private ByteBuf frameHeader;
        private int prevData;
        private int prevPadding;
        private final int streamId;

        DataFrameHeader(ChannelHandlerContext channelHandlerContext, int i) {
            this.buffer = channelHandlerContext.alloc().buffer(30);
            this.streamId = i;
        }

        void release() {
            this.buffer.release();
        }

        ByteBuf slice(int i, int i2, boolean z) {
            if (i != this.prevData || i2 != this.prevPadding || z != this.flags.endOfStream() || this.frameHeader == null) {
                this.prevData = i;
                this.prevPadding = i2;
                this.flags.paddingPresent(i2 > 0);
                this.flags.endOfStream(z);
                ByteBuf writerIndex = this.buffer.readSlice(10).writerIndex(0);
                this.frameHeader = writerIndex;
                Http2CodecUtil.writeFrameHeaderInternal(writerIndex, i + i2, (byte) 0, this.flags, this.streamId);
                DefaultHttp2FrameWriter.writePaddingLength(this.frameHeader, i2);
            }
            return this.frameHeader.slice();
        }
    }

    public DefaultHttp2FrameWriter() {
        this(new DefaultHttp2HeadersEncoder());
    }

    private static int paddingBytes(int i) {
        return i - 1;
    }

    private static void verifyErrorCode(long j) {
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException("Invalid errorCode: " + j);
        }
    }

    private static void verifyPingPayload(ByteBuf byteBuf) {
        if (byteBuf == null || byteBuf.readableBytes() != 8) {
            throw new IllegalArgumentException("Opaque data must be 8 bytes");
        }
    }

    private static void verifyStreamId(int i, String str) {
        if (i > 0) {
            return;
        }
        throw new IllegalArgumentException(str + " must be > 0");
    }

    private static void verifyStreamOrConnectionId(int i, String str) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " must be >= 0");
    }

    private static void verifyWeight(short s) {
        if (s < 1 || s > 256) {
            throw new IllegalArgumentException("Invalid weight: " + ((int) s));
        }
    }

    private static void verifyWindowSizeIncrement(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("WindowSizeIncrement must be >= 0");
        }
    }

    private ChannelFuture writeContinuationFrames(ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator) {
        Http2Flags paddingPresent = new Http2Flags().paddingPresent(i2 > 0);
        int i3 = this.maxFrameSize - i2;
        if (i3 <= 0) {
            return simpleChannelPromiseAggregator.setFailure((Throwable) new IllegalArgumentException("Padding [" + i2 + "] is too large for max frame size [" + this.maxFrameSize + "]"));
        } else if (byteBuf.isReadable()) {
            ByteBuf buffer = channelHandlerContext.alloc().buffer(10);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, Math.min(byteBuf.readableBytes(), i3) + i2, (byte) 9, paddingPresent, i);
            writePaddingLength(buffer, i2);
            do {
                int min = Math.min(byteBuf.readableBytes(), i3);
                Object readRetainedSlice = byteBuf.readRetainedSlice(min);
                int i4 = min + i2;
                if (byteBuf.isReadable()) {
                    channelHandlerContext.write(buffer.retain(), simpleChannelPromiseAggregator.newPromise());
                } else {
                    paddingPresent = paddingPresent.endOfHeaders(true);
                    buffer.release();
                    buffer = channelHandlerContext.alloc().buffer(10);
                    Http2CodecUtil.writeFrameHeaderInternal(buffer, i4, (byte) 9, paddingPresent, i);
                    writePaddingLength(buffer, i2);
                    channelHandlerContext.write(buffer, simpleChannelPromiseAggregator.newPromise());
                }
                channelHandlerContext.write(readRetainedSlice, simpleChannelPromiseAggregator.newPromise());
                if (paddingBytes(i2) > 0) {
                    channelHandlerContext.write(ZERO_BUFFER.slice(0, paddingBytes(i2)), simpleChannelPromiseAggregator.newPromise());
                }
            } while (byteBuf.isReadable());
            return simpleChannelPromiseAggregator;
        } else {
            return simpleChannelPromiseAggregator;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00df, code lost:
        if (r7 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private io.netty.channel.ChannelFuture writeHeadersInternal(io.netty.channel.ChannelHandlerContext r16, int r17, io.netty.handler.codec.http2.Http2Headers r18, int r19, boolean r20, boolean r21, int r22, short r23, boolean r24, io.netty.channel.ChannelPromise r25) {
        /*
            r15 = this;
            r1 = r15
            r0 = r16
            r2 = r17
            r3 = r19
            r4 = r21
            r5 = r22
            io.netty.handler.codec.http2.Http2CodecUtil$SimpleChannelPromiseAggregator r6 = new io.netty.handler.codec.http2.Http2CodecUtil$SimpleChannelPromiseAggregator
            io.netty.channel.Channel r7 = r16.channel()
            io.netty.util.concurrent.EventExecutor r8 = r16.executor()
            r9 = r25
            r6.<init>(r9, r7, r8)
            r7 = 0
            java.lang.String r8 = "Stream ID"
            verifyStreamId(r2, r8)     // Catch: java.lang.Throwable -> Ldb
            if (r4 == 0) goto L2d
            java.lang.String r8 = "Stream Dependency"
            verifyStreamOrConnectionId(r5, r8)     // Catch: java.lang.Throwable -> Ldb
            io.netty.handler.codec.http2.Http2CodecUtil.verifyPadding(r19)     // Catch: java.lang.Throwable -> Ldb
            verifyWeight(r23)     // Catch: java.lang.Throwable -> Ldb
        L2d:
            io.netty.buffer.ByteBufAllocator r8 = r16.alloc()     // Catch: java.lang.Throwable -> Ldb
            io.netty.buffer.ByteBuf r7 = r8.buffer()     // Catch: java.lang.Throwable -> Ldb
            io.netty.handler.codec.http2.Http2HeadersEncoder r8 = r1.headersEncoder     // Catch: java.lang.Throwable -> Ldb
            r9 = r18
            r8.encodeHeaders(r9, r7)     // Catch: java.lang.Throwable -> Ldb
            io.netty.handler.codec.http2.Http2Flags r8 = new io.netty.handler.codec.http2.Http2Flags     // Catch: java.lang.Throwable -> Ldb
            r8.<init>()     // Catch: java.lang.Throwable -> Ldb
            r9 = r20
            io.netty.handler.codec.http2.Http2Flags r8 = r8.endOfStream(r9)     // Catch: java.lang.Throwable -> Ldb
            io.netty.handler.codec.http2.Http2Flags r8 = r8.priorityPresent(r4)     // Catch: java.lang.Throwable -> Ldb
            r9 = 0
            r10 = 1
            if (r3 <= 0) goto L51
            r11 = 1
            goto L52
        L51:
            r11 = 0
        L52:
            io.netty.handler.codec.http2.Http2Flags r8 = r8.paddingPresent(r11)     // Catch: java.lang.Throwable -> Ldb
            int r11 = r8.getNumPriorityBytes()     // Catch: java.lang.Throwable -> Ldb
            int r11 = r11 + r3
            int r12 = r1.maxFrameSize     // Catch: java.lang.Throwable -> Ldb
            int r12 = r12 - r11
            int r13 = r7.readableBytes()     // Catch: java.lang.Throwable -> Ldb
            int r12 = java.lang.Math.min(r13, r12)     // Catch: java.lang.Throwable -> Ldb
            io.netty.buffer.ByteBuf r12 = r7.readRetainedSlice(r12)     // Catch: java.lang.Throwable -> Ldb
            boolean r13 = r7.isReadable()     // Catch: java.lang.Throwable -> Ldb
            if (r13 != 0) goto L72
            r13 = 1
            goto L73
        L72:
            r13 = 0
        L73:
            r8.endOfHeaders(r13)     // Catch: java.lang.Throwable -> Ldb
            int r13 = r12.readableBytes()     // Catch: java.lang.Throwable -> Ldb
            int r13 = r13 + r11
            io.netty.buffer.ByteBufAllocator r11 = r16.alloc()     // Catch: java.lang.Throwable -> Ldb
            r14 = 15
            io.netty.buffer.ByteBuf r11 = r11.buffer(r14)     // Catch: java.lang.Throwable -> Ldb
            io.netty.handler.codec.http2.Http2CodecUtil.writeFrameHeaderInternal(r11, r13, r10, r8, r2)     // Catch: java.lang.Throwable -> Ldb
            writePaddingLength(r11, r3)     // Catch: java.lang.Throwable -> Ldb
            if (r4 == 0) goto La0
            if (r24 == 0) goto L97
            r13 = 2147483648(0x80000000, double:1.0609978955E-314)
            long r4 = (long) r5     // Catch: java.lang.Throwable -> Ldb
            long r4 = r4 | r13
            goto L98
        L97:
            long r4 = (long) r5     // Catch: java.lang.Throwable -> Ldb
        L98:
            io.netty.handler.codec.http2.Http2CodecUtil.writeUnsignedInt(r4, r11)     // Catch: java.lang.Throwable -> Ldb
            int r4 = r23 + (-1)
            r11.writeByte(r4)     // Catch: java.lang.Throwable -> Ldb
        La0:
            io.netty.channel.ChannelPromise r4 = r6.newPromise()     // Catch: java.lang.Throwable -> Ldb
            r0.write(r11, r4)     // Catch: java.lang.Throwable -> Ldb
            io.netty.channel.ChannelPromise r4 = r6.newPromise()     // Catch: java.lang.Throwable -> Ldb
            r0.write(r12, r4)     // Catch: java.lang.Throwable -> Ldb
            int r4 = paddingBytes(r19)     // Catch: java.lang.Throwable -> Ldb
            if (r4 <= 0) goto Lc5
            io.netty.buffer.ByteBuf r4 = io.netty.handler.codec.http2.DefaultHttp2FrameWriter.ZERO_BUFFER     // Catch: java.lang.Throwable -> Ldb
            int r5 = paddingBytes(r19)     // Catch: java.lang.Throwable -> Ldb
            io.netty.buffer.ByteBuf r4 = r4.slice(r9, r5)     // Catch: java.lang.Throwable -> Ldb
            io.netty.channel.ChannelPromise r5 = r6.newPromise()     // Catch: java.lang.Throwable -> Ldb
            r0.write(r4, r5)     // Catch: java.lang.Throwable -> Ldb
        Lc5:
            boolean r4 = r8.endOfHeaders()     // Catch: java.lang.Throwable -> Ldb
            if (r4 != 0) goto Le1
            r20 = r15
            r21 = r16
            r22 = r17
            r23 = r7
            r24 = r19
            r25 = r6
            r20.writeContinuationFrames(r21, r22, r23, r24, r25)     // Catch: java.lang.Throwable -> Ldb
            goto Le1
        Ldb:
            r0 = move-exception
            r6.setFailure(r0)     // Catch: java.lang.Throwable -> Le9
            if (r7 == 0) goto Le4
        Le1:
            r7.release()
        Le4:
            io.netty.channel.ChannelPromise r0 = r6.doneAllocatingPromises()
            return r0
        Le9:
            r0 = move-exception
            r2 = r0
            if (r7 == 0) goto Lf0
            r7.release()
        Lf0:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.DefaultHttp2FrameWriter.writeHeadersInternal(io.netty.channel.ChannelHandlerContext, int, io.netty.handler.codec.http2.Http2Headers, int, boolean, boolean, int, short, boolean, io.netty.channel.ChannelPromise):io.netty.channel.ChannelFuture");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writePaddingLength(ByteBuf byteBuf, int i) {
        if (i > 0) {
            byteBuf.writeByte(i - 1);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public Http2FrameWriter.Configuration configuration() {
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter.Configuration
    public Http2FrameSizePolicy frameSizePolicy() {
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter.Configuration
    public Http2HeaderTable headerTable() {
        return this.headersEncoder.configuration().headerTable();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameSizePolicy
    public void maxFrameSize(int i) throws Http2Exception {
        if (!Http2CodecUtil.isMaxFrameSizeValid(i)) {
            throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Invalid MAX_FRAME_SIZE specified in sent settings: %d", Integer.valueOf(i));
        }
        this.maxFrameSize = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ab  */
    @Override // io.netty.handler.codec.http2.Http2DataWriter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.netty.channel.ChannelFuture writeData(io.netty.channel.ChannelHandlerContext r16, int r17, io.netty.buffer.ByteBuf r18, int r19, boolean r20, io.netty.channel.ChannelPromise r21) {
        /*
            r15 = this;
            r1 = r15
            r0 = r16
            r2 = r17
            io.netty.handler.codec.http2.Http2CodecUtil$SimpleChannelPromiseAggregator r3 = new io.netty.handler.codec.http2.Http2CodecUtil$SimpleChannelPromiseAggregator
            io.netty.channel.Channel r4 = r16.channel()
            io.netty.util.concurrent.EventExecutor r5 = r16.executor()
            r6 = r21
            r3.<init>(r6, r4, r5)
            io.netty.handler.codec.http2.DefaultHttp2FrameWriter$DataFrameHeader r4 = new io.netty.handler.codec.http2.DefaultHttp2FrameWriter$DataFrameHeader
            r4.<init>(r0, r2)
            r5 = 1
            java.lang.String r6 = "Stream ID"
            verifyStreamId(r2, r6)     // Catch: java.lang.Throwable -> La0
            io.netty.handler.codec.http2.Http2CodecUtil.verifyPadding(r19)     // Catch: java.lang.Throwable -> La0
            int r2 = r18.readableBytes()     // Catch: java.lang.Throwable -> La0
            r6 = r2
            r7 = 1
            r8 = 1
            r2 = r19
        L2b:
            int r9 = r1.maxFrameSize     // Catch: java.lang.Throwable -> L9b
            int r9 = java.lang.Math.min(r6, r9)     // Catch: java.lang.Throwable -> L9b
            int r10 = r1.maxFrameSize     // Catch: java.lang.Throwable -> L9b
            int r10 = r10 - r5
            int r10 = r10 - r9
            r11 = 0
            int r10 = java.lang.Math.max(r11, r10)     // Catch: java.lang.Throwable -> L9b
            int r10 = java.lang.Math.min(r2, r10)     // Catch: java.lang.Throwable -> L9b
            int r2 = r2 - r10
            int r6 = r6 - r9
            if (r6 != 0) goto L46
            if (r2 != 0) goto L46
            r12 = 1
            goto L47
        L46:
            r12 = 0
        L47:
            if (r12 == 0) goto L4d
            if (r20 == 0) goto L4d
            r13 = 1
            goto L4e
        L4d:
            r13 = 0
        L4e:
            io.netty.buffer.ByteBuf r7 = r4.slice(r9, r10, r13)     // Catch: java.lang.Throwable -> L9b
            r13 = r12 ^ 1
            if (r12 == 0) goto L57
            goto L5b
        L57:
            io.netty.buffer.ByteBuf r7 = r7.retain()     // Catch: java.lang.Throwable -> L96
        L5b:
            io.netty.channel.ChannelPromise r14 = r3.newPromise()     // Catch: java.lang.Throwable -> L96
            r0.write(r7, r14)     // Catch: java.lang.Throwable -> L96
            r14 = r18
            io.netty.buffer.ByteBuf r7 = r14.readSlice(r9)     // Catch: java.lang.Throwable -> L94
            r8 = r12 ^ 1
            if (r12 == 0) goto L6d
            goto L71
        L6d:
            io.netty.buffer.ByteBuf r7 = r7.retain()     // Catch: java.lang.Throwable -> L94
        L71:
            io.netty.channel.ChannelPromise r9 = r3.newPromise()     // Catch: java.lang.Throwable -> L94
            r0.write(r7, r9)     // Catch: java.lang.Throwable -> L94
            int r7 = paddingBytes(r10)     // Catch: java.lang.Throwable -> L94
            if (r7 <= 0) goto L8f
            io.netty.buffer.ByteBuf r7 = io.netty.handler.codec.http2.DefaultHttp2FrameWriter.ZERO_BUFFER     // Catch: java.lang.Throwable -> L94
            int r9 = paddingBytes(r10)     // Catch: java.lang.Throwable -> L94
            io.netty.buffer.ByteBuf r7 = r7.slice(r11, r9)     // Catch: java.lang.Throwable -> L94
            io.netty.channel.ChannelPromise r9 = r3.newPromise()     // Catch: java.lang.Throwable -> L94
            r0.write(r7, r9)     // Catch: java.lang.Throwable -> L94
        L8f:
            if (r12 == 0) goto L92
            goto Lb1
        L92:
            r7 = r13
            goto L2b
        L94:
            r0 = move-exception
            goto L99
        L96:
            r0 = move-exception
            r14 = r18
        L99:
            r5 = r13
            goto La4
        L9b:
            r0 = move-exception
            r14 = r18
            r5 = r7
            goto La4
        La0:
            r0 = move-exception
            r14 = r18
            r8 = 1
        La4:
            if (r5 == 0) goto La9
            r4.release()
        La9:
            if (r8 == 0) goto Lae
            r18.release()
        Lae:
            r3.setFailure(r0)
        Lb1:
            io.netty.channel.ChannelPromise r0 = r3.doneAllocatingPromises()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.DefaultHttp2FrameWriter.writeData(io.netty.channel.ChannelHandlerContext, int, io.netty.buffer.ByteBuf, int, boolean, io.netty.channel.ChannelPromise):io.netty.channel.ChannelFuture");
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeFrame(ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf, ChannelPromise channelPromise) {
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        boolean z = true;
        try {
            verifyStreamOrConnectionId(i, STREAM_ID);
            ByteBuf buffer = channelHandlerContext.alloc().buffer(9);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, byteBuf.readableBytes(), b, http2Flags, i);
            channelHandlerContext.write(buffer, simpleChannelPromiseAggregator.newPromise());
            z = false;
            channelHandlerContext.write(byteBuf, simpleChannelPromiseAggregator.newPromise());
        } catch (Throwable th) {
            if (z) {
                byteBuf.release();
            }
            simpleChannelPromiseAggregator.setFailure(th);
        }
        return simpleChannelPromiseAggregator.doneAllocatingPromises();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeGoAway(ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf, ChannelPromise channelPromise) {
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        boolean z = false;
        try {
            verifyStreamOrConnectionId(i, "Last Stream ID");
            verifyErrorCode(j);
            ByteBuf buffer = channelHandlerContext.alloc().buffer(17);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, byteBuf.readableBytes() + 8, (byte) 7, new Http2Flags(), 0);
            buffer.writeInt(i);
            Http2CodecUtil.writeUnsignedInt(j, buffer);
            channelHandlerContext.write(buffer, simpleChannelPromiseAggregator.newPromise());
        } catch (Throwable th) {
            th = th;
            z = true;
        }
        try {
            channelHandlerContext.write(byteBuf, simpleChannelPromiseAggregator.newPromise());
        } catch (Throwable th2) {
            th = th2;
            if (z) {
                byteBuf.release();
            }
            simpleChannelPromiseAggregator.setFailure(th);
            return simpleChannelPromiseAggregator.doneAllocatingPromises();
        }
        return simpleChannelPromiseAggregator.doneAllocatingPromises();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z, ChannelPromise channelPromise) {
        return writeHeadersInternal(channelHandlerContext, i, http2Headers, i2, z, false, 0, (short) 0, false, channelPromise);
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePing(ChannelHandlerContext channelHandlerContext, boolean z, ByteBuf byteBuf, ChannelPromise channelPromise) {
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        boolean z2 = false;
        try {
            verifyPingPayload(byteBuf);
            Http2Flags ack = z ? new Http2Flags().ack(true) : new Http2Flags();
            ByteBuf buffer = channelHandlerContext.alloc().buffer(9);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, byteBuf.readableBytes(), (byte) 6, ack, 0);
            channelHandlerContext.write(buffer, simpleChannelPromiseAggregator.newPromise());
        } catch (Throwable th) {
            th = th;
            z2 = true;
        }
        try {
            channelHandlerContext.write(byteBuf, simpleChannelPromiseAggregator.newPromise());
        } catch (Throwable th2) {
            th = th2;
            if (z2) {
                byteBuf.release();
            }
            simpleChannelPromiseAggregator.setFailure(th);
            return simpleChannelPromiseAggregator.doneAllocatingPromises();
        }
        return simpleChannelPromiseAggregator.doneAllocatingPromises();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePriority(ChannelHandlerContext channelHandlerContext, int i, int i2, short s, boolean z, ChannelPromise channelPromise) {
        try {
            verifyStreamId(i, STREAM_ID);
            verifyStreamId(i2, STREAM_DEPENDENCY);
            verifyWeight(s);
            ByteBuf buffer = channelHandlerContext.alloc().buffer(14);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, 5, (byte) 2, new Http2Flags(), i);
            Http2CodecUtil.writeUnsignedInt(z ? i2 | IjkMediaMeta.AV_CH_WIDE_LEFT : i2, buffer);
            buffer.writeByte(s - 1);
            return channelHandlerContext.write(buffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writePushPromise(ChannelHandlerContext channelHandlerContext, int i, int i2, Http2Headers http2Headers, int i3, ChannelPromise channelPromise) {
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        ByteBuf byteBuf = null;
        try {
            verifyStreamId(i, STREAM_ID);
            verifyStreamId(i2, "Promised Stream ID");
            Http2CodecUtil.verifyPadding(i3);
            byteBuf = channelHandlerContext.alloc().buffer();
            this.headersEncoder.encodeHeaders(http2Headers, byteBuf);
            boolean z = true;
            Http2Flags paddingPresent = new Http2Flags().paddingPresent(i3 > 0);
            int i4 = i3 + 4;
            ByteBuf readRetainedSlice = byteBuf.readRetainedSlice(Math.min(byteBuf.readableBytes(), this.maxFrameSize - i4));
            if (byteBuf.isReadable()) {
                z = false;
            }
            paddingPresent.endOfHeaders(z);
            int readableBytes = readRetainedSlice.readableBytes() + i4;
            ByteBuf buffer = channelHandlerContext.alloc().buffer(14);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, readableBytes, (byte) 5, paddingPresent, i);
            writePaddingLength(buffer, i3);
            buffer.writeInt(i2);
            channelHandlerContext.write(buffer, simpleChannelPromiseAggregator.newPromise());
            channelHandlerContext.write(readRetainedSlice, simpleChannelPromiseAggregator.newPromise());
            if (paddingBytes(i3) > 0) {
                channelHandlerContext.write(ZERO_BUFFER.slice(0, paddingBytes(i3)), simpleChannelPromiseAggregator.newPromise());
            }
            if (!paddingPresent.endOfHeaders()) {
                writeContinuationFrames(channelHandlerContext, i, byteBuf, i3, simpleChannelPromiseAggregator);
            }
        } catch (Throwable th) {
            try {
                simpleChannelPromiseAggregator.setFailure(th);
            } finally {
                if (byteBuf != null) {
                    byteBuf.release();
                }
            }
        }
        return simpleChannelPromiseAggregator.doneAllocatingPromises();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeRstStream(ChannelHandlerContext channelHandlerContext, int i, long j, ChannelPromise channelPromise) {
        try {
            verifyStreamId(i, STREAM_ID);
            verifyErrorCode(j);
            ByteBuf buffer = channelHandlerContext.alloc().buffer(13);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, 4, (byte) 3, new Http2Flags(), i);
            Http2CodecUtil.writeUnsignedInt(j, buffer);
            return channelHandlerContext.write(buffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettings(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings, ChannelPromise channelPromise) {
        try {
            ObjectUtil.checkNotNull(http2Settings, "settings");
            ByteBuf buffer = channelHandlerContext.alloc().buffer((http2Settings.size() * 6) + 9);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, http2Settings.size() * 6, (byte) 4, new Http2Flags(), 0);
            for (CharObjectMap.PrimitiveEntry<Long> primitiveEntry : http2Settings.entries()) {
                Http2CodecUtil.writeUnsignedShort(primitiveEntry.key(), buffer);
                Http2CodecUtil.writeUnsignedInt(primitiveEntry.value().longValue(), buffer);
            }
            return channelHandlerContext.write(buffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeSettingsAck(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        try {
            ByteBuf buffer = channelHandlerContext.alloc().buffer(9);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, 0, (byte) 4, new Http2Flags().ack(true), 0);
            return channelHandlerContext.write(buffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeWindowUpdate(ChannelHandlerContext channelHandlerContext, int i, int i2, ChannelPromise channelPromise) {
        try {
            verifyStreamOrConnectionId(i, STREAM_ID);
            verifyWindowSizeIncrement(i2);
            ByteBuf buffer = channelHandlerContext.alloc().buffer(13);
            Http2CodecUtil.writeFrameHeaderInternal(buffer, 4, (byte) 8, new Http2Flags(), i);
            buffer.writeInt(i2);
            return channelHandlerContext.write(buffer, channelPromise);
        } catch (Throwable th) {
            return channelPromise.setFailure(th);
        }
    }

    public DefaultHttp2FrameWriter(Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        this(new DefaultHttp2HeadersEncoder(4096, sensitivityDetector));
    }

    @Override // io.netty.handler.codec.http2.Http2FrameWriter
    public ChannelFuture writeHeaders(ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i3, boolean z2, ChannelPromise channelPromise) {
        return writeHeadersInternal(channelHandlerContext, i, http2Headers, i3, z2, true, i2, s, z, channelPromise);
    }

    public DefaultHttp2FrameWriter(Http2HeadersEncoder http2HeadersEncoder) {
        this.headersEncoder = http2HeadersEncoder;
        this.maxFrameSize = 16384;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameSizePolicy
    public int maxFrameSize() {
        return this.maxFrameSize;
    }
}
