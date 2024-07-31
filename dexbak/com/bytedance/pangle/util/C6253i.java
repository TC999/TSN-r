package com.bytedance.pangle.util;

import android.os.Build;

/* renamed from: com.bytedance.pangle.util.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C6253i {
    /* renamed from: a */
    public static boolean m36887a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* renamed from: b */
    public static boolean m36886b() {
        return Build.VERSION.SDK_INT < 21;
    }

    /* renamed from: c */
    public static boolean m36885c() {
        int i = Build.VERSION.SDK_INT;
        return i >= 21 && i <= 23;
    }

    /* renamed from: d */
    public static boolean m36884d() {
        int i = Build.VERSION.SDK_INT;
        return i >= 21 && i < 23;
    }

    /* renamed from: e */
    public static boolean m36883e() {
        int i = Build.VERSION.SDK_INT;
        return i >= 21 && i <= 25;
    }

    /* renamed from: f */
    public static boolean m36882f() {
        int i = Build.VERSION.SDK_INT;
        return i >= 26 && i <= 28;
    }

    /* renamed from: g */
    public static boolean m36881g() {
        int i = Build.VERSION.SDK_INT;
        return i >= 29 && i <= 30;
    }

    /* renamed from: h */
    public static boolean m36880h() {
        return Build.VERSION.SDK_INT > 23;
    }

    /* renamed from: i */
    public static boolean m36879i() {
        return Build.VERSION.SDK_INT >= 26;
    }

    /* renamed from: j */
    public static boolean m36878j() {
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            return i == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    /* renamed from: k */
    public static boolean m36877k() {
        int i = Build.VERSION.SDK_INT;
        if (i < 31) {
            return i == 30 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }
}
