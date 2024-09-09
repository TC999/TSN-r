package io.netty.channel.socket;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public enum InternetProtocolFamily {
    IPv4(Inet4Address.class),
    IPv6(Inet6Address.class);
    
    private final Class<? extends InetAddress> addressType;

    InternetProtocolFamily(Class cls) {
        this.addressType = cls;
    }

    public Class<? extends InetAddress> addressType() {
        return this.addressType;
    }
}
