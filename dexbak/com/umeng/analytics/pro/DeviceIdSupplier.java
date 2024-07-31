package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bxkj.student.C4229c;

/* renamed from: com.umeng.analytics.pro.ay */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DeviceIdSupplier {

    /* renamed from: a */
    private static final String f37720a = "ro.build.version.emui";

    /* renamed from: b */
    private static final String f37721b = "hw_sc.build.platform.version";

    /* renamed from: a */
    public static IDeviceIdSupplier m14681a(Context context) {
        String str = Build.BRAND;
        C13124bh.m14664a("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equalsIgnoreCase("huawei") && !str.equalsIgnoreCase("honor") && !str.equalsIgnoreCase("华为")) {
            if (!str.equalsIgnoreCase(C4229c.f16088d) && !str.equalsIgnoreCase("redmi") && !str.equalsIgnoreCase("meitu") && !str.equalsIgnoreCase("小米") && !str.equalsIgnoreCase("blackshark")) {
                if (str.equalsIgnoreCase("vivo")) {
                    return new VivoDeviceIdSupplier();
                }
                if (!str.equalsIgnoreCase("oppo") && !str.equalsIgnoreCase("oneplus") && !str.equalsIgnoreCase("realme")) {
                    if (!str.equalsIgnoreCase("lenovo") && !str.equalsIgnoreCase("zuk")) {
                        if (str.equalsIgnoreCase("nubia")) {
                            return new NubiaDeviceIdSupplier();
                        }
                        if (str.equalsIgnoreCase("samsung")) {
                            return new SamsungDeviceIdSupplier();
                        }
                        if (m14682a()) {
                            return new HuaweiDeviceIdSupplier();
                        }
                        if (!str.equalsIgnoreCase("meizu") && !str.equalsIgnoreCase("mblu") && !m14678c()) {
                            if (m14679b()) {
                                return new CoolpadDeviceIdSupplier();
                            }
                            return null;
                        }
                        return new MeizuDeviceIdSupplier();
                    }
                    return new LenovoDeviceIdSupplier();
                }
                return new OppoDeviceIdSupplier();
            }
            return new XiaomiDeviceIdSupplier();
        }
        return new HuaweiDeviceIdSupplier();
    }

    /* renamed from: b */
    private static boolean m14679b() {
        return !TextUtils.isEmpty(m14680a("ro.coolos.version"));
    }

    /* renamed from: c */
    private static boolean m14678c() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return !TextUtils.isEmpty((String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.build.flyme.version", ""));
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m14682a() {
        return (TextUtils.isEmpty(m14680a(f37720a)) && TextUtils.isEmpty(m14680a(f37721b))) ? false : true;
    }

    /* renamed from: a */
    private static String m14680a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }
}
