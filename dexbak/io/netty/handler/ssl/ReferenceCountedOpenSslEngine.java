package io.netty.handler.ssl;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeak;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
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
import org.apache.tomcat.jni.Buffer;
import org.apache.tomcat.jni.SSL;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ReferenceCountedOpenSslEngine extends SSLEngine implements ReferenceCounted {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final SSLEngineResult CLOSED_NOT_HANDSHAKING;
    private static final AtomicIntegerFieldUpdater<ReferenceCountedOpenSslEngine> DESTROYED_UPDATER;
    private static final long EMPTY_ADDR;
    private static final Method GET_ASCII_NAME_METHOD;
    private static final Method GET_SERVER_NAMES_METHOD;
    private static final Method GET_USE_CIPHER_SUITES_ORDER_METHOD;
    private static final String INVALID_CIPHER = "SSL_NULL_WITH_NULL_NULL";
    private static final int MAX_CIPHERTEXT_LENGTH = 18432;
    private static final int MAX_COMPRESSED_LENGTH = 17408;
    static final int MAX_ENCRYPTED_PACKET_LENGTH = 18713;
    static final int MAX_ENCRYPTION_OVERHEAD_LENGTH = 2329;
    private static final int MAX_PLAINTEXT_LENGTH = 16384;
    private static final SSLEngineResult NEED_UNWRAP_CLOSED;
    private static final SSLEngineResult NEED_UNWRAP_OK;
    private static final SSLEngineResult NEED_WRAP_CLOSED;
    private static final SSLEngineResult NEED_WRAP_OK;
    private static final Method SET_SERVER_NAMES_METHOD;
    private static final Method SET_USE_CIPHER_SUITES_ORDER_METHOD;
    private static final Class<?> SNI_HOSTNAME_CLASS;
    private Object algorithmConstraints;
    private final ByteBufAllocator alloc;
    private final OpenSslApplicationProtocolNegotiator apn;
    private boolean certificateSet;
    private volatile ClientAuth clientAuth;
    private final boolean clientMode;
    private volatile int destroyed;
    private String endPointIdentificationAlgorithm;
    private boolean engineClosed;
    private final OpenSslEngineMap engineMap;
    SSLHandshakeException handshakeException;
    private HandshakeState handshakeState;
    private boolean isInboundDone;
    private boolean isOutboundDone;
    private final OpenSslKeyMaterialManager keyMaterialManager;
    private volatile long lastAccessed;
    private final ResourceLeak leak;
    private final Certificate[] localCerts;
    private long networkBIO;
    private boolean receivedShutdown;
    private final AbstractReferenceCounted refCnt;
    private final boolean rejectRemoteInitiatedRenegation;
    private final OpenSslSession session;
    private final ByteBuffer[] singleDstBuffer;
    private final ByteBuffer[] singleSrcBuffer;
    private List<?> sniHostNames;
    private long ssl;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ReferenceCountedOpenSslEngine.class);
    private static final Certificate[] EMPTY_CERTIFICATES = EmptyArrays.EMPTY_CERTIFICATES;
    private static final X509Certificate[] EMPTY_X509_CERTIFICATES = EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
    private static final SSLException BEGIN_HANDSHAKE_ENGINE_CLOSED = (SSLException) ThrowableUtil.unknownStackTrace(new SSLException("engine closed"), ReferenceCountedOpenSslEngine.class, "beginHandshake()");
    private static final SSLException HANDSHAKE_ENGINE_CLOSED = (SSLException) ThrowableUtil.unknownStackTrace(new SSLException("engine closed"), ReferenceCountedOpenSslEngine.class, "handshake()");
    private static final SSLException RENEGOTIATION_UNSUPPORTED = (SSLException) ThrowableUtil.unknownStackTrace(new SSLException("renegotiation unsupported"), ReferenceCountedOpenSslEngine.class, "beginHandshake()");
    private static final SSLException ENCRYPTED_PACKET_OVERSIZED = (SSLException) ThrowableUtil.unknownStackTrace(new SSLException("encrypted packet oversized"), ReferenceCountedOpenSslEngine.class, "unwrap(...)");
    private static final ResourceLeakDetector<ReferenceCountedOpenSslEngine> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ReferenceCountedOpenSslEngine.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslEngine$2 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C139462 {

        /* renamed from: $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol */
        static final /* synthetic */ int[] f40279xc16482e4;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ClientAuth;

        /* renamed from: $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState */
        static final /* synthetic */ int[] f40280xea902ccf;

        static {
            int[] iArr = new int[ApplicationProtocolConfig.Protocol.values().length];
            f40279xc16482e4 = iArr;
            try {
                iArr[ApplicationProtocolConfig.Protocol.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40279xc16482e4[ApplicationProtocolConfig.Protocol.ALPN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40279xc16482e4[ApplicationProtocolConfig.Protocol.NPN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40279xc16482e4[ApplicationProtocolConfig.Protocol.NPN_AND_ALPN.ordinal()] = 4;
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
            f40280xea902ccf = iArr3;
            try {
                iArr3[HandshakeState.NOT_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f40280xea902ccf[HandshakeState.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f40280xea902ccf[HandshakeState.STARTED_IMPLICITLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f40280xea902ccf[HandshakeState.STARTED_EXPLICITLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum HandshakeState {
        NOT_STARTED,
        STARTED_IMPLICITLY,
        STARTED_EXPLICITLY,
        FINISHED
    }

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        AtomicIntegerFieldUpdater<ReferenceCountedOpenSslEngine> newAtomicIntegerFieldUpdater = PlatformDependent.newAtomicIntegerFieldUpdater(ReferenceCountedOpenSslEngine.class, "destroyed");
        if (newAtomicIntegerFieldUpdater == null) {
            newAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(ReferenceCountedOpenSslEngine.class, "destroyed");
        }
        DESTROYED_UPDATER = newAtomicIntegerFieldUpdater;
        Method method6 = null;
        if (PlatformDependent.javaVersion() >= 8) {
            try {
                method5 = SSLParameters.class.getDeclaredMethod("getUseCipherSuitesOrder", new Class[0]);
                SSLParameters sSLParameters = new SSLParameters();
                Boolean bool = (Boolean) method5.invoke(sSLParameters, new Object[0]);
                method = SSLParameters.class.getDeclaredMethod("setUseCipherSuitesOrder", Boolean.TYPE);
                method.invoke(sSLParameters, Boolean.TRUE);
            } catch (Throwable unused) {
                method5 = null;
                method = null;
            }
            try {
                cls = Class.forName("javax.net.ssl.SNIHostName", false, PlatformDependent.getClassLoader(ReferenceCountedOpenSslEngine.class));
                Object newInstance = cls.getConstructor(String.class).newInstance("netty.io");
                method3 = cls.getDeclaredMethod("getAsciiName", new Class[0]);
                String str = (String) method3.invoke(newInstance, new Object[0]);
                method2 = SSLParameters.class.getDeclaredMethod("getServerNames", new Class[0]);
                method4 = SSLParameters.class.getDeclaredMethod("setServerNames", List.class);
                SSLParameters sSLParameters2 = new SSLParameters();
                List list = (List) method2.invoke(sSLParameters2, new Object[0]);
                method4.invoke(sSLParameters2, Collections.emptyList());
            } catch (Throwable unused2) {
                cls = null;
                method2 = null;
                method3 = null;
                method4 = null;
            }
            method6 = method5;
        } else {
            cls = null;
            method = null;
            method2 = null;
            method3 = null;
            method4 = null;
        }
        GET_USE_CIPHER_SUITES_ORDER_METHOD = method6;
        SET_USE_CIPHER_SUITES_ORDER_METHOD = method;
        SNI_HOSTNAME_CLASS = cls;
        GET_ASCII_NAME_METHOD = method3;
        GET_SERVER_NAMES_METHOD = method2;
        SET_SERVER_NAMES_METHOD = method4;
        EMPTY_ADDR = Buffer.address(Unpooled.EMPTY_BUFFER.nioBuffer());
        NEED_UNWRAP_OK = new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
        NEED_UNWRAP_CLOSED = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
        NEED_WRAP_OK = new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, 0);
        NEED_WRAP_CLOSED = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, 0);
        CLOSED_NOT_HANDSHAKING = new SSLEngineResult(SSLEngineResult.Status.CLOSED, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReferenceCountedOpenSslEngine(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, ByteBufAllocator byteBufAllocator, String str, int i, boolean z) {
        super(str, i);
        this.handshakeState = HandshakeState.NOT_STARTED;
        this.refCnt = new AbstractReferenceCounted() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.1
            @Override // io.netty.util.AbstractReferenceCounted
            protected void deallocate() {
                ReferenceCountedOpenSslEngine.this.shutdown();
                if (ReferenceCountedOpenSslEngine.this.leak != null) {
                    ReferenceCountedOpenSslEngine.this.leak.close();
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
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        OpenSsl.ensureAvailability();
        this.leak = z ? leakDetector.open(this) : null;
        this.alloc = (ByteBufAllocator) ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        this.apn = (OpenSslApplicationProtocolNegotiator) referenceCountedOpenSslContext.applicationProtocolNegotiator();
        this.ssl = SSL.newSSL(referenceCountedOpenSslContext.ctx, !referenceCountedOpenSslContext.isClient());
        this.session = new OpenSslSession(referenceCountedOpenSslContext.sessionContext());
        this.networkBIO = SSL.makeNetworkBIO(this.ssl);
        boolean isClient = referenceCountedOpenSslContext.isClient();
        this.clientMode = isClient;
        this.engineMap = referenceCountedOpenSslContext.engineMap;
        this.rejectRemoteInitiatedRenegation = referenceCountedOpenSslContext.rejectRemoteInitiatedRenegotiation;
        this.localCerts = referenceCountedOpenSslContext.keyCertChain;
        setClientAuth(isClient ? clientAuth : referenceCountedOpenSslContext.clientAuth);
        if (isClient && str != null) {
            SSL.setTlsExtHostName(this.ssl, str);
        }
        this.keyMaterialManager = referenceCountedOpenSslContext.keyMaterialManager();
    }

    private void checkEngineClosed(SSLException sSLException) throws SSLException {
        if (this.engineClosed || isDestroyed()) {
            throw sSLException;
        }
    }

    private void closeAll() throws SSLException {
        this.receivedShutdown = true;
        closeOutbound();
        closeInbound();
    }

    private SSLEngineResult.Status getEngineStatus() {
        return this.engineClosed ? SSLEngineResult.Status.CLOSED : SSLEngineResult.Status.OK;
    }

    private SSLEngineResult.HandshakeStatus handshake() throws SSLException {
        OpenSslKeyMaterialManager openSslKeyMaterialManager;
        if (this.handshakeState == HandshakeState.FINISHED) {
            return SSLEngineResult.HandshakeStatus.FINISHED;
        }
        checkEngineClosed(HANDSHAKE_ENGINE_CLOSED);
        SSLHandshakeException sSLHandshakeException = this.handshakeException;
        if (sSLHandshakeException != null) {
            if (SSL.pendingWrittenBytesInBIO(this.networkBIO) > 0) {
                return SSLEngineResult.HandshakeStatus.NEED_WRAP;
            }
            this.handshakeException = null;
            shutdown();
            throw sSLHandshakeException;
        }
        this.engineMap.add(this);
        if (this.lastAccessed == -1) {
            this.lastAccessed = System.currentTimeMillis();
        }
        if (!this.certificateSet && (openSslKeyMaterialManager = this.keyMaterialManager) != null) {
            this.certificateSet = true;
            openSslKeyMaterialManager.setKeyMaterial(this);
        }
        int doHandshake = SSL.doHandshake(this.ssl);
        if (doHandshake <= 0) {
            SSLHandshakeException sSLHandshakeException2 = this.handshakeException;
            if (sSLHandshakeException2 == null) {
                int error = SSL.getError(this.ssl, doHandshake);
                if (error != 2 && error != 3) {
                    throw shutdownWithError("SSL_do_handshake");
                }
                return pendingStatus(SSL.pendingWrittenBytesInBIO(this.networkBIO));
            }
            this.handshakeException = null;
            shutdown();
            throw sSLHandshakeException2;
        }
        this.session.handshakeFinished();
        this.engineMap.remove(this.ssl);
        return SSLEngineResult.HandshakeStatus.FINISHED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDestroyed() {
        return this.destroyed != 0;
    }

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        return (handshakeStatus != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING || this.handshakeState == HandshakeState.FINISHED) ? handshakeStatus : handshake();
    }

    private boolean needPendingStatus() {
        return (this.handshakeState == HandshakeState.NOT_STARTED || isDestroyed() || (this.handshakeState == HandshakeState.FINISHED && !this.engineClosed)) ? false : true;
    }

    private SSLEngineResult newResult(int i, int i2, SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        SSLEngineResult.Status engineStatus = getEngineStatus();
        if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
            handshakeStatus = getHandshakeStatus();
        }
        return new SSLEngineResult(engineStatus, mayFinishHandshake(handshakeStatus), i, i2);
    }

    private int pendingAppData() {
        if (this.handshakeState == HandshakeState.FINISHED) {
            return SSL.pendingReadableBytesInSSL(this.ssl);
        }
        return 0;
    }

    private static SSLEngineResult.HandshakeStatus pendingStatus(int i) {
        return i > 0 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
    }

    private int readEncryptedData(ByteBuffer byteBuffer, int i) {
        int readFromBIO;
        if (byteBuffer.isDirect() && byteBuffer.remaining() >= i) {
            int position = byteBuffer.position();
            readFromBIO = SSL.readFromBIO(this.networkBIO, Buffer.address(byteBuffer) + position, i);
            if (readFromBIO > 0) {
                byteBuffer.position(position + readFromBIO);
                return readFromBIO;
            }
        } else {
            ByteBuf directBuffer = this.alloc.directBuffer(i);
            try {
                readFromBIO = SSL.readFromBIO(this.networkBIO, OpenSsl.memoryAddress(directBuffer), i);
                if (readFromBIO > 0) {
                    int limit = byteBuffer.limit();
                    byteBuffer.limit(byteBuffer.position() + readFromBIO);
                    directBuffer.getBytes(0, byteBuffer);
                    byteBuffer.limit(limit);
                    return readFromBIO;
                }
            } finally {
                directBuffer.release();
            }
        }
        return readFromBIO;
    }

    private SSLEngineResult readPendingBytesFromBIO(ByteBuffer byteBuffer, int i, int i2, SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        int pendingWrittenBytesInBIO = SSL.pendingWrittenBytesInBIO(this.networkBIO);
        if (pendingWrittenBytesInBIO > 0) {
            if (byteBuffer.remaining() < pendingWrittenBytesInBIO) {
                SSLEngineResult.Status status = SSLEngineResult.Status.BUFFER_OVERFLOW;
                if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
                    handshakeStatus = getHandshakeStatus(pendingWrittenBytesInBIO);
                }
                return new SSLEngineResult(status, mayFinishHandshake(handshakeStatus), i, i2);
            }
            int readEncryptedData = readEncryptedData(byteBuffer, pendingWrittenBytesInBIO);
            if (readEncryptedData <= 0) {
                SSL.clearError();
            } else {
                i2 += readEncryptedData;
                pendingWrittenBytesInBIO -= readEncryptedData;
            }
            if (this.isOutboundDone) {
                shutdown();
            }
            SSLEngineResult.Status engineStatus = getEngineStatus();
            if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
                handshakeStatus = getHandshakeStatus(pendingWrittenBytesInBIO);
            }
            return new SSLEngineResult(engineStatus, mayFinishHandshake(handshakeStatus), i, i2);
        }
        return null;
    }

    private int readPlaintextData(ByteBuffer byteBuffer) {
        if (byteBuffer.isDirect()) {
            int position = byteBuffer.position();
            int readFromSSL = SSL.readFromSSL(this.ssl, Buffer.address(byteBuffer) + position, byteBuffer.limit() - position);
            if (readFromSSL > 0) {
                byteBuffer.position(position + readFromSSL);
                return readFromSSL;
            }
            return readFromSSL;
        }
        int position2 = byteBuffer.position();
        int limit = byteBuffer.limit();
        int min = Math.min((int) MAX_ENCRYPTED_PACKET_LENGTH, limit - position2);
        ByteBuf directBuffer = this.alloc.directBuffer(min);
        try {
            int readFromSSL2 = SSL.readFromSSL(this.ssl, OpenSsl.memoryAddress(directBuffer), min);
            if (readFromSSL2 > 0) {
                byteBuffer.limit(position2 + readFromSSL2);
                directBuffer.getBytes(0, byteBuffer);
                byteBuffer.limit(limit);
            }
            return readFromSSL2;
        } finally {
            directBuffer.release();
        }
    }

    private void rejectRemoteInitiatedRenegation() throws SSLHandshakeException {
        if (!this.rejectRemoteInitiatedRenegation || SSL.getHandshakeCount(this.ssl) <= 1) {
            return;
        }
        shutdown();
        throw new SSLHandshakeException("remote-initiated renegotation not allowed");
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
            int i = C139462.$SwitchMap$io$netty$handler$ssl$ClientAuth[clientAuth.ordinal()];
            if (i == 1) {
                SSL.setVerify(this.ssl, 0, 10);
            } else if (i == 2) {
                SSL.setVerify(this.ssl, 2, 10);
            } else if (i == 3) {
                SSL.setVerify(this.ssl, 1, 10);
            } else {
                throw new Error(clientAuth.toString());
            }
            this.clientAuth = clientAuth;
        }
    }

    private SSLException shutdownWithError(String str) {
        return shutdownWithError(str, SSL.getLastError());
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

    private SSLEngineResult sslReadErrorResult(int i, int i2, int i3) throws SSLException {
        String errorString = SSL.getErrorString(i);
        if (SSL.pendingWrittenBytesInBIO(this.networkBIO) > 0) {
            if (this.handshakeException == null && this.handshakeState != HandshakeState.FINISHED) {
                this.handshakeException = new SSLHandshakeException(errorString);
            }
            return new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, i2, i3);
        }
        throw shutdownWithError("SSL_read", errorString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String toJavaCipherSuite(String str) {
        if (str == null) {
            return null;
        }
        return CipherSuiteConverter.toJava(str, toJavaCipherSuitePrefix(SSL.getVersion(this.ssl)));
    }

    private static String toJavaCipherSuitePrefix(String str) {
        char c = 0;
        if (str != null && str.length() != 0) {
            c = str.charAt(0);
        }
        return c != 'S' ? c != 'T' ? Constants.APP_VERSION_UNKNOWN : "TLS" : "SSL";
    }

    private int writeEncryptedData(ByteBuffer byteBuffer) {
        int writeToBIO;
        int position = byteBuffer.position();
        int remaining = byteBuffer.remaining();
        if (byteBuffer.isDirect()) {
            writeToBIO = SSL.writeToBIO(this.networkBIO, Buffer.address(byteBuffer) + position, remaining);
            if (writeToBIO >= 0) {
                byteBuffer.position(position + writeToBIO);
            }
        } else {
            ByteBuf directBuffer = this.alloc.directBuffer(remaining);
            try {
                long memoryAddress = OpenSsl.memoryAddress(directBuffer);
                directBuffer.setBytes(0, byteBuffer);
                writeToBIO = SSL.writeToBIO(this.networkBIO, memoryAddress, remaining);
                if (writeToBIO >= 0) {
                    byteBuffer.position(position + writeToBIO);
                } else {
                    byteBuffer.position(position);
                }
            } finally {
                directBuffer.release();
            }
        }
        return writeToBIO;
    }

    private int writePlaintextData(ByteBuffer byteBuffer) {
        int writeToSSL;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int min = Math.min(limit - position, 16384);
        if (byteBuffer.isDirect()) {
            writeToSSL = SSL.writeToSSL(this.ssl, Buffer.address(byteBuffer) + position, min);
            if (writeToSSL > 0) {
                byteBuffer.position(position + writeToSSL);
            }
        } else {
            ByteBuf directBuffer = this.alloc.directBuffer(min);
            try {
                long memoryAddress = OpenSsl.memoryAddress(directBuffer);
                byteBuffer.limit(position + min);
                directBuffer.setBytes(0, byteBuffer);
                byteBuffer.limit(limit);
                writeToSSL = SSL.writeToSSL(this.ssl, memoryAddress, min);
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
        int i = C139462.f40280xea902ccf[this.handshakeState.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    checkEngineClosed(BEGIN_HANDSHAKE_ENGINE_CLOSED);
                    this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
                } else if (i != 4) {
                    throw new Error();
                }
            } else if (!this.clientMode) {
                if (SSL.renegotiate(this.ssl) == 1 && SSL.doHandshake(this.ssl) == 1) {
                    SSL.setState(this.ssl, 8192);
                    this.lastAccessed = System.currentTimeMillis();
                } else {
                    throw shutdownWithError("renegotiation failed");
                }
            } else {
                throw RENEGOTIATION_UNSUPPORTED;
            }
        }
        this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
        handshake();
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void closeInbound() throws SSLException {
        if (this.isInboundDone) {
            return;
        }
        this.isInboundDone = true;
        this.engineClosed = true;
        shutdown();
        if (this.handshakeState != HandshakeState.NOT_STARTED && !this.receivedShutdown) {
            throw new SSLException("Inbound closed before receiving peer's close_notify: possible truncation attack?");
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void closeOutbound() {
        int shutdownSSL;
        if (this.isOutboundDone) {
            return;
        }
        this.isOutboundDone = true;
        this.engineClosed = true;
        if (this.handshakeState != HandshakeState.NOT_STARTED && !isDestroyed()) {
            if ((SSL.getShutdown(this.ssl) & 1) != 1 && (shutdownSSL = SSL.shutdownSSL(this.ssl)) < 0) {
                switch (SSL.getError(this.ssl, shutdownSSL)) {
                    case 0:
                    case 2:
                    case 3:
                    case 4:
                    case 6:
                    case 7:
                    case 8:
                        break;
                    case 1:
                    case 5:
                        InternalLogger internalLogger = logger;
                        if (internalLogger.isDebugEnabled()) {
                            internalLogger.debug("SSL_shutdown failed: OpenSSL error: {}", SSL.getLastError());
                        }
                        shutdown();
                        break;
                    default:
                        SSL.clearError();
                        break;
                }
            }
        } else {
            shutdown();
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final Runnable getDelegatedTask() {
        return null;
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
                synchronized (this) {
                    for (int i = 0; i < ciphers.length; i++) {
                        String javaCipherSuite = toJavaCipherSuite(ciphers[i]);
                        if (javaCipherSuite != null) {
                            ciphers[i] = javaCipherSuite;
                        }
                    }
                }
                return ciphers;
            }
            return EmptyArrays.EMPTY_STRINGS;
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getEnabledProtocols() {
        ArrayList arrayList = InternalThreadLocalMap.get().arrayList();
        arrayList.add("SSLv2Hello");
        synchronized (this) {
            if (!isDestroyed()) {
                int options = SSL.getOptions(this.ssl);
                if ((67108864 & options) == 0) {
                    arrayList.add("TLSv1");
                }
                if ((268435456 & options) == 0) {
                    arrayList.add("TLSv1.1");
                }
                if ((134217728 & options) == 0) {
                    arrayList.add("TLSv1.2");
                }
                if ((16777216 & options) == 0) {
                    arrayList.add("SSLv2");
                }
                if ((options & CommonNetImpl.FLAG_SHARE_JUMP) == 0) {
                    arrayList.add("SSLv3");
                }
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            return (String[]) arrayList.toArray(new String[1]);
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLSession getHandshakeSession() {
        int i = C139462.f40280xea902ccf[this.handshakeState.ordinal()];
        if (i == 1 || i == 2) {
            return null;
        }
        return this.session;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        return needPendingStatus() ? pendingStatus(SSL.pendingWrittenBytesInBIO(this.networkBIO)) : SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getNeedClientAuth() {
        return this.clientAuth == ClientAuth.REQUIRE;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLParameters getSSLParameters() {
        SSLParameters sSLParameters;
        List<?> list;
        sSLParameters = super.getSSLParameters();
        int javaVersion = PlatformDependent.javaVersion();
        if (javaVersion >= 7) {
            sSLParameters.setEndpointIdentificationAlgorithm(this.endPointIdentificationAlgorithm);
            SslParametersUtils.setAlgorithmConstraints(sSLParameters, this.algorithmConstraints);
            if (javaVersion >= 8) {
                Method method = SET_SERVER_NAMES_METHOD;
                boolean z = true;
                if (method != null && (list = this.sniHostNames) != null) {
                    try {
                        method.invoke(sSLParameters, list);
                    } catch (IllegalAccessException e) {
                        throw new Error(e);
                    } catch (InvocationTargetException e2) {
                        throw new Error(e2);
                    }
                }
                Method method2 = SET_USE_CIPHER_SUITES_ORDER_METHOD;
                if (method2 != null && !isDestroyed()) {
                    try {
                        Object[] objArr = new Object[1];
                        if ((SSL.getOptions(this.ssl) & 4194304) == 0) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        method2.invoke(sSLParameters, objArr);
                    } catch (IllegalAccessException e3) {
                        throw new Error(e3);
                    } catch (InvocationTargetException e4) {
                        throw new Error(e4);
                    }
                }
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
        Set<String> set = OpenSsl.AVAILABLE_CIPHER_SUITES;
        return (String[]) set.toArray(new String[set.size()]);
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getSupportedProtocols() {
        Set<String> set = OpenSsl.SUPPORTED_PROTOCOLS_SET;
        return (String[]) set.toArray(new String[set.size()]);
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getUseClientMode() {
        return this.clientMode;
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getWantClientAuth() {
        return this.clientAuth == ClientAuth.OPTIONAL;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized boolean isInboundDone() {
        boolean z;
        if (!this.isInboundDone) {
            z = this.engineClosed;
        }
        return z;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized boolean isOutboundDone() {
        return this.isOutboundDone;
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
    public final void setEnableSessionCreation(boolean z) {
        if (z) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setEnabledCipherSuites(String[] strArr) {
        ObjectUtil.checkNotNull(strArr, "cipherSuites");
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if (str == null) {
                break;
            }
            String openSsl = CipherSuiteConverter.toOpenSsl(str);
            if (openSsl == null) {
                openSsl = str;
            }
            if (OpenSsl.isCipherSuiteAvailable(openSsl)) {
                sb.append(openSsl);
                sb.append(':');
            } else {
                throw new IllegalArgumentException("unsupported cipher suite: " + str + '(' + openSsl + ')');
            }
        }
        if (sb.length() != 0) {
            sb.setLength(sb.length() - 1);
            String sb2 = sb.toString();
            synchronized (this) {
                if (!isDestroyed()) {
                    try {
                        SSL.setCipherSuites(this.ssl, sb2);
                    } catch (Exception e) {
                        throw new IllegalStateException("failed to enable cipher suites: " + sb2, e);
                    }
                } else {
                    throw new IllegalStateException("failed to enable cipher suites: " + sb2);
                }
            }
            return;
        }
        throw new IllegalArgumentException("empty cipher suites");
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setEnabledProtocols(String[] strArr) {
        if (strArr != null) {
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            for (String str : strArr) {
                if (OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(str)) {
                    if (str.equals("SSLv2")) {
                        z = true;
                    } else if (str.equals("SSLv3")) {
                        z2 = true;
                    } else if (str.equals("TLSv1")) {
                        z3 = true;
                    } else if (str.equals("TLSv1.1")) {
                        z4 = true;
                    } else if (str.equals("TLSv1.2")) {
                        z5 = true;
                    }
                } else {
                    throw new IllegalArgumentException("Protocol " + str + " is not supported.");
                }
            }
            synchronized (this) {
                if (!isDestroyed()) {
                    SSL.setOptions(this.ssl, 4095);
                    SSL.clearOptions(this.ssl, 520093696);
                    int i = z ? 0 : 16777216;
                    if (!z2) {
                        i |= CommonNetImpl.FLAG_SHARE_JUMP;
                    }
                    if (!z3) {
                        i |= 67108864;
                    }
                    if (!z4) {
                        i |= 268435456;
                    }
                    if (!z5) {
                        i |= AMapEngineUtils.HALF_MAX_P20_WIDTH;
                    }
                    SSL.setOptions(this.ssl, i);
                } else {
                    throw new IllegalStateException("failed to enable protocols: " + Arrays.asList(strArr));
                }
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setNeedClientAuth(boolean z) {
        setClientAuth(z ? ClientAuth.REQUIRE : ClientAuth.NONE);
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void setSSLParameters(SSLParameters sSLParameters) {
        super.setSSLParameters(sSLParameters);
        int javaVersion = PlatformDependent.javaVersion();
        if (javaVersion >= 7) {
            this.endPointIdentificationAlgorithm = sSLParameters.getEndpointIdentificationAlgorithm();
            this.algorithmConstraints = sSLParameters.getAlgorithmConstraints();
            if (javaVersion >= 8) {
                if (SNI_HOSTNAME_CLASS != null && this.clientMode && !isDestroyed()) {
                    try {
                        try {
                            List<?> list = (List) GET_SERVER_NAMES_METHOD.invoke(sSLParameters, new Object[0]);
                            if (list != null) {
                                for (Object obj : list) {
                                    Class<?> cls = SNI_HOSTNAME_CLASS;
                                    if (cls.isInstance(obj)) {
                                        SSL.setTlsExtHostName(this.ssl, (String) GET_ASCII_NAME_METHOD.invoke(obj, new Object[0]));
                                    } else {
                                        throw new IllegalArgumentException("Only " + cls.getName() + " instances are supported, but found: " + obj);
                                    }
                                }
                            }
                            this.sniHostNames = list;
                        } catch (IllegalAccessException e) {
                            throw new Error(e);
                        }
                    } catch (InvocationTargetException e2) {
                        throw new Error(e2);
                    }
                }
                Method method = GET_USE_CIPHER_SUITES_ORDER_METHOD;
                if (method != null && !isDestroyed()) {
                    try {
                        if (((Boolean) method.invoke(sSLParameters, new Object[0])).booleanValue()) {
                            SSL.setOptions(this.ssl, 4194304);
                        } else {
                            SSL.clearOptions(this.ssl, 4194304);
                        }
                    } catch (IllegalAccessException e3) {
                        throw new Error(e3);
                    } catch (InvocationTargetException e4) {
                        throw new Error(e4);
                    }
                }
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setUseClientMode(boolean z) {
        if (z != this.clientMode) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setWantClientAuth(boolean z) {
        setClientAuth(z ? ClientAuth.OPTIONAL : ClientAuth.NONE);
    }

    public final synchronized void shutdown() {
        if (DESTROYED_UPDATER.compareAndSet(this, 0, 1)) {
            this.engineMap.remove(this.ssl);
            SSL.freeSSL(this.ssl);
            SSL.freeBIO(this.networkBIO);
            this.networkBIO = 0L;
            this.ssl = 0L;
            this.engineClosed = true;
            this.isOutboundDone = true;
            this.isInboundDone = true;
        }
        SSL.clearError();
    }

    public final synchronized long sslPointer() {
        return this.ssl;
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch() {
        this.refCnt.touch();
        return this;
    }

    public final SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer[] byteBufferArr2, int i3, int i4) throws SSLException {
        int i5;
        int i6;
        ByteBuffer byteBuffer;
        if (byteBufferArr != null) {
            if (i >= byteBufferArr.length || (i5 = i + i2) > byteBufferArr.length) {
                throw new IndexOutOfBoundsException("offset: " + i + ", length: " + i2 + " (expected: offset <= offset + length <= srcs.length (" + byteBufferArr.length + "))");
            } else if (byteBufferArr2 != null) {
                if (i3 < byteBufferArr2.length && (i6 = i3 + i4) <= byteBufferArr2.length) {
                    long j = 0;
                    for (int i7 = i3; i7 < i6; i7++) {
                        ByteBuffer byteBuffer2 = byteBufferArr2[i7];
                        if (byteBuffer2 != null) {
                            if (!byteBuffer2.isReadOnly()) {
                                j += byteBuffer2.remaining();
                            } else {
                                throw new ReadOnlyBufferException();
                            }
                        } else {
                            throw new IllegalArgumentException("dsts[" + i7 + "] is null");
                        }
                    }
                    long j2 = 0;
                    for (int i8 = i; i8 < i5; i8++) {
                        if (byteBufferArr[i8] != null) {
                            j2 += byteBuffer.remaining();
                        } else {
                            throw new IllegalArgumentException("srcs[" + i8 + "] is null");
                        }
                    }
                    synchronized (this) {
                        if (isDestroyed()) {
                            return CLOSED_NOT_HANDSHAKING;
                        }
                        if (j2 <= 18713) {
                            SSLEngineResult.HandshakeStatus handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                            HandshakeState handshakeState = this.handshakeState;
                            if (handshakeState != HandshakeState.FINISHED) {
                                if (handshakeState != HandshakeState.STARTED_EXPLICITLY) {
                                    this.handshakeState = HandshakeState.STARTED_IMPLICITLY;
                                }
                                handshakeStatus = handshake();
                                if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
                                    return NEED_WRAP_OK;
                                }
                                if (this.engineClosed) {
                                    return NEED_WRAP_CLOSED;
                                }
                            }
                            int i9 = 0;
                            int i10 = 0;
                            if (i < i5) {
                                while (true) {
                                    ByteBuffer byteBuffer3 = byteBufferArr[i];
                                    int remaining = byteBuffer3.remaining();
                                    if (remaining != 0) {
                                        int writeEncryptedData = writeEncryptedData(byteBuffer3);
                                        if (writeEncryptedData <= 0) {
                                            SSL.clearError();
                                            break;
                                        }
                                        i10 += writeEncryptedData;
                                        if (writeEncryptedData != remaining) {
                                            break;
                                        }
                                    }
                                    i++;
                                    if (i >= i5) {
                                        break;
                                    }
                                }
                            }
                            if (j > 0) {
                                while (i3 < i6) {
                                    ByteBuffer byteBuffer4 = byteBufferArr2[i3];
                                    if (byteBuffer4.hasRemaining()) {
                                        int readPlaintextData = readPlaintextData(byteBuffer4);
                                        rejectRemoteInitiatedRenegation();
                                        if (readPlaintextData > 0) {
                                            i9 += readPlaintextData;
                                            if (byteBuffer4.hasRemaining()) {
                                                return newResult(i10, i9, handshakeStatus);
                                            }
                                        } else {
                                            int error = SSL.getError(this.ssl, readPlaintextData);
                                            if (error != 2 && error != 3) {
                                                if (error != 6) {
                                                    return sslReadErrorResult(SSL.getLastErrorNumber(), i10, i9);
                                                }
                                                if (!this.receivedShutdown) {
                                                    closeAll();
                                                }
                                            }
                                            return newResult(i10, i9, handshakeStatus);
                                        }
                                    }
                                    i3++;
                                }
                            } else if (SSL.readFromSSL(this.ssl, EMPTY_ADDR, 0) <= 0) {
                                int lastErrorNumber = SSL.getLastErrorNumber();
                                if (OpenSsl.isError(lastErrorNumber)) {
                                    return sslReadErrorResult(lastErrorNumber, i10, 0);
                                }
                            }
                            if (pendingAppData() > 0) {
                                SSLEngineResult.Status status = SSLEngineResult.Status.BUFFER_OVERFLOW;
                                if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
                                    handshakeStatus = getHandshakeStatus();
                                }
                                return new SSLEngineResult(status, mayFinishHandshake(handshakeStatus), i10, i9);
                            }
                            if (!this.receivedShutdown && (SSL.getShutdown(this.ssl) & 2) == 2) {
                                closeAll();
                            }
                            return newResult(i10, i9, handshakeStatus);
                        }
                        this.isInboundDone = true;
                        this.isOutboundDone = true;
                        this.engineClosed = true;
                        shutdown();
                        throw ENCRYPTED_PACKET_OVERSIZED;
                    }
                }
                throw new IndexOutOfBoundsException("offset: " + i3 + ", length: " + i4 + " (expected: offset <= offset + length <= dsts.length (" + byteBufferArr2.length + "))");
            } else {
                throw new IllegalArgumentException("dsts is null");
            }
        }
        throw new NullPointerException("srcs");
    }

    @Override // javax.net.ssl.SSLEngine
    public final SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer byteBuffer) throws SSLException {
        int i3;
        SSLEngineResult readPendingBytesFromBIO;
        if (byteBufferArr != null) {
            if (byteBuffer != null) {
                if (i < byteBufferArr.length && (i3 = i + i2) <= byteBufferArr.length) {
                    if (!byteBuffer.isReadOnly()) {
                        synchronized (this) {
                            if (isDestroyed()) {
                                return CLOSED_NOT_HANDSHAKING;
                            }
                            SSLEngineResult.HandshakeStatus handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                            HandshakeState handshakeState = this.handshakeState;
                            if (handshakeState != HandshakeState.FINISHED) {
                                if (handshakeState != HandshakeState.STARTED_EXPLICITLY) {
                                    this.handshakeState = HandshakeState.STARTED_IMPLICITLY;
                                }
                                handshakeStatus = handshake();
                                if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                                    return NEED_UNWRAP_OK;
                                }
                                if (this.engineClosed) {
                                    return NEED_UNWRAP_CLOSED;
                                }
                            }
                            int i4 = 0;
                            int i5 = 0;
                            while (i < i3) {
                                ByteBuffer byteBuffer2 = byteBufferArr[i];
                                if (byteBuffer2 != null) {
                                    while (byteBuffer2.hasRemaining()) {
                                        int writePlaintextData = writePlaintextData(byteBuffer2);
                                        if (writePlaintextData > 0) {
                                            i4 += writePlaintextData;
                                            SSLEngineResult readPendingBytesFromBIO2 = readPendingBytesFromBIO(byteBuffer, i4, i5, handshakeStatus);
                                            if (readPendingBytesFromBIO2 != null) {
                                                if (readPendingBytesFromBIO2.getStatus() != SSLEngineResult.Status.OK) {
                                                    return readPendingBytesFromBIO2;
                                                }
                                                i5 = readPendingBytesFromBIO2.bytesProduced();
                                            }
                                        } else {
                                            int error = SSL.getError(this.ssl, writePlaintextData);
                                            if (error == 2) {
                                                SSLEngineResult readPendingBytesFromBIO3 = readPendingBytesFromBIO(byteBuffer, i4, i5, handshakeStatus);
                                                if (readPendingBytesFromBIO3 == null) {
                                                    readPendingBytesFromBIO3 = new SSLEngineResult(getEngineStatus(), SSLEngineResult.HandshakeStatus.NEED_UNWRAP, i4, i5);
                                                }
                                                return readPendingBytesFromBIO3;
                                            } else if (error == 3) {
                                                SSLEngineResult readPendingBytesFromBIO4 = readPendingBytesFromBIO(byteBuffer, i4, i5, handshakeStatus);
                                                if (readPendingBytesFromBIO4 == null) {
                                                    readPendingBytesFromBIO4 = NEED_WRAP_CLOSED;
                                                }
                                                return readPendingBytesFromBIO4;
                                            } else if (error == 6) {
                                                if (!this.receivedShutdown) {
                                                    closeAll();
                                                }
                                                SSLEngineResult readPendingBytesFromBIO5 = readPendingBytesFromBIO(byteBuffer, i4, i5, handshakeStatus);
                                                if (readPendingBytesFromBIO5 == null) {
                                                    readPendingBytesFromBIO5 = CLOSED_NOT_HANDSHAKING;
                                                }
                                                return readPendingBytesFromBIO5;
                                            } else {
                                                throw shutdownWithError("SSL_write");
                                            }
                                        }
                                    }
                                    i++;
                                } else {
                                    throw new IllegalArgumentException("srcs[" + i + "] is null");
                                }
                            }
                            return (i4 != 0 || (readPendingBytesFromBIO = readPendingBytesFromBIO(byteBuffer, 0, i5, handshakeStatus)) == null) ? newResult(i4, i5, handshakeStatus) : readPendingBytesFromBIO;
                        }
                    }
                    throw new ReadOnlyBufferException();
                }
                throw new IndexOutOfBoundsException("offset: " + i + ", length: " + i2 + " (expected: offset <= offset + length <= srcs.length (" + byteBufferArr.length + "))");
            }
            throw new IllegalArgumentException("dst is null");
        }
        throw new IllegalArgumentException("srcs is null");
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatus(int i) {
        return needPendingStatus() ? pendingStatus(i) : SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
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

    private SSLException shutdownWithError(String str, String str2) {
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} failed: OpenSSL error: {}", str, str2);
        }
        shutdown();
        if (this.handshakeState == HandshakeState.FINISHED) {
            return new SSLException(str2);
        }
        return new SSLHandshakeException(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public final class OpenSslSession implements SSLSession, ApplicationProtocolAccessor {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private String applicationProtocol;
        private String cipher;
        private long creationTime;

        /* renamed from: id */
        private byte[] f40281id;
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
            int i;
            byte[][] peerCertChain = SSL.getPeerCertChain(ReferenceCountedOpenSslEngine.this.ssl);
            byte[] peerCertificate = !ReferenceCountedOpenSslEngine.this.clientMode ? SSL.getPeerCertificate(ReferenceCountedOpenSslEngine.this.ssl) : null;
            if (peerCertChain == null && peerCertificate == null) {
                this.peerCerts = ReferenceCountedOpenSslEngine.EMPTY_CERTIFICATES;
                this.x509PeerCerts = ReferenceCountedOpenSslEngine.EMPTY_X509_CERTIFICATES;
                return;
            }
            int length = peerCertChain != null ? peerCertChain.length : 0;
            if (peerCertificate != null) {
                certificateArr = new Certificate[length + 1];
                certificateArr[0] = new OpenSslX509Certificate(peerCertificate);
                i = 1;
            } else {
                certificateArr = new Certificate[length];
                i = 0;
            }
            if (peerCertChain != null) {
                int length2 = peerCertChain.length;
                X509Certificate[] x509CertificateArr = new X509Certificate[length2];
                for (int i2 = 0; i2 < length2; i2++) {
                    byte[] bArr = peerCertChain[i2];
                    x509CertificateArr[i2] = new OpenSslJavaxX509Certificate(bArr);
                    certificateArr[i] = new OpenSslX509Certificate(bArr);
                    i++;
                }
                this.x509PeerCerts = x509CertificateArr;
            } else {
                this.x509PeerCerts = ReferenceCountedOpenSslEngine.EMPTY_X509_CERTIFICATES;
            }
            this.peerCerts = certificateArr;
        }

        private void notifyUnbound(Object obj, String str) {
            if (obj instanceof SSLSessionBindingListener) {
                ((SSLSessionBindingListener) obj).valueUnbound(new SSLSessionBindingEvent(this, str));
            }
        }

        private void selectApplicationProtocol() throws SSLException {
            ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior = ReferenceCountedOpenSslEngine.this.apn.selectedListenerFailureBehavior();
            List<String> protocols = ReferenceCountedOpenSslEngine.this.apn.protocols();
            int i = C139462.f40279xc16482e4[ReferenceCountedOpenSslEngine.this.apn.protocol().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    String alpnSelected = SSL.getAlpnSelected(ReferenceCountedOpenSslEngine.this.ssl);
                    if (alpnSelected != null) {
                        this.applicationProtocol = selectApplicationProtocol(protocols, selectedListenerFailureBehavior, alpnSelected);
                    }
                } else if (i == 3) {
                    String nextProtoNegotiated = SSL.getNextProtoNegotiated(ReferenceCountedOpenSslEngine.this.ssl);
                    if (nextProtoNegotiated != null) {
                        this.applicationProtocol = selectApplicationProtocol(protocols, selectedListenerFailureBehavior, nextProtoNegotiated);
                    }
                } else if (i == 4) {
                    String alpnSelected2 = SSL.getAlpnSelected(ReferenceCountedOpenSslEngine.this.ssl);
                    if (alpnSelected2 == null) {
                        alpnSelected2 = SSL.getNextProtoNegotiated(ReferenceCountedOpenSslEngine.this.ssl);
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
                if (this.creationTime == 0 && !ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                    this.creationTime = SSL.getTime(ReferenceCountedOpenSslEngine.this.ssl) * 1000;
                }
            }
            return this.creationTime;
        }

        @Override // javax.net.ssl.SSLSession
        public byte[] getId() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                byte[] bArr = this.f40281id;
                if (bArr == null) {
                    return EmptyArrays.EMPTY_BYTES;
                }
                return (byte[]) bArr.clone();
            }
        }

        @Override // javax.net.ssl.SSLSession
        public long getLastAccessedTime() {
            long j = ReferenceCountedOpenSslEngine.this.lastAccessed;
            return j == -1 ? getCreationTime() : j;
        }

        @Override // javax.net.ssl.SSLSession
        public Certificate[] getLocalCertificates() {
            if (ReferenceCountedOpenSslEngine.this.localCerts == null) {
                return null;
            }
            return (Certificate[]) ReferenceCountedOpenSslEngine.this.localCerts.clone();
        }

        @Override // javax.net.ssl.SSLSession
        public Principal getLocalPrincipal() {
            Certificate[] certificateArr = ReferenceCountedOpenSslEngine.this.localCerts;
            if (certificateArr == null || certificateArr.length == 0) {
                return null;
            }
            return ((java.security.cert.X509Certificate) certificateArr[0]).getIssuerX500Principal();
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
                if (!ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                    this.f40281id = SSL.getSessionId(ReferenceCountedOpenSslEngine.this.ssl);
                    ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = ReferenceCountedOpenSslEngine.this;
                    this.cipher = referenceCountedOpenSslEngine.toJavaCipherSuite(SSL.getCipherForSSL(referenceCountedOpenSslEngine.ssl));
                    this.protocol = SSL.getVersion(ReferenceCountedOpenSslEngine.this.ssl);
                    initPeerCerts();
                    selectApplicationProtocol();
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
            throw new NullPointerException(DomainCampaignEx.LOOPBACK_VALUE);
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

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        SSLEngineResult wrap;
        wrap = wrap(singleSrcBuffer(byteBuffer), byteBuffer2);
        resetSingleSrcBuffer();
        return wrap;
    }

    public final SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2) throws SSLException {
        return unwrap(byteBufferArr, 0, byteBufferArr.length, byteBufferArr2, 0, byteBufferArr2.length);
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i, int i2) throws SSLException {
        SSLEngineResult unwrap;
        unwrap = unwrap(singleSrcBuffer(byteBuffer), 0, 1, byteBufferArr, i, i2);
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
}
