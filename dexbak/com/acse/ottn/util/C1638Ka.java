package com.acse.ottn.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Locale;

/* renamed from: com.acse.ottn.util.Ka */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1638Ka {

    /* renamed from: a */
    private static final String f3254a = "harmony";

    /* renamed from: a */
    public static String m56195a() {
        if (TextUtils.isEmpty(C1661ba.m56097a().m56086d("getDeviceBoard"))) {
            C1661ba.m56097a().m56088b("getDeviceBoard", Build.BOARD.toLowerCase());
        }
        return C1661ba.m56097a().m56086d("getDeviceBoard");
    }

    /* renamed from: a */
    public static String m56194a(Context context) {
        return "\n\n2. 设备宽度:\n\t\t" + m56190c(context) + "\n\n3. 设备高度:\n\t\t" + m56192b(context) + "\n\n10. 系统默认语言:\n\t\t" + m56191c() + "\n\n11. 硬件序列号(设备名):\n\t\t" + m56181l() + "\n\n12. 手机型号:\n\t\t" + m56177p() + "\n\n13. 生产厂商:\n\t\t" + m56184i() + "\n\n14. 手机Fingerprint标识:\n\t\t" + m56187f() + "\n\n15. Android 版本:\n\t\t" + m56176q() + "\n\n16. Android SDK版本:\n\t\t" + m56182k() + "\n\n17. 安全patch 时间:\n\t\t" + Build.VERSION.SECURITY_PATCH + "\n\n19. 版本类型:\n\t\t" + Build.TYPE + "\n\n20. 用户名:\n\t\t" + m56179n() + "\n\n21. 产品名:\n\t\t" + m56183j() + "\n\n22. ID:\n\t\t" + m56178o() + "\n\n23. 显示ID:\n\t\t" + m56188e() + "\n\n24. 硬件名:\n\t\t" + m56186g() + "\n\n25. 产品名:\n\t\t" + m56189d() + "\n\n26. Bootloader:\n\t\t" + Build.BOOTLOADER + "\n\n27. 主板名:\n\t\t" + m56195a() + "\n\n28. CodeName:\n\t\t" + Build.VERSION.CODENAME;
    }

    /* renamed from: b */
    public static int m56192b(Context context) {
        if (C1661ba.m56097a().m56090b("getDeviceHeight") == 0) {
            C1661ba.m56097a().m56089b("getDeviceHeight", context.getResources().getDisplayMetrics().heightPixels);
        }
        return C1661ba.m56097a().m56090b("getDeviceHeight");
    }

    /* renamed from: b */
    public static String m56193b() {
        if (TextUtils.isEmpty(C1661ba.m56097a().m56086d("getDeviceBrand"))) {
            C1661ba.m56097a().m56088b("getDeviceBrand", Build.BRAND.toLowerCase());
        }
        return C1661ba.m56097a().m56086d("getDeviceBrand");
    }

    /* renamed from: c */
    public static int m56190c(Context context) {
        if (context == null) {
            return 0;
        }
        if (C1661ba.m56097a().m56090b("getDeviceWidth") == 0) {
            C1661ba.m56097a().m56089b("getDeviceWidth", context.getResources().getDisplayMetrics().widthPixels);
        }
        return C1661ba.m56097a().m56090b("getDeviceWidth");
    }

    /* renamed from: c */
    public static String m56191c() {
        return Locale.getDefault().getLanguage().toLowerCase();
    }

    /* renamed from: d */
    public static String m56189d() {
        if (TextUtils.isEmpty(C1661ba.m56097a().m56086d("getDeviceDevice"))) {
            C1661ba.m56097a().m56088b("getDeviceDevice", Build.DEVICE.toLowerCase());
        }
        return C1661ba.m56097a().m56086d("getDeviceDevice");
    }

    /* renamed from: e */
    public static String m56188e() {
        if (TextUtils.isEmpty(C1661ba.m56097a().m56086d("getDeviceDisplay"))) {
            C1661ba.m56097a().m56088b("getDeviceDisplay", Build.DISPLAY.toLowerCase());
        }
        return C1661ba.m56097a().m56086d("getDeviceDisplay");
    }

    /* renamed from: f */
    public static String m56187f() {
        if (TextUtils.isEmpty(C1661ba.m56097a().m56086d("getDeviceFubgerprint"))) {
            C1661ba.m56097a().m56088b("getDeviceFubgerprint", Build.FINGERPRINT.toLowerCase());
        }
        return C1661ba.m56097a().m56086d("getDeviceFubgerprint");
    }

    /* renamed from: g */
    public static String m56186g() {
        if (TextUtils.isEmpty(C1661ba.m56097a().m56086d("getDeviceHardware"))) {
            C1661ba.m56097a().m56088b("getDeviceHardware", Build.HARDWARE.toLowerCase());
        }
        return C1661ba.m56097a().m56086d("getDeviceHardware");
    }

    /* renamed from: h */
    public static String m56185h() {
        if (TextUtils.isEmpty(C1661ba.m56097a().m56086d("getDeviceHost"))) {
            C1661ba.m56097a().m56088b("getDeviceHost", Build.HOST.toLowerCase());
        }
        return C1661ba.m56097a().m56086d("getDeviceHost");
    }

    /* renamed from: i */
    public static String m56184i() {
        if (TextUtils.isEmpty(C1661ba.m56097a().m56086d("getDeviceManufacturer"))) {
            C1661ba.m56097a().m56088b("getDeviceManufacturer", Build.MANUFACTURER.toLowerCase());
        }
        return C1661ba.m56097a().m56086d("getDeviceManufacturer");
    }

    /* renamed from: j */
    public static String m56183j() {
        if (TextUtils.isEmpty(C1661ba.m56097a().m56086d("getDeviceProduct"))) {
            C1661ba.m56097a().m56088b("getDeviceProduct", Build.PRODUCT.toLowerCase());
        }
        return C1661ba.m56097a().m56086d("getDeviceProduct");
    }

    /* renamed from: k */
    public static int m56182k() {
        if (C1661ba.m56097a().m56090b("getDeviceSDK") == 0) {
            C1661ba.m56097a().m56089b("getDeviceSDK", Build.VERSION.SDK_INT);
        }
        return C1661ba.m56097a().m56090b("getDeviceSDK");
    }

    /* renamed from: l */
    public static String m56181l() {
        if (TextUtils.isEmpty(C1661ba.m56097a().m56086d("getDeviceSerial"))) {
            C1661ba.m56097a().m56088b("getDeviceSerial", Build.SERIAL.toLowerCase());
        }
        return C1661ba.m56097a().m56086d("getDeviceSerial");
    }

    /* renamed from: m */
    public static String m56180m() {
        C1694ra.m55917a("wangjie", "Local:" + Locale.GERMAN);
        C1694ra.m55917a("wangjie", "Local:" + Locale.ENGLISH);
        C1694ra.m55917a("wangjie", "Local:" + Locale.US);
        C1694ra.m55917a("wangjie", "Local:" + Locale.CHINESE);
        C1694ra.m55917a("wangjie", "Local:" + Locale.TAIWAN);
        C1694ra.m55917a("wangjie", "Local:" + Locale.FRANCE);
        C1694ra.m55917a("wangjie", "Local:" + Locale.FRENCH);
        C1694ra.m55917a("wangjie", "Local:" + Locale.GERMANY);
        C1694ra.m55917a("wangjie", "Local:" + Locale.ITALIAN);
        C1694ra.m55917a("wangjie", "Local:" + Locale.JAPAN);
        C1694ra.m55917a("wangjie", "Local:" + Locale.JAPANESE);
        return Locale.getAvailableLocales().toString();
    }

    /* renamed from: n */
    public static String m56179n() {
        if (TextUtils.isEmpty(C1661ba.m56097a().m56086d("getDeviceUser"))) {
            C1661ba.m56097a().m56088b("getDeviceUser", Build.USER.toLowerCase());
        }
        return C1661ba.m56097a().m56086d("getDeviceUser");
    }

    /* renamed from: o */
    public static String m56178o() {
        if (TextUtils.isEmpty(C1661ba.m56097a().m56086d("getMobileId"))) {
            C1661ba.m56097a().m56088b("getMobileId", Build.ID.toLowerCase());
        }
        return C1661ba.m56097a().m56086d("getMobileId");
    }

    /* renamed from: p */
    public static String m56177p() {
        if (TextUtils.isEmpty(C1661ba.m56097a().m56086d("getSystemModel"))) {
            C1661ba.m56097a().m56088b("getSystemModel", Build.MODEL.toLowerCase());
        }
        return C1661ba.m56097a().m56086d("getSystemModel");
    }

    /* renamed from: q */
    public static String m56176q() {
        if (TextUtils.isEmpty(C1661ba.m56097a().m56086d("getSystemVersion"))) {
            C1661ba.m56097a().m56088b("getSystemVersion", Build.VERSION.RELEASE.toLowerCase());
        }
        return C1661ba.m56097a().m56086d("getSystemVersion");
    }

    /* renamed from: r */
    public static String m56175r() {
        String str;
        PackageInfo packageInfo;
        if (HelpShopAppUtil.getContext() == null) {
            return "";
        }
        try {
            str = packageInfo.versionCode + "";
            try {
                C1661ba.m56097a().m56088b("appName", HelpShopAppUtil.getContext().getPackageManager().getPackageInfo(HelpShopAppUtil.getContext().getPackageName(), 0).packageName);
            } catch (PackageManager.NameNotFoundException e) {
                e = e;
                e.printStackTrace();
                C1661ba.m56097a().m56088b("app_version_code", str);
                return str;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e = e2;
            str = "0";
        }
        C1661ba.m56097a().m56088b("app_version_code", str);
        return str;
    }

    /* renamed from: s */
    public static boolean m56174s() {
        C1661ba m56097a;
        String str;
        if (TextUtils.isEmpty(C1661ba.m56097a().m56086d("isHarmonyOSa"))) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                Method method = cls.getMethod("getOsBrand", new Class[0]);
                ClassLoader classLoader = cls.getClassLoader();
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("classLoader: ");
                sb.append(classLoader);
                printStream.println(sb.toString());
                if (classLoader != null && classLoader.getParent() == null) {
                    if (f3254a.equals(method.invoke(cls, new Object[0]))) {
                        m56097a = C1661ba.m56097a();
                        str = "TRUE";
                    } else {
                        m56097a = C1661ba.m56097a();
                        str = "FALSE";
                    }
                    m56097a.m56088b("isHarmonyOSa", str);
                }
            } catch (Exception unused) {
                C1661ba.m56097a().m56088b("isHarmonyOSa", "FALSE");
            }
        }
        return C1661ba.m56097a().m56086d("isHarmonyOSa").equals("TRUE");
    }
}
