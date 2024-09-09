package io.netty.resolver.dns;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class RotationalDnsServerAddresses extends DefaultDnsServerAddresses {
    private static final AtomicIntegerFieldUpdater<RotationalDnsServerAddresses> startIdxUpdater = AtomicIntegerFieldUpdater.newUpdater(RotationalDnsServerAddresses.class, "startIdx");
    private volatile int startIdx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RotationalDnsServerAddresses(List<InetSocketAddress> list) {
        super("rotational", list);
    }

    @Override // io.netty.resolver.dns.DnsServerAddresses
    public DnsServerAddressStream stream() {
        int i4;
        int i5;
        do {
            i4 = this.startIdx;
            i5 = i4 + 1;
            if (i5 >= this.addresses.size()) {
                i5 = 0;
            }
        } while (!startIdxUpdater.compareAndSet(this, i4, i5));
        return new SequentialDnsServerAddressStream(this.addresses, i4);
    }
}
