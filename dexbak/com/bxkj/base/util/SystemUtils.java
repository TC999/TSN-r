package com.bxkj.base.util;

import android.content.Context;
import android.os.Build;

/* renamed from: com.bxkj.base.util.z */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SystemUtils {
    /* renamed from: a */
    private static String m44005a(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    /* renamed from: b */
    public static synchronized String m44004b(Context context) {
        String string;
        synchronized (SystemUtils.class) {
            try {
                string = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return string;
    }

    /* renamed from: c */
    public static String m44003c() {
        HarmonyUtils harmonyUtils = HarmonyUtils.f14924a;
        if (harmonyUtils.m44071d()) {
            return harmonyUtils.m44073b();
        }
        return Build.VERSION.RELEASE;
    }

    /* renamed from: d */
    public static String m44002d() {
        return m44005a(Build.MANUFACTURER);
    }

    /* renamed from: e */
    public static String m44001e() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? m44005a(str2) : str2;
    }

    /* renamed from: f */
    public static String m44000f() {
        return HarmonyUtils.f14924a.m44071d() ? "HarmonyOS" : "Android";
    }

    /* renamed from: g */
    public static int m43999g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: h */
    public static String m43998h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "1.0";
        }
    }
}
