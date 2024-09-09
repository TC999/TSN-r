package com.bytedance.msdk.adapter.sr;

import android.util.Log;
import com.bytedance.msdk.f.bk;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    static boolean f27216c = true;

    /* renamed from: w  reason: collision with root package name */
    private static boolean f27217w = false;
    private static int xv = 4;

    public static void c(int i4) {
        xv = i4;
    }

    public static void sr(String str, String str2) {
        if (w() && str2 != null && xv <= 6) {
            Log.e(str, str2);
        }
    }

    public static boolean w() {
        return bk.f28306c || f27217w;
    }

    public static void xv(String str, String str2) {
        if (w() && str2 != null && xv <= 5) {
            Log.w(str, str2);
        }
    }

    public static void c() {
        f27217w = true;
        c(3);
    }

    public static void w(String str) {
        if (w()) {
            w("Logger", str);
        }
    }

    public static void c(String str) {
        if (w()) {
            c("Logger", str);
        }
    }

    public static void w(String str, String str2) {
        if (w() && str2 != null && xv <= 4) {
            Log.i(str, str2);
        }
    }

    public static void xv(String str) {
        if (w()) {
            sr("Logger", str);
        }
    }

    public static void c(String str, String str2) {
        if (w() && str2 != null && xv <= 3) {
            Log.d(str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (w()) {
            if (!(str2 == null && th == null) && xv <= 6) {
                Log.e(str, str2, th);
            }
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (w()) {
            if (!(str2 == null && th == null) && xv <= 3) {
                Log.d(str, str2, th);
            }
        }
    }
}
