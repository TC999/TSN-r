package io.netty.resolver.dns;

import io.netty.channel.ChannelFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.ReflectiveChannelFactory;
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

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DnsAddressResolverGroup extends AddressResolverGroup<InetSocketAddress> {
    private final ChannelFactory<? extends DatagramChannel> channelFactory;
    private final DnsServerAddresses nameServerAddresses;
    private final ConcurrentMap<String, Promise<List<InetAddress>>> resolveAllsInProgress;
    private final ConcurrentMap<String, Promise<InetAddress>> resolvesInProgress;

    public DnsAddressResolverGroup(Class<? extends DatagramChannel> cls, DnsServerAddresses dnsServerAddresses) {
        this(new ReflectiveChannelFactory(cls), dnsServerAddresses);
    }

    protected NameResolver<InetAddress> newNameResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, DnsServerAddresses dnsServerAddresses) throws Exception {
        return new DnsNameResolverBuilder(eventLoop).channelFactory(channelFactory).nameServerAddresses(dnsServerAddresses).build();
    }

    @Override // io.netty.resolver.AddressResolverGroup
    protected final AddressResolver<InetSocketAddress> newResolver(EventExecutor eventExecutor) throws Exception {
        if (eventExecutor instanceof EventLoop) {
            return newResolver((EventLoop) eventExecutor, this.channelFactory, this.nameServerAddresses);
        }
        throw new IllegalStateException("unsupported executor type: " + StringUtil.simpleClassName(eventExecutor) + " (expected: " + StringUtil.simpleClassName((Class<?>) EventLoop.class));
    }

    public DnsAddressResolverGroup(ChannelFactory<? extends DatagramChannel> channelFactory, DnsServerAddresses dnsServerAddresses) {
        this.resolvesInProgress = PlatformDependent.newConcurrentHashMap();
        this.resolveAllsInProgress = PlatformDependent.newConcurrentHashMap();
        this.channelFactory = channelFactory;
        this.nameServerAddresses = dnsServerAddresses;
    }

    @Deprecated
    protected AddressResolver<InetSocketAddress> newResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, DnsServerAddresses dnsServerAddresses) throws Exception {
        return new InetSocketAddressResolver(eventLoop, new InflightNameResolver(eventLoop, newNameResolver(eventLoop, channelFactory, dnsServerAddresses), this.resolvesInProgress, this.resolveAllsInProgress));
    }
}
