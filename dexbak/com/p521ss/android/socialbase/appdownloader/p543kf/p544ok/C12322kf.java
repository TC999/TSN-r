package com.p521ss.android.socialbase.appdownloader.p543kf.p544ok;

import java.io.IOException;

/* renamed from: com.ss.android.socialbase.appdownloader.kf.ok.kf */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12322kf {

    /* renamed from: a */
    private int[] f34747a;

    /* renamed from: ok */
    private int[] f34748ok;

    private C12322kf() {
    }

    /* renamed from: ok */
    public static C12322kf m18211ok(C12328s c12328s) throws IOException {
        C12319a.m18213ok(c12328s, 1835009);
        int m18180a = c12328s.m18180a();
        int m18180a2 = c12328s.m18180a();
        int m18180a3 = c12328s.m18180a();
        c12328s.m18180a();
        int m18180a4 = c12328s.m18180a();
        int m18180a5 = c12328s.m18180a();
        C12322kf c12322kf = new C12322kf();
        c12322kf.f34748ok = c12328s.m18179a(m18180a2);
        if (m18180a3 != 0) {
            c12328s.m18179a(m18180a3);
        }
        int i = (m18180a5 == 0 ? m18180a : m18180a5) - m18180a4;
        if (i % 4 == 0) {
            c12322kf.f34747a = c12328s.m18179a(i / 4);
            if (m18180a5 != 0) {
                int i2 = m18180a - m18180a5;
                if (i2 % 4 == 0) {
                    c12328s.m18179a(i2 / 4);
                } else {
                    throw new IOException("Style data size is not multiple of 4 (" + i2 + ").");
                }
            }
            return c12322kf;
        }
        throw new IOException("String data size is not multiple of 4 (" + i + ").");
    }

    /* renamed from: ok */
    public String m18212ok(int i) {
        int[] iArr;
        if (i < 0 || (iArr = this.f34748ok) == null || i >= iArr.length) {
            return null;
        }
        int i2 = iArr[i];
        int m18210ok = m18210ok(this.f34747a, i2);
        StringBuilder sb = new StringBuilder(m18210ok);
        while (m18210ok != 0) {
            i2 += 2;
            sb.append((char) m18210ok(this.f34747a, i2));
            m18210ok--;
        }
        return sb.toString();
    }

    /* renamed from: ok */
    private static final int m18210ok(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
    }
}
