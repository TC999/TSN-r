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
/* compiled from: RSAAESEncryptProcessor.java */
/* renamed from: com.amap.api.col.3l.l6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class l6 extends j6 {
    public l6() {
    }

    @Override // com.amap.api.col.p0003l.j6
    protected final byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return j4.b(bArr);
    }

    public l6(j6 j6Var) {
        super(j6Var);
    }
}
