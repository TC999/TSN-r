package com.qq.e.comm.plugin.util.x2;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class f extends g {

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f46722d;

    /* renamed from: e  reason: collision with root package name */
    private int f46723e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f46723e = -1;
        this.f46722d = bArr;
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            try {
                return Arrays.equals(getEncoded(), ((f) obj).getEncoded());
            } catch (CertificateEncodingException unused) {
                return false;
            }
        }
        return false;
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return this.f46722d;
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        if (this.f46723e == -1) {
            try {
                this.f46723e = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.f46723e = 0;
            }
        }
        return this.f46723e;
    }
}
