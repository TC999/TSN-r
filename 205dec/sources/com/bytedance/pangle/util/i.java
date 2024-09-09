package com.bytedance.pangle.util;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class i {
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT < 21;
    }

    public static boolean c() {
        int i4 = Build.VERSION.SDK_INT;
        return i4 >= 21 && i4 <= 23;
    }

    public static boolean d() {
        int i4 = Build.VERSION.SDK_INT;
        return i4 >= 21 && i4 < 23;
    }

    public static boolean e() {
        int i4 = Build.VERSION.SDK_INT;
        return i4 >= 21 && i4 <= 25;
    }

    public static boolean f() {
        int i4 = Build.VERSION.SDK_INT;
        return i4 >= 26 && i4 <= 28;
    }

    public static boolean g() {
        int i4 = Build.VERSION.SDK_INT;
        return i4 >= 29 && i4 <= 30;
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static boolean i() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean j() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 28) {
            return i4 == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean k() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 31) {
            return i4 == 30 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }
}
