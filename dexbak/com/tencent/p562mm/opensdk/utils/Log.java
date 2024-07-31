package com.tencent.p562mm.opensdk.utils;

/* renamed from: com.tencent.mm.opensdk.utils.Log */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Log {
    private static ILog logImpl;

    /* renamed from: d */
    public static void m15265d(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.d(str, str2);
        } else {
            iLog.m15270d(str, str2);
        }
    }

    /* renamed from: e */
    public static void m15264e(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.e(str, str2);
        } else {
            iLog.m15269e(str, str2);
        }
    }

    /* renamed from: i */
    public static void m15263i(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.i(str, str2);
        } else {
            iLog.m15268i(str, str2);
        }
    }

    public static void setLogImpl(ILog iLog) {
        logImpl = iLog;
    }

    /* renamed from: v */
    public static void m15262v(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.v(str, str2);
        } else {
            iLog.m15267v(str, str2);
        }
    }

    /* renamed from: w */
    public static void m15261w(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.w(str, str2);
        } else {
            iLog.m15266w(str, str2);
        }
    }
}
