package com.bytedance.msdk.adapter.util;

import android.util.Log;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import com.snail.antifake.deviceid.ShellAdbUtils;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class Logger {

    /* renamed from: a */
    private static boolean f21505a = false;

    /* renamed from: b */
    private static int f21506b = 4;

    /* renamed from: c */
    static boolean f21507c = true;

    /* renamed from: a */
    private static String m37565a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1);
    }

    /* renamed from: b */
    private static boolean m37564b() {
        return InternalContainer.m59943f().m59725v();
    }

    /* renamed from: d */
    public static void m37563d(String str) {
        if (isDebug()) {
            m37562d("Logger", str);
        }
    }

    /* renamed from: d_ */
    public static void m37560d_(String str) {
        if (m37564b()) {
            m37563d(str);
        }
    }

    /* renamed from: e */
    public static void m37558e(String str) {
        if (isDebug()) {
            m37557e("Logger", str);
        }
    }

    public static int getLogLevel() {
        return f21506b;
    }

    /* renamed from: i */
    public static void m37555i(String str) {
        if (isDebug()) {
            m37554i("Logger", str);
        }
    }

    public static void iEventLog(String str, String str2) {
        if (f21507c || str2 == null || f21506b > 4) {
            return;
        }
        Log.i(str, str2);
    }

    public static boolean isDebug() {
        return f21505a;
    }

    public static void openDebugMode() {
        f21505a = true;
        setLogLevel(3);
    }

    public static void setLogLevel(int i) {
        f21506b = i;
    }

    /* renamed from: st */
    public static void m37552st(String str, int i) {
        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 1; i2 < Math.min(i, stackTrace.length); i2++) {
                if (i2 > 1) {
                    sb.append(ShellAdbUtils.f33810d);
                }
                sb.append(m37565a(stackTrace[i2].getClassName()));
                sb.append(".");
                sb.append(stackTrace[i2].getMethodName());
            }
            m37550v(str, sb.toString());
        }
    }

    /* renamed from: v */
    public static void m37551v(String str) {
        m37550v("Logger", str);
    }

    /* renamed from: w */
    public static void m37548w(String str) {
        if (isDebug()) {
            m37547w("Logger", str);
        }
    }

    /* renamed from: v */
    public static void m37550v(String str, String str2) {
        if (isDebug() && str2 != null && f21506b <= 2) {
            Log.v(str, str2);
        }
    }

    /* renamed from: d */
    public static void m37562d(String str, String str2) {
        if (isDebug() && str2 != null && f21506b <= 3) {
            Log.d(str, str2);
        }
    }

    /* renamed from: d_ */
    public static void m37559d_(String str, String str2) {
        if (m37564b()) {
            m37562d(str, str2);
        }
    }

    /* renamed from: e */
    public static void m37557e(String str, String str2) {
        if (isDebug() && str2 != null && f21506b <= 6) {
            Log.e(str, str2);
        }
    }

    /* renamed from: i */
    public static void m37554i(String str, String str2) {
        if (isDebug() && str2 != null && f21506b <= 4) {
            Log.i(str, str2);
        }
    }

    /* renamed from: w */
    public static void m37547w(String str, String str2) {
        if (isDebug() && str2 != null && f21506b <= 5) {
            Log.w(str, str2);
        }
    }

    /* renamed from: v */
    public static void m37549v(String str, String str2, Throwable th) {
        if (isDebug()) {
            if (!(str2 == null && th == null) && f21506b <= 2) {
                Log.v(str, str2, th);
            }
        }
    }

    /* renamed from: d */
    public static void m37561d(String str, String str2, Throwable th) {
        if (isDebug()) {
            if (!(str2 == null && th == null) && f21506b <= 3) {
                Log.d(str, str2, th);
            }
        }
    }

    /* renamed from: e */
    public static void m37556e(String str, String str2, Throwable th) {
        if (isDebug()) {
            if (!(str2 == null && th == null) && f21506b <= 6) {
                Log.e(str, str2, th);
            }
        }
    }

    /* renamed from: i */
    public static void m37553i(String str, String str2, Throwable th) {
        if (isDebug()) {
            if (!(str2 == null && th == null) && f21506b <= 4) {
                Log.i(str, str2, th);
            }
        }
    }

    /* renamed from: w */
    public static void m37546w(String str, String str2, Throwable th) {
        if (isDebug()) {
            if (!(str2 == null && th == null) && f21506b <= 5) {
                Log.w(str, str2, th);
            }
        }
    }
}
