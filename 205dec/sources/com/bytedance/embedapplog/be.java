package com.bytedance.embedapplog;

import android.util.Log;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class be {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f26701c;

    /* renamed from: w  reason: collision with root package name */
    public static boolean f26702w;

    public static void c(String str) {
        c(str, null);
    }

    public static void sr(String str, Throwable th) {
        Log.i("TeaLog", str, th);
    }

    public static void w(String str) {
        w(str, null);
    }

    public static void xv(String str, Throwable th) {
        Log.e("TeaLog", str, th);
    }

    public static void c(String str, Throwable th) {
        if (f26702w) {
            Log.d("TeaLog", str, th);
        }
    }

    public static void w(String str, Throwable th) {
        Log.w("TeaLog", str, th);
    }

    public static void w(Throwable th) {
        if (th != null) {
            Log.e("TeaLog", "U SHALL NOT PASS!", th);
        }
    }

    public static void c(Throwable th) {
        Log.e("TeaLog", "", th);
    }
}
