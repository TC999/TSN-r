package com.bytedance.sdk.component.xv.w;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class r {

    /* renamed from: c  reason: collision with root package name */
    public static final r f31091c = new c().c();

    /* renamed from: w  reason: collision with root package name */
    private final Set<w> f31092w;
    private final com.bytedance.sdk.component.xv.w.c.gd.xv xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        private final List<w> f31093c = new ArrayList();

        public r c() {
            return new r(new LinkedHashSet(this.f31093c), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class w {

        /* renamed from: c  reason: collision with root package name */
        final String f31094c;
        final com.bytedance.sdk.component.xv.c.f sr;

        /* renamed from: w  reason: collision with root package name */
        final String f31095w;
        final String xv;

        boolean c(String str) {
            if (this.f31094c.startsWith("*.")) {
                int indexOf = str.indexOf(46);
                if ((str.length() - indexOf) - 1 == this.f31095w.length()) {
                    String str2 = this.f31095w;
                    if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                        return true;
                    }
                }
                return false;
            }
            return str.equals(this.f31095w);
        }

        public boolean equals(Object obj) {
            if (obj instanceof w) {
                w wVar = (w) obj;
                if (this.f31094c.equals(wVar.f31094c) && this.xv.equals(wVar.xv) && this.sr.equals(wVar.sr)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f31094c.hashCode()) * 31) + this.xv.hashCode()) * 31) + this.sr.hashCode();
        }

        public String toString() {
            return this.xv + this.sr.w();
        }
    }

    r(Set<w> set, com.bytedance.sdk.component.xv.w.c.gd.xv xvVar) {
        this.f31092w = set;
        this.xv = xvVar;
    }

    static com.bytedance.sdk.component.xv.c.f w(X509Certificate x509Certificate) {
        return com.bytedance.sdk.component.xv.c.f.c(x509Certificate.getPublicKey().getEncoded()).sr();
    }

    public void c(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<w> c4 = c(str);
        if (c4.isEmpty()) {
            return;
        }
        com.bytedance.sdk.component.xv.w.c.gd.xv xvVar = this.xv;
        if (xvVar != null) {
            list = xvVar.c(list, str);
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i4);
            int size2 = c4.size();
            com.bytedance.sdk.component.xv.c.f fVar = null;
            com.bytedance.sdk.component.xv.c.f fVar2 = null;
            for (int i5 = 0; i5 < size2; i5++) {
                w wVar = c4.get(i5);
                if (wVar.xv.equals("sha256/")) {
                    if (fVar == null) {
                        fVar = w(x509Certificate);
                    }
                    if (wVar.sr.equals(fVar)) {
                        return;
                    }
                } else if (wVar.xv.equals("sha1/")) {
                    if (fVar2 == null) {
                        fVar2 = c(x509Certificate);
                    }
                    if (wVar.sr.equals(fVar2)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + wVar.xv);
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
            sb.append(c((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = c4.size();
        for (int i7 = 0; i7 < size4; i7++) {
            sb.append("\n    ");
            sb.append(c4.get(i7));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (com.bytedance.sdk.component.xv.w.c.xv.c(this.xv, rVar.xv) && this.f31092w.equals(rVar.f31092w)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        com.bytedance.sdk.component.xv.w.c.gd.xv xvVar = this.xv;
        return ((xvVar != null ? xvVar.hashCode() : 0) * 31) + this.f31092w.hashCode();
    }

    List<w> c(String str) {
        List<w> emptyList = Collections.emptyList();
        for (w wVar : this.f31092w) {
            if (wVar.c(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(wVar);
            }
        }
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r c(com.bytedance.sdk.component.xv.w.c.gd.xv xvVar) {
        return com.bytedance.sdk.component.xv.w.c.xv.c(this.xv, xvVar) ? this : new r(this.f31092w, xvVar);
    }

    public static String c(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + w((X509Certificate) certificate).w();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static com.bytedance.sdk.component.xv.c.f c(X509Certificate x509Certificate) {
        return com.bytedance.sdk.component.xv.c.f.c(x509Certificate.getPublicKey().getEncoded()).xv();
    }
}
