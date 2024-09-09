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
/* compiled from: UpdateDataStrategy.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class p3 {

    /* renamed from: a  reason: collision with root package name */
    p3 f10094a;

    /* renamed from: b  reason: collision with root package name */
    byte[] f10095b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p3() {
    }

    public final byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] b4 = b(this.f10095b);
        p3 p3Var = this.f10094a;
        if (p3Var != null) {
            p3Var.f10095b = b4;
            return p3Var.a();
        }
        return b4;
    }

    protected abstract byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public void c(byte[] bArr) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p3(p3 p3Var) {
        this.f10094a = p3Var;
    }
}
