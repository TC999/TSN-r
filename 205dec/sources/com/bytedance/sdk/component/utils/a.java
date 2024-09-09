package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f30182c = false;
    private static String sr = "";

    /* renamed from: w  reason: collision with root package name */
    private static int f30183w = 4;
    private static com.bytedance.sdk.component.c xv;

    public static void c(com.bytedance.sdk.component.c cVar) {
        xv = cVar;
    }

    public static void f(String str, String str2) {
        com.bytedance.sdk.component.c cVar = xv;
        if (cVar != null) {
            cVar.ux(sr(str), str2);
        }
        if (f30182c && str2 != null && f30183w <= 6) {
            Log.e(sr(str), str2);
        }
    }

    public static void sr(String str, String str2) {
        com.bytedance.sdk.component.c cVar = xv;
        if (cVar != null) {
            cVar.sr(sr(str), str2);
        }
        if (f30182c && str2 != null && f30183w <= 5) {
            Log.w(sr(str), str2);
        }
    }

    public static void ux(String str, String str2) {
        com.bytedance.sdk.component.c cVar = xv;
        if (cVar != null) {
            cVar.xv(sr(str), str2);
        }
        if (str2 == null) {
            return;
        }
        if (str == null) {
            str = "Logger";
        }
        Log.i(sr(str), str2);
    }

    public static void w() {
        f30182c = true;
        c(3);
    }

    public static boolean xv() {
        return f30182c;
    }

    public static void c(int i4) {
        f30183w = i4;
    }

    public static void xv(String str, String str2) {
        com.bytedance.sdk.component.c cVar = xv;
        if (cVar != null) {
            cVar.xv(sr(str), str2);
        }
        if (f30182c && str2 != null && f30183w <= 4) {
            Log.i(sr(str), str2);
        }
    }

    public static boolean c() {
        return f30183w <= 3;
    }

    public static void w(String str, String str2) {
        com.bytedance.sdk.component.c cVar = xv;
        if (cVar != null) {
            cVar.w(sr(str), str2);
        }
        if (f30182c && str2 != null && f30183w <= 3) {
            Log.d(sr(str), str2);
        }
    }

    public static void c(String str, String str2) {
        com.bytedance.sdk.component.c cVar = xv;
        if (cVar != null) {
            cVar.c(sr(str), str2);
        }
        if (f30182c && str2 != null && f30183w <= 2) {
            Log.v(sr(str), str2);
        }
    }

    public static void sr(String str, Object... objArr) {
        com.bytedance.sdk.component.c cVar = xv;
        if (cVar != null) {
            cVar.ux(sr(str), c(objArr));
        }
        if (f30182c && objArr != null && f30183w <= 6) {
            Log.e(sr(str), c(objArr));
        }
    }

    public static void xv(String str, Object... objArr) {
        com.bytedance.sdk.component.c cVar = xv;
        if (cVar != null) {
            cVar.sr(sr(str), c(objArr));
        }
        if (f30182c && objArr != null && f30183w <= 5) {
            Log.w(sr(str), c(objArr));
        }
    }

    public static void w(String str, Object... objArr) {
        com.bytedance.sdk.component.c cVar = xv;
        if (cVar != null) {
            cVar.xv(sr(str), c(objArr));
        }
        if (f30182c && objArr != null && f30183w <= 4) {
            Log.i(sr(str), c(objArr));
        }
    }

    public static void c(String str) {
        if (f30182c) {
            w("Logger", str);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.c cVar = xv;
        if (cVar != null) {
            String sr2 = sr(str);
            cVar.w(sr2, str2 + Log.getStackTraceString(th));
        }
        if (f30182c) {
            if (!(str2 == null && th == null) && f30183w <= 3) {
                Log.d(sr(str), str2, th);
            }
        }
    }

    public static String sr(String str) {
        if (TextUtils.isEmpty(sr)) {
            return str;
        }
        return c("[" + sr + "]-[" + str + "]");
    }

    public static void xv(String str) {
        if (f30182c) {
            f("Logger", str);
        }
    }

    public static void w(String str) {
        if (f30182c) {
            sr("Logger", str);
        }
    }

    public static void xv(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.c cVar = xv;
        if (cVar != null) {
            cVar.w(sr(str), str2, th);
        }
        if (f30182c) {
            if (!(str2 == null && th == null) && f30183w <= 6) {
                Log.e(sr(str), str2, th);
            }
        }
    }

    public static void w(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.c cVar = xv;
        if (cVar != null) {
            cVar.c(sr(str), str2, th);
        }
        if (f30182c) {
            if (!(str2 == null && th == null) && f30183w <= 5) {
                Log.w(sr(str), str2, th);
            }
        }
    }

    public static void c(String str, Object... objArr) {
        com.bytedance.sdk.component.c cVar = xv;
        if (cVar != null) {
            cVar.w(sr(str), c(objArr));
        }
        if (f30182c && objArr != null && f30183w <= 3) {
            Log.d(sr(str), c(objArr));
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
