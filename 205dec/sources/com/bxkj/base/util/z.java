package com.bxkj.base.util;

import android.content.Context;
import android.os.Build;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SystemUtils.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class z {
    private static String a(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    public static synchronized String b(Context context) {
        String string;
        synchronized (z.class) {
            try {
                string = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return string;
    }

    public static String c() {
        k kVar = k.f18408a;
        if (kVar.d()) {
            return kVar.b();
        }
        return Build.VERSION.RELEASE;
    }

    public static String d() {
        return a(Build.MANUFACTURER);
    }

    public static String e() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        return str2.startsWith(str) ? a(str2) : str2;
    }

    public static String f() {
        return k.f18408a.d() ? "HarmonyOS" : "Android";
    }

    public static int g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static String h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e4) {
            e4.printStackTrace();
            return "1.0";
        }
    }
}
