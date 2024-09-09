package com.bytedance.sdk.openadsdk.api;

import android.util.Log;

/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class bl {

    /* renamed from: a  reason: collision with root package name */
    private static int f31368a = 4;
    private static boolean ok;

    public static void a(String str, String str2) {
        if (ok && str2 != null && f31368a <= 3) {
            Log.d(str, str2);
        }
    }

    public static void bl(String str, String str2) {
        if (ok && str2 != null && f31368a <= 4) {
            Log.i(str, str2);
        }
    }

    public static void n(String str, String str2) {
        if (ok && str2 != null && f31368a <= 6) {
            Log.e(str, str2);
        }
    }

    public static void ok(int i4) {
        f31368a = i4;
    }

    public static void s(String str, String str2) {
        if (ok && str2 != null && f31368a <= 5) {
            Log.w(str, str2);
        }
    }

    public static void ok() {
        ok = true;
        ok(3);
    }

    public static void a(String str, String str2, Throwable th) {
        if (ok) {
            if (!(str2 == null && th == null) && f31368a <= 5) {
                Log.w(str, str2, th);
            }
        }
    }

    public static void bl(String str, String str2, Throwable th) {
        if (ok) {
            if (!(str2 == null && th == null) && f31368a <= 6) {
                Log.e(str, str2, th);
            }
        }
    }

    public static void ok(String str, String str2) {
        if (ok && str2 != null && f31368a <= 2) {
            Log.v(str, str2);
        }
    }

    public static void a(String str, Object... objArr) {
        if (ok && objArr != null && f31368a <= 5) {
            Log.v(str, ok(objArr));
        }
    }

    public static void ok(String str, String str2, Throwable th) {
        if (ok) {
            if (!(str2 == null && th == null) && f31368a <= 3) {
                Log.d(str, str2, th);
            }
        }
    }

    public static void ok(String str, Object... objArr) {
        if (ok && objArr != null && f31368a <= 3) {
            Log.d(str, ok(objArr));
        }
    }

    public static void ok(String str) {
        if (ok) {
            s("TTLogger", str);
        }
    }

    private static String ok(Object... objArr) {
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
