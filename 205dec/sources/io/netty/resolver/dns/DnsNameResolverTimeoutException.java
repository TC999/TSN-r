package io.netty.resolver.dns;

import io.netty.handler.codec.dns.DnsQuestion;
import java.net.InetSocketAddress;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class DnsNameResolverTimeoutException extends DnsNameResolverException {
    private static final long serialVersionUID = -8826717969627131854L;

    public DnsNameResolverTimeoutException(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, String str) {
        super(inetSocketAddress, dnsQuestion, str);
    }
}
