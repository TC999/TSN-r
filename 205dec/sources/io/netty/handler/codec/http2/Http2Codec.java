package io.netty.handler.codec.http2;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoopGroup;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class Http2Codec extends ChannelDuplexHandler {
    private final Http2FrameCodec frameCodec;
    private final Http2MultiplexCodec multiplexCodec;

    public Http2Codec(boolean z3, ChannelHandler channelHandler) {
        this(z3, channelHandler, null);
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

    public Http2Codec(boolean z3, ChannelHandler channelHandler, EventLoopGroup eventLoopGroup) {
        this(z3, channelHandler, eventLoopGroup, new DefaultHttp2FrameWriter());
    }

    Http2Codec(boolean z3, ChannelHandler channelHandler, EventLoopGroup eventLoopGroup, Http2FrameWriter http2FrameWriter) {
        this.frameCodec = new Http2FrameCodec(z3, http2FrameWriter);
        this.multiplexCodec = new Http2MultiplexCodec(z3, eventLoopGroup, channelHandler);
    }
}
