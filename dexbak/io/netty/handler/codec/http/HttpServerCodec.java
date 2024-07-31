package io.netty.handler.codec.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.CombinedChannelDuplexHandler;
import io.netty.handler.codec.http.HttpServerUpgradeHandler;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class HttpServerCodec extends CombinedChannelDuplexHandler<HttpRequestDecoder, HttpResponseEncoder> implements HttpServerUpgradeHandler.SourceCodec {
    public HttpServerCodec() {
        this(4096, 8192, 8192);
    }

    @Override // io.netty.handler.codec.http.HttpServerUpgradeHandler.SourceCodec
    public void upgradeFrom(ChannelHandlerContext channelHandlerContext) {
        channelHandlerContext.pipeline().remove(this);
    }

    public HttpServerCodec(int i, int i2, int i3) {
        super(new HttpRequestDecoder(i, i2, i3), new HttpResponseEncoder());
    }

    public HttpServerCodec(int i, int i2, int i3, boolean z) {
        super(new HttpRequestDecoder(i, i2, i3, z), new HttpResponseEncoder());
    }

    public HttpServerCodec(int i, int i2, int i3, boolean z, int i4) {
        super(new HttpRequestDecoder(i, i2, i3, z, i4), new HttpResponseEncoder());
    }
}
