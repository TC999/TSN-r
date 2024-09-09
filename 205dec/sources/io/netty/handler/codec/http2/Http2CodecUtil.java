package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.handler.codec.http2.StreamByteDistributor;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutor;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class Http2CodecUtil {
    public static final int CONNECTION_STREAM_ID = 0;
    public static final int CONTINUATION_FRAME_HEADER_LENGTH = 10;
    public static final int DATA_FRAME_HEADER_LENGTH = 10;
    public static final boolean DEFAULT_ENABLE_PUSH = true;
    public static final int DEFAULT_HEADER_TABLE_SIZE = 4096;
    public static final int DEFAULT_MAX_FRAME_SIZE = 16384;
    public static final int DEFAULT_MAX_HEADER_SIZE = 8192;
    public static final short DEFAULT_PRIORITY_WEIGHT = 16;
    public static final int DEFAULT_WINDOW_SIZE = 65535;
    public static final int FRAME_HEADER_LENGTH = 9;
    public static final int GO_AWAY_FRAME_HEADER_LENGTH = 17;
    public static final int HEADERS_FRAME_HEADER_LENGTH = 15;
    public static final int HTTP_UPGRADE_STREAM_ID = 1;
    public static final int INT_FIELD_LENGTH = 4;
    public static final long MAX_CONCURRENT_STREAMS = 4294967295L;
    public static final int MAX_FRAME_SIZE_LOWER_BOUND = 16384;
    public static final int MAX_FRAME_SIZE_UPPER_BOUND = 16777215;
    public static final long MAX_HEADER_LIST_SIZE = Long.MAX_VALUE;
    public static final int MAX_HEADER_TABLE_SIZE = Integer.MAX_VALUE;
    public static final int MAX_INITIAL_WINDOW_SIZE = Integer.MAX_VALUE;
    public static final int MAX_PADDING = 256;
    private static final int MAX_PADDING_LENGTH_LENGTH = 1;
    public static final short MAX_UNSIGNED_BYTE = 255;
    public static final long MAX_UNSIGNED_INT = 4294967295L;
    public static final int MAX_UNSIGNED_SHORT = 65535;
    public static final short MAX_WEIGHT = 256;
    public static final long MIN_CONCURRENT_STREAMS = 0;
    public static final long MIN_HEADER_LIST_SIZE = 0;
    public static final long MIN_HEADER_TABLE_SIZE = 0;
    public static final int MIN_INITIAL_WINDOW_SIZE = 0;
    public static final short MIN_WEIGHT = 1;
    public static final int NUM_STANDARD_SETTINGS = 6;
    public static final int PING_FRAME_PAYLOAD_LENGTH = 8;
    public static final int PRIORITY_ENTRY_LENGTH = 5;
    public static final int PRIORITY_FRAME_LENGTH = 14;
    public static final int PUSH_PROMISE_FRAME_HEADER_LENGTH = 14;
    public static final int RST_STREAM_FRAME_LENGTH = 13;
    public static final char SETTINGS_ENABLE_PUSH = 2;
    public static final char SETTINGS_HEADER_TABLE_SIZE = 1;
    public static final char SETTINGS_INITIAL_WINDOW_SIZE = 4;
    public static final char SETTINGS_MAX_CONCURRENT_STREAMS = 3;
    public static final char SETTINGS_MAX_FRAME_SIZE = 5;
    public static final char SETTINGS_MAX_HEADER_LIST_SIZE = 6;
    public static final int SETTING_ENTRY_LENGTH = 6;
    public static final int SMALLEST_MAX_CONCURRENT_STREAMS = 100;
    public static final int WINDOW_UPDATE_FRAME_LENGTH = 13;
    public static final CharSequence HTTP_UPGRADE_SETTINGS_HEADER = new AsciiString("HTTP2-Settings");
    public static final CharSequence HTTP_UPGRADE_PROTOCOL_NAME = "h2c";
    public static final CharSequence TLS_UPGRADE_PROTOCOL_NAME = "h2";
    private static final ByteBuf CONNECTION_PREFACE = Unpooled.unreleasableBuffer(Unpooled.directBuffer(24).writeBytes("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n".getBytes(CharsetUtil.UTF_8))).asReadOnly();
    private static final ByteBuf EMPTY_PING = Unpooled.unreleasableBuffer(Unpooled.directBuffer(8).writeZero(8)).asReadOnly();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static final class SimpleChannelPromiseAggregator extends DefaultChannelPromise {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean doneAllocating;
        private int doneCount;
        private int expectedCount;
        private Throwable lastFailure;
        private final ChannelPromise promise;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SimpleChannelPromiseAggregator(ChannelPromise channelPromise, Channel channel, EventExecutor eventExecutor) {
            super(channel, eventExecutor);
            this.promise = channelPromise;
        }

        private boolean allPromisesDone() {
            return this.doneCount == this.expectedCount && this.doneAllocating;
        }

        private boolean allowFailure() {
            return awaitingPromises() || this.expectedCount == 0;
        }

        private boolean awaitingPromises() {
            return this.doneCount < this.expectedCount;
        }

        private ChannelPromise setPromise() {
            Throwable th = this.lastFailure;
            if (th == null) {
                this.promise.setSuccess();
                return super.setSuccess((Void) null);
            }
            this.promise.setFailure(th);
            return super.setFailure(this.lastFailure);
        }

        private boolean tryPromise() {
            Throwable th = this.lastFailure;
            if (th == null) {
                this.promise.trySuccess();
                return super.trySuccess((SimpleChannelPromiseAggregator) null);
            }
            this.promise.tryFailure(th);
            return super.tryFailure(this.lastFailure);
        }

        public ChannelPromise doneAllocatingPromises() {
            if (!this.doneAllocating) {
                this.doneAllocating = true;
                int i4 = this.doneCount;
                int i5 = this.expectedCount;
                if (i4 == i5 || i5 == 0) {
                    return setPromise();
                }
            }
            return this;
        }

        public ChannelPromise newPromise() {
            this.expectedCount++;
            return this;
        }

        @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
        public boolean tryFailure(Throwable th) {
            if (allowFailure()) {
                this.doneCount++;
                this.lastFailure = th;
                if (allPromisesDone()) {
                    return tryPromise();
                }
                return true;
            }
            return false;
        }

        @Override // io.netty.channel.DefaultChannelPromise, io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.channel.ChannelPromise
        public ChannelPromise setFailure(Throwable th) {
            if (allowFailure()) {
                this.doneCount++;
                this.lastFailure = th;
                if (allPromisesDone()) {
                    return setPromise();
                }
            }
            return this;
        }

        @Override // io.netty.channel.DefaultChannelPromise, io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise, io.netty.util.concurrent.ProgressivePromise
        public ChannelPromise setSuccess(Void r12) {
            if (awaitingPromises()) {
                this.doneCount++;
                if (allPromisesDone()) {
                    setPromise();
                }
            }
            return this;
        }

        @Override // io.netty.util.concurrent.DefaultPromise, io.netty.util.concurrent.Promise
        public boolean trySuccess(Void r22) {
            if (awaitingPromises()) {
                this.doneCount++;
                if (allPromisesDone()) {
                    return tryPromise();
                }
                return true;
            }
            return false;
        }
    }

    private Http2CodecUtil() {
    }

    public static ByteBuf connectionPrefaceBuf() {
        return CONNECTION_PREFACE.retainedDuplicate();
    }

    public static ByteBuf emptyPingBuf() {
        return EMPTY_PING.retainedDuplicate();
    }

    public static Http2Exception getEmbeddedHttp2Exception(Throwable th) {
        while (th != null) {
            if (th instanceof Http2Exception) {
                return (Http2Exception) th;
            }
            th = th.getCause();
        }
        return null;
    }

    public static boolean isMaxFrameSizeValid(int i4) {
        return i4 >= 16384 && i4 <= 16777215;
    }

    public static int readUnsignedInt(ByteBuf byteBuf) {
        return (byteBuf.readByte() & 255) | ((byteBuf.readByte() & Byte.MAX_VALUE) << 24) | ((byteBuf.readByte() & 255) << 16) | ((byteBuf.readByte() & 255) << 8);
    }

    public static int streamableBytes(StreamByteDistributor.StreamState streamState) {
        return Math.max(0, Math.min(streamState.pendingBytes(), streamState.windowSize()));
    }

    public static ByteBuf toByteBuf(ChannelHandlerContext channelHandlerContext, Throwable th) {
        if (th != null && th.getMessage() != null) {
            return ByteBufUtil.writeUtf8(channelHandlerContext.alloc(), th.getMessage());
        }
        return Unpooled.EMPTY_BUFFER;
    }

    public static void verifyPadding(int i4) {
        if (i4 < 0 || i4 > 256) {
            throw new IllegalArgumentException(String.format("Invalid padding '%d'. Padding must be between 0 and %d (inclusive).", Integer.valueOf(i4), 256));
        }
    }

    public static void writeFrameHeader(ByteBuf byteBuf, int i4, byte b4, Http2Flags http2Flags, int i5) {
        byteBuf.ensureWritable(i4 + 9);
        writeFrameHeaderInternal(byteBuf, i4, b4, http2Flags, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeFrameHeaderInternal(ByteBuf byteBuf, int i4, byte b4, Http2Flags http2Flags, int i5) {
        byteBuf.writeMedium(i4);
        byteBuf.writeByte(b4);
        byteBuf.writeByte(http2Flags.value());
        byteBuf.writeInt(i5);
    }

    public static void writeUnsignedInt(long j4, ByteBuf byteBuf) {
        byteBuf.writeByte((int) ((j4 >> 24) & 255));
        byteBuf.writeByte((int) ((j4 >> 16) & 255));
        byteBuf.writeByte((int) ((j4 >> 8) & 255));
        byteBuf.writeByte((int) (j4 & 255));
    }

    public static void writeUnsignedShort(int i4, ByteBuf byteBuf) {
        byteBuf.writeByte((i4 >> 8) & 255);
        byteBuf.writeByte(i4 & 255);
    }
}
