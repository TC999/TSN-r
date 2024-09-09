package com.bytedance.sdk.openadsdk.core.eq;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.acse.ottn.c4;
import com.acse.ottn.f3;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static String f33191c = null;
    private static int ev = 1;

    /* renamed from: f  reason: collision with root package name */
    private static Boolean f33192f = null;

    /* renamed from: r  reason: collision with root package name */
    private static int f33193r = 1;
    private static String sr;
    private static String ux;

    /* renamed from: w  reason: collision with root package name */
    private static String f33194w;
    private static Boolean xv;

    public static boolean a() {
        Boolean bool = f33192f;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private static int bk() {
        return ev;
    }

    public static void c() {
        if (xv == null) {
            if (!sr() && !xv()) {
                xv = Boolean.FALSE;
                return;
            }
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                xv = Boolean.valueOf(c4.f5363a.equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            } catch (Throwable unused) {
                xv = Boolean.FALSE;
            }
            if (f33191c == null) {
                f33191c = c("getApiVersion");
            }
            if (f33194w == null) {
                f33194w = c("getVersion");
            }
            if (ux == null) {
                ux = c("getReleaseType");
            }
            if (sr == null) {
                sr = c("getBuildVersion");
            }
            if (f33192f == null) {
                f33192f = Boolean.FALSE;
                try {
                    f33192f = Boolean.valueOf("156".equals(w("ro.config.hw_optb", "0")) && "true".equals(w("hw_mc.pure_mode.enable", "false")));
                } catch (Exception unused2) {
                }
            }
            try {
                f33193r = Settings.Secure.getInt(com.bytedance.sdk.openadsdk.core.ls.getContext().getContentResolver(), "pure_enhanced_mode_state", 1);
            } catch (Throwable unused3) {
            }
            try {
                Class<?> cls2 = Class.forName("com.huawei.android.os.UserHandleEx");
                ev = ((Integer) cls2.getMethod("getUserId", Integer.TYPE).invoke(cls2, Integer.valueOf(Process.myUid()))).intValue();
            } catch (Throwable unused4) {
            }
        }
    }

    public static String ev() {
        return sr;
    }

    public static String f() {
        return f33194w;
    }

    public static boolean gd() {
        return k() == 0 && p();
    }

    public static int k() {
        return f33193r;
    }

    public static boolean p() {
        return a() && c(f(), ux()) && bk() == 0;
    }

    public static String r() {
        return ux;
    }

    public static boolean sr() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || !str.toUpperCase().startsWith("HONOR")) {
            String str2 = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str2) || !str2.toUpperCase().startsWith("HONOR")) {
                return false;
            }
        }
        return true;
    }

    public static String ux() {
        return f33191c;
    }

    public static boolean w() {
        Boolean bool = xv;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static boolean xv() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || !str.toUpperCase().startsWith("HUAWEI")) {
            String str2 = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str2) || !str2.toUpperCase().startsWith("HUAWEI")) {
                return false;
            }
        }
        return true;
    }

    private static int w(Context context) {
        if (context != null) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
        }
        return 1;
    }

    private static String w(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod(f3.f5657f, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e4) {
            e4.printStackTrace();
            return str2;
        } catch (Throwable unused) {
            return str2;
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

    public static boolean c(Context context) {
        return context != null && w(context) == 0 && a();
    }

    public static void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            int i4 = 1;
            jSONObject.put("pure_enhanced_mode", gd() ? 1 : 2);
            if (!p()) {
                i4 = 2;
            }
            jSONObject.put("pure_enhanced_mode_enable", i4);
        } catch (Throwable unused) {
        }
    }

    private static boolean c(String str, String str2) {
        return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !str.startsWith("3")) ? false : true;
    }
}
