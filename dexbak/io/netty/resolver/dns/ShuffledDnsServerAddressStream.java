package io.netty.resolver.dns;

import io.netty.util.internal.ThreadLocalRandom;
import java.net.InetSocketAddress;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class ShuffledDnsServerAddressStream implements DnsServerAddressStream {
    private final InetSocketAddress[] addresses;

    /* renamed from: i */
    private int f40291i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShuffledDnsServerAddressStream(InetSocketAddress[] inetSocketAddressArr) {
        this.addresses = (InetSocketAddress[]) inetSocketAddressArr.clone();
        shuffle();
    }

    private void shuffle() {
        InetSocketAddress[] inetSocketAddressArr = this.addresses;
        ThreadLocalRandom current = ThreadLocalRandom.current();
        for (int length = inetSocketAddressArr.length - 1; length >= 0; length--) {
            InetSocketAddress inetSocketAddress = inetSocketAddressArr[length];
            int nextInt = current.nextInt(length + 1);
            inetSocketAddressArr[length] = inetSocketAddressArr[nextInt];
            inetSocketAddressArr[nextInt] = inetSocketAddress;
        }
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public InetSocketAddress next() {
        int i = this.f40291i;
        InetSocketAddress[] inetSocketAddressArr = this.addresses;
        InetSocketAddress inetSocketAddress = inetSocketAddressArr[i];
        int i2 = i + 1;
        if (i2 < inetSocketAddressArr.length) {
            this.f40291i = i2;
        } else {
            this.f40291i = 0;
            shuffle();
        }
        return inetSocketAddress;
    }

    public String toString() {
        return SequentialDnsServerAddressStream.toString("shuffled", this.f40291i, this.addresses);
    }
}
