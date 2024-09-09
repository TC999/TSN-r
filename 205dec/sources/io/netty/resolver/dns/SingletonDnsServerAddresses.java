package io.netty.resolver.dns;

import java.net.InetSocketAddress;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class SingletonDnsServerAddresses extends DnsServerAddresses {
    private final InetSocketAddress address;
    private final DnsServerAddressStream stream = new DnsServerAddressStream() { // from class: io.netty.resolver.dns.SingletonDnsServerAddresses.1
        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public DnsServerAddressStream duplicate() {
            return this;
        }

        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public InetSocketAddress next() {
            return SingletonDnsServerAddresses.this.address;
        }

        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public int size() {
            return 1;
        }

        public String toString() {
            return SingletonDnsServerAddresses.this.toString();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingletonDnsServerAddresses(InetSocketAddress inetSocketAddress) {
        this.address = inetSocketAddress;
    }

    @Override // io.netty.resolver.dns.DnsServerAddresses
    public DnsServerAddressStream stream() {
        return this.stream;
    }

    public String toString() {
        return "singleton(" + this.address + ")";
    }
}
