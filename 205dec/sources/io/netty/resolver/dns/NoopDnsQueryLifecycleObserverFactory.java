package io.netty.resolver.dns;

import io.netty.handler.codec.dns.DnsQuestion;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class NoopDnsQueryLifecycleObserverFactory implements DnsQueryLifecycleObserverFactory {
    public static final NoopDnsQueryLifecycleObserverFactory INSTANCE = new NoopDnsQueryLifecycleObserverFactory();

    private NoopDnsQueryLifecycleObserverFactory() {
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserverFactory
    public DnsQueryLifecycleObserver newDnsQueryLifecycleObserver(DnsQuestion dnsQuestion) {
        return NoopDnsQueryLifecycleObserver.INSTANCE;
    }
}
