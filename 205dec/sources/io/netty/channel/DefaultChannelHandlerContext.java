package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class DefaultChannelHandlerContext extends AbstractChannelHandlerContext {
    private final ChannelHandler handler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultChannelHandlerContext(DefaultChannelPipeline defaultChannelPipeline, EventExecutor eventExecutor, String str, ChannelHandler channelHandler) {
        super(defaultChannelPipeline, eventExecutor, str, isInbound(channelHandler), isOutbound(channelHandler));
        if (channelHandler != null) {
            this.handler = channelHandler;
            return;
        }
        throw new NullPointerException("handler");
    }

    private static boolean isInbound(ChannelHandler channelHandler) {
        return channelHandler instanceof ChannelInboundHandler;
    }

    private static boolean isOutbound(ChannelHandler channelHandler) {
        return channelHandler instanceof ChannelOutboundHandler;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandler handler() {
        return this.handler;
    }
}
