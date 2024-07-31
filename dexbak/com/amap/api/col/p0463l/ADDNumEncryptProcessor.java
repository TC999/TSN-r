package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.g6 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ADDNumEncryptProcessor extends EncryptProcessor {
    ADDNumEncryptProcessor() {
    }

    @Override // com.amap.api.col.p0463l.EncryptProcessor
    /* renamed from: a */
    protected final byte[] mo54635a(byte[] bArr) {
        return C1925p4.m54189o(C1925p4.m54197g(bArr) + "||1");
    }

    public ADDNumEncryptProcessor(EncryptProcessor encryptProcessor) {
        super(encryptProcessor);
    }
}
