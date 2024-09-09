package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: CertificatePinner.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class g {

    /* renamed from: c  reason: collision with root package name */
    public static final g f1276c = new a().a();

    /* renamed from: a  reason: collision with root package name */
    private final Set<b> f1277a;

    /* renamed from: b  reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c f1278b;

    /* compiled from: CertificatePinner.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<b> f1279a = new ArrayList();

        public g a() {
            return new g(new LinkedHashSet(this.f1279a), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CertificatePinner.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final String f1280a;

        /* renamed from: b  reason: collision with root package name */
        final String f1281b;

        /* renamed from: c  reason: collision with root package name */
        final String f1282c;

        /* renamed from: d  reason: collision with root package name */
        final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f f1283d;

        boolean a(String str) {
            if (this.f1280a.startsWith("*.")) {
                int indexOf = str.indexOf(46);
                if ((str.length() - indexOf) - 1 == this.f1281b.length()) {
                    String str2 = this.f1281b;
                    if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                        return true;
                    }
                }
                return false;
            }
            return str.equals(this.f1281b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f1280a.equals(bVar.f1280a) && this.f1282c.equals(bVar.f1282c) && this.f1283d.equals(bVar.f1283d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((this.f1280a.hashCode() + 527) * 31) + this.f1282c.hashCode()) * 31) + this.f1283d.hashCode();
        }

        public String toString() {
            return this.f1282c + this.f1283d.a();
        }
    }

    g(Set<b> set, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c cVar) {
        this.f1277a = set;
        this.f1278b = cVar;
    }

    static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f b(X509Certificate x509Certificate) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> a4 = a(str);
        if (a4.isEmpty()) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1278b;
        if (cVar != null) {
            list = cVar.a(list, str);
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i4);
            int size2 = a4.size();
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar = null;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar2 = null;
            for (int i5 = 0; i5 < size2; i5++) {
                b bVar = a4.get(i5);
                if (bVar.f1282c.equals("sha256/")) {
                    if (fVar == null) {
                        fVar = b(x509Certificate);
                    }
                    if (bVar.f1283d.equals(fVar)) {
                        return;
                    }
                } else if (bVar.f1282c.equals("sha1/")) {
                    if (fVar2 == null) {
                        fVar2 = a(x509Certificate);
                    }
                    if (bVar.f1283d.equals(fVar2)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + bVar.f1282c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i6 = 0; i6 < size3; i6++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i6);
            sb.append("\n    ");
            sb.append(a((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = a4.size();
        for (int i7 = 0; i7 < size4; i7++) {
            sb.append("\n    ");
            sb.append(a4.get(i7));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f1278b, gVar.f1278b) && this.f1277a.equals(gVar.f1277a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1278b;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f1277a.hashCode();
    }

    List<b> a(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.f1277a) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c cVar) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f1278b, cVar) ? this : new g(this.f1277a, cVar);
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + b((X509Certificate) certificate).a();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f a(X509Certificate x509Certificate) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.a(x509Certificate.getPublicKey().getEncoded()).c();
    }
}
