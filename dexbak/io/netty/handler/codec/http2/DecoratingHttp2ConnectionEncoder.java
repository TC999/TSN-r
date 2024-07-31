package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DecoratingHttp2ConnectionEncoder extends DecoratingHttp2FrameWriter implements Http2ConnectionEncoder {
    private final Http2ConnectionEncoder delegate;

    public DecoratingHttp2ConnectionEncoder(Http2ConnectionEncoder http2ConnectionEncoder) {
        super(http2ConnectionEncoder);
        this.delegate = (Http2ConnectionEncoder) ObjectUtil.checkNotNull(http2ConnectionEncoder, "delegate");
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public Http2Connection connection() {
        return this.delegate.connection();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public Http2RemoteFlowController flowController() {
        return this.delegate.flowController();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public Http2FrameWriter frameWriter() {
        return this.delegate.frameWriter();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public void lifecycleManager(Http2LifecycleManager http2LifecycleManager) {
        this.delegate.lifecycleManager(http2LifecycleManager);
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public Http2Settings pollSentSettings() {
        return this.delegate.pollSentSettings();
    }

    @Override // io.netty.handler.codec.http2.Http2ConnectionEncoder
    public void remoteSettings(Http2Settings http2Settings) throws Http2Exception {
        this.delegate.remoteSettings(http2Settings);
    }
}
