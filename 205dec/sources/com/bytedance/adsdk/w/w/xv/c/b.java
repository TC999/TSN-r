package com.bytedance.adsdk.w.w.xv.c;

import com.bytedance.adsdk.w.w.sr.xv;
import java.util.Deque;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b extends c {
    @Override // com.bytedance.adsdk.w.w.xv.c.c
    public int b(String str, int i4, Deque<r0.a> deque, s0.a aVar) {
        if (!com.bytedance.adsdk.w.w.ux.a.b(a(i4, str))) {
            return aVar.a(str, i4, deque);
        }
        int i5 = i4 + 1;
        String str2 = new String(new char[]{a(i4, str), a(i5, str)});
        if (xv.c(str2) != null) {
            deque.push(new com.bytedance.adsdk.w.w.w.c.f(xv.c(str2)));
            return i4 + 2;
        }
        String valueOf = String.valueOf(a(i4, str));
        if (xv.c(valueOf) != null) {
            deque.push(new com.bytedance.adsdk.w.w.w.c.f(xv.c(valueOf)));
            return i5;
        }
        throw new IllegalArgumentException("\u65e0\u6cd5\u8bc6\u522b:" + valueOf + "\u68c0\u67e5:" + str.substring(0, i4));
    }
}
