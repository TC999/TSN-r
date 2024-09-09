package io.netty.resolver.dns;

import io.netty.channel.EventLoop;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class NoopDnsCnameCache implements DnsCnameCache {
    public static final NoopDnsCnameCache INSTANCE = new NoopDnsCnameCache();

    private NoopDnsCnameCache() {
    }

    @Override // io.netty.resolver.dns.DnsCnameCache
    public void cache(String str, String str2, long j4, EventLoop eventLoop) {
    }

    @Override // io.netty.resolver.dns.DnsCnameCache
    public void clear() {
    }

    @Override // io.netty.resolver.dns.DnsCnameCache
    public boolean clear(String str) {
        return false;
    }

    @Override // io.netty.resolver.dns.DnsCnameCache
    public String get(String str) {
        return null;
    }
}
