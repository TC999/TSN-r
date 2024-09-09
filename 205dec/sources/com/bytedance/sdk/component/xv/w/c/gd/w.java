package com.bytedance.sdk.component.xv.w.c.gd;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class w implements f {

    /* renamed from: c  reason: collision with root package name */
    private final Map<X500Principal, Set<X509Certificate>> f30783c = new LinkedHashMap();

    public w(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set<X509Certificate> set = this.f30783c.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet<>(1);
                this.f30783c.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    @Override // com.bytedance.sdk.component.xv.w.c.gd.f
    public X509Certificate c(X509Certificate x509Certificate) {
        Set<X509Certificate> set = this.f30783c.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof w) && ((w) obj).f30783c.equals(this.f30783c);
    }

    public int hashCode() {
        return this.f30783c.hashCode();
    }
}
