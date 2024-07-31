package com.bytedance.pangle.p123g;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* renamed from: com.bytedance.pangle.g.p */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
final class C6154p extends C6156r {

    /* renamed from: a */
    private final byte[] f22048a;

    /* renamed from: b */
    private int f22049b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6154p(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f22049b = -1;
        this.f22048a = bArr;
    }

    @Override // java.security.cert.Certificate
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C6154p) {
            try {
                return Arrays.equals(getEncoded(), ((C6154p) obj).getEncoded());
            } catch (CertificateEncodingException unused) {
                return false;
            }
        }
        return false;
    }

    @Override // com.bytedance.pangle.p123g.C6156r, java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.f22048a;
    }

    @Override // java.security.cert.Certificate
    public final int hashCode() {
        if (this.f22049b == -1) {
            try {
                this.f22049b = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.f22049b = 0;
            }
        }
        return this.f22049b;
    }
}
