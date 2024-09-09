package com.bytedance.sdk.component.xv.w.c.gd;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c extends xv {

    /* renamed from: c  reason: collision with root package name */
    private final f f30777c;

    public c(f fVar) {
        this.f30777c = fVar;
    }

    @Override // com.bytedance.sdk.component.xv.w.c.gd.xv
    public List<Certificate> c(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        boolean z3 = false;
        for (int i4 = 0; i4 < 9; i4++) {
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate c4 = this.f30777c.c(x509Certificate);
            if (c4 != null) {
                if (arrayList.size() > 1 || !x509Certificate.equals(c4)) {
                    arrayList.add(c4);
                }
                if (c(c4, c4)) {
                    return arrayList;
                }
                z3 = true;
            } else {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (c(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z3) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof c) && ((c) obj).f30777c.equals(this.f30777c);
    }

    public int hashCode() {
        return this.f30777c.hashCode();
    }

    private boolean c(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return true;
            } catch (GeneralSecurityException unused) {
                return false;
            }
        }
        return false;
    }
}
