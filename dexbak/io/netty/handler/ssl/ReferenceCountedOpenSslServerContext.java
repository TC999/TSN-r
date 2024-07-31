package io.netty.handler.ssl;

import io.netty.handler.ssl.ReferenceCountedOpenSslContext;
import io.netty.util.internal.ObjectUtil;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import org.apache.tomcat.jni.SSLContext;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class ReferenceCountedOpenSslServerContext extends ReferenceCountedOpenSslContext {

    /* renamed from: ID */
    private static final byte[] f40282ID = {110, 101, 116, 116, 121};
    private final OpenSslKeyMaterialManager keyMaterialManager;
    private final OpenSslServerSessionContext sessionContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class ExtendedTrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509ExtendedTrustManager manager;

        ExtendedTrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap, X509ExtendedTrustManager x509ExtendedTrustManager) {
            super(openSslEngineMap);
            this.manager = x509ExtendedTrustManager;
        }

        @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext.AbstractCertificateVerifier
        void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception {
            this.manager.checkClientTrusted(x509CertificateArr, str, referenceCountedOpenSslEngine);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class ServerContext {
        OpenSslKeyMaterialManager keyMaterialManager;
        OpenSslServerSessionContext sessionContext;

        ServerContext() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class TrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509TrustManager manager;

        TrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap, X509TrustManager x509TrustManager) {
            super(openSslEngineMap);
            this.manager = x509TrustManager;
        }

        @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext.AbstractCertificateVerifier
        void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception {
            this.manager.checkClientTrusted(x509CertificateArr, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReferenceCountedOpenSslServerContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j, long j2, ClientAuth clientAuth) throws SSLException {
        this(x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig), j, j2, clientAuth);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ServerContext newSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, long j, OpenSslEngineMap openSslEngineMap, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory) throws SSLException {
        ServerContext serverContext = new ServerContext();
        synchronized (ReferenceCountedOpenSslContext.class) {
            try {
                try {
                    SSLContext.setVerify(j, 0, 10);
                    if (OpenSsl.useKeyManagerFactory()) {
                        if (keyManagerFactory == null) {
                            keyManagerFactory = SslContext.buildKeyManagerFactory(x509CertificateArr2, privateKey, str, keyManagerFactory);
                        }
                        X509KeyManager chooseX509KeyManager = ReferenceCountedOpenSslContext.chooseX509KeyManager(keyManagerFactory.getKeyManagers());
                        serverContext.keyMaterialManager = ReferenceCountedOpenSslContext.useExtendedKeyManager(chooseX509KeyManager) ? new OpenSslExtendedKeyMaterialManager((X509ExtendedKeyManager) chooseX509KeyManager, str) : new OpenSslKeyMaterialManager(chooseX509KeyManager, str);
                    } else if (keyManagerFactory == null) {
                        ObjectUtil.checkNotNull(x509CertificateArr2, "keyCertChain");
                        SSLContext.setVerify(j, 0, 10);
                        ReferenceCountedOpenSslContext.setKeyMaterial(j, x509CertificateArr2, privateKey, str);
                    } else {
                        throw new IllegalArgumentException("KeyManagerFactory not supported");
                    }
                    try {
                        if (x509CertificateArr != null) {
                            trustManagerFactory = SslContext.buildTrustManagerFactory(x509CertificateArr, trustManagerFactory);
                        } else if (trustManagerFactory == null) {
                            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                            trustManagerFactory.init((KeyStore) null);
                        }
                        X509TrustManager chooseTrustManager = ReferenceCountedOpenSslContext.chooseTrustManager(trustManagerFactory.getTrustManagers());
                        if (ReferenceCountedOpenSslContext.useExtendedTrustManager(chooseTrustManager)) {
                            SSLContext.setCertVerifyCallback(j, new ExtendedTrustManagerVerifyCallback(openSslEngineMap, (X509ExtendedTrustManager) chooseTrustManager));
                        } else {
                            SSLContext.setCertVerifyCallback(j, new TrustManagerVerifyCallback(openSslEngineMap, chooseTrustManager));
                        }
                    } catch (Exception e) {
                        throw new SSLException("unable to setup trustmanager", e);
                    }
                } catch (Exception e2) {
                    throw new SSLException("failed to set certificate and key", e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        OpenSslServerSessionContext openSslServerSessionContext = new OpenSslServerSessionContext(referenceCountedOpenSslContext);
        serverContext.sessionContext = openSslServerSessionContext;
        openSslServerSessionContext.setSessionIdContext(f40282ID);
        return serverContext;
    }

    @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext
    OpenSslKeyMaterialManager keyMaterialManager() {
        return this.keyMaterialManager;
    }

    private ReferenceCountedOpenSslServerContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator, long j, long j2, ClientAuth clientAuth) throws SSLException {
        super(iterable, cipherSuiteFilter, openSslApplicationProtocolNegotiator, j, j2, 1, (Certificate[]) x509CertificateArr2, clientAuth, true);
        try {
            ServerContext newSessionContext = newSessionContext(this, this.ctx, this.engineMap, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory);
            this.sessionContext = newSessionContext.sessionContext;
            this.keyMaterialManager = newSessionContext.keyMaterialManager;
        } catch (Throwable th) {
            release();
            throw th;
        }
    }

    @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext, io.netty.handler.ssl.SslContext
    public OpenSslServerSessionContext sessionContext() {
        return this.sessionContext;
    }
}
