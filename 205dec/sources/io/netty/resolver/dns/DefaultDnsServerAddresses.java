package io.netty.resolver.dns;

import java.net.InetSocketAddress;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class DefaultDnsServerAddresses extends DnsServerAddresses {
    protected final List<InetSocketAddress> addresses;
    private final String strVal;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultDnsServerAddresses(String str, List<InetSocketAddress> list) {
        this.addresses = list;
        StringBuilder sb = new StringBuilder(str.length() + 2 + (list.size() * 16));
        sb.append(str);
        sb.append('(');
        for (InetSocketAddress inetSocketAddress : list) {
            sb.append(inetSocketAddress);
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(')');
        this.strVal = sb.toString();
    }

    public String toString() {
        return this.strVal;
    }
}
