package io.netty.resolver.dns;

import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DnsNameResolverException extends RuntimeException {
    private static final long serialVersionUID = -8826717909627131850L;
    private final DnsQuestion question;
    private final InetSocketAddress remoteAddress;

    public DnsNameResolverException(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, String str) {
        super(str);
        this.remoteAddress = validateRemoteAddress(inetSocketAddress);
        this.question = validateQuestion(dnsQuestion);
    }

    private static DnsQuestion validateQuestion(DnsQuestion dnsQuestion) {
        return (DnsQuestion) ObjectUtil.checkNotNull(dnsQuestion, "question");
    }

    private static InetSocketAddress validateRemoteAddress(InetSocketAddress inetSocketAddress) {
        return (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress, "remoteAddress");
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(EmptyArrays.EMPTY_STACK_TRACE);
        return this;
    }

    public DnsQuestion question() {
        return this.question;
    }

    public InetSocketAddress remoteAddress() {
        return this.remoteAddress;
    }

    public DnsNameResolverException(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, String str, Throwable th) {
        super(str, th);
        this.remoteAddress = validateRemoteAddress(inetSocketAddress);
        this.question = validateQuestion(dnsQuestion);
    }
}
