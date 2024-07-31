package com.amap.api.col.p0463l;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.amap.api.col.3l.k6 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RSAAESEncryptProcessor extends EncryptProcessor {
    public RSAAESEncryptProcessor() {
    }

    @Override // com.amap.api.col.p0463l.EncryptProcessor
    /* renamed from: a */
    protected final byte[] mo54635a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return Encrypt.m54723b(bArr);
    }

    public RSAAESEncryptProcessor(EncryptProcessor encryptProcessor) {
        super(encryptProcessor);
    }
}
