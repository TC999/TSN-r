package com.bytedance.adsdk.ugeno.swiper;

import java.util.Collection;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {
    public static int a(boolean z3, int i4, int i5) {
        if (i5 != 0 && z3) {
            int i6 = i4 - 1073741823;
            int abs = Math.abs(i6) % i5;
            return (i6 >= 0 || abs == 0) ? abs : i5 - abs;
        }
        return i4;
    }

    public static boolean b(int i4, Collection<?> collection) {
        return i4 >= 0 && i4 < collection.size();
    }
}
