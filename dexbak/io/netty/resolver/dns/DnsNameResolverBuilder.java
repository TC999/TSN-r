package io.netty.resolver.dns;

import io.netty.channel.ChannelFactory;
import io.netty.channel.EventLoop;
import io.netty.channel.ReflectiveChannelFactory;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.resolver.HostsFileEntriesResolver;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class DnsNameResolverBuilder {
    private ChannelFactory<? extends DatagramChannel> channelFactory;
    private final EventLoop eventLoop;
    private Integer maxTtl;
    private Integer minTtl;
    private Integer negativeTtl;
    private DnsCache resolveCache;
    private boolean traceEnabled;
    private DnsServerAddresses nameServerAddresses = DnsServerAddresses.defaultAddresses();
    private long queryTimeoutMillis = 5000;
    private InternetProtocolFamily[] resolvedAddressTypes = DnsNameResolver.DEFAULT_RESOLVE_ADDRESS_TYPES;
    private boolean recursionDesired = true;
    private int maxQueriesPerResolve = 16;
    private int maxPayloadSize = 4096;
    private boolean optResourceEnabled = true;
    private HostsFileEntriesResolver hostsFileEntriesResolver = HostsFileEntriesResolver.DEFAULT;
    private String[] searchDomains = DnsNameResolver.DEFAULT_SEACH_DOMAINS;
    private int ndots = 1;

    public DnsNameResolverBuilder(EventLoop eventLoop) {
        this.eventLoop = eventLoop;
    }

    public DnsNameResolver build() {
        DnsCache dnsCache = this.resolveCache;
        if (dnsCache != null && (this.minTtl != null || this.maxTtl != null || this.negativeTtl != null)) {
            throw new IllegalStateException("resolveCache and TTLs are mutually exclusive");
        }
        if (dnsCache == null) {
            dnsCache = new DefaultDnsCache(ObjectUtil.intValue(this.minTtl, 0), ObjectUtil.intValue(this.maxTtl, Integer.MAX_VALUE), ObjectUtil.intValue(this.negativeTtl, 0));
        }
        return new DnsNameResolver(this.eventLoop, this.channelFactory, this.nameServerAddresses, dnsCache, this.queryTimeoutMillis, this.resolvedAddressTypes, this.recursionDesired, this.maxQueriesPerResolve, this.traceEnabled, this.maxPayloadSize, this.optResourceEnabled, this.hostsFileEntriesResolver, this.searchDomains, this.ndots);
    }

    public DnsNameResolverBuilder channelFactory(ChannelFactory<? extends DatagramChannel> channelFactory) {
        this.channelFactory = channelFactory;
        return this;
    }

    public DnsNameResolverBuilder channelType(Class<? extends DatagramChannel> cls) {
        return channelFactory(new ReflectiveChannelFactory(cls));
    }

    public DnsNameResolverBuilder hostsFileEntriesResolver(HostsFileEntriesResolver hostsFileEntriesResolver) {
        this.hostsFileEntriesResolver = hostsFileEntriesResolver;
        return this;
    }

    public DnsNameResolverBuilder maxPayloadSize(int i) {
        this.maxPayloadSize = i;
        return this;
    }

    public DnsNameResolverBuilder maxQueriesPerResolve(int i) {
        this.maxQueriesPerResolve = i;
        return this;
    }

    public DnsNameResolverBuilder nameServerAddresses(DnsServerAddresses dnsServerAddresses) {
        this.nameServerAddresses = dnsServerAddresses;
        return this;
    }

    public DnsNameResolverBuilder ndots(int i) {
        this.ndots = i;
        return this;
    }

    public DnsNameResolverBuilder negativeTtl(int i) {
        this.negativeTtl = Integer.valueOf(i);
        return this;
    }

    public DnsNameResolverBuilder optResourceEnabled(boolean z) {
        this.optResourceEnabled = z;
        return this;
    }

    public DnsNameResolverBuilder queryTimeoutMillis(long j) {
        this.queryTimeoutMillis = j;
        return this;
    }

    public DnsNameResolverBuilder recursionDesired(boolean z) {
        this.recursionDesired = z;
        return this;
    }

    public DnsNameResolverBuilder resolveCache(DnsCache dnsCache) {
        this.resolveCache = dnsCache;
        return this;
    }

    public DnsNameResolverBuilder resolvedAddressTypes(InternetProtocolFamily... internetProtocolFamilyArr) {
        ObjectUtil.checkNotNull(internetProtocolFamilyArr, "resolvedAddressTypes");
        ArrayList arrayList = InternalThreadLocalMap.get().arrayList(InternetProtocolFamily.values().length);
        for (InternetProtocolFamily internetProtocolFamily : internetProtocolFamilyArr) {
            if (internetProtocolFamily == null) {
                break;
            }
            if (!arrayList.contains(internetProtocolFamily)) {
                arrayList.add(internetProtocolFamily);
            }
        }
        if (!arrayList.isEmpty()) {
            this.resolvedAddressTypes = (InternetProtocolFamily[]) arrayList.toArray(new InternetProtocolFamily[arrayList.size()]);
            return this;
        }
        throw new IllegalArgumentException("no protocol family specified");
    }

    public DnsNameResolverBuilder searchDomains(Iterable<String> iterable) {
        String next;
        ObjectUtil.checkNotNull(iterable, "searchDomains");
        ArrayList arrayList = InternalThreadLocalMap.get().arrayList(4);
        Iterator<String> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (!arrayList.contains(next)) {
                arrayList.add(next);
            }
        }
        this.searchDomains = (String[]) arrayList.toArray(new String[arrayList.size()]);
        return this;
    }

    public DnsNameResolverBuilder traceEnabled(boolean z) {
        this.traceEnabled = z;
        return this;
    }

    public DnsNameResolverBuilder ttl(int i, int i2) {
        this.maxTtl = Integer.valueOf(i2);
        this.minTtl = Integer.valueOf(i);
        return this;
    }

    public DnsNameResolverBuilder resolvedAddressTypes(Iterable<InternetProtocolFamily> iterable) {
        InternetProtocolFamily next;
        ObjectUtil.checkNotNull(iterable, "resolveAddressTypes");
        ArrayList arrayList = InternalThreadLocalMap.get().arrayList(InternetProtocolFamily.values().length);
        Iterator<InternetProtocolFamily> it = iterable.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (!arrayList.contains(next)) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            this.resolvedAddressTypes = (InternetProtocolFamily[]) arrayList.toArray(new InternetProtocolFamily[arrayList.size()]);
            return this;
        }
        throw new IllegalArgumentException("no protocol family specified");
    }
}
