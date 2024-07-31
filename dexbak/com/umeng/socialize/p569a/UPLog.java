package com.umeng.socialize.p569a;

import android.text.TextUtils;
import android.util.Log;

/* renamed from: com.umeng.socialize.a.m */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UPLog {

    /* renamed from: a */
    private static boolean f39330a;

    /* renamed from: a */
    public static void m13364a(boolean z) {
        f39330a = z;
    }

    /* renamed from: b */
    public static void m13361b(String str, Object... objArr) {
        if (m13369a()) {
            m13368a(4, str, m13363a(objArr));
        }
    }

    /* renamed from: c */
    public static void m13360c(String str, Object... objArr) {
        if (m13369a()) {
            m13368a(5, str, m13363a(objArr));
        }
    }

    /* renamed from: d */
    public static void m13359d(String str, Object... objArr) {
        if (m13369a()) {
            m13368a(6, str, m13363a(objArr));
        }
    }

    /* renamed from: a */
    public static boolean m13369a() {
        return f39330a;
    }

    /* renamed from: a */
    public static void m13366a(String str, Object... objArr) {
        if (m13369a()) {
            m13368a(3, str, m13363a(objArr));
        }
    }

    /* renamed from: b */
    private static void m13362b(int i, String str, String str2) {
        if (i == 3) {
            Log.d(m13367a(str), str2);
        } else if (i == 4) {
            Log.i(m13367a(str), str2);
        } else if (i == 5) {
            Log.w(m13367a(str), str2);
        } else if (i != 6) {
        } else {
            Log.e(m13367a(str), str2);
        }
    }

    /* renamed from: a */
    private static void m13368a(int i, String str, String str2) {
        if (str2 == null) {
            return;
        }
        while (str2.length() > 3072) {
            m13362b(i, str, str2.substring(0, 3072));
            str2 = str2.substring(3072);
        }
        if (str2.length() > 0) {
            m13362b(i, str, str2);
        }
    }

    /* renamed from: a */
    public static String m13365a(Throwable th) {
        return Log.getStackTraceString(th);
    }

    /* renamed from: a */
    private static String m13367a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "AZX";
        }
        return "AZX." + str;
    }

    /* renamed from: a */
    private static String m13363a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        if (objArr.length == 1) {
            return String.valueOf(objArr[0]);
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }
}
