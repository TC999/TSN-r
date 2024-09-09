package io.netty.handler.ssl;

import java.io.File;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManagerFactory;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
@Deprecated
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class JdkSslClientContext extends JdkSslContext {
    @Deprecated
    public JdkSslClientContext() throws SSLException {
        this(null, null);
    }

    private static SSLContext newSSLContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, long j4, long j5) throws SSLException {
        if (x509CertificateArr != null) {
            try {
                trustManagerFactory = SslContext.buildTrustManagerFactory(x509CertificateArr, trustManagerFactory);
            } catch (Exception e4) {
                if (e4 instanceof SSLException) {
                    throw ((SSLException) e4);
                }
                throw new SSLException("failed to initialize the client-side SSL context", e4);
            }
        }
        if (x509CertificateArr2 != null) {
            keyManagerFactory = SslContext.buildKeyManagerFactory(x509CertificateArr2, privateKey, str, keyManagerFactory);
        }
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(keyManagerFactory == null ? null : keyManagerFactory.getKeyManagers(), trustManagerFactory == null ? null : trustManagerFactory.getTrustManagers(), null);
        SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
        if (j4 > 0) {
            clientSessionContext.setSessionCacheSize((int) Math.min(j4, 2147483647L));
        }
        if (j5 > 0) {
            clientSessionContext.setSessionTimeout((int) Math.min(j5, 2147483647L));
        }
        return sSLContext;
    }

    @Deprecated
    public JdkSslClientContext(File file) throws SSLException {
        this(file, null);
    }

    @Deprecated
    public JdkSslClientContext(TrustManagerFactory trustManagerFactory) throws SSLException {
        this(null, trustManagerFactory);
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory) throws SSLException {
        this(file, trustManagerFactory, (Iterable<String>) null, IdentityCipherSuiteFilter.INSTANCE, JdkDefaultApplicationProtocolNegotiator.INSTANCE, 0L, 0L);
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, Iterable<String> iterable2, long j4, long j5) throws SSLException {
        this(file, trustManagerFactory, iterable, IdentityCipherSuiteFilter.INSTANCE, JdkSslContext.toNegotiator(SslContext.toApplicationProtocolConfig(iterable2), false), j4, j5);
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j4, long j5) throws SSLException {
        this(file, trustManagerFactory, iterable, cipherSuiteFilter, JdkSslContext.toNegotiator(applicationProtocolConfig, false), j4, j5);
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, long j4, long j5) throws SSLException {
        this(file, trustManagerFactory, (File) null, (File) null, (String) null, (KeyManagerFactory) null, iterable, cipherSuiteFilter, jdkApplicationProtocolNegotiator, j4, j5);
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory, File file2, File file3, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j4, long j5) throws SSLException {
        this(file, trustManagerFactory, file2, file3, str, keyManagerFactory, iterable, cipherSuiteFilter, JdkSslContext.toNegotiator(applicationProtocolConfig, false), j4, j5);
    }

    @Deprecated
    public JdkSslClientContext(File file, TrustManagerFactory trustManagerFactory, File file2, File file3, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, long j4, long j5) throws SSLException {
        super(newSSLContext(SslContext.toX509CertificatesInternal(file), trustManagerFactory, SslContext.toX509CertificatesInternal(file2), SslContext.toPrivateKeyInternal(file3, str), str, keyManagerFactory, j4, j5), true, iterable, cipherSuiteFilter, jdkApplicationProtocolNegotiator, ClientAuth.NONE);
    }

    JdkSslClientContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j4, long j5) throws SSLException {
        super(newSSLContext(x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, j4, j5), true, iterable, cipherSuiteFilter, JdkSslContext.toNegotiator(applicationProtocolConfig, false), ClientAuth.NONE);
    }
}
