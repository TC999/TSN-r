package com.umeng.analytics.pro;

import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.f3;
import com.ss.android.download.api.constant.BaseConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: RomUtils.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    private static String f52546a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f52547b = "";

    /* renamed from: c  reason: collision with root package name */
    private static final String f52548c = "hw_sc.build.platform.version";

    /* renamed from: d  reason: collision with root package name */
    private static final String f52549d = "ro.build.version.emui";

    /* renamed from: e  reason: collision with root package name */
    private static final String f52550e = "ro.build.version.magic";

    /* renamed from: f  reason: collision with root package name */
    private static final String f52551f = "ro.miui.ui.version.name";

    /* renamed from: g  reason: collision with root package name */
    private static final String f52552g = "ro.build.version.opporom";

    /* renamed from: h  reason: collision with root package name */
    private static final String f52553h = "ro.vivo.os.name";

    /* renamed from: i  reason: collision with root package name */
    private static final String f52554i = "ro.vivo.os.version";

    /* renamed from: j  reason: collision with root package name */
    private static final String f52555j = "ro.build.version.oplusrom";

    /* renamed from: k  reason: collision with root package name */
    private static final String f52556k = "ro.rom.version";

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return !TextUtils.isEmpty((String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(f52546a)) {
            e(str);
        }
        return f52547b;
    }

    public static String c(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replaceAll(" ", "").toUpperCase();
    }

    private static String d(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod(f3.f5657f, String.class).invoke(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void e(String str) {
        try {
            String c4 = c(str);
            char c5 = '\uffff';
            switch (c4.hashCode()) {
                case -1881642058:
                    if (c4.equals("REALME")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case -1706170181:
                    if (c4.equals("XIAOMI")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case -602397472:
                    if (c4.equals("ONEPLUS")) {
                        c5 = 7;
                        break;
                    }
                    break;
                case 2432928:
                    if (c4.equals(BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
                        c5 = 5;
                        break;
                    }
                    break;
                case 2634924:
                    if (c4.equals("VIVO")) {
                        c5 = 6;
                        break;
                    }
                    break;
                case 68924490:
                    if (c4.equals("HONOR")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 77852109:
                    if (c4.equals("REDMI")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 2141820391:
                    if (c4.equals("HUAWEI")) {
                        c5 = 0;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    if (a()) {
                        f52547b = d("hw_sc.build.platform.version");
                        f52546a = "HarmonyOS";
                        return;
                    }
                    f52546a = "EMUI";
                    f52547b = d("ro.build.version.emui");
                    return;
                case 1:
                    if (!TextUtils.isEmpty(d("ro.build.version.magic"))) {
                        f52546a = "MagicUI";
                        f52547b = d("ro.build.version.magic");
                        return;
                    }
                    f52546a = "EMUI";
                    f52547b = d("ro.build.version.emui");
                    return;
                case 2:
                case 3:
                    f52546a = "MIUI";
                    f52547b = d("ro.miui.ui.version.name");
                    return;
                case 4:
                case 5:
                    f52546a = "ColorOS";
                    f52547b = d("ro.build.version.opporom");
                    return;
                case 6:
                    f52546a = "Funtouch";
                    f52547b = d("ro.vivo.os.version");
                    return;
                case 7:
                    f52546a = "HydrogenOS";
                    String d4 = d("ro.rom.version");
                    if (TextUtils.isEmpty(d4)) {
                        f52546a = "ColorOS";
                        d4 = d("ro.build.version.oplusrom");
                    }
                    f52547b = d4;
                    return;
                default:
                    f52546a = "Android";
                    f52547b = Build.VERSION.RELEASE;
                    return;
            }
        } catch (Throwable unused) {
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(f52546a)) {
            e(str);
        }
        return f52546a;
    }
}
