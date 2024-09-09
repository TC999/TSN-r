package io.netty.resolver.dns;

import java.util.List;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class MultiDnsServerAddressStreamProvider implements DnsServerAddressStreamProvider {
    private final DnsServerAddressStreamProvider[] providers;

    public MultiDnsServerAddressStreamProvider(List<DnsServerAddressStreamProvider> list) {
        this.providers = (DnsServerAddressStreamProvider[]) list.toArray(new DnsServerAddressStreamProvider[0]);
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStreamProvider
    public DnsServerAddressStream nameServerAddressStream(String str) {
        for (DnsServerAddressStreamProvider dnsServerAddressStreamProvider : this.providers) {
            DnsServerAddressStream nameServerAddressStream = dnsServerAddressStreamProvider.nameServerAddressStream(str);
            if (nameServerAddressStream != null) {
                return nameServerAddressStream;
            }
        }
        return null;
    }

    public MultiDnsServerAddressStreamProvider(DnsServerAddressStreamProvider... dnsServerAddressStreamProviderArr) {
        this.providers = (DnsServerAddressStreamProvider[]) dnsServerAddressStreamProviderArr.clone();
    }
}
