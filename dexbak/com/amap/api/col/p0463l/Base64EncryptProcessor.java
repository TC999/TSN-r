package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.h6 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Base64EncryptProcessor extends EncryptProcessor {
    Base64EncryptProcessor() {
    }

    @Override // com.amap.api.col.p0463l.EncryptProcessor
    /* renamed from: a */
    protected final byte[] mo54635a(byte[] bArr) {
        return C1925p4.m54189o(Encrypt.m54716i(bArr));
    }

    public Base64EncryptProcessor(EncryptProcessor encryptProcessor) {
        super(encryptProcessor);
    }
}
