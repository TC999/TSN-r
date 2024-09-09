package io.netty.resolver.dns;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.AddressedEnvelope;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFactory;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.FixedRecvByteBufAllocator;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.dns.DatagramDnsQueryEncoder;
import io.netty.handler.codec.dns.DatagramDnsResponse;
import io.netty.handler.codec.dns.DatagramDnsResponseDecoder;
import io.netty.handler.codec.dns.DefaultDnsRawRecord;
import io.netty.handler.codec.dns.DnsQuestion;
import io.netty.handler.codec.dns.DnsRawRecord;
import io.netty.handler.codec.dns.DnsRecord;
import io.netty.handler.codec.dns.DnsRecordType;
import io.netty.handler.codec.dns.DnsResponse;
import io.netty.handler.codec.dns.TcpDnsQueryEncoder;
import io.netty.handler.codec.dns.TcpDnsResponseDecoder;
import io.netty.resolver.HostsFileEntriesResolver;
import io.netty.resolver.InetNameResolver;
import io.netty.resolver.ResolvedAddressTypes;
import io.netty.util.NetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.IDN;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DnsNameResolver extends InetNameResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final DatagramDnsResponseDecoder DATAGRAM_DECODER;
    private static final DatagramDnsQueryEncoder DATAGRAM_ENCODER;
    private static final int DEFAULT_NDOTS;
    static final ResolvedAddressTypes DEFAULT_RESOLVE_ADDRESS_TYPES;
    static final String[] DEFAULT_SEARCH_DOMAINS;
    private static final InternetProtocolFamily[] IPV4_ONLY_RESOLVED_PROTOCOL_FAMILIES;
    private static final DnsRecordType[] IPV4_ONLY_RESOLVED_RECORD_TYPES;
    private static final InternetProtocolFamily[] IPV4_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
    private static final DnsRecordType[] IPV4_PREFERRED_RESOLVED_RECORD_TYPES;
    private static final InternetProtocolFamily[] IPV6_ONLY_RESOLVED_PROTOCOL_FAMILIES;
    private static final DnsRecordType[] IPV6_ONLY_RESOLVED_RECORD_TYPES;
    private static final InternetProtocolFamily[] IPV6_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
    private static final DnsRecordType[] IPV6_PREFERRED_RESOLVED_RECORD_TYPES;
    private static final String LOCALHOST = "localhost";
    private static final InetAddress LOCALHOST_ADDRESS;
    private static final TcpDnsQueryEncoder TCP_ENCODER;
    private final AuthoritativeDnsServerCache authoritativeDnsServerCache;
    final Channel ch;
    final Future<Channel> channelFuture;
    private final DnsCnameCache cnameCache;
    private final boolean completeOncePreferredResolved;
    private final boolean decodeIdn;
    private final DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory;
    private final DnsServerAddressStreamProvider dnsServerAddressStreamProvider;
    private final HostsFileEntriesResolver hostsFileEntriesResolver;
    private final int maxPayloadSize;
    private final int maxQueriesPerResolve;
    private final FastThreadLocal<DnsServerAddressStream> nameServerAddrStream;
    private final Comparator<InetSocketAddress> nameServerComparator;
    private final int ndots;
    private final boolean optResourceEnabled;
    private final InternetProtocolFamily preferredAddressType;
    final DnsQueryContextManager queryContextManager;
    private final long queryTimeoutMillis;
    private final boolean recursionDesired;
    private final DnsCache resolveCache;
    private final DnsRecordType[] resolveRecordTypes;
    private final ResolvedAddressTypes resolvedAddressTypes;
    private final InternetProtocolFamily[] resolvedInternetProtocolFamilies;
    private final String[] searchDomains;
    private final ChannelFactory<? extends SocketChannel> socketChannelFactory;
    private final boolean supportsAAAARecords;
    private final boolean supportsARecords;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DnsNameResolver.class);
    private static final DnsRecord[] EMPTY_ADDITIONALS = new DnsRecord[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.resolver.dns.DnsNameResolver$6  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$resolver$ResolvedAddressTypes;

        static {
            int[] iArr = new int[ResolvedAddressTypes.values().length];
            $SwitchMap$io$netty$resolver$ResolvedAddressTypes = iArr;
            try {
                iArr[ResolvedAddressTypes.IPV4_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV4_PREFERRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV6_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$resolver$ResolvedAddressTypes[ResolvedAddressTypes.IPV6_PREFERRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private final class AddressedEnvelopeAdapter implements AddressedEnvelope<DnsResponse, InetSocketAddress> {
        private final InetSocketAddress recipient;
        private final DnsResponse response;
        private final InetSocketAddress sender;

        AddressedEnvelopeAdapter(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, DnsResponse dnsResponse) {
            this.sender = inetSocketAddress;
            this.recipient = inetSocketAddress2;
            this.response = dnsResponse;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AddressedEnvelope) {
                AddressedEnvelope addressedEnvelope = (AddressedEnvelope) obj;
                if (sender() == null) {
                    if (addressedEnvelope.sender() != null) {
                        return false;
                    }
                } else if (!sender().equals(addressedEnvelope.sender())) {
                    return false;
                }
                if (recipient() == null) {
                    if (addressedEnvelope.recipient() != null) {
                        return false;
                    }
                } else if (!recipient().equals(addressedEnvelope.recipient())) {
                    return false;
                }
                return this.response.equals(obj);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.response.hashCode();
            if (sender() != null) {
                hashCode = (hashCode * 31) + sender().hashCode();
            }
            return recipient() != null ? (hashCode * 31) + recipient().hashCode() : hashCode;
        }

        @Override // io.netty.util.ReferenceCounted
        public int refCnt() {
            return this.response.refCnt();
        }

        @Override // io.netty.util.ReferenceCounted
        public boolean release() {
            return this.response.release();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.channel.AddressedEnvelope
        public DnsResponse content() {
            return this.response;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.channel.AddressedEnvelope
        public InetSocketAddress recipient() {
            return this.recipient;
        }

        @Override // io.netty.util.ReferenceCounted
        public boolean release(int i4) {
            return this.response.release(i4);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.channel.AddressedEnvelope
        public InetSocketAddress sender() {
            return this.sender;
        }

        @Override // io.netty.util.ReferenceCounted
        public AddressedEnvelope<DnsResponse, InetSocketAddress> retain() {
            this.response.retain();
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public AddressedEnvelope<DnsResponse, InetSocketAddress> touch() {
            this.response.touch();
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public AddressedEnvelope<DnsResponse, InetSocketAddress> retain(int i4) {
            this.response.retain(i4);
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public AddressedEnvelope<DnsResponse, InetSocketAddress> touch(Object obj) {
            this.response.touch(obj);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
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
        public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
            try {
                final DatagramDnsResponse datagramDnsResponse = (DatagramDnsResponse) obj;
                final int id = datagramDnsResponse.id();
                if (DnsNameResolver.logger.isDebugEnabled()) {
                    DnsNameResolver.logger.debug("{} RECEIVED: UDP [{}: {}], {}", DnsNameResolver.this.ch, Integer.valueOf(id), datagramDnsResponse.sender(), datagramDnsResponse);
                }
                final DnsQueryContext dnsQueryContext = DnsNameResolver.this.queryContextManager.get(datagramDnsResponse.sender(), id);
                if (dnsQueryContext == null) {
                    DnsNameResolver.logger.warn("{} Received a DNS response with an unknown ID: {}", DnsNameResolver.this.ch, Integer.valueOf(id));
                    return;
                }
                if (datagramDnsResponse.isTruncated() && DnsNameResolver.this.socketChannelFactory != null) {
                    datagramDnsResponse.retain();
                    Bootstrap bootstrap = new Bootstrap();
                    bootstrap.option(ChannelOption.SO_REUSEADDR, Boolean.TRUE).group(DnsNameResolver.this.executor()).channelFactory(DnsNameResolver.this.socketChannelFactory).handler(new ChannelInitializer<Channel>() { // from class: io.netty.resolver.dns.DnsNameResolver.DnsResponseHandler.1
                        @Override // io.netty.channel.ChannelInitializer
                        protected void initChannel(Channel channel) {
                            channel.pipeline().addLast(DnsNameResolver.TCP_ENCODER);
                            channel.pipeline().addLast(new TcpDnsResponseDecoder());
                            channel.pipeline().addLast(new ChannelInboundHandlerAdapter() { // from class: io.netty.resolver.dns.DnsNameResolver.DnsResponseHandler.1.1
                                private boolean finish;

                                @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
                                public void channelRead(ChannelHandlerContext channelHandlerContext2, Object obj2) {
                                    try {
                                        Channel channel2 = channelHandlerContext2.channel();
                                        DnsResponse dnsResponse = (DnsResponse) obj2;
                                        int id2 = dnsResponse.id();
                                        if (DnsNameResolver.logger.isDebugEnabled()) {
                                            DnsNameResolver.logger.debug("{} RECEIVED: TCP [{}: {}], {}", channel2, Integer.valueOf(id2), channel2.remoteAddress(), dnsResponse);
                                        }
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        DnsQueryContext dnsQueryContext2 = DnsNameResolver.this.queryContextManager.get(datagramDnsResponse.sender(), id2);
                                        if (dnsQueryContext2 == null) {
                                            DnsNameResolver.logger.warn("{} Received a DNS response with an unknown ID: {}", channel2, Integer.valueOf(id2));
                                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                            dnsQueryContext.finish(datagramDnsResponse);
                                            return;
                                        }
                                        datagramDnsResponse.release();
                                        dnsQueryContext2.finish(new AddressedEnvelopeAdapter((InetSocketAddress) channelHandlerContext2.channel().remoteAddress(), (InetSocketAddress) channelHandlerContext2.channel().localAddress(), dnsResponse));
                                        this.finish = true;
                                    } finally {
                                        ReferenceCountUtil.release(obj2);
                                    }
                                }

                                @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
                                public void exceptionCaught(ChannelHandlerContext channelHandlerContext2, Throwable th) {
                                    if (this.finish) {
                                        return;
                                    }
                                    if (DnsNameResolver.logger.isDebugEnabled()) {
                                        DnsNameResolver.logger.debug("{} Error during processing response: TCP [{}: {}]", channelHandlerContext2.channel(), Integer.valueOf(id), channelHandlerContext2.channel().remoteAddress(), th);
                                    }
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    dnsQueryContext.finish(datagramDnsResponse);
                                }
                            });
                        }
                    });
                    bootstrap.connect(datagramDnsResponse.sender()).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.resolver.dns.DnsNameResolver.DnsResponseHandler.2
                        @Override // io.netty.util.concurrent.GenericFutureListener
                        public void operationComplete(ChannelFuture channelFuture) {
                            if (channelFuture.isSuccess()) {
                                final Channel channel = channelFuture.channel();
                                Promise newPromise = channel.eventLoop().newPromise();
                                new TcpDnsQueryContext(DnsNameResolver.this, channel, (InetSocketAddress) channel.remoteAddress(), dnsQueryContext.question(), DnsNameResolver.EMPTY_ADDITIONALS, newPromise).query(true, channelFuture.channel().newPromise());
                                newPromise.addListener((GenericFutureListener) new FutureListener<AddressedEnvelope<DnsResponse, InetSocketAddress>>() { // from class: io.netty.resolver.dns.DnsNameResolver.DnsResponseHandler.2.1
                                    @Override // io.netty.util.concurrent.GenericFutureListener
                                    public void operationComplete(Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> future) {
                                        channel.close();
                                        if (future.isSuccess()) {
                                            dnsQueryContext.finish(future.getNow());
                                            return;
                                        }
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        dnsQueryContext.finish(datagramDnsResponse);
                                    }
                                });
                                return;
                            }
                            if (DnsNameResolver.logger.isDebugEnabled()) {
                                DnsNameResolver.logger.debug("{} Unable to fallback to TCP [{}]", Integer.valueOf(id), channelFuture.cause());
                            }
                            dnsQueryContext.finish(datagramDnsResponse);
                        }
                    });
                } else {
                    dnsQueryContext.finish(datagramDnsResponse);
                }
            } finally {
                ReferenceCountUtil.safeRelease(obj);
            }
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
            DnsNameResolver.logger.warn("{} Unexpected exception: ", channelHandlerContext.channel(), th);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    final class ListResolverContext extends DnsNameResolverContext<List<InetAddress>> {
        ListResolverContext(DnsNameResolver dnsNameResolver, String str, DnsCache dnsCache) {
            super(dnsNameResolver, str, dnsCache);
        }

        @Override // io.netty.resolver.dns.DnsNameResolverContext
        boolean finishResolve(Class<? extends InetAddress> cls, List<DnsCacheEntry> list, Promise<List<InetAddress>> promise) {
            int size = list.size();
            ArrayList arrayList = null;
            for (int i4 = 0; i4 < size; i4++) {
                InetAddress address = list.get(i4).address();
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

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    final class SingleResolverContext extends DnsNameResolverContext<InetAddress> {
        SingleResolverContext(DnsNameResolver dnsNameResolver, String str, DnsCache dnsCache) {
            super(dnsNameResolver, str, dnsCache);
        }

        @Override // io.netty.resolver.dns.DnsNameResolverContext
        boolean finishResolve(Class<? extends InetAddress> cls, List<DnsCacheEntry> list, Promise<InetAddress> promise) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                InetAddress address = list.get(i4).address();
                if (cls.isInstance(address)) {
                    DnsNameResolver.access$300(promise, address);
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
        List<String> parseEtcResolverSearchDomains;
        int i4 = 1;
        DnsRecordType dnsRecordType = DnsRecordType.A;
        IPV4_ONLY_RESOLVED_RECORD_TYPES = new DnsRecordType[]{dnsRecordType};
        InternetProtocolFamily internetProtocolFamily = InternetProtocolFamily.IPv4;
        IPV4_ONLY_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[]{internetProtocolFamily};
        DnsRecordType dnsRecordType2 = DnsRecordType.AAAA;
        IPV4_PREFERRED_RESOLVED_RECORD_TYPES = new DnsRecordType[]{dnsRecordType, dnsRecordType2};
        InternetProtocolFamily internetProtocolFamily2 = InternetProtocolFamily.IPv6;
        IPV4_PREFERRED_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[]{internetProtocolFamily, internetProtocolFamily2};
        IPV6_ONLY_RESOLVED_RECORD_TYPES = new DnsRecordType[]{dnsRecordType2};
        IPV6_ONLY_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[]{internetProtocolFamily2};
        IPV6_PREFERRED_RESOLVED_RECORD_TYPES = new DnsRecordType[]{dnsRecordType2, dnsRecordType};
        IPV6_PREFERRED_RESOLVED_PROTOCOL_FAMILIES = new InternetProtocolFamily[]{internetProtocolFamily2, internetProtocolFamily};
        if (!NetUtil.isIpV4StackPreferred() && anyInterfaceSupportsIpV6()) {
            if (NetUtil.isIpV6AddressesPreferred()) {
                DEFAULT_RESOLVE_ADDRESS_TYPES = ResolvedAddressTypes.IPV6_PREFERRED;
                LOCALHOST_ADDRESS = NetUtil.LOCALHOST6;
            } else {
                DEFAULT_RESOLVE_ADDRESS_TYPES = ResolvedAddressTypes.IPV4_PREFERRED;
                LOCALHOST_ADDRESS = NetUtil.LOCALHOST4;
            }
        } else {
            DEFAULT_RESOLVE_ADDRESS_TYPES = ResolvedAddressTypes.IPV4_ONLY;
            LOCALHOST_ADDRESS = NetUtil.LOCALHOST4;
        }
        try {
            if (PlatformDependent.isWindows()) {
                parseEtcResolverSearchDomains = getSearchDomainsHack();
            } else {
                parseEtcResolverSearchDomains = UnixResolverDnsServerAddressStreamProvider.parseEtcResolverSearchDomains();
            }
            strArr = (String[]) parseEtcResolverSearchDomains.toArray(new String[0]);
        } catch (Exception unused) {
            strArr = EmptyArrays.EMPTY_STRINGS;
        }
        DEFAULT_SEARCH_DOMAINS = strArr;
        try {
            i4 = UnixResolverDnsServerAddressStreamProvider.parseEtcResolverFirstNdots();
        } catch (Exception unused2) {
        }
        DEFAULT_NDOTS = i4;
        DATAGRAM_DECODER = new DatagramDnsResponseDecoder();
        DATAGRAM_ENCODER = new DatagramDnsQueryEncoder();
        TCP_ENCODER = new TcpDnsQueryEncoder();
    }

    @Deprecated
    public DnsNameResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, DnsCache dnsCache, DnsCache dnsCache2, DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory, long j4, ResolvedAddressTypes resolvedAddressTypes, boolean z3, int i4, boolean z4, int i5, boolean z5, HostsFileEntriesResolver hostsFileEntriesResolver, DnsServerAddressStreamProvider dnsServerAddressStreamProvider, String[] strArr, int i6, boolean z6) {
        this(eventLoop, channelFactory, dnsCache, new AuthoritativeDnsServerCacheAdapter(dnsCache2), dnsQueryLifecycleObserverFactory, j4, resolvedAddressTypes, z3, i4, z4, i5, z5, hostsFileEntriesResolver, dnsServerAddressStreamProvider, strArr, i6, z6);
    }

    private static boolean anyInterfaceSupportsIpV6() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    if (inetAddresses.nextElement() instanceof Inet6Address) {
                        return true;
                    }
                }
            }
            return false;
        } catch (SocketException e4) {
            logger.debug("Unable to detect if any interface supports IPv6, assuming IPv4-only", (Throwable) e4);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> cast(Promise<?> promise) {
        return promise;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean doResolveAllCached(String str, DnsRecord[] dnsRecordArr, Promise<List<InetAddress>> promise, DnsCache dnsCache, InternetProtocolFamily[] internetProtocolFamilyArr) {
        List<? extends DnsCacheEntry> list = dnsCache.get(str, dnsRecordArr);
        if (list == null || list.isEmpty()) {
            return false;
        }
        Throwable cause = list.get(0).cause();
        if (cause == null) {
            ArrayList arrayList = null;
            int size = list.size();
            for (InternetProtocolFamily internetProtocolFamily : internetProtocolFamilyArr) {
                for (int i4 = 0; i4 < size; i4++) {
                    DnsCacheEntry dnsCacheEntry = list.get(i4);
                    if (internetProtocolFamily.addressType().isInstance(dnsCacheEntry.address())) {
                        if (arrayList == null) {
                            arrayList = new ArrayList(size);
                        }
                        arrayList.add(dnsCacheEntry.address());
                    }
                }
            }
            if (arrayList != null) {
                trySuccess(promise, arrayList);
                return true;
            }
            return false;
        }
        tryFailure(promise, cause);
        return true;
    }

    private void doResolveAllUncached(final String str, final DnsRecord[] dnsRecordArr, final Promise<List<InetAddress>> promise, final DnsCache dnsCache, final boolean z3) {
        EventLoop executor = executor();
        if (executor.inEventLoop()) {
            doResolveAllUncached0(str, dnsRecordArr, promise, dnsCache, z3);
        } else {
            executor.execute(new Runnable() { // from class: io.netty.resolver.dns.DnsNameResolver.5
                @Override // java.lang.Runnable
                public void run() {
                    DnsNameResolver.this.doResolveAllUncached0(str, dnsRecordArr, promise, dnsCache, z3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doResolveAllUncached0(String str, DnsRecord[] dnsRecordArr, Promise<List<InetAddress>> promise, DnsCache dnsCache, boolean z3) {
        new DnsAddressResolveContext(this, str, dnsRecordArr, this.dnsServerAddressStreamProvider.nameServerAddressStream(str), dnsCache, this.authoritativeDnsServerCache, z3).resolve(promise);
    }

    private boolean doResolveCached(String str, DnsRecord[] dnsRecordArr, Promise<InetAddress> promise, DnsCache dnsCache) {
        InternetProtocolFamily[] internetProtocolFamilyArr;
        List<? extends DnsCacheEntry> list = dnsCache.get(str, dnsRecordArr);
        if (list == null || list.isEmpty()) {
            return false;
        }
        Throwable cause = list.get(0).cause();
        if (cause == null) {
            int size = list.size();
            for (InternetProtocolFamily internetProtocolFamily : this.resolvedInternetProtocolFamilies) {
                for (int i4 = 0; i4 < size; i4++) {
                    DnsCacheEntry dnsCacheEntry = list.get(i4);
                    if (internetProtocolFamily.addressType().isInstance(dnsCacheEntry.address())) {
                        trySuccess(promise, dnsCacheEntry.address());
                        return true;
                    }
                }
            }
            return false;
        }
        tryFailure(promise, cause);
        return true;
    }

    private void doResolveUncached(String str, DnsRecord[] dnsRecordArr, final Promise<InetAddress> promise, DnsCache dnsCache, boolean z3) {
        Promise<List<InetAddress>> newPromise = executor().newPromise();
        doResolveAllUncached(str, dnsRecordArr, newPromise, dnsCache, true);
        newPromise.addListener((GenericFutureListener<? extends Future<? super List<InetAddress>>>) new FutureListener<List<InetAddress>>() { // from class: io.netty.resolver.dns.DnsNameResolver.4
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<List<InetAddress>> future) {
                if (future.isSuccess()) {
                    DnsNameResolver.trySuccess(promise, future.getNow().get(0));
                } else {
                    DnsNameResolver.tryFailure(promise, future.cause());
                }
            }
        });
    }

    private static List<String> getSearchDomainsHack() throws Exception {
        Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
        return (List) cls.getMethod("searchlist", new Class[0]).invoke(cls.getMethod("open", new Class[0]).invoke(null, new Object[0]), new Object[0]);
    }

    private static String hostname(String str) {
        String ascii = IDN.toASCII(str);
        if (!StringUtil.endsWith(str, '.') || StringUtil.endsWith(ascii, '.')) {
            return ascii;
        }
        return ascii + ".";
    }

    public static boolean isTimeoutError(Throwable th) {
        return th != null && (th.getCause() instanceof DnsNameResolverTimeoutException);
    }

    public static boolean isTransportOrTimeoutError(Throwable th) {
        return th != null && (th.getCause() instanceof DnsNameResolverException);
    }

    private InetAddress loopbackAddress() {
        return preferredAddressType().localhost();
    }

    private InetSocketAddress nextNameServerAddress() {
        return this.nameServerAddrStream.get().next();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InternetProtocolFamily preferredAddressType(ResolvedAddressTypes resolvedAddressTypes) {
        int i4 = AnonymousClass6.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[resolvedAddressTypes.ordinal()];
        if (i4 == 1 || i4 == 2) {
            return InternetProtocolFamily.IPv4;
        }
        if (i4 != 3 && i4 != 4) {
            throw new IllegalArgumentException("Unknown ResolvedAddressTypes " + resolvedAddressTypes);
        }
        return InternetProtocolFamily.IPv6;
    }

    private InetAddress resolveHostsFileEntry(String str) {
        HostsFileEntriesResolver hostsFileEntriesResolver = this.hostsFileEntriesResolver;
        if (hostsFileEntriesResolver == null) {
            return null;
        }
        InetAddress address = hostsFileEntriesResolver.address(str, this.resolvedAddressTypes);
        return (address == null && PlatformDependent.isWindows() && "localhost".equalsIgnoreCase(str)) ? LOCALHOST_ADDRESS : address;
    }

    private static DnsRecord[] toArray(Iterable<DnsRecord> iterable, boolean z3) {
        ObjectUtil.checkNotNull(iterable, "additionals");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            for (DnsRecord dnsRecord : iterable) {
                validateAdditional(dnsRecord, z3);
            }
            return (DnsRecord[]) collection.toArray(new DnsRecord[collection.size()]);
        }
        Iterator<DnsRecord> it = iterable.iterator();
        if (!it.hasNext()) {
            return EMPTY_ADDITIONALS;
        }
        ArrayList arrayList = new ArrayList();
        do {
            DnsRecord next = it.next();
            validateAdditional(next, z3);
            arrayList.add(next);
        } while (it.hasNext());
        return (DnsRecord[]) arrayList.toArray(new DnsRecord[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tryFailure(Promise<?> promise, Throwable th) {
        if (promise.tryFailure(th)) {
            return;
        }
        logger.trace("Failed to notify failure to a promise: {}", promise, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void trySuccess(Promise<T> promise, T t3) {
        if (promise.trySuccess(t3)) {
            return;
        }
        logger.trace("Failed to notify success ({}) to a promise: {}", t3, promise);
    }

    private static void validateAdditional(DnsRecord dnsRecord, boolean z3) {
        ObjectUtil.checkNotNull(dnsRecord, "record");
        if (z3 && (dnsRecord instanceof DnsRawRecord)) {
            throw new IllegalArgumentException("DnsRawRecord implementations not allowed: " + dnsRecord);
        }
    }

    public AuthoritativeDnsServerCache authoritativeDnsServerCache() {
        return this.authoritativeDnsServerCache;
    }

    @Override // io.netty.resolver.SimpleNameResolver, io.netty.resolver.NameResolver, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.ch.isOpen()) {
            this.ch.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DnsCnameCache cnameCache() {
        return this.cnameCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory() {
        return this.dnsQueryLifecycleObserverFactory;
    }

    @Override // io.netty.resolver.SimpleNameResolver
    protected void doResolve(String str, Promise<InetAddress> promise) throws Exception {
        doResolve(str, EMPTY_ADDITIONALS, promise, this.resolveCache);
    }

    @Override // io.netty.resolver.SimpleNameResolver
    protected void doResolveAll(String str, Promise<List<InetAddress>> promise) throws Exception {
        doResolveAll(str, EMPTY_ADDITIONALS, promise, this.resolveCache);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void flushQueries() {
        this.ch.flush();
    }

    public HostsFileEntriesResolver hostsFileEntriesResolver() {
        return this.hostsFileEntriesResolver;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isDecodeIdn() {
        return this.decodeIdn;
    }

    public boolean isOptResourceEnabled() {
        return this.optResourceEnabled;
    }

    public boolean isRecursionDesired() {
        return this.recursionDesired;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public final DnsServerAddressStream newNameServerAddressStream(String str) {
        return this.dnsServerAddressStreamProvider.nameServerAddressStream(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DnsServerAddressStream newRedirectDnsServerStream(String str, List<InetSocketAddress> list) {
        DnsServerAddressStream dnsServerAddressStream = authoritativeDnsServerCache().get(str);
        if (dnsServerAddressStream == null || dnsServerAddressStream.size() == 0) {
            Collections.sort(list, this.nameServerComparator);
            return new SequentialDnsServerAddressStream(list, 0);
        }
        return dnsServerAddressStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InetSocketAddress newRedirectServerAddress(InetAddress inetAddress) {
        return new InetSocketAddress(inetAddress, 53);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion dnsQuestion) {
        return query(nextNameServerAddress(), dnsQuestion);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query0(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, DnsRecord[] dnsRecordArr, boolean z3, ChannelPromise channelPromise, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        Promise<AddressedEnvelope<DnsResponse, InetSocketAddress>> cast = cast((Promise) ObjectUtil.checkNotNull(promise, "promise"));
        try {
            new DatagramDnsQueryContext(this, inetSocketAddress, dnsQuestion, dnsRecordArr, cast).query(z3, channelPromise);
            return cast;
        } catch (Exception e4) {
            return cast.setFailure(e4);
        }
    }

    public long queryTimeoutMillis() {
        return this.queryTimeoutMillis;
    }

    public final Future<InetAddress> resolve(String str, Iterable<DnsRecord> iterable) {
        return resolve(str, iterable, executor().newPromise());
    }

    public final Future<List<InetAddress>> resolveAll(String str, Iterable<DnsRecord> iterable) {
        return resolveAll(str, iterable, executor().newPromise());
    }

    public DnsCache resolveCache() {
        return this.resolveCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final DnsRecordType[] resolveRecordTypes() {
        return this.resolveRecordTypes;
    }

    public ResolvedAddressTypes resolvedAddressTypes() {
        return this.resolvedAddressTypes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InternetProtocolFamily[] resolvedInternetProtocolFamiliesUnsafe() {
        return this.resolvedInternetProtocolFamilies;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String[] searchDomains() {
        return this.searchDomains;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean supportsAAAARecords() {
        return this.supportsAAAARecords;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean supportsARecords() {
        return this.supportsARecords;
    }

    @Deprecated
    public DnsNameResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, DnsCache dnsCache, AuthoritativeDnsServerCache authoritativeDnsServerCache, DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory, long j4, ResolvedAddressTypes resolvedAddressTypes, boolean z3, int i4, boolean z4, int i5, boolean z5, HostsFileEntriesResolver hostsFileEntriesResolver, DnsServerAddressStreamProvider dnsServerAddressStreamProvider, String[] strArr, int i6, boolean z6) {
        this(eventLoop, channelFactory, null, dnsCache, NoopDnsCnameCache.INSTANCE, authoritativeDnsServerCache, dnsQueryLifecycleObserverFactory, j4, resolvedAddressTypes, z3, i4, z4, i5, z5, hostsFileEntriesResolver, dnsServerAddressStreamProvider, strArr, i6, z6, false);
    }

    protected void doResolve(String str, DnsRecord[] dnsRecordArr, Promise<InetAddress> promise, DnsCache dnsCache) throws Exception {
        if (str != null && !str.isEmpty()) {
            byte[] createByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString(str);
            if (createByteArrayFromIpAddressString != null) {
                promise.setSuccess(InetAddress.getByAddress(createByteArrayFromIpAddressString));
                return;
            }
            String hostname = hostname(str);
            InetAddress resolveHostsFileEntry = resolveHostsFileEntry(hostname);
            if (resolveHostsFileEntry != null) {
                promise.setSuccess(resolveHostsFileEntry);
                return;
            } else if (doResolveCached(hostname, dnsRecordArr, promise, dnsCache)) {
                return;
            } else {
                doResolveUncached(hostname, dnsRecordArr, promise, dnsCache, true);
                return;
            }
        }
        promise.setSuccess(loopbackAddress());
    }

    protected void doResolveAll(String str, DnsRecord[] dnsRecordArr, Promise<List<InetAddress>> promise, DnsCache dnsCache) throws Exception {
        if (str != null && !str.isEmpty()) {
            byte[] createByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString(str);
            if (createByteArrayFromIpAddressString != null) {
                promise.setSuccess(Collections.singletonList(InetAddress.getByAddress(createByteArrayFromIpAddressString)));
                return;
            }
            String hostname = hostname(str);
            InetAddress resolveHostsFileEntry = resolveHostsFileEntry(hostname);
            if (resolveHostsFileEntry != null) {
                promise.setSuccess(Collections.singletonList(resolveHostsFileEntry));
                return;
            } else if (doResolveAllCached(hostname, dnsRecordArr, promise, dnsCache, this.resolvedInternetProtocolFamilies)) {
                return;
            } else {
                doResolveAllUncached(hostname, dnsRecordArr, promise, dnsCache, this.completeOncePreferredResolved);
                return;
            }
        }
        promise.setSuccess(Collections.singletonList(loopbackAddress()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.resolver.SimpleNameResolver
    public EventLoop executor() {
        return (EventLoop) super.executor();
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable) {
        return query(nextNameServerAddress(), dnsQuestion, iterable);
    }

    public final Future<InetAddress> resolve(String str, Iterable<DnsRecord> iterable, Promise<InetAddress> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        try {
            doResolve(str, toArray(iterable, true), promise, this.resolveCache);
            return promise;
        } catch (Exception e4) {
            return promise.setFailure(e4);
        }
    }

    public final Future<List<InetAddress>> resolveAll(String str, Iterable<DnsRecord> iterable, Promise<List<InetAddress>> promise) {
        ObjectUtil.checkNotNull(promise, "promise");
        try {
            doResolveAll(str, toArray(iterable, true), promise, this.resolveCache);
            return promise;
        } catch (Exception e4) {
            return promise.setFailure(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DnsNameResolver(EventLoop eventLoop, ChannelFactory<? extends DatagramChannel> channelFactory, ChannelFactory<? extends SocketChannel> channelFactory2, final DnsCache dnsCache, final DnsCnameCache dnsCnameCache, final AuthoritativeDnsServerCache authoritativeDnsServerCache, DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory, long j4, ResolvedAddressTypes resolvedAddressTypes, boolean z3, int i4, boolean z4, int i5, boolean z5, HostsFileEntriesResolver hostsFileEntriesResolver, DnsServerAddressStreamProvider dnsServerAddressStreamProvider, String[] strArr, int i6, boolean z6, boolean z7) {
        super(eventLoop);
        DnsQueryLifecycleObserverFactory dnsQueryLifecycleObserverFactory2;
        this.queryContextManager = new DnsQueryContextManager();
        this.nameServerAddrStream = new FastThreadLocal<DnsServerAddressStream>() { // from class: io.netty.resolver.dns.DnsNameResolver.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public DnsServerAddressStream initialValue() {
                return DnsNameResolver.this.dnsServerAddressStreamProvider.nameServerAddressStream("");
            }
        };
        this.queryTimeoutMillis = ObjectUtil.checkPositive(j4, "queryTimeoutMillis");
        ResolvedAddressTypes resolvedAddressTypes2 = resolvedAddressTypes != null ? resolvedAddressTypes : DEFAULT_RESOLVE_ADDRESS_TYPES;
        this.resolvedAddressTypes = resolvedAddressTypes2;
        this.recursionDesired = z3;
        this.maxQueriesPerResolve = ObjectUtil.checkPositive(i4, "maxQueriesPerResolve");
        this.maxPayloadSize = ObjectUtil.checkPositive(i5, "maxPayloadSize");
        this.optResourceEnabled = z5;
        this.hostsFileEntriesResolver = (HostsFileEntriesResolver) ObjectUtil.checkNotNull(hostsFileEntriesResolver, "hostsFileEntriesResolver");
        this.dnsServerAddressStreamProvider = (DnsServerAddressStreamProvider) ObjectUtil.checkNotNull(dnsServerAddressStreamProvider, "dnsServerAddressStreamProvider");
        this.resolveCache = (DnsCache) ObjectUtil.checkNotNull(dnsCache, "resolveCache");
        this.cnameCache = (DnsCnameCache) ObjectUtil.checkNotNull(dnsCnameCache, "cnameCache");
        if (z4) {
            dnsQueryLifecycleObserverFactory2 = dnsQueryLifecycleObserverFactory instanceof NoopDnsQueryLifecycleObserverFactory ? new TraceDnsQueryLifeCycleObserverFactory() : new BiDnsQueryLifecycleObserverFactory(new TraceDnsQueryLifeCycleObserverFactory(), dnsQueryLifecycleObserverFactory);
        } else {
            dnsQueryLifecycleObserverFactory2 = (DnsQueryLifecycleObserverFactory) ObjectUtil.checkNotNull(dnsQueryLifecycleObserverFactory, "dnsQueryLifecycleObserverFactory");
        }
        this.dnsQueryLifecycleObserverFactory = dnsQueryLifecycleObserverFactory2;
        this.searchDomains = strArr != null ? (String[]) strArr.clone() : DEFAULT_SEARCH_DOMAINS;
        this.ndots = i6 >= 0 ? i6 : DEFAULT_NDOTS;
        this.decodeIdn = z6;
        this.completeOncePreferredResolved = z7;
        this.socketChannelFactory = channelFactory2;
        int i7 = AnonymousClass6.$SwitchMap$io$netty$resolver$ResolvedAddressTypes[resolvedAddressTypes2.ordinal()];
        if (i7 == 1) {
            this.supportsAAAARecords = false;
            this.supportsARecords = true;
            this.resolveRecordTypes = IPV4_ONLY_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV4_ONLY_RESOLVED_PROTOCOL_FAMILIES;
        } else if (i7 == 2) {
            this.supportsAAAARecords = true;
            this.supportsARecords = true;
            this.resolveRecordTypes = IPV4_PREFERRED_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV4_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
        } else if (i7 == 3) {
            this.supportsAAAARecords = true;
            this.supportsARecords = false;
            this.resolveRecordTypes = IPV6_ONLY_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV6_ONLY_RESOLVED_PROTOCOL_FAMILIES;
        } else if (i7 == 4) {
            this.supportsAAAARecords = true;
            this.supportsARecords = true;
            this.resolveRecordTypes = IPV6_PREFERRED_RESOLVED_RECORD_TYPES;
            this.resolvedInternetProtocolFamilies = IPV6_PREFERRED_RESOLVED_PROTOCOL_FAMILIES;
        } else {
            throw new IllegalArgumentException("Unknown ResolvedAddressTypes " + resolvedAddressTypes);
        }
        InternetProtocolFamily preferredAddressType = preferredAddressType(resolvedAddressTypes2);
        this.preferredAddressType = preferredAddressType;
        this.authoritativeDnsServerCache = (AuthoritativeDnsServerCache) ObjectUtil.checkNotNull(authoritativeDnsServerCache, "authoritativeDnsServerCache");
        this.nameServerComparator = new NameServerComparator(preferredAddressType.addressType());
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(executor());
        bootstrap.channelFactory((ChannelFactory) channelFactory);
        bootstrap.option(ChannelOption.DATAGRAM_CHANNEL_ACTIVE_ON_REGISTRATION, Boolean.TRUE);
        final DnsResponseHandler dnsResponseHandler = new DnsResponseHandler(executor().newPromise());
        bootstrap.handler(new ChannelInitializer<DatagramChannel>() { // from class: io.netty.resolver.dns.DnsNameResolver.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.channel.ChannelInitializer
            public void initChannel(DatagramChannel datagramChannel) {
                datagramChannel.pipeline().addLast(DnsNameResolver.DATAGRAM_ENCODER, DnsNameResolver.DATAGRAM_DECODER, dnsResponseHandler);
            }
        });
        this.channelFuture = dnsResponseHandler.channelActivePromise;
        ChannelFuture register = bootstrap.register();
        Throwable cause = register.cause();
        if (cause != null) {
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new IllegalStateException("Unable to create / register Channel", cause);
            }
            throw ((RuntimeException) cause);
        }
        Channel channel = register.channel();
        this.ch = channel;
        channel.config().setRecvByteBufAllocator(new FixedRecvByteBufAllocator(i5));
        channel.closeFuture().addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.resolver.dns.DnsNameResolver.3
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                dnsCache.clear();
                dnsCnameCache.clear();
                authoritativeDnsServerCache.clear();
            }
        });
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(DnsQuestion dnsQuestion, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query(nextNameServerAddress(), dnsQuestion, Collections.emptyList(), promise);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion) {
        return query0(inetSocketAddress, dnsQuestion, EMPTY_ADDITIONALS, true, this.ch.newPromise(), this.ch.eventLoop().newPromise());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final InternetProtocolFamily preferredAddressType() {
        return this.preferredAddressType;
    }

    public final Future<List<DnsRecord>> resolveAll(DnsQuestion dnsQuestion) {
        return resolveAll(dnsQuestion, EMPTY_ADDITIONALS, executor().newPromise());
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable) {
        return query0(inetSocketAddress, dnsQuestion, toArray(iterable, false), true, this.ch.newPromise(), this.ch.eventLoop().newPromise());
    }

    public final Future<List<DnsRecord>> resolveAll(DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable) {
        return resolveAll(dnsQuestion, iterable, executor().newPromise());
    }

    public final Future<List<DnsRecord>> resolveAll(DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable, Promise<List<DnsRecord>> promise) {
        return resolveAll(dnsQuestion, toArray(iterable, true), promise);
    }

    private Future<List<DnsRecord>> resolveAll(DnsQuestion dnsQuestion, DnsRecord[] dnsRecordArr, Promise<List<DnsRecord>> promise) {
        InetAddress resolveHostsFileEntry;
        ByteBuf wrappedBuffer;
        ByteBuf byteBuf;
        ObjectUtil.checkNotNull(dnsQuestion, "question");
        ObjectUtil.checkNotNull(promise, "promise");
        DnsRecordType type = dnsQuestion.type();
        String name = dnsQuestion.name();
        DnsRecordType dnsRecordType = DnsRecordType.A;
        if ((type == dnsRecordType || type == DnsRecordType.AAAA) && (resolveHostsFileEntry = resolveHostsFileEntry(name)) != null) {
            if (resolveHostsFileEntry instanceof Inet4Address) {
                if (type == dnsRecordType) {
                    wrappedBuffer = Unpooled.wrappedBuffer(resolveHostsFileEntry.getAddress());
                    byteBuf = wrappedBuffer;
                }
                byteBuf = null;
            } else {
                if ((resolveHostsFileEntry instanceof Inet6Address) && type == DnsRecordType.AAAA) {
                    wrappedBuffer = Unpooled.wrappedBuffer(resolveHostsFileEntry.getAddress());
                    byteBuf = wrappedBuffer;
                }
                byteBuf = null;
            }
            if (byteBuf != null) {
                trySuccess(promise, Collections.singletonList(new DefaultDnsRawRecord(name, type, 86400L, byteBuf)));
                return promise;
            }
        }
        new DnsRecordResolveContext(this, dnsQuestion, dnsRecordArr, this.dnsServerAddressStreamProvider.nameServerAddressStream(name)).resolve(promise);
        return promise;
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query0(inetSocketAddress, dnsQuestion, EMPTY_ADDITIONALS, true, this.ch.newPromise(), promise);
    }

    public Future<AddressedEnvelope<DnsResponse, InetSocketAddress>> query(InetSocketAddress inetSocketAddress, DnsQuestion dnsQuestion, Iterable<DnsRecord> iterable, Promise<AddressedEnvelope<? extends DnsResponse, InetSocketAddress>> promise) {
        return query0(inetSocketAddress, dnsQuestion, toArray(iterable, false), true, this.ch.newPromise(), promise);
    }
}
