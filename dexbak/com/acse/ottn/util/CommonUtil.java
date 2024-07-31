package com.acse.ottn.util;

import com.acse.ottn.C1248a;
import com.bxkj.student.C4229c;
import com.tencent.connect.common.Constants;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class CommonUtil {
    public static String CURRECT_APP_VERSION;
    public static String CURRECT_SYSTEM_VERSION;
    public static String PACKAGE_NAME;
    public static String appName = C1663ca.m56080c().m56081b();
    public static String showPermissionName = showAppName("");
    public static boolean isShwoToast = false;
    public static boolean isShowConpunInfor = true;
    public static String CURRENT_ACCESSIBLITY_OPEN = "1";
    public static String CURRENT_ACCESSIBLITY_CLOSE = "0";
    public static String SNT_VERSION = Constants.VIA_SHARE_TYPE_MINI_PROGRAM;
    public static String SDK_VERSION = "1";
    public static boolean isReadActivityPage = false;
    public static int TB_READ_SIZE = 17;
    public static int JD_READ_SIZE = 18;
    public static String APP_PACKAGE_NAME = C1248a.f2036b;
    public static String SCROLLED_SCREEN_CALCLE = "0";
    public static String SCROLLED_SCREEN_START = "1";
    public static String YDSJXU_PACKAGENAME = "com.zjwh.android_wh_physicalfitness";
    public static String TSN_PACKAGENAME = C4229c.f16086b;

    static {
        PACKAGE_NAME = HelpShopAppUtil.getContext() != null ? HelpShopAppUtil.getContext().getPackageName() : "";
        CURRECT_APP_VERSION = "".equals(C1661ba.m56097a().m56086d("app_version_code")) ? C1638Ka.m56175r() : C1661ba.m56097a().m56086d("app_version_code");
        CURRECT_SYSTEM_VERSION = "".equals(C1661ba.m56097a().m56086d("getSystemVersion")) ? C1638Ka.m56176q() : C1661ba.m56097a().m56086d("getSystemVersion");
    }

    public static String getDecryptKey(boolean z) {
        return z ? "QVbZFjAoPF6LCCQm6RgDs1g13mnJ8nA0" : C1661ba.m56097a().m56086d("aes_key");
    }

    public static void setButteryState(boolean z) {
        if (C1661ba.m56097a() != null) {
            C1703va.m55903a().m55901a("battery_permission");
            C1661ba.m56097a().m56092a("open_battery_white", z);
        }
    }

    public static void setServiceHightButteryState(boolean z) {
        C1694ra.m55917a("MyService", "setServiceHightButteryState come on");
        if (C1661ba.m56097a() != null) {
            C1661ba.m56097a().m56092a("background_battery_hignt", z);
        }
        C1703va.m55903a().m55901a("vivo_battery_permission");
    }

    public static String showAppName(String str) {
        return "程序";
    }
}
