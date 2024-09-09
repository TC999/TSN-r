package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.internal.ObjectUtil;

@Deprecated
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class Http2MultiplexCodecBuilder extends AbstractHttp2ConnectionHandlerBuilder<Http2MultiplexCodec, Http2MultiplexCodecBuilder> {
    final ChannelHandler childHandler;
    private Http2FrameWriter frameWriter;
    private ChannelHandler upgradeStreamHandler;

    Http2MultiplexCodecBuilder(boolean z3, ChannelHandler channelHandler) {
        server(z3);
        this.childHandler = checkSharable((ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "childHandler"));
        gracefulShutdownTimeoutMillis(0L);
    }

    private static ChannelHandler checkSharable(ChannelHandler channelHandler) {
        if (!(channelHandler instanceof ChannelHandlerAdapter) || ((ChannelHandlerAdapter) channelHandler).isSharable() || channelHandler.getClass().isAnnotationPresent(ChannelHandler.Sharable.class)) {
            return channelHandler;
        }
        throw new IllegalArgumentException("The handler must be Sharable");
    }

    public static Http2MultiplexCodecBuilder forClient(ChannelHandler channelHandler) {
        return new Http2MultiplexCodecBuilder(false, channelHandler);
    }

    public static Http2MultiplexCodecBuilder forServer(ChannelHandler channelHandler) {
        return new Http2MultiplexCodecBuilder(true, channelHandler);
    }

    Http2MultiplexCodecBuilder frameWriter(Http2FrameWriter http2FrameWriter) {
        this.frameWriter = (Http2FrameWriter) ObjectUtil.checkNotNull(http2FrameWriter, "frameWriter");
        return this;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public boolean isServer() {
        return super.isServer();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public boolean isValidateHeaders() {
        return super.isValidateHeaders();
    }

    public Http2MultiplexCodecBuilder withUpgradeStreamHandler(ChannelHandler channelHandler) {
        if (!isServer()) {
            this.upgradeStreamHandler = channelHandler;
            return this;
        }
        throw new IllegalArgumentException("Server codecs don't use an extra handler for the upgrade stream");
    }

    public Http2MultiplexCodecBuilder autoAckPingFrame(boolean z3) {
        return (Http2MultiplexCodecBuilder) super.autoAckPingFrame(z3);
    }

    public Http2MultiplexCodecBuilder autoAckSettingsFrame(boolean z3) {
        return (Http2MultiplexCodecBuilder) super.autoAckSettingsFrame(z3);
    }

    public Http2MultiplexCodecBuilder decoupleCloseAndGoAway(boolean z3) {
        return (Http2MultiplexCodecBuilder) super.decoupleCloseAndGoAway(z3);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public boolean encoderEnforceMaxConcurrentStreams() {
        return super.encoderEnforceMaxConcurrentStreams();
    }

    public Http2MultiplexCodecBuilder encoderIgnoreMaxHeaderListSize(boolean z3) {
        return (Http2MultiplexCodecBuilder) super.encoderIgnoreMaxHeaderListSize(z3);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2FrameLogger frameLogger() {
        return super.frameLogger();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public long gracefulShutdownTimeoutMillis() {
        return super.gracefulShutdownTimeoutMillis();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2HeadersEncoder.SensitivityDetector headerSensitivityDetector() {
        return super.headerSensitivityDetector();
    }

    @Deprecated
    public Http2MultiplexCodecBuilder initialHuffmanDecodeCapacity(int i4) {
        return (Http2MultiplexCodecBuilder) super.initialHuffmanDecodeCapacity(i4);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2Settings initialSettings() {
        return super.initialSettings();
    }

    public int maxReservedStreams() {
        return super.maxReservedStreams();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodecBuilder validateHeaders(boolean z3) {
        return (Http2MultiplexCodecBuilder) super.validateHeaders(z3);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodec build() {
        Http2FrameReader http2FrameReader;
        Http2FrameWriter http2FrameWriter = this.frameWriter;
        if (http2FrameWriter != null) {
            DefaultHttp2Connection defaultHttp2Connection = new DefaultHttp2Connection(isServer(), maxReservedStreams());
            Long maxHeaderListSize = initialSettings().maxHeaderListSize();
            Http2FrameReader defaultHttp2FrameReader = new DefaultHttp2FrameReader(maxHeaderListSize == null ? new DefaultHttp2HeadersDecoder(true) : new DefaultHttp2HeadersDecoder(true, maxHeaderListSize.longValue()));
            if (frameLogger() != null) {
                Http2OutboundFrameLogger http2OutboundFrameLogger = new Http2OutboundFrameLogger(http2FrameWriter, frameLogger());
                http2FrameReader = new Http2InboundFrameLogger(defaultHttp2FrameReader, frameLogger());
                http2FrameWriter = http2OutboundFrameLogger;
            } else {
                http2FrameReader = defaultHttp2FrameReader;
            }
            DefaultHttp2ConnectionEncoder defaultHttp2ConnectionEncoder = new DefaultHttp2ConnectionEncoder(defaultHttp2Connection, http2FrameWriter);
            Http2ConnectionEncoder streamBufferingEncoder = encoderEnforceMaxConcurrentStreams() ? new StreamBufferingEncoder(defaultHttp2ConnectionEncoder) : defaultHttp2ConnectionEncoder;
            return build((Http2ConnectionDecoder) new DefaultHttp2ConnectionDecoder(defaultHttp2Connection, streamBufferingEncoder, http2FrameReader, promisedRequestVerifier(), isAutoAckSettingsFrame(), isAutoAckPingFrame()), streamBufferingEncoder, initialSettings());
        }
        return (Http2MultiplexCodec) super.build();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodecBuilder encoderEnforceMaxConcurrentStreams(boolean z3) {
        return (Http2MultiplexCodecBuilder) super.encoderEnforceMaxConcurrentStreams(z3);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodecBuilder frameLogger(Http2FrameLogger http2FrameLogger) {
        return (Http2MultiplexCodecBuilder) super.frameLogger(http2FrameLogger);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodecBuilder gracefulShutdownTimeoutMillis(long j4) {
        return (Http2MultiplexCodecBuilder) super.gracefulShutdownTimeoutMillis(j4);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodecBuilder headerSensitivityDetector(Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        return (Http2MultiplexCodecBuilder) super.headerSensitivityDetector(sensitivityDetector);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodecBuilder initialSettings(Http2Settings http2Settings) {
        return (Http2MultiplexCodecBuilder) super.initialSettings(http2Settings);
    }

    public Http2MultiplexCodecBuilder maxReservedStreams(int i4) {
        return (Http2MultiplexCodecBuilder) super.maxReservedStreams(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r7v0, types: [io.netty.handler.codec.http2.Http2MultiplexCodec, io.netty.handler.codec.http2.Http2ConnectionHandler] */
    @Override // io.netty.handler.codec.http2.AbstractHttp2ConnectionHandlerBuilder
    public Http2MultiplexCodec build(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings) {
        ?? http2MultiplexCodec = new Http2MultiplexCodec(http2ConnectionEncoder, http2ConnectionDecoder, http2Settings, this.childHandler, this.upgradeStreamHandler, decoupleCloseAndGoAway());
        http2MultiplexCodec.gracefulShutdownTimeoutMillis(gracefulShutdownTimeoutMillis());
        return http2MultiplexCodec;
    }
}
