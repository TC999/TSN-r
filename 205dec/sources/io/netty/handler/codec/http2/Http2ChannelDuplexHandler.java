package io.netty.handler.codec.http2;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.StringUtil;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public abstract class Http2ChannelDuplexHandler extends ChannelDuplexHandler {
    private volatile Http2FrameCodec frameCodec;

    private static Http2FrameCodec requireHttp2FrameCodec(ChannelHandlerContext channelHandlerContext) {
        ChannelHandlerContext context = channelHandlerContext.pipeline().context(Http2FrameCodec.class);
        if (context == null) {
            throw new IllegalArgumentException(Http2FrameCodec.class.getSimpleName() + " was not found in the channel pipeline.");
        }
        return (Http2FrameCodec) context.handler();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void forEachActiveStream(Http2FrameStreamVisitor http2FrameStreamVisitor) throws Http2Exception {
        this.frameCodec.forEachActiveStream(http2FrameStreamVisitor);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public final void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.frameCodec = requireHttp2FrameCodec(channelHandlerContext);
        handlerAdded0(channelHandlerContext);
    }

    protected void handlerAdded0(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public final void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            handlerRemoved0(channelHandlerContext);
        } finally {
            this.frameCodec = null;
        }
    }

    protected void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    public final Http2FrameStream newStream() {
        Http2FrameCodec http2FrameCodec = this.frameCodec;
        if (http2FrameCodec != null) {
            return http2FrameCodec.newStream();
        }
        throw new IllegalStateException(StringUtil.simpleClassName((Class<?>) Http2FrameCodec.class) + " not found. Has the handler been added to a pipeline?");
    }
}
