package io.netty.resolver.dns;

import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.dns.AbstractDnsOptPseudoRrRecord;
import io.netty.handler.codec.dns.DnsQuery;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.handler.codec.dns.DnsSection;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class DnsQueryContext implements FutureListener<AddressedEnvelope<DnsResponse, InetSocketAddress>> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DnsQueryContext.class);
    private final DnsRecord[] additionals;
    private final int id;
    private final InetSocketAddress nameServerAddr;
    private final DnsRecord optResource;
    private final DnsNameResolver parent;
    private final Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> promise;
    private final DnsQuestion question;
    private final boolean recursionDesired;
    private volatile ScheduledFuture<?> timeoutFuture;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DnsQueryContext(DnsNameResolver dnsNameResolver, InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, DnsRecord[] dnsRecordArr, Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> promise) {
        this.parent = (DnsNameResolver) ObjectUtil.checkNotNull(dnsNameResolver, "parent");
        this.nameServerAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress, "nameServerAddr");
        this.question = (DnsQuestion) ObjectUtil.checkNotNull(dnsQuestion, "question");
        this.additionals = (DnsRecord[]) ObjectUtil.checkNotNull(dnsRecordArr, "additionals");
        this.promise = (Promise) ObjectUtil.checkNotNull(promise, "promise");
        this.recursionDesired = dnsNameResolver.isRecursionDesired();
        this.id = dnsNameResolver.queryContextManager.add(this);
        promise.addListener((GenericFutureListener<? extends Future<? super AddressedEnvelope<DnsResponse, InetSocketAddress>>>) this);
        if (dnsNameResolver.isOptResourceEnabled()) {
            this.optResource = new AbstractDnsOptPseudoRrRecord(dnsNameResolver.maxPayloadSize(), 0, 0) { // from class: io.netty.resolver.dns.DnsQueryContext.1
            };
        } else {
            this.optResource = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onQueryWriteCompletion(ChannelFuture channelFuture) {
        if (!channelFuture.isSuccess()) {
            setFailure("failed to send a query via " + protocol(), channelFuture.cause());
            return;
        }
        final long queryTimeoutMillis = this.parent.queryTimeoutMillis();
        if (queryTimeoutMillis > 0) {
            this.timeoutFuture = this.parent.ch.eventLoop().schedule(new Runnable() { // from class: io.netty.resolver.dns.DnsQueryContext.4
                @Override // java.lang.Runnable
                public void run() {
                    if (DnsQueryContext.this.promise.isDone()) {
                        return;
                    }
                    DnsQueryContext dnsQueryContext = DnsQueryContext.this;
                    dnsQueryContext.setFailure("query via " + DnsQueryContext.this.protocol() + " timed out after " + queryTimeoutMillis + " milliseconds", null);
                }
            }, queryTimeoutMillis, TimeUnit.MILLISECONDS);
        }
    }

    private void sendQuery(final DnsQuery dnsQuery, boolean z3, final ChannelPromise channelPromise) {
        if (this.parent.channelFuture.isDone()) {
            writeQuery(dnsQuery, z3, channelPromise);
        } else {
            this.parent.channelFuture.addListener(new GenericFutureListener<Future<? super Channel>>() { // from class: io.netty.resolver.dns.DnsQueryContext.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<? super Channel> future) {
                    if (future.isSuccess()) {
                        DnsQueryContext.this.writeQuery(dnsQuery, true, channelPromise);
                        return;
                    }
                    Throwable cause = future.cause();
                    DnsQueryContext.this.promise.tryFailure(cause);
                    channelPromise.setFailure(cause);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFailure(String str, Throwable th) {
        Throwable dnsNameResolverException;
        InetSocketAddress nameServerAddr = nameServerAddr();
        StringBuilder sb = new StringBuilder(str.length() + 64);
        sb.append('[');
        sb.append(nameServerAddr);
        sb.append("] ");
        sb.append(str);
        sb.append(" (no stack trace available)");
        if (th == null) {
            dnsNameResolverException = new DnsNameResolverTimeoutException(nameServerAddr, question(), sb.toString());
        } else {
            dnsNameResolverException = new DnsNameResolverException(nameServerAddr, question(), sb.toString(), th);
        }
        this.promise.tryFailure(dnsNameResolverException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setSuccess(AddressedEnvelope<? extends DnsResponse, InetSocketAddress> addressedEnvelope) {
        if (this.promise.trySuccess(addressedEnvelope.retain())) {
            return;
        }
        addressedEnvelope.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeQuery(DnsQuery dnsQuery, boolean z3, ChannelPromise channelPromise) {
        final ChannelFuture write;
        if (z3) {
            write = channel().writeAndFlush(dnsQuery, channelPromise);
        } else {
            write = channel().write(dnsQuery, channelPromise);
        }
        if (write.isDone()) {
            onQueryWriteCompletion(write);
        } else {
            write.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.resolver.dns.DnsQueryContext.3
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) {
                    DnsQueryContext.this.onQueryWriteCompletion(write);
                }
            });
        }
    }

    protected abstract Channel channel();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void finish(AddressedEnvelope<? extends DnsResponse, InetSocketAddress> addressedEnvelope) {
        DnsResponse content = addressedEnvelope.content();
        DnsSection dnsSection = DnsSection.QUESTION;
        if (content.count(dnsSection) != 1) {
            logger.warn("Received a DNS response with invalid number of questions: {}", addressedEnvelope);
        } else if (!question().equals(content.recordAt(dnsSection))) {
            logger.warn("Received a mismatching DNS response: {}", addressedEnvelope);
        } else {
            setSuccess(addressedEnvelope);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InetSocketAddress nameServerAddr() {
        return this.nameServerAddr;
    }

    protected abstract DnsQuery newQuery(int i4);

    @Override // io.netty.util.concurrent.GenericFutureListener
    public void operationComplete(Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> future) {
        ScheduledFuture<?> scheduledFuture = this.timeoutFuture;
        if (scheduledFuture != null) {
            this.timeoutFuture = null;
            scheduledFuture.cancel(false);
        }
        this.parent.queryContextManager.remove(this.nameServerAddr, this.id);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DnsNameResolver parent() {
        return this.parent;
    }

    protected abstract String protocol();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void query(boolean z3, ChannelPromise channelPromise) {
        DnsQuestion question = question();
        InetSocketAddress nameServerAddr = nameServerAddr();
        DnsQuery newQuery = newQuery(this.id);
        newQuery.setRecursionDesired(this.recursionDesired);
        newQuery.addRecord(DnsSection.QUESTION, (DnsRecord) question);
        for (DnsRecord dnsRecord : this.additionals) {
            newQuery.addRecord(DnsSection.ADDITIONAL, dnsRecord);
        }
        DnsRecord dnsRecord2 = this.optResource;
        if (dnsRecord2 != null) {
            newQuery.addRecord(DnsSection.ADDITIONAL, dnsRecord2);
        }
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} WRITE: {}, [{}: {}], {}", channel(), protocol(), Integer.valueOf(this.id), nameServerAddr, question);
        }
        sendQuery(newQuery, z3, channelPromise);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DnsQuestion question() {
        return this.question;
    }
}
