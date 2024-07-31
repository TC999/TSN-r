package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.PathCenter;
import com.umeng.analytics.pro.UMLogAnalytics;
import com.umeng.common.SPHelper;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class AnalyticsConfig {
    public static boolean CATCH_EXCEPTION = false;
    public static boolean CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    public static boolean CLEAR_EKV_BL = false;
    public static boolean CLEAR_EKV_WL = false;
    public static final String DEBUG_KEY = "debugkey";
    public static final String DEBUG_MODE_PERIOD = "sendaging";
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";
    public static final String RTD_PERIOD = "period";
    public static final String RTD_START_TIME = "startTime";

    /* renamed from: a */
    static double[] f37520a = null;

    /* renamed from: b */
    private static String f37521b = null;

    /* renamed from: c */
    private static String f37522c = null;

    /* renamed from: d */
    private static String f37523d = null;

    /* renamed from: e */
    private static int f37524e = 0;
    public static boolean enable = true;
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;
    public static final String RTD_SP_FILE = PathCenter.m14695b().m14694b(PathCenter.f37677A);

    /* renamed from: f */
    private static Object f37525f = new Object();

    /* renamed from: g */
    private static boolean f37526g = false;

    /* renamed from: h */
    private static String f37527h = "";

    /* renamed from: a */
    static void m14843a(String str) {
        f37522c = str;
    }

    public static String getAppkey(Context context) {
        return UMUtils.getAppkey(context);
    }

    public static String getChannel(Context context) {
        return UMUtils.getChannel(context);
    }

    public static String getGameSdkVersion(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.analytics.game.GameSdkVersion");
            return (String) cls.getDeclaredField("SDK_VERSION").get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static double[] getLocation() {
        return f37520a;
    }

    public static String getRealTimeDebugKey() {
        String str;
        synchronized (f37525f) {
            str = f37527h;
        }
        return str;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f37523d)) {
            f37523d = SPHelper.m14059a(context).m14052c();
        }
        return f37523d;
    }

    public static int getVerticalType(Context context) {
        if (f37524e == 0) {
            f37524e = SPHelper.m14059a(context).m14051d();
        }
        return f37524e;
    }

    public static boolean isRealTimeDebugMode() {
        boolean z;
        synchronized (f37525f) {
            z = f37526g;
        }
        return z;
    }

    public static void turnOffRealTimeDebug() {
        synchronized (f37525f) {
            f37526g = false;
            f37527h = "";
        }
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        synchronized (f37525f) {
            f37526g = true;
            if (map != null && map.containsKey(DEBUG_KEY)) {
                f37527h = map.get(DEBUG_KEY);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m14844a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            f37523d = str;
            SPHelper.m14059a(context).m14055a(f37523d);
            return;
        }
        UMLog.m14015aq(UMLogAnalytics.f38269A, 0, "\\|");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m14845a(Context context, int i) {
        f37524e = i;
        SPHelper.m14059a(context).m14060a(f37524e);
    }
}
