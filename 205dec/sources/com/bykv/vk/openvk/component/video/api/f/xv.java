package com.bykv.vk.openvk.component.video.api.f;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f24926c = false;

    /* renamed from: w  reason: collision with root package name */
    private static int f24927w = 4;
    private static String xv = "";

    public static void c(int i4) {
        f24927w = i4;
    }

    public static void sr(String str, String str2) {
        if (f24926c && str2 != null && f24927w <= 6) {
            Log.e(sr(str), str2);
        }
    }

    public static boolean w() {
        return f24926c;
    }

    public static void xv(String str, String str2) {
        if (f24926c && str2 != null && f24927w <= 5) {
            Log.w(sr(str), str2);
        }
    }

    public static void c() {
        f24926c = true;
        c(3);
    }

    public static void w(String str) {
        if (f24926c) {
            w("Logger", str);
        }
    }

    public static void c(String str) {
        if (f24926c) {
            c("Logger", str);
        }
    }

    private static String sr(String str) {
        if (TextUtils.isEmpty(xv)) {
            return str;
        }
        return c("[" + xv + "]-[" + str + "]");
    }

    public static void w(String str, String str2) {
        if (f24926c && str2 != null && f24927w <= 4) {
            Log.i(sr(str), str2);
        }
    }

    public static void xv(String str) {
        if (f24926c) {
            sr("Logger", str);
        }
    }

    public static void c(String str, String str2) {
        if (f24926c && str2 != null && f24927w <= 3) {
            Log.d(sr(str), str2);
        }
    }

    public static void xv(String str, String str2, Throwable th) {
        if (f24926c) {
            if (!(str2 == null && th == null) && f24927w <= 6) {
                Log.e(sr(str), str2, th);
            }
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (f24926c) {
            if (!(str2 == null && th == null) && f24927w <= 4) {
                Log.i(sr(str), str2, th);
            }
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (f24926c) {
            if (!(str2 == null && th == null) && f24927w <= 3) {
                Log.d(sr(str), str2, th);
            }
        }
    }

    public static void w(String str, Object... objArr) {
        if (f24926c && objArr != null && f24927w <= 4) {
            Log.v(sr(str), c(objArr));
        }
    }

    public static void c(String str, Object... objArr) {
        if (f24926c && objArr != null && f24927w <= 3) {
            Log.v(sr(str), c(objArr));
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
