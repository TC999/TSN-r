package com.bytedance.adsdk.w.w.xv.c;

import com.bytedance.adsdk.w.w.sr.sr;
import java.util.Deque;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends c {
    @Override // com.bytedance.adsdk.w.w.xv.c.c
    public int b(String str, int i4, Deque<r0.a> deque, s0.a aVar) {
        if (',' != a(i4, str)) {
            return aVar.a(str, i4, deque);
        }
        deque.push(new com.bytedance.adsdk.w.w.w.c.i(sr.COMMA));
        return i4 + 1;
    }
}
