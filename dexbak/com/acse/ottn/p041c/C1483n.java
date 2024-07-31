package com.acse.ottn.p041c;

import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* renamed from: com.acse.ottn.c.n */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1483n {
    /* renamed from: a */
    public static HostnameVerifier m56683a() {
        return new C1482m();
    }

    /* renamed from: b */
    public static SSLSocketFactory m56682b() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, m56680d(), new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: c */
    public static X509TrustManager m56681c() {
        return new C1481l();
    }

    /* renamed from: d */
    private static TrustManager[] m56680d() {
        return new TrustManager[]{new C1480k()};
    }
}
