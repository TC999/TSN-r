package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.InetAddress;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DefaultDnsCache implements DnsCache {
    private final int maxTtl;
    private final int minTtl;
    private final int negativeTtl;
    private final Cache<DefaultDnsCacheEntry> resolveCache;

    public DefaultDnsCache() {
        this(0, Cache.MAX_SUPPORTED_TTL_SECS, 0);
    }

    private static String appendDot(String str) {
        if (StringUtil.endsWith(str, '.')) {
            return str;
        }
        return str + '.';
    }

    private static boolean emptyAdditionals(DnsRecord[] dnsRecordArr) {
        return dnsRecordArr == null || dnsRecordArr.length == 0;
    }

    @Override // io.netty.resolver.dns.DnsCache
    public DnsCacheEntry cache(String str, DnsRecord[] dnsRecordArr, InetAddress inetAddress, long j4, EventLoop eventLoop) {
        ObjectUtil.checkNotNull(str, "hostname");
        ObjectUtil.checkNotNull(inetAddress, "address");
        ObjectUtil.checkNotNull(eventLoop, "loop");
        DefaultDnsCacheEntry defaultDnsCacheEntry = new DefaultDnsCacheEntry(str, inetAddress);
        if (this.maxTtl != 0 && emptyAdditionals(dnsRecordArr)) {
            this.resolveCache.cache(appendDot(str), defaultDnsCacheEntry, Math.max(this.minTtl, (int) Math.min(this.maxTtl, j4)), eventLoop);
        }
        return defaultDnsCacheEntry;
    }

    @Override // io.netty.resolver.dns.DnsCache
    public void clear() {
        this.resolveCache.clear();
    }

    @Override // io.netty.resolver.dns.DnsCache
    public List<? extends DnsCacheEntry> get(String str, DnsRecord[] dnsRecordArr) {
        ObjectUtil.checkNotNull(str, "hostname");
        if (!emptyAdditionals(dnsRecordArr)) {
            return Collections.emptyList();
        }
        return this.resolveCache.get(appendDot(str));
    }

    public int maxTtl() {
        return this.maxTtl;
    }

    public int minTtl() {
        return this.minTtl;
    }

    public int negativeTtl() {
        return this.negativeTtl;
    }

    public String toString() {
        return "DefaultDnsCache(minTtl=" + this.minTtl + ", maxTtl=" + this.maxTtl + ", negativeTtl=" + this.negativeTtl + ", cached resolved hostname=" + this.resolveCache.size() + ')';
    }

    public DefaultDnsCache(int i4, int i5, int i6) {
        this.resolveCache = new Cache<DefaultDnsCacheEntry>() { // from class: io.netty.resolver.dns.DefaultDnsCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.resolver.dns.Cache
            public boolean equals(DefaultDnsCacheEntry defaultDnsCacheEntry, DefaultDnsCacheEntry defaultDnsCacheEntry2) {
                if (defaultDnsCacheEntry.address() != null) {
                    return defaultDnsCacheEntry.address().equals(defaultDnsCacheEntry2.address());
                }
                if (defaultDnsCacheEntry2.address() != null) {
                    return false;
                }
                return defaultDnsCacheEntry.cause().equals(defaultDnsCacheEntry2.cause());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.resolver.dns.Cache
            public boolean shouldReplaceAll(DefaultDnsCacheEntry defaultDnsCacheEntry) {
                return defaultDnsCacheEntry.cause() != null;
            }
        };
        int i7 = Cache.MAX_SUPPORTED_TTL_SECS;
        this.minTtl = Math.min(i7, ObjectUtil.checkPositiveOrZero(i4, "minTtl"));
        this.maxTtl = Math.min(i7, ObjectUtil.checkPositiveOrZero(i5, "maxTtl"));
        if (i4 <= i5) {
            this.negativeTtl = ObjectUtil.checkPositiveOrZero(i6, "negativeTtl");
            return;
        }
        throw new IllegalArgumentException("minTtl: " + i4 + ", maxTtl: " + i5 + " (expected: 0 <= minTtl <= maxTtl)");
    }

    @Override // io.netty.resolver.dns.DnsCache
    public boolean clear(String str) {
        ObjectUtil.checkNotNull(str, "hostname");
        return this.resolveCache.clear(appendDot(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class DefaultDnsCacheEntry implements DnsCacheEntry {
        private final InetAddress address;
        private final Throwable cause;
        private final String hostname;

        DefaultDnsCacheEntry(String str, InetAddress inetAddress) {
            this.hostname = str;
            this.address = inetAddress;
            this.cause = null;
        }

        @Override // io.netty.resolver.dns.DnsCacheEntry
        public InetAddress address() {
            return this.address;
        }

        @Override // io.netty.resolver.dns.DnsCacheEntry
        public Throwable cause() {
            return this.cause;
        }

        String hostname() {
            return this.hostname;
        }

        public String toString() {
            if (this.cause != null) {
                return this.hostname + '/' + this.cause;
            }
            return this.address.toString();
        }

        DefaultDnsCacheEntry(String str, Throwable th) {
            this.hostname = str;
            this.cause = th;
            this.address = null;
        }
    }

    @Override // io.netty.resolver.dns.DnsCache
    public DnsCacheEntry cache(String str, DnsRecord[] dnsRecordArr, Throwable th, EventLoop eventLoop) {
        ObjectUtil.checkNotNull(str, "hostname");
        ObjectUtil.checkNotNull(th, "cause");
        ObjectUtil.checkNotNull(eventLoop, "loop");
        DefaultDnsCacheEntry defaultDnsCacheEntry = new DefaultDnsCacheEntry(str, th);
        if (this.negativeTtl != 0 && emptyAdditionals(dnsRecordArr)) {
            this.resolveCache.cache(appendDot(str), defaultDnsCacheEntry, this.negativeTtl, eventLoop);
        }
        return defaultDnsCacheEntry;
    }
}
