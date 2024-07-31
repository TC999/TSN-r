package com.bxkj.base.p085v2.http;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.bxkj.base.v2.http.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SSLSocketClient {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SSLSocketClient.java */
    /* renamed from: com.bxkj.base.v2.http.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C3994a implements X509TrustManager {
        C3994a() {
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
    /* renamed from: com.bxkj.base.v2.http.a$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C3995b implements HostnameVerifier {
        C3995b() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* renamed from: a */
    public static HostnameVerifier m43540a() {
        return new C3995b();
    }

    /* renamed from: b */
    public static SSLSocketFactory m43539b() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, m43538c(), new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: c */
    public static TrustManager[] m43538c() {
        return new TrustManager[]{new C3994a()};
    }
}
