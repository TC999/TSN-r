package io.netty.resolver.dns;

import io.netty.buffer.Unpooled;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.handler.codec.dns.DatagramDnsQuery;
import io.netty.handler.codec.dns.DefaultDnsRawRecord;
import io.netty.handler.codec.dns.DnsQuery;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.handler.codec.dns.DnsSection;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class DnsQueryContext {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DnsQueryContext.class);
    private final Iterable<DnsRecord> additional;

    /* renamed from: id */
    private final int f40289id;
    private final InetSocketAddress nameServerAddr;
    private final DnsRecord optResource;
    private final DnsNameResolver parent;
    private final Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> promise;
    private final DnsQuestion question;
    private final boolean recursionDesired;
    private volatile ScheduledFuture<?> timeoutFuture;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DnsQueryContext(DnsNameResolver dnsNameResolver, InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable, Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> promise) {
        this.parent = (DnsNameResolver) ObjectUtil.checkNotNull(dnsNameResolver, "parent");
        this.nameServerAddr = (InetSocketAddress) ObjectUtil.checkNotNull(inetSocketAddress, "nameServerAddr");
        this.question = (DnsQuestion) ObjectUtil.checkNotNull(dnsQuestion, "question");
        this.additional = (Iterable) ObjectUtil.checkNotNull(iterable, "additional");
        this.promise = (Promise) ObjectUtil.checkNotNull(promise, "promise");
        this.recursionDesired = dnsNameResolver.isRecursionDesired();
        this.f40289id = dnsNameResolver.queryContextManager.add(this);
        if (dnsNameResolver.isOptResourceEnabled()) {
            this.optResource = new DefaultDnsRawRecord("", DnsRecordType.OPT, dnsNameResolver.maxPayloadSize(), 0L, Unpooled.EMPTY_BUFFER);
        } else {
            this.optResource = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onQueryWriteCompletion(ChannelFuture channelFuture) {
        if (!channelFuture.isSuccess()) {
            setFailure("failed to send a query", channelFuture.cause());
            return;
        }
        final long queryTimeoutMillis = this.parent.queryTimeoutMillis();
        if (queryTimeoutMillis > 0) {
            this.timeoutFuture = this.parent.f40288ch.eventLoop().schedule(new Runnable() { // from class: io.netty.resolver.dns.DnsQueryContext.3
                @Override // java.lang.Runnable
                public void run() {
                    if (DnsQueryContext.this.promise.isDone()) {
                        return;
                    }
                    DnsQueryContext dnsQueryContext = DnsQueryContext.this;
                    dnsQueryContext.setFailure("query timed out after " + queryTimeoutMillis + " milliseconds", null);
                }
            }, queryTimeoutMillis, TimeUnit.MILLISECONDS);
        }
    }

    private void sendQuery(final DnsQuery dnsQuery) {
        if (this.parent.channelFuture.isDone()) {
            writeQuery(dnsQuery);
        } else {
            this.parent.channelFuture.addListener(new GenericFutureListener<Future<? super Channel>>() { // from class: io.netty.resolver.dns.DnsQueryContext.1
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<? super Channel> future) throws Exception {
                    if (future.isSuccess()) {
                        DnsQueryContext.this.writeQuery(dnsQuery);
                    } else {
                        DnsQueryContext.this.promise.tryFailure(future.cause());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFailure(String str, Throwable th) {
        DnsNameResolverException dnsNameResolverException;
        InetSocketAddress nameServerAddr = nameServerAddr();
        this.parent.queryContextManager.remove(nameServerAddr, this.f40289id);
        StringBuilder sb = new StringBuilder(str.length() + 64);
        sb.append('[');
        sb.append(nameServerAddr);
        sb.append("] ");
        sb.append(str);
        sb.append(" (no stack trace available)");
        if (th != null) {
            dnsNameResolverException = new DnsNameResolverException(nameServerAddr, question(), sb.toString(), th);
        } else {
            dnsNameResolverException = new DnsNameResolverException(nameServerAddr, question(), sb.toString());
        }
        this.promise.tryFailure(dnsNameResolverException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setSuccess(AddressedEnvelope<? extends DnsResponse, InetSocketAddress> addressedEnvelope) {
        this.parent.queryContextManager.remove(nameServerAddr(), this.f40289id);
        ScheduledFuture<?> scheduledFuture = this.timeoutFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> promise = this.promise;
        if (promise.setUncancellable()) {
            promise.setSuccess(addressedEnvelope.retain());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeQuery(DnsQuery dnsQuery) {
        final ChannelFuture writeAndFlush = this.parent.f40288ch.writeAndFlush(dnsQuery);
        if (writeAndFlush.isDone()) {
            onQueryWriteCompletion(writeAndFlush);
        } else {
            writeAndFlush.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.resolver.dns.DnsQueryContext.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    DnsQueryContext.this.onQueryWriteCompletion(writeAndFlush);
                }
            });
        }
    }

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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void query() {
        DnsQuestion question = question();
        InetSocketAddress nameServerAddr = nameServerAddr();
        DatagramDnsQuery datagramDnsQuery = new DatagramDnsQuery(null, nameServerAddr, this.f40289id);
        datagramDnsQuery.setRecursionDesired(this.recursionDesired);
        datagramDnsQuery.addRecord(DnsSection.QUESTION, (DnsRecord) question);
        for (DnsRecord dnsRecord : this.additional) {
            datagramDnsQuery.addRecord(DnsSection.ADDITIONAL, dnsRecord);
        }
        DnsRecord dnsRecord2 = this.optResource;
        if (dnsRecord2 != null) {
            datagramDnsQuery.addRecord(DnsSection.ADDITIONAL, dnsRecord2);
        }
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} WRITE: [{}: {}], {}", this.parent.f40288ch, Integer.valueOf(this.f40289id), nameServerAddr, question);
        }
        sendQuery(datagramDnsQuery);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DnsQuestion question() {
        return this.question;
    }
}
