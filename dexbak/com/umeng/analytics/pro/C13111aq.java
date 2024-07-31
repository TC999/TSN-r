package com.umeng.analytics.pro;

import android.os.Build;
import android.text.TextUtils;

/* compiled from: RomUtils.java */
/* renamed from: com.umeng.analytics.pro.aq */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13111aq {

    /* renamed from: a */
    private static String f37654a = "";

    /* renamed from: b */
    private static String f37655b = "";

    /* renamed from: c */
    private static final String f37656c = "hw_sc.build.platform.version";

    /* renamed from: d */
    private static final String f37657d = "ro.build.version.emui";

    /* renamed from: e */
    private static final String f37658e = "ro.build.version.magic";

    /* renamed from: f */
    private static final String f37659f = "ro.miui.ui.version.name";

    /* renamed from: g */
    private static final String f37660g = "ro.build.version.opporom";

    /* renamed from: h */
    private static final String f37661h = "ro.vivo.os.name";

    /* renamed from: i */
    private static final String f37662i = "ro.vivo.os.version";

    /* renamed from: j */
    private static final String f37663j = "ro.build.version.oplusrom";

    /* renamed from: k */
    private static final String f37664k = "ro.rom.version";

    /* renamed from: a */
    private static boolean m14709a() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static String m14707b(String str) {
        if (TextUtils.isEmpty(f37654a)) {
            m14704e(str);
        }
        return f37655b;
    }

    /* renamed from: c */
    public static String m14706c(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll(" ", "").toUpperCase();
    }

    /* renamed from: d */
    private static String m14705d(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: e */
    private static void m14704e(String str) {
        try {
            String m14706c = m14706c(str);
            char c = 65535;
            switch (m14706c.hashCode()) {
                case -1881642058:
                    if (m14706c.equals("REALME")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1706170181:
                    if (m14706c.equals("XIAOMI")) {
                        c = 2;
                        break;
                    }
                    break;
                case -602397472:
                    if (m14706c.equals("ONEPLUS")) {
                        c = 7;
                        break;
                    }
                    break;
                case 2432928:
                    if (m14706c.equals("OPPO")) {
                        c = 5;
                        break;
                    }
                    break;
                case 2634924:
                    if (m14706c.equals("VIVO")) {
                        c = 6;
                        break;
                    }
                    break;
                case 68924490:
                    if (m14706c.equals("HONOR")) {
                        c = 1;
                        break;
                    }
                    break;
                case 77852109:
                    if (m14706c.equals("REDMI")) {
                        c = 3;
                        break;
                    }
                    break;
                case 2141820391:
                    if (m14706c.equals("HUAWEI")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (m14709a()) {
                        f37655b = m14705d(f37656c);
                        f37654a = "HarmonyOS";
                        return;
                    }
                    f37654a = "EMUI";
                    f37655b = m14705d(f37657d);
                    return;
                case 1:
                    if (!TextUtils.isEmpty(m14705d(f37658e))) {
                        f37654a = "MagicUI";
                        f37655b = m14705d(f37658e);
                        return;
                    }
                    f37654a = "EMUI";
                    f37655b = m14705d(f37657d);
                    return;
                case 2:
                case 3:
                    f37654a = "MIUI";
                    f37655b = m14705d(f37659f);
                    return;
                case 4:
                case 5:
                    f37654a = "ColorOS";
                    f37655b = m14705d(f37660g);
                    return;
                case 6:
                    f37654a = "Funtouch";
                    f37655b = m14705d(f37662i);
                    return;
                case 7:
                    f37654a = "HydrogenOS";
                    String m14705d = m14705d(f37664k);
                    if (TextUtils.isEmpty(m14705d)) {
                        f37654a = "ColorOS";
                        m14705d = m14705d(f37663j);
                    }
                    f37655b = m14705d;
                    return;
                default:
                    f37654a = "Android";
                    f37655b = Build.VERSION.RELEASE;
                    return;
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static String m14708a(String str) {
        if (TextUtils.isEmpty(f37654a)) {
            m14704e(str);
        }
        return f37654a;
    }
}
