package com.bytedance.adsdk.w.w.xv.c;

import com.bytedance.adsdk.w.w.w.c.l;
import java.util.Deque;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class h extends c {
    @Override // com.bytedance.adsdk.w.w.xv.c.c
    public int b(String str, int i4, Deque<r0.a> deque, s0.a aVar) {
        char a4;
        int i5 = i4;
        while (true) {
            a4 = a(i5, str);
            if (!com.bytedance.adsdk.w.w.ux.a.c(a4) && !com.bytedance.adsdk.w.w.ux.a.d(a4)) {
                break;
            }
            i5++;
        }
        if (a4 != '(') {
            return aVar.a(str, i4, deque);
        }
        deque.push(new l(str.substring(i4, i5)));
        return i5 + 1;
    }
}
