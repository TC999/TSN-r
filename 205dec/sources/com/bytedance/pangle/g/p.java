package com.bytedance.pangle.g;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class p extends r {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f28809a;

    /* renamed from: b  reason: collision with root package name */
    private int f28810b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f28810b = -1;
        this.f28809a = bArr;
    }

    @Override // java.security.cert.Certificate
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            try {
                return Arrays.equals(getEncoded(), ((p) obj).getEncoded());
            } catch (CertificateEncodingException unused) {
                return false;
            }
        }
        return false;
    }

    @Override // com.bytedance.pangle.g.r, java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.f28809a;
    }

    @Override // java.security.cert.Certificate
    public final int hashCode() {
        if (this.f28810b == -1) {
            try {
                this.f28810b = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.f28810b = 0;
            }
        }
        return this.f28810b;
    }
}
