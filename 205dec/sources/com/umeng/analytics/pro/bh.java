package com.umeng.analytics.pro;

import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Logger.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bh {

    /* renamed from: a  reason: collision with root package name */
    private static final String f52629a = "OpenId";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f52630b;

    public static void a(boolean z3) {
        Log.d("OpenId", "setDebug:" + z3);
        f52630b = z3;
    }

    public static void b(String str, Object... objArr) {
        if (f52630b) {
            Log.i("OpenId", e(str, objArr));
        }
    }

    public static void c(String str, Object... objArr) {
        if (f52630b) {
            Log.w("OpenId", e(str, objArr));
        }
    }

    public static void d(String str, Object... objArr) {
        if (f52630b) {
            Log.e("OpenId", e(str, objArr));
        }
    }

    private static String e(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Object[] objArr2 = new Object[1];
        if (str == null) {
            str = "-";
        }
        int i4 = 0;
        objArr2[0] = str;
        sb.append(String.format("[%s] ", objArr2));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i5 = i4 + 1;
                if (i5 >= objArr.length) {
                    break;
                }
                sb.append(a(objArr[i4], objArr[i5]));
                if (i5 < length - 1) {
                    sb.append(",");
                }
                i4 = i5 + 1;
            }
            if (i4 == objArr.length - 1) {
                sb.append(objArr[i4]);
            }
        }
        return sb.toString();
    }

    public static void a(String str, Object... objArr) {
        if (f52630b) {
            Log.d("OpenId", e(str, objArr));
        }
    }

    private static String a(Object obj, Object obj2) {
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
