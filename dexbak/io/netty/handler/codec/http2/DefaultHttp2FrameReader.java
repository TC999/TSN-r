package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2FrameReader;
import io.netty.util.internal.PlatformDependent;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DefaultHttp2FrameReader implements Http2FrameReader, Http2FrameSizePolicy, Http2FrameReader.Configuration {
    private Http2Flags flags;
    private byte frameType;
    private HeadersContinuation headersContinuation;
    private final Http2HeadersDecoder headersDecoder;
    private int maxFrameSize;
    private int payloadLength;
    private boolean readError;
    private boolean readingHeaders;
    private int streamId;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class HeadersBlockBuilder {
        private ByteBuf headerBlock;

        protected HeadersBlockBuilder() {
        }

        private void headerSizeExceeded() throws Http2Exception {
            close();
            throw Http2Exception.connectionError(Http2Error.ENHANCE_YOUR_CALM, "Header size exceeded max allowed size (%d)", Integer.valueOf(DefaultHttp2FrameReader.this.headersDecoder.configuration().maxHeaderSize()));
        }

        final void addFragment(ByteBuf byteBuf, ByteBufAllocator byteBufAllocator, boolean z) throws Http2Exception {
            if (this.headerBlock == null) {
                if (byteBuf.readableBytes() > DefaultHttp2FrameReader.this.headersDecoder.configuration().maxHeaderSize()) {
                    headerSizeExceeded();
                }
                if (z) {
                    this.headerBlock = byteBuf.retain();
                    return;
                }
                ByteBuf buffer = byteBufAllocator.buffer(byteBuf.readableBytes());
                this.headerBlock = buffer;
                buffer.writeBytes(byteBuf);
                return;
            }
            if (DefaultHttp2FrameReader.this.headersDecoder.configuration().maxHeaderSize() - byteBuf.readableBytes() < this.headerBlock.readableBytes()) {
                headerSizeExceeded();
            }
            if (this.headerBlock.isWritable(byteBuf.readableBytes())) {
                this.headerBlock.writeBytes(byteBuf);
                return;
            }
            ByteBuf buffer2 = byteBufAllocator.buffer(this.headerBlock.readableBytes() + byteBuf.readableBytes());
            buffer2.writeBytes(this.headerBlock);
            buffer2.writeBytes(byteBuf);
            this.headerBlock.release();
            this.headerBlock = buffer2;
        }

        void close() {
            ByteBuf byteBuf = this.headerBlock;
            if (byteBuf != null) {
                byteBuf.release();
                this.headerBlock = null;
            }
            DefaultHttp2FrameReader.this.headersContinuation = null;
        }

        Http2Headers headers() throws Http2Exception {
            try {
                return DefaultHttp2FrameReader.this.headersDecoder.decodeHeaders(this.headerBlock);
            } finally {
                close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public abstract class HeadersContinuation {
        private final HeadersBlockBuilder builder;

        private HeadersContinuation() {
            this.builder = new HeadersBlockBuilder();
        }

        final void close() {
            this.builder.close();
        }

        abstract int getStreamId();

        final HeadersBlockBuilder headersBlockBuilder() {
            return this.builder;
        }

        abstract void processFragment(boolean z, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception;
    }

    public DefaultHttp2FrameReader() {
        this(true);
    }

    private static int lengthWithoutTrailingPadding(int i, int i2) {
        return i2 == 0 ? i : i - (i2 - 1);
    }

    private void processHeaderState(ByteBuf byteBuf) throws Http2Exception {
        if (byteBuf.readableBytes() < 9) {
            return;
        }
        int readUnsignedMedium = byteBuf.readUnsignedMedium();
        this.payloadLength = readUnsignedMedium;
        if (readUnsignedMedium > this.maxFrameSize) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Frame length: %d exceeds maximum: %d", Integer.valueOf(readUnsignedMedium), Integer.valueOf(this.maxFrameSize));
        }
        this.frameType = byteBuf.readByte();
        this.flags = new Http2Flags(byteBuf.readUnsignedByte());
        this.streamId = Http2CodecUtil.readUnsignedInt(byteBuf);
        this.readingHeaders = false;
        switch (this.frameType) {
            case 0:
                verifyDataFrame();
                return;
            case 1:
                verifyHeadersFrame();
                return;
            case 2:
                verifyPriorityFrame();
                return;
            case 3:
                verifyRstStreamFrame();
                return;
            case 4:
                verifySettingsFrame();
                return;
            case 5:
                verifyPushPromiseFrame();
                return;
            case 6:
                verifyPingFrame();
                return;
            case 7:
                verifyGoAwayFrame();
                return;
            case 8:
                verifyWindowUpdateFrame();
                return;
            case 9:
                verifyContinuationFrame();
                return;
            default:
                return;
        }
    }

    private void processPayloadState(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        int readableBytes = byteBuf.readableBytes();
        int i = this.payloadLength;
        if (readableBytes < i) {
            return;
        }
        ByteBuf readSlice = byteBuf.readSlice(i);
        this.readingHeaders = true;
        switch (this.frameType) {
            case 0:
                readDataFrame(channelHandlerContext, readSlice, http2FrameListener);
                return;
            case 1:
                readHeadersFrame(channelHandlerContext, readSlice, http2FrameListener);
                return;
            case 2:
                readPriorityFrame(channelHandlerContext, readSlice, http2FrameListener);
                return;
            case 3:
                readRstStreamFrame(channelHandlerContext, readSlice, http2FrameListener);
                return;
            case 4:
                readSettingsFrame(channelHandlerContext, readSlice, http2FrameListener);
                return;
            case 5:
                readPushPromiseFrame(channelHandlerContext, readSlice, http2FrameListener);
                return;
            case 6:
                readPingFrame(channelHandlerContext, readSlice, http2FrameListener);
                return;
            case 7:
                readGoAwayFrame(channelHandlerContext, readSlice, http2FrameListener);
                return;
            case 8:
                readWindowUpdateFrame(channelHandlerContext, readSlice, http2FrameListener);
                return;
            case 9:
                readContinuationFrame(readSlice, http2FrameListener);
                return;
            default:
                readUnknownFrame(channelHandlerContext, readSlice, http2FrameListener);
                return;
        }
    }

    private void readContinuationFrame(ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        this.headersContinuation.processFragment(this.flags.endOfHeaders(), byteBuf.readSlice(byteBuf.readableBytes()), http2FrameListener);
    }

    private void readDataFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        int readPadding = readPadding(byteBuf);
        int lengthWithoutTrailingPadding = lengthWithoutTrailingPadding(byteBuf.readableBytes(), readPadding);
        if (lengthWithoutTrailingPadding >= 0) {
            http2FrameListener.onDataRead(channelHandlerContext, this.streamId, byteBuf.readSlice(lengthWithoutTrailingPadding), readPadding, this.flags.endOfStream());
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame payload too small for padding.", new Object[0]);
    }

    private static void readGoAwayFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        http2FrameListener.onGoAwayRead(channelHandlerContext, Http2CodecUtil.readUnsignedInt(byteBuf), byteBuf.readUnsignedInt(), byteBuf.readSlice(byteBuf.readableBytes()));
    }

    private void readHeadersFrame(final ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        final int i = this.streamId;
        final Http2Flags http2Flags = this.flags;
        final int readPadding = readPadding(byteBuf);
        if (this.flags.priorityPresent()) {
            long readUnsignedInt = byteBuf.readUnsignedInt();
            final boolean z = (IjkMediaMeta.AV_CH_WIDE_LEFT & readUnsignedInt) != 0;
            final int i2 = (int) (readUnsignedInt & 2147483647L);
            final short readUnsignedByte = (short) (byteBuf.readUnsignedByte() + 1);
            ByteBuf readSlice = byteBuf.readSlice(lengthWithoutTrailingPadding(byteBuf.readableBytes(), readPadding));
            HeadersContinuation headersContinuation = new HeadersContinuation() { // from class: io.netty.handler.codec.http2.DefaultHttp2FrameReader.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
                public int getStreamId() {
                    return i;
                }

                @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
                public void processFragment(boolean z2, ByteBuf byteBuf2, Http2FrameListener http2FrameListener2) throws Http2Exception {
                    HeadersBlockBuilder headersBlockBuilder = headersBlockBuilder();
                    headersBlockBuilder.addFragment(byteBuf2, channelHandlerContext.alloc(), z2);
                    if (z2) {
                        http2FrameListener2.onHeadersRead(channelHandlerContext, i, headersBlockBuilder.headers(), i2, readUnsignedByte, z, readPadding, http2Flags.endOfStream());
                    }
                }
            };
            this.headersContinuation = headersContinuation;
            headersContinuation.processFragment(this.flags.endOfHeaders(), readSlice, http2FrameListener);
            return;
        }
        this.headersContinuation = new HeadersContinuation() { // from class: io.netty.handler.codec.http2.DefaultHttp2FrameReader.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
            public int getStreamId() {
                return i;
            }

            @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
            public void processFragment(boolean z2, ByteBuf byteBuf2, Http2FrameListener http2FrameListener2) throws Http2Exception {
                HeadersBlockBuilder headersBlockBuilder = headersBlockBuilder();
                headersBlockBuilder.addFragment(byteBuf2, channelHandlerContext.alloc(), z2);
                if (z2) {
                    http2FrameListener2.onHeadersRead(channelHandlerContext, i, headersBlockBuilder.headers(), readPadding, http2Flags.endOfStream());
                }
            }
        };
        this.headersContinuation.processFragment(this.flags.endOfHeaders(), byteBuf.readSlice(lengthWithoutTrailingPadding(byteBuf.readableBytes(), readPadding)), http2FrameListener);
    }

    private int readPadding(ByteBuf byteBuf) {
        if (this.flags.paddingPresent()) {
            return byteBuf.readUnsignedByte() + 1;
        }
        return 0;
    }

    private void readPingFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        ByteBuf readSlice = byteBuf.readSlice(byteBuf.readableBytes());
        if (this.flags.ack()) {
            http2FrameListener.onPingAckRead(channelHandlerContext, readSlice);
        } else {
            http2FrameListener.onPingRead(channelHandlerContext, readSlice);
        }
    }

    private void readPriorityFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        long readUnsignedInt = byteBuf.readUnsignedInt();
        http2FrameListener.onPriorityRead(channelHandlerContext, this.streamId, (int) (readUnsignedInt & 2147483647L), (short) (byteBuf.readUnsignedByte() + 1), (IjkMediaMeta.AV_CH_WIDE_LEFT & readUnsignedInt) != 0);
    }

    private void readPushPromiseFrame(final ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        final int i = this.streamId;
        final int readPadding = readPadding(byteBuf);
        final int readUnsignedInt = Http2CodecUtil.readUnsignedInt(byteBuf);
        this.headersContinuation = new HeadersContinuation() { // from class: io.netty.handler.codec.http2.DefaultHttp2FrameReader.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
            public int getStreamId() {
                return i;
            }

            @Override // io.netty.handler.codec.http2.DefaultHttp2FrameReader.HeadersContinuation
            public void processFragment(boolean z, ByteBuf byteBuf2, Http2FrameListener http2FrameListener2) throws Http2Exception {
                headersBlockBuilder().addFragment(byteBuf2, channelHandlerContext.alloc(), z);
                if (z) {
                    http2FrameListener2.onPushPromiseRead(channelHandlerContext, i, readUnsignedInt, headersBlockBuilder().headers(), readPadding);
                }
            }
        };
        this.headersContinuation.processFragment(this.flags.endOfHeaders(), byteBuf.readSlice(lengthWithoutTrailingPadding(byteBuf.readableBytes(), readPadding)), http2FrameListener);
    }

    private void readRstStreamFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        http2FrameListener.onRstStreamRead(channelHandlerContext, this.streamId, byteBuf.readUnsignedInt());
    }

    private void readSettingsFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        if (this.flags.ack()) {
            http2FrameListener.onSettingsAckRead(channelHandlerContext);
            return;
        }
        int i = this.payloadLength / 6;
        Http2Settings http2Settings = new Http2Settings();
        for (int i2 = 0; i2 < i; i2++) {
            char readUnsignedShort = (char) byteBuf.readUnsignedShort();
            try {
                http2Settings.put(readUnsignedShort, Long.valueOf(byteBuf.readUnsignedInt()));
            } catch (IllegalArgumentException e) {
                if (readUnsignedShort == 4) {
                    throw Http2Exception.connectionError(Http2Error.FLOW_CONTROL_ERROR, e, e.getMessage(), new Object[0]);
                }
                if (readUnsignedShort != 5) {
                    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, e, e.getMessage(), new Object[0]);
                }
                throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, e, e.getMessage(), new Object[0]);
            }
        }
        http2FrameListener.onSettingsRead(channelHandlerContext, http2Settings);
    }

    private void readUnknownFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        http2FrameListener.onUnknownFrame(channelHandlerContext, this.frameType, this.streamId, this.flags, byteBuf.readSlice(byteBuf.readableBytes()));
    }

    private void readWindowUpdateFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        int readUnsignedInt = Http2CodecUtil.readUnsignedInt(byteBuf);
        if (readUnsignedInt != 0) {
            http2FrameListener.onWindowUpdateRead(channelHandlerContext, this.streamId, readUnsignedInt);
        } else {
            int i = this.streamId;
            throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, "Received WINDOW_UPDATE with delta 0 for stream: %d", Integer.valueOf(i));
        }
    }

    private void verifyContinuationFrame() throws Http2Exception {
        verifyPayloadLength(this.payloadLength);
        HeadersContinuation headersContinuation = this.headersContinuation;
        if (headersContinuation == null) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Received %s frame but not currently processing headers.", Byte.valueOf(this.frameType));
        }
        if (this.streamId != headersContinuation.getStreamId()) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Continuation stream ID does not match pending headers. Expected %d, but received %d.", Integer.valueOf(this.headersContinuation.getStreamId()), Integer.valueOf(this.streamId));
        }
        if (this.payloadLength < this.flags.getPaddingPresenceFieldLength()) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small for padding.", Integer.valueOf(this.payloadLength));
        }
    }

    private void verifyDataFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        verifyPayloadLength(this.payloadLength);
        if (this.payloadLength < this.flags.getPaddingPresenceFieldLength()) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small.", Integer.valueOf(this.payloadLength));
        }
    }

    private void verifyGoAwayFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        verifyPayloadLength(this.payloadLength);
        if (this.streamId == 0) {
            int i = this.payloadLength;
            if (i < 8) {
                throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small.", Integer.valueOf(i));
            }
            return;
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A stream ID must be zero.", new Object[0]);
    }

    private void verifyHeadersFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        verifyPayloadLength(this.payloadLength);
        if (this.payloadLength >= this.flags.getPaddingPresenceFieldLength() + this.flags.getNumPriorityBytes()) {
            return;
        }
        int i = this.streamId;
        Http2Error http2Error = Http2Error.FRAME_SIZE_ERROR;
        throw Http2Exception.streamError(i, http2Error, "Frame length too small." + this.payloadLength, new Object[0]);
    }

    private void verifyNotProcessingHeaders() throws Http2Exception {
        if (this.headersContinuation != null) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Received frame of type %s while processing headers.", Byte.valueOf(this.frameType));
        }
    }

    private void verifyPayloadLength(int i) throws Http2Exception {
        if (i > this.maxFrameSize) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Total payload length %d exceeds max frame length.", Integer.valueOf(i));
        }
    }

    private void verifyPingFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        if (this.streamId == 0) {
            int i = this.payloadLength;
            if (i != 8) {
                throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length %d incorrect size for ping.", Integer.valueOf(i));
            }
            return;
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A stream ID must be zero.", new Object[0]);
    }

    private void verifyPriorityFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        int i = this.payloadLength;
        if (i != 5) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Invalid frame length %d.", Integer.valueOf(i));
        }
    }

    private void verifyPushPromiseFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        verifyPayloadLength(this.payloadLength);
        int paddingPresenceFieldLength = this.flags.getPaddingPresenceFieldLength() + 4;
        int i = this.payloadLength;
        if (i < paddingPresenceFieldLength) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small.", Integer.valueOf(i));
        }
    }

    private void verifyRstStreamFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        int i = this.payloadLength;
        if (i != 4) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Invalid frame length %d.", Integer.valueOf(i));
        }
    }

    private void verifySettingsFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        verifyPayloadLength(this.payloadLength);
        if (this.streamId == 0) {
            if (this.flags.ack() && this.payloadLength > 0) {
                throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Ack settings frame must have an empty payload.", new Object[0]);
            }
            int i = this.payloadLength;
            if (i % 6 > 0) {
                throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length %d invalid.", Integer.valueOf(i));
            }
            return;
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A stream ID must be zero.", new Object[0]);
    }

    private static void verifyStreamOrConnectionId(int i, String str) throws Http2Exception {
        if (i < 0) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "%s must be >= 0", str);
        }
    }

    private void verifyWindowUpdateFrame() throws Http2Exception {
        verifyNotProcessingHeaders();
        verifyStreamOrConnectionId(this.streamId, "Stream ID");
        int i = this.payloadLength;
        if (i != 4) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Invalid frame length %d.", Integer.valueOf(i));
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        HeadersContinuation headersContinuation = this.headersContinuation;
        if (headersContinuation != null) {
            headersContinuation.close();
        }
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader
    public Http2FrameReader.Configuration configuration() {
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader.Configuration
    public Http2FrameSizePolicy frameSizePolicy() {
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader.Configuration
    public Http2HeaderTable headerTable() {
        return this.headersDecoder.configuration().headerTable();
    }

    @Override // io.netty.handler.codec.http2.Http2FrameSizePolicy
    public void maxFrameSize(int i) throws Http2Exception {
        if (!Http2CodecUtil.isMaxFrameSizeValid(i)) {
            throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Invalid MAX_FRAME_SIZE specified in sent settings: %d", Integer.valueOf(i));
        }
        this.maxFrameSize = i;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameReader
    public void readFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, Http2FrameListener http2FrameListener) throws Http2Exception {
        if (this.readError) {
            byteBuf.skipBytes(byteBuf.readableBytes());
            return;
        }
        do {
            try {
                if (this.readingHeaders) {
                    processHeaderState(byteBuf);
                    if (this.readingHeaders) {
                        return;
                    }
                }
                processPayloadState(channelHandlerContext, byteBuf, http2FrameListener);
                if (!this.readingHeaders) {
                    return;
                }
            } catch (Http2Exception e) {
                this.readError = !Http2Exception.isStreamError(e);
                throw e;
            } catch (RuntimeException e2) {
                this.readError = true;
                throw e2;
            } catch (Throwable th) {
                this.readError = true;
                PlatformDependent.throwException(th);
                return;
            }
        } while (byteBuf.isReadable());
    }

    public DefaultHttp2FrameReader(boolean z) {
        this(new DefaultHttp2HeadersDecoder(z));
    }

    public DefaultHttp2FrameReader(Http2HeadersDecoder http2HeadersDecoder) {
        this.readingHeaders = true;
        this.headersDecoder = http2HeadersDecoder;
        this.maxFrameSize = 16384;
    }

    @Override // io.netty.handler.codec.http2.Http2FrameSizePolicy
    public int maxFrameSize() {
        return this.maxFrameSize;
    }
}
