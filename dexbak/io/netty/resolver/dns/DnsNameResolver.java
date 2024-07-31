package io.netty.resolver.dns;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoop;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.handler.codec.dns.DatagramDnsQueryEncoder;
import io.netty.handler.codec.dns.DatagramDnsResponse;
import io.netty.handler.codec.dns.DatagramDnsResponseDecoder;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.resolver.HostsFileEntriesResolver;
import io.netty.resolver.InetNameResolver;
import io.netty.util.NetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.IDN;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DnsNameResolver extends InetNameResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final DatagramDnsResponseDecoder DECODER;
    static final InternetProtocolFamily[] DEFAULT_RESOLVE_ADDRESS_TYPES;
    static final String[] DEFAULT_SEACH_DOMAINS;
    private static final DatagramDnsQueryEncoder ENCODER;
    private static final String LOCALHOST = "localhost";
    private static final InetAddress LOCALHOST_ADDRESS;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DnsNameResolver.class);

    /* renamed from: ch */
    final DatagramChannel f40288ch;
    final Future<Channel> channelFuture;
    private final HostsFileEntriesResolver hostsFileEntriesResolver;
    private final int maxPayloadSize;
    private final int maxQueriesPerResolve;
    private final FastThreadLocal<DnsServerAddressStream> nameServerAddrStream;
    final DnsServerAddresses nameServerAddresses;
    private final int ndots;
    private final boolean optResourceEnabled;
    final DnsQueryContextManager queryContextManager;
    private final long queryTimeoutMillis;
    private final boolean recursionDesired;
    private final DnsCache resolveCache;
    private final InternetProtocolFamily[] resolvedAddressTypes;
    private final String[] searchDomains;
    private final boolean traceEnabled;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class DnsResponseHandler extends ChannelInboundHandlerAdapter {
        private final Promise<Channel> channelActivePromise;

        DnsResponseHandler(Promise<Channel> promise) {
            this.channelActivePromise = promise;
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
            super.channelActive(channelHandlerContext);
            this.channelActivePromise.setSuccess(channelHandlerContext.channel());
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
            try {
                DatagramDnsResponse datagramDnsResponse = (DatagramDnsResponse) obj;
                int mo12686id = datagramDnsResponse.mo12686id();
                if (DnsNameResolver.logger.isDebugEnabled()) {
                    DnsNameResolver.logger.debug("{} RECEIVED: [{}: {}], {}", DnsNameResolver.this.f40288ch, Integer.valueOf(mo12686id), datagramDnsResponse.sender(), datagramDnsResponse);
                }
                DnsQueryContext dnsQueryContext = DnsNameResolver.this.queryContextManager.get(datagramDnsResponse.sender(), mo12686id);
                if (dnsQueryContext == null) {
                    DnsNameResolver.logger.warn("{} Received a DNS response with an unknown ID: {}", DnsNameResolver.this.f40288ch, Integer.valueOf(mo12686id));
                } else {
                    dnsQueryContext.finish(datagramDnsResponse);
                }
            } finally {
                ReferenceCountUtil.safeRelease(obj);
            }
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
            DnsNameResolver.logger.warn("{} Unexpected exception: ", DnsNameResolver.this.f40288ch, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class ListResolverContext extends DnsNameResolverContext<List<InetAddress>> {
        ListResolverContext(DnsNameResolver dnsNameResolver, String str, DnsCache dnsCache) {
            super(dnsNameResolver, str, dnsCache);
        }

        @Override // io.netty.resolver.dns.DnsNameResolverContext
        boolean finishResolve(Class<? extends InetAddress> cls, List<DnsCacheEntry> list, Promise<List<InetAddress>> promise) {
            int size = list.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                InetAddress address = list.get(i).address();
                if (cls.isInstance(address)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(size);
                    }
                    arrayList.add(address);
                }
            }
            if (arrayList != null) {
                promise.trySuccess(arrayList);
                return true;
            }
            return false;
        }

        @Override // io.netty.resolver.dns.DnsNameResolverContext
        DnsNameResolverContext<List<InetAddress>> newResolverContext(DnsNameResolver dnsNameResolver, String str, DnsCache dnsCache) {
            return new ListResolverContext(dnsNameResolver, str, dnsCache);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class SingleResolverContext extends DnsNameResolverContext<InetAddress> {
        SingleResolverContext(DnsNameResolver dnsNameResolver, String str, DnsCache dnsCache) {
            super(dnsNameResolver, str, dnsCache);
        }

        @Override // io.netty.resolver.dns.DnsNameResolverContext
        boolean finishResolve(Class<? extends InetAddress> cls, List<DnsCacheEntry> list, Promise<InetAddress> promise) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                InetAddress address = list.get(i).address();
                if (cls.isInstance(address)) {
                    DnsNameResolver.setSuccess(promise, address);
                    return true;
                }
            }
            return false;
        }

        @Override // io.netty.resolver.dns.DnsNameResolverContext
        DnsNameResolverContext<InetAddress> newResolverContext(DnsNameResolver dnsNameResolver, String str, DnsCache dnsCache) {
            return new SingleResolverContext(dnsNameResolver, str, dnsCache);
        }
    }

    static {
        String[] strArr;
        if (NetUtil.isIpV4StackPreferred()) {
            DEFAULT_RESOLVE_ADDRESS_TYPES = new InternetProtocolFamily[]{InternetProtocolFamily.IPv4};
            LOCALHOST_ADDRESS = NetUtil.LOCALHOST4;
        } else {
            InternetProtocolFamily[] internetProtocolFamilyArr = new InternetProtocolFamily[2];
            DEFAULT_RESOLVE_ADDRESS_TYPES = internetProtocolFamilyArr;
            if (NetUtil.isIpV6AddressesPreferred()) {
                internetProtocolFamilyArr[0] = InternetProtocolFamily.IPv6;
                internetProtocolFamilyArr[1] = InternetProtocolFamily.IPv4;
                LOCALHOST_ADDRESS = NetUtil.LOCALHOST6;
            } else {
                internetProtocolFamilyArr[0] = InternetProtocolFamily.IPv4;
                internetProtocolFamilyArr[1] = InternetProtocolFamily.IPv6;
                LOCALHOST_ADDRESS = NetUtil.LOCALHOST4;
            }
        }
        try {
            Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
            List list = (List) cls.getMethod("searchlist", new Class[0]).invoke(cls.getMethod("open", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            strArr = (String[]) list.toArray(new String[list.size()]);
        } catch (Exception unused) {
            strArr = EmptyArrays.EMPTY_STRINGS;
        }
        DEFAULT_SEACH_DOMAINS = strArr;
        DECODER = new DatagramDnsResponseDecoder();
        ENCODER = new DatagramDnsQueryEncoder();
    }

    public DnsNameResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, DnsServerAddresses dnsServerAddresses, final DnsCache dnsCache, long j, InternetProtocolFamily[] internetProtocolFamilyArr, boolean z, int i, boolean z2, int i2, boolean z3, HostsFileEntriesResolver hostsFileEntriesResolver, String[] strArr, int i3) {
        super(eventLoop);
        this.queryContextManager = new DnsQueryContextManager();
        this.nameServerAddrStream = new FastThreadLocal<DnsServerAddressStream>() { // from class: io.netty.resolver.dns.DnsNameResolver.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public DnsServerAddressStream initialValue() throws Exception {
                return DnsNameResolver.this.nameServerAddresses.stream();
            }
        };
        ObjectUtil.checkNotNull(channelFactory, "channelFactory");
        this.nameServerAddresses = (DnsServerAddresses) ObjectUtil.checkNotNull(dnsServerAddresses, "nameServerAddresses");
        this.queryTimeoutMillis = ObjectUtil.checkPositive(j, "queryTimeoutMillis");
        this.resolvedAddressTypes = (InternetProtocolFamily[]) ObjectUtil.checkNonEmpty(internetProtocolFamilyArr, "resolvedAddressTypes");
        this.recursionDesired = z;
        this.maxQueriesPerResolve = ObjectUtil.checkPositive(i, "maxQueriesPerResolve");
        this.traceEnabled = z2;
        this.maxPayloadSize = ObjectUtil.checkPositive(i2, "maxPayloadSize");
        this.optResourceEnabled = z3;
        this.hostsFileEntriesResolver = (HostsFileEntriesResolver) ObjectUtil.checkNotNull(hostsFileEntriesResolver, "hostsFileEntriesResolver");
        this.resolveCache = dnsCache;
        this.searchDomains = (String[]) ((String[]) ObjectUtil.checkNotNull(strArr, "searchDomains")).clone();
        this.ndots = ObjectUtil.checkPositiveOrZero(i3, "ndots");
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(executor());
        bootstrap.channelFactory((ChannelFactory) channelFactory);
        bootstrap.option(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION, Boolean.TRUE);
        final DnsResponseHandler dnsResponseHandler = new DnsResponseHandler(executor().newPromise());
        bootstrap.handler(new ChannelInitializer<DatagramChannel>() { // from class: io.netty.resolver.dns.DnsNameResolver.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.channel.ChannelInitializer
            public void initChannel(DatagramChannel datagramChannel) throws Exception {
                datagramChannel.pipeline().addLast(DnsNameResolver.DECODER, DnsNameResolver.ENCODER, dnsResponseHandler);
            }
        });
        this.channelFuture = dnsResponseHandler.channelActivePromise;
        DatagramChannel datagramChannel = (DatagramChannel) bootstrap.register().channel();
        this.f40288ch = datagramChannel;
        datagramChannel.config().setRecvByteBufAllocator((RecvByteBufAllocator) new FixedRecvByteBufAllocator(i2));
        datagramChannel.closeFuture().addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.resolver.dns.DnsNameResolver.3
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                dnsCache.clear();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> cast(Promise<?> promise) {
        return promise;
    }

    private boolean doResolveAllCached(String str, Promise<List<InetAddress>> promise, DnsCache dnsCache) {
        ArrayList arrayList;
        InternetProtocolFamily[] internetProtocolFamilyArr;
        Throwable th;
        List<DnsCacheEntry> list = dnsCache.get(str);
        if (list == null || list.isEmpty()) {
            return false;
        }
        synchronized (list) {
            int size = list.size();
            arrayList = null;
            if (list.get(0).cause() != null) {
                th = list.get(0).cause();
            } else {
                ArrayList arrayList2 = null;
                for (InternetProtocolFamily internetProtocolFamily : this.resolvedAddressTypes) {
                    for (int i = 0; i < size; i++) {
                        DnsCacheEntry dnsCacheEntry = list.get(i);
                        if (internetProtocolFamily.addressType().isInstance(dnsCacheEntry.address())) {
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList(size);
                            }
                            arrayList2.add(dnsCacheEntry.address());
                        }
                    }
                }
                th = null;
                arrayList = arrayList2;
            }
        }
        if (arrayList != null) {
            promise.trySuccess(arrayList);
            return true;
        } else if (th != null) {
            promise.tryFailure(th);
            return true;
        } else {
            return false;
        }
    }

    private void doResolveAllUncached(String str, Promise<List<InetAddress>> promise, DnsCache dnsCache) {
        new ListResolverContext(this, str, dnsCache).resolve(promise);
    }

    private boolean doResolveCached(String str, Promise<InetAddress> promise, DnsCache dnsCache) {
        InetAddress inetAddress;
        InternetProtocolFamily[] internetProtocolFamilyArr;
        Throwable th;
        List<DnsCacheEntry> list = dnsCache.get(str);
        if (list == null || list.isEmpty()) {
            return false;
        }
        synchronized (list) {
            int size = list.size();
            inetAddress = null;
            if (list.get(0).cause() != null) {
                th = list.get(0).cause();
            } else {
                InetAddress inetAddress2 = null;
                for (InternetProtocolFamily internetProtocolFamily : this.resolvedAddressTypes) {
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            DnsCacheEntry dnsCacheEntry = list.get(i);
                            if (internetProtocolFamily.addressType().isInstance(dnsCacheEntry.address())) {
                                inetAddress2 = dnsCacheEntry.address();
                                break;
                            }
                            i++;
                        }
                    }
                }
                th = null;
                inetAddress = inetAddress2;
            }
        }
        if (inetAddress != null) {
            setSuccess(promise, inetAddress);
            return true;
        } else if (th != null) {
            if (promise.tryFailure(th)) {
                return true;
            }
            logger.warn("Failed to notify failure to a promise: {}", promise, th);
            return true;
        } else {
            return false;
        }
    }

    private void doResolveUncached(String str, Promise<InetAddress> promise, DnsCache dnsCache) {
        new SingleResolverContext(this, str, dnsCache).resolve(promise);
    }

    private static String hostname(String str) {
        String ascii = IDN.toASCII(str);
        if (!StringUtil.endsWith(str, '.') || StringUtil.endsWith(ascii, '.')) {
            return ascii;
        }
        return ascii + ".";
    }

    private InetSocketAddress nextNameServerAddress() {
        return this.nameServerAddrStream.get().next();
    }

    private Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query0(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> cast = cast((Promise) ObjectUtil.checkNotNull(promise, "promise"));
        try {
            new DnsQueryContext(this, inetSocketAddress, dnsQuestion, iterable, cast).query();
            return cast;
        } catch (Exception e) {
            return cast.setFailure(e);
        }
    }

    private InetAddress resolveHostsFileEntry(String str) {
        HostsFileEntriesResolver hostsFileEntriesResolver = this.hostsFileEntriesResolver;
        if (hostsFileEntriesResolver == null) {
            return null;
        }
        InetAddress address = hostsFileEntriesResolver.address(str);
        return (address == null && PlatformDependent.isWindows() && LOCALHOST.equalsIgnoreCase(str)) ? LOCALHOST_ADDRESS : address;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setSuccess(Promise<InetAddress> promise, InetAddress inetAddress) {
        if (promise.trySuccess(inetAddress)) {
            return;
        }
        logger.warn("Failed to notify success ({}) to a promise: {}", inetAddress, promise);
    }

    @Override // io.netty.resolver.SimpleNameResolver, io.netty.resolver.NameResolver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f40288ch.isOpen()) {
            this.f40288ch.close();
        }
    }

    @Override // io.netty.resolver.SimpleNameResolver
    protected void doResolve(String str, Promise<InetAddress> promise) throws Exception {
        doResolve(str, promise, this.resolveCache);
    }

    @Override // io.netty.resolver.SimpleNameResolver
    protected void doResolveAll(String str, Promise<List<InetAddress>> promise) throws Exception {
        doResolveAll(str, promise, this.resolveCache);
    }

    public HostsFileEntriesResolver hostsFileEntriesResolver() {
        return this.hostsFileEntriesResolver;
    }

    public boolean isOptResourceEnabled() {
        return this.optResourceEnabled;
    }

    public boolean isRecursionDesired() {
        return this.recursionDesired;
    }

    public boolean isTraceEnabled() {
        return this.traceEnabled;
    }

    public int maxPayloadSize() {
        return this.maxPayloadSize;
    }

    public int maxQueriesPerResolve() {
        return this.maxQueriesPerResolve;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int ndots() {
        return this.ndots;
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion dnsQuestion) {
        return query(nextNameServerAddress(), dnsQuestion);
    }

    public long queryTimeoutMillis() {
        return this.queryTimeoutMillis;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InternetProtocolFamily[] resolveAddressTypesUnsafe() {
        return this.resolvedAddressTypes;
    }

    public DnsCache resolveCache() {
        return this.resolveCache;
    }

    public List<InternetProtocolFamily> resolvedAddressTypes() {
        return Arrays.asList(this.resolvedAddressTypes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String[] searchDomains() {
        return this.searchDomains;
    }

    protected void doResolve(String str, Promise<InetAddress> promise, DnsCache dnsCache) throws Exception {
        byte[] createByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString(str);
        if (createByteArrayFromIpAddressString != null) {
            promise.setSuccess(InetAddress.getByAddress(createByteArrayFromIpAddressString));
            return;
        }
        String hostname = hostname(str);
        InetAddress resolveHostsFileEntry = resolveHostsFileEntry(hostname);
        if (resolveHostsFileEntry != null) {
            promise.setSuccess(resolveHostsFileEntry);
        } else if (doResolveCached(hostname, promise, dnsCache)) {
        } else {
            doResolveUncached(hostname, promise, dnsCache);
        }
    }

    protected void doResolveAll(String str, Promise<List<InetAddress>> promise, DnsCache dnsCache) throws Exception {
        byte[] createByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString(str);
        if (createByteArrayFromIpAddressString != null) {
            promise.setSuccess(Collections.singletonList(InetAddress.getByAddress(createByteArrayFromIpAddressString)));
            return;
        }
        String hostname = hostname(str);
        InetAddress resolveHostsFileEntry = resolveHostsFileEntry(hostname);
        if (resolveHostsFileEntry != null) {
            promise.setSuccess(Collections.singletonList(resolveHostsFileEntry));
        } else if (doResolveAllCached(hostname, promise, dnsCache)) {
        } else {
            doResolveAllUncached(hostname, promise, dnsCache);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.resolver.SimpleNameResolver
    public EventLoop executor() {
        return (EventLoop) super.executor();
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable) {
        return query(nextNameServerAddress(), dnsQuestion, iterable);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion dnsQuestion, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query(nextNameServerAddress(), dnsQuestion, Collections.emptyList(), promise);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion) {
        return query0(inetSocketAddress, dnsQuestion, Collections.emptyList(), this.f40288ch.eventLoop().newPromise());
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable) {
        return query0(inetSocketAddress, dnsQuestion, iterable, this.f40288ch.eventLoop().newPromise());
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query0(inetSocketAddress, dnsQuestion, Collections.emptyList(), promise);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query0(inetSocketAddress, dnsQuestion, iterable, promise);
    }
}
