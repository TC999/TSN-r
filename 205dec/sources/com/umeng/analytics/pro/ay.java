package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.f3;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: DeviceIdSupplier.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ay {

    /* renamed from: a  reason: collision with root package name */
    private static final String f52607a = "ro.build.version.emui";

    /* renamed from: b  reason: collision with root package name */
    private static final String f52608b = "hw_sc.build.platform.version";

    public static av a(Context context) {
        String str = Build.BRAND;
        bh.a("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase("huawei") && !str.equalsIgnoreCase("honor") && !str.equalsIgnoreCase("\u534e\u4e3a")) {
            if (!str.equalsIgnoreCase("xiaomi") && !str.equalsIgnoreCase("redmi") && !str.equalsIgnoreCase("meitu") && !str.equalsIgnoreCase("\u5c0f\u7c73") && !str.equalsIgnoreCase("blackshark")) {
                if (str.equalsIgnoreCase("vivo")) {
                    return new bf();
                }
                if (!str.equalsIgnoreCase("oppo") && !str.equalsIgnoreCase("oneplus") && !str.equalsIgnoreCase("realme")) {
                    if (!str.equalsIgnoreCase("lenovo") && !str.equalsIgnoreCase("zuk")) {
                        if (str.equalsIgnoreCase("nubia")) {
                            return new bc();
                        }
                        if (str.equalsIgnoreCase("samsung")) {
                            return new be();
                        }
                        if (a()) {
                            return new az();
                        }
                        if (!str.equalsIgnoreCase("meizu") && !str.equalsIgnoreCase("mblu") && !c()) {
                            if (b()) {
                                return new ax();
                            }
                            return null;
                        }
                        return new bb();
                    }
                    return new ba();
                }
                return new bd();
            }
            return new bg();
        }
        return new az();
    }

    private static boolean b() {
        return !TextUtils.isEmpty(a("ro.coolos.version"));
    }

    private static boolean c() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return !TextUtils.isEmpty((String) cls.getMethod(f3.f5657f, String.class, String.class).invoke(cls, "ro.build.flyme.version", ""));
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean a() {
        return (TextUtils.isEmpty(a("ro.build.version.emui")) && TextUtils.isEmpty(a("hw_sc.build.platform.version"))) ? false : true;
    }

    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod(f3.f5657f, String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }
}
