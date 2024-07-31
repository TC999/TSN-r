package com.amap.api.col.p047s;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: ByteJoinDataStrategy.java */
/* renamed from: com.amap.api.col.s.j3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2081j3 extends AbstractC2117p3 {

    /* renamed from: c */
    ByteArrayOutputStream f6225c;

    public C2081j3() {
        this.f6225c = new ByteArrayOutputStream();
    }

    @Override // com.amap.api.col.p047s.AbstractC2117p3
    /* renamed from: b */
    protected final byte[] mo52644b(byte[] bArr) {
        byte[] byteArray = this.f6225c.toByteArray();
        try {
            this.f6225c.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f6225c = new ByteArrayOutputStream();
        return byteArray;
    }

    @Override // com.amap.api.col.p047s.AbstractC2117p3
    /* renamed from: c */
    public final void mo52692c(byte[] bArr) {
        try {
            this.f6225c.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public C2081j3(AbstractC2117p3 abstractC2117p3) {
        super(abstractC2117p3);
        this.f6225c = new ByteArrayOutputStream();
    }
}
