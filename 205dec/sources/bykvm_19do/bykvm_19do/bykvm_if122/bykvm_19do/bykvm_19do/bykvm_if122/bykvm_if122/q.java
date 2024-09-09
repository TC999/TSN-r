package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* compiled from: Handshake.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    private final d0 f1346a;

    /* renamed from: b  reason: collision with root package name */
    private final h f1347b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Certificate> f1348c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Certificate> f1349d;

    private q(d0 d0Var, h hVar, List<Certificate> list, List<Certificate> list2) {
        this.f1346a = d0Var;
        this.f1347b = hVar;
        this.f1348c = list;
        this.f1349d = list2;
    }

    public static q a(SSLSession sSLSession) {
        String str;
        List emptyList;
        List emptyList2;
        Certificate[] certificateArr = null;
        try {
            str = sSLSession.getCipherSuite();
        } catch (Exception unused) {
            str = null;
        }
        if (str != null) {
            h a4 = h.a(str);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                d0 a5 = d0.a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused2) {
                }
                if (certificateArr != null) {
                    emptyList = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(certificateArr);
                } else {
                    emptyList = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    emptyList2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(localCertificates);
                } else {
                    emptyList2 = Collections.emptyList();
                }
                return new q(a5, a4, emptyList, emptyList2);
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public List<Certificate> b() {
        return this.f1348c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof q) {
            q qVar = (q) obj;
            return this.f1346a.equals(qVar.f1346a) && this.f1347b.equals(qVar.f1347b) && this.f1348c.equals(qVar.f1348c) && this.f1349d.equals(qVar.f1349d);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f1346a.hashCode() + 527) * 31) + this.f1347b.hashCode()) * 31) + this.f1348c.hashCode()) * 31) + this.f1349d.hashCode();
    }

    public h a() {
        return this.f1347b;
    }
}
