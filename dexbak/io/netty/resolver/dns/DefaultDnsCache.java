package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DefaultDnsCache implements DnsCache {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final int maxTtl;
    private final int minTtl;
    private final int negativeTtl;
    private final ConcurrentMap<String, List<DnsCacheEntry>> resolveCache;

    public DefaultDnsCache() {
        this(0, Integer.MAX_VALUE, 0);
    }

    private List<DnsCacheEntry> cachedEntries(String str) {
        List<DnsCacheEntry> list = this.resolveCache.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList(8);
            List<DnsCacheEntry> putIfAbsent = this.resolveCache.putIfAbsent(str, arrayList);
            return putIfAbsent != null ? putIfAbsent : arrayList;
        }
        return list;
    }

    private static void cancelExpiration(List<DnsCacheEntry> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).cancelExpiration();
        }
    }

    private void scheduleCacheExpiration(final List<DnsCacheEntry> list, final DnsCacheEntry dnsCacheEntry, int i, EventLoop eventLoop) {
        dnsCacheEntry.scheduleExpiration(eventLoop, new Runnable() { // from class: io.netty.resolver.dns.DefaultDnsCache.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (list) {
                    list.remove(dnsCacheEntry);
                    if (list.isEmpty()) {
                        DefaultDnsCache.this.resolveCache.remove(dnsCacheEntry.hostname());
                    }
                }
            }
        }, i, TimeUnit.SECONDS);
    }

    @Override // io.netty.resolver.dns.DnsCache
    public void cache(String str, InetAddress inetAddress, long j, EventLoop eventLoop) {
        if (this.maxTtl == 0) {
            return;
        }
        ObjectUtil.checkNotNull(str, "hostname");
        ObjectUtil.checkNotNull(inetAddress, "address");
        ObjectUtil.checkNotNull(eventLoop, "loop");
        int max = Math.max(this.minTtl, (int) Math.min(this.maxTtl, j));
        List<DnsCacheEntry> cachedEntries = cachedEntries(str);
        DnsCacheEntry dnsCacheEntry = new DnsCacheEntry(str, inetAddress);
        synchronized (cachedEntries) {
            if (!cachedEntries.isEmpty()) {
                DnsCacheEntry dnsCacheEntry2 = cachedEntries.get(0);
                if (dnsCacheEntry2.cause() != null) {
                    dnsCacheEntry2.cancelExpiration();
                    cachedEntries.clear();
                }
            }
            cachedEntries.add(dnsCacheEntry);
        }
        scheduleCacheExpiration(cachedEntries, dnsCacheEntry, max, eventLoop);
    }

    @Override // io.netty.resolver.dns.DnsCache
    public void clear() {
        Iterator<Map.Entry<String, List<DnsCacheEntry>>> it = this.resolveCache.entrySet().iterator();
        while (it.hasNext()) {
            it.remove();
            cancelExpiration(it.next().getValue());
        }
    }

    @Override // io.netty.resolver.dns.DnsCache
    public List<DnsCacheEntry> get(String str) {
        ObjectUtil.checkNotNull(str, "hostname");
        return this.resolveCache.get(str);
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
        return "DefaultDnsCache(minTtl=" + this.minTtl + ", maxTtl=" + this.maxTtl + ", negativeTtl=" + this.negativeTtl + ", cached resolved hostname=" + this.resolveCache.size() + ")";
    }

    public DefaultDnsCache(int i, int i2, int i3) {
        this.resolveCache = PlatformDependent.newConcurrentHashMap();
        this.minTtl = ObjectUtil.checkPositiveOrZero(i, "minTtl");
        this.maxTtl = ObjectUtil.checkPositiveOrZero(i2, "maxTtl");
        if (i <= i2) {
            this.negativeTtl = ObjectUtil.checkPositiveOrZero(i3, "negativeTtl");
            return;
        }
        throw new IllegalArgumentException("minTtl: " + i + ", maxTtl: " + i2 + " (expected: 0 <= minTtl <= maxTtl)");
    }

    @Override // io.netty.resolver.dns.DnsCache
    public boolean clear(String str) {
        ObjectUtil.checkNotNull(str, "hostname");
        Iterator<Map.Entry<String, List<DnsCacheEntry>>> it = this.resolveCache.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Map.Entry<String, List<DnsCacheEntry>> next = it.next();
            if (next.getKey().equals(str)) {
                it.remove();
                cancelExpiration(next.getValue());
                z = true;
            }
        }
        return z;
    }

    @Override // io.netty.resolver.dns.DnsCache
    public void cache(String str, Throwable th, EventLoop eventLoop) {
        if (this.negativeTtl == 0) {
            return;
        }
        ObjectUtil.checkNotNull(str, "hostname");
        ObjectUtil.checkNotNull(th, "cause");
        ObjectUtil.checkNotNull(eventLoop, "loop");
        List<DnsCacheEntry> cachedEntries = cachedEntries(str);
        DnsCacheEntry dnsCacheEntry = new DnsCacheEntry(str, th);
        synchronized (cachedEntries) {
            int size = cachedEntries.size();
            for (int i = 0; i < size; i++) {
                cachedEntries.get(i).cancelExpiration();
            }
            cachedEntries.clear();
            cachedEntries.add(dnsCacheEntry);
        }
        scheduleCacheExpiration(cachedEntries, dnsCacheEntry, this.negativeTtl, eventLoop);
    }
}
