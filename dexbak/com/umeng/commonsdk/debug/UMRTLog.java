package com.umeng.commonsdk.debug;

import android.util.Log;
import com.umeng.commonsdk.UMConfigure;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMRTLog {
    private static final String RTLOG_ENABLE = "1";
    private static final String RTLOG_PROP = "debug.umeng.rtlog";
    public static final String RTLOG_TAG = "MobclickRT";

    private UMRTLog() {
    }

    /* renamed from: d */
    public static void m14010d(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.d(str, warpperMsg(str2, false));
        }
    }

    /* renamed from: e */
    public static void m14009e(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.e(str, warpperMsg(str2, false));
        }
    }

    /* renamed from: i */
    public static void m14008i(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.i(str, warpperMsg(str2, false));
        }
    }

    /* renamed from: sd */
    public static void m14007sd(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.d(str, warpperMsg(str2, true));
        }
    }

    /* renamed from: se */
    public static void m14006se(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.e(str, warpperMsg(str2, true));
        }
    }

    /* renamed from: si */
    public static void m14005si(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.i(str, warpperMsg(str2, true));
        }
    }

    /* renamed from: sv */
    public static void m14004sv(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.v(str, warpperMsg(str2, true));
        }
    }

    /* renamed from: sw */
    public static void m14003sw(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.w(str, warpperMsg(str2, true));
        }
    }

    /* renamed from: v */
    public static void m14002v(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.v(str, warpperMsg(str2, false));
        }
    }

    /* renamed from: w */
    public static void m14001w(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.w(str, warpperMsg(str2, false));
        }
    }

    private static String warpperMsg(String str, boolean z) {
        if (z) {
            StringBuffer stringBuffer = null;
            try {
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                if (stackTrace.length >= 3) {
                    String fileName = stackTrace[2].getFileName();
                    String methodName = stackTrace[2].getMethodName();
                    int lineNumber = stackTrace[2].getLineNumber();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("<");
                    stringBuffer2.append(fileName);
                    stringBuffer2.append(":");
                    stringBuffer2.append(methodName);
                    stringBuffer2.append(":");
                    stringBuffer2.append(lineNumber);
                    stringBuffer2.append("> ");
                    stringBuffer2.append(str);
                    stringBuffer = stringBuffer2;
                }
                return stringBuffer.toString();
            } catch (Throwable unused) {
                return str;
            }
        }
        return str;
    }
}
