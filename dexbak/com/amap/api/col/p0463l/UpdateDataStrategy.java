package com.amap.api.col.p0463l;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.amap.api.col.3l.o7 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class UpdateDataStrategy {

    /* renamed from: a */
    UpdateDataStrategy f4807a;

    /* renamed from: b */
    byte[] f4808b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateDataStrategy() {
    }

    /* renamed from: a */
    public final byte[] m54363a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] mo54164b = mo54164b(this.f4808b);
        UpdateDataStrategy updateDataStrategy = this.f4807a;
        if (updateDataStrategy != null) {
            updateDataStrategy.f4808b = mo54164b;
            return updateDataStrategy.m54363a();
        }
        return mo54164b;
    }

    /* renamed from: b */
    protected abstract byte[] mo54164b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    /* renamed from: c */
    public void mo54362c(byte[] bArr) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateDataStrategy(UpdateDataStrategy updateDataStrategy) {
        this.f4807a = updateDataStrategy;
    }
}
