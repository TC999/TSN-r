package io.netty.handler.ssl.util;

import com.github.mikephil.charting.utils.Utils;
import io.netty.util.concurrent.FastThreadLocal;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Provider;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.TrustManagerFactorySpi;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class SimpleTrustManagerFactory extends TrustManagerFactory {
    private static final Provider PROVIDER = new Provider("", Utils.DOUBLE_EPSILON, "") { // from class: io.netty.handler.ssl.util.SimpleTrustManagerFactory.1
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
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class SimpleTrustManagerFactorySpi extends TrustManagerFactorySpi {
        private SimpleTrustManagerFactory parent;

        SimpleTrustManagerFactorySpi() {
        }

        @Override // javax.net.ssl.TrustManagerFactorySpi
        protected TrustManager[] engineGetTrustManagers() {
            return this.parent.engineGetTrustManagers();
        }

        @Override // javax.net.ssl.TrustManagerFactorySpi
        protected void engineInit(KeyStore keyStore) throws KeyStoreException {
            try {
                this.parent.engineInit(keyStore);
            } catch (KeyStoreException e) {
                throw e;
            } catch (Exception e2) {
                throw new KeyStoreException(e2);
            }
        }

        void init(SimpleTrustManagerFactory simpleTrustManagerFactory) {
            this.parent = simpleTrustManagerFactory;
        }

        @Override // javax.net.ssl.TrustManagerFactorySpi
        protected void engineInit(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException {
            try {
                this.parent.engineInit(managerFactoryParameters);
            } catch (InvalidAlgorithmParameterException e) {
                throw e;
            } catch (Exception e2) {
                throw new InvalidAlgorithmParameterException(e2);
            }
        }
    }
}
