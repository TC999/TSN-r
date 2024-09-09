package io.netty.resolver.dns;

import java.net.InetSocketAddress;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class SequentialDnsServerAddressStreamProvider extends UniSequentialDnsServerAddressStreamProvider {
    public SequentialDnsServerAddressStreamProvider(InetSocketAddress... inetSocketAddressArr) {
        super(DnsServerAddresses.sequential(inetSocketAddressArr));
    }

    public SequentialDnsServerAddressStreamProvider(Iterable<? extends InetSocketAddress> iterable) {
        super(DnsServerAddresses.sequential(iterable));
    }
}
