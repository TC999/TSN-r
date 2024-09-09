package com.bytedance.sdk.openadsdk.api;

import android.util.Log;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f31498c = false;

    /* renamed from: w  reason: collision with root package name */
    private static int f31499w = 4;

    public static void c(int i4) {
        f31499w = i4;
    }

    public static void sr(String str, String str2) {
        if (f31498c && str2 != null && f31499w <= 5) {
            Log.w(str, str2);
        }
    }

    public static void ux(String str, String str2) {
        if (f31498c && str2 != null && f31499w <= 6) {
            Log.e(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (f31498c && str2 != null && f31499w <= 3) {
            Log.d(str, str2);
        }
    }

    public static void xv(String str, String str2) {
        if (f31498c && str2 != null && f31499w <= 4) {
            Log.i(str, str2);
        }
    }

    public static void c() {
        f31498c = true;
        c(3);
    }

    public static void c(String str, String str2) {
        if (f31498c && str2 != null && f31499w <= 2) {
            Log.v(str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (f31498c) {
            if (!(str2 == null && th == null) && f31499w <= 5) {
                Log.w(str, str2, th);
            }
        }
    }

    public static void xv(String str, String str2, Throwable th) {
        if (f31498c) {
            if (!(str2 == null && th == null) && f31499w <= 6) {
                Log.e(str, str2, th);
            }
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (f31498c) {
            if (!(str2 == null && th == null) && f31499w <= 3) {
                Log.d(str, str2, th);
            }
        }
    }

    public static void w(String str, Object... objArr) {
        if (f31498c && objArr != null && f31499w <= 5) {
            Log.v(str, c(objArr));
        }
    }

    public static void c(String str, Object... objArr) {
        if (f31498c && objArr != null && f31499w <= 3) {
            Log.d(str, c(objArr));
        }
    }

    public static void c(String str) {
        if (f31498c) {
            sr("TTLogger", str);
        }
    }

    private static String c(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
