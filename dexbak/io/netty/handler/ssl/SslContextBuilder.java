package io.netty.handler.ssl;

import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.InputStream;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class SslContextBuilder {
    private ApplicationProtocolConfig apn;
    private Iterable<String> ciphers;
    private final boolean forServer;
    private PrivateKey key;
    private X509Certificate[] keyCertChain;
    private KeyManagerFactory keyManagerFactory;
    private String keyPassword;
    private SslProvider provider;
    private long sessionCacheSize;
    private long sessionTimeout;
    private X509Certificate[] trustCertCollection;
    private TrustManagerFactory trustManagerFactory;
    private CipherSuiteFilter cipherFilter = IdentityCipherSuiteFilter.INSTANCE;
    private ClientAuth clientAuth = ClientAuth.NONE;

    private SslContextBuilder(boolean z) {
        this.forServer = z;
    }

    public static SslContextBuilder forClient() {
        return new SslContextBuilder(false);
    }

    public static SslContextBuilder forServer(File file, File file2) {
        return new SslContextBuilder(true).keyManager(file, file2);
    }

    public SslContextBuilder applicationProtocolConfig(ApplicationProtocolConfig applicationProtocolConfig) {
        this.apn = applicationProtocolConfig;
        return this;
    }

    public SslContext build() throws SSLException {
        if (this.forServer) {
            return SslContext.newServerContextInternal(this.provider, this.trustCertCollection, this.trustManagerFactory, this.keyCertChain, this.key, this.keyPassword, this.keyManagerFactory, this.ciphers, this.cipherFilter, this.apn, this.sessionCacheSize, this.sessionTimeout, this.clientAuth);
        }
        return SslContext.newClientContextInternal(this.provider, this.trustCertCollection, this.trustManagerFactory, this.keyCertChain, this.key, this.keyPassword, this.keyManagerFactory, this.ciphers, this.cipherFilter, this.apn, this.sessionCacheSize, this.sessionTimeout);
    }

    public SslContextBuilder ciphers(Iterable<String> iterable) {
        return ciphers(iterable, IdentityCipherSuiteFilter.INSTANCE);
    }

    public SslContextBuilder clientAuth(ClientAuth clientAuth) {
        this.clientAuth = (ClientAuth) ObjectUtil.checkNotNull(clientAuth, "clientAuth");
        return this;
    }

    public SslContextBuilder keyManager(File file, File file2) {
        return keyManager(file, file2, (String) null);
    }

    public SslContextBuilder sessionCacheSize(long j) {
        this.sessionCacheSize = j;
        return this;
    }

    public SslContextBuilder sessionTimeout(long j) {
        this.sessionTimeout = j;
        return this;
    }

    public SslContextBuilder sslProvider(SslProvider sslProvider) {
        this.provider = sslProvider;
        return this;
    }

    public SslContextBuilder trustManager(File file) {
        try {
            return trustManager(SslContext.toX509Certificates(file));
        } catch (Exception e) {
            throw new IllegalArgumentException("File does not contain valid certificates: " + file, e);
        }
    }

    public static SslContextBuilder forServer(InputStream inputStream, InputStream inputStream2) {
        return new SslContextBuilder(true).keyManager(inputStream, inputStream2);
    }

    public SslContextBuilder ciphers(Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter) {
        ObjectUtil.checkNotNull(cipherSuiteFilter, "cipherFilter");
        this.ciphers = iterable;
        this.cipherFilter = cipherSuiteFilter;
        return this;
    }

    public SslContextBuilder keyManager(InputStream inputStream, InputStream inputStream2) {
        return keyManager(inputStream, inputStream2, (String) null);
    }

    public static SslContextBuilder forServer(PrivateKey privateKey, X509Certificate... x509CertificateArr) {
        return new SslContextBuilder(true).keyManager(privateKey, x509CertificateArr);
    }

    public SslContextBuilder keyManager(PrivateKey privateKey, X509Certificate... x509CertificateArr) {
        return keyManager(privateKey, (String) null, x509CertificateArr);
    }

    public SslContextBuilder trustManager(InputStream inputStream) {
        try {
            return trustManager(SslContext.toX509Certificates(inputStream));
        } catch (Exception e) {
            throw new IllegalArgumentException("Input stream does not contain valid certificates.", e);
        }
    }

    public static SslContextBuilder forServer(File file, File file2, String str) {
        return new SslContextBuilder(true).keyManager(file, file2, str);
    }

    public SslContextBuilder keyManager(File file, File file2, String str) {
        try {
            try {
                return keyManager(SslContext.toPrivateKey(file2, str), str, SslContext.toX509Certificates(file));
            } catch (Exception e) {
                throw new IllegalArgumentException("File does not contain valid private key: " + file2, e);
            }
        } catch (Exception e2) {
            throw new IllegalArgumentException("File does not contain valid certificates: " + file, e2);
        }
    }

    public static SslContextBuilder forServer(InputStream inputStream, InputStream inputStream2, String str) {
        return new SslContextBuilder(true).keyManager(inputStream, inputStream2, str);
    }

    public SslContextBuilder trustManager(X509Certificate... x509CertificateArr) {
        this.trustCertCollection = x509CertificateArr != null ? (X509Certificate[]) x509CertificateArr.clone() : null;
        this.trustManagerFactory = null;
        return this;
    }

    public static SslContextBuilder forServer(PrivateKey privateKey, String str, X509Certificate... x509CertificateArr) {
        return new SslContextBuilder(true).keyManager(privateKey, str, x509CertificateArr);
    }

    public static SslContextBuilder forServer(KeyManagerFactory keyManagerFactory) {
        return new SslContextBuilder(true).keyManager(keyManagerFactory);
    }

    public SslContextBuilder trustManager(TrustManagerFactory trustManagerFactory) {
        this.trustCertCollection = null;
        this.trustManagerFactory = trustManagerFactory;
        return this;
    }

    public SslContextBuilder keyManager(InputStream inputStream, InputStream inputStream2, String str) {
        try {
            try {
                return keyManager(SslContext.toPrivateKey(inputStream2, str), str, SslContext.toX509Certificates(inputStream));
            } catch (Exception e) {
                throw new IllegalArgumentException("Input stream does not contain valid private key.", e);
            }
        } catch (Exception e2) {
            throw new IllegalArgumentException("Input stream not contain valid certificates.", e2);
        }
    }

    public SslContextBuilder keyManager(PrivateKey privateKey, String str, X509Certificate... x509CertificateArr) {
        if (this.forServer) {
            ObjectUtil.checkNotNull(x509CertificateArr, "keyCertChain required for servers");
            if (x509CertificateArr.length != 0) {
                ObjectUtil.checkNotNull(privateKey, "key required for servers");
            } else {
                throw new IllegalArgumentException("keyCertChain must be non-empty");
            }
        }
        if (x509CertificateArr != null && x509CertificateArr.length != 0) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                if (x509Certificate == null) {
                    throw new IllegalArgumentException("keyCertChain contains null entry");
                }
            }
            this.keyCertChain = (X509Certificate[]) x509CertificateArr.clone();
        } else {
            this.keyCertChain = null;
        }
        this.key = privateKey;
        this.keyPassword = str;
        this.keyManagerFactory = null;
        return this;
    }

    public SslContextBuilder keyManager(KeyManagerFactory keyManagerFactory) {
        if (this.forServer) {
            ObjectUtil.checkNotNull(keyManagerFactory, "keyManagerFactory required for servers");
        }
        this.keyCertChain = null;
        this.key = null;
        this.keyPassword = null;
        this.keyManagerFactory = keyManagerFactory;
        return this;
    }
}
