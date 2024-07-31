package com.bytedance.sdk.openadsdk.api;

import android.util.Log;

/* renamed from: com.bytedance.sdk.openadsdk.api.bl */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C6280bl {

    /* renamed from: a */
    private static int f22360a = 4;

    /* renamed from: ok */
    private static boolean f22361ok;

    /* renamed from: a */
    public static void m36774a(String str, String str2) {
        if (f22361ok && str2 != null && f22360a <= 3) {
            Log.d(str, str2);
        }
    }

    /* renamed from: bl */
    public static void m36771bl(String str, String str2) {
        if (f22361ok && str2 != null && f22360a <= 4) {
            Log.i(str, str2);
        }
    }

    /* renamed from: n */
    public static void m36769n(String str, String str2) {
        if (f22361ok && str2 != null && f22360a <= 6) {
            Log.e(str, str2);
        }
    }

    /* renamed from: ok */
    public static void m36767ok(int i) {
        f22360a = i;
    }

    /* renamed from: s */
    public static void m36761s(String str, String str2) {
        if (f22361ok && str2 != null && f22360a <= 5) {
            Log.w(str, str2);
        }
    }

    /* renamed from: ok */
    public static void m36768ok() {
        f22361ok = true;
        m36767ok(3);
    }

    /* renamed from: a */
    public static void m36773a(String str, String str2, Throwable th) {
        if (f22361ok) {
            if (!(str2 == null && th == null) && f22360a <= 5) {
                Log.w(str, str2, th);
            }
        }
    }

    /* renamed from: bl */
    public static void m36770bl(String str, String str2, Throwable th) {
        if (f22361ok) {
            if (!(str2 == null && th == null) && f22360a <= 6) {
                Log.e(str, str2, th);
            }
        }
    }

    /* renamed from: ok */
    public static void m36765ok(String str, String str2) {
        if (f22361ok && str2 != null && f22360a <= 2) {
            Log.v(str, str2);
        }
    }

    /* renamed from: a */
    public static void m36772a(String str, Object... objArr) {
        if (f22361ok && objArr != null && f22360a <= 5) {
            Log.v(str, m36762ok(objArr));
        }
    }

    /* renamed from: ok */
    public static void m36764ok(String str, String str2, Throwable th) {
        if (f22361ok) {
            if (!(str2 == null && th == null) && f22360a <= 3) {
                Log.d(str, str2, th);
            }
        }
    }

    /* renamed from: ok */
    public static void m36763ok(String str, Object... objArr) {
        if (f22361ok && objArr != null && f22360a <= 3) {
            Log.d(str, m36762ok(objArr));
        }
    }

    /* renamed from: ok */
    public static void m36766ok(String str) {
        if (f22361ok) {
            m36761s("TTLogger", str);
        }
    }

    /* renamed from: ok */
    private static String m36762ok(Object... objArr) {
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
