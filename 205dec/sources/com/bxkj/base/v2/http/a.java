package com.bxkj.base.v2.http;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SSLSocketClient.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SSLSocketClient.java */
    /* renamed from: com.bxkj.base.v2.http.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class C0206a implements X509TrustManager {
        C0206a() {
        }

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

    /* compiled from: SSLSocketClient.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements HostnameVerifier {
        b() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    public static HostnameVerifier a() {
        return new b();
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
        return new TrustManager[]{new C0206a()};
    }
}
