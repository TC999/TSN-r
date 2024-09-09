package io.netty.resolver.dns;

import io.netty.handler.codec.dns.DnsQuestion;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface DnsQueryLifecycleObserverFactory {
    DnsQueryLifecycleObserver newDnsQueryLifecycleObserver(DnsQuestion dnsQuestion);
}
