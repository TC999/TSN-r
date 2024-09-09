package com.acse.ottn;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.util.HelpShopAppUtil;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c4 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5363a = "harmony";

    public static String a() {
        String d4 = g1.a().d("getDeviceBoard");
        if (TextUtils.isEmpty(d4)) {
            String lowerCase = Build.BOARD.toLowerCase();
            g1.a().b("getDeviceBoard", lowerCase);
            return lowerCase;
        }
        return d4;
    }

    public static int b(Context context) {
        int b4 = g1.a().b("getDeviceHeight");
        if (b4 == 0) {
            int i4 = context.getResources().getDisplayMetrics().heightPixels;
            g1.a().b("getDeviceHeight", i4);
            return i4;
        }
        return b4;
    }

    public static int c(Context context) {
        if (context == null) {
            return 0;
        }
        int b4 = g1.a().b("getDeviceWidth");
        if (b4 == 0) {
            int i4 = context.getResources().getDisplayMetrics().widthPixels;
            g1.a().b("getDeviceWidth", i4);
            return i4;
        }
        return b4;
    }

    public static String d() {
        String d4 = g1.a().d("getDeviceDevice");
        if (TextUtils.isEmpty(d4)) {
            String lowerCase = Build.DEVICE.toLowerCase();
            g1.a().b("getDeviceDevice", lowerCase);
            return lowerCase;
        }
        return d4;
    }

    public static String e() {
        String d4 = g1.a().d("getDeviceDisplay");
        if (TextUtils.isEmpty(d4)) {
            String lowerCase = Build.DISPLAY.toLowerCase();
            g1.a().b("getDeviceDisplay", lowerCase);
            return lowerCase;
        }
        return d4;
    }

    public static String f() {
        String d4 = g1.a().d("getDeviceFubgerprint");
        if (TextUtils.isEmpty(d4)) {
            String lowerCase = Build.FINGERPRINT.toLowerCase();
            g1.a().b("getDeviceFubgerprint", lowerCase);
            return lowerCase;
        }
        return d4;
    }

    public static String g() {
        String d4 = g1.a().d("getDeviceHardware");
        if (TextUtils.isEmpty(d4)) {
            String lowerCase = Build.HARDWARE.toLowerCase();
            g1.a().b("getDeviceHardware", lowerCase);
            return lowerCase;
        }
        return d4;
    }

    public static String h() {
        String d4 = g1.a().d("getDeviceHost");
        if (TextUtils.isEmpty(d4)) {
            String lowerCase = Build.HOST.toLowerCase();
            g1.a().b("getDeviceHost", lowerCase);
            return lowerCase;
        }
        return d4;
    }

    public static String i() {
        String d4 = g1.a().d("getDeviceManufacturer");
        if (TextUtils.isEmpty(d4)) {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            g1.a().b("getDeviceManufacturer", lowerCase);
            return lowerCase;
        }
        return d4;
    }

    public static String j() {
        String d4 = g1.a().d("getDeviceProduct");
        if (TextUtils.isEmpty(d4)) {
            String lowerCase = Build.PRODUCT.toLowerCase();
            g1.a().b("getDeviceProduct", lowerCase);
            return lowerCase;
        }
        return d4;
    }

    public static int k() {
        int b4 = g1.a().b("getDeviceSDK");
        if (b4 == 0) {
            int i4 = Build.VERSION.SDK_INT;
            g1.a().b("getDeviceSDK", i4);
            return i4;
        }
        return b4;
    }

    public static String l() {
        String d4 = g1.a().d("getDeviceSerial");
        if (TextUtils.isEmpty(d4)) {
            String lowerCase = Build.SERIAL.toLowerCase();
            g1.a().b("getDeviceSerial", lowerCase);
            return lowerCase;
        }
        return d4;
    }

    public static String m() {
        z1.a("wangjie", "Local:" + Locale.GERMAN);
        z1.a("wangjie", "Local:" + Locale.ENGLISH);
        z1.a("wangjie", "Local:" + Locale.US);
        z1.a("wangjie", "Local:" + Locale.CHINESE);
        z1.a("wangjie", "Local:" + Locale.TAIWAN);
        z1.a("wangjie", "Local:" + Locale.FRANCE);
        z1.a("wangjie", "Local:" + Locale.FRENCH);
        z1.a("wangjie", "Local:" + Locale.GERMANY);
        z1.a("wangjie", "Local:" + Locale.ITALIAN);
        z1.a("wangjie", "Local:" + Locale.JAPAN);
        z1.a("wangjie", "Local:" + Locale.JAPANESE);
        return Locale.getAvailableLocales().toString();
    }

    public static String n() {
        String d4 = g1.a().d("getDeviceUser");
        if (TextUtils.isEmpty(d4)) {
            String lowerCase = Build.USER.toLowerCase();
            g1.a().b("getDeviceUser", lowerCase);
            return lowerCase;
        }
        return d4;
    }

    public static String o() {
        String d4 = g1.a().d("getMobileId");
        if (TextUtils.isEmpty(d4)) {
            String lowerCase = Build.ID.toLowerCase();
            g1.a().b("getMobileId", lowerCase);
            return lowerCase;
        }
        return d4;
    }

    public static String p() {
        String d4 = g1.a().d("getSystemModel");
        if (TextUtils.isEmpty(d4)) {
            String lowerCase = Build.MODEL.toLowerCase();
            g1.a().b("getSystemModel", lowerCase);
            return lowerCase;
        }
        return d4;
    }

    public static String q() {
        String d4 = g1.a().d("getSystemVersion");
        if (TextUtils.isEmpty(d4)) {
            String lowerCase = Build.VERSION.RELEASE.toLowerCase();
            g1.a().b("getSystemVersion", lowerCase);
            return lowerCase;
        }
        return d4;
    }

    public static String r() {
        PackageInfo packageInfo;
        if (HelpShopAppUtil.getContext() == null) {
            return "";
        }
        String str = "0";
        try {
            str = packageInfo.versionCode + "";
            g1.a().b("appName", HelpShopAppUtil.getContext().getPackageManager().getPackageInfo(HelpShopAppUtil.getContext().getPackageName(), 0).packageName);
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
        }
        g1.a().b("app_version_code", str);
        return str;
    }

    public static boolean s() {
        if (TextUtils.isEmpty(g1.a().d("isHarmonyOSa"))) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                Method method = cls.getMethod("getOsBrand", new Class[0]);
                ClassLoader classLoader = cls.getClassLoader();
                PrintStream printStream = System.out;
                printStream.println("classLoader: " + classLoader);
                if (classLoader != null && classLoader.getParent() == null) {
                    if (f5363a.equals(method.invoke(cls, new Object[0]))) {
                        g1.a().b("isHarmonyOSa", "TRUE");
                    } else {
                        g1.a().b("isHarmonyOSa", "FALSE");
                    }
                }
            } catch (Exception unused) {
                g1.a().b("isHarmonyOSa", "FALSE");
            }
        }
        return g1.a().d("isHarmonyOSa").equals("TRUE");
    }

    public static String b() {
        String d4 = g1.a().d("getDeviceBrand");
        if (TextUtils.isEmpty(g1.a().d("getDeviceBrand"))) {
            String lowerCase = Build.BRAND.toLowerCase();
            g1.a().b("getDeviceBrand", lowerCase);
            return lowerCase;
        }
        return d4;
    }

    public static String c() {
        return Locale.getDefault().getLanguage().toLowerCase();
    }

    public static String a(Context context) {
        return "\n\n2. \u8bbe\u5907\u5bbd\u5ea6:\n\t\t" + c(context) + "\n\n3. \u8bbe\u5907\u9ad8\u5ea6:\n\t\t" + b(context) + "\n\n10. \u7cfb\u7edf\u9ed8\u8ba4\u8bed\u8a00:\n\t\t" + c() + "\n\n11. \u786c\u4ef6\u5e8f\u5217\u53f7(\u8bbe\u5907\u540d):\n\t\t" + l() + "\n\n12. \u624b\u673a\u578b\u53f7:\n\t\t" + p() + "\n\n13. \u751f\u4ea7\u5382\u5546:\n\t\t" + i() + "\n\n14. \u624b\u673aFingerprint\u6807\u8bc6:\n\t\t" + f() + "\n\n15. Android \u7248\u672c:\n\t\t" + q() + "\n\n16. Android SDK\u7248\u672c:\n\t\t" + k() + "\n\n17. \u5b89\u5168patch \u65f6\u95f4:\n\t\t" + Build.VERSION.SECURITY_PATCH + "\n\n19. \u7248\u672c\u7c7b\u578b:\n\t\t" + Build.TYPE + "\n\n20. \u7528\u6237\u540d:\n\t\t" + n() + "\n\n21. \u4ea7\u54c1\u540d:\n\t\t" + j() + "\n\n22. ID:\n\t\t" + o() + "\n\n23. \u663e\u793aID:\n\t\t" + e() + "\n\n24. \u786c\u4ef6\u540d:\n\t\t" + g() + "\n\n25. \u4ea7\u54c1\u540d:\n\t\t" + d() + "\n\n26. Bootloader:\n\t\t" + Build.BOOTLOADER + "\n\n27. \u4e3b\u677f\u540d:\n\t\t" + a() + "\n\n28. CodeName:\n\t\t" + Build.VERSION.CODENAME;
    }
}
