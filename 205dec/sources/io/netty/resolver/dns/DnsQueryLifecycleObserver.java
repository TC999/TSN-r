package io.netty.resolver.dns;

import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsResponseCode;
import java.net.InetSocketAddress;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface DnsQueryLifecycleObserver {
    DnsQueryLifecycleObserver queryCNAMEd(DnsQuestion dnsQuestion);

    void queryCancelled(int i4);

    void queryFailed(Throwable th);

    DnsQueryLifecycleObserver queryNoAnswer(DnsResponseCode dnsResponseCode);

    DnsQueryLifecycleObserver queryRedirected(List<InetSocketAddress> list);

    void querySucceed();

    void queryWritten(InetSocketAddress inetSocketAddress, ChannelFuture channelFuture);
}
