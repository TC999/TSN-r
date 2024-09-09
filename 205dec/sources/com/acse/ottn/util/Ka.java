package com.acse.ottn.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class Ka {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6764a = "harmony";

    public static String a() {
        if (TextUtils.isEmpty(C1419ba.a().d("getDeviceBoard"))) {
            C1419ba.a().b("getDeviceBoard", Build.BOARD.toLowerCase());
        }
        return C1419ba.a().d("getDeviceBoard");
    }

    public static String a(Context context) {
        return "\n\n2. \u8bbe\u5907\u5bbd\u5ea6:\n\t\t" + c(context) + "\n\n3. \u8bbe\u5907\u9ad8\u5ea6:\n\t\t" + b(context) + "\n\n10. \u7cfb\u7edf\u9ed8\u8ba4\u8bed\u8a00:\n\t\t" + c() + "\n\n11. \u786c\u4ef6\u5e8f\u5217\u53f7(\u8bbe\u5907\u540d):\n\t\t" + l() + "\n\n12. \u624b\u673a\u578b\u53f7:\n\t\t" + p() + "\n\n13. \u751f\u4ea7\u5382\u5546:\n\t\t" + i() + "\n\n14. \u624b\u673aFingerprint\u6807\u8bc6:\n\t\t" + f() + "\n\n15. Android \u7248\u672c:\n\t\t" + q() + "\n\n16. Android SDK\u7248\u672c:\n\t\t" + k() + "\n\n17. \u5b89\u5168patch \u65f6\u95f4:\n\t\t" + Build.VERSION.SECURITY_PATCH + "\n\n19. \u7248\u672c\u7c7b\u578b:\n\t\t" + Build.TYPE + "\n\n20. \u7528\u6237\u540d:\n\t\t" + n() + "\n\n21. \u4ea7\u54c1\u540d:\n\t\t" + j() + "\n\n22. ID:\n\t\t" + o() + "\n\n23. \u663e\u793aID:\n\t\t" + e() + "\n\n24. \u786c\u4ef6\u540d:\n\t\t" + g() + "\n\n25. \u4ea7\u54c1\u540d:\n\t\t" + d() + "\n\n26. Bootloader:\n\t\t" + Build.BOOTLOADER + "\n\n27. \u4e3b\u677f\u540d:\n\t\t" + a() + "\n\n28. CodeName:\n\t\t" + Build.VERSION.CODENAME;
    }

    public static int b(Context context) {
        if (C1419ba.a().b("getDeviceHeight") == 0) {
            C1419ba.a().b("getDeviceHeight", context.getResources().getDisplayMetrics().heightPixels);
        }
        return C1419ba.a().b("getDeviceHeight");
    }

    public static String b() {
        if (TextUtils.isEmpty(C1419ba.a().d("getDeviceBrand"))) {
            C1419ba.a().b("getDeviceBrand", Build.BRAND.toLowerCase());
        }
        return C1419ba.a().d("getDeviceBrand");
    }

    public static int c(Context context) {
        if (context == null) {
            return 0;
        }
        if (C1419ba.a().b("getDeviceWidth") == 0) {
            C1419ba.a().b("getDeviceWidth", context.getResources().getDisplayMetrics().widthPixels);
        }
        return C1419ba.a().b("getDeviceWidth");
    }

    public static String c() {
        return Locale.getDefault().getLanguage().toLowerCase();
    }

    public static String d() {
        if (TextUtils.isEmpty(C1419ba.a().d("getDeviceDevice"))) {
            C1419ba.a().b("getDeviceDevice", Build.DEVICE.toLowerCase());
        }
        return C1419ba.a().d("getDeviceDevice");
    }

    public static String e() {
        if (TextUtils.isEmpty(C1419ba.a().d("getDeviceDisplay"))) {
            C1419ba.a().b("getDeviceDisplay", Build.DISPLAY.toLowerCase());
        }
        return C1419ba.a().d("getDeviceDisplay");
    }

    public static String f() {
        if (TextUtils.isEmpty(C1419ba.a().d("getDeviceFubgerprint"))) {
            C1419ba.a().b("getDeviceFubgerprint", Build.FINGERPRINT.toLowerCase());
        }
        return C1419ba.a().d("getDeviceFubgerprint");
    }

    public static String g() {
        if (TextUtils.isEmpty(C1419ba.a().d("getDeviceHardware"))) {
            C1419ba.a().b("getDeviceHardware", Build.HARDWARE.toLowerCase());
        }
        return C1419ba.a().d("getDeviceHardware");
    }

    public static String h() {
        if (TextUtils.isEmpty(C1419ba.a().d("getDeviceHost"))) {
            C1419ba.a().b("getDeviceHost", Build.HOST.toLowerCase());
        }
        return C1419ba.a().d("getDeviceHost");
    }

    public static String i() {
        if (TextUtils.isEmpty(C1419ba.a().d("getDeviceManufacturer"))) {
            C1419ba.a().b("getDeviceManufacturer", Build.MANUFACTURER.toLowerCase());
        }
        return C1419ba.a().d("getDeviceManufacturer");
    }

    public static String j() {
        if (TextUtils.isEmpty(C1419ba.a().d("getDeviceProduct"))) {
            C1419ba.a().b("getDeviceProduct", Build.PRODUCT.toLowerCase());
        }
        return C1419ba.a().d("getDeviceProduct");
    }

    public static int k() {
        if (C1419ba.a().b("getDeviceSDK") == 0) {
            C1419ba.a().b("getDeviceSDK", Build.VERSION.SDK_INT);
        }
        return C1419ba.a().b("getDeviceSDK");
    }

    public static String l() {
        if (TextUtils.isEmpty(C1419ba.a().d("getDeviceSerial"))) {
            C1419ba.a().b("getDeviceSerial", Build.SERIAL.toLowerCase());
        }
        return C1419ba.a().d("getDeviceSerial");
    }

    public static String m() {
        ra.a("wangjie", "Local:" + Locale.GERMAN);
        ra.a("wangjie", "Local:" + Locale.ENGLISH);
        ra.a("wangjie", "Local:" + Locale.US);
        ra.a("wangjie", "Local:" + Locale.CHINESE);
        ra.a("wangjie", "Local:" + Locale.TAIWAN);
        ra.a("wangjie", "Local:" + Locale.FRANCE);
        ra.a("wangjie", "Local:" + Locale.FRENCH);
        ra.a("wangjie", "Local:" + Locale.GERMANY);
        ra.a("wangjie", "Local:" + Locale.ITALIAN);
        ra.a("wangjie", "Local:" + Locale.JAPAN);
        ra.a("wangjie", "Local:" + Locale.JAPANESE);
        return Locale.getAvailableLocales().toString();
    }

    public static String n() {
        if (TextUtils.isEmpty(C1419ba.a().d("getDeviceUser"))) {
            C1419ba.a().b("getDeviceUser", Build.USER.toLowerCase());
        }
        return C1419ba.a().d("getDeviceUser");
    }

    public static String o() {
        if (TextUtils.isEmpty(C1419ba.a().d("getMobileId"))) {
            C1419ba.a().b("getMobileId", Build.ID.toLowerCase());
        }
        return C1419ba.a().d("getMobileId");
    }

    public static String p() {
        if (TextUtils.isEmpty(C1419ba.a().d("getSystemModel"))) {
            C1419ba.a().b("getSystemModel", Build.MODEL.toLowerCase());
        }
        return C1419ba.a().d("getSystemModel");
    }

    public static String q() {
        if (TextUtils.isEmpty(C1419ba.a().d("getSystemVersion"))) {
            C1419ba.a().b("getSystemVersion", Build.VERSION.RELEASE.toLowerCase());
        }
        return C1419ba.a().d("getSystemVersion");
    }

    public static String r() {
        String str;
        PackageInfo packageInfo;
        if (HelpShopAppUtil.getContext() == null) {
            return "";
        }
        try {
            str = packageInfo.versionCode + "";
            try {
                C1419ba.a().b("appName", HelpShopAppUtil.getContext().getPackageManager().getPackageInfo(HelpShopAppUtil.getContext().getPackageName(), 0).packageName);
            } catch (PackageManager.NameNotFoundException e4) {
                e = e4;
                e.printStackTrace();
                C1419ba.a().b("app_version_code", str);
                return str;
            }
        } catch (PackageManager.NameNotFoundException e5) {
            e = e5;
            str = "0";
        }
        C1419ba.a().b("app_version_code", str);
        return str;
    }

    public static boolean s() {
        C1419ba a4;
        String str;
        if (TextUtils.isEmpty(C1419ba.a().d("isHarmonyOSa"))) {
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
                    if ("harmony".equals(method.invoke(cls, new Object[0]))) {
                        a4 = C1419ba.a();
                        str = "TRUE";
                    } else {
                        a4 = C1419ba.a();
                        str = "FALSE";
                    }
                    a4.b("isHarmonyOSa", str);
                }
            } catch (Exception unused) {
                C1419ba.a().b("isHarmonyOSa", "FALSE");
            }
        }
        return C1419ba.a().d("isHarmonyOSa").equals("TRUE");
    }
}
