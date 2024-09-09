package com.bytedance.adsdk.w.w.xv.c;

import java.util.Deque;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c {
    /* JADX INFO: Access modifiers changed from: protected */
    public char a(int i4, String str) {
        if (i4 >= str.length()) {
            return (char) 26;
        }
        return str.charAt(i4);
    }

    public abstract int b(String str, int i4, Deque<r0.a> deque, s0.a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(int i4, String str) {
        while (com.bytedance.adsdk.w.w.ux.a.a(a(i4, str))) {
            i4++;
        }
        return i4;
    }

    protected int getIdentifier(int i4, String str) {
        int i5 = 0;
        while (true) {
            int i6 = i5 + i4;
            char a4 = a(i6, str);
            if (!com.bytedance.adsdk.w.w.ux.a.c(a4) && !com.bytedance.adsdk.w.w.ux.a.d(a4)) {
                return i6;
            }
            i5++;
        }
    }
}
