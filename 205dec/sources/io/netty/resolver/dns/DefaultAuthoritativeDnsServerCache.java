package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DefaultAuthoritativeDnsServerCache implements AuthoritativeDnsServerCache {
    private final Comparator<InetSocketAddress> comparator;
    private final int maxTtl;
    private final int minTtl;
    private final Cache<InetSocketAddress> resolveCache;

    public DefaultAuthoritativeDnsServerCache() {
        this(0, Cache.MAX_SUPPORTED_TTL_SECS, null);
    }

    @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
    public void cache(String str, InetSocketAddress inetSocketAddress, long j4, EventLoop eventLoop) {
        ObjectUtil.checkNotNull(str, "hostname");
        ObjectUtil.checkNotNull(inetSocketAddress, "address");
        ObjectUtil.checkNotNull(eventLoop, "loop");
        if (PlatformDependent.javaVersion() < 7 || inetSocketAddress.getHostString() != null) {
            this.resolveCache.cache(str, inetSocketAddress, Math.max(this.minTtl, (int) Math.min(this.maxTtl, j4)), eventLoop);
        }
    }

    @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
    public void clear() {
        this.resolveCache.clear();
    }

    @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
    public DnsServerAddressStream get(String str) {
        ObjectUtil.checkNotNull(str, "hostname");
        List<? extends InetSocketAddress> list = this.resolveCache.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return new SequentialDnsServerAddressStream(list, 0);
    }

    public String toString() {
        return "DefaultAuthoritativeDnsServerCache(minTtl=" + this.minTtl + ", maxTtl=" + this.maxTtl + ", cached nameservers=" + this.resolveCache.size() + ')';
    }

    public DefaultAuthoritativeDnsServerCache(int i4, int i5, Comparator<InetSocketAddress> comparator) {
        this.resolveCache = new Cache<InetSocketAddress>() { // from class: io.netty.resolver.dns.DefaultAuthoritativeDnsServerCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.resolver.dns.Cache
            public boolean shouldReplaceAll(InetSocketAddress inetSocketAddress) {
                return false;
            }

            @Override // io.netty.resolver.dns.Cache
            protected void sortEntries(String str, List<InetSocketAddress> list) {
                if (DefaultAuthoritativeDnsServerCache.this.comparator != null) {
                    Collections.sort(list, DefaultAuthoritativeDnsServerCache.this.comparator);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.resolver.dns.Cache
            public boolean equals(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) {
                if (PlatformDependent.javaVersion() >= 7) {
                    return inetSocketAddress.getHostString().equalsIgnoreCase(inetSocketAddress2.getHostString());
                }
                return inetSocketAddress.getHostName().equalsIgnoreCase(inetSocketAddress2.getHostName());
            }
        };
        int i6 = Cache.MAX_SUPPORTED_TTL_SECS;
        this.minTtl = Math.min(i6, ObjectUtil.checkPositiveOrZero(i4, "minTtl"));
        this.maxTtl = Math.min(i6, ObjectUtil.checkPositive(i5, "maxTtl"));
        if (i4 <= i5) {
            this.comparator = comparator;
            return;
        }
        throw new IllegalArgumentException("minTtl: " + i4 + ", maxTtl: " + i5 + " (expected: 0 <= minTtl <= maxTtl)");
    }

    @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
    public boolean clear(String str) {
        ObjectUtil.checkNotNull(str, "hostname");
        return this.resolveCache.clear(str);
    }
}
