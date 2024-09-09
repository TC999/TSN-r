package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.acse.ottn.f3;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static final CharSequence f26830c = "sony";

    /* renamed from: w  reason: collision with root package name */
    private static final CharSequence f26831w = "amigo";
    private static final CharSequence xv = "funtouch";
    private static final c<Boolean> sr = new c<Boolean>() { // from class: com.bytedance.embedapplog.w.1
    };

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static abstract class c<T> {
        c() {
        }
    }

    public static boolean a() {
        return t().toUpperCase().contains("NUBIA");
    }

    public static boolean bk() {
        return t().toUpperCase().contains("ASUS");
    }

    public static String c() {
        return w("ro.build.version.emui");
    }

    public static boolean ev() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean f() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    public static boolean gd() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean k() {
        String str = Build.FINGERPRINT;
        if (!TextUtils.isEmpty(str)) {
            return str.contains("VIBEUI_V2");
        }
        String w3 = w("ro.build.version.incremental");
        return !TextUtils.isEmpty(w3) && w3.contains("VIBEUI_V2");
    }

    public static boolean p() {
        return "samsung".equalsIgnoreCase(Build.BRAND) || "samsung".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean r() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("XIAOMI") && !str.equalsIgnoreCase("REDMI")) {
                return false;
            }
        }
        return true;
    }

    public static boolean sr() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod(f3.f5657f, String.class).invoke(cls, "ro.build.version.emui");
            if (!TextUtils.isEmpty(str)) {
                Log.d("Honor", " oldHonor device, version is" + str);
                return true;
            }
        } catch (Exception e4) {
            Log.e("Honor", "" + e4.getMessage());
        }
        return false;
    }

    private static String t() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean ux() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean w() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("huawei")) {
            String str2 = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str2) || !str2.toLowerCase().startsWith("huawei")) {
                return false;
            }
        }
        return true;
    }

    public static boolean xv() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("honor")) {
            String str2 = Build.MANUFACTURER;
            if ((TextUtils.isEmpty(str2) || !str2.toLowerCase().startsWith("honor")) && !"HONOR".equalsIgnoreCase(str2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = c();
        }
        return (!TextUtils.isEmpty(str) && (str.toLowerCase().contains("emotionui") || str.toLowerCase().contains("magicui"))) || w() || xv();
    }

    private static String w(String str) {
        String c4 = eu.c(str);
        return !TextUtils.isEmpty(c4) ? c4 : g.c(str);
    }

    public static boolean c(Context context) {
        return t().toUpperCase().contains("HUAWEI");
    }
}
