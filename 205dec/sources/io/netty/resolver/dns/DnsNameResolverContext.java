package io.netty.resolver.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.dns.DefaultDnsQuestion;
import io.netty.handler.codec.dns.DefaultDnsRecordDecoder;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.handler.codec.dns.DnsResponseCode;
import io.netty.handler.codec.dns.DnsSection;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.StringUtil;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class DnsNameResolverContext<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INADDRSZ4 = 4;
    private static final int INADDRSZ6 = 16;
    private static final FutureListener<AddressedEnvelope<DnsResponse, InetSocketAddress>> RELEASE_RESPONSE = new FutureListener<AddressedEnvelope<DnsResponse, InetSocketAddress>>() { // from class: io.netty.resolver.dns.DnsNameResolverContext.1
        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> future) {
            if (future.isSuccess()) {
                future.getNow().release();
            }
        }
    };
    private int allowedQueries;
    private final String hostname;
    private final int maxAllowedQueries;
    private final DnsServerAddressStream nameServerAddrs;
    private final DnsNameResolver parent;
    protected String pristineHostname;
    private final Set<Future<AddressedEnvelope<DnsResponse, InetSocketAddress>>> queriesInProgress = Collections.newSetFromMap(new IdentityHashMap());
    private final InternetProtocolFamily[] resolveAddressTypes;
    private final DnsCache resolveCache;
    private List<DnsCacheEntry> resolvedEntries;
    private StringBuilder trace;
    private final boolean traceEnabled;
    private boolean triedCNAME;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.resolver.dns.DnsNameResolverContext$4  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$channel$socket$InternetProtocolFamily;

        static {
            int[] iArr = new int[InternetProtocolFamily.values().length];
            $SwitchMap$io$netty$channel$socket$InternetProtocolFamily = iArr;
            try {
                iArr[InternetProtocolFamily.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$channel$socket$InternetProtocolFamily[InternetProtocolFamily.IPv6.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DnsNameResolverContext(DnsNameResolver dnsNameResolver, String str, DnsCache dnsCache) {
        this.parent = dnsNameResolver;
        this.hostname = str;
        this.resolveCache = dnsCache;
        this.nameServerAddrs = dnsNameResolver.nameServerAddresses.stream();
        int maxQueriesPerResolve = dnsNameResolver.maxQueriesPerResolve();
        this.maxAllowedQueries = maxQueriesPerResolve;
        this.resolveAddressTypes = dnsNameResolver.resolveAddressTypesUnsafe();
        this.traceEnabled = dnsNameResolver.isTraceEnabled();
        this.allowedQueries = maxQueriesPerResolve;
    }

    private void addTrace(InetSocketAddress inetSocketAddress, String str) {
        if (this.trace == null) {
            this.trace = new StringBuilder(128);
        }
        this.trace.append(StringUtil.NEWLINE);
        this.trace.append("\tfrom ");
        this.trace.append(inetSocketAddress);
        this.trace.append(": ");
        this.trace.append(str);
    }

    private static Map<String, String> buildAliasMap(DnsResponse dnsResponse) {
        String decodeDomainName;
        int count = dnsResponse.count(DnsSection.ANSWER);
        HashMap hashMap = null;
        for (int i4 = 0; i4 < count; i4++) {
            DnsRecord recordAt = dnsResponse.recordAt(DnsSection.ANSWER, i4);
            if (recordAt.type() == DnsRecordType.CNAME && (recordAt instanceof DnsRawRecord) && (decodeDomainName = decodeDomainName(((ByteBufHolder) recordAt).content())) != null) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                String name = recordAt.name();
                Locale locale = Locale.US;
                hashMap.put(name.toLowerCase(locale), decodeDomainName.toLowerCase(locale));
            }
        }
        return hashMap != null ? hashMap : Collections.emptyMap();
    }

    static String decodeDomainName(ByteBuf byteBuf) {
        byteBuf.markReaderIndex();
        try {
            return DefaultDnsRecordDecoder.decodeName(byteBuf);
        } catch (CorruptedFrameException unused) {
            return null;
        } finally {
            byteBuf.resetReaderIndex();
        }
    }

    private void finishResolve(Promise<T> promise) {
        if (!this.queriesInProgress.isEmpty()) {
            Iterator<Future<AddressedEnvelope<DnsResponse, InetSocketAddress>>> it = this.queriesInProgress.iterator();
            while (it.hasNext()) {
                Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> next = it.next();
                it.remove();
                if (!next.cancel(false)) {
                    next.addListener(RELEASE_RESPONSE);
                }
            }
        }
        if (this.resolvedEntries != null) {
            for (InternetProtocolFamily internetProtocolFamily : this.resolveAddressTypes) {
                if (finishResolve(internetProtocolFamily.addressType(), this.resolvedEntries, promise)) {
                    return;
                }
            }
        }
        int i4 = this.maxAllowedQueries - this.allowedQueries;
        StringBuilder sb = new StringBuilder(64);
        sb.append("failed to resolve '");
        String str = this.pristineHostname;
        if (str != null) {
            sb.append(str);
        } else {
            sb.append(this.hostname);
        }
        sb.append('\'');
        if (i4 > 1) {
            if (i4 < this.maxAllowedQueries) {
                sb.append(" after ");
                sb.append(i4);
                sb.append(" queries ");
            } else {
                sb.append(". Exceeded max queries per resolve ");
                sb.append(this.maxAllowedQueries);
                sb.append(' ');
            }
        }
        if (this.trace != null) {
            sb.append(':');
            sb.append((CharSequence) this.trace);
        }
        UnknownHostException unknownHostException = new UnknownHostException(sb.toString());
        this.resolveCache.cache(this.hostname, unknownHostException, this.parent.ch.eventLoop());
        promise.tryFailure(unknownHostException);
    }

    private void followCname(InetSocketAddress inetSocketAddress, String str, String str2, Promise<T> promise) {
        if (this.traceEnabled) {
            if (this.trace == null) {
                this.trace = new StringBuilder(128);
            }
            this.trace.append(StringUtil.NEWLINE);
            this.trace.append("\tfrom ");
            this.trace.append(inetSocketAddress);
            this.trace.append(": ");
            this.trace.append(str);
            this.trace.append(" CNAME ");
            this.trace.append(str2);
        }
        InetSocketAddress next = this.nameServerAddrs.next();
        query(next, new DefaultDnsQuestion(str2, DnsRecordType.A), promise);
        query(next, new DefaultDnsQuestion(str2, DnsRecordType.AAAA), promise);
    }

    private boolean gotPreferredAddress() {
        List<DnsCacheEntry> list = this.resolvedEntries;
        if (list == null) {
            return false;
        }
        int size = list.size();
        int i4 = AnonymousClass4.$SwitchMap$io$netty$channel$socket$InternetProtocolFamily[this.resolveAddressTypes[0].ordinal()];
        if (i4 == 1) {
            for (int i5 = 0; i5 < size; i5++) {
                if (this.resolvedEntries.get(i5).address() instanceof Inet4Address) {
                    return true;
                }
            }
        } else if (i4 == 2) {
            for (int i6 = 0; i6 < size; i6++) {
                if (this.resolvedEntries.get(i6).address() instanceof Inet6Address) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalResolve(Promise<T> promise) {
        DnsRecordType dnsRecordType;
        InetSocketAddress next = this.nameServerAddrs.next();
        for (InternetProtocolFamily internetProtocolFamily : this.resolveAddressTypes) {
            int i4 = AnonymousClass4.$SwitchMap$io$netty$channel$socket$InternetProtocolFamily[internetProtocolFamily.ordinal()];
            if (i4 == 1) {
                dnsRecordType = DnsRecordType.A;
            } else if (i4 == 2) {
                dnsRecordType = DnsRecordType.AAAA;
            } else {
                throw new Error();
            }
            query(next, new DefaultDnsQuestion(this.hostname, dnsRecordType), promise);
        }
    }

    private void onResponseAorAAAA(DnsRecordType dnsRecordType, DnsQuestion dnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, Promise<T> promise) {
        ByteBuf content;
        int readableBytes;
        DnsResponse content2 = addressedEnvelope.content();
        Map<String, String> buildAliasMap = buildAliasMap(content2);
        int count = content2.count(DnsSection.ANSWER);
        boolean z3 = false;
        for (int i4 = 0; i4 < count; i4++) {
            DnsRecord recordAt = content2.recordAt(DnsSection.ANSWER, i4);
            DnsRecordType type = recordAt.type();
            if (type == DnsRecordType.A || type == DnsRecordType.AAAA) {
                String name = dnsQuestion.name();
                Locale locale = Locale.US;
                String lowerCase = name.toLowerCase(locale);
                String lowerCase2 = recordAt.name().toLowerCase(locale);
                if (!lowerCase2.equals(lowerCase)) {
                    do {
                        lowerCase = buildAliasMap.get(lowerCase);
                        if (!lowerCase2.equals(lowerCase)) {
                            break;
                            break;
                        }
                        break;
                    } while (lowerCase != null);
                    if (lowerCase == null) {
                        continue;
                    }
                }
                if ((recordAt instanceof DnsRawRecord) && ((readableBytes = (content = ((ByteBufHolder) recordAt).content()).readableBytes()) == 4 || readableBytes == 16)) {
                    byte[] bArr = new byte[readableBytes];
                    content.getBytes(content.readerIndex(), bArr);
                    try {
                        InetAddress byAddress = InetAddress.getByAddress(this.hostname, bArr);
                        if (this.resolvedEntries == null) {
                            this.resolvedEntries = new ArrayList(8);
                        }
                        DnsCacheEntry dnsCacheEntry = new DnsCacheEntry(this.hostname, byAddress);
                        this.resolveCache.cache(this.hostname, byAddress, recordAt.timeToLive(), this.parent.ch.eventLoop());
                        this.resolvedEntries.add(dnsCacheEntry);
                        z3 = true;
                    } catch (UnknownHostException e4) {
                        throw new Error(e4);
                    }
                }
            }
        }
        if (z3) {
            return;
        }
        if (this.traceEnabled) {
            addTrace(addressedEnvelope.sender(), "no matching " + dnsRecordType + " record found");
        }
        if (buildAliasMap.isEmpty()) {
            return;
        }
        onResponseCNAME(dnsQuestion, addressedEnvelope, buildAliasMap, false, promise);
    }

    private void onResponseCNAME(DnsQuestion dnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, Promise<T> promise) {
        onResponseCNAME(dnsQuestion, addressedEnvelope, buildAliasMap(addressedEnvelope.content()), true, promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void query(InetSocketAddress inetSocketAddress, final DnsQuestion dnsQuestion, final Promise<T> promise) {
        if (this.allowedQueries != 0 && !promise.isCancelled()) {
            this.allowedQueries--;
            Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query = this.parent.query(inetSocketAddress, dnsQuestion);
            this.queriesInProgress.add(query);
            query.addListener(new FutureListener<AddressedEnvelope<DnsResponse, InetSocketAddress>>() { // from class: io.netty.resolver.dns.DnsNameResolverContext.3
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> future) {
                    DnsNameResolverContext.this.queriesInProgress.remove(future);
                    if (promise.isDone() || future.isCancelled()) {
                        return;
                    }
                    try {
                        if (future.isSuccess()) {
                            DnsNameResolverContext.this.onResponse(dnsQuestion, future.getNow(), promise);
                        } else {
                            if (DnsNameResolverContext.this.traceEnabled) {
                                DnsNameResolverContext.this.addTrace(future.cause());
                            }
                            DnsNameResolverContext dnsNameResolverContext = DnsNameResolverContext.this;
                            dnsNameResolverContext.query(dnsNameResolverContext.nameServerAddrs.next(), dnsQuestion, promise);
                        }
                    } finally {
                        DnsNameResolverContext.this.tryToFinishResolve(promise);
                    }
                }
            });
            return;
        }
        tryToFinishResolve(promise);
    }

    abstract boolean finishResolve(Class<? extends InetAddress> cls, List<DnsCacheEntry> list, Promise<T> promise);

    abstract DnsNameResolverContext<T> newResolverContext(DnsNameResolver dnsNameResolver, String str, DnsCache dnsCache);

    void onResponse(DnsQuestion dnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, Promise<T> promise) {
        try {
            DnsResponse content = addressedEnvelope.content();
            DnsResponseCode code = content.code();
            if (code == DnsResponseCode.NOERROR) {
                DnsRecordType type = dnsQuestion.type();
                if (type != DnsRecordType.A && type != DnsRecordType.AAAA) {
                    if (type == DnsRecordType.CNAME) {
                        onResponseCNAME(dnsQuestion, addressedEnvelope, promise);
                    }
                    return;
                }
                onResponseAorAAAA(type, dnsQuestion, addressedEnvelope, promise);
                return;
            }
            if (this.traceEnabled) {
                addTrace(addressedEnvelope.sender(), "response code: " + code + " with " + content.count(DnsSection.ANSWER) + " answer(s) and " + content.count(DnsSection.AUTHORITY) + " authority resource(s)");
            }
            if (code != DnsResponseCode.NXDOMAIN) {
                query(this.nameServerAddrs.next(), dnsQuestion, promise);
            }
        } finally {
            ReferenceCountUtil.safeRelease(addressedEnvelope);
        }
    }

    void resolve(final Promise<T> promise) {
        int i4 = 0;
        if (this.parent.searchDomains().length == 0 || StringUtil.endsWith(this.hostname, '.')) {
            internalResolve(promise);
            return;
        }
        Promise<T> newPromise = this.parent.executor().newPromise();
        newPromise.addListener((GenericFutureListener<? extends Future<? super T>>) new FutureListener<T>() { // from class: io.netty.resolver.dns.DnsNameResolverContext.2
            int count;

            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<T> future) throws Exception {
                if (future.isSuccess()) {
                    promise.trySuccess(future.getNow());
                } else if (this.count < DnsNameResolverContext.this.parent.searchDomains().length) {
                    String[] searchDomains = DnsNameResolverContext.this.parent.searchDomains();
                    int i5 = this.count;
                    this.count = i5 + 1;
                    String str = searchDomains[i5];
                    Promise newPromise2 = DnsNameResolverContext.this.parent.executor().newPromise();
                    DnsNameResolverContext dnsNameResolverContext = DnsNameResolverContext.this;
                    DnsNameResolverContext<T> newResolverContext = dnsNameResolverContext.newResolverContext(dnsNameResolverContext.parent, DnsNameResolverContext.this.hostname + "." + str, DnsNameResolverContext.this.resolveCache);
                    newResolverContext.pristineHostname = DnsNameResolverContext.this.hostname;
                    newResolverContext.internalResolve(newPromise2);
                    newPromise2.addListener((GenericFutureListener) this);
                } else {
                    promise.tryFailure(future.cause());
                }
            }
        });
        if (this.parent.ndots() == 0) {
            internalResolve(newPromise);
            return;
        }
        for (int length = this.hostname.length() - 1; length >= 0; length--) {
            if (this.hostname.charAt(length) == '.' && (i4 = i4 + 1) >= this.parent.ndots()) {
                internalResolve(newPromise);
                return;
            }
        }
        newPromise.tryFailure(new UnknownHostException(this.hostname));
    }

    void tryToFinishResolve(Promise<T> promise) {
        if (!this.queriesInProgress.isEmpty()) {
            if (gotPreferredAddress()) {
                finishResolve(promise);
            }
        } else if (this.resolvedEntries == null && !this.triedCNAME) {
            this.triedCNAME = true;
            query(this.nameServerAddrs.next(), new DefaultDnsQuestion(this.hostname, DnsRecordType.CNAME), promise);
        } else {
            finishResolve(promise);
        }
    }

    private void onResponseCNAME(DnsQuestion dnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, Map<String, String> map, boolean z3, Promise<T> promise) {
        String remove;
        String lowerCase = dnsQuestion.name().toLowerCase(Locale.US);
        boolean z4 = false;
        String str = lowerCase;
        while (!map.isEmpty() && (remove = map.remove(str)) != null) {
            z4 = true;
            str = remove;
        }
        if (z4) {
            followCname(addressedEnvelope.sender(), lowerCase, str, promise);
        } else if (z3 && this.traceEnabled) {
            addTrace(addressedEnvelope.sender(), "no matching CNAME record found");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTrace(Throwable th) {
        if (this.trace == null) {
            this.trace = new StringBuilder(128);
        }
        this.trace.append(StringUtil.NEWLINE);
        this.trace.append("Caused by: ");
        this.trace.append(th);
    }
}
