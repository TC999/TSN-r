package com.beizi.fusion.p073sm.p074a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* renamed from: com.beizi.fusion.sm.a.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class OAIDRom {
    /* renamed from: a */
    public static String m48127a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            OAIDLog.m48130a("System property invoke error: " + e);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    /* renamed from: b */
    public static boolean m48126b() {
        return !TextUtils.isEmpty(m48127a("ro.build.version.emui", ""));
    }

    /* renamed from: c */
    public static boolean m48125c() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("OPPO") && !str.equalsIgnoreCase("REALME") && TextUtils.isEmpty(m48127a("ro.build.version.opporom", ""))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public static boolean m48124d() {
        return Build.MANUFACTURER.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO") || !TextUtils.isEmpty(m48127a("ro.vivo.os.version", ""));
    }

    /* renamed from: e */
    public static boolean m48123e() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("XIAOMI") && !str.equalsIgnoreCase("REDMI")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public static boolean m48122f() {
        return !TextUtils.isEmpty(m48127a("ro.miui.ui.version.name", ""));
    }

    /* renamed from: g */
    public static boolean m48121g() {
        return Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") || Build.BRAND.equalsIgnoreCase("BLACKSHARK");
    }

    /* renamed from: h */
    public static boolean m48120h() {
        return Build.MANUFACTURER.equalsIgnoreCase("ONEPLUS") || Build.BRAND.equalsIgnoreCase("ONEPLUS");
    }

    /* renamed from: i */
    public static boolean m48119i() {
        return Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG");
    }

    /* renamed from: j */
    public static boolean m48118j() {
        return Build.MANUFACTURER.equalsIgnoreCase("MEIZU") || Build.BRAND.equalsIgnoreCase("MEIZU") || Build.DISPLAY.toUpperCase().contains("FLYME");
    }

    /* renamed from: k */
    public static boolean m48117k() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("LENOVO")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("LENOVO") && !str.equalsIgnoreCase("ZUK")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: l */
    public static boolean m48116l() {
        return Build.MANUFACTURER.equalsIgnoreCase("NUBIA") || Build.BRAND.equalsIgnoreCase("NUBIA");
    }

    /* renamed from: m */
    public static boolean m48115m() {
        return Build.MANUFACTURER.equalsIgnoreCase("ASUS") || Build.BRAND.equalsIgnoreCase("ASUS");
    }

    /* renamed from: n */
    public static boolean m48114n() {
        return Build.MANUFACTURER.equalsIgnoreCase("MOTOLORA") || Build.BRAND.equalsIgnoreCase("MOTOLORA");
    }

    /* renamed from: o */
    public static boolean m48113o() {
        return !TextUtils.isEmpty(m48127a("ro.build.freeme.label", ""));
    }

    /* renamed from: p */
    public static boolean m48112p() {
        return m48127a("ro.odm.manufacturer", "").equalsIgnoreCase("PRIZE");
    }

    /* renamed from: a */
    public static boolean m48129a() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("HUAWEI") && !str.equalsIgnoreCase("HONOR")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m48128a(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
