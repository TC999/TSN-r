package io.netty.resolver.dns;

import java.net.InetSocketAddress;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class SingletonDnsServerAddressStreamProvider extends UniSequentialDnsServerAddressStreamProvider {
    public SingletonDnsServerAddressStreamProvider(InetSocketAddress inetSocketAddress) {
        super(DnsServerAddresses.singleton(inetSocketAddress));
    }
}
