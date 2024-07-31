package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import java.net.InetAddress;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface DnsCache {
    void cache(String str, Throwable th, EventLoop eventLoop);

    void cache(String str, InetAddress inetAddress, long j, EventLoop eventLoop);

    void clear();

    boolean clear(String str);

    List<DnsCacheEntry> get(String str);
}
