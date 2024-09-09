package io.netty.resolver.dns;

import io.netty.util.internal.PlatformDependent;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class ShuffledDnsServerAddressStream implements DnsServerAddressStream {
    private final List<InetSocketAddress> addresses;

    /* renamed from: i  reason: collision with root package name */
    private int f54806i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShuffledDnsServerAddressStream(List<InetSocketAddress> list) {
        this.addresses = list;
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(this.addresses, PlatformDependent.threadLocalRandom());
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public InetSocketAddress next() {
        int i4 = this.f54806i;
        InetSocketAddress inetSocketAddress = this.addresses.get(i4);
        int i5 = i4 + 1;
        if (i5 < this.addresses.size()) {
            this.f54806i = i5;
        } else {
            this.f54806i = 0;
            shuffle();
        }
        return inetSocketAddress;
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public int size() {
        return this.addresses.size();
    }

    public String toString() {
        return SequentialDnsServerAddressStream.toString("shuffled", this.f54806i, this.addresses);
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStream
    public ShuffledDnsServerAddressStream duplicate() {
        return new ShuffledDnsServerAddressStream(this.addresses, this.f54806i);
    }

    private ShuffledDnsServerAddressStream(List<InetSocketAddress> list, int i4) {
        this.addresses = list;
        this.f54806i = i4;
    }
}
