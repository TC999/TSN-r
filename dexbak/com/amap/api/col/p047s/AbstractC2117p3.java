package com.amap.api.col.p047s;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: UpdateDataStrategy.java */
/* renamed from: com.amap.api.col.s.p3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractC2117p3 {

    /* renamed from: a */
    AbstractC2117p3 f6366a;

    /* renamed from: b */
    byte[] f6367b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC2117p3() {
    }

    /* renamed from: a */
    public final byte[] m52693a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] mo52644b = mo52644b(this.f6367b);
        AbstractC2117p3 abstractC2117p3 = this.f6366a;
        if (abstractC2117p3 != null) {
            abstractC2117p3.f6367b = mo52644b;
            return abstractC2117p3.m52693a();
        }
        return mo52644b;
    }

    /* renamed from: b */
    protected abstract byte[] mo52644b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    /* renamed from: c */
    public void mo52692c(byte[] bArr) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC2117p3(AbstractC2117p3 abstractC2117p3) {
        this.f6366a = abstractC2117p3;
    }
}
