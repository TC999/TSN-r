package com.amap.api.col.p0463l;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.amap.api.col.3l.j7 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class EncryptRsaDataStrategy extends UpdateDataStrategy {

    /* renamed from: c */
    private EncryptProcessor f4581c;

    public EncryptRsaDataStrategy() {
        this.f4581c = new RSAAESEncryptProcessor();
    }

    @Override // com.amap.api.col.p0463l.UpdateDataStrategy
    /* renamed from: b */
    protected final byte[] mo54164b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return this.f4581c.m54710b(bArr);
    }

    public EncryptRsaDataStrategy(UpdateDataStrategy updateDataStrategy) {
        super(updateDataStrategy);
        this.f4581c = new RSAAESEncryptProcessor();
    }
}
