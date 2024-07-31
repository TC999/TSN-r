package io.netty.handler.codec.http2;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoopGroup;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class Http2Codec extends ChannelDuplexHandler {
    private final Http2FrameCodec frameCodec;
    private final Http2MultiplexCodec multiplexCodec;

    public Http2Codec(boolean z, ChannelHandler channelHandler) {
        this(z, channelHandler, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2FrameCodec frameCodec() {
        return this.frameCodec;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.pipeline().addBefore(channelHandlerContext.executor(), channelHandlerContext.name(), null, this.frameCodec);
        channelHandlerContext.pipeline().addBefore(channelHandlerContext.executor(), channelHandlerContext.name(), null, this.multiplexCodec);
        channelHandlerContext.pipeline().remove(this);
    }

    public Http2Codec(boolean z, ChannelHandler channelHandler, EventLoopGroup eventLoopGroup) {
        this(z, channelHandler, eventLoopGroup, new DefaultHttp2FrameWriter());
    }

    Http2Codec(boolean z, ChannelHandler channelHandler, EventLoopGroup eventLoopGroup, Http2FrameWriter http2FrameWriter) {
        this.frameCodec = new Http2FrameCodec(z, http2FrameWriter);
        this.multiplexCodec = new Http2MultiplexCodec(z, eventLoopGroup, channelHandler);
    }
}
