package com.p518qq.p519e.comm.util;

import android.util.Log;

/* renamed from: com.qq.e.comm.util.GDTLogger */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class GDTLogger {
    public static final boolean DEBUG_ENABLE = false;

    /* renamed from: d */
    public static void m20308d(String str) {
    }

    /* renamed from: e */
    public static void m20307e(String str) {
        Log.e("gdt_ad_mob", str);
    }

    /* renamed from: e */
    public static void m20306e(String str, Throwable th) {
        if (th == null) {
            Log.e("gdt_ad_mob", str);
        } else {
            Log.e("gdt_ad_mob", str, th);
        }
    }

    /* renamed from: i */
    public static void m20305i(String str) {
    }

    /* renamed from: w */
    public static void m20304w(String str) {
        Log.e("gdt_ad_mob", str);
    }

    /* renamed from: w */
    public static void m20303w(String str, Throwable th) {
        if (th == null) {
            Log.w("gdt_ad_mob", str);
        } else {
            Log.w("gdt_ad_mob", str, th);
        }
    }
}
