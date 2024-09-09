package com.acse.ottn.util;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class CommonUtil {
    public static String CURRECT_APP_VERSION;
    public static String CURRECT_SYSTEM_VERSION;
    public static String PACKAGE_NAME;
    public static String appName = C1421ca.c().b();
    public static String showPermissionName = showAppName("");
    public static boolean isShwoToast = false;
    public static boolean isShowConpunInfor = true;
    public static String CURRENT_ACCESSIBLITY_OPEN = "1";
    public static String CURRENT_ACCESSIBLITY_CLOSE = "0";
    public static String SNT_VERSION = "9";
    public static String SDK_VERSION = "1";
    public static boolean isReadActivityPage = false;
    public static int TB_READ_SIZE = 17;
    public static int JD_READ_SIZE = 18;
    public static String APP_PACKAGE_NAME = "com.acse.ottn";
    public static String SCROLLED_SCREEN_CALCLE = "0";
    public static String SCROLLED_SCREEN_START = "1";
    public static String YDSJXU_PACKAGENAME = "com.zjwh.android_wh_physicalfitness";
    public static String TSN_PACKAGENAME = "com.bxkj.student";

    static {
        PACKAGE_NAME = HelpShopAppUtil.getContext() != null ? HelpShopAppUtil.getContext().getPackageName() : "";
        CURRECT_APP_VERSION = "".equals(C1419ba.a().d("app_version_code")) ? Ka.r() : C1419ba.a().d("app_version_code");
        CURRECT_SYSTEM_VERSION = "".equals(C1419ba.a().d("getSystemVersion")) ? Ka.q() : C1419ba.a().d("getSystemVersion");
    }

    public static String getDecryptKey(boolean z3) {
        return z3 ? "QVbZFjAoPF6LCCQm6RgDs1g13mnJ8nA0" : C1419ba.a().d("aes_key");
    }

    public static void setButteryState(boolean z3) {
        if (C1419ba.a() != null) {
            va.a().a("battery_permission");
            C1419ba.a().a("open_battery_white", z3);
        }
    }

    public static void setServiceHightButteryState(boolean z3) {
        ra.a("MyService", "setServiceHightButteryState come on");
        if (C1419ba.a() != null) {
            C1419ba.a().a("background_battery_hignt", z3);
        }
        va.a().a("vivo_battery_permission");
    }

    public static String showAppName(String str) {
        return "\u7a0b\u5e8f";
    }
}
