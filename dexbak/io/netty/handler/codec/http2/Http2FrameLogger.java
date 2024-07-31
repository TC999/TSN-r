package io.netty.handler.codec.http2;

import com.baidu.mobads.sdk.internal.C2634bs;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.logging.LogLevel;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogLevel;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import kotlin.UByte;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Http2FrameLogger extends ChannelHandlerAdapter {
    private static final int BUFFER_LENGTH_THRESHOLD = 64;
    private final InternalLogLevel level;
    private final InternalLogger logger;

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum Direction {
        INBOUND,
        OUTBOUND
    }

    public Http2FrameLogger(LogLevel logLevel) {
        this(logLevel.toInternalLevel(), InternalLoggerFactory.getInstance(Http2FrameLogger.class));
    }

    private boolean enabled() {
        return this.logger.isEnabled(this.level);
    }

    private void log(Direction direction, String str, Object... objArr) {
        StringBuilder sb = new StringBuilder(200);
        sb.append("\n----------------");
        sb.append(direction.name());
        sb.append("--------------------\n");
        sb.append(String.format(str, objArr));
        sb.append("\n------------------------------------");
        this.logger.log(this.level, sb.toString());
    }

    private String toString(ByteBuf byteBuf) {
        if (this.level != InternalLogLevel.TRACE && byteBuf.readableBytes() > 64) {
            int min = Math.min(byteBuf.readableBytes(), 64);
            return ByteBufUtil.hexDump(byteBuf, byteBuf.readerIndex(), min) + "...";
        }
        return ByteBufUtil.hexDump(byteBuf);
    }

    public void logData(Direction direction, ChannelHandlerContext channelHandlerContext, int i, ByteBuf byteBuf, int i2, boolean z) {
        if (enabled()) {
            log(direction, "%s DATA: streamId=%d, padding=%d, endStream=%b, length=%d, bytes=%s", channelHandlerContext.channel(), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(byteBuf.readableBytes()), toString(byteBuf));
        }
    }

    public void logGoAway(Direction direction, ChannelHandlerContext channelHandlerContext, int i, long j, ByteBuf byteBuf) {
        if (enabled()) {
            log(direction, "%s GO_AWAY: lastStreamId=%d, errorCode=%d, length=%d, bytes=%s", channelHandlerContext.channel(), Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(byteBuf.readableBytes()), toString(byteBuf));
        }
    }

    public void logHeaders(Direction direction, ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, boolean z) {
        if (enabled()) {
            log(direction, "%s HEADERS: streamId=%d, headers=%s, padding=%d, endStream=%b", channelHandlerContext.channel(), Integer.valueOf(i), http2Headers, Integer.valueOf(i2), Boolean.valueOf(z));
        }
    }

    public void logPing(Direction direction, ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        if (enabled()) {
            log(direction, "%s PING: ack=false, length=%d, bytes=%s", channelHandlerContext.channel(), Integer.valueOf(byteBuf.readableBytes()), toString(byteBuf));
        }
    }

    public void logPingAck(Direction direction, ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        if (enabled()) {
            log(direction, "%s PING: ack=true, length=%d, bytes=%s", channelHandlerContext.channel(), Integer.valueOf(byteBuf.readableBytes()), toString(byteBuf));
        }
    }

    public void logPriority(Direction direction, ChannelHandlerContext channelHandlerContext, int i, int i2, short s, boolean z) {
        if (enabled()) {
            log(direction, "%s PRIORITY: streamId=%d, streamDependency=%d, weight=%d, exclusive=%b", channelHandlerContext.channel(), Integer.valueOf(i), Integer.valueOf(i2), Short.valueOf(s), Boolean.valueOf(z));
        }
    }

    public void logPushPromise(Direction direction, ChannelHandlerContext channelHandlerContext, int i, int i2, Http2Headers http2Headers, int i3) {
        if (enabled()) {
            log(direction, "%s PUSH_PROMISE: streamId=%d, promisedStreamId=%d, headers=%s, padding=%d", channelHandlerContext.channel(), Integer.valueOf(i), Integer.valueOf(i2), http2Headers, Integer.valueOf(i3));
        }
    }

    public void logRstStream(Direction direction, ChannelHandlerContext channelHandlerContext, int i, long j) {
        if (enabled()) {
            log(direction, "%s RST_STREAM: streamId=%d, errorCode=%d", channelHandlerContext.channel(), Integer.valueOf(i), Long.valueOf(j));
        }
    }

    public void logSettings(Direction direction, ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) {
        if (enabled()) {
            log(direction, "%s SETTINGS: ack=false, settings=%s", channelHandlerContext.channel(), http2Settings);
        }
    }

    public void logSettingsAck(Direction direction, ChannelHandlerContext channelHandlerContext) {
        if (enabled()) {
            log(direction, "%s SETTINGS: ack=true", channelHandlerContext.channel());
        }
    }

    public void logUnknownFrame(Direction direction, ChannelHandlerContext channelHandlerContext, byte b, int i, Http2Flags http2Flags, ByteBuf byteBuf) {
        if (enabled()) {
            log(direction, "%s UNKNOWN: frameType=%d, streamId=%d, flags=%d, length=%d, bytes=%s", channelHandlerContext.channel(), Integer.valueOf(b & UByte.f41242c), Integer.valueOf(i), Short.valueOf(http2Flags.value()), Integer.valueOf(byteBuf.readableBytes()), toString(byteBuf));
        }
    }

    public void logWindowsUpdate(Direction direction, ChannelHandlerContext channelHandlerContext, int i, int i2) {
        if (enabled()) {
            log(direction, "%s WINDOW_UPDATE: streamId=%d, windowSizeIncrement=%d", channelHandlerContext.channel(), Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    public Http2FrameLogger(LogLevel logLevel, String str) {
        this(logLevel.toInternalLevel(), InternalLoggerFactory.getInstance(str));
    }

    public Http2FrameLogger(LogLevel logLevel, Class<?> cls) {
        this(logLevel.toInternalLevel(), InternalLoggerFactory.getInstance(cls));
    }

    public void logHeaders(Direction direction, ChannelHandlerContext channelHandlerContext, int i, Http2Headers http2Headers, int i2, short s, boolean z, int i3, boolean z2) {
        if (enabled()) {
            log(direction, "%s HEADERS: streamId=%d, headers=%s, streamDependency=%d, weight=%d, exclusive=%b, padding=%d, endStream=%b", channelHandlerContext.channel(), Integer.valueOf(i), http2Headers, Integer.valueOf(i2), Short.valueOf(s), Boolean.valueOf(z), Integer.valueOf(i3), Boolean.valueOf(z2));
        }
    }

    private Http2FrameLogger(InternalLogLevel internalLogLevel, InternalLogger internalLogger) {
        this.level = (InternalLogLevel) ObjectUtil.checkNotNull(internalLogLevel, "level");
        this.logger = (InternalLogger) ObjectUtil.checkNotNull(internalLogger, C2634bs.f8731a);
    }
}
