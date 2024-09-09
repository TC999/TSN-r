package com.qq.e.comm.plugin.p.j;

import com.qq.e.comm.plugin.p.j.l;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class b implements l {
    @Override // com.qq.e.comm.plugin.p.j.l
    public l.a[] a(long j4, int i4) {
        long j5 = j4 / i4;
        l.a[] aVarArr = new l.a[i4];
        int i5 = 0;
        while (true) {
            int i6 = i4 - 1;
            if (i5 < i6) {
                aVarArr[i5] = new l.a(i5 * j5, j5);
                i5++;
            } else {
                long j6 = i6 * j5;
                aVarArr[i6] = new l.a(j6, j4 - j6);
                return aVarArr;
            }
        }
    }
}
