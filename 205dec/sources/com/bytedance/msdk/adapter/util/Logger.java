package com.bytedance.msdk.adapter.util;

import android.util.Log;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class Logger {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f27223a = false;

    /* renamed from: b  reason: collision with root package name */
    private static int f27224b = 4;

    /* renamed from: c  reason: collision with root package name */
    static boolean f27225c = true;

    private static String a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1);
    }

    private static boolean b() {
        return a.f().v();
    }

    public static void d(String str) {
        if (isDebug()) {
            d("Logger", str);
        }
    }

    public static void d_(String str) {
        if (b()) {
            d(str);
        }
    }

    public static void e(String str) {
        if (isDebug()) {
            e("Logger", str);
        }
    }

    public static int getLogLevel() {
        return f27224b;
    }

    public static void i(String str) {
        if (isDebug()) {
            i("Logger", str);
        }
    }

    public static void iEventLog(String str, String str2) {
        if (f27225c || str2 == null || f27224b > 4) {
            return;
        }
        Log.i(str, str2);
    }

    public static boolean isDebug() {
        return f27223a;
    }

    public static void openDebugMode() {
        f27223a = true;
        setLogLevel(3);
    }

    public static void setLogLevel(int i4) {
        f27224b = i4;
    }

    public static void st(String str, int i4) {
        try {
            throw new Exception();
        } catch (Exception e4) {
            StackTraceElement[] stackTrace = e4.getStackTrace();
            StringBuilder sb = new StringBuilder();
            for (int i5 = 1; i5 < Math.min(i4, stackTrace.length); i5++) {
                if (i5 > 1) {
                    sb.append("\n");
                }
                sb.append(a(stackTrace[i5].getClassName()));
                sb.append(".");
                sb.append(stackTrace[i5].getMethodName());
            }
            v(str, sb.toString());
        }
    }

    public static void v(String str) {
        v("Logger", str);
    }

    public static void w(String str) {
        if (isDebug()) {
            w("Logger", str);
        }
    }

    public static void v(String str, String str2) {
        if (isDebug() && str2 != null && f27224b <= 2) {
            Log.v(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (isDebug() && str2 != null && f27224b <= 3) {
            Log.d(str, str2);
        }
    }

    public static void d_(String str, String str2) {
        if (b()) {
            d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (isDebug() && str2 != null && f27224b <= 6) {
            Log.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (isDebug() && str2 != null && f27224b <= 4) {
            Log.i(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (isDebug() && str2 != null && f27224b <= 5) {
            Log.w(str, str2);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (isDebug()) {
            if (!(str2 == null && th == null) && f27224b <= 2) {
                Log.v(str, str2, th);
            }
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (isDebug()) {
            if (!(str2 == null && th == null) && f27224b <= 3) {
                Log.d(str, str2, th);
            }
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (isDebug()) {
            if (!(str2 == null && th == null) && f27224b <= 6) {
                Log.e(str, str2, th);
            }
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (isDebug()) {
            if (!(str2 == null && th == null) && f27224b <= 4) {
                Log.i(str, str2, th);
            }
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (isDebug()) {
            if (!(str2 == null && th == null) && f27224b <= 5) {
                Log.w(str, str2, th);
            }
        }
    }
}
