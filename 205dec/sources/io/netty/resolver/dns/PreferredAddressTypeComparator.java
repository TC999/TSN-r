package io.netty.resolver.dns;

import io.netty.channel.socket.InternetProtocolFamily;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Comparator;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class PreferredAddressTypeComparator implements Comparator<InetAddress> {
    private static final PreferredAddressTypeComparator IPv4 = new PreferredAddressTypeComparator(Inet4Address.class);
    private static final PreferredAddressTypeComparator IPv6 = new PreferredAddressTypeComparator(Inet6Address.class);
    private final Class<? extends InetAddress> preferredAddressType;

    /* renamed from: io.netty.resolver.dns.PreferredAddressTypeComparator$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$channel$socket$InternetProtocolFamily;

        static {
            int[] iArr = new int[InternetProtocolFamily.values().length];
            $SwitchMap$io$netty$channel$socket$InternetProtocolFamily = iArr;
            try {
                iArr[InternetProtocolFamily.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$channel$socket$InternetProtocolFamily[InternetProtocolFamily.IPv6.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private PreferredAddressTypeComparator(Class<? extends InetAddress> cls) {
        this.preferredAddressType = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PreferredAddressTypeComparator comparator(InternetProtocolFamily internetProtocolFamily) {
        int i4 = AnonymousClass1.$SwitchMap$io$netty$channel$socket$InternetProtocolFamily[internetProtocolFamily.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                return IPv6;
            }
            throw new IllegalArgumentException();
        }
        return IPv4;
    }

    @Override // java.util.Comparator
    public int compare(InetAddress inetAddress, InetAddress inetAddress2) {
        if (inetAddress.getClass() == inetAddress2.getClass()) {
            return 0;
        }
        return this.preferredAddressType.isAssignableFrom(inetAddress.getClass()) ? -1 : 1;
    }
}
