package io.netty.resolver.dns;

import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.util.internal.ObjectUtil;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class BiDnsQueryLifecycleObserverFactory implements DnsQueryLifecycleObserverFactory {

    /* renamed from: a  reason: collision with root package name */
    private final DnsQueryLifecycleObserverFactory f54802a;

    /* renamed from: b  reason: collision with root package name */
    private final DnsQueryLifecycleObserverFactory f54803b;

    public BiDnsQueryLifecycleObserverFactory(DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory, DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory2) {
        this.f54802a = (DnsQueryLifecycleObserverFactory) ObjectUtil.checkNotNull(dnsQueryLifecycleObserverFactory, "a");
        this.f54803b = (DnsQueryLifecycleObserverFactory) ObjectUtil.checkNotNull(dnsQueryLifecycleObserverFactory2, "b");
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserverFactory
    public DnsQueryLifecycleObserver newDnsQueryLifecycleObserver(DnsQuestion dnsQuestion) {
        return new BiDnsQueryLifecycleObserver(this.f54802a.newDnsQueryLifecycleObserver(dnsQuestion), this.f54803b.newDnsQueryLifecycleObserver(dnsQuestion));
    }
}
