package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.Platform;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class CertificateChainCleaner {
    /* renamed from: a */
    public static CertificateChainCleaner m58789a(X509TrustManager x509TrustManager) {
        return Platform.m58485b().mo58486a(x509TrustManager);
    }

    /* renamed from: a */
    public abstract List<Certificate> mo58508a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
