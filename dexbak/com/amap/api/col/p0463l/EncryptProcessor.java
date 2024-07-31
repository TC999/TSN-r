package com.amap.api.col.p0463l;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.amap.api.col.3l.i6 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class EncryptProcessor {

    /* renamed from: a */
    EncryptProcessor f4508a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EncryptProcessor() {
    }

    /* renamed from: a */
    protected abstract byte[] mo54635a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    /* renamed from: b */
    public final byte[] m54710b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        EncryptProcessor encryptProcessor = this.f4508a;
        if (encryptProcessor != null) {
            bArr = encryptProcessor.m54710b(bArr);
        }
        return mo54635a(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EncryptProcessor(EncryptProcessor encryptProcessor) {
        this.f4508a = encryptProcessor;
    }
}
