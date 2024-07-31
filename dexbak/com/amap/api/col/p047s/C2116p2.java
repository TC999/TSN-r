package com.amap.api.col.p047s;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: RSAAESEncryptProcessor.java */
/* renamed from: com.amap.api.col.s.p2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2116p2 extends AbstractC2102n2 {
    public C2116p2() {
    }

    @Override // com.amap.api.col.p047s.AbstractC2102n2
    /* renamed from: a */
    protected final byte[] mo52694a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return C2040d1.m53095b(bArr);
    }

    public C2116p2(AbstractC2102n2 abstractC2102n2) {
        super(abstractC2102n2);
    }
}
