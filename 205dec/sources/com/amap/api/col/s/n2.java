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
/* compiled from: EncryptProcessor.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class n2 {

    /* renamed from: a  reason: collision with root package name */
    n2 f10039a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n2() {
    }

    protected abstract byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public final byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        n2 n2Var = this.f10039a;
        if (n2Var != null) {
            bArr = n2Var.b(bArr);
        }
        return a(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n2(n2 n2Var) {
        this.f10039a = n2Var;
    }
}
