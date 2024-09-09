package com.ss.android.socialbase.appdownloader.kf;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.acse.ottn.f3;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static String f49144a;
    private static String bl;

    /* renamed from: n  reason: collision with root package name */
    private static Boolean f49145n;
    private static String ok;

    /* renamed from: s  reason: collision with root package name */
    private static String f49146s;

    public static boolean a(Context context) {
        return context != null && s(context) == 0 && kf();
    }

    public static String bl() {
        if (bl == null) {
            bl = ok("getReleaseType");
        }
        return bl;
    }

    public static String h() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean kf() {
        return n() && a(a(), ok()) && ok(Process.myUid()) == 0;
    }

    public static boolean n() {
        if (f49145n == null) {
            f49145n = Boolean.FALSE;
            try {
                f49145n = Boolean.valueOf("156".equals(ok("ro.config.hw_optb", "0")) && "true".equals(ok("hw_mc.pure_mode.enable", "false")));
            } catch (Exception unused) {
            }
        }
        return f49145n.booleanValue();
    }

    public static boolean ok(Context context) {
        return context != null && bl(context) == 0 && n();
    }

    public static String s() {
        if (f49146s == null) {
            f49146s = ok("getBuildVersion");
        }
        return f49146s;
    }

    public static String a() {
        if (f49144a == null) {
            f49144a = ok("getVersion");
        }
        return f49144a;
    }

    public static String ok() {
        if (ok == null) {
            ok = ok("getApiVersion");
        }
        return ok;
    }

    public static int bl(Context context) {
        if (context != null) {
            if (a(a(), ok())) {
                return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1;
            }
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
        }
        return 1;
    }

    public static int s(Context context) {
        return (context == null || Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) ? 1 : 0;
    }

    private static boolean a(String str, String str2) {
        return !TextUtils.isEmpty(str2) && str.startsWith("3");
    }

    private static String ok(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod(f3.f5657f, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static int ok(int i4) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.UserHandleEx");
            return ((Integer) cls.getMethod("getUserId", Integer.TYPE).invoke(cls, Integer.valueOf(i4))).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return 1;
        }
    }

    private static String ok(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
