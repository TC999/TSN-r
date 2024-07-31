package io.netty.resolver.dns;

import java.net.InetSocketAddress;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class SequentialDnsServerAddressStream implements DnsServerAddressStream {
    private final InetSocketAddress[] addresses;

    /* renamed from: i */
    private int f40290i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SequentialDnsServerAddressStream(InetSocketAddress[] inetSocketAddressArr, int i) {
        this.addresses = inetSocketAddressArr;
        this.f40290i = i;
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public InetSocketAddress next() {
        int i = this.f40290i;
        InetSocketAddress[] inetSocketAddressArr = this.addresses;
        InetSocketAddress inetSocketAddress = inetSocketAddressArr[i];
        int i2 = i + 1;
        if (i2 < inetSocketAddressArr.length) {
            this.f40290i = i2;
        } else {
            this.f40290i = 0;
        }
        return inetSocketAddress;
    }

    public String toString() {
        return toString("sequential", this.f40290i, this.addresses);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toString(String str, int i, InetSocketAddress[] inetSocketAddressArr) {
        StringBuilder sb = new StringBuilder(str.length() + 2 + (inetSocketAddressArr.length * 16));
        sb.append(str);
        sb.append("(index: ");
        sb.append(i);
        sb.append(", addrs: (");
        for (InetSocketAddress inetSocketAddress : inetSocketAddressArr) {
            sb.append(inetSocketAddress);
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("))");
        return sb.toString();
    }
}
