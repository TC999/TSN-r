package com.umeng.socialize;

import xyz.adscope.amps.common.AMPSConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class Config {
    public static String Descriptor = null;
    public static String EntityKey = "-1";
    public static String EntityName = "share";
    public static final boolean Google = false;
    @Deprecated
    public static int KaKaoLoginType = 0;
    @Deprecated
    public static int LinkedInProfileScope = 0;
    @Deprecated
    public static int LinkedInShareCode = 0;
    public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
    public static String MORE_TITLE = null;
    @Deprecated
    public static boolean OpenEditor = true;
    @Deprecated
    public static String QQAPPNAME;
    @Deprecated
    public static int QQWITHQZONE;
    public static String SessionId;

    /* renamed from: a  reason: collision with root package name */
    private static int f53833a;
    @Deprecated
    public static String appName;
    public static int connectionTimeOut;
    public static boolean isFacebookRead;
    public static boolean isJumptoAppStore;
    @Deprecated
    public static boolean isNeedAuth;
    public static Boolean isUmengDY;
    public static Boolean isUmengQQ;
    public static Boolean isUmengSina;
    public static Boolean isUmengWx;
    public static final boolean mEncrypt = false;
    public static int readSocketTimeOut;
    public static String shareType;

    static {
        Boolean bool = Boolean.TRUE;
        isUmengSina = bool;
        isUmengWx = bool;
        isUmengQQ = bool;
        isUmengDY = bool;
        Descriptor = "com.umeng.share";
        SessionId = null;
        QQWITHQZONE = 2;
        QQAPPNAME = "";
        shareType = AMPSConstants.AdType.AD_TYPE_NATIVE;
        KaKaoLoginType = 0;
        MORE_TITLE = "\u5206\u4eab";
        LinkedInProfileScope = 0;
        LinkedInShareCode = 0;
        connectionTimeOut = 30000;
        readSocketTimeOut = 30000;
        isNeedAuth = false;
        isJumptoAppStore = false;
        isFacebookRead = false;
        f53833a = 0;
    }

    public static int getMINITYPE() {
        return f53833a;
    }

    public static void setMini() {
        f53833a = 0;
    }

    public static void setMiniPreView() {
        f53833a = 2;
    }

    public static void setMiniTest() {
        f53833a = 1;
    }
}
