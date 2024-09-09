package io.netty.handler.ssl;

import java.io.File;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class OpenSslClientContext extends OpenSslContext {
    private final OpenSslSessionContext sessionContext;

    @Deprecated
    public OpenSslClientContext() throws SSLException {
        this((File) null, (TrustManagerFactory) null, (File) null, (File) null, (String) null, (KeyManagerFactory) null, (Iterable<String>) null, IdentityCipherSuiteFilter.INSTANCE, (ApplicationProtocolConfig) null, 0L, 0L);
    }

    OpenSslKeyMaterialManager keyMaterialManager() {
        return null;
    }

    @Deprecated
    public OpenSslClientContext(File file) throws SSLException {
        this(file, null);
    }

    @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext, io.netty.handler.ssl.SslContext
    public OpenSslSessionContext sessionContext() {
        return this.sessionContext;
    }

    @Deprecated
    public OpenSslClientContext(TrustManagerFactory trustManagerFactory) throws SSLException {
        this(null, trustManagerFactory);
    }

    @Deprecated
    public OpenSslClientContext(File file, TrustManagerFactory trustManagerFactory) throws SSLException {
        this(file, trustManagerFactory, (File) null, (File) null, (String) null, (KeyManagerFactory) null, (Iterable<String>) null, IdentityCipherSuiteFilter.INSTANCE, (ApplicationProtocolConfig) null, 0L, 0L);
    }

    @Deprecated
    public OpenSslClientContext(File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, ApplicationProtocolConfig applicationProtocolConfig, long j4, long j5) throws SSLException {
        this(file, trustManagerFactory, (File) null, (File) null, (String) null, (KeyManagerFactory) null, iterable, IdentityCipherSuiteFilter.INSTANCE, applicationProtocolConfig, j4, j5);
    }

    @Deprecated
    public OpenSslClientContext(File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j4, long j5) throws SSLException {
        this(file, trustManagerFactory, (File) null, (File) null, (String) null, (KeyManagerFactory) null, iterable, cipherSuiteFilter, applicationProtocolConfig, j4, j5);
    }

    @Deprecated
    public OpenSslClientContext(File file, TrustManagerFactory trustManagerFactory, File file2, File file3, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j4, long j5) throws SSLException {
        this(SslContext.toX509CertificatesInternal(file), trustManagerFactory, SslContext.toX509CertificatesInternal(file2), SslContext.toPrivateKeyInternal(file3, str), str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, j4, j5);
    }

    OpenSslClientContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j4, long j5) throws SSLException {
        super(iterable, cipherSuiteFilter, applicationProtocolConfig, j4, j5, 0, x509CertificateArr2, ClientAuth.NONE);
        try {
            this.sessionContext = ReferenceCountedOpenSslClientContext.newSessionContext(this, this.ctx, this.engineMap, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory);
        } catch (Throwable th) {
            release();
            throw th;
        }
    }
}
