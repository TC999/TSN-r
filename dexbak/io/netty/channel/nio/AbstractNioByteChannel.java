package io.netty.channel.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractNioByteChannel extends AbstractNioChannel {
    private Runnable flushTask;
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) FileRegion.class) + ')';

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class NioByteUnsafe extends AbstractNioChannel.AbstractNioUnsafe {
        /* JADX INFO: Access modifiers changed from: protected */
        public NioByteUnsafe() {
            super();
        }

        private void closeOnRead(ChannelPipeline channelPipeline) {
            if (AbstractNioByteChannel.this.isOpen()) {
                if (Boolean.TRUE.equals(AbstractNioByteChannel.this.config().getOption(ChannelOption.ALLOW_HALF_CLOSURE))) {
                    AbstractNioByteChannel.this.shutdownInput();
                    SelectionKey selectionKey = AbstractNioByteChannel.this.selectionKey();
                    selectionKey.interestOps(selectionKey.interestOps() & (AbstractNioByteChannel.this.readInterestOp ^ (-1)));
                    channelPipeline.fireUserEventTriggered((Object) ChannelInputShutdownEvent.INSTANCE);
                    return;
                }
                close(voidPromise());
            }
        }

        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z, RecvByteBufAllocator.Handle handle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    AbstractNioByteChannel.this.readPending = false;
                    channelPipeline.fireChannelRead((Object) byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            handle.readComplete();
            channelPipeline.fireChannelReadComplete();
            channelPipeline.fireExceptionCaught(th);
            if (z || (th instanceof IOException)) {
                closeOnRead(channelPipeline);
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(8:1|(13:2|3|4|5|6|(4:44|45|46|(1:48))(2:8|9)|11|12|(1:14)|16|(1:23)|20|21)|11|12|(0)|16|(2:18|23)(1:24)|(1:(0))) */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
            r5 = r1;
            r6 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
            handleReadException(r3, r4, r5, r6, r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0080, code lost:
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0085, code lost:
            if (r9.this$0.readPending == false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x008d, code lost:
            removeReadOp();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0091, code lost:
            throw r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
            return;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0050 A[Catch: all -> 0x0060, TRY_LEAVE, TryCatch #1 {all -> 0x0060, blocks: (B:14:0x0048, B:16:0x0050), top: B:47:0x0048 }] */
        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void read() {
            /*
                r9 = this;
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                io.netty.channel.ChannelConfig r0 = r0.config()
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this
                io.netty.channel.ChannelPipeline r3 = r1.pipeline()
                io.netty.buffer.ByteBufAllocator r1 = r0.getAllocator()
                io.netty.channel.RecvByteBufAllocator$Handle r7 = r9.recvBufAllocHandle()
                r7.reset(r0)
            L17:
                r2 = 0
                r4 = 0
                io.netty.buffer.ByteBuf r5 = r7.allocate(r1)     // Catch: java.lang.Throwable -> L69
                io.netty.channel.nio.AbstractNioByteChannel r6 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch: java.lang.Throwable -> L64
                int r6 = r6.doReadBytes(r5)     // Catch: java.lang.Throwable -> L64
                r7.lastBytesRead(r6)     // Catch: java.lang.Throwable -> L64
                int r6 = r7.lastBytesRead()     // Catch: java.lang.Throwable -> L64
                r8 = 1
                if (r6 > 0) goto L38
                r5.release()     // Catch: java.lang.Throwable -> L64
                int r1 = r7.lastBytesRead()     // Catch: java.lang.Throwable -> L69
                if (r1 >= 0) goto L48
                r2 = 1
                goto L48
            L38:
                r7.incMessagesRead(r8)     // Catch: java.lang.Throwable -> L64
                io.netty.channel.nio.AbstractNioByteChannel r6 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch: java.lang.Throwable -> L64
                r6.readPending = r2     // Catch: java.lang.Throwable -> L64
                r3.fireChannelRead(r5)     // Catch: java.lang.Throwable -> L64
                boolean r5 = r7.continueReading()     // Catch: java.lang.Throwable -> L69
                if (r5 != 0) goto L17
            L48:
                r7.readComplete()     // Catch: java.lang.Throwable -> L60
                r3.fireChannelReadComplete()     // Catch: java.lang.Throwable -> L60
                if (r2 == 0) goto L53
                r9.closeOnRead(r3)     // Catch: java.lang.Throwable -> L60
            L53:
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r1 = r1.readPending
                if (r1 != 0) goto L7f
                boolean r0 = r0.isAutoRead()
                if (r0 != 0) goto L7f
                goto L7c
            L60:
                r1 = move-exception
                r5 = r1
                r6 = r2
                goto L6c
            L64:
                r1 = move-exception
                r4 = r5
                r6 = 0
                r5 = r1
                goto L6c
            L69:
                r1 = move-exception
                r5 = r1
                r6 = 0
            L6c:
                r2 = r9
                r2.handleReadException(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L80
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r1 = r1.readPending
                if (r1 != 0) goto L7f
                boolean r0 = r0.isAutoRead()
                if (r0 != 0) goto L7f
            L7c:
                r9.removeReadOp()
            L7f:
                return
            L80:
                r1 = move-exception
                io.netty.channel.nio.AbstractNioByteChannel r2 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r2 = r2.readPending
                if (r2 != 0) goto L90
                boolean r0 = r0.isAutoRead()
                if (r0 != 0) goto L90
                r9.removeReadOp()
            L90:
                goto L92
            L91:
                throw r1
            L92:
                goto L91
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.nio.AbstractNioByteChannel.NioByteUnsafe.read():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractNioByteChannel(Channel channel, SelectableChannel selectableChannel) {
        super(channel, selectableChannel, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void clearOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (selectionKey.isValid()) {
            int interestOps = selectionKey.interestOps();
            if ((interestOps & 4) != 0) {
                selectionKey.interestOps(interestOps & (-5));
            }
        }
    }

    protected abstract int doReadBytes(ByteBuf byteBuf) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009f, code lost:
        incompleteWrite(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a2, code lost:
        return;
     */
    @Override // io.netty.channel.AbstractChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void doWrite(io.netty.channel.ChannelOutboundBuffer r20) throws java.lang.Exception {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = 0
            r3 = -1
            r4 = -1
            r5 = 0
        L8:
            java.lang.Object r6 = r20.current()
            if (r6 != 0) goto L12
            r19.clearOpWrite()
            return
        L12:
            boolean r7 = r6 instanceof io.netty.buffer.ByteBuf
            r8 = 0
            r10 = 1
            if (r7 == 0) goto L51
            io.netty.buffer.ByteBuf r6 = (io.netty.buffer.ByteBuf) r6
            int r7 = r6.readableBytes()
            if (r7 != 0) goto L25
            r20.remove()
            goto L8
        L25:
            if (r4 != r3) goto L2f
            io.netty.channel.ChannelConfig r4 = r19.config()
            int r4 = r4.getWriteSpinCount()
        L2f:
            int r7 = r4 + (-1)
        L31:
            if (r7 < 0) goto L47
            int r11 = r0.doWriteBytes(r6)
            if (r11 != 0) goto L3b
            r5 = 1
            goto L47
        L3b:
            long r11 = (long) r11
            long r8 = r8 + r11
            boolean r11 = r6.isReadable()
            if (r11 != 0) goto L44
            goto L48
        L44:
            int r7 = r7 + (-1)
            goto L31
        L47:
            r10 = 0
        L48:
            r1.progress(r8)
            if (r10 == 0) goto L9f
            r20.remove()
            goto L8
        L51:
            boolean r7 = r6 instanceof io.netty.channel.FileRegion
            if (r7 == 0) goto La3
            io.netty.channel.FileRegion r6 = (io.netty.channel.FileRegion) r6
            long r11 = r6.transferred()
            long r13 = r6.count()
            int r7 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r7 < 0) goto L65
            r7 = 1
            goto L66
        L65:
            r7 = 0
        L66:
            if (r7 != 0) goto L98
            if (r4 != r3) goto L72
            io.netty.channel.ChannelConfig r4 = r19.config()
            int r4 = r4.getWriteSpinCount()
        L72:
            int r11 = r4 + (-1)
            r12 = r8
        L75:
            if (r11 < 0) goto L93
            long r14 = r0.doWriteFileRegion(r6)
            int r16 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r16 != 0) goto L82
            r10 = r7
            r5 = 1
            goto L94
        L82:
            long r12 = r12 + r14
            long r14 = r6.transferred()
            long r16 = r6.count()
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 < 0) goto L90
            goto L94
        L90:
            int r11 = r11 + (-1)
            goto L75
        L93:
            r10 = r7
        L94:
            r1.progress(r12)
            r7 = r10
        L98:
            if (r7 == 0) goto L9f
            r20.remove()
            goto L8
        L9f:
            r0.incompleteWrite(r5)
            return
        La3:
            java.lang.Error r1 = new java.lang.Error
            r1.<init>()
            goto Laa
        La9:
            throw r1
        Laa:
            goto La9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.nio.AbstractNioByteChannel.doWrite(io.netty.channel.ChannelOutboundBuffer):void");
    }

    protected abstract int doWriteBytes(ByteBuf byteBuf) throws Exception;

    protected abstract long doWriteFileRegion(FileRegion fileRegion) throws Exception;

    @Override // io.netty.channel.AbstractChannel
    protected final Object filterOutboundMessage(Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return byteBuf.isDirect() ? obj : newDirectBuffer(byteBuf);
        } else if (obj instanceof FileRegion) {
            return obj;
        } else {
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void incompleteWrite(boolean z) {
        if (z) {
            setOpWrite();
            return;
        }
        Runnable runnable = this.flushTask;
        if (runnable == null) {
            runnable = new Runnable() { // from class: io.netty.channel.nio.AbstractNioByteChannel.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractNioByteChannel.this.flush();
                }
            };
            this.flushTask = runnable;
        }
        eventLoop().execute(runnable);
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    protected final void setOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (selectionKey.isValid()) {
            int interestOps = selectionKey.interestOps();
            if ((interestOps & 4) == 0) {
                selectionKey.interestOps(interestOps | 4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ChannelFuture shutdownInput();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioByteUnsafe();
    }
}
