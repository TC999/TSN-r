package io.netty.resolver.dns;

import java.net.InetSocketAddress;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface DnsServerAddressStream {
    DnsServerAddressStream duplicate();

    InetSocketAddress next();

    int size();
}
