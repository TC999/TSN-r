package io.netty.resolver.dns;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class DnsServerAddresses {
    @Deprecated
    public static List<InetSocketAddress> defaultAddressList() {
        return DefaultDnsServerAddressStreamProvider.defaultAddressList();
    }

    @Deprecated
    public static DnsServerAddresses defaultAddresses() {
        return DefaultDnsServerAddressStreamProvider.defaultAddresses();
    }

    public static DnsServerAddresses rotational(Iterable<? extends InetSocketAddress> iterable) {
        return rotational0(sanitize(iterable));
    }

    private static DnsServerAddresses rotational0(List<InetSocketAddress> list) {
        if (list.size() == 1) {
            return singleton(list.get(0));
        }
        return new RotationalDnsServerAddresses(list);
    }

    private static List<InetSocketAddress> sanitize(Iterable<? extends InetSocketAddress> iterable) {
        ArrayList arrayList;
        InetSocketAddress next;
        if (iterable != null) {
            if (iterable instanceof Collection) {
                arrayList = new ArrayList(((Collection) iterable).size());
            } else {
                arrayList = new ArrayList(4);
            }
            Iterator<? extends InetSocketAddress> it = iterable.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                if (!next.isUnresolved()) {
                    arrayList.add(next);
                } else {
                    throw new IllegalArgumentException("cannot use an unresolved DNS server address: " + next);
                }
            }
            if (arrayList.isEmpty()) {
                throw new IllegalArgumentException("empty addresses");
            }
            return arrayList;
        }
        throw new NullPointerException("addresses");
    }

    public static DnsServerAddresses sequential(Iterable<? extends InetSocketAddress> iterable) {
        return sequential0(sanitize(iterable));
    }

    private static DnsServerAddresses sequential0(List<InetSocketAddress> list) {
        if (list.size() == 1) {
            return singleton(list.get(0));
        }
        return new DefaultDnsServerAddresses("sequential", list) { // from class: io.netty.resolver.dns.DnsServerAddresses.1
            @Override // io.netty.resolver.dns.DnsServerAddresses
            public DnsServerAddressStream stream() {
                return new SequentialDnsServerAddressStream(this.addresses, 0);
            }
        };
    }

    public static DnsServerAddresses shuffled(Iterable<? extends InetSocketAddress> iterable) {
        return shuffled0(sanitize(iterable));
    }

    private static DnsServerAddresses shuffled0(List<InetSocketAddress> list) {
        if (list.size() == 1) {
            return singleton(list.get(0));
        }
        return new DefaultDnsServerAddresses("shuffled", list) { // from class: io.netty.resolver.dns.DnsServerAddresses.2
            @Override // io.netty.resolver.dns.DnsServerAddresses
            public DnsServerAddressStream stream() {
                return new ShuffledDnsServerAddressStream(this.addresses);
            }
        };
    }

    public static DnsServerAddresses singleton(InetSocketAddress inetSocketAddress) {
        if (inetSocketAddress != null) {
            if (!inetSocketAddress.isUnresolved()) {
                return new SingletonDnsServerAddresses(inetSocketAddress);
            }
            throw new IllegalArgumentException("cannot use an unresolved DNS server address: " + inetSocketAddress);
        }
        throw new NullPointerException("address");
    }

    public abstract DnsServerAddressStream stream();

    public static DnsServerAddresses rotational(InetSocketAddress... inetSocketAddressArr) {
        return rotational0(sanitize(inetSocketAddressArr));
    }

    public static DnsServerAddresses sequential(InetSocketAddress... inetSocketAddressArr) {
        return sequential0(sanitize(inetSocketAddressArr));
    }

    public static DnsServerAddresses shuffled(InetSocketAddress... inetSocketAddressArr) {
        return shuffled0(sanitize(inetSocketAddressArr));
    }

    private static List<InetSocketAddress> sanitize(InetSocketAddress[] inetSocketAddressArr) {
        if (inetSocketAddressArr != null) {
            ArrayList arrayList = new ArrayList(inetSocketAddressArr.length);
            for (InetSocketAddress inetSocketAddress : inetSocketAddressArr) {
                if (inetSocketAddress == null) {
                    break;
                } else if (!inetSocketAddress.isUnresolved()) {
                    arrayList.add(inetSocketAddress);
                } else {
                    throw new IllegalArgumentException("cannot use an unresolved DNS server address: " + inetSocketAddress);
                }
            }
            return arrayList.isEmpty() ? DefaultDnsServerAddressStreamProvider.defaultAddressList() : arrayList;
        }
        throw new NullPointerException("addresses");
    }
}
