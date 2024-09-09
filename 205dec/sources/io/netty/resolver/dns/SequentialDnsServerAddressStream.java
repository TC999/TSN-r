package io.netty.resolver.dns;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class SequentialDnsServerAddressStream implements DnsServerAddressStream {
    private final List<? extends InetSocketAddress> addresses;

    /* renamed from: i  reason: collision with root package name */
    private int f54805i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SequentialDnsServerAddressStream(List<? extends InetSocketAddress> list, int i4) {
        this.addresses = list;
        this.f54805i = i4;
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public InetSocketAddress next() {
        int i4 = this.f54805i;
        InetSocketAddress inetSocketAddress = this.addresses.get(i4);
        int i5 = i4 + 1;
        if (i5 < this.addresses.size()) {
            this.f54805i = i5;
        } else {
            this.f54805i = 0;
        }
        return inetSocketAddress;
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public int size() {
        return this.addresses.size();
    }

    public String toString() {
        return toString("sequential", this.f54805i, this.addresses);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toString(String str, int i4, Collection<? extends InetSocketAddress> collection) {
        StringBuilder sb = new StringBuilder(str.length() + 2 + (collection.size() * 16));
        sb.append(str);
        sb.append("(index: ");
        sb.append(i4);
        sb.append(", addrs: (");
        for (InetSocketAddress inetSocketAddress : collection) {
            sb.append(inetSocketAddress);
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("))");
        return sb.toString();
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public SequentialDnsServerAddressStream duplicate() {
        return new SequentialDnsServerAddressStream(this.addresses, this.f54805i);
    }
}
