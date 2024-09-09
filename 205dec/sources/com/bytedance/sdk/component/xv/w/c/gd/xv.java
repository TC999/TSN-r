package com.bytedance.sdk.component.xv.w.c.gd;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class xv {
    public static xv c(X509TrustManager x509TrustManager) {
        return com.bytedance.sdk.component.xv.w.c.r.ux.w().c(x509TrustManager);
    }

    public abstract List<Certificate> c(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
