package com.amap.api.col.p047s;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: EncryptRsaDataStrategy.java */
/* renamed from: com.amap.api.col.s.k3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2087k3 extends AbstractC2117p3 {

    /* renamed from: c */
    private AbstractC2102n2 f6253c;

    public C2087k3() {
        this.f6253c = new C2116p2();
    }

    @Override // com.amap.api.col.p047s.AbstractC2117p3
    /* renamed from: b */
    protected final byte[] mo52644b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return this.f6253c.m52733b(bArr);
    }

    public C2087k3(AbstractC2117p3 abstractC2117p3) {
        super(abstractC2117p3);
        this.f6253c = new C2116p2();
    }
}
