package com.amap.api.col.p047s;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* compiled from: StatisticsPubDataStrategy.java */
/* renamed from: com.amap.api.col.s.o3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2109o3 extends AbstractC2117p3 {
    public C2109o3() {
    }

    @Override // com.amap.api.col.p047s.AbstractC2117p3
    /* renamed from: b */
    protected final byte[] mo52644b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        stringBuffer.append(" ");
        stringBuffer.append(UUID.randomUUID().toString());
        stringBuffer.append(" ");
        if (stringBuffer.length() != 53) {
            return new byte[0];
        }
        byte[] m52862o = C2079j1.m52862o(stringBuffer.toString());
        byte[] bArr2 = new byte[m52862o.length + bArr.length];
        System.arraycopy(m52862o, 0, bArr2, 0, m52862o.length);
        System.arraycopy(bArr, 0, bArr2, m52862o.length, bArr.length);
        return bArr2;
    }

    public C2109o3(AbstractC2117p3 abstractC2117p3) {
        super(abstractC2117p3);
    }
}
