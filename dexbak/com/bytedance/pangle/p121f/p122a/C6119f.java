package com.bytedance.pangle.p121f.p122a;

/* renamed from: com.bytedance.pangle.f.a.f */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6119f {

    /* renamed from: a */
    int[] f22005a;

    /* renamed from: b */
    int[] f22006b;

    /* renamed from: a */
    public final String m37147a(int i) {
        int[] iArr;
        if (i < 0 || (iArr = this.f22005a) == null || i >= iArr.length) {
            return null;
        }
        int i2 = iArr[i];
        int m37146a = m37146a(this.f22006b, i2);
        StringBuilder sb = new StringBuilder(m37146a);
        while (m37146a != 0) {
            i2 += 2;
            sb.append((char) m37146a(this.f22006b, i2));
            m37146a--;
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static final int m37146a(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
    }
}
