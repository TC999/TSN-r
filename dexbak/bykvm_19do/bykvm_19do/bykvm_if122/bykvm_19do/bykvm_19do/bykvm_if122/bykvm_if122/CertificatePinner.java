package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ByteString;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.CertificateChainCleaner;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class CertificatePinner {

    /* renamed from: c */
    public static final CertificatePinner f1283c = new C1066a().m58416a();

    /* renamed from: a */
    private final Set<C1067b> f1284a;

    /* renamed from: b */
    private final CertificateChainCleaner f1285b;

    /* compiled from: CertificatePinner.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.g$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class C1066a {

        /* renamed from: a */
        private final List<C1067b> f1286a = new ArrayList();

        /* renamed from: a */
        public CertificatePinner m58416a() {
            return new CertificatePinner(new LinkedHashSet(this.f1286a), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CertificatePinner.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.g$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class C1067b {

        /* renamed from: a */
        final String f1287a;

        /* renamed from: b */
        final String f1288b;

        /* renamed from: c */
        final String f1289c;

        /* renamed from: d */
        final ByteString f1290d;

        /* renamed from: a */
        boolean m58415a(String str) {
            if (this.f1287a.startsWith("*.")) {
                int indexOf = str.indexOf(46);
                if ((str.length() - indexOf) - 1 == this.f1288b.length()) {
                    String str2 = this.f1288b;
                    if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                        return true;
                    }
                }
                return false;
            }
            return str.equals(this.f1288b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1067b) {
                C1067b c1067b = (C1067b) obj;
                if (this.f1287a.equals(c1067b.f1287a) && this.f1289c.equals(c1067b.f1289c) && this.f1290d.equals(c1067b.f1290d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((this.f1287a.hashCode() + 527) * 31) + this.f1289c.hashCode()) * 31) + this.f1290d.hashCode();
        }

        public String toString() {
            return this.f1289c + this.f1290d.mo58891a();
        }
    }

    CertificatePinner(Set<C1067b> set, CertificateChainCleaner certificateChainCleaner) {
        this.f1284a = set;
        this.f1285b = certificateChainCleaner;
    }

    /* renamed from: b */
    static ByteString m58417b(X509Certificate x509Certificate) {
        return ByteString.m58940a(x509Certificate.getPublicKey().getEncoded()).mo58882d();
    }

    /* renamed from: a */
    public void m58420a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<C1067b> m58421a = m58421a(str);
        if (m58421a.isEmpty()) {
            return;
        }
        CertificateChainCleaner certificateChainCleaner = this.f1285b;
        if (certificateChainCleaner != null) {
            list = certificateChainCleaner.mo58508a(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = m58421a.size();
            ByteString byteString = null;
            ByteString byteString2 = null;
            for (int i2 = 0; i2 < size2; i2++) {
                C1067b c1067b = m58421a.get(i2);
                if (c1067b.f1289c.equals("sha256/")) {
                    if (byteString == null) {
                        byteString = m58417b(x509Certificate);
                    }
                    if (c1067b.f1290d.equals(byteString)) {
                        return;
                    }
                } else if (c1067b.f1289c.equals("sha1/")) {
                    if (byteString2 == null) {
                        byteString2 = m58418a(x509Certificate);
                    }
                    if (c1067b.f1290d.equals(byteString2)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + c1067b.f1289c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(m58419a((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = m58421a.size();
        for (int i4 = 0; i4 < size4; i4++) {
            sb.append("\n    ");
            sb.append(m58421a.get(i4));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (C1061c.m58473a(this.f1285b, certificatePinner.f1285b) && this.f1284a.equals(certificatePinner.f1284a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        CertificateChainCleaner certificateChainCleaner = this.f1285b;
        return ((certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0) * 31) + this.f1284a.hashCode();
    }

    /* renamed from: a */
    List<C1067b> m58421a(String str) {
        List<C1067b> emptyList = Collections.emptyList();
        for (C1067b c1067b : this.f1284a) {
            if (c1067b.m58415a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(c1067b);
            }
        }
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public CertificatePinner m58422a(CertificateChainCleaner certificateChainCleaner) {
        return C1061c.m58473a(this.f1285b, certificateChainCleaner) ? this : new CertificatePinner(this.f1284a, certificateChainCleaner);
    }

    /* renamed from: a */
    public static String m58419a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + m58417b((X509Certificate) certificate).mo58891a();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    /* renamed from: a */
    static ByteString m58418a(X509Certificate x509Certificate) {
        return ByteString.m58940a(x509Certificate.getPublicKey().getEncoded()).mo58883c();
    }
}
