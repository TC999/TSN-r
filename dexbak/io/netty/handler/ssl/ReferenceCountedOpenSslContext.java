package io.netty.handler.ssl;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeak;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateRevokedException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import org.apache.tomcat.jni.CertificateVerifier;
import org.apache.tomcat.jni.Pool;
import org.apache.tomcat.jni.SSL;
import org.apache.tomcat.jni.SSLContext;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class ReferenceCountedOpenSslContext extends SslContext implements ReferenceCounted {
    private static final List<String> DEFAULT_CIPHERS;
    private static final Integer DH_KEY_LENGTH;
    private static final boolean JDK_REJECT_CLIENT_INITIATED_RENEGOTIATION;
    static final OpenSslApplicationProtocolNegotiator NONE_PROTOCOL_NEGOTIATOR;
    protected static final int VERIFY_DEPTH = 10;
    private static final ResourceLeakDetector<ReferenceCountedOpenSslContext> leakDetector;
    private static final InternalLogger logger;
    private final OpenSslApplicationProtocolNegotiator apn;
    long aprPool;
    private volatile int aprPoolDestroyed;
    final ClientAuth clientAuth;
    protected volatile long ctx;
    final OpenSslEngineMap engineMap;
    final Certificate[] keyCertChain;
    private final ResourceLeak leak;
    private final int mode;
    private final AbstractReferenceCounted refCnt;
    volatile boolean rejectRemoteInitiatedRenegotiation;
    private final long sessionCacheSize;
    private final long sessionTimeout;
    private final List<String> unmodifiableCiphers;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslContext$4 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C139444 {

        /* renamed from: $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol */
        static final /* synthetic */ int[] f40276xc16482e4;

        /* renamed from: $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior */
        static final /* synthetic */ int[] f40277xcbdfafc1;

        /* renamed from: $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior */
        static final /* synthetic */ int[] f40278xb32e3251;

        static {
            int[] iArr = new int[ApplicationProtocolConfig.SelectedListenerFailureBehavior.values().length];
            f40277xcbdfafc1 = iArr;
            try {
                iArr[ApplicationProtocolConfig.SelectedListenerFailureBehavior.CHOOSE_MY_LAST_PROTOCOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40277xcbdfafc1[ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[ApplicationProtocolConfig.SelectorFailureBehavior.values().length];
            f40278xb32e3251 = iArr2;
            try {
                iArr2[ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40278xb32e3251[ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[ApplicationProtocolConfig.Protocol.values().length];
            f40276xc16482e4 = iArr3;
            try {
                iArr3[ApplicationProtocolConfig.Protocol.NPN.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f40276xc16482e4[ApplicationProtocolConfig.Protocol.ALPN.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f40276xc16482e4[ApplicationProtocolConfig.Protocol.NPN_AND_ALPN.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f40276xc16482e4[ApplicationProtocolConfig.Protocol.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractCertificateVerifier implements CertificateVerifier {
        private final OpenSslEngineMap engineMap;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AbstractCertificateVerifier(OpenSslEngineMap openSslEngineMap) {
            this.engineMap = openSslEngineMap;
        }

        public final int verify(long j, byte[][] bArr, String str) {
            X509Certificate[] certificates = ReferenceCountedOpenSslContext.certificates(bArr);
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = this.engineMap.get(j);
            try {
                verify(referenceCountedOpenSslEngine, certificates, str);
                return 0;
            } catch (Throwable th) {
                ReferenceCountedOpenSslContext.logger.debug("verification of certificate failed", (Throwable) th);
                SSLHandshakeException sSLHandshakeException = new SSLHandshakeException("General OpenSslEngine problem");
                sSLHandshakeException.initCause(th);
                referenceCountedOpenSslEngine.handshakeException = sSLHandshakeException;
                if (th instanceof OpenSslCertificateException) {
                    return th.errorCode();
                }
                if (th instanceof CertificateExpiredException) {
                    return 10;
                }
                if (th instanceof CertificateNotYetValidException) {
                    return 9;
                }
                return (PlatformDependent.javaVersion() < 7 || !(th instanceof CertificateRevokedException)) ? 1 : 23;
            }
        }

        abstract void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception;
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static final class DefaultOpenSslEngineMap implements OpenSslEngineMap {
        private final Map<Long, ReferenceCountedOpenSslEngine> engines;

        private DefaultOpenSslEngineMap() {
            this.engines = PlatformDependent.newConcurrentHashMap();
        }

        @Override // io.netty.handler.ssl.OpenSslEngineMap
        public void add(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine) {
            this.engines.put(Long.valueOf(referenceCountedOpenSslEngine.sslPointer()), referenceCountedOpenSslEngine);
        }

        @Override // io.netty.handler.ssl.OpenSslEngineMap
        public ReferenceCountedOpenSslEngine get(long j) {
            return this.engines.get(Long.valueOf(j));
        }

        @Override // io.netty.handler.ssl.OpenSslEngineMap
        public ReferenceCountedOpenSslEngine remove(long j) {
            return this.engines.remove(Long.valueOf(j));
        }
    }

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(ReferenceCountedOpenSslContext.class);
        logger = internalLoggerFactory;
        JDK_REJECT_CLIENT_INITIATED_RENEGOTIATION = SystemPropertyUtil.getBoolean("jdk.tls.rejectClientInitiatedRenegotiation", false);
        leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ReferenceCountedOpenSslContext.class);
        NONE_PROTOCOL_NEGOTIATOR = new OpenSslApplicationProtocolNegotiator() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslContext.2
            @Override // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
            public ApplicationProtocolConfig.Protocol protocol() {
                return ApplicationProtocolConfig.Protocol.NONE;
            }

            @Override // io.netty.handler.ssl.ApplicationProtocolNegotiator
            public List<String> protocols() {
                return Collections.emptyList();
            }

            @Override // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
            public ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior() {
                return ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT;
            }

            @Override // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
            public ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior() {
                return ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL;
            }
        };
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, "ECDHE-RSA-AES128-GCM-SHA256", "ECDHE-RSA-AES128-SHA", "ECDHE-RSA-AES256-SHA", "AES128-GCM-SHA256", "AES128-SHA", "AES256-SHA", "DES-CBC3-SHA");
        DEFAULT_CIPHERS = Collections.unmodifiableList(arrayList);
        if (internalLoggerFactory.isDebugEnabled()) {
            internalLoggerFactory.debug("Default cipher suite (OpenSSL): " + arrayList);
        }
        Integer num = null;
        try {
            String str = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslContext.3
                @Override // java.security.PrivilegedAction
                public String run() {
                    return SystemPropertyUtil.get("jdk.tls.ephemeralDHKeySize");
                }
            });
            if (str != null) {
                try {
                    num = Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    InternalLogger internalLogger = logger;
                    internalLogger.debug("ReferenceCountedOpenSslContext supports -Djdk.tls.ephemeralDHKeySize={int}, but got: " + str);
                }
            }
        } catch (Throwable unused2) {
        }
        DH_KEY_LENGTH = num;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReferenceCountedOpenSslContext(Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j, long j2, int i, Certificate[] certificateArr, ClientAuth clientAuth, boolean z) throws SSLException {
        this(iterable, cipherSuiteFilter, toNegotiator(applicationProtocolConfig), j, j2, i, certificateArr, clientAuth, z);
    }

    protected static X509Certificate[] certificates(byte[][] bArr) {
        int length = bArr.length;
        X509Certificate[] x509CertificateArr = new X509Certificate[length];
        for (int i = 0; i < length; i++) {
            x509CertificateArr[i] = new OpenSslX509Certificate(bArr[i]);
        }
        return x509CertificateArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static X509TrustManager chooseTrustManager(TrustManager[] trustManagerArr) {
        for (TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        throw new IllegalStateException("no X509TrustManager found");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static X509KeyManager chooseX509KeyManager(KeyManager[] keyManagerArr) {
        for (KeyManager keyManager : keyManagerArr) {
            if (keyManager instanceof X509KeyManager) {
                return (X509KeyManager) keyManager;
            }
        }
        throw new IllegalStateException("no X509KeyManager found");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void freeBio(long j) {
        if (j != 0) {
            SSL.freeBIO(j);
        }
    }

    private static long newBIO(ByteBuf byteBuf) throws Exception {
        try {
            long newMemBIO = SSL.newMemBIO();
            int readableBytes = byteBuf.readableBytes();
            if (SSL.writeToBIO(newMemBIO, OpenSsl.memoryAddress(byteBuf) + byteBuf.readerIndex(), readableBytes) == readableBytes) {
                return newMemBIO;
            }
            SSL.freeBIO(newMemBIO);
            throw new IllegalStateException("Could not write data to memory BIO");
        } finally {
            byteBuf.release();
        }
    }

    private static int opensslSelectorFailureBehavior(ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior) {
        int i = C139444.f40278xb32e3251[selectorFailureBehavior.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 1;
            }
            throw new Error();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setKeyMaterial(long j, X509Certificate[] x509CertificateArr, PrivateKey privateKey, String str) throws SSLException {
        long j2;
        long j3;
        long j4 = 0;
        PemEncoded pemEncoded = null;
        try {
            try {
                ByteBufAllocator byteBufAllocator = ByteBufAllocator.DEFAULT;
                pemEncoded = PemX509Certificate.toPEM(byteBufAllocator, true, x509CertificateArr);
                j2 = toBIO(byteBufAllocator, pemEncoded.retain());
                try {
                    long bio = toBIO(byteBufAllocator, pemEncoded.retain());
                    if (privateKey != null) {
                        try {
                            j4 = toBIO(privateKey);
                        } catch (SSLException e) {
                            e = e;
                            throw e;
                        } catch (Exception e2) {
                            e = e2;
                            throw new SSLException("failed to set certificate and key", e);
                        }
                    }
                    SSLContext.setCertificateBio(j, j2, j4, str == null ? "" : str);
                    SSLContext.setCertificateChainBio(j, bio, false);
                    freeBio(j4);
                    freeBio(j2);
                    freeBio(bio);
                    pemEncoded.release();
                } catch (SSLException e3) {
                    e = e3;
                } catch (Exception e4) {
                    e = e4;
                } catch (Throwable th) {
                    th = th;
                    j3 = 0;
                    freeBio(0L);
                    freeBio(j2);
                    freeBio(j3);
                    if (pemEncoded != null) {
                        pemEncoded.release();
                    }
                    throw th;
                }
            } catch (SSLException e5) {
                e = e5;
            } catch (Exception e6) {
                e = e6;
            } catch (Throwable th2) {
                th = th2;
                j2 = 0;
                j3 = 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long toBIO(PrivateKey privateKey) throws Exception {
        if (privateKey == null) {
            return 0L;
        }
        ByteBufAllocator byteBufAllocator = ByteBufAllocator.DEFAULT;
        PemEncoded pem = PemPrivateKey.toPEM(byteBufAllocator, true, privateKey);
        try {
            return toBIO(byteBufAllocator, pem.retain());
        } finally {
            pem.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OpenSslApplicationProtocolNegotiator toNegotiator(ApplicationProtocolConfig applicationProtocolConfig) {
        if (applicationProtocolConfig == null) {
            return NONE_PROTOCOL_NEGOTIATOR;
        }
        int i = C139444.f40276xc16482e4[applicationProtocolConfig.protocol().ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            if (i == 4) {
                return NONE_PROTOCOL_NEGOTIATOR;
            }
            throw new Error();
        }
        int i2 = C139444.f40277xcbdfafc1[applicationProtocolConfig.selectedListenerFailureBehavior().ordinal()];
        if (i2 != 1 && i2 != 2) {
            throw new UnsupportedOperationException("OpenSSL provider does not support " + applicationProtocolConfig.selectedListenerFailureBehavior() + " behavior");
        }
        int i3 = C139444.f40278xb32e3251[applicationProtocolConfig.selectorFailureBehavior().ordinal()];
        if (i3 != 1 && i3 != 2) {
            throw new UnsupportedOperationException("OpenSSL provider does not support " + applicationProtocolConfig.selectorFailureBehavior() + " behavior");
        }
        return new OpenSslDefaultApplicationProtocolNegotiator(applicationProtocolConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean useExtendedKeyManager(X509KeyManager x509KeyManager) {
        return PlatformDependent.javaVersion() >= 7 && (x509KeyManager instanceof X509ExtendedKeyManager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean useExtendedTrustManager(X509TrustManager x509TrustManager) {
        return PlatformDependent.javaVersion() >= 7 && (x509TrustManager instanceof X509ExtendedTrustManager);
    }

    @Override // io.netty.handler.ssl.SslContext
    public ApplicationProtocolNegotiator applicationProtocolNegotiator() {
        return this.apn;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final List<String> cipherSuites() {
        return this.unmodifiableCiphers;
    }

    @Deprecated
    public final long context() {
        return this.ctx;
    }

    final void destroy() {
        synchronized (ReferenceCountedOpenSslContext.class) {
            if (this.ctx != 0) {
                SSLContext.free(this.ctx);
                this.ctx = 0L;
            }
            long j = this.aprPool;
            if (j != 0) {
                Pool.destroy(j);
                this.aprPool = 0L;
            }
        }
    }

    @Override // io.netty.handler.ssl.SslContext
    public final boolean isClient() {
        return this.mode == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract OpenSslKeyMaterialManager keyMaterialManager();

    @Override // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator, String str, int i) {
        return newEngine0(byteBufAllocator, str, i);
    }

    SSLEngine newEngine0(ByteBufAllocator byteBufAllocator, String str, int i) {
        return new ReferenceCountedOpenSslEngine(this, byteBufAllocator, str, i, true);
    }

    @Override // io.netty.util.ReferenceCounted
    public final int refCnt() {
        return this.refCnt.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release() {
        return this.refCnt.release();
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted retain() {
        this.refCnt.retain();
        return this;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final long sessionCacheSize() {
        return this.sessionCacheSize;
    }

    @Override // io.netty.handler.ssl.SslContext
    public abstract OpenSslSessionContext sessionContext();

    @Override // io.netty.handler.ssl.SslContext
    public final long sessionTimeout() {
        return this.sessionTimeout;
    }

    public void setRejectRemoteInitiatedRenegotiation(boolean z) {
        this.rejectRemoteInitiatedRenegotiation = z;
    }

    @Deprecated
    public final void setTicketKeys(byte[] bArr) {
        sessionContext().setTicketKeys(bArr);
    }

    public final long sslCtxPointer() {
        return this.ctx;
    }

    @Deprecated
    public final OpenSslSessionStats stats() {
        return sessionContext().stats();
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch() {
        this.refCnt.touch();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReferenceCountedOpenSslContext(Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator, long j, long j2, int i, Certificate[] certificateArr, ClientAuth clientAuth, boolean z) throws SSLException {
        String next;
        this.refCnt = new AbstractReferenceCounted() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslContext.1
            @Override // io.netty.util.AbstractReferenceCounted
            protected void deallocate() {
                ReferenceCountedOpenSslContext.this.destroy();
                if (ReferenceCountedOpenSslContext.this.leak != null) {
                    ReferenceCountedOpenSslContext.this.leak.close();
                }
            }

            @Override // io.netty.util.ReferenceCounted
            public ReferenceCounted touch(Object obj) {
                if (ReferenceCountedOpenSslContext.this.leak != null) {
                    ReferenceCountedOpenSslContext.this.leak.record(obj);
                }
                return ReferenceCountedOpenSslContext.this;
            }
        };
        ArrayList arrayList = null;
        this.engineMap = new DefaultOpenSslEngineMap();
        OpenSsl.ensureAvailability();
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException("mode most be either SSL.SSL_MODE_SERVER or SSL.SSL_MODE_CLIENT");
        }
        this.leak = z ? leakDetector.open(this) : null;
        this.mode = i;
        this.clientAuth = isServer() ? (ClientAuth) ObjectUtil.checkNotNull(clientAuth, "clientAuth") : ClientAuth.NONE;
        if (i == 1) {
            this.rejectRemoteInitiatedRenegotiation = JDK_REJECT_CLIENT_INITIATED_RENEGOTIATION;
        }
        this.keyCertChain = certificateArr == null ? null : (Certificate[]) certificateArr.clone();
        if (iterable != null) {
            arrayList = new ArrayList();
            Iterator<String> it = iterable.iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                String openSsl = CipherSuiteConverter.toOpenSsl(next);
                if (openSsl != null) {
                    next = openSsl;
                }
                arrayList.add(next);
            }
        }
        List<String> asList = Arrays.asList(((CipherSuiteFilter) ObjectUtil.checkNotNull(cipherSuiteFilter, "cipherFilter")).filterCipherSuites(arrayList, DEFAULT_CIPHERS, OpenSsl.availableCipherSuites()));
        this.unmodifiableCiphers = asList;
        this.apn = (OpenSslApplicationProtocolNegotiator) ObjectUtil.checkNotNull(openSslApplicationProtocolNegotiator, "apn");
        this.aprPool = Pool.create(0L);
        try {
            synchronized (ReferenceCountedOpenSslContext.class) {
                try {
                    this.ctx = SSLContext.make(this.aprPool, 31, i);
                    SSLContext.setOptions(this.ctx, 4095);
                    SSLContext.setOptions(this.ctx, 16777216);
                    SSLContext.setOptions(this.ctx, (int) CommonNetImpl.FLAG_SHARE_JUMP);
                    SSLContext.setOptions(this.ctx, 4194304);
                    SSLContext.setOptions(this.ctx, 524288);
                    SSLContext.setOptions(this.ctx, 1048576);
                    SSLContext.setOptions(this.ctx, 65536);
                    SSLContext.setOptions(this.ctx, 16384);
                    SSLContext.setMode(this.ctx, SSLContext.getMode(this.ctx) | 2);
                    Integer num = DH_KEY_LENGTH;
                    if (num != null) {
                        SSLContext.setTmpDHLength(this.ctx, num.intValue());
                    }
                    try {
                        SSLContext.setCipherSuite(this.ctx, CipherSuiteConverter.toOpenSsl(asList));
                        List<String> protocols = openSslApplicationProtocolNegotiator.protocols();
                        if (!protocols.isEmpty()) {
                            String[] strArr = (String[]) protocols.toArray(new String[protocols.size()]);
                            int opensslSelectorFailureBehavior = opensslSelectorFailureBehavior(openSslApplicationProtocolNegotiator.selectorFailureBehavior());
                            int i2 = C139444.f40276xc16482e4[openSslApplicationProtocolNegotiator.protocol().ordinal()];
                            if (i2 == 1) {
                                SSLContext.setNpnProtos(this.ctx, strArr, opensslSelectorFailureBehavior);
                            } else if (i2 == 2) {
                                SSLContext.setAlpnProtos(this.ctx, strArr, opensslSelectorFailureBehavior);
                            } else if (i2 == 3) {
                                SSLContext.setNpnProtos(this.ctx, strArr, opensslSelectorFailureBehavior);
                                SSLContext.setAlpnProtos(this.ctx, strArr, opensslSelectorFailureBehavior);
                            } else {
                                throw new Error();
                            }
                        }
                        if (j > 0) {
                            this.sessionCacheSize = j;
                            SSLContext.setSessionCacheSize(this.ctx, j);
                        } else {
                            long sessionCacheSize = SSLContext.setSessionCacheSize(this.ctx, 20480L);
                            this.sessionCacheSize = sessionCacheSize;
                            SSLContext.setSessionCacheSize(this.ctx, sessionCacheSize);
                        }
                        if (j2 > 0) {
                            this.sessionTimeout = j2;
                            SSLContext.setSessionCacheTimeout(this.ctx, j2);
                        } else {
                            long sessionCacheTimeout = SSLContext.setSessionCacheTimeout(this.ctx, 300L);
                            this.sessionTimeout = sessionCacheTimeout;
                            SSLContext.setSessionCacheTimeout(this.ctx, sessionCacheTimeout);
                        }
                    } catch (SSLException e) {
                        throw e;
                    } catch (Exception e2) {
                        throw new SSLException("failed to set cipher suite: " + this.unmodifiableCiphers, e2);
                    }
                } catch (Exception e3) {
                    throw new SSLException("failed to create an SSL_CTX", e3);
                }
            }
        } catch (Throwable th) {
            release();
            throw th;
        }
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator) {
        return newEngine(byteBufAllocator, null, -1);
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release(int i) {
        return this.refCnt.release(i);
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted retain(int i) {
        this.refCnt.retain(i);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch(Object obj) {
        this.refCnt.touch(obj);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long toBIO(X509Certificate... x509CertificateArr) throws Exception {
        if (x509CertificateArr == null) {
            return 0L;
        }
        if (x509CertificateArr.length != 0) {
            ByteBufAllocator byteBufAllocator = ByteBufAllocator.DEFAULT;
            PemEncoded pem = PemX509Certificate.toPEM(byteBufAllocator, true, x509CertificateArr);
            try {
                return toBIO(byteBufAllocator, pem.retain());
            } finally {
                pem.release();
            }
        }
        throw new IllegalArgumentException("certChain can't be empty");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long toBIO(ByteBufAllocator byteBufAllocator, PemEncoded pemEncoded) throws Exception {
        try {
            ByteBuf content = pemEncoded.content();
            if (content.isDirect()) {
                return newBIO(content.retainedSlice());
            }
            ByteBuf directBuffer = byteBufAllocator.directBuffer(content.readableBytes());
            directBuffer.writeBytes(content, content.readerIndex(), content.readableBytes());
            long newBIO = newBIO(directBuffer.retainedSlice());
            if (pemEncoded.isSensitive()) {
                SslUtils.zeroout(directBuffer);
            }
            directBuffer.release();
            return newBIO;
        } finally {
            pemEncoded.release();
        }
    }
}
