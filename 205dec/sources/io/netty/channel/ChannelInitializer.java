package io.netty.channel;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.concurrent.ConcurrentMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
@ChannelHandler.Sharable
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class ChannelInitializer<C extends Channel> extends ChannelInboundHandlerAdapter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ChannelInitializer.class);
    private final ConcurrentMap<ChannelHandlerContext, Boolean> initMap = PlatformDependent.newConcurrentHashMap();

    /* renamed from: io.netty.channel.ChannelInitializer$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ChannelHandlerContext val$ctx;

        AnonymousClass1(ChannelHandlerContext channelHandlerContext) {
            this.val$ctx = channelHandlerContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChannelInitializer.access$000(ChannelInitializer.this).remove(this.val$ctx);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean initChannel(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.initMap.putIfAbsent(channelHandlerContext, Boolean.TRUE) == null) {
            try {
                initChannel((ChannelInitializer<C>) channelHandlerContext.channel());
            } finally {
                try {
                    return true;
                } finally {
                }
            }
            return true;
        }
        return false;
    }

    private void remove(ChannelHandlerContext channelHandlerContext) {
        try {
            ChannelPipeline pipeline = channelHandlerContext.pipeline();
            if (pipeline.context(this) != null) {
                pipeline.remove(this);
            }
        } finally {
            this.initMap.remove(channelHandlerContext);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (initChannel(channelHandlerContext)) {
            channelHandlerContext.pipeline().fireChannelRegistered();
        } else {
            channelHandlerContext.fireChannelRegistered();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
        InternalLogger internalLogger = logger;
        internalLogger.warn("Failed to initialize a channel. Closing: " + channelHandlerContext.channel(), th);
        channelHandlerContext.close();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContext.channel().isRegistered()) {
            initChannel(channelHandlerContext);
        }
    }

    protected abstract void initChannel(C c4) throws Exception;
}
