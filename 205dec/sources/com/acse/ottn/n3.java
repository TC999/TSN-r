package com.acse.ottn;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class n3 {

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return str != null && str.endsWith("boo.chat");
        }
    }

    public static HostnameVerifier a() {
        return new c();
    }

    public static SSLSocketFactory b() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, c(), new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static TrustManager[] c() {
        return new TrustManager[]{new a()};
    }

    public static X509TrustManager d() {
        return new b();
    }
}
