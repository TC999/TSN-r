package com.ss.android.socialbase.appdownloader.f;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.acse.ottn.f3;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private static String f49088c;
    private static String sr;
    private static Boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private static String f49089w;
    private static String xv;

    public static boolean c(Context context) {
        return context != null && xv(context) == 0 && ux();
    }

    public static boolean f() {
        return ux() && w(w(), c()) && c(Process.myUid()) == 0;
    }

    public static String r() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String sr() {
        if (sr == null) {
            sr = c("getBuildVersion");
        }
        return sr;
    }

    public static boolean ux() {
        if (ux == null) {
            ux = Boolean.FALSE;
            try {
                ux = Boolean.valueOf("156".equals(c("ro.config.hw_optb", "0")) && "true".equals(c("hw_mc.pure_mode.enable", "false")));
            } catch (Exception unused) {
            }
        }
        return ux.booleanValue();
    }

    public static boolean w(Context context) {
        return context != null && sr(context) == 0 && f();
    }

    public static String xv() {
        if (xv == null) {
            xv = c("getReleaseType");
        }
        return xv;
    }

    public static String c() {
        if (f49088c == null) {
            f49088c = c("getApiVersion");
        }
        return f49088c;
    }

    public static String w() {
        if (f49089w == null) {
            f49089w = c("getVersion");
        }
        return f49089w;
    }

    public static int sr(Context context) {
        return (context == null || Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) ? 1 : 0;
    }

    public static int xv(Context context) {
        if (context != null) {
            if (w(w(), c())) {
                return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1;
            }
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
        }
        return 1;
    }

    private static String c(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod(f3.f5657f, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static boolean w(String str, String str2) {
        return !TextUtils.isEmpty(str2) && str.startsWith("3");
    }

    private static int c(int i4) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.UserHandleEx");
            return ((Integer) cls.getMethod("getUserId", Integer.TYPE).invoke(cls, Integer.valueOf(i4))).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return 1;
        }
    }

    private static String c(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
