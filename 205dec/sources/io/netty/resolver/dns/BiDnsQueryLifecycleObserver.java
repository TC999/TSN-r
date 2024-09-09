package io.netty.resolver.dns;

import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class BiDnsQueryLifecycleObserver implements DnsQueryLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    private final DnsQueryLifecycleObserver f54800a;

    /* renamed from: b  reason: collision with root package name */
    private final DnsQueryLifecycleObserver f54801b;

    public BiDnsQueryLifecycleObserver(DnsQueryLifecycleObserver dnsQueryLifecycleObserver, DnsQueryLifecycleObserver dnsQueryLifecycleObserver2) {
        this.f54800a = (DnsQueryLifecycleObserver) ObjectUtil.checkNotNull(dnsQueryLifecycleObserver, "a");
        this.f54801b = (DnsQueryLifecycleObserver) ObjectUtil.checkNotNull(dnsQueryLifecycleObserver2, "b");
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public DnsQueryLifecycleObserver queryCNAMEd(DnsQuestion dnsQuestion) {
        try {
            this.f54800a.queryCNAMEd(dnsQuestion);
            return this;
        } finally {
            this.f54801b.queryCNAMEd(dnsQuestion);
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void queryCancelled(int i4) {
        try {
            this.f54800a.queryCancelled(i4);
        } finally {
            this.f54801b.queryCancelled(i4);
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void queryFailed(Throwable th) {
        try {
            this.f54800a.queryFailed(th);
        } finally {
            this.f54801b.queryFailed(th);
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public DnsQueryLifecycleObserver queryNoAnswer(DnsResponseCode dnsResponseCode) {
        try {
            this.f54800a.queryNoAnswer(dnsResponseCode);
            return this;
        } finally {
            this.f54801b.queryNoAnswer(dnsResponseCode);
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public DnsQueryLifecycleObserver queryRedirected(List<InetSocketAddress> list) {
        try {
            this.f54800a.queryRedirected(list);
            return this;
        } finally {
            this.f54801b.queryRedirected(list);
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void querySucceed() {
        try {
            this.f54800a.querySucceed();
        } finally {
            this.f54801b.querySucceed();
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void queryWritten(InetSocketAddress inetSocketAddress, ChannelFuture channelFuture) {
        try {
            this.f54800a.queryWritten(inetSocketAddress, channelFuture);
        } finally {
            this.f54801b.queryWritten(inetSocketAddress, channelFuture);
        }
    }
}
