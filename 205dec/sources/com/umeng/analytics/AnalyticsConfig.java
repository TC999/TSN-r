package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
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

    /* renamed from: a  reason: collision with root package name */
    static double[] f52418a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f52419b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f52420c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f52421d = null;

    /* renamed from: e  reason: collision with root package name */
    private static int f52422e = 0;
    public static boolean enable = true;
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;
    public static final String RTD_SP_FILE = au.b().b("rtd");

    /* renamed from: f  reason: collision with root package name */
    private static Object f52423f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static boolean f52424g = false;

    /* renamed from: h  reason: collision with root package name */
    private static String f52425h = "";

    static void a(String str) {
        f52420c = str;
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
        return f52418a;
    }

    public static String getRealTimeDebugKey() {
        String str;
        synchronized (f52423f) {
            str = f52425h;
        }
        return str;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f52421d)) {
            f52421d = com.umeng.common.b.a(context).c();
        }
        return f52421d;
    }

    public static int getVerticalType(Context context) {
        if (f52422e == 0) {
            f52422e = com.umeng.common.b.a(context).d();
        }
        return f52422e;
    }

    public static boolean isRealTimeDebugMode() {
        boolean z3;
        synchronized (f52423f) {
            z3 = f52424g;
        }
        return z3;
    }

    public static void turnOffRealTimeDebug() {
        synchronized (f52423f) {
            f52424g = false;
            f52425h = "";
        }
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        synchronized (f52423f) {
            f52424g = true;
            if (map != null && map.containsKey("debugkey")) {
                f52425h = map.get("debugkey");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            f52421d = str;
            com.umeng.common.b.a(context).a(f52421d);
            return;
        }
        UMLog.aq("MobclickAgent.setSecret\u65b9\u6cd5\u53c2\u6570secretkey\u4e0d\u80fd\u4e3anull\uff0c\u4e5f\u4e0d\u80fd\u4e3a\u7a7a\u5b57\u7b26\u4e32\u3002|secretkey\u53c2\u6570\u5fc5\u987b\u662f\u975e\u7a7a \u5b57\u7b26\u4e32\u3002", 0, "\\|");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, int i4) {
        f52422e = i4;
        com.umeng.common.b.a(context).a(f52422e);
    }
}
