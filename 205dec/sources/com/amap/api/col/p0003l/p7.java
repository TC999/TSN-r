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
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: UpdateDataStrategy.java */
/* renamed from: com.amap.api.col.3l.p7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class p7 {

    /* renamed from: a  reason: collision with root package name */
    p7 f8646a;

    /* renamed from: b  reason: collision with root package name */
    byte[] f8647b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p7() {
    }

    public final byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] b4 = b(this.f8647b);
        p7 p7Var = this.f8646a;
        if (p7Var != null) {
            p7Var.f8647b = b4;
            return p7Var.a();
        }
        return b4;
    }

    protected abstract byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public void c(byte[] bArr) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p7(p7 p7Var) {
        this.f8646a = p7Var;
    }
}
