package com.amap.api.col.s;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: StatisticsPubDataStrategy.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class o3 extends p3 {
    public o3() {
    }

    @Override // com.amap.api.col.s.p3
    protected final byte[] b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        stringBuffer.append(" ");
        stringBuffer.append(UUID.randomUUID().toString());
        stringBuffer.append(" ");
        if (stringBuffer.length() != 53) {
            return new byte[0];
        }
        byte[] o4 = j1.o(stringBuffer.toString());
        byte[] bArr2 = new byte[o4.length + bArr.length];
        System.arraycopy(o4, 0, bArr2, 0, o4.length);
        System.arraycopy(bArr, 0, bArr2, o4.length, bArr.length);
        return bArr2;
    }

    public o3(p3 p3Var) {
        super(p3Var);
    }
}
