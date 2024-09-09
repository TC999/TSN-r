package com.acse.ottn.c;

import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class n {
    public static HostnameVerifier a() {
        return new m();
    }

    public static SSLSocketFactory b() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, d(), new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static X509TrustManager c() {
        return new l();
    }

    private static TrustManager[] d() {
        return new TrustManager[]{new k()};
    }
}
