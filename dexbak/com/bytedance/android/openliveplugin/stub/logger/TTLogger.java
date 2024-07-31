package com.bytedance.android.openliveplugin.stub.logger;

import android.util.Log;
import com.snail.antifake.deviceid.ShellAdbUtils;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TTLogger {
    private static boolean DEBUG = false;
    private static final String TAG = "TTLiveLogger";
    private static int sLevel = 4;

    /* renamed from: d */
    public static void m37909d(String str) {
        if (DEBUG) {
            m37908d(TAG, str);
        }
    }

    /* renamed from: d */
    public static void m37908d(String str, String str2) {
        if (DEBUG && str2 != null && sLevel <= 3) {
            Log.d(str, str2);
        }
    }

    /* renamed from: d */
    public static void m37907d(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (!(str2 == null && th == null) && sLevel <= 3) {
                Log.d(str, str2, th);
            }
        }
    }

    /* renamed from: d */
    public static void m37906d(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 3) {
            Log.d(str, formatMsgs(objArr));
        }
    }

    public static boolean debug() {
        return sLevel <= 3;
    }

    /* renamed from: e */
    public static void m37905e(String str) {
        if (DEBUG) {
            m37904e(TAG, str);
        }
    }

    /* renamed from: e */
    public static void m37904e(String str, String str2) {
        if (DEBUG && str2 != null && sLevel <= 6) {
            Log.e(str, str2);
        }
    }

    /* renamed from: e */
    public static void m37903e(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (!(str2 == null && th == null) && sLevel <= 6) {
                Log.e(str, str2, th);
            }
        }
    }

    /* renamed from: e */
    public static void m37902e(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 6) {
            Log.v(str, formatMsgs(objArr));
        }
    }

    private static String formatMsgs(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            sb.append(obj != null ? obj.toString() : " null ");
            sb.append(" ");
        }
        return sb.toString();
    }

    public static int getLogLevel() {
        return sLevel;
    }

    private static String getSimpleClassName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1);
    }

    /* renamed from: i */
    public static void m37901i(String str) {
        if (DEBUG) {
            m37900i(TAG, str);
        }
    }

    /* renamed from: i */
    public static void m37900i(String str, String str2) {
        if (DEBUG && str2 != null && sLevel <= 4) {
            Log.i(str, str2);
        }
    }

    /* renamed from: i */
    public static void m37899i(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (!(str2 == null && th == null) && sLevel <= 4) {
                Log.i(str, str2, th);
            }
        }
    }

    /* renamed from: i */
    public static void m37898i(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 4) {
            Log.v(str, formatMsgs(objArr));
        }
    }

    public static boolean isDebug() {
        return DEBUG;
    }

    public static void logDirect(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (str == null) {
            str = TAG;
        }
        Log.i(str, str2);
    }

    public static void openDebugMode() {
        DEBUG = true;
        setLogLevel(3);
    }

    public static void setLogLevel(int i) {
        sLevel = i;
    }

    /* renamed from: st */
    public static void m37897st(String str, int i) {
        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 1; i2 < Math.min(i, stackTrace.length); i2++) {
                if (i2 > 1) {
                    sb.append(ShellAdbUtils.f33810d);
                }
                sb.append(getSimpleClassName(stackTrace[i2].getClassName()));
                sb.append(".");
                sb.append(stackTrace[i2].getMethodName());
            }
            m37895v(str, sb.toString());
        }
    }

    /* renamed from: v */
    public static void m37896v(String str) {
        m37895v(TAG, str);
    }

    /* renamed from: v */
    public static void m37895v(String str, String str2) {
        if (DEBUG && str2 != null && sLevel <= 2) {
            Log.v(str, str2);
        }
    }

    /* renamed from: v */
    public static void m37894v(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (!(str2 == null && th == null) && sLevel <= 2) {
                Log.v(str, str2, th);
            }
        }
    }

    /* renamed from: v */
    public static void m37893v(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 2) {
            Log.v(str, formatMsgs(objArr));
        }
    }

    /* renamed from: w */
    public static void m37892w(String str) {
        if (DEBUG) {
            m37891w(TAG, str);
        }
    }

    /* renamed from: w */
    public static void m37891w(String str, String str2) {
        if (DEBUG && str2 != null && sLevel <= 5) {
            Log.w(str, str2);
        }
    }

    /* renamed from: w */
    public static void m37890w(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (!(str2 == null && th == null) && sLevel <= 5) {
                Log.w(str, str2, th);
            }
        }
    }

    /* renamed from: w */
    public static void m37889w(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 5) {
            Log.v(str, formatMsgs(objArr));
        }
    }
}
