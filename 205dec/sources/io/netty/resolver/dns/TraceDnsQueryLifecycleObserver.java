package io.netty.resolver.dns;

import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogLevel;
import io.netty.util.internal.logging.InternalLogger;
import java.net.InetSocketAddress;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class TraceDnsQueryLifecycleObserver implements DnsQueryLifecycleObserver {
    private InetSocketAddress dnsServerAddress;
    private final InternalLogLevel level;
    private final InternalLogger logger;
    private final DnsQuestion question;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TraceDnsQueryLifecycleObserver(DnsQuestion dnsQuestion, InternalLogger internalLogger, InternalLogLevel internalLogLevel) {
        this.question = (DnsQuestion) ObjectUtil.checkNotNull(dnsQuestion, "question");
        this.logger = (InternalLogger) ObjectUtil.checkNotNull(internalLogger, "logger");
        this.level = (InternalLogLevel) ObjectUtil.checkNotNull(internalLogLevel, "level");
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public DnsQueryLifecycleObserver queryCNAMEd(DnsQuestion dnsQuestion) {
        this.logger.log(this.level, "from {} : {} CNAME question {}", this.dnsServerAddress, this.question, dnsQuestion);
        return this;
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void queryCancelled(int i4) {
        InetSocketAddress inetSocketAddress = this.dnsServerAddress;
        if (inetSocketAddress != null) {
            this.logger.log(this.level, "from {} : {} cancelled with {} queries remaining", inetSocketAddress, this.question, Integer.valueOf(i4));
        } else {
            this.logger.log(this.level, "{} query never written and cancelled with {} queries remaining", this.question, Integer.valueOf(i4));
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void queryFailed(Throwable th) {
        InetSocketAddress inetSocketAddress = this.dnsServerAddress;
        if (inetSocketAddress != null) {
            this.logger.log(this.level, "from {} : {} failure", inetSocketAddress, this.question, th);
        } else {
            this.logger.log(this.level, "{} query never written and failed", this.question, th);
        }
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public DnsQueryLifecycleObserver queryNoAnswer(DnsResponseCode dnsResponseCode) {
        this.logger.log(this.level, "from {} : {} no answer {}", this.dnsServerAddress, this.question, dnsResponseCode);
        return this;
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public DnsQueryLifecycleObserver queryRedirected(List<InetSocketAddress> list) {
        this.logger.log(this.level, "from {} : {} redirected", this.dnsServerAddress, this.question);
        return this;
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void querySucceed() {
    }

    @Override // io.netty.resolver.dns.DnsQueryLifecycleObserver
    public void queryWritten(InetSocketAddress inetSocketAddress, ChannelFuture channelFuture) {
        this.dnsServerAddress = inetSocketAddress;
    }
}
