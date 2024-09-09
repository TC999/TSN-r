package com.qq.e.comm.plugin.rewardvideo;

import com.qq.e.comm.plugin.g0.y;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class l {
    public static int a(com.qq.e.comm.plugin.g0.e eVar) {
        y i02;
        if (eVar == null || !eVar.o().j() || (i02 = eVar.i0()) == null) {
            return 0;
        }
        return i02.p();
    }

    public static boolean a(int i4) {
        return i4 == 2 || i4 == 7 || i4 == 8 || i4 == 9;
    }

    public static boolean b(int i4) {
        return i4 == 5 || i4 == 6 || i4 == 8 || i4 == 9;
    }

    public static boolean c(int i4) {
        return i4 == 4 || i4 == 7;
    }

    public static boolean d(int i4) {
        return i4 >= 1 && i4 <= 9;
    }
}
