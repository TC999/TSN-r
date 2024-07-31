package io.netty.resolver.dns;

import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class DnsServerAddresses {
    private static final DnsServerAddresses DEFAULT_NAME_SERVERS;
    private static final InetSocketAddress[] DEFAULT_NAME_SERVER_ARRAY;
    private static final List<InetSocketAddress> DEFAULT_NAME_SERVER_LIST;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DnsServerAddresses.class);

    static {
        ArrayList arrayList = new ArrayList(2);
        try {
            Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
            for (String str : (List) cls.getMethod("nameservers", new Class[0]).invoke(cls.getMethod("open", new Class[0]).invoke(null, new Object[0]), new Object[0])) {
                if (str != null) {
                    arrayList.add(new InetSocketAddress(InetAddress.getByName(str), 53));
                }
            }
        } catch (Exception unused) {
        }
        if (!arrayList.isEmpty()) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Default DNS servers: {} (sun.net.dns.ResolverConfiguration)", arrayList);
            }
        } else {
            Collections.addAll(arrayList, new InetSocketAddress("8.8.8.8", 53), new InetSocketAddress("8.8.4.4", 53));
            InternalLogger internalLogger2 = logger;
            if (internalLogger2.isWarnEnabled()) {
                internalLogger2.warn("Default DNS servers: {} (Google Public DNS as a fallback)", arrayList);
            }
        }
        DEFAULT_NAME_SERVER_LIST = Collections.unmodifiableList(arrayList);
        InetSocketAddress[] inetSocketAddressArr = (InetSocketAddress[]) arrayList.toArray(new InetSocketAddress[arrayList.size()]);
        DEFAULT_NAME_SERVER_ARRAY = inetSocketAddressArr;
        DEFAULT_NAME_SERVERS = sequential(inetSocketAddressArr);
    }

    public static List<InetSocketAddress> defaultAddressList() {
        return DEFAULT_NAME_SERVER_LIST;
    }

    public static DnsServerAddresses defaultAddresses() {
        return DEFAULT_NAME_SERVERS;
    }

    public static DnsServerAddresses rotational(Iterable<? extends InetSocketAddress> iterable) {
        return rotational0(sanitize(iterable));
    }

    private static DnsServerAddresses rotational0(InetSocketAddress[] inetSocketAddressArr) {
        if (inetSocketAddressArr.length == 1) {
            return singleton(inetSocketAddressArr[0]);
        }
        return new RotationalDnsServerAddresses(inetSocketAddressArr);
    }

    private static InetSocketAddress[] sanitize(Iterable<? extends InetSocketAddress> iterable) {
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
            if (!arrayList.isEmpty()) {
                return (InetSocketAddress[]) arrayList.toArray(new InetSocketAddress[arrayList.size()]);
            }
            throw new IllegalArgumentException("empty addresses");
        }
        throw new NullPointerException("addresses");
    }

    public static DnsServerAddresses sequential(Iterable<? extends InetSocketAddress> iterable) {
        return sequential0(sanitize(iterable));
    }

    private static DnsServerAddresses sequential0(InetSocketAddress... inetSocketAddressArr) {
        if (inetSocketAddressArr.length == 1) {
            return singleton(inetSocketAddressArr[0]);
        }
        return new DefaultDnsServerAddresses("sequential", inetSocketAddressArr) { // from class: io.netty.resolver.dns.DnsServerAddresses.1
            @Override // io.netty.resolver.dns.DnsServerAddresses
            public DnsServerAddressStream stream() {
                return new SequentialDnsServerAddressStream(this.addresses, 0);
            }
        };
    }

    public static DnsServerAddresses shuffled(Iterable<? extends InetSocketAddress> iterable) {
        return shuffled0(sanitize(iterable));
    }

    private static DnsServerAddresses shuffled0(InetSocketAddress[] inetSocketAddressArr) {
        if (inetSocketAddressArr.length == 1) {
            return singleton(inetSocketAddressArr[0]);
        }
        return new DefaultDnsServerAddresses("shuffled", inetSocketAddressArr) { // from class: io.netty.resolver.dns.DnsServerAddresses.2
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

    private static InetSocketAddress[] sanitize(InetSocketAddress[] inetSocketAddressArr) {
        if (inetSocketAddressArr != null) {
            ArrayList arrayList = InternalThreadLocalMap.get().arrayList(inetSocketAddressArr.length);
            for (InetSocketAddress inetSocketAddress : inetSocketAddressArr) {
                if (inetSocketAddress == null) {
                    break;
                } else if (!inetSocketAddress.isUnresolved()) {
                    arrayList.add(inetSocketAddress);
                } else {
                    throw new IllegalArgumentException("cannot use an unresolved DNS server address: " + inetSocketAddress);
                }
            }
            if (arrayList.isEmpty()) {
                return DEFAULT_NAME_SERVER_ARRAY;
            }
            return (InetSocketAddress[]) arrayList.toArray(new InetSocketAddress[arrayList.size()]);
        }
        throw new NullPointerException("addresses");
    }
}
