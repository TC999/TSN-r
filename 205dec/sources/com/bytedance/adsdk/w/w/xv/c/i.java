package com.bytedance.adsdk.w.w.xv.c;

import com.bytedance.adsdk.w.w.w.c.r;
import java.util.Deque;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class i extends c {
    @Override // com.bytedance.adsdk.w.w.xv.c.c
    public int b(String str, int i4, Deque<r0.a> deque, s0.a aVar) {
        if ('\'' != a(i4, str)) {
            return aVar.a(str, i4, deque);
        }
        int i5 = i4 + 1;
        int length = str.length();
        int i6 = i5;
        while (i6 < length && a(i6, str) != '\'') {
            i6++;
        }
        if (a(i6, str) == '\'') {
            deque.push(new r(str.substring(i5, i6)));
            return i6 + 1;
        }
        throw new com.bytedance.adsdk.w.c.c("\u5b57\u7b26\u4e32\u8868\u8fbe\u5f0f\u6ca1\u6709\u88ab'\u5305\u56f4", str.substring(i5 - 1));
    }
}
