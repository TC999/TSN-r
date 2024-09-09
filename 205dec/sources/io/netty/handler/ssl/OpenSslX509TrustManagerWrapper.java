package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedAction;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class OpenSslX509TrustManagerWrapper {
    private static final InternalLogger LOGGER;
    private static final TrustManagerWrapper WRAPPER;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface TrustManagerWrapper {
        X509TrustManager wrapIfNeeded(X509TrustManager x509TrustManager);
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class UnsafeTrustManagerWrapper implements TrustManagerWrapper {
        private final long spiOffset;
        private final long tmOffset;

        UnsafeTrustManagerWrapper(long j4, long j5) {
            this.spiOffset = j4;
            this.tmOffset = j5;
        }

        @Override // io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.TrustManagerWrapper
        public X509TrustManager wrapIfNeeded(X509TrustManager x509TrustManager) {
            if (!(x509TrustManager instanceof X509ExtendedTrustManager)) {
                try {
                    SSLContext access$000 = OpenSslX509TrustManagerWrapper.access$000();
                    access$000.init(null, new TrustManager[]{x509TrustManager}, null);
                    Object object = PlatformDependent.getObject(access$000, this.spiOffset);
                    if (object != null) {
                        Object object2 = PlatformDependent.getObject(object, this.tmOffset);
                        if (object2 instanceof X509ExtendedTrustManager) {
                            return (X509TrustManager) object2;
                        }
                    }
                } catch (KeyManagementException e4) {
                    PlatformDependent.throwException(e4);
                } catch (NoSuchAlgorithmException e5) {
                    PlatformDependent.throwException(e5);
                }
            }
            return x509TrustManager;
        }
    }

    static {
        final SSLContext sSLContext;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(OpenSslX509TrustManagerWrapper.class);
        LOGGER = internalLoggerFactory;
        TrustManagerWrapper trustManagerWrapper = new TrustManagerWrapper() { // from class: io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.1
            @Override // io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.TrustManagerWrapper
            public X509TrustManager wrapIfNeeded(X509TrustManager x509TrustManager) {
                return x509TrustManager;
            }
        };
        Throwable th = null;
        if (PlatformDependent.getUnsafeUnavailabilityCause() == null) {
            try {
                sSLContext = newSSLContext();
                sSLContext.init(null, new TrustManager[]{new X509TrustManager() { // from class: io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.2
                    @Override // javax.net.ssl.X509TrustManager
                    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                        throw new CertificateException();
                    }

                    @Override // javax.net.ssl.X509TrustManager
                    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                        throw new CertificateException();
                    }

                    @Override // javax.net.ssl.X509TrustManager
                    public X509Certificate[] getAcceptedIssuers() {
                        return EmptyArrays.EMPTY_X509_CERTIFICATES;
                    }
                }}, null);
            } catch (Throwable th2) {
                th = th2;
                sSLContext = null;
            }
            if (th != null) {
                LOGGER.debug("Unable to access wrapped TrustManager", th);
            } else {
                Object doPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.handler.ssl.OpenSslX509TrustManagerWrapper.3
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            try {
                                long objectFieldOffset = PlatformDependent.objectFieldOffset(SSLContext.class.getDeclaredField("contextSpi"));
                                Object object = PlatformDependent.getObject(sSLContext, objectFieldOffset);
                                if (object != null) {
                                    Class<?> cls = object.getClass();
                                    while (true) {
                                        try {
                                            long objectFieldOffset2 = PlatformDependent.objectFieldOffset(cls.getDeclaredField("trustManager"));
                                            if (PlatformDependent.getObject(object, objectFieldOffset2) instanceof X509ExtendedTrustManager) {
                                                return new UnsafeTrustManagerWrapper(objectFieldOffset, objectFieldOffset2);
                                            }
                                        } catch (NoSuchFieldException unused) {
                                        }
                                        cls = cls.getSuperclass();
                                        if (cls == null) {
                                            break;
                                        }
                                    }
                                }
                                throw new NoSuchFieldException();
                            } catch (SecurityException e4) {
                                return e4;
                            }
                        } catch (NoSuchFieldException e5) {
                            return e5;
                        }
                    }
                });
                if (doPrivileged instanceof Throwable) {
                    LOGGER.debug("Unable to access wrapped TrustManager", (Throwable) doPrivileged);
                } else {
                    trustManagerWrapper = (TrustManagerWrapper) doPrivileged;
                }
            }
        } else {
            internalLoggerFactory.debug("Unable to access wrapped TrustManager", (Throwable) null);
        }
        WRAPPER = trustManagerWrapper;
    }

    private OpenSslX509TrustManagerWrapper() {
    }

    static /* synthetic */ SSLContext access$000() throws NoSuchAlgorithmException {
        return newSSLContext();
    }

    private static SSLContext newSSLContext() throws NoSuchAlgorithmException {
        return SSLContext.getInstance("TLS");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static X509TrustManager wrapIfNeeded(X509TrustManager x509TrustManager) {
        return WRAPPER.wrapIfNeeded(x509TrustManager);
    }
}
