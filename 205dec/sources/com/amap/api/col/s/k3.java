package com.amap.api.col.s;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: EncryptRsaDataStrategy.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class k3 extends p3 {

    /* renamed from: c  reason: collision with root package name */
    private n2 f9981c;

    public k3() {
        this.f9981c = new p2();
    }

    @Override // com.amap.api.col.s.p3
    protected final byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return this.f9981c.b(bArr);
    }

    public k3(p3 p3Var) {
        super(p3Var);
        this.f9981c = new p2();
    }
}
