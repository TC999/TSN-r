package com.amap.api.col.p047s;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: EncryptProcessor.java */
/* renamed from: com.amap.api.col.s.n2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractC2102n2 {

    /* renamed from: a */
    AbstractC2102n2 f6311a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC2102n2() {
    }

    /* renamed from: a */
    protected abstract byte[] mo52694a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    /* renamed from: b */
    public final byte[] m52733b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        AbstractC2102n2 abstractC2102n2 = this.f6311a;
        if (abstractC2102n2 != null) {
            bArr = abstractC2102n2.m52733b(bArr);
        }
        return mo52694a(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC2102n2(AbstractC2102n2 abstractC2102n2) {
        this.f6311a = abstractC2102n2;
    }
}
