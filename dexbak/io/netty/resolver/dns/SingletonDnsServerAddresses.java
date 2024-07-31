package io.netty.resolver.dns;

import java.net.InetSocketAddress;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class SingletonDnsServerAddresses extends DnsServerAddresses {
    private final InetSocketAddress address;
    private final String strVal;
    private final DnsServerAddressStream stream = new DnsServerAddressStream() { // from class: io.netty.resolver.dns.SingletonDnsServerAddresses.1
        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public InetSocketAddress next() {
            return SingletonDnsServerAddresses.this.address;
        }

        public String toString() {
            return SingletonDnsServerAddresses.this.toString();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingletonDnsServerAddresses(InetSocketAddress inetSocketAddress) {
        this.address = inetSocketAddress;
        StringBuilder sb = new StringBuilder(32);
        sb.append("singleton(");
        sb.append(inetSocketAddress);
        sb.append(')');
        this.strVal = sb.toString();
    }

    @Override // io.netty.resolver.dns.DnsServerAddresses
    public DnsServerAddressStream stream() {
        return this.stream;
    }

    public String toString() {
        return this.strVal;
    }
}
