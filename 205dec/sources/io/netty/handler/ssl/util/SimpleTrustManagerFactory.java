package io.netty.handler.ssl.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.PlatformDependent;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Provider;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.TrustManagerFactorySpi;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class SimpleTrustManagerFactory extends TrustManagerFactory {
    private static final Provider PROVIDER = new Provider("", 0.0d, "") { // from class: io.netty.handler.ssl.util.SimpleTrustManagerFactory.1
        private static final long serialVersionUID = -2680540247105807895L;
    };
    private static final FastThreadLocal<SimpleTrustManagerFactorySpi> CURRENT_SPI = new FastThreadLocal<SimpleTrustManagerFactorySpi>() { // from class: io.netty.handler.ssl.util.SimpleTrustManagerFactory.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public SimpleTrustManagerFactorySpi initialValue() {
            return new SimpleTrustManagerFactorySpi();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    public SimpleTrustManagerFactory() {
        this("");
    }

    protected abstract TrustManager[] engineGetTrustManagers();

    protected abstract void engineInit(KeyStore keyStore) throws Exception;

    protected abstract void engineInit(ManagerFactoryParameters managerFactoryParameters) throws Exception;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected SimpleTrustManagerFactory(java.lang.String r4) {
        /*
            r3 = this;
            io.netty.util.concurrent.FastThreadLocal<io.netty.handler.ssl.util.SimpleTrustManagerFactory$SimpleTrustManagerFactorySpi> r0 = io.netty.handler.ssl.util.SimpleTrustManagerFactory.CURRENT_SPI
            java.lang.Object r1 = r0.get()
            javax.net.ssl.TrustManagerFactorySpi r1 = (javax.net.ssl.TrustManagerFactorySpi) r1
            java.security.Provider r2 = io.netty.handler.ssl.util.SimpleTrustManagerFactory.PROVIDER
            r3.<init>(r1, r2, r4)
            java.lang.Object r1 = r0.get()
            io.netty.handler.ssl.util.SimpleTrustManagerFactory$SimpleTrustManagerFactorySpi r1 = (io.netty.handler.ssl.util.SimpleTrustManagerFactory.SimpleTrustManagerFactorySpi) r1
            r1.init(r3)
            r0.remove()
            if (r4 == 0) goto L1c
            return
        L1c:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            java.lang.String r0 = "name"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.util.SimpleTrustManagerFactory.<init>(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class SimpleTrustManagerFactorySpi extends TrustManagerFactorySpi {
        private SimpleTrustManagerFactory parent;
        private volatile TrustManager[] trustManagers;

        SimpleTrustManagerFactorySpi() {
        }

        @Override // javax.net.ssl.TrustManagerFactorySpi
        protected TrustManager[] engineGetTrustManagers() {
            TrustManager[] trustManagerArr = this.trustManagers;
            if (trustManagerArr == null) {
                trustManagerArr = this.parent.engineGetTrustManagers();
                if (PlatformDependent.javaVersion() >= 7) {
                    for (int i4 = 0; i4 < trustManagerArr.length; i4++) {
                        TrustManager trustManager = trustManagerArr[i4];
                        if ((trustManager instanceof X509TrustManager) && !(trustManager instanceof X509ExtendedTrustManager)) {
                            trustManagerArr[i4] = new X509TrustManagerWrapper((X509TrustManager) trustManager);
                        }
                    }
                }
                this.trustManagers = trustManagerArr;
            }
            return (TrustManager[]) trustManagerArr.clone();
        }

        @Override // javax.net.ssl.TrustManagerFactorySpi
        protected void engineInit(KeyStore keyStore) throws KeyStoreException {
            try {
                this.parent.engineInit(keyStore);
            } catch (KeyStoreException e4) {
                throw e4;
            } catch (Exception e5) {
                throw new KeyStoreException(e5);
            }
        }

        void init(SimpleTrustManagerFactory simpleTrustManagerFactory) {
            this.parent = simpleTrustManagerFactory;
        }

        @Override // javax.net.ssl.TrustManagerFactorySpi
        protected void engineInit(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException {
            try {
                this.parent.engineInit(managerFactoryParameters);
            } catch (InvalidAlgorithmParameterException e4) {
                throw e4;
            } catch (Exception e5) {
                throw new InvalidAlgorithmParameterException(e5);
            }
        }
    }
}
