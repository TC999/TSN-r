package io.netty.resolver.dns;

import io.netty.util.internal.PlatformDependent;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class RotationalDnsServerAddresses extends DefaultDnsServerAddresses {
    private static final AtomicIntegerFieldUpdater<RotationalDnsServerAddresses> startIdxUpdater;
    private volatile int startIdx;

    static {
        AtomicIntegerFieldUpdater<RotationalDnsServerAddresses> newAtomicIntegerFieldUpdater = PlatformDependent.newAtomicIntegerFieldUpdater(RotationalDnsServerAddresses.class, "startIdx");
        if (newAtomicIntegerFieldUpdater == null) {
            newAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(RotationalDnsServerAddresses.class, "startIdx");
        }
        startIdxUpdater = newAtomicIntegerFieldUpdater;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RotationalDnsServerAddresses(InetSocketAddress[] inetSocketAddressArr) {
        super("rotational", inetSocketAddressArr);
    }

    @Override // io.netty.resolver.dns.DnsServerAddresses
    public DnsServerAddressStream stream() {
        int i;
        int i2;
        do {
            i = this.startIdx;
            i2 = i + 1;
            if (i2 >= this.addresses.length) {
                i2 = 0;
            }
        } while (!startIdxUpdater.compareAndSet(this, i, i2));
        return new SequentialDnsServerAddressStream(this.addresses, i);
    }
}
