package io.netty.bootstrap;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import io.netty.bootstrap.AbstractBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ReflectiveChannelFactory;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.internal.StringUtil;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractBootstrap<B extends AbstractBootstrap<B, C>, C extends Channel> implements Cloneable {
    private final Map<AttributeKey<?>, Object> attrs;
    private volatile ChannelFactory<? extends C> channelFactory;
    volatile EventLoopGroup group;
    private volatile ChannelHandler handler;
    private volatile SocketAddress localAddress;
    private final Map<ChannelOption<?>, Object> options;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class PendingRegistrationPromise extends DefaultChannelPromise {
        private volatile boolean registered;

        /* JADX INFO: Access modifiers changed from: package-private */
        public PendingRegistrationPromise(Channel channel) {
            super(channel);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.channel.DefaultChannelPromise, io.netty.util.concurrent.DefaultPromise
        public EventExecutor executor() {
            if (this.registered) {
                return super.executor();
            }
            return GlobalEventExecutor.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void registered() {
            this.registered = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractBootstrap() {
        this.options = new LinkedHashMap();
        this.attrs = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map<K, V> copiedMap(Map<K, V> map) {
        synchronized (map) {
            if (map.isEmpty()) {
                return Collections.emptyMap();
            }
            return Collections.unmodifiableMap(new LinkedHashMap(map));
        }
    }

    private ChannelFuture doBind(final SocketAddress socketAddress) {
        final ChannelFuture initAndRegister = initAndRegister();
        final Channel channel = initAndRegister.channel();
        if (initAndRegister.cause() != null) {
            return initAndRegister;
        }
        if (initAndRegister.isDone()) {
            ChannelPromise newPromise = channel.newPromise();
            doBind0(initAndRegister, channel, socketAddress, newPromise);
            return newPromise;
        }
        final PendingRegistrationPromise pendingRegistrationPromise = new PendingRegistrationPromise(channel);
        initAndRegister.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.bootstrap.AbstractBootstrap.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                Throwable cause = channelFuture.cause();
                if (cause != null) {
                    pendingRegistrationPromise.setFailure(cause);
                    return;
                }
                pendingRegistrationPromise.registered();
                AbstractBootstrap.doBind0(initAndRegister, channel, socketAddress, pendingRegistrationPromise);
            }
        });
        return pendingRegistrationPromise;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doBind0(final ChannelFuture channelFuture, final Channel channel, final SocketAddress socketAddress, final ChannelPromise channelPromise) {
        channel.eventLoop().execute(new Runnable() { // from class: io.netty.bootstrap.AbstractBootstrap.2
            @Override // java.lang.Runnable
            public void run() {
                if (ChannelFuture.this.isSuccess()) {
                    channel.bind(socketAddress, channelPromise).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE_ON_FAILURE);
                } else {
                    channelPromise.setFailure(ChannelFuture.this.cause());
                }
            }
        });
    }

    public <T> B attr(AttributeKey<T> attributeKey, T t) {
        if (attributeKey != null) {
            if (t == null) {
                synchronized (this.attrs) {
                    this.attrs.remove(attributeKey);
                }
            } else {
                synchronized (this.attrs) {
                    this.attrs.put(attributeKey, t);
                }
            }
            return this;
        }
        throw new NullPointerException(DomainCampaignEx.LOOPBACK_KEY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<AttributeKey<?>, Object> attrs() {
        return copiedMap(this.attrs);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<AttributeKey<?>, Object> attrs0() {
        return this.attrs;
    }

    public ChannelFuture bind() {
        validate();
        SocketAddress socketAddress = this.localAddress;
        if (socketAddress != null) {
            return doBind(socketAddress);
        }
        throw new IllegalStateException("localAddress not set");
    }

    public B channel(Class<? extends C> cls) {
        if (cls != null) {
            return channelFactory((io.netty.channel.ChannelFactory) new ReflectiveChannelFactory(cls));
        }
        throw new NullPointerException("channelClass");
    }

    @Deprecated
    public B channelFactory(ChannelFactory<? extends C> channelFactory) {
        if (channelFactory != null) {
            if (this.channelFactory == null) {
                this.channelFactory = channelFactory;
                return this;
            }
            throw new IllegalStateException("channelFactory set already");
        }
        throw new NullPointerException("channelFactory");
    }

    @Override // 
    /* renamed from: clone */
    public abstract B mo60142clone();

    public abstract AbstractBootstrapConfig<B, C> config();

    public B group(EventLoopGroup eventLoopGroup) {
        if (eventLoopGroup != null) {
            if (this.group == null) {
                this.group = eventLoopGroup;
                return this;
            }
            throw new IllegalStateException("group set already");
        }
        throw new NullPointerException("group");
    }

    public B handler(ChannelHandler channelHandler) {
        if (channelHandler != null) {
            this.handler = channelHandler;
            return this;
        }
        throw new NullPointerException("handler");
    }

    abstract void init(Channel channel) throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ChannelFuture initAndRegister() {
        C c = null;
        try {
            c = this.channelFactory.newChannel();
            init(c);
            ChannelFuture register = config().group().register(c);
            if (register.cause() != null) {
                if (c.isRegistered()) {
                    c.close();
                } else {
                    c.unsafe().closeForcibly();
                }
            }
            return register;
        } catch (Throwable th) {
            if (c != null) {
                c.unsafe().closeForcibly();
            }
            return new DefaultChannelPromise(c, GlobalEventExecutor.INSTANCE).setFailure(th);
        }
    }

    public B localAddress(SocketAddress socketAddress) {
        this.localAddress = socketAddress;
        return this;
    }

    public <T> B option(ChannelOption<T> channelOption, T t) {
        if (channelOption != null) {
            if (t == null) {
                synchronized (this.options) {
                    this.options.remove(channelOption);
                }
            } else {
                synchronized (this.options) {
                    this.options.put(channelOption, t);
                }
            }
            return this;
        }
        throw new NullPointerException("option");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<ChannelOption<?>, Object> options() {
        return copiedMap(this.options);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<ChannelOption<?>, Object> options0() {
        return this.options;
    }

    public ChannelFuture register() {
        validate();
        return initAndRegister();
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + '(' + config() + ')';
    }

    public B validate() {
        if (this.group != null) {
            if (this.channelFactory != null) {
                return this;
            }
            throw new IllegalStateException("channel or channelFactory not set");
        }
        throw new IllegalStateException("group not set");
    }

    public B localAddress(int i) {
        return localAddress(new InetSocketAddress(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ChannelHandler handler() {
        return this.handler;
    }

    public B localAddress(String str, int i) {
        return localAddress(new InetSocketAddress(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractBootstrap(AbstractBootstrap<B, C> abstractBootstrap) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.options = linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        this.attrs = linkedHashMap2;
        this.group = abstractBootstrap.group;
        this.channelFactory = abstractBootstrap.channelFactory;
        this.handler = abstractBootstrap.handler;
        this.localAddress = abstractBootstrap.localAddress;
        synchronized (abstractBootstrap.options) {
            linkedHashMap.putAll(abstractBootstrap.options);
        }
        synchronized (abstractBootstrap.attrs) {
            linkedHashMap2.putAll(abstractBootstrap.attrs);
        }
    }

    public B localAddress(InetAddress inetAddress, int i) {
        return localAddress(new InetSocketAddress(inetAddress, i));
    }

    public ChannelFuture bind(int i) {
        return bind(new InetSocketAddress(i));
    }

    public B channelFactory(io.netty.channel.ChannelFactory<? extends C> channelFactory) {
        return channelFactory((ChannelFactory) channelFactory);
    }

    @Deprecated
    public final EventLoopGroup group() {
        return this.group;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SocketAddress localAddress() {
        return this.localAddress;
    }

    public ChannelFuture bind(String str, int i) {
        return bind(new InetSocketAddress(str, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ChannelFactory<? extends C> channelFactory() {
        return this.channelFactory;
    }

    public ChannelFuture bind(InetAddress inetAddress, int i) {
        return bind(new InetSocketAddress(inetAddress, i));
    }

    public ChannelFuture bind(SocketAddress socketAddress) {
        validate();
        if (socketAddress != null) {
            return doBind(socketAddress);
        }
        throw new NullPointerException("localAddress");
    }
}
