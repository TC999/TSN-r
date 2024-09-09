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
/* compiled from: EncryptProcessor.java */
/* renamed from: com.amap.api.col.3l.j6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class j6 {

    /* renamed from: a  reason: collision with root package name */
    j6 f8221a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j6() {
    }

    protected abstract byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public final byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        j6 j6Var = this.f8221a;
        if (j6Var != null) {
            bArr = j6Var.b(bArr);
        }
        return a(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j6(j6 j6Var) {
        this.f8221a = j6Var;
    }
}
