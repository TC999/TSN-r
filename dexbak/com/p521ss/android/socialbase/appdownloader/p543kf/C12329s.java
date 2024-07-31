package com.p521ss.android.socialbase.appdownloader.p543kf;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;

/* renamed from: com.ss.android.socialbase.appdownloader.kf.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12329s {

    /* renamed from: a */
    private static String f34772a;

    /* renamed from: bl */
    private static String f34773bl;

    /* renamed from: n */
    private static Boolean f34774n;

    /* renamed from: ok */
    private static String f34775ok;

    /* renamed from: s */
    private static String f34776s;

    /* renamed from: a */
    public static boolean m18171a(Context context) {
        return context != null && m18158s(context) == 0 && m18166kf();
    }

    /* renamed from: bl */
    public static String m18169bl() {
        if (f34773bl == null) {
            f34773bl = m18161ok("getReleaseType");
        }
        return f34773bl;
    }

    /* renamed from: h */
    public static String m18167h() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: kf */
    public static boolean m18166kf() {
        return m18165n() && m18170a(m18172a(), m18164ok()) && m18163ok(Process.myUid()) == 0;
    }

    /* renamed from: n */
    public static boolean m18165n() {
        if (f34774n == null) {
            f34774n = Boolean.FALSE;
            try {
                f34774n = Boolean.valueOf("156".equals(m18160ok("ro.config.hw_optb", "0")) && "true".equals(m18160ok("hw_mc.pure_mode.enable", "false")));
            } catch (Exception unused) {
            }
        }
        return f34774n.booleanValue();
    }

    /* renamed from: ok */
    public static boolean m18162ok(Context context) {
        return context != null && m18168bl(context) == 0 && m18165n();
    }

    /* renamed from: s */
    public static String m18159s() {
        if (f34776s == null) {
            f34776s = m18161ok("getBuildVersion");
        }
        return f34776s;
    }

    /* renamed from: a */
    public static String m18172a() {
        if (f34772a == null) {
            f34772a = m18161ok("getVersion");
        }
        return f34772a;
    }

    /* renamed from: ok */
    public static String m18164ok() {
        if (f34775ok == null) {
            f34775ok = m18161ok("getApiVersion");
        }
        return f34775ok;
    }

    /* renamed from: bl */
    public static int m18168bl(Context context) {
        if (context != null) {
            if (m18170a(m18172a(), m18164ok())) {
                return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1;
            }
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
        }
        return 1;
    }

    /* renamed from: s */
    public static int m18158s(Context context) {
        return (context == null || Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) ? 1 : 0;
    }

    /* renamed from: a */
    private static boolean m18170a(String str, String str2) {
        return !TextUtils.isEmpty(str2) && str.startsWith("3");
    }

    /* renamed from: ok */
    private static String m18160ok(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* renamed from: ok */
    private static int m18163ok(int i) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.UserHandleEx");
            return ((Integer) cls.getMethod("getUserId", Integer.TYPE).invoke(cls, Integer.valueOf(i))).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return 1;
        }
    }

    /* renamed from: ok */
    private static String m18161ok(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
