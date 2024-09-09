package io.netty.handler.ssl;

import io.netty.handler.ssl.ReferenceCountedOpenSslContext;
import io.netty.internal.tcnative.CertificateCallback;
import io.netty.internal.tcnative.SSLContext;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import org.apache.tomcat.jni.CertificateRequestedCallback;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ReferenceCountedOpenSslClientContext extends ReferenceCountedOpenSslContext {
    private final OpenSslSessionContext sessionContext;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ReferenceCountedOpenSslClientContext.class);
    private static final Set<String> SUPPORTED_KEY_TYPES = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList("RSA", "DH_RSA", "EC", "EC_RSA", "EC_EC")));

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class ExtendedTrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509ExtendedTrustManager manager;

        ExtendedTrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap, X509ExtendedTrustManager x509ExtendedTrustManager) {
            super(openSslEngineMap);
            this.manager = OpenSslTlsv13X509ExtendedTrustManager.wrap(x509ExtendedTrustManager, true);
        }

        @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext.AbstractCertificateVerifier
        void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception {
            this.manager.checkServerTrusted(x509CertificateArr, str, referenceCountedOpenSslEngine);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static final class OpenSslCertificateRequestedCallback implements CertificateRequestedCallback {
        private final OpenSslEngineMap engineMap;
        private final OpenSslKeyMaterialManager keyManagerHolder;

        OpenSslCertificateRequestedCallback(OpenSslEngineMap openSslEngineMap, OpenSslKeyMaterialManager openSslKeyMaterialManager) {
            this.engineMap = openSslEngineMap;
            this.keyManagerHolder = openSslKeyMaterialManager;
        }

        private static String clientKeyType(byte b4) {
            if (b4 != 1) {
                if (b4 != 3) {
                    switch (b4) {
                        case 64:
                            return "EC";
                        case 65:
                            return "EC_RSA";
                        case 66:
                            return "EC_EC";
                        default:
                            return null;
                    }
                }
                return "DH_RSA";
            }
            return "RSA";
        }

        private static Set<String> supportedClientKeyTypes(byte[] bArr) {
            HashSet hashSet = new HashSet(bArr.length);
            for (byte b4 : bArr) {
                String clientKeyType = clientKeyType(b4);
                if (clientKeyType != null) {
                    hashSet.add(clientKeyType);
                }
            }
            return hashSet;
        }

        public CertificateRequestedCallback.KeyMaterial requested(long j4, byte[] bArr, byte[][] bArr2) {
            X500Principal[] x500PrincipalArr;
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = this.engineMap.get(j4);
            try {
                Set<String> supportedClientKeyTypes = supportedClientKeyTypes(bArr);
                String[] strArr = (String[]) supportedClientKeyTypes.toArray(new String[supportedClientKeyTypes.size()]);
                if (bArr2 == null) {
                    x500PrincipalArr = null;
                } else {
                    x500PrincipalArr = new X500Principal[bArr2.length];
                    for (int i4 = 0; i4 < bArr2.length; i4++) {
                        x500PrincipalArr[i4] = new X500Principal(bArr2[i4]);
                    }
                }
                return this.keyManagerHolder.keyMaterial(referenceCountedOpenSslEngine, strArr, x500PrincipalArr);
            } catch (Throwable th) {
                ReferenceCountedOpenSslClientContext.logger.debug("request of key failed", th);
                SSLHandshakeException sSLHandshakeException = new SSLHandshakeException("General OpenSslEngine problem");
                sSLHandshakeException.initCause(th);
                referenceCountedOpenSslEngine.handshakeException = sSLHandshakeException;
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class OpenSslClientCertificateCallback implements CertificateCallback {
        private final OpenSslEngineMap engineMap;
        private final OpenSslKeyMaterialManager keyManagerHolder;

        OpenSslClientCertificateCallback(OpenSslEngineMap openSslEngineMap, OpenSslKeyMaterialManager openSslKeyMaterialManager) {
            this.engineMap = openSslEngineMap;
            this.keyManagerHolder = openSslKeyMaterialManager;
        }

        private static String clientKeyType(byte b4) {
            if (b4 != 1) {
                if (b4 != 3) {
                    switch (b4) {
                        case 64:
                            return "EC";
                        case 65:
                            return "EC_RSA";
                        case 66:
                            return "EC_EC";
                        default:
                            return null;
                    }
                }
                return "DH_RSA";
            }
            return "RSA";
        }

        private static Set<String> supportedClientKeyTypes(byte[] bArr) {
            if (bArr == null) {
                return ReferenceCountedOpenSslClientContext.SUPPORTED_KEY_TYPES;
            }
            HashSet hashSet = new HashSet(bArr.length);
            for (byte b4 : bArr) {
                String clientKeyType = clientKeyType(b4);
                if (clientKeyType != null) {
                    hashSet.add(clientKeyType);
                }
            }
            return hashSet;
        }

        public void handle(long j4, byte[] bArr, byte[][] bArr2) throws Exception {
            X500Principal[] x500PrincipalArr;
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = this.engineMap.get(j4);
            try {
                Set<String> supportedClientKeyTypes = supportedClientKeyTypes(bArr);
                String[] strArr = (String[]) supportedClientKeyTypes.toArray(new String[0]);
                if (bArr2 == null) {
                    x500PrincipalArr = null;
                } else {
                    X500Principal[] x500PrincipalArr2 = new X500Principal[bArr2.length];
                    for (int i4 = 0; i4 < bArr2.length; i4++) {
                        x500PrincipalArr2[i4] = new X500Principal(bArr2[i4]);
                    }
                    x500PrincipalArr = x500PrincipalArr2;
                }
                this.keyManagerHolder.setKeyMaterialClientSide(referenceCountedOpenSslEngine, strArr, x500PrincipalArr);
            } catch (Throwable th) {
                ReferenceCountedOpenSslClientContext.logger.debug("request of key failed", th);
                referenceCountedOpenSslEngine.initHandshakeException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class OpenSslClientSessionContext extends OpenSslSessionContext {
        OpenSslClientSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, OpenSslKeyMaterialProvider openSslKeyMaterialProvider) {
            super(referenceCountedOpenSslContext, openSslKeyMaterialProvider);
        }

        @Override // javax.net.ssl.SSLSessionContext
        public int getSessionCacheSize() {
            return 0;
        }

        @Override // javax.net.ssl.SSLSessionContext
        public int getSessionTimeout() {
            return 0;
        }

        @Override // io.netty.handler.ssl.OpenSslSessionContext
        public boolean isSessionCacheEnabled() {
            return false;
        }

        @Override // io.netty.handler.ssl.OpenSslSessionContext
        public void setSessionCacheEnabled(boolean z3) {
        }

        @Override // javax.net.ssl.SSLSessionContext
        public void setSessionCacheSize(int i4) {
            if (i4 < 0) {
                throw new IllegalArgumentException();
            }
        }

        @Override // javax.net.ssl.SSLSessionContext
        public void setSessionTimeout(int i4) {
            if (i4 < 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class TrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509TrustManager manager;

        TrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap, X509TrustManager x509TrustManager) {
            super(openSslEngineMap);
            this.manager = x509TrustManager;
        }

        @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext.AbstractCertificateVerifier
        void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception {
            this.manager.checkServerTrusted(x509CertificateArr, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReferenceCountedOpenSslClientContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, String[] strArr, long j4, long j5, boolean z3, String str2) throws SSLException {
        super(iterable, cipherSuiteFilter, applicationProtocolConfig, j4, j5, 0, (Certificate[]) x509CertificateArr2, ClientAuth.NONE, strArr, false, z3, true);
        try {
            this.sessionContext = newSessionContext(this, this.ctx, this.engineMap, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, str2);
        } catch (Throwable th) {
            release();
            throw th;
        }
    }

    static OpenSslSessionContext newSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, long j4, OpenSslEngineMap openSslEngineMap, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, String str2) throws SSLException {
        OpenSslKeyMaterialProvider providerFor;
        KeyManagerFactory openSslCachingX509KeyManagerFactory;
        if ((privateKey == null && x509CertificateArr2 != null) || (privateKey != null && x509CertificateArr2 == null)) {
            throw new IllegalArgumentException("Either both keyCertChain and key needs to be null or none of them");
        }
        OpenSslKeyMaterialProvider openSslKeyMaterialProvider = null;
        try {
            try {
                if (OpenSsl.useKeyManagerFactory()) {
                    if (keyManagerFactory == null && x509CertificateArr2 != null) {
                        char[] keyStorePassword = SslContext.keyStorePassword(str);
                        KeyStore buildKeyStore = SslContext.buildKeyStore(x509CertificateArr2, privateKey, keyStorePassword, str2);
                        if (buildKeyStore.aliases().hasMoreElements()) {
                            openSslCachingX509KeyManagerFactory = new OpenSslX509KeyManagerFactory();
                        } else {
                            openSslCachingX509KeyManagerFactory = new OpenSslCachingX509KeyManagerFactory(KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()));
                        }
                        openSslCachingX509KeyManagerFactory.init(buildKeyStore, keyStorePassword);
                        providerFor = ReferenceCountedOpenSslContext.providerFor(openSslCachingX509KeyManagerFactory, str);
                    } else {
                        providerFor = keyManagerFactory != null ? ReferenceCountedOpenSslContext.providerFor(keyManagerFactory, str) : null;
                    }
                    if (providerFor != null) {
                        try {
                            try {
                                SSLContext.setCertificateCallback(j4, new OpenSslClientCertificateCallback(openSslEngineMap, new OpenSslKeyMaterialManager(providerFor)));
                            } catch (Exception e4) {
                                e = e4;
                                throw new SSLException("failed to set certificate and key", e);
                            }
                        } catch (Throwable th) {
                            th = th;
                            openSslKeyMaterialProvider = providerFor;
                            if (openSslKeyMaterialProvider != null) {
                                openSslKeyMaterialProvider.destroy();
                            }
                            throw th;
                        }
                    }
                } else if (keyManagerFactory != null) {
                    throw new IllegalArgumentException("KeyManagerFactory not supported");
                } else {
                    if (x509CertificateArr2 != null) {
                        ReferenceCountedOpenSslContext.setKeyMaterial(j4, x509CertificateArr2, privateKey, str);
                    }
                    providerFor = null;
                }
                SSLContext.setVerify(j4, 1, 10);
                try {
                    if (x509CertificateArr != null) {
                        trustManagerFactory = SslContext.buildTrustManagerFactory(x509CertificateArr, trustManagerFactory, str2);
                    } else if (trustManagerFactory == null) {
                        trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                        trustManagerFactory.init((KeyStore) null);
                    }
                    X509TrustManager chooseTrustManager = ReferenceCountedOpenSslContext.chooseTrustManager(trustManagerFactory.getTrustManagers());
                    if (ReferenceCountedOpenSslContext.useExtendedTrustManager(chooseTrustManager)) {
                        SSLContext.setCertVerifyCallback(j4, new ExtendedTrustManagerVerifyCallback(openSslEngineMap, (X509ExtendedTrustManager) chooseTrustManager));
                    } else {
                        SSLContext.setCertVerifyCallback(j4, new TrustManagerVerifyCallback(openSslEngineMap, chooseTrustManager));
                    }
                    return new OpenSslClientSessionContext(referenceCountedOpenSslContext, providerFor);
                } catch (Exception e5) {
                    if (providerFor != null) {
                        providerFor.destroy();
                    }
                    throw new SSLException("unable to setup trustmanager", e5);
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext, io.netty.handler.ssl.SslContext
    public OpenSslSessionContext sessionContext() {
        return this.sessionContext;
    }
}
