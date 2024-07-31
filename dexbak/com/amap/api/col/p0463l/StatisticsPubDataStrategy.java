package com.amap.api.col.p0463l;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* renamed from: com.amap.api.col.3l.n7 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class StatisticsPubDataStrategy extends UpdateDataStrategy {
    public StatisticsPubDataStrategy() {
    }

    @Override // com.amap.api.col.p0463l.UpdateDataStrategy
    /* renamed from: b */
    protected final byte[] mo54164b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        stringBuffer.append(" ");
        stringBuffer.append(UUID.randomUUID().toString());
        stringBuffer.append(" ");
        if (stringBuffer.length() != 53) {
            return new byte[0];
        }
        byte[] m54189o = C1925p4.m54189o(stringBuffer.toString());
        byte[] bArr2 = new byte[m54189o.length + bArr.length];
        System.arraycopy(m54189o, 0, bArr2, 0, m54189o.length);
        System.arraycopy(bArr, 0, bArr2, m54189o.length, bArr.length);
        return bArr2;
    }

    public StatisticsPubDataStrategy(UpdateDataStrategy updateDataStrategy) {
        super(updateDataStrategy);
    }
}
