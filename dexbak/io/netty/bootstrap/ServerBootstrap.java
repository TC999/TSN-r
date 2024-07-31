package io.netty.bootstrap;

import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ServerBootstrap extends AbstractBootstrap<ServerBootstrap, ServerChannel> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ServerBootstrap.class);
    private final Map<AttributeKey<?>, Object> childAttrs;
    private volatile EventLoopGroup childGroup;
    private volatile ChannelHandler childHandler;
    private final Map<ChannelOption<?>, Object> childOptions;
    private final ServerBootstrapConfig config;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class ServerBootstrapAcceptor extends ChannelInboundHandlerAdapter {
        private final Map.Entry<AttributeKey<?>, Object>[] childAttrs;
        private final EventLoopGroup childGroup;
        private final ChannelHandler childHandler;
        private final Map.Entry<ChannelOption<?>, Object>[] childOptions;

        ServerBootstrapAcceptor(EventLoopGroup eventLoopGroup, ChannelHandler channelHandler, Map.Entry<ChannelOption<?>, Object>[] entryArr, Map.Entry<AttributeKey<?>, Object>[] entryArr2) {
            this.childGroup = eventLoopGroup;
            this.childHandler = channelHandler;
            this.childOptions = entryArr;
            this.childAttrs = entryArr2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void forceClose(Channel channel, Throwable th) {
            channel.unsafe().closeForcibly();
            InternalLogger internalLogger = ServerBootstrap.logger;
            internalLogger.warn("Failed to register an accepted channel: " + channel, th);
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
            Map.Entry<ChannelOption<?>, Object>[] entryArr;
            Map.Entry<AttributeKey<?>, Object>[] entryArr2;
            final Channel channel = (Channel) obj;
            channel.pipeline().addLast(this.childHandler);
            for (Map.Entry<ChannelOption<?>, Object> entry : this.childOptions) {
                try {
                    if (!channel.config().setOption(entry.getKey(), entry.getValue())) {
                        ServerBootstrap.logger.warn("Unknown channel option: " + entry);
                    }
                } catch (Throwable th) {
                    ServerBootstrap.logger.warn("Failed to set a channel option: " + channel, th);
                }
            }
            for (Map.Entry<AttributeKey<?>, Object> entry2 : this.childAttrs) {
                channel.attr(entry2.getKey()).set(entry2.getValue());
            }
            try {
                this.childGroup.register(channel).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.bootstrap.ServerBootstrap.ServerBootstrapAcceptor.1
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if (channelFuture.isSuccess()) {
                            return;
                        }
                        ServerBootstrapAcceptor.forceClose(channel, channelFuture.cause());
                    }
                });
            } catch (Throwable th2) {
                forceClose(channel, th2);
            }
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
            final ChannelConfig config = channelHandlerContext.channel().config();
            if (config.isAutoRead()) {
                config.setAutoRead(false);
                channelHandlerContext.channel().eventLoop().schedule(new Runnable() { // from class: io.netty.bootstrap.ServerBootstrap.ServerBootstrapAcceptor.2
                    @Override // java.lang.Runnable
                    public void run() {
                        config.setAutoRead(true);
                    }
                }, 1L, TimeUnit.SECONDS);
            }
            channelHandlerContext.fireExceptionCaught(th);
        }
    }

    public ServerBootstrap() {
        this.childOptions = new LinkedHashMap();
        this.childAttrs = new LinkedHashMap();
        this.config = new ServerBootstrapConfig(this);
    }

    private static Map.Entry<AttributeKey<?>, Object>[] newAttrArray(int i) {
        return new Map.Entry[i];
    }

    private static Map.Entry<ChannelOption<?>, Object>[] newOptionArray(int i) {
        return new Map.Entry[i];
    }

    public <T> ServerBootstrap childAttr(AttributeKey<T> attributeKey, T t) {
        if (attributeKey != null) {
            if (t == null) {
                this.childAttrs.remove(attributeKey);
            } else {
                this.childAttrs.put(attributeKey, t);
            }
            return this;
        }
        throw new NullPointerException("childKey");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<AttributeKey<?>, Object> childAttrs() {
        return AbstractBootstrap.copiedMap(this.childAttrs);
    }

    @Deprecated
    public EventLoopGroup childGroup() {
        return this.childGroup;
    }

    public ServerBootstrap childHandler(ChannelHandler channelHandler) {
        if (channelHandler != null) {
            this.childHandler = channelHandler;
            return this;
        }
        throw new NullPointerException("childHandler");
    }

    public <T> ServerBootstrap childOption(ChannelOption<T> channelOption, T t) {
        if (channelOption != null) {
            if (t == null) {
                synchronized (this.childOptions) {
                    this.childOptions.remove(channelOption);
                }
            } else {
                synchronized (this.childOptions) {
                    this.childOptions.put(channelOption, t);
                }
            }
            return this;
        }
        throw new NullPointerException("childOption");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<ChannelOption<?>, Object> childOptions() {
        return AbstractBootstrap.copiedMap(this.childOptions);
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    void init(Channel channel) throws Exception {
        final Map.Entry[] entryArr;
        final Map.Entry[] entryArr2;
        Map<ChannelOption<?>, ?> options0 = options0();
        synchronized (options0) {
            channel.config().setOptions(options0);
        }
        Map<AttributeKey<?>, Object> attrs0 = attrs0();
        synchronized (attrs0) {
            for (Map.Entry<AttributeKey<?>, Object> entry : attrs0.entrySet()) {
                channel.attr(entry.getKey()).set(entry.getValue());
            }
        }
        ChannelPipeline pipeline = channel.pipeline();
        final EventLoopGroup eventLoopGroup = this.childGroup;
        final ChannelHandler channelHandler = this.childHandler;
        synchronized (this.childOptions) {
            entryArr = (Map.Entry[]) this.childOptions.entrySet().toArray(newOptionArray(this.childOptions.size()));
        }
        synchronized (this.childAttrs) {
            entryArr2 = (Map.Entry[]) this.childAttrs.entrySet().toArray(newAttrArray(this.childAttrs.size()));
        }
        pipeline.addLast(new ChannelInitializer<Channel>() { // from class: io.netty.bootstrap.ServerBootstrap.1
            @Override // io.netty.channel.ChannelInitializer
            public void initChannel(Channel channel2) throws Exception {
                final ChannelPipeline pipeline2 = channel2.pipeline();
                ChannelHandler handler = ServerBootstrap.this.config.handler();
                if (handler != null) {
                    pipeline2.addLast(handler);
                }
                channel2.eventLoop().execute(new Runnable() { // from class: io.netty.bootstrap.ServerBootstrap.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChannelPipeline channelPipeline = pipeline2;
                        C135901 c135901 = C135901.this;
                        channelPipeline.addLast(new ServerBootstrapAcceptor(eventLoopGroup, channelHandler, entryArr, entryArr2));
                    }
                });
            }
        });
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public final AbstractBootstrapConfig<ServerBootstrap, ServerChannel> config() {
        return this.config;
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public ServerBootstrap group(EventLoopGroup eventLoopGroup) {
        return group(eventLoopGroup, eventLoopGroup);
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public ServerBootstrap validate() {
        super.validate();
        if (this.childHandler != null) {
            if (this.childGroup == null) {
                logger.warn("childGroup is not set. Using parentGroup instead.");
                this.childGroup = this.config.group();
            }
            return this;
        }
        throw new IllegalStateException("childHandler not set");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ChannelHandler childHandler() {
        return this.childHandler;
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    /* renamed from: clone  reason: avoid collision after fix types in other method */
    public ServerBootstrap mo60142clone() {
        return new ServerBootstrap(this);
    }

    public ServerBootstrap group(EventLoopGroup eventLoopGroup, EventLoopGroup eventLoopGroup2) {
        super.group(eventLoopGroup);
        if (eventLoopGroup2 != null) {
            if (this.childGroup == null) {
                this.childGroup = eventLoopGroup2;
                return this;
            }
            throw new IllegalStateException("childGroup set already");
        }
        throw new NullPointerException("childGroup");
    }

    private ServerBootstrap(ServerBootstrap serverBootstrap) {
        super(serverBootstrap);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.childOptions = linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        this.childAttrs = linkedHashMap2;
        this.config = new ServerBootstrapConfig(this);
        this.childGroup = serverBootstrap.childGroup;
        this.childHandler = serverBootstrap.childHandler;
        synchronized (serverBootstrap.childOptions) {
            linkedHashMap.putAll(serverBootstrap.childOptions);
        }
        synchronized (serverBootstrap.childAttrs) {
            linkedHashMap2.putAll(serverBootstrap.childAttrs);
        }
    }
}
