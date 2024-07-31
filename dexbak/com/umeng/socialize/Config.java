package com.umeng.socialize;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
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

    /* renamed from: a */
    private static int f39244a;
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
        shareType = "native";
        KaKaoLoginType = 0;
        MORE_TITLE = "分享";
        LinkedInProfileScope = 0;
        LinkedInShareCode = 0;
        connectionTimeOut = 30000;
        readSocketTimeOut = 30000;
        isNeedAuth = false;
        isJumptoAppStore = false;
        isFacebookRead = false;
        f39244a = 0;
    }

    public static int getMINITYPE() {
        return f39244a;
    }

    public static void setMini() {
        f39244a = 0;
    }

    public static void setMiniPreView() {
        f39244a = 2;
    }

    public static void setMiniTest() {
        f39244a = 1;
    }
}
