package io.netty.resolver.dns;

import io.netty.util.internal.ObjectUtil;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
abstract class UniSequentialDnsServerAddressStreamProvider implements DnsServerAddressStreamProvider {
    private final DnsServerAddresses addresses;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UniSequentialDnsServerAddressStreamProvider(DnsServerAddresses dnsServerAddresses) {
        this.addresses = (DnsServerAddresses) ObjectUtil.checkNotNull(dnsServerAddresses, "addresses");
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStreamProvider
    public final DnsServerAddressStream nameServerAddressStream(String str) {
        return this.addresses.stream();
    }
}
