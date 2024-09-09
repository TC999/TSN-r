package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.internal.tcnative.Buffer;
import io.netty.internal.tcnative.SSL;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.Lock;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class ReferenceCountedOpenSslEngine extends SSLEngine implements ReferenceCounted, ApplicationProtocolAccessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_SSLV2 = 0;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_SSLV3 = 1;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1 = 2;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_1 = 3;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_2 = 4;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_3 = 5;
    private Object algorithmConstraints;
    final ByteBufAllocator alloc;
    private final OpenSslApplicationProtocolNegotiator apn;
    private volatile String applicationProtocol;
    private volatile ClientAuth clientAuth;
    private final boolean clientMode;
    private volatile int destroyed;
    private final boolean enableOcsp;
    private String endPointIdentificationAlgorithm;
    private final OpenSslEngineMap engineMap;
    private Throwable handshakeException;
    private HandshakeState handshakeState;
    private boolean isInboundDone;
    final boolean jdkCompatibilityMode;
    private volatile long lastAccessed;
    private final ResourceLeakTracker<ReferenceCountedOpenSslEngine> leak;
    private volatile Certificate[] localCertificateChain;
    private volatile Collection<?> matchers;
    private int maxWrapBufferSize;
    private int maxWrapOverhead;
    private volatile boolean needTask;
    private long networkBIO;
    private boolean outboundClosed;
    private boolean receivedShutdown;
    private final AbstractReferenceCounted refCnt;
    private final io.netty.handler.ssl.OpenSslSession session;
    private final ByteBuffer[] singleDstBuffer;
    private final ByteBuffer[] singleSrcBuffer;
    private List<String> sniHostNames;
    private long ssl;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ReferenceCountedOpenSslEngine.class);
    private static final ResourceLeakDetector<ReferenceCountedOpenSslEngine> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ReferenceCountedOpenSslEngine.class);
    private static final int[] OPENSSL_OP_NO_PROTOCOLS = {SSL.SSL_OP_NO_SSLv2, SSL.SSL_OP_NO_SSLv3, SSL.SSL_OP_NO_TLSv1, SSL.SSL_OP_NO_TLSv1_1, SSL.SSL_OP_NO_TLSv1_2, SSL.SSL_OP_NO_TLSv1_3};
    static final int MAX_PLAINTEXT_LENGTH = SSL.SSL_MAX_PLAINTEXT_LENGTH;
    private static final int MAX_RECORD_SIZE = SSL.SSL_MAX_RECORD_LENGTH;
    private static final AtomicIntegerFieldUpdater<ReferenceCountedOpenSslEngine> DESTROYED_UPDATER = AtomicIntegerFieldUpdater.newUpdater(ReferenceCountedOpenSslEngine.class, "destroyed");
    private static final SSLEngineResult NEED_UNWRAP_OK = new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
    private static final SSLEngineResult NEED_UNWRAP_CLOSED = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
    private static final SSLEngineResult NEED_WRAP_OK = new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, 0);
    private static final SSLEngineResult NEED_WRAP_CLOSED = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, 0);
    private static final SSLEngineResult CLOSED_NOT_HANDSHAKING = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslEngine$4  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ClientAuth;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState;

        static {
            int[] iArr = new int[ApplicationProtocolConfig.Protocol.values().length];
            $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol = iArr;
            try {
                iArr[ApplicationProtocolConfig.Protocol.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.ALPN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.NPN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.NPN_AND_ALPN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ClientAuth.values().length];
            $SwitchMap$io$netty$handler$ssl$ClientAuth = iArr2;
            try {
                iArr2[ClientAuth.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ClientAuth[ClientAuth.REQUIRE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ClientAuth[ClientAuth.OPTIONAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[HandshakeState.values().length];
            $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState = iArr3;
            try {
                iArr3[HandshakeState.NOT_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[HandshakeState.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[HandshakeState.STARTED_IMPLICITLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[HandshakeState.STARTED_EXPLICITLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum HandshakeState {
        NOT_STARTED,
        STARTED_IMPLICITLY,
        STARTED_EXPLICITLY,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReferenceCountedOpenSslEngine(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, ByteBufAllocator byteBufAllocator, String str, int i4, boolean z3, boolean z4) {
        super(str, i4);
        this.handshakeState = HandshakeState.NOT_STARTED;
        this.refCnt = new AbstractReferenceCounted() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // io.netty.util.AbstractReferenceCounted
            protected void deallocate() {
                ReferenceCountedOpenSslEngine.this.shutdown();
                if (ReferenceCountedOpenSslEngine.this.leak != null) {
                    ReferenceCountedOpenSslEngine.this.leak.close(ReferenceCountedOpenSslEngine.this);
                }
            }

            @Override // io.netty.util.ReferenceCounted
            public ReferenceCounted touch(Object obj) {
                if (ReferenceCountedOpenSslEngine.this.leak != null) {
                    ReferenceCountedOpenSslEngine.this.leak.record(obj);
                }
                return ReferenceCountedOpenSslEngine.this;
            }
        };
        ClientAuth clientAuth = ClientAuth.NONE;
        this.clientAuth = clientAuth;
        this.lastAccessed = -1L;
        boolean z5 = true;
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        OpenSsl.ensureAvailability();
        this.alloc = (ByteBufAllocator) ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        this.apn = (OpenSslApplicationProtocolNegotiator) referenceCountedOpenSslContext.applicationProtocolNegotiator();
        boolean isClient = referenceCountedOpenSslContext.isClient();
        this.clientMode = isClient;
        if (PlatformDependent.javaVersion() >= 7) {
            this.session = new ExtendedOpenSslSession(new DefaultOpenSslSession(referenceCountedOpenSslContext.sessionContext())) { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.2
                private String[] peerSupportedSignatureAlgorithms;
                private List requestedServerNames;

                @Override // javax.net.ssl.ExtendedSSLSession
                public String[] getPeerSupportedSignatureAlgorithms() {
                    String[] strArr;
                    synchronized (ReferenceCountedOpenSslEngine.this) {
                        if (this.peerSupportedSignatureAlgorithms == null) {
                            if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                                this.peerSupportedSignatureAlgorithms = EmptyArrays.EMPTY_STRINGS;
                            } else {
                                String[] sigAlgs = SSL.getSigAlgs(ReferenceCountedOpenSslEngine.this.ssl);
                                if (sigAlgs == null) {
                                    this.peerSupportedSignatureAlgorithms = EmptyArrays.EMPTY_STRINGS;
                                } else {
                                    LinkedHashSet linkedHashSet = new LinkedHashSet(sigAlgs.length);
                                    for (String str2 : sigAlgs) {
                                        String javaName = SignatureAlgorithmConverter.toJavaName(str2);
                                        if (javaName != null) {
                                            linkedHashSet.add(javaName);
                                        }
                                    }
                                    this.peerSupportedSignatureAlgorithms = (String[]) linkedHashSet.toArray(new String[0]);
                                }
                            }
                        }
                        strArr = (String[]) this.peerSupportedSignatureAlgorithms.clone();
                    }
                    return strArr;
                }

                @Override // io.netty.handler.ssl.ExtendedOpenSslSession, javax.net.ssl.ExtendedSSLSession
                public List getRequestedServerNames() {
                    List list;
                    if (ReferenceCountedOpenSslEngine.this.clientMode) {
                        return Java8SslUtils.getSniHostNames(ReferenceCountedOpenSslEngine.this.sniHostNames);
                    }
                    synchronized (ReferenceCountedOpenSslEngine.this) {
                        if (this.requestedServerNames == null) {
                            if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                                this.requestedServerNames = Collections.emptyList();
                            } else if (SSL.getSniHostname(ReferenceCountedOpenSslEngine.this.ssl) == null) {
                                this.requestedServerNames = Collections.emptyList();
                            } else {
                                this.requestedServerNames = Java8SslUtils.getSniHostName(SSL.getSniHostname(ReferenceCountedOpenSslEngine.this.ssl).getBytes(CharsetUtil.UTF_8));
                            }
                        }
                        list = this.requestedServerNames;
                    }
                    return list;
                }

                @Override // io.netty.handler.ssl.ExtendedOpenSslSession
                public List<byte[]> getStatusResponses() {
                    if (ReferenceCountedOpenSslEngine.this.enableOcsp && ReferenceCountedOpenSslEngine.this.clientMode) {
                        synchronized (ReferenceCountedOpenSslEngine.this) {
                            r1 = ReferenceCountedOpenSslEngine.this.isDestroyed() ? null : SSL.getOcspResponse(ReferenceCountedOpenSslEngine.this.ssl);
                        }
                    }
                    return r1 == null ? Collections.emptyList() : Collections.singletonList(r1);
                }
            };
        } else {
            this.session = new DefaultOpenSslSession(referenceCountedOpenSslContext.sessionContext());
        }
        this.engineMap = referenceCountedOpenSslContext.engineMap;
        boolean z6 = referenceCountedOpenSslContext.enableOcsp;
        this.enableOcsp = z6;
        this.localCertificateChain = referenceCountedOpenSslContext.keyCertChain;
        this.jdkCompatibilityMode = z3;
        Lock readLock = referenceCountedOpenSslContext.ctxLock.readLock();
        readLock.lock();
        try {
            long j4 = referenceCountedOpenSslContext.ctx;
            if (referenceCountedOpenSslContext.isClient()) {
                z5 = false;
            }
            long newSSL = SSL.newSSL(j4, z5);
            synchronized (this) {
                this.ssl = newSSL;
                this.networkBIO = SSL.bioNewByteBuffer(newSSL, referenceCountedOpenSslContext.getBioNonApplicationBufferSize());
                if (!isClient) {
                    clientAuth = referenceCountedOpenSslContext.clientAuth;
                }
                setClientAuth(clientAuth);
                String[] strArr = referenceCountedOpenSslContext.protocols;
                if (strArr != null) {
                    setEnabledProtocols(strArr);
                }
                if (isClient && SslUtils.isValidHostNameForSNI(str)) {
                    SSL.setTlsExtHostName(this.ssl, str);
                    this.sniHostNames = Collections.singletonList(str);
                }
                if (z6) {
                    SSL.enableOcsp(this.ssl);
                }
                if (!z3) {
                    long j5 = this.ssl;
                    SSL.setMode(j5, SSL.getMode(j5) | SSL.SSL_MODE_ENABLE_PARTIAL_WRITE);
                }
                calculateMaxWrapOverhead();
            }
            this.leak = z4 ? leakDetector.track(this) : null;
        } finally {
            readLock.unlock();
        }
    }

    private static long bufferAddress(ByteBuffer byteBuffer) {
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.directBufferAddress(byteBuffer);
        }
        return Buffer.address(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculateMaxWrapOverhead() {
        this.maxWrapOverhead = SSL.getMaxWrapOverhead(this.ssl);
        this.maxWrapBufferSize = this.jdkCompatibilityMode ? maxEncryptedPacketLength0() : maxEncryptedPacketLength0() << 4;
    }

    private void checkEngineClosed() throws SSLException {
        if (isDestroyed()) {
            throw new SSLException("engine closed");
        }
    }

    private void closeAll() throws SSLException {
        this.receivedShutdown = true;
        closeOutbound();
        closeInbound();
    }

    private boolean doSSLShutdown() {
        if (SSL.isInInit(this.ssl) != 0) {
            return false;
        }
        int shutdownSSL = SSL.shutdownSSL(this.ssl);
        if (shutdownSSL < 0) {
            int error = SSL.getError(this.ssl, shutdownSSL);
            if (error != SSL.SSL_ERROR_SYSCALL && error != SSL.SSL_ERROR_SSL) {
                SSL.clearError();
                return true;
            }
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                int lastErrorNumber = SSL.getLastErrorNumber();
                internalLogger.debug("SSL_shutdown failed: OpenSSL error: {} {}", Integer.valueOf(lastErrorNumber), SSL.getErrorString(lastErrorNumber));
            }
            shutdown();
            return false;
        }
        return true;
    }

    private SSLEngineResult.HandshakeStatus handshake() throws SSLException {
        if (this.needTask) {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        }
        if (this.handshakeState == HandshakeState.FINISHED) {
            return SSLEngineResult.HandshakeStatus.FINISHED;
        }
        checkEngineClosed();
        if (this.handshakeException != null) {
            return handshakeException();
        }
        this.engineMap.add(this);
        if (this.lastAccessed == -1) {
            this.lastAccessed = System.currentTimeMillis();
        }
        int doHandshake = SSL.doHandshake(this.ssl);
        if (doHandshake <= 0) {
            int error = SSL.getError(this.ssl, doHandshake);
            if (error != SSL.SSL_ERROR_WANT_READ && error != SSL.SSL_ERROR_WANT_WRITE) {
                if (error != SSL.SSL_ERROR_WANT_X509_LOOKUP && error != SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY && error != SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION) {
                    if (this.handshakeException != null) {
                        return handshakeException();
                    }
                    throw shutdownWithError("SSL_do_handshake", error);
                }
                return SSLEngineResult.HandshakeStatus.NEED_TASK;
            }
            return pendingStatus(SSL.bioLengthNonApplication(this.networkBIO));
        } else if (SSL.bioLengthNonApplication(this.networkBIO) > 0) {
            return SSLEngineResult.HandshakeStatus.NEED_WRAP;
        } else {
            this.session.handshakeFinished();
            return SSLEngineResult.HandshakeStatus.FINISHED;
        }
    }

    private SSLEngineResult.HandshakeStatus handshakeException() throws SSLException {
        if (SSL.bioLengthNonApplication(this.networkBIO) > 0) {
            return SSLEngineResult.HandshakeStatus.NEED_WRAP;
        }
        Throwable th = this.handshakeException;
        this.handshakeException = null;
        shutdown();
        if (th instanceof SSLHandshakeException) {
            throw ((SSLHandshakeException) th);
        }
        SSLHandshakeException sSLHandshakeException = new SSLHandshakeException("General OpenSslEngine problem");
        sSLHandshakeException.initCause(th);
        throw sSLHandshakeException;
    }

    private boolean isBytesAvailableEnoughForWrap(int i4, int i5, int i6) {
        return ((long) i4) - (((long) this.maxWrapOverhead) * ((long) i6)) >= ((long) i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDestroyed() {
        return this.destroyed != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    private static boolean isEndPointVerificationEnabled(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    private static boolean isProtocolEnabled(int i4, int i5, String str) {
        return (i4 & i5) == 0 && OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(str);
    }

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        return (handshakeStatus != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING || this.handshakeState == HandshakeState.FINISHED) ? handshakeStatus : handshake();
    }

    private boolean needPendingStatus() {
        return (this.handshakeState == HandshakeState.NOT_STARTED || isDestroyed() || (this.handshakeState == HandshakeState.FINISHED && !isInboundDone() && !isOutboundDone())) ? false : true;
    }

    private SSLEngineResult newResult(SSLEngineResult.HandshakeStatus handshakeStatus, int i4, int i5) {
        return newResult(SSLEngineResult.Status.OK, handshakeStatus, i4, i5);
    }

    private SSLEngineResult newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus, int i4, int i5) throws SSLException {
        SSLEngineResult.HandshakeStatus handshakeStatus2 = SSLEngineResult.HandshakeStatus.FINISHED;
        if (handshakeStatus != handshakeStatus2) {
            handshakeStatus2 = getHandshakeStatus();
        }
        return newResult(mayFinishHandshake(handshakeStatus2), i4, i5);
    }

    private static SSLEngineResult.HandshakeStatus pendingStatus(int i4) {
        return i4 > 0 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
    }

    private int readPlaintextData(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        if (byteBuffer.isDirect()) {
            int readFromSSL = SSL.readFromSSL(this.ssl, bufferAddress(byteBuffer) + position, byteBuffer.limit() - position);
            if (readFromSSL > 0) {
                byteBuffer.position(position + readFromSSL);
                return readFromSSL;
            }
            return readFromSSL;
        }
        int limit = byteBuffer.limit();
        int min = Math.min(maxEncryptedPacketLength0(), limit - position);
        ByteBuf directBuffer = this.alloc.directBuffer(min);
        try {
            int readFromSSL2 = SSL.readFromSSL(this.ssl, OpenSsl.memoryAddress(directBuffer), min);
            if (readFromSSL2 > 0) {
                byteBuffer.limit(position + readFromSSL2);
                directBuffer.getBytes(directBuffer.readerIndex(), byteBuffer);
                byteBuffer.limit(limit);
            }
            return readFromSSL2;
        } finally {
            directBuffer.release();
        }
    }

    private void rejectRemoteInitiatedRenegotiation() throws SSLHandshakeException {
        if (isDestroyed() || SSL.getHandshakeCount(this.ssl) <= 1 || "TLSv1.3".equals(this.session.getProtocol()) || this.handshakeState != HandshakeState.FINISHED) {
            return;
        }
        shutdown();
        throw new SSLHandshakeException("remote-initiated renegotiation not allowed");
    }

    private void resetSingleDstBuffer() {
        this.singleDstBuffer[0] = null;
    }

    private void resetSingleSrcBuffer() {
        this.singleSrcBuffer[0] = null;
    }

    private void setClientAuth(ClientAuth clientAuth) {
        if (this.clientMode) {
            return;
        }
        synchronized (this) {
            if (this.clientAuth == clientAuth) {
                return;
            }
            int i4 = AnonymousClass4.$SwitchMap$io$netty$handler$ssl$ClientAuth[clientAuth.ordinal()];
            if (i4 == 1) {
                SSL.setVerify(this.ssl, 0, 10);
            } else if (i4 == 2) {
                SSL.setVerify(this.ssl, 2, 10);
            } else if (i4 == 3) {
                SSL.setVerify(this.ssl, 1, 10);
            } else {
                throw new Error(clientAuth.toString());
            }
            this.clientAuth = clientAuth;
        }
    }

    private SSLException shutdownWithError(String str, int i4) {
        return shutdownWithError(str, i4, SSL.getLastErrorNumber());
    }

    private ByteBuffer[] singleDstBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleDstBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private ByteBuffer[] singleSrcBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleSrcBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private int sslPending0() {
        if (this.handshakeState != HandshakeState.FINISHED) {
            return 0;
        }
        return SSL.sslPending(this.ssl);
    }

    private SSLEngineResult sslReadErrorResult(int i4, int i5, int i6, int i7) throws SSLException {
        if (SSL.bioLengthNonApplication(this.networkBIO) > 0) {
            if (this.handshakeException == null && this.handshakeState != HandshakeState.FINISHED) {
                this.handshakeException = new SSLHandshakeException(SSL.getErrorString(i5));
            }
            SSL.clearError();
            return new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, i6, i7);
        }
        throw shutdownWithError("SSL_read", i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String toJavaCipherSuite(String str) {
        if (str == null) {
            return null;
        }
        return CipherSuiteConverter.toJava(str, toJavaCipherSuitePrefix(SSL.getVersion(this.ssl)));
    }

    private static String toJavaCipherSuitePrefix(String str) {
        char c4 = 0;
        if (str != null && !str.isEmpty()) {
            c4 = str.charAt(0);
        }
        return c4 != 'S' ? c4 != 'T' ? "UNKNOWN" : "TLS" : "SSL";
    }

    private ByteBuf writeEncryptedData(ByteBuffer byteBuffer, int i4) {
        int position = byteBuffer.position();
        if (byteBuffer.isDirect()) {
            SSL.bioSetByteBuffer(this.networkBIO, bufferAddress(byteBuffer) + position, i4, false);
            return null;
        }
        ByteBuf directBuffer = this.alloc.directBuffer(i4);
        try {
            int limit = byteBuffer.limit();
            byteBuffer.limit(position + i4);
            directBuffer.writeBytes(byteBuffer);
            byteBuffer.position(position);
            byteBuffer.limit(limit);
            SSL.bioSetByteBuffer(this.networkBIO, OpenSsl.memoryAddress(directBuffer), i4, false);
            return directBuffer;
        } catch (Throwable th) {
            directBuffer.release();
            PlatformDependent.throwException(th);
            return null;
        }
    }

    private int writePlaintextData(ByteBuffer byteBuffer, int i4) {
        int writeToSSL;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        if (byteBuffer.isDirect()) {
            writeToSSL = SSL.writeToSSL(this.ssl, bufferAddress(byteBuffer) + position, i4);
            if (writeToSSL > 0) {
                byteBuffer.position(position + writeToSSL);
            }
        } else {
            ByteBuf directBuffer = this.alloc.directBuffer(i4);
            try {
                byteBuffer.limit(position + i4);
                directBuffer.setBytes(0, byteBuffer);
                byteBuffer.limit(limit);
                writeToSSL = SSL.writeToSSL(this.ssl, OpenSsl.memoryAddress(directBuffer), i4);
                if (writeToSSL > 0) {
                    byteBuffer.position(position + writeToSSL);
                } else {
                    byteBuffer.position(position);
                }
            } finally {
                directBuffer.release();
            }
        }
        return writeToSSL;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void beginHandshake() throws SSLException {
        int i4 = AnonymousClass4.$SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[this.handshakeState.ordinal()];
        if (i4 == 1) {
            this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
            if (handshake() == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                this.needTask = true;
            }
            calculateMaxWrapOverhead();
        } else if (i4 == 2) {
            throw new SSLException("renegotiation unsupported");
        } else {
            if (i4 == 3) {
                checkEngineClosed();
                this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
                calculateMaxWrapOverhead();
            } else if (i4 != 4) {
                throw new Error();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int calculateMaxLengthForWrap(int i4, int i5) {
        return (int) Math.min(this.maxWrapBufferSize, i4 + (this.maxWrapOverhead * i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean checkSniHostnameMatch(byte[] bArr) {
        return Java8SslUtils.checkSniHostnameMatch(this.matchers, bArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void closeInbound() throws SSLException {
        if (this.isInboundDone) {
            return;
        }
        this.isInboundDone = true;
        if (isOutboundDone()) {
            shutdown();
        }
        if (this.handshakeState != HandshakeState.NOT_STARTED && !this.receivedShutdown) {
            throw new SSLException("Inbound closed before receiving peer's close_notify: possible truncation attack?");
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void closeOutbound() {
        if (this.outboundClosed) {
            return;
        }
        this.outboundClosed = true;
        if (this.handshakeState != HandshakeState.NOT_STARTED && !isDestroyed()) {
            if ((SSL.getShutdown(this.ssl) & SSL.SSL_SENT_SHUTDOWN) != SSL.SSL_SENT_SHUTDOWN) {
                doSSLShutdown();
            }
        } else {
            shutdown();
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized Runnable getDelegatedTask() {
        if (isDestroyed()) {
            return null;
        }
        final Runnable task = SSL.getTask(this.ssl);
        if (task == null) {
            return null;
        }
        return new Runnable() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.3
            @Override // java.lang.Runnable
            public void run() {
                if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                    return;
                }
                try {
                    task.run();
                } finally {
                    ReferenceCountedOpenSslEngine.this.needTask = false;
                }
            }
        };
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getEnableSessionCreation() {
        return false;
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getEnabledCipherSuites() {
        synchronized (this) {
            if (!isDestroyed()) {
                String[] ciphers = SSL.getCiphers(this.ssl);
                if (ciphers == null) {
                    return EmptyArrays.EMPTY_STRINGS;
                }
                ArrayList arrayList = new ArrayList();
                synchronized (this) {
                    for (int i4 = 0; i4 < ciphers.length; i4++) {
                        String javaCipherSuite = toJavaCipherSuite(ciphers[i4]);
                        if (javaCipherSuite == null) {
                            javaCipherSuite = ciphers[i4];
                        }
                        if (OpenSsl.isTlsv13Supported() || !SslUtils.isTLSv13Cipher(javaCipherSuite)) {
                            arrayList.add(javaCipherSuite);
                        }
                    }
                }
                return (String[]) arrayList.toArray(new String[0]);
            }
            return EmptyArrays.EMPTY_STRINGS;
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getEnabledProtocols() {
        ArrayList arrayList = new ArrayList(6);
        arrayList.add("SSLv2Hello");
        synchronized (this) {
            if (!isDestroyed()) {
                int options = SSL.getOptions(this.ssl);
                if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1, "TLSv1")) {
                    arrayList.add("TLSv1");
                }
                if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1_1, "TLSv1.1")) {
                    arrayList.add("TLSv1.1");
                }
                if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1_2, "TLSv1.2")) {
                    arrayList.add("TLSv1.2");
                }
                if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1_3, "TLSv1.3")) {
                    arrayList.add("TLSv1.3");
                }
                if (isProtocolEnabled(options, SSL.SSL_OP_NO_SSLv2, "SSLv2")) {
                    arrayList.add("SSLv2");
                }
                if (isProtocolEnabled(options, SSL.SSL_OP_NO_SSLv3, "SSLv3")) {
                    arrayList.add("SSLv3");
                }
                return (String[]) arrayList.toArray(new String[0]);
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLSession getHandshakeSession() {
        int i4 = AnonymousClass4.$SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[this.handshakeState.ordinal()];
        if (i4 == 1 || i4 == 2) {
            return null;
        }
        return this.session;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        if (needPendingStatus()) {
            if (this.needTask) {
                return SSLEngineResult.HandshakeStatus.NEED_TASK;
            }
            return pendingStatus(SSL.bioLengthNonApplication(this.networkBIO));
        }
        return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getNeedClientAuth() {
        return this.clientAuth == ClientAuth.REQUIRE;
    }

    public String getNegotiatedApplicationProtocol() {
        return this.applicationProtocol;
    }

    public byte[] getOcspResponse() {
        byte[] ocspResponse;
        if (this.enableOcsp) {
            if (this.clientMode) {
                synchronized (this) {
                    ocspResponse = SSL.getOcspResponse(this.ssl);
                }
                return ocspResponse;
            }
            throw new IllegalStateException("Not a client SSLEngine");
        }
        throw new IllegalStateException("OCSP stapling is not enabled");
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLParameters getSSLParameters() {
        SSLParameters sSLParameters;
        sSLParameters = super.getSSLParameters();
        int javaVersion = PlatformDependent.javaVersion();
        if (javaVersion >= 7) {
            sSLParameters.setEndpointIdentificationAlgorithm(this.endPointIdentificationAlgorithm);
            Java7SslParametersUtils.setAlgorithmConstraints(sSLParameters, this.algorithmConstraints);
            if (javaVersion >= 8) {
                List<String> list = this.sniHostNames;
                if (list != null) {
                    Java8SslUtils.setSniHostNames(sSLParameters, list);
                }
                if (!isDestroyed()) {
                    Java8SslUtils.setUseCipherSuitesOrder(sSLParameters, (SSL.getOptions(this.ssl) & SSL.SSL_OP_CIPHER_SERVER_PREFERENCE) != 0);
                }
                Java8SslUtils.setSNIMatchers(sSLParameters, this.matchers);
            }
        }
        return sSLParameters;
    }

    @Override // javax.net.ssl.SSLEngine
    public final SSLSession getSession() {
        return this.session;
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getSupportedCipherSuites() {
        return (String[]) OpenSsl.AVAILABLE_CIPHER_SUITES.toArray(new String[0]);
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getSupportedProtocols() {
        return (String[]) OpenSsl.SUPPORTED_PROTOCOLS_SET.toArray(new String[0]);
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getUseClientMode() {
        return this.clientMode;
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getWantClientAuth() {
        return this.clientAuth == ClientAuth.OPTIONAL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void initHandshakeException(Throwable th) {
        this.handshakeException = th;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized boolean isInboundDone() {
        return this.isInboundDone;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0011, code lost:
        if (io.netty.internal.tcnative.SSL.bioLengthNonApplication(r0) == 0) goto L10;
     */
    @Override // javax.net.ssl.SSLEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean isOutboundDone() {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.outboundClosed     // Catch: java.lang.Throwable -> L18
            if (r0 == 0) goto L15
            long r0 = r5.networkBIO     // Catch: java.lang.Throwable -> L18
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L13
            int r0 = io.netty.internal.tcnative.SSL.bioLengthNonApplication(r0)     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L15
        L13:
            r0 = 1
            goto L16
        L15:
            r0 = 0
        L16:
            monitor-exit(r5)
            return r0
        L18:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.isOutboundDone():boolean");
    }

    final synchronized int maxEncryptedPacketLength() {
        return maxEncryptedPacketLength0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int maxEncryptedPacketLength0() {
        return this.maxWrapOverhead + MAX_PLAINTEXT_LENGTH;
    }

    final synchronized int maxWrapOverhead() {
        return this.maxWrapOverhead;
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

    @Override // javax.net.ssl.SSLEngine
    public final void setEnableSessionCreation(boolean z3) {
        if (z3) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setEnabledCipherSuites(String[] strArr) {
        ObjectUtil.checkNotNull(strArr, "cipherSuites");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        CipherSuiteConverter.convertToCipherStrings(Arrays.asList(strArr), sb, sb2, OpenSsl.isBoringSSL());
        String sb3 = sb.toString();
        String sb4 = sb2.toString();
        if (!OpenSsl.isTlsv13Supported() && !sb4.isEmpty()) {
            throw new IllegalArgumentException("TLSv1.3 is not supported by this java version.");
        }
        synchronized (this) {
            if (!isDestroyed()) {
                try {
                    SSL.setCipherSuites(this.ssl, sb3, false);
                    if (OpenSsl.isTlsv13Supported()) {
                        SSL.setCipherSuites(this.ssl, sb4, true);
                    }
                } catch (Exception e4) {
                    throw new IllegalStateException("failed to enable cipher suites: " + sb3, e4);
                }
            } else {
                throw new IllegalStateException("failed to enable cipher suites: " + sb3);
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setEnabledProtocols(String[] strArr) {
        if (strArr != null) {
            int length = OPENSSL_OP_NO_PROTOCOLS.length;
            int i4 = 0;
            for (String str : strArr) {
                if (OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(str)) {
                    if (str.equals("SSLv2")) {
                        if (length > 0) {
                            length = 0;
                        }
                        if (i4 < 0) {
                            i4 = 0;
                        }
                    } else if (str.equals("SSLv3")) {
                        if (length > 1) {
                            length = 1;
                        }
                        if (i4 < 1) {
                            i4 = 1;
                        }
                    } else if (str.equals("TLSv1")) {
                        if (length > 2) {
                            length = 2;
                        }
                        if (i4 < 2) {
                            i4 = 2;
                        }
                    } else if (str.equals("TLSv1.1")) {
                        if (length > 3) {
                            length = 3;
                        }
                        if (i4 < 3) {
                            i4 = 3;
                        }
                    } else if (str.equals("TLSv1.2")) {
                        if (length > 4) {
                            length = 4;
                        }
                        if (i4 < 4) {
                            i4 = 4;
                        }
                    } else if (str.equals("TLSv1.3")) {
                        if (length > 5) {
                            length = 5;
                        }
                        if (i4 < 5) {
                            i4 = 5;
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Protocol " + str + " is not supported.");
                }
            }
            synchronized (this) {
                if (!isDestroyed()) {
                    SSL.clearOptions(this.ssl, SSL.SSL_OP_NO_SSLv2 | SSL.SSL_OP_NO_SSLv3 | SSL.SSL_OP_NO_TLSv1 | SSL.SSL_OP_NO_TLSv1_1 | SSL.SSL_OP_NO_TLSv1_2 | SSL.SSL_OP_NO_TLSv1_3);
                    int i5 = 0;
                    for (int i6 = 0; i6 < length; i6++) {
                        i5 |= OPENSSL_OP_NO_PROTOCOLS[i6];
                    }
                    int i7 = i4 + 1;
                    while (true) {
                        int[] iArr = OPENSSL_OP_NO_PROTOCOLS;
                        if (i7 < iArr.length) {
                            i5 |= iArr[i7];
                            i7++;
                        } else {
                            SSL.setOptions(this.ssl, i5);
                        }
                    }
                } else {
                    throw new IllegalStateException("failed to enable protocols: " + Arrays.asList(strArr));
                }
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    final void setKeyMaterial(OpenSslKeyMaterial openSslKeyMaterial) throws Exception {
        SSL.setKeyMaterial(this.ssl, openSslKeyMaterial.certificateChainAddress(), openSslKeyMaterial.privateKeyAddress());
        this.localCertificateChain = openSslKeyMaterial.certificateChain();
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setNeedClientAuth(boolean z3) {
        setClientAuth(z3 ? ClientAuth.REQUIRE : ClientAuth.NONE);
    }

    public void setOcspResponse(byte[] bArr) {
        if (this.enableOcsp) {
            if (!this.clientMode) {
                synchronized (this) {
                    SSL.setOcspResponse(this.ssl, bArr);
                }
                return;
            }
            throw new IllegalStateException("Not a server SSLEngine");
        }
        throw new IllegalStateException("OCSP stapling is not enabled");
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void setSSLParameters(SSLParameters sSLParameters) {
        int javaVersion = PlatformDependent.javaVersion();
        if (javaVersion >= 7) {
            if (sSLParameters.getAlgorithmConstraints() == null) {
                if (javaVersion >= 8) {
                    if (!isDestroyed()) {
                        if (this.clientMode) {
                            List<String> sniHostNames = Java8SslUtils.getSniHostNames(sSLParameters);
                            for (String str : sniHostNames) {
                                SSL.setTlsExtHostName(this.ssl, str);
                            }
                            this.sniHostNames = sniHostNames;
                        }
                        if (Java8SslUtils.getUseCipherSuitesOrder(sSLParameters)) {
                            SSL.setOptions(this.ssl, SSL.SSL_OP_CIPHER_SERVER_PREFERENCE);
                        } else {
                            SSL.clearOptions(this.ssl, SSL.SSL_OP_CIPHER_SERVER_PREFERENCE);
                        }
                    }
                    this.matchers = sSLParameters.getSNIMatchers();
                }
                String endpointIdentificationAlgorithm = sSLParameters.getEndpointIdentificationAlgorithm();
                boolean isEndPointVerificationEnabled = isEndPointVerificationEnabled(endpointIdentificationAlgorithm);
                if (this.clientMode && isEndPointVerificationEnabled) {
                    SSL.setVerify(this.ssl, 2, -1);
                }
                this.endPointIdentificationAlgorithm = endpointIdentificationAlgorithm;
                this.algorithmConstraints = sSLParameters.getAlgorithmConstraints();
            } else {
                throw new IllegalArgumentException("AlgorithmConstraints are not supported.");
            }
        }
        super.setSSLParameters(sSLParameters);
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setUseClientMode(boolean z3) {
        if (z3 != this.clientMode) {
            throw new UnsupportedOperationException();
        }
    }

    public final synchronized void setVerify(int i4, int i5) {
        SSL.setVerify(this.ssl, i4, i5);
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setWantClientAuth(boolean z3) {
        setClientAuth(z3 ? ClientAuth.OPTIONAL : ClientAuth.NONE);
    }

    public final synchronized void shutdown() {
        if (DESTROYED_UPDATER.compareAndSet(this, 0, 1)) {
            this.engineMap.remove(this.ssl);
            SSL.freeSSL(this.ssl);
            this.networkBIO = 0L;
            this.ssl = 0L;
            this.outboundClosed = true;
            this.isInboundDone = true;
        }
        SSL.clearError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized int sslPending() {
        return sslPending0();
    }

    public final synchronized long sslPointer() {
        return this.ssl;
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch() {
        this.refCnt.touch();
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:115:0x01a3, code lost:
        if (r13 != null) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01a5, code lost:
        r13.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0214, code lost:
        if (r13 == null) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x02a0, code lost:
        io.netty.internal.tcnative.SSL.bioClearByteBuffer(r18.networkBIO);
        rejectRemoteInitiatedRenegotiation();
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x02aa, code lost:
        if (r18.receivedShutdown != false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x02b7, code lost:
        if ((io.netty.internal.tcnative.SSL.getShutdown(r18.ssl) & io.netty.internal.tcnative.SSL.SSL_RECEIVED_SHUTDOWN) != io.netty.internal.tcnative.SSL.SSL_RECEIVED_SHUTDOWN) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x02b9, code lost:
        closeAll();
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x02c0, code lost:
        if (isInboundDone() == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x02c2, code lost:
        r0 = javax.net.ssl.SSLEngineResult.Status.CLOSED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x02c5, code lost:
        r0 = javax.net.ssl.SSLEngineResult.Status.OK;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x02c7, code lost:
        r0 = newResultMayFinishHandshake(r0, r6, r9, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x02cc, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final javax.net.ssl.SSLEngineResult unwrap(java.nio.ByteBuffer[] r19, int r20, int r21, java.nio.ByteBuffer[] r22, int r23, int r24) throws javax.net.ssl.SSLException {
        /*
            Method dump skipped, instructions count: 854
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.unwrap(java.nio.ByteBuffer[], int, int, java.nio.ByteBuffer[], int, int):javax.net.ssl.SSLEngineResult");
    }

    /* JADX WARN: Removed duplicated region for block: B:266:0x0495 A[Catch: all -> 0x04ad, TryCatch #5 {, blocks: (B:11:0x0013, B:13:0x0019, B:15:0x001f, B:18:0x0026, B:20:0x002b, B:19:0x0029, B:32:0x0083, B:34:0x008a, B:36:0x00a1, B:35:0x0093, B:41:0x00b1, B:43:0x00b8, B:45:0x00cf, B:44:0x00c1, B:50:0x00dd, B:52:0x00e4, B:54:0x00fb, B:53:0x00ed, B:59:0x010a, B:61:0x0111, B:63:0x0128, B:62:0x011a, B:264:0x048e, B:266:0x0495, B:268:0x04ac, B:267:0x04a4, B:78:0x0153, B:80:0x015a, B:82:0x0171, B:81:0x0163, B:87:0x0187, B:89:0x018e, B:91:0x01a5, B:90:0x0197, B:100:0x01c4, B:102:0x01cb, B:104:0x01e2, B:103:0x01d4, B:112:0x01f3, B:114:0x01fa, B:116:0x0211, B:115:0x0203, B:122:0x0221, B:124:0x0228, B:126:0x023f, B:125:0x0231, B:151:0x0299, B:153:0x02a0, B:155:0x02b7, B:154:0x02a9, B:186:0x0336, B:188:0x033d, B:190:0x0354, B:189:0x0346, B:205:0x038f, B:207:0x0396, B:209:0x03ad, B:208:0x039f, B:212:0x03b5, B:214:0x03bc, B:216:0x03d3, B:215:0x03c5, B:221:0x03df, B:223:0x03e6, B:225:0x03fd, B:224:0x03ef, B:230:0x0409, B:232:0x0410, B:234:0x0427, B:233:0x0419, B:246:0x0443, B:248:0x044a, B:250:0x0461, B:249:0x0453, B:168:0x02ef, B:170:0x02f6, B:172:0x030d, B:171:0x02ff, B:253:0x0467, B:255:0x046e, B:257:0x0485, B:256:0x0477), top: B:286:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x04a4 A[Catch: all -> 0x04ad, TryCatch #5 {, blocks: (B:11:0x0013, B:13:0x0019, B:15:0x001f, B:18:0x0026, B:20:0x002b, B:19:0x0029, B:32:0x0083, B:34:0x008a, B:36:0x00a1, B:35:0x0093, B:41:0x00b1, B:43:0x00b8, B:45:0x00cf, B:44:0x00c1, B:50:0x00dd, B:52:0x00e4, B:54:0x00fb, B:53:0x00ed, B:59:0x010a, B:61:0x0111, B:63:0x0128, B:62:0x011a, B:264:0x048e, B:266:0x0495, B:268:0x04ac, B:267:0x04a4, B:78:0x0153, B:80:0x015a, B:82:0x0171, B:81:0x0163, B:87:0x0187, B:89:0x018e, B:91:0x01a5, B:90:0x0197, B:100:0x01c4, B:102:0x01cb, B:104:0x01e2, B:103:0x01d4, B:112:0x01f3, B:114:0x01fa, B:116:0x0211, B:115:0x0203, B:122:0x0221, B:124:0x0228, B:126:0x023f, B:125:0x0231, B:151:0x0299, B:153:0x02a0, B:155:0x02b7, B:154:0x02a9, B:186:0x0336, B:188:0x033d, B:190:0x0354, B:189:0x0346, B:205:0x038f, B:207:0x0396, B:209:0x03ad, B:208:0x039f, B:212:0x03b5, B:214:0x03bc, B:216:0x03d3, B:215:0x03c5, B:221:0x03df, B:223:0x03e6, B:225:0x03fd, B:224:0x03ef, B:230:0x0409, B:232:0x0410, B:234:0x0427, B:233:0x0419, B:246:0x0443, B:248:0x044a, B:250:0x0461, B:249:0x0453, B:168:0x02ef, B:170:0x02f6, B:172:0x030d, B:171:0x02ff, B:253:0x0467, B:255:0x046e, B:257:0x0485, B:256:0x0477), top: B:286:0x0013 }] */
    @Override // javax.net.ssl.SSLEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final javax.net.ssl.SSLEngineResult wrap(java.nio.ByteBuffer[] r12, int r13, int r14, java.nio.ByteBuffer r15) throws javax.net.ssl.SSLException {
        /*
            Method dump skipped, instructions count: 1269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.wrap(java.nio.ByteBuffer[], int, int, java.nio.ByteBuffer):javax.net.ssl.SSLEngineResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    private SSLEngineResult newResult(SSLEngineResult.Status status, SSLEngineResult.HandshakeStatus handshakeStatus, int i4, int i5) {
        if (isOutboundDone()) {
            if (isInboundDone()) {
                handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                shutdown();
            }
            return new SSLEngineResult(SSLEngineResult.Status.CLOSED, handshakeStatus, i4, i5);
        }
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_TASK) {
            this.needTask = true;
        }
        return new SSLEngineResult(status, handshakeStatus, i4, i5);
    }

    private SSLEngineResult newResultMayFinishHandshake(SSLEngineResult.Status status, SSLEngineResult.HandshakeStatus handshakeStatus, int i4, int i5) throws SSLException {
        SSLEngineResult.HandshakeStatus handshakeStatus2 = SSLEngineResult.HandshakeStatus.FINISHED;
        if (handshakeStatus != handshakeStatus2) {
            handshakeStatus2 = getHandshakeStatus();
        }
        return newResult(status, mayFinishHandshake(handshakeStatus2), i4, i5);
    }

    private SSLException shutdownWithError(String str, int i4, int i5) {
        String errorString = SSL.getErrorString(i5);
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} failed with {}: OpenSSL error: {} {}", str, Integer.valueOf(i4), Integer.valueOf(i5), errorString);
        }
        shutdown();
        if (this.handshakeState == HandshakeState.FINISHED) {
            return new SSLException(errorString);
        }
        SSLHandshakeException sSLHandshakeException = new SSLHandshakeException(errorString);
        Throwable th = this.handshakeException;
        if (th != null) {
            sSLHandshakeException.initCause(th);
            this.handshakeException = null;
        }
        return sSLHandshakeException;
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release(int i4) {
        return this.refCnt.release(i4);
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted retain(int i4) {
        this.refCnt.retain(i4);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch(Object obj) {
        this.refCnt.touch(obj);
        return this;
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatus(int i4) {
        if (needPendingStatus()) {
            if (this.needTask) {
                return SSLEngineResult.HandshakeStatus.NEED_TASK;
            }
            return pendingStatus(i4);
        }
        return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private final class DefaultOpenSslSession implements io.netty.handler.ssl.OpenSslSession {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile int applicationBufferSize = ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH;
        private String cipher;
        private long creationTime;
        private byte[] id;
        private Certificate[] peerCerts;
        private String protocol;
        private final OpenSslSessionContext sessionContext;
        private Map<String, Object> values;
        private X509Certificate[] x509PeerCerts;

        DefaultOpenSslSession(OpenSslSessionContext openSslSessionContext) {
            this.sessionContext = openSslSessionContext;
        }

        private void initCerts(byte[][] bArr, int i4) {
            for (int i5 = 0; i5 < bArr.length; i5++) {
                int i6 = i4 + i5;
                this.peerCerts[i6] = new OpenSslX509Certificate(bArr[i5]);
                this.x509PeerCerts[i6] = new OpenSslJavaxX509Certificate(bArr[i5]);
            }
        }

        private void initPeerCerts() {
            byte[][] peerCertChain = SSL.getPeerCertChain(ReferenceCountedOpenSslEngine.this.ssl);
            if (ReferenceCountedOpenSslEngine.this.clientMode) {
                if (ReferenceCountedOpenSslEngine.isEmpty(peerCertChain)) {
                    this.peerCerts = EmptyArrays.EMPTY_CERTIFICATES;
                    this.x509PeerCerts = EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
                    return;
                }
                this.peerCerts = new Certificate[peerCertChain.length];
                this.x509PeerCerts = new X509Certificate[peerCertChain.length];
                initCerts(peerCertChain, 0);
                return;
            }
            byte[] peerCertificate = SSL.getPeerCertificate(ReferenceCountedOpenSslEngine.this.ssl);
            if (ReferenceCountedOpenSslEngine.isEmpty(peerCertificate)) {
                this.peerCerts = EmptyArrays.EMPTY_CERTIFICATES;
                this.x509PeerCerts = EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
            } else if (ReferenceCountedOpenSslEngine.isEmpty(peerCertChain)) {
                this.peerCerts = new Certificate[]{new OpenSslX509Certificate(peerCertificate)};
                this.x509PeerCerts = new X509Certificate[]{new OpenSslJavaxX509Certificate(peerCertificate)};
            } else {
                Certificate[] certificateArr = new Certificate[peerCertChain.length + 1];
                this.peerCerts = certificateArr;
                this.x509PeerCerts = new X509Certificate[peerCertChain.length + 1];
                certificateArr[0] = new OpenSslX509Certificate(peerCertificate);
                this.x509PeerCerts[0] = new OpenSslJavaxX509Certificate(peerCertificate);
                initCerts(peerCertChain, 1);
            }
        }

        private SSLSessionBindingEvent newSSLSessionBindingEvent(String str) {
            return new SSLSessionBindingEvent(ReferenceCountedOpenSslEngine.this.session, str);
        }

        private void notifyUnbound(Object obj, String str) {
            if (obj instanceof SSLSessionBindingListener) {
                ((SSLSessionBindingListener) obj).valueUnbound(newSSLSessionBindingEvent(str));
            }
        }

        private void selectApplicationProtocol() throws SSLException {
            ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior = ReferenceCountedOpenSslEngine.this.apn.selectedListenerFailureBehavior();
            List<String> protocols = ReferenceCountedOpenSslEngine.this.apn.protocols();
            int i4 = AnonymousClass4.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ReferenceCountedOpenSslEngine.this.apn.protocol().ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    String alpnSelected = SSL.getAlpnSelected(ReferenceCountedOpenSslEngine.this.ssl);
                    if (alpnSelected != null) {
                        ReferenceCountedOpenSslEngine.this.applicationProtocol = selectApplicationProtocol(protocols, selectedListenerFailureBehavior, alpnSelected);
                    }
                } else if (i4 == 3) {
                    String nextProtoNegotiated = SSL.getNextProtoNegotiated(ReferenceCountedOpenSslEngine.this.ssl);
                    if (nextProtoNegotiated != null) {
                        ReferenceCountedOpenSslEngine.this.applicationProtocol = selectApplicationProtocol(protocols, selectedListenerFailureBehavior, nextProtoNegotiated);
                    }
                } else if (i4 == 4) {
                    String alpnSelected2 = SSL.getAlpnSelected(ReferenceCountedOpenSslEngine.this.ssl);
                    if (alpnSelected2 == null) {
                        alpnSelected2 = SSL.getNextProtoNegotiated(ReferenceCountedOpenSslEngine.this.ssl);
                    }
                    if (alpnSelected2 != null) {
                        ReferenceCountedOpenSslEngine.this.applicationProtocol = selectApplicationProtocol(protocols, selectedListenerFailureBehavior, alpnSelected2);
                    }
                } else {
                    throw new Error();
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public int getApplicationBufferSize() {
            return this.applicationBufferSize;
        }

        @Override // javax.net.ssl.SSLSession
        public String getCipherSuite() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                String str = this.cipher;
                return str == null ? ReferenceCountedOpenSslEngine.INVALID_CIPHER : str;
            }
        }

        @Override // javax.net.ssl.SSLSession
        public long getCreationTime() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (this.creationTime == 0 && !ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                    this.creationTime = SSL.getTime(ReferenceCountedOpenSslEngine.this.ssl) * 1000;
                }
            }
            return this.creationTime;
        }

        @Override // javax.net.ssl.SSLSession
        public byte[] getId() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                byte[] bArr = this.id;
                if (bArr == null) {
                    return EmptyArrays.EMPTY_BYTES;
                }
                return (byte[]) bArr.clone();
            }
        }

        @Override // javax.net.ssl.SSLSession
        public long getLastAccessedTime() {
            long j4 = ReferenceCountedOpenSslEngine.this.lastAccessed;
            return j4 == -1 ? getCreationTime() : j4;
        }

        @Override // javax.net.ssl.SSLSession
        public Certificate[] getLocalCertificates() {
            Certificate[] certificateArr = ReferenceCountedOpenSslEngine.this.localCertificateChain;
            if (certificateArr == null) {
                return null;
            }
            return (Certificate[]) certificateArr.clone();
        }

        @Override // javax.net.ssl.SSLSession
        public Principal getLocalPrincipal() {
            Certificate[] certificateArr = ReferenceCountedOpenSslEngine.this.localCertificateChain;
            if (certificateArr == null || certificateArr.length == 0) {
                return null;
            }
            return ((java.security.cert.X509Certificate) certificateArr[0]).getIssuerX500Principal();
        }

        @Override // javax.net.ssl.SSLSession
        public int getPacketBufferSize() {
            return ReferenceCountedOpenSslEngine.this.maxEncryptedPacketLength();
        }

        @Override // javax.net.ssl.SSLSession
        public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
            X509Certificate[] x509CertificateArr;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (!ReferenceCountedOpenSslEngine.isEmpty(this.x509PeerCerts)) {
                    x509CertificateArr = (X509Certificate[]) this.x509PeerCerts.clone();
                } else {
                    throw new SSLPeerUnverifiedException("peer not verified");
                }
            }
            return x509CertificateArr;
        }

        @Override // javax.net.ssl.SSLSession
        public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
            Certificate[] certificateArr;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (!ReferenceCountedOpenSslEngine.isEmpty(this.peerCerts)) {
                    certificateArr = (Certificate[]) this.peerCerts.clone();
                } else {
                    throw new SSLPeerUnverifiedException("peer not verified");
                }
            }
            return certificateArr;
        }

        @Override // javax.net.ssl.SSLSession
        public String getPeerHost() {
            return ReferenceCountedOpenSslEngine.this.getPeerHost();
        }

        @Override // javax.net.ssl.SSLSession
        public int getPeerPort() {
            return ReferenceCountedOpenSslEngine.this.getPeerPort();
        }

        @Override // javax.net.ssl.SSLSession
        public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
            return ((java.security.cert.X509Certificate) getPeerCertificates()[0]).getSubjectX500Principal();
        }

        @Override // javax.net.ssl.SSLSession
        public String getProtocol() {
            String str = this.protocol;
            if (str == null) {
                synchronized (ReferenceCountedOpenSslEngine.this) {
                    str = !ReferenceCountedOpenSslEngine.this.isDestroyed() ? SSL.getVersion(ReferenceCountedOpenSslEngine.this.ssl) : "";
                }
            }
            return str;
        }

        @Override // javax.net.ssl.SSLSession
        public SSLSessionContext getSessionContext() {
            return this.sessionContext;
        }

        @Override // javax.net.ssl.SSLSession
        public Object getValue(String str) {
            if (str != null) {
                synchronized (this) {
                    Map<String, Object> map = this.values;
                    if (map == null) {
                        return null;
                    }
                    return map.get(str);
                }
            }
            throw new NullPointerException("name");
        }

        @Override // javax.net.ssl.SSLSession
        public String[] getValueNames() {
            synchronized (this) {
                Map<String, Object> map = this.values;
                if (map != null && !map.isEmpty()) {
                    return (String[]) map.keySet().toArray(new String[0]);
                }
                return EmptyArrays.EMPTY_STRINGS;
            }
        }

        @Override // io.netty.handler.ssl.OpenSslSession
        public void handshakeFinished() throws SSLException {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (!ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                    this.id = SSL.getSessionId(ReferenceCountedOpenSslEngine.this.ssl);
                    ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = ReferenceCountedOpenSslEngine.this;
                    this.cipher = referenceCountedOpenSslEngine.toJavaCipherSuite(SSL.getCipherForSSL(referenceCountedOpenSslEngine.ssl));
                    this.protocol = SSL.getVersion(ReferenceCountedOpenSslEngine.this.ssl);
                    initPeerCerts();
                    selectApplicationProtocol();
                    ReferenceCountedOpenSslEngine.this.calculateMaxWrapOverhead();
                    ReferenceCountedOpenSslEngine.this.handshakeState = HandshakeState.FINISHED;
                } else {
                    throw new SSLException("Already closed");
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public void invalidate() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (!ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                    SSL.setTimeout(ReferenceCountedOpenSslEngine.this.ssl, 0L);
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public boolean isValid() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                    return false;
                }
                return System.currentTimeMillis() - (SSL.getTimeout(ReferenceCountedOpenSslEngine.this.ssl) * 1000) < SSL.getTime(ReferenceCountedOpenSslEngine.this.ssl) * 1000;
            }
        }

        @Override // javax.net.ssl.SSLSession
        public void putValue(String str, Object obj) {
            Object put;
            if (str == null) {
                throw new NullPointerException("name");
            }
            if (obj != null) {
                synchronized (this) {
                    Map map = this.values;
                    if (map == null) {
                        map = new HashMap(2);
                        this.values = map;
                    }
                    put = map.put(str, obj);
                }
                if (obj instanceof SSLSessionBindingListener) {
                    ((SSLSessionBindingListener) obj).valueBound(newSSLSessionBindingEvent(str));
                }
                notifyUnbound(put, str);
                return;
            }
            throw new NullPointerException("value");
        }

        @Override // javax.net.ssl.SSLSession
        public void removeValue(String str) {
            if (str != null) {
                synchronized (this) {
                    Map<String, Object> map = this.values;
                    if (map == null) {
                        return;
                    }
                    notifyUnbound(map.remove(str), str);
                    return;
                }
            }
            throw new NullPointerException("name");
        }

        @Override // io.netty.handler.ssl.OpenSslSession
        public void tryExpandApplicationBufferSize(int i4) {
            if (i4 <= ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH || this.applicationBufferSize == ReferenceCountedOpenSslEngine.MAX_RECORD_SIZE) {
                return;
            }
            this.applicationBufferSize = ReferenceCountedOpenSslEngine.MAX_RECORD_SIZE;
        }

        private String selectApplicationProtocol(List<String> list, ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior, String str) throws SSLException {
            if (selectedListenerFailureBehavior == ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT) {
                return str;
            }
            int size = list.size();
            if (list.contains(str)) {
                return str;
            }
            if (selectedListenerFailureBehavior == ApplicationProtocolConfig.SelectedListenerFailureBehavior.CHOOSE_MY_LAST_PROTOCOL) {
                return list.get(size - 1);
            }
            throw new SSLException("unknown protocol " + str);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private final class OpenSslSession implements SSLSession, ApplicationProtocolAccessor {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private String applicationProtocol;
        private String cipher;
        private long creationTime;
        private byte[] id;
        private Certificate[] peerCerts;
        private String protocol;
        private final OpenSslSessionContext sessionContext;
        private Map<String, Object> values;
        private X509Certificate[] x509PeerCerts;

        OpenSslSession(OpenSslSessionContext openSslSessionContext) {
            this.sessionContext = openSslSessionContext;
        }

        private void initPeerCerts() {
            Certificate[] certificateArr;
            int i4;
            byte[][] peerCertChain = org.apache.tomcat.jni.SSL.getPeerCertChain(ReferenceCountedOpenSslEngine.this.sniHostNames);
            byte[] peerCertificate = !ReferenceCountedOpenSslEngine.access$600(ReferenceCountedOpenSslEngine.this) ? org.apache.tomcat.jni.SSL.getPeerCertificate(ReferenceCountedOpenSslEngine.this.sniHostNames) : null;
            if (peerCertChain == null && peerCertificate == null) {
                this.peerCerts = ReferenceCountedOpenSslEngine.access$700();
                this.x509PeerCerts = ReferenceCountedOpenSslEngine.access$800();
                return;
            }
            int length = peerCertChain != null ? peerCertChain.length : 0;
            if (peerCertificate != null) {
                certificateArr = new Certificate[length + 1];
                certificateArr[0] = new OpenSslX509Certificate(peerCertificate);
                i4 = 1;
            } else {
                certificateArr = new Certificate[length];
                i4 = 0;
            }
            if (peerCertChain != null) {
                int length2 = peerCertChain.length;
                X509Certificate[] x509CertificateArr = new X509Certificate[length2];
                for (int i5 = 0; i5 < length2; i5++) {
                    byte[] bArr = peerCertChain[i5];
                    x509CertificateArr[i5] = new OpenSslJavaxX509Certificate(bArr);
                    certificateArr[i4] = new OpenSslX509Certificate(bArr);
                    i4++;
                }
                this.x509PeerCerts = x509CertificateArr;
            } else {
                this.x509PeerCerts = ReferenceCountedOpenSslEngine.access$800();
            }
            this.peerCerts = certificateArr;
        }

        private void notifyUnbound(Object obj, String str) {
            if (obj instanceof SSLSessionBindingListener) {
                ((SSLSessionBindingListener) obj).valueUnbound(new SSLSessionBindingEvent(this, str));
            }
        }

        private void selectApplicationProtocol() throws SSLException {
            ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior = ReferenceCountedOpenSslEngine.access$900(ReferenceCountedOpenSslEngine.this).selectedListenerFailureBehavior();
            List<String> protocols = ReferenceCountedOpenSslEngine.access$900(ReferenceCountedOpenSslEngine.this).protocols();
            int i4 = AnonymousClass2.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ReferenceCountedOpenSslEngine.access$900(ReferenceCountedOpenSslEngine.this).protocol().ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    String alpnSelected = org.apache.tomcat.jni.SSL.getAlpnSelected(ReferenceCountedOpenSslEngine.this.sniHostNames);
                    if (alpnSelected != null) {
                        this.applicationProtocol = selectApplicationProtocol(protocols, selectedListenerFailureBehavior, alpnSelected);
                    }
                } else if (i4 == 3) {
                    String nextProtoNegotiated = org.apache.tomcat.jni.SSL.getNextProtoNegotiated(ReferenceCountedOpenSslEngine.this.sniHostNames);
                    if (nextProtoNegotiated != null) {
                        this.applicationProtocol = selectApplicationProtocol(protocols, selectedListenerFailureBehavior, nextProtoNegotiated);
                    }
                } else if (i4 == 4) {
                    String alpnSelected2 = org.apache.tomcat.jni.SSL.getAlpnSelected(ReferenceCountedOpenSslEngine.this.sniHostNames);
                    if (alpnSelected2 == null) {
                        alpnSelected2 = org.apache.tomcat.jni.SSL.getNextProtoNegotiated(ReferenceCountedOpenSslEngine.this.sniHostNames);
                    }
                    if (alpnSelected2 != null) {
                        this.applicationProtocol = selectApplicationProtocol(protocols, selectedListenerFailureBehavior, alpnSelected2);
                    }
                } else {
                    throw new Error();
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public int getApplicationBufferSize() {
            return 16384;
        }

        @Override // io.netty.handler.ssl.ApplicationProtocolAccessor
        public String getApplicationProtocol() {
            String str;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                str = this.applicationProtocol;
            }
            return str;
        }

        @Override // javax.net.ssl.SSLSession
        public String getCipherSuite() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                String str = this.cipher;
                return str == null ? ReferenceCountedOpenSslEngine.INVALID_CIPHER : str;
            }
        }

        @Override // javax.net.ssl.SSLSession
        public long getCreationTime() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (this.creationTime == 0 && !ReferenceCountedOpenSslEngine.this.clientMode) {
                    this.creationTime = org.apache.tomcat.jni.SSL.getTime(ReferenceCountedOpenSslEngine.this.sniHostNames) * 1000;
                }
            }
            return this.creationTime;
        }

        @Override // javax.net.ssl.SSLSession
        public byte[] getId() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                byte[] bArr = this.id;
                if (bArr == null) {
                    return EmptyArrays.EMPTY_BYTES;
                }
                return (byte[]) bArr.clone();
            }
        }

        @Override // javax.net.ssl.SSLSession
        public long getLastAccessedTime() {
            long isDestroyed = ReferenceCountedOpenSslEngine.this.isDestroyed();
            return isDestroyed == -1 ? getCreationTime() : isDestroyed;
        }

        @Override // javax.net.ssl.SSLSession
        public Certificate[] getLocalCertificates() {
            if (ReferenceCountedOpenSslEngine.this.calculateMaxWrapOverhead() == null) {
                return null;
            }
            return (Certificate[]) ReferenceCountedOpenSslEngine.this.calculateMaxWrapOverhead().clone();
        }

        @Override // javax.net.ssl.SSLSession
        public Principal getLocalPrincipal() {
            Certificate[] calculateMaxWrapOverhead = ReferenceCountedOpenSslEngine.this.calculateMaxWrapOverhead();
            if (calculateMaxWrapOverhead == null || calculateMaxWrapOverhead.length == 0) {
                return null;
            }
            return ((java.security.cert.X509Certificate) calculateMaxWrapOverhead[0]).getIssuerX500Principal();
        }

        @Override // javax.net.ssl.SSLSession
        public int getPacketBufferSize() {
            return ReferenceCountedOpenSslEngine.MAX_ENCRYPTED_PACKET_LENGTH;
        }

        @Override // javax.net.ssl.SSLSession
        public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
            X509Certificate[] x509CertificateArr;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                x509CertificateArr = this.x509PeerCerts;
                if (x509CertificateArr == null || x509CertificateArr.length == 0) {
                    throw new SSLPeerUnverifiedException("peer not verified");
                }
            }
            return x509CertificateArr;
        }

        @Override // javax.net.ssl.SSLSession
        public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
            Certificate[] certificateArr;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                certificateArr = this.peerCerts;
                if (certificateArr == null || certificateArr.length == 0) {
                    throw new SSLPeerUnverifiedException("peer not verified");
                }
            }
            return certificateArr;
        }

        @Override // javax.net.ssl.SSLSession
        public String getPeerHost() {
            return ReferenceCountedOpenSslEngine.this.getPeerHost();
        }

        @Override // javax.net.ssl.SSLSession
        public int getPeerPort() {
            return ReferenceCountedOpenSslEngine.this.getPeerPort();
        }

        @Override // javax.net.ssl.SSLSession
        public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
            return ((java.security.cert.X509Certificate) getPeerCertificates()[0]).getSubjectX500Principal();
        }

        @Override // javax.net.ssl.SSLSession
        public String getProtocol() {
            String str = this.protocol;
            if (str == null) {
                synchronized (ReferenceCountedOpenSslEngine.this) {
                    str = !ReferenceCountedOpenSslEngine.this.clientMode ? org.apache.tomcat.jni.SSL.getVersion(ReferenceCountedOpenSslEngine.this.sniHostNames) : "";
                }
            }
            return str;
        }

        @Override // javax.net.ssl.SSLSession
        public SSLSessionContext getSessionContext() {
            return this.sessionContext;
        }

        @Override // javax.net.ssl.SSLSession
        public Object getValue(String str) {
            if (str != null) {
                Map<String, Object> map = this.values;
                if (map == null) {
                    return null;
                }
                return map.get(str);
            }
            throw new NullPointerException("name");
        }

        @Override // javax.net.ssl.SSLSession
        public String[] getValueNames() {
            Map<String, Object> map = this.values;
            if (map != null && !map.isEmpty()) {
                return (String[]) map.keySet().toArray(new String[map.size()]);
            }
            return EmptyArrays.EMPTY_STRINGS;
        }

        void handshakeFinished() throws SSLException {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (!ReferenceCountedOpenSslEngine.this.clientMode) {
                    this.id = org.apache.tomcat.jni.SSL.getSessionId(ReferenceCountedOpenSslEngine.this.sniHostNames);
                    ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = ReferenceCountedOpenSslEngine.this;
                    this.cipher = ReferenceCountedOpenSslEngine.access$400(referenceCountedOpenSslEngine, org.apache.tomcat.jni.SSL.getCipherForSSL(referenceCountedOpenSslEngine.sniHostNames));
                    this.protocol = org.apache.tomcat.jni.SSL.getVersion(ReferenceCountedOpenSslEngine.this.sniHostNames);
                    initPeerCerts();
                    selectApplicationProtocol();
                    ReferenceCountedOpenSslEngine.access$502(ReferenceCountedOpenSslEngine.this, HandshakeState.FINISHED);
                } else {
                    throw new SSLException("Already closed");
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public void invalidate() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (!ReferenceCountedOpenSslEngine.this.clientMode) {
                    org.apache.tomcat.jni.SSL.setTimeout(ReferenceCountedOpenSslEngine.this.sniHostNames, 0L);
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public boolean isValid() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                if (ReferenceCountedOpenSslEngine.this.clientMode) {
                    return false;
                }
                return System.currentTimeMillis() - (org.apache.tomcat.jni.SSL.getTimeout(ReferenceCountedOpenSslEngine.this.sniHostNames) * 1000) < org.apache.tomcat.jni.SSL.getTime(ReferenceCountedOpenSslEngine.this.sniHostNames) * 1000;
            }
        }

        @Override // javax.net.ssl.SSLSession
        public void putValue(String str, Object obj) {
            if (str == null) {
                throw new NullPointerException("name");
            }
            if (obj != null) {
                Map map = this.values;
                if (map == null) {
                    map = new HashMap(2);
                    this.values = map;
                }
                Object put = map.put(str, obj);
                if (obj instanceof SSLSessionBindingListener) {
                    ((SSLSessionBindingListener) obj).valueBound(new SSLSessionBindingEvent(this, str));
                }
                notifyUnbound(put, str);
                return;
            }
            throw new NullPointerException("value");
        }

        @Override // javax.net.ssl.SSLSession
        public void removeValue(String str) {
            if (str != null) {
                Map<String, Object> map = this.values;
                if (map == null) {
                    return;
                }
                notifyUnbound(map.remove(str), str);
                return;
            }
            throw new NullPointerException("name");
        }

        private String selectApplicationProtocol(List<String> list, ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior, String str) throws SSLException {
            if (selectedListenerFailureBehavior == ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT) {
                return str;
            }
            int size = list.size();
            if (list.contains(str)) {
                return str;
            }
            if (selectedListenerFailureBehavior == ApplicationProtocolConfig.SelectedListenerFailureBehavior.CHOOSE_MY_LAST_PROTOCOL) {
                return list.get(size - 1);
            }
            throw new SSLException("unknown protocol " + str);
        }
    }

    public final SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2) throws SSLException {
        return unwrap(byteBufferArr, 0, byteBufferArr.length, byteBufferArr2, 0, byteBufferArr2.length);
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i4, int i5) throws SSLException {
        SSLEngineResult unwrap;
        unwrap = unwrap(singleSrcBuffer(byteBuffer), 0, 1, byteBufferArr, i4, i5);
        resetSingleSrcBuffer();
        return unwrap;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        SSLEngineResult unwrap;
        unwrap = unwrap(singleSrcBuffer(byteBuffer), singleDstBuffer(byteBuffer2));
        resetSingleSrcBuffer();
        resetSingleDstBuffer();
        return unwrap;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) throws SSLException {
        SSLEngineResult unwrap;
        unwrap = unwrap(singleSrcBuffer(byteBuffer), byteBufferArr);
        resetSingleSrcBuffer();
        return unwrap;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        SSLEngineResult wrap;
        wrap = wrap(singleSrcBuffer(byteBuffer), byteBuffer2);
        resetSingleSrcBuffer();
        return wrap;
    }
}
