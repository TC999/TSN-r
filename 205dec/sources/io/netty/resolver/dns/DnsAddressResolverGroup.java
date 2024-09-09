package io.netty.resolver.dns;

import io.netty.channel.ChannelFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.socket.DatagramChannel;
import io.netty.resolver.AddressResolver;
import io.netty.resolver.AddressResolverGroup;
import io.netty.resolver.InetSocketAddressResolver;
import io.netty.resolver.NameResolver;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DnsAddressResolverGroup extends AddressResolverGroup<InetSocketAddress> {
    private final DnsNameResolverBuilder dnsResolverBuilder;
    private final ConcurrentMap<String, Promise<List<InetAddress>>> resolveAllsInProgress;
    private final ConcurrentMap<String, Promise<InetAddress>> resolvesInProgress;

    public DnsAddressResolverGroup(DnsNameResolverBuilder dnsNameResolverBuilder) {
        this.resolvesInProgress = PlatformDependent.newConcurrentHashMap();
        this.resolveAllsInProgress = PlatformDependent.newConcurrentHashMap();
        this.dnsResolverBuilder = dnsNameResolverBuilder.copy();
    }

    protected AddressResolver<InetSocketAddress> newAddressResolver(EventLoop eventLoop, NameResolver<InetAddress> nameResolver) throws Exception {
        return new InetSocketAddressResolver(eventLoop, nameResolver);
    }

    protected NameResolver<InetAddress> newNameResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, DnsServerAddressStreamProvider dnsServerAddressStreamProvider) throws Exception {
        return this.dnsResolverBuilder.eventLoop(eventLoop).channelFactory(channelFactory).nameServerProvider(dnsServerAddressStreamProvider).build();
    }

    @Override // io.netty.resolver.AddressResolverGroup
    protected final AddressResolver<InetSocketAddress> newResolver(EventExecutor eventExecutor) throws Exception {
        if (eventExecutor instanceof EventLoop) {
            return newResolver((EventLoop) eventExecutor, this.dnsResolverBuilder.channelFactory(), this.dnsResolverBuilder.nameServerProvider());
        }
        throw new IllegalStateException("unsupported executor type: " + StringUtil.simpleClassName(eventExecutor) + " (expected: " + StringUtil.simpleClassName((Class<?>) EventLoop.class));
    }

    public DnsAddressResolverGroup(Class<? extends DatagramChannel> cls, DnsServerAddressStreamProvider dnsServerAddressStreamProvider) {
        this(new DnsNameResolverBuilder());
        this.dnsResolverBuilder.channelType(cls).nameServerProvider(dnsServerAddressStreamProvider);
    }

    public DnsAddressResolverGroup(ChannelFactory<? extends DatagramChannel> channelFactory, DnsServerAddressStreamProvider dnsServerAddressStreamProvider) {
        this(new DnsNameResolverBuilder());
        this.dnsResolverBuilder.channelFactory(channelFactory).nameServerProvider(dnsServerAddressStreamProvider);
    }

    @Deprecated
    protected AddressResolver<InetSocketAddress> newResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, DnsServerAddressStreamProvider dnsServerAddressStreamProvider) throws Exception {
        return newAddressResolver(eventLoop, new InflightNameResolver(eventLoop, newNameResolver(eventLoop, channelFactory, dnsServerAddressStreamProvider), this.resolvesInProgress, this.resolveAllsInProgress));
    }
}
