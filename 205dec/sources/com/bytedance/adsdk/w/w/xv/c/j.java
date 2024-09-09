package com.bytedance.adsdk.w.w.xv.c;

import com.bytedance.adsdk.w.w.w.c.m;
import com.bytedance.adsdk.w.w.w.c.n;
import java.util.Deque;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class j extends c {
    private int d(String str, int i4, Deque<r0.a> deque) {
        int i5;
        int i6 = 0;
        while (true) {
            i5 = i6 + i4;
            char a4 = a(i5, str);
            if (!com.bytedance.adsdk.w.w.ux.a.c(a4) && !com.bytedance.adsdk.w.w.ux.a.d(a4) && '.' != a4 && '[' != a4 && ']' != a4 && '_' != a4 && '-' != a4) {
                break;
            }
            i6++;
        }
        String substring = str.substring(i4, i5);
        if (com.bytedance.adsdk.w.w.sr.c.c(substring) != null) {
            deque.push(new n(substring));
        } else {
            deque.push(new m(substring));
        }
        return i5;
    }

    @Override // com.bytedance.adsdk.w.w.xv.c.c
    public int b(String str, int i4, Deque<r0.a> deque, s0.a aVar) {
        if (!com.bytedance.adsdk.w.w.ux.a.c(a(i4, str))) {
            return aVar.a(str, i4, deque);
        }
        return d(str, i4, deque);
    }
}
