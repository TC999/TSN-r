package io.netty.handler.codec.http2;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.channels.ClosedChannelException;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class Http2StreamChannelBootstrap {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(Http2StreamChannelBootstrap.class);
    private final Channel channel;
    private volatile ChannelHandler handler;
    private volatile ChannelHandlerContext multiplexCtx;
    private final Map<ChannelOption<?>, Object> options = new LinkedHashMap();
    private final Map<AttributeKey<?>, Object> attrs = new LinkedHashMap();

    public Http2StreamChannelBootstrap(Channel channel) {
        this.channel = (Channel) ObjectUtil.checkNotNull(channel, "channel");
    }

    private ChannelHandlerContext findCtx() throws ClosedChannelException {
        ChannelHandlerContext channelHandlerContext = this.multiplexCtx;
        if (channelHandlerContext == null || channelHandlerContext.isRemoved()) {
            ChannelPipeline pipeline = this.channel.pipeline();
            ChannelHandlerContext context = pipeline.context(Http2MultiplexCodec.class);
            if (context == null) {
                context = pipeline.context(Http2MultiplexHandler.class);
            }
            if (context == null) {
                if (this.channel.isActive()) {
                    throw new IllegalStateException(StringUtil.simpleClassName((Class<?>) Http2MultiplexCodec.class) + " or " + StringUtil.simpleClassName((Class<?>) Http2MultiplexHandler.class) + " must be in the ChannelPipeline of Channel " + this.channel);
                }
                throw new ClosedChannelException();
            }
            this.multiplexCtx = context;
            return context;
        }
        return channelHandlerContext;
    }

    private void init(Channel channel) {
        ChannelPipeline pipeline = channel.pipeline();
        ChannelHandler channelHandler = this.handler;
        if (channelHandler != null) {
            pipeline.addLast(channelHandler);
        }
        synchronized (this.options) {
            setChannelOptions(channel, this.options);
        }
        synchronized (this.attrs) {
            for (Map.Entry<AttributeKey<?>, Object> entry : this.attrs.entrySet()) {
                channel.attr(entry.getKey()).set(entry.getValue());
            }
        }
    }

    private static void setChannelOption(Channel channel, ChannelOption<?> channelOption, Object obj) {
        try {
            if (channel.config().setOption(channelOption, obj)) {
                return;
            }
            logger.warn("Unknown channel option '{}' for channel '{}'", channelOption, channel);
        } catch (Throwable th) {
            logger.warn("Failed to set channel option '{}' with value '{}' for channel '{}'", channelOption, obj, channel, th);
        }
    }

    private static void setChannelOptions(Channel channel, Map<ChannelOption<?>, Object> map) {
        for (Map.Entry<ChannelOption<?>, Object> entry : map.entrySet()) {
            setChannelOption(channel, entry.getKey(), entry.getValue());
        }
    }

    public <T> Http2StreamChannelBootstrap attr(AttributeKey<T> attributeKey, T t3) {
        if (attributeKey != null) {
            if (t3 == null) {
                synchronized (this.attrs) {
                    this.attrs.remove(attributeKey);
                }
            } else {
                synchronized (this.attrs) {
                    this.attrs.put(attributeKey, t3);
                }
            }
            return this;
        }
        throw new NullPointerException(DomainCampaignEx.LOOPBACK_KEY);
    }

    public Http2StreamChannelBootstrap handler(ChannelHandler channelHandler) {
        this.handler = (ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "handler");
        return this;
    }

    public Future<Http2StreamChannel> open() {
        return open(this.channel.eventLoop().newPromise());
    }

    @Deprecated
    public void open0(ChannelHandlerContext channelHandlerContext, final Promise<Http2StreamChannel> promise) {
        final Http2StreamChannel newOutboundStream;
        if (channelHandlerContext.handler() instanceof Http2MultiplexCodec) {
            newOutboundStream = ((Http2MultiplexCodec) channelHandlerContext.handler()).newOutboundStream();
        } else {
            newOutboundStream = ((Http2MultiplexHandler) channelHandlerContext.handler()).newOutboundStream();
        }
        try {
            init(newOutboundStream);
            channelHandlerContext.channel().eventLoop().register(newOutboundStream).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http2.Http2StreamChannelBootstrap.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) {
                    if (channelFuture.isSuccess()) {
                        promise.setSuccess(newOutboundStream);
                    } else if (channelFuture.isCancelled()) {
                        promise.cancel(false);
                    } else {
                        if (newOutboundStream.isRegistered()) {
                            newOutboundStream.close();
                        } else {
                            newOutboundStream.unsafe().closeForcibly();
                        }
                        promise.setFailure(channelFuture.cause());
                    }
                }
            });
        } catch (Exception e4) {
            newOutboundStream.unsafe().closeForcibly();
            promise.setFailure(e4);
        }
    }

    public <T> Http2StreamChannelBootstrap option(ChannelOption<T> channelOption, T t3) {
        if (channelOption != null) {
            if (t3 == null) {
                synchronized (this.options) {
                    this.options.remove(channelOption);
                }
            } else {
                synchronized (this.options) {
                    this.options.put(channelOption, t3);
                }
            }
            return this;
        }
        throw new NullPointerException("option");
    }

    public Future<Http2StreamChannel> open(final Promise<Http2StreamChannel> promise) {
        try {
            final ChannelHandlerContext findCtx = findCtx();
            EventExecutor executor = findCtx.executor();
            if (executor.inEventLoop()) {
                open0(findCtx, promise);
            } else {
                executor.execute(new Runnable() { // from class: io.netty.handler.codec.http2.Http2StreamChannelBootstrap.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Http2StreamChannelBootstrap.this.open0(findCtx, promise);
                    }
                });
            }
        } catch (Throwable th) {
            promise.setFailure(th);
        }
        return promise;
    }
}
