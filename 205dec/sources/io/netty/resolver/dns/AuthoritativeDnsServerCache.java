package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import java.net.InetSocketAddress;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface AuthoritativeDnsServerCache {
    void cache(String str, InetSocketAddress inetSocketAddress, long j4, EventLoop eventLoop);

    void clear();

    boolean clear(String str);

    DnsServerAddressStream get(String str);
}
