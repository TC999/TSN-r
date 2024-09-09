package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class DefaultDnsCnameCache implements DnsCnameCache {
    private final Cache<String> cache;
    private final int maxTtl;
    private final int minTtl;

    public DefaultDnsCnameCache() {
        this(0, Cache.MAX_SUPPORTED_TTL_SECS);
    }

    @Override // io.netty.resolver.dns.DnsCnameCache
    public void cache(String str, String str2, long j4, EventLoop eventLoop) {
        ObjectUtil.checkNotNull(str, "hostname");
        ObjectUtil.checkNotNull(str2, "cname");
        ObjectUtil.checkNotNull(eventLoop, "loop");
        this.cache.cache(str, str2, Math.max(this.minTtl, (int) Math.min(this.maxTtl, j4)), eventLoop);
    }

    @Override // io.netty.resolver.dns.DnsCnameCache
    public void clear() {
        this.cache.clear();
    }

    @Override // io.netty.resolver.dns.DnsCnameCache
    public String get(String str) {
        ObjectUtil.checkNotNull(str, "hostname");
        List<? extends String> list = this.cache.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public DefaultDnsCnameCache(int i4, int i5) {
        this.cache = new Cache<String>() { // from class: io.netty.resolver.dns.DefaultDnsCnameCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.resolver.dns.Cache
            public boolean shouldReplaceAll(String str) {
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.resolver.dns.Cache
            public boolean equals(String str, String str2) {
                return AsciiString.contentEqualsIgnoreCase(str, str2);
            }
        };
        int i6 = Cache.MAX_SUPPORTED_TTL_SECS;
        this.minTtl = Math.min(i6, ObjectUtil.checkPositiveOrZero(i4, "minTtl"));
        this.maxTtl = Math.min(i6, ObjectUtil.checkPositive(i5, "maxTtl"));
        if (i4 <= i5) {
            return;
        }
        throw new IllegalArgumentException("minTtl: " + i4 + ", maxTtl: " + i5 + " (expected: 0 <= minTtl <= maxTtl)");
    }

    @Override // io.netty.resolver.dns.DnsCnameCache
    public boolean clear(String str) {
        ObjectUtil.checkNotNull(str, "hostname");
        return this.cache.clear(str);
    }
}
