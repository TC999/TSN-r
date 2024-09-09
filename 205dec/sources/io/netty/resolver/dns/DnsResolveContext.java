package io.netty.resolver.dns;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
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
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.ThrowableUtil;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class DnsResolveContext<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    final DnsRecord[] additionals;
    private int allowedQueries;
    private boolean completeEarly;
    private final int dnsClass;
    private final DnsRecordType[] expectedTypes;
    private List<T> finalResult;
    private final String hostname;
    private final int maxAllowedQueries;
    private final DnsServerAddressStream nameServerAddrs;
    final DnsNameResolver parent;
    private final Set<Future<AddressedEnvelope<DnsResponse, InetSocketAddress>>> queriesInProgress = Collections.newSetFromMap(new IdentityHashMap());
    private boolean triedCNAME;
    private static final RuntimeException NXDOMAIN_QUERY_FAILED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(DnsResolveContextException.newStatic("No answer found and NXDOMAIN response code returned"), DnsResolveContext.class, "onResponse(..)");
    private static final RuntimeException CNAME_NOT_FOUND_QUERY_FAILED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(DnsResolveContextException.newStatic("No matching CNAME record found"), DnsResolveContext.class, "onResponseCNAME(..)");
    private static final RuntimeException NO_MATCHING_RECORD_QUERY_FAILED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(DnsResolveContextException.newStatic("No matching record type found"), DnsResolveContext.class, "onResponseAorAAAA(..)");
    private static final RuntimeException UNRECOGNIZED_TYPE_QUERY_FAILED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(new RuntimeException("Response type was unrecognized"), DnsResolveContext.class, "onResponse(..)");
    private static final RuntimeException NAME_SERVERS_EXHAUSTED_EXCEPTION = (RuntimeException) ThrowableUtil.unknownStackTrace(DnsResolveContextException.newStatic("No name servers returned an answer"), DnsResolveContext.class, "tryToFinishResolve(..)");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class AuthoritativeNameServerList {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private AuthoritativeNameServer head;
        private int nameServerCount;
        private final String questionName;

        AuthoritativeNameServerList(String str) {
            this.questionName = str.toLowerCase(Locale.US);
        }

        private static void cache(AuthoritativeNameServer authoritativeNameServer, AuthoritativeDnsServerCache authoritativeDnsServerCache, EventLoop eventLoop) {
            if (authoritativeNameServer.isRootServer()) {
                return;
            }
            authoritativeDnsServerCache.cache(authoritativeNameServer.domainName, authoritativeNameServer.address, authoritativeNameServer.ttl, eventLoop);
        }

        private static void cacheUnresolved(AuthoritativeNameServer authoritativeNameServer, AuthoritativeDnsServerCache authoritativeDnsServerCache, EventLoop eventLoop) {
            authoritativeNameServer.address = InetSocketAddress.createUnresolved(authoritativeNameServer.nsName, 53);
            cache(authoritativeNameServer, authoritativeDnsServerCache, eventLoop);
        }

        void add(DnsRecord dnsRecord) {
            String decodeDomainName;
            if (dnsRecord.type() != DnsRecordType.NS || !(dnsRecord instanceof DnsRawRecord) || this.questionName.length() < dnsRecord.name().length()) {
                return;
            }
            String lowerCase = dnsRecord.name().toLowerCase(Locale.US);
            int length = lowerCase.length() - 1;
            int length2 = this.questionName.length() - 1;
            int i4 = 0;
            while (length >= 0) {
                char charAt = lowerCase.charAt(length);
                if (this.questionName.charAt(length2) != charAt) {
                    return;
                }
                if (charAt == '.') {
                    i4++;
                }
                length--;
                length2--;
            }
            AuthoritativeNameServer authoritativeNameServer = this.head;
            if ((authoritativeNameServer != null && authoritativeNameServer.dots > i4) || (decodeDomainName = DnsResolveContext.decodeDomainName(((ByteBufHolder) dnsRecord).content())) == null) {
                return;
            }
            AuthoritativeNameServer authoritativeNameServer2 = this.head;
            if (authoritativeNameServer2 != null && authoritativeNameServer2.dots >= i4) {
                if (this.head.dots != i4) {
                    return;
                }
                AuthoritativeNameServer authoritativeNameServer3 = this.head;
                while (true) {
                    AuthoritativeNameServer authoritativeNameServer4 = authoritativeNameServer3.next;
                    if (authoritativeNameServer4 == null) {
                        authoritativeNameServer3.next = new AuthoritativeNameServer(i4, dnsRecord.timeToLive(), lowerCase, decodeDomainName);
                        this.nameServerCount++;
                        return;
                    }
                    authoritativeNameServer3 = authoritativeNameServer4;
                }
            } else {
                this.nameServerCount = 1;
                this.head = new AuthoritativeNameServer(i4, dnsRecord.timeToLive(), lowerCase, decodeDomainName);
            }
        }

        List<InetSocketAddress> addressList() {
            ArrayList arrayList = new ArrayList(this.nameServerCount);
            for (AuthoritativeNameServer authoritativeNameServer = this.head; authoritativeNameServer != null; authoritativeNameServer = authoritativeNameServer.next) {
                if (authoritativeNameServer.address != null) {
                    arrayList.add(authoritativeNameServer.address);
                }
            }
            return arrayList;
        }

        void handleWithAdditional(DnsNameResolver dnsNameResolver, DnsRecord dnsRecord, AuthoritativeDnsServerCache authoritativeDnsServerCache) {
            AuthoritativeNameServer authoritativeNameServer = this.head;
            String name = dnsRecord.name();
            InetAddress decodeAddress = DnsAddressDecoder.decodeAddress(dnsRecord, name, dnsNameResolver.isDecodeIdn());
            if (decodeAddress == null) {
                return;
            }
            while (authoritativeNameServer != null) {
                if (authoritativeNameServer.nsName.equalsIgnoreCase(name)) {
                    if (authoritativeNameServer.address != null) {
                        while (true) {
                            AuthoritativeNameServer authoritativeNameServer2 = authoritativeNameServer.next;
                            if (authoritativeNameServer2 == null || !authoritativeNameServer2.isCopy) {
                                break;
                            }
                            authoritativeNameServer = authoritativeNameServer2;
                        }
                        AuthoritativeNameServer authoritativeNameServer3 = new AuthoritativeNameServer(authoritativeNameServer);
                        authoritativeNameServer3.next = authoritativeNameServer.next;
                        authoritativeNameServer.next = authoritativeNameServer3;
                        this.nameServerCount++;
                        authoritativeNameServer = authoritativeNameServer3;
                    }
                    authoritativeNameServer.update(dnsNameResolver.newRedirectServerAddress(decodeAddress), dnsRecord.timeToLive());
                    cache(authoritativeNameServer, authoritativeDnsServerCache, dnsNameResolver.executor());
                    return;
                }
                authoritativeNameServer = authoritativeNameServer.next;
            }
        }

        void handleWithoutAdditionals(DnsNameResolver dnsNameResolver, DnsCache dnsCache, AuthoritativeDnsServerCache authoritativeDnsServerCache) {
            InetAddress address;
            AuthoritativeNameServer authoritativeNameServer = this.head;
            while (authoritativeNameServer != null) {
                if (authoritativeNameServer.address == null) {
                    cacheUnresolved(authoritativeNameServer, authoritativeDnsServerCache, dnsNameResolver.executor());
                    List<? extends DnsCacheEntry> list = dnsCache.get(authoritativeNameServer.nsName, null);
                    if (list != null && !list.isEmpty() && (address = list.get(0).address()) != null) {
                        authoritativeNameServer.update(dnsNameResolver.newRedirectServerAddress(address));
                        int i4 = 1;
                        while (i4 < list.size()) {
                            InetAddress address2 = list.get(i4).address();
                            AuthoritativeNameServer authoritativeNameServer2 = new AuthoritativeNameServer(authoritativeNameServer);
                            authoritativeNameServer2.next = authoritativeNameServer.next;
                            authoritativeNameServer.next = authoritativeNameServer2;
                            authoritativeNameServer2.update(dnsNameResolver.newRedirectServerAddress(address2));
                            this.nameServerCount++;
                            i4++;
                            authoritativeNameServer = authoritativeNameServer2;
                        }
                    }
                }
                authoritativeNameServer = authoritativeNameServer.next;
            }
        }

        boolean isEmpty() {
            return this.nameServerCount == 0;
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private final class CombinedDnsServerAddressStream implements DnsServerAddressStream {
        private final DnsServerAddressStream originalStream;
        private final InetSocketAddress replaced;
        private Iterator<InetAddress> resolved;
        private final List<InetAddress> resolvedAddresses;

        CombinedDnsServerAddressStream(InetSocketAddress inetSocketAddress, List<InetAddress> list, DnsServerAddressStream dnsServerAddressStream) {
            this.replaced = inetSocketAddress;
            this.resolvedAddresses = list;
            this.originalStream = dnsServerAddressStream;
            this.resolved = list.iterator();
        }

        private InetSocketAddress nextResolved0() {
            return DnsResolveContext.this.parent.newRedirectServerAddress(this.resolved.next());
        }

        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public DnsServerAddressStream duplicate() {
            return new CombinedDnsServerAddressStream(this.replaced, this.resolvedAddresses, this.originalStream.duplicate());
        }

        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public InetSocketAddress next() {
            if (this.resolved.hasNext()) {
                return nextResolved0();
            }
            InetSocketAddress next = this.originalStream.next();
            if (next.equals(this.replaced)) {
                this.resolved = this.resolvedAddresses.iterator();
                return nextResolved0();
            }
            return next;
        }

        @Override // io.netty.resolver.dns.DnsServerAddressStream
        public int size() {
            return (this.originalStream.size() + this.resolvedAddresses.size()) - 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class DnsAddressStreamList extends AbstractList<InetSocketAddress> {
        private List<InetSocketAddress> addresses;
        private final DnsServerAddressStream duplicate;

        DnsAddressStreamList(DnsServerAddressStream dnsServerAddressStream) {
            this.duplicate = dnsServerAddressStream.duplicate();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<InetSocketAddress> iterator() {
            return new Iterator<InetSocketAddress>() { // from class: io.netty.resolver.dns.DnsResolveContext.DnsAddressStreamList.1

                /* renamed from: i  reason: collision with root package name */
                private int f54804i;
                private final DnsServerAddressStream stream;

                {
                    this.stream = DnsAddressStreamList.this.duplicate.duplicate();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f54804i < this.stream.size();
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Iterator
                public InetSocketAddress next() {
                    if (hasNext()) {
                        this.f54804i++;
                        return this.stream.next();
                    }
                    throw new NoSuchElementException();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.duplicate.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public InetSocketAddress get(int i4) {
            if (this.addresses == null) {
                DnsServerAddressStream duplicate = this.duplicate.duplicate();
                this.addresses = new ArrayList(size());
                for (int i5 = 0; i5 < duplicate.size(); i5++) {
                    this.addresses.add(duplicate.next());
                }
            }
            return this.addresses.get(i4);
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class DnsResolveContextException extends RuntimeException {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        private DnsResolveContextException(String str) {
            super(str);
        }

        static DnsResolveContextException newStatic(String str) {
            if (PlatformDependent.javaVersion() >= 7) {
                return new DnsResolveContextException(str, true);
            }
            return new DnsResolveContextException(str);
        }

        @SuppressJava6Requirement(reason = "uses Java 7+ Exception.<init>(String, Throwable, boolean, boolean) but is guarded by version checks")
        private DnsResolveContextException(String str, boolean z3) {
            super(str, null, false, true);
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class SearchDomainUnknownHostException extends UnknownHostException {
        private static final long serialVersionUID = -8573510133644997085L;

        SearchDomainUnknownHostException(Throwable th, String str) {
            super("Search domain query failed. Original hostname: '" + str + "' " + th.getMessage());
            setStackTrace(th.getStackTrace());
            initCause(th.getCause());
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DnsResolveContext(DnsNameResolver dnsNameResolver, String str, int i4, DnsRecordType[] dnsRecordTypeArr, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream) {
        this.parent = dnsNameResolver;
        this.hostname = str;
        this.dnsClass = i4;
        this.expectedTypes = dnsRecordTypeArr;
        this.additionals = dnsRecordArr;
        this.nameServerAddrs = (DnsServerAddressStream) ObjectUtil.checkNotNull(dnsServerAddressStream, "nameServerAddrs");
        int maxQueriesPerResolve = dnsNameResolver.maxQueriesPerResolve();
        this.maxAllowedQueries = maxQueriesPerResolve;
        this.allowedQueries = maxQueriesPerResolve;
    }

    private static Map<String, String> buildAliasMap(DnsResponse dnsResponse, DnsCnameCache dnsCnameCache, EventLoop eventLoop) {
        String decodeDomainName;
        int count = dnsResponse.count(DnsSection.ANSWER);
        HashMap hashMap = null;
        for (int i4 = 0; i4 < count; i4++) {
            DnsRecord recordAt = dnsResponse.recordAt(DnsSection.ANSWER, i4);
            if (recordAt.type() == DnsRecordType.CNAME && (recordAt instanceof DnsRawRecord) && (decodeDomainName = decodeDomainName(((ByteBufHolder) recordAt).content())) != null) {
                if (hashMap == null) {
                    hashMap = new HashMap(Math.min(8, count));
                }
                String name = recordAt.name();
                Locale locale = Locale.US;
                String lowerCase = name.toLowerCase(locale);
                String lowerCase2 = decodeDomainName.toLowerCase(locale);
                String hostnameWithDot = hostnameWithDot(lowerCase);
                String hostnameWithDot2 = hostnameWithDot(lowerCase2);
                if (!hostnameWithDot.equalsIgnoreCase(hostnameWithDot2)) {
                    dnsCnameCache.cache(hostnameWithDot, hostnameWithDot2, recordAt.timeToLive(), eventLoop);
                    hashMap.put(lowerCase, lowerCase2);
                }
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

    private static AuthoritativeNameServerList extractAuthoritativeNameServers(String str, DnsResponse dnsResponse) {
        int count = dnsResponse.count(DnsSection.AUTHORITY);
        if (count == 0) {
            return null;
        }
        AuthoritativeNameServerList authoritativeNameServerList = new AuthoritativeNameServerList(str);
        for (int i4 = 0; i4 < count; i4++) {
            authoritativeNameServerList.add(dnsResponse.recordAt(DnsSection.AUTHORITY, i4));
        }
        if (authoritativeNameServerList.isEmpty()) {
            return null;
        }
        return authoritativeNameServerList;
    }

    private void finishResolve(Promise<List<T>> promise, Throwable th) {
        if (!this.completeEarly && !this.queriesInProgress.isEmpty()) {
            Iterator<Future<AddressedEnvelope<DnsResponse, InetSocketAddress>>> it = this.queriesInProgress.iterator();
            while (it.hasNext()) {
                it.remove();
                it.next().cancel(false);
            }
        }
        if (this.finalResult != null) {
            if (promise.isDone()) {
                return;
            }
            DnsNameResolver.trySuccess(promise, filterResults(this.finalResult));
            return;
        }
        int i4 = this.maxAllowedQueries - this.allowedQueries;
        StringBuilder sb = new StringBuilder(64);
        sb.append("failed to resolve '");
        sb.append(this.hostname);
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
        UnknownHostException unknownHostException = new UnknownHostException(sb.toString());
        if (th == null) {
            cache(this.hostname, this.additionals, unknownHostException);
        } else {
            unknownHostException.initCause(th);
        }
        promise.tryFailure(unknownHostException);
    }

    private void followCname(DnsQuestion dnsQuestion, String str, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise) {
        HashSet hashSet = null;
        while (true) {
            String str2 = cnameCache().get(hostnameWithDot(str));
            if (str2 == null) {
                break;
            }
            if (hashSet == null) {
                hashSet = new HashSet(2);
            }
            if (!hashSet.add(str)) {
                break;
            }
            str = str2;
        }
        DnsServerAddressStream nameServers = getNameServers(str);
        try {
            DefaultDnsQuestion defaultDnsQuestion = new DefaultDnsQuestion(str, dnsQuestion.type(), this.dnsClass);
            query(nameServers, 0, defaultDnsQuestion, dnsQueryLifecycleObserver.queryCNAMEd(defaultDnsQuestion), true, promise, null);
        } catch (Throwable th) {
            dnsQueryLifecycleObserver.queryFailed(th);
            PlatformDependent.throwException(th);
        }
    }

    private DnsServerAddressStream getNameServers(String str) {
        DnsServerAddressStream nameServersFromCache = getNameServersFromCache(str);
        return nameServersFromCache == null ? this.nameServerAddrs.duplicate() : nameServersFromCache;
    }

    private DnsServerAddressStream getNameServersFromCache(String str) {
        DnsServerAddressStream dnsServerAddressStream;
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (str.charAt(length - 1) != '.') {
            str = str + ".";
        }
        int indexOf = str.indexOf(46);
        if (indexOf == str.length() - 1) {
            return null;
        }
        do {
            str = str.substring(indexOf + 1);
            indexOf = str.indexOf(46);
            if (indexOf <= 0 || indexOf == str.length() - 1) {
                return null;
            }
            dnsServerAddressStream = authoritativeDnsServerCache().get(str);
        } while (dnsServerAddressStream == null);
        return dnsServerAddressStream;
    }

    private boolean handleRedirect(DnsQuestion dnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise) {
        AuthoritativeNameServerList extractAuthoritativeNameServers;
        DnsResponse content = addressedEnvelope.content();
        if (content.count(DnsSection.ANSWER) == 0 && (extractAuthoritativeNameServers = extractAuthoritativeNameServers(dnsQuestion.name(), content)) != null) {
            int count = content.count(DnsSection.ADDITIONAL);
            AuthoritativeDnsServerCache authoritativeDnsServerCache = authoritativeDnsServerCache();
            for (int i4 = 0; i4 < count; i4++) {
                DnsRecord recordAt = content.recordAt(DnsSection.ADDITIONAL, i4);
                if ((recordAt.type() != DnsRecordType.A || this.parent.supportsARecords()) && (recordAt.type() != DnsRecordType.AAAA || this.parent.supportsAAAARecords())) {
                    extractAuthoritativeNameServers.handleWithAdditional(this.parent, recordAt, authoritativeDnsServerCache);
                }
            }
            extractAuthoritativeNameServers.handleWithoutAdditionals(this.parent, resolveCache(), authoritativeDnsServerCache);
            DnsServerAddressStream newRedirectDnsServerStream = this.parent.newRedirectDnsServerStream(dnsQuestion.name(), extractAuthoritativeNameServers.addressList());
            if (newRedirectDnsServerStream != null) {
                query(newRedirectDnsServerStream, 0, dnsQuestion, dnsQueryLifecycleObserver.queryRedirected(new DnsAddressStreamList(newRedirectDnsServerStream)), true, promise, null);
                return true;
            }
        }
        return false;
    }

    private boolean hasNDots() {
        int i4 = 0;
        for (int length = this.hostname.length() - 1; length >= 0; length--) {
            if (this.hostname.charAt(length) == '.' && (i4 = i4 + 1) >= this.parent.ndots()) {
                return true;
            }
        }
        return false;
    }

    private static String hostnameWithDot(String str) {
        if (StringUtil.endsWith(str, '.')) {
            return str;
        }
        return str + '.';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalResolve(String str, Promise<List<T>> promise) {
        while (true) {
            String str2 = cnameCache().get(hostnameWithDot(str));
            if (str2 == null) {
                try {
                    break;
                } finally {
                    this.parent.flushQueries();
                }
            }
            str = str2;
        }
        DnsServerAddressStream nameServers = getNameServers(str);
        int length = this.expectedTypes.length - 1;
        for (int i4 = 0; i4 < length; i4++) {
            if (!query(str, this.expectedTypes[i4], nameServers.duplicate(), false, promise)) {
                return;
            }
        }
        query(str, this.expectedTypes[length], nameServers, false, promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DnsQueryLifecycleObserver newDnsQueryLifecycleObserver(DnsQuestion dnsQuestion) {
        return this.parent.dnsQueryLifecycleObserverFactory().newDnsQueryLifecycleObserver(dnsQuestion);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void onExpectedResponse(io.netty.handler.codec.dns.DnsQuestion r16, io.netty.channel.AddressedEnvelope<io.netty.handler.codec.dns.DnsResponse, java.net.InetSocketAddress> r17, io.netty.resolver.dns.DnsQueryLifecycleObserver r18, io.netty.util.concurrent.Promise<java.util.List<T>> r19) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.DnsResolveContext.onExpectedResponse(io.netty.handler.codec.dns.DnsQuestion, io.netty.channel.AddressedEnvelope, io.netty.resolver.dns.DnsQueryLifecycleObserver, io.netty.util.concurrent.Promise):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResponse(DnsServerAddressStream dnsServerAddressStream, int i4, DnsQuestion dnsQuestion, AddressedEnvelope<DnsResponse, InetSocketAddress> addressedEnvelope, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise) {
        try {
            DnsResponse content = addressedEnvelope.content();
            DnsResponseCode code = content.code();
            if (code == DnsResponseCode.NOERROR) {
                if (handleRedirect(dnsQuestion, addressedEnvelope, dnsQueryLifecycleObserver, promise)) {
                    return;
                }
                DnsRecordType type = dnsQuestion.type();
                if (type == DnsRecordType.CNAME) {
                    onResponseCNAME(dnsQuestion, buildAliasMap(addressedEnvelope.content(), cnameCache(), this.parent.executor()), dnsQueryLifecycleObserver, promise);
                    return;
                }
                for (DnsRecordType dnsRecordType : this.expectedTypes) {
                    if (type == dnsRecordType) {
                        onExpectedResponse(dnsQuestion, addressedEnvelope, dnsQueryLifecycleObserver, promise);
                        return;
                    }
                }
                dnsQueryLifecycleObserver.queryFailed(UNRECOGNIZED_TYPE_QUERY_FAILED_EXCEPTION);
                return;
            }
            if (code != DnsResponseCode.NXDOMAIN) {
                query(dnsServerAddressStream, i4 + 1, dnsQuestion, dnsQueryLifecycleObserver.queryNoAnswer(code), true, promise, null);
            } else {
                dnsQueryLifecycleObserver.queryFailed(NXDOMAIN_QUERY_FAILED_EXCEPTION);
                if (!content.isAuthoritativeAnswer()) {
                    query(dnsServerAddressStream, i4 + 1, dnsQuestion, newDnsQueryLifecycleObserver(dnsQuestion), true, promise, null);
                }
            }
        } finally {
            ReferenceCountUtil.safeRelease(addressedEnvelope);
        }
    }

    private void onResponseCNAME(DnsQuestion dnsQuestion, Map<String, String> map, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise) {
        String remove;
        String lowerCase = dnsQuestion.name().toLowerCase(Locale.US);
        boolean z3 = false;
        while (!map.isEmpty() && (remove = map.remove(lowerCase)) != null) {
            z3 = true;
            lowerCase = remove;
        }
        if (z3) {
            followCname(dnsQuestion, lowerCase, dnsQueryLifecycleObserver, promise);
        } else {
            dnsQueryLifecycleObserver.queryFailed(CNAME_NOT_FOUND_QUERY_FAILED_EXCEPTION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void query(final DnsServerAddressStream dnsServerAddressStream, final int i4, final DnsQuestion dnsQuestion, final DnsQueryLifecycleObserver dnsQueryLifecycleObserver, boolean z3, final Promise<List<T>> promise, Throwable th) {
        if (!this.completeEarly && i4 < dnsServerAddressStream.size() && this.allowedQueries != 0 && !promise.isCancelled()) {
            this.allowedQueries--;
            InetSocketAddress next = dnsServerAddressStream.next();
            if (next.isUnresolved()) {
                queryUnresolvedNameserver(next, dnsServerAddressStream, i4, dnsQuestion, dnsQueryLifecycleObserver, promise, th);
                return;
            }
            ChannelPromise newPromise = this.parent.ch.newPromise();
            Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query0 = this.parent.query0(next, dnsQuestion, this.additionals, z3, newPromise, this.parent.ch.eventLoop().newPromise());
            this.queriesInProgress.add(query0);
            dnsQueryLifecycleObserver.queryWritten(next, newPromise);
            query0.addListener(new FutureListener<AddressedEnvelope<DnsResponse, InetSocketAddress>>() { // from class: io.netty.resolver.dns.DnsResolveContext.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> future) {
                    DnsResolveContext.this.queriesInProgress.remove(future);
                    if (!promise.isDone() && !future.isCancelled()) {
                        Throwable cause = future.cause();
                        try {
                            if (cause == null) {
                                DnsResolveContext.this.onResponse(dnsServerAddressStream, i4, dnsQuestion, future.getNow(), dnsQueryLifecycleObserver, promise);
                            } else {
                                dnsQueryLifecycleObserver.queryFailed(cause);
                                DnsResolveContext dnsResolveContext = DnsResolveContext.this;
                                DnsQuestion dnsQuestion2 = dnsQuestion;
                                dnsResolveContext.query(dnsServerAddressStream, i4 + 1, dnsQuestion2, dnsResolveContext.newDnsQueryLifecycleObserver(dnsQuestion2), true, promise, cause);
                            }
                            return;
                        } finally {
                            DnsResolveContext.this.tryToFinishResolve(dnsServerAddressStream, i4, dnsQuestion, NoopDnsQueryLifecycleObserver.INSTANCE, promise, cause);
                        }
                    }
                    dnsQueryLifecycleObserver.queryCancelled(DnsResolveContext.this.allowedQueries);
                    AddressedEnvelope<DnsResponse, InetSocketAddress> now = future.getNow();
                    if (now != null) {
                        now.release();
                    }
                }
            });
            return;
        }
        tryToFinishResolve(dnsServerAddressStream, i4, dnsQuestion, dnsQueryLifecycleObserver, promise, th);
    }

    private void queryUnresolvedNameserver(final InetSocketAddress inetSocketAddress, final DnsServerAddressStream dnsServerAddressStream, final int i4, final DnsQuestion dnsQuestion, final DnsQueryLifecycleObserver dnsQueryLifecycleObserver, final Promise<List<T>> promise, final Throwable th) {
        String hostString = PlatformDependent.javaVersion() >= 7 ? inetSocketAddress.getHostString() : inetSocketAddress.getHostName();
        final Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> newSucceededFuture = this.parent.executor().newSucceededFuture(null);
        this.queriesInProgress.add(newSucceededFuture);
        Promise<List<T>> newPromise = this.parent.executor().newPromise();
        newPromise.addListener((GenericFutureListener<? extends Future<? super List<T>>>) new FutureListener<List<InetAddress>>() { // from class: io.netty.resolver.dns.DnsResolveContext.3
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<List<InetAddress>> future) {
                DnsResolveContext.this.queriesInProgress.remove(newSucceededFuture);
                if (future.isSuccess()) {
                    DnsResolveContext.this.query(new CombinedDnsServerAddressStream(inetSocketAddress, future.getNow(), dnsServerAddressStream), i4, dnsQuestion, dnsQueryLifecycleObserver, true, promise, th);
                    return;
                }
                DnsResolveContext.this.query(dnsServerAddressStream, i4 + 1, dnsQuestion, dnsQueryLifecycleObserver, true, promise, th);
            }
        });
        if (DnsNameResolver.doResolveAllCached(hostString, this.additionals, newPromise, resolveCache(), this.parent.resolvedInternetProtocolFamiliesUnsafe())) {
            return;
        }
        final AuthoritativeDnsServerCache authoritativeDnsServerCache = authoritativeDnsServerCache();
        DnsNameResolver dnsNameResolver = this.parent;
        new DnsAddressResolveContext(dnsNameResolver, hostString, this.additionals, dnsNameResolver.newNameServerAddressStream(hostString), resolveCache(), new AuthoritativeDnsServerCache() { // from class: io.netty.resolver.dns.DnsResolveContext.4
            @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
            public void cache(String str, InetSocketAddress inetSocketAddress2, long j4, EventLoop eventLoop) {
                authoritativeDnsServerCache.cache(str, inetSocketAddress2, j4, eventLoop);
            }

            @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
            public void clear() {
                authoritativeDnsServerCache.clear();
            }

            @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
            public DnsServerAddressStream get(String str) {
                return null;
            }

            @Override // io.netty.resolver.dns.AuthoritativeDnsServerCache
            public boolean clear(String str) {
                return authoritativeDnsServerCache.clear(str);
            }
        }, false).resolve(newPromise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryToFinishResolve(DnsServerAddressStream dnsServerAddressStream, int i4, DnsQuestion dnsQuestion, DnsQueryLifecycleObserver dnsQueryLifecycleObserver, Promise<List<T>> promise, Throwable th) {
        if (!this.completeEarly && !this.queriesInProgress.isEmpty()) {
            dnsQueryLifecycleObserver.queryCancelled(this.allowedQueries);
            return;
        }
        if (this.finalResult == null) {
            if (i4 < dnsServerAddressStream.size()) {
                if (dnsQueryLifecycleObserver == NoopDnsQueryLifecycleObserver.INSTANCE) {
                    query(dnsServerAddressStream, 1 + i4, dnsQuestion, newDnsQueryLifecycleObserver(dnsQuestion), true, promise, th);
                    return;
                } else {
                    query(dnsServerAddressStream, 1 + i4, dnsQuestion, dnsQueryLifecycleObserver, true, promise, th);
                    return;
                }
            }
            dnsQueryLifecycleObserver.queryFailed(NAME_SERVERS_EXHAUSTED_EXCEPTION);
            if (th == null && !this.triedCNAME) {
                this.triedCNAME = true;
                String str = this.hostname;
                query(str, DnsRecordType.CNAME, getNameServers(str), true, promise);
                return;
            }
        } else {
            dnsQueryLifecycleObserver.queryCancelled(this.allowedQueries);
        }
        finishResolve(promise, th);
    }

    AuthoritativeDnsServerCache authoritativeDnsServerCache() {
        return this.parent.authoritativeDnsServerCache();
    }

    abstract void cache(String str, DnsRecord[] dnsRecordArr, DnsRecord dnsRecord, T t3);

    abstract void cache(String str, DnsRecord[] dnsRecordArr, UnknownHostException unknownHostException);

    DnsCnameCache cnameCache() {
        return this.parent.cnameCache();
    }

    abstract T convertRecord(DnsRecord dnsRecord, String str, DnsRecord[] dnsRecordArr, EventLoop eventLoop);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doSearchDomainQuery(String str, Promise<List<T>> promise) {
        newResolverContext(this.parent, str, this.dnsClass, this.expectedTypes, this.additionals, this.nameServerAddrs).internalResolve(str, promise);
    }

    abstract List<T> filterResults(List<T> list);

    abstract boolean isCompleteEarly(T t3);

    abstract boolean isDuplicateAllowed();

    abstract DnsResolveContext<T> newResolverContext(DnsNameResolver dnsNameResolver, String str, int i4, DnsRecordType[] dnsRecordTypeArr, DnsRecord[] dnsRecordArr, DnsServerAddressStream dnsServerAddressStream);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resolve(Promise<List<T>> promise) {
        String str;
        String[] searchDomains = this.parent.searchDomains();
        if (searchDomains.length != 0 && this.parent.ndots() != 0 && !StringUtil.endsWith(this.hostname, '.')) {
            boolean hasNDots = hasNDots();
            if (hasNDots) {
                str = this.hostname;
            } else {
                str = this.hostname + '.' + searchDomains[0];
            }
            int i4 = !hasNDots ? 1 : 0;
            Promise<List<T>> newPromise = this.parent.executor().newPromise();
            newPromise.addListener((GenericFutureListener<? extends Future<? super List<T>>>) new FutureListener<List<T>>(i4, promise, searchDomains, hasNDots) { // from class: io.netty.resolver.dns.DnsResolveContext.1
                private int searchDomainIdx;
                final /* synthetic */ int val$initialSearchDomainIdx;
                final /* synthetic */ Promise val$promise;
                final /* synthetic */ String[] val$searchDomains;
                final /* synthetic */ boolean val$startWithoutSearchDomain;

                {
                    this.val$initialSearchDomainIdx = i4;
                    this.val$promise = promise;
                    this.val$searchDomains = searchDomains;
                    this.val$startWithoutSearchDomain = hasNDots;
                    this.searchDomainIdx = i4;
                }

                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(Future<List<T>> future) {
                    Throwable cause = future.cause();
                    if (cause == null) {
                        this.val$promise.trySuccess(future.getNow());
                    } else if (DnsNameResolver.isTransportOrTimeoutError(cause)) {
                        this.val$promise.tryFailure(new SearchDomainUnknownHostException(cause, DnsResolveContext.this.hostname));
                    } else if (this.searchDomainIdx < this.val$searchDomains.length) {
                        Promise<List<T>> newPromise2 = DnsResolveContext.this.parent.executor().newPromise();
                        newPromise2.addListener((GenericFutureListener<? extends Future<? super List<T>>>) this);
                        DnsResolveContext dnsResolveContext = DnsResolveContext.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(DnsResolveContext.this.hostname);
                        sb.append('.');
                        String[] strArr = this.val$searchDomains;
                        int i5 = this.searchDomainIdx;
                        this.searchDomainIdx = i5 + 1;
                        sb.append(strArr[i5]);
                        dnsResolveContext.doSearchDomainQuery(sb.toString(), newPromise2);
                    } else if (!this.val$startWithoutSearchDomain) {
                        DnsResolveContext dnsResolveContext2 = DnsResolveContext.this;
                        dnsResolveContext2.internalResolve(dnsResolveContext2.hostname, this.val$promise);
                    } else {
                        this.val$promise.tryFailure(new SearchDomainUnknownHostException(cause, DnsResolveContext.this.hostname));
                    }
                }
            });
            doSearchDomainQuery(str, newPromise);
            return;
        }
        internalResolve(this.hostname, promise);
    }

    DnsCache resolveCache() {
        return this.parent.resolveCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class AuthoritativeNameServer {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private InetSocketAddress address;
        private final String domainName;
        private final int dots;
        final boolean isCopy = false;
        AuthoritativeNameServer next;
        final String nsName;
        private long ttl;

        AuthoritativeNameServer(int i4, long j4, String str, String str2) {
            this.dots = i4;
            this.ttl = j4;
            this.nsName = str2;
            this.domainName = str;
        }

        boolean isRootServer() {
            return this.dots == 1;
        }

        void update(InetSocketAddress inetSocketAddress, long j4) {
            this.address = inetSocketAddress;
            this.ttl = Math.min(this.ttl, j4);
        }

        void update(InetSocketAddress inetSocketAddress) {
            update(inetSocketAddress, Long.MAX_VALUE);
        }

        AuthoritativeNameServer(AuthoritativeNameServer authoritativeNameServer) {
            this.dots = authoritativeNameServer.dots;
            this.ttl = authoritativeNameServer.ttl;
            this.nsName = authoritativeNameServer.nsName;
            this.domainName = authoritativeNameServer.domainName;
        }
    }

    private boolean query(String str, DnsRecordType dnsRecordType, DnsServerAddressStream dnsServerAddressStream, boolean z3, Promise<List<T>> promise) {
        try {
            DefaultDnsQuestion defaultDnsQuestion = new DefaultDnsQuestion(str, dnsRecordType, this.dnsClass);
            query(dnsServerAddressStream, 0, defaultDnsQuestion, newDnsQueryLifecycleObserver(defaultDnsQuestion), z3, promise, null);
            return true;
        } catch (Throwable th) {
            promise.tryFailure(new IllegalArgumentException("Unable to create DNS Question for: [" + str + ", " + dnsRecordType + ']', th));
            return false;
        }
    }
}
