package com.umeng.analytics.pro;

import android.util.Log;

/* compiled from: Logger.java */
/* renamed from: com.umeng.analytics.pro.bh */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13124bh {

    /* renamed from: a */
    private static final String f37742a = "OpenId";

    /* renamed from: b */
    private static boolean f37743b;

    /* renamed from: a */
    public static void m14663a(boolean z) {
        Log.d(f37742a, "setDebug:" + z);
        f37743b = z;
    }

    /* renamed from: b */
    public static void m14662b(String str, Object... objArr) {
        if (f37743b) {
            Log.i(f37742a, m14659e(str, objArr));
        }
    }

    /* renamed from: c */
    public static void m14661c(String str, Object... objArr) {
        if (f37743b) {
            Log.w(f37742a, m14659e(str, objArr));
        }
    }

    /* renamed from: d */
    public static void m14660d(String str, Object... objArr) {
        if (f37743b) {
            Log.e(f37742a, m14659e(str, objArr));
        }
    }

    /* renamed from: e */
    private static String m14659e(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Object[] objArr2 = new Object[1];
        if (str == null) {
            str = "-";
        }
        int i = 0;
        objArr2[0] = str;
        sb.append(String.format("[%s] ", objArr2));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i2 = i + 1;
                if (i2 >= objArr.length) {
                    break;
                }
                sb.append(m14665a(objArr[i], objArr[i2]));
                if (i2 < length - 1) {
                    sb.append(",");
                }
                i = i2 + 1;
            }
            if (i == objArr.length - 1) {
                sb.append(objArr[i]);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static void m14664a(String str, Object... objArr) {
        if (f37743b) {
            Log.d(f37742a, m14659e(str, objArr));
        }
    }

    /* renamed from: a */
    private static String m14665a(Object obj, Object obj2) {
        Object[] objArr = new Object[2];
        if (obj == null) {
            obj = "";
        }
        objArr[0] = obj;
        if (obj2 == null) {
            obj2 = "";
        }
        objArr[1] = obj2;
        return String.format("%s:%s", objArr);
    }
}
