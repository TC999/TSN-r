package com.bytedance.adsdk.w.w.xv.c;

import com.bytedance.adsdk.w.w.sr.xv;
import com.bytedance.adsdk.w.w.w.c.v;
import java.util.Deque;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends c {
    private boolean d(String str, int i4, Deque<r0.a> deque) {
        if ('-' == a(i4, str)) {
            if (deque.peek() == null || xv.c(deque.peek().c())) {
                if (com.bytedance.adsdk.w.w.ux.a.d(a(i4 + 1, str))) {
                    return true;
                }
                throw new IllegalArgumentException("\u65e0\u6cd5\u8bc6\u522b\u7684-\u7b26\u53f7\uff0c\u4e0d\u662f\u8d1f\u6570\u4e5f\u4e0d\u662f\u64cd\u4f5c\u7b26,\u95ee\u9898\u533a\u95f4:" + str.substring(0, i4));
            }
            return false;
        }
        return com.bytedance.adsdk.w.w.ux.a.d(a(i4, str));
    }

    @Override // com.bytedance.adsdk.w.w.xv.c.c
    public int b(String str, int i4, Deque<r0.a> deque, s0.a aVar) {
        char a4;
        if (!d(str, i4, deque)) {
            return aVar.a(str, i4, deque);
        }
        int i5 = a(i4, str) == '-' ? i4 + 1 : i4;
        boolean z3 = false;
        while (true) {
            a4 = a(i5, str);
            if (com.bytedance.adsdk.w.w.ux.a.d(a4) || (!z3 && a4 == '.')) {
                i5++;
                if (a4 == '.') {
                    z3 = true;
                }
            }
        }
        if (a4 != '.') {
            deque.push(new v(str.substring(i4, i5)));
            return i5;
        }
        throw new IllegalArgumentException("\u975e\u6cd5\u7684\u8d1f\u6570\u683c\u5f0f,\u95ee\u9898\u533a\u95f4:" + str.substring(i4, i5));
    }
}
