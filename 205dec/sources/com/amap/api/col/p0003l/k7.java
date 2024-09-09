package com.amap.api.col.p0003l;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: EncryptRsaDataStrategy.java */
/* renamed from: com.amap.api.col.3l.k7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class k7 extends p7 {

    /* renamed from: c  reason: collision with root package name */
    private j6 f8250c;

    public k7() {
        this.f8250c = new l6();
    }

    @Override // com.amap.api.col.p0003l.p7
    protected final byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return this.f8250c.b(bArr);
    }

    public k7(p7 p7Var) {
        super(p7Var);
        this.f8250c = new l6();
    }
}
