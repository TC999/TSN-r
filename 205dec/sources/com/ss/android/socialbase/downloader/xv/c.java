package com.ss.android.socialbase.downloader.xv;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static int f50231c = 4;

    /* renamed from: w  reason: collision with root package name */
    private static AbstractC1026c f50232w;

    /* renamed from: com.ss.android.socialbase.downloader.xv.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static abstract class AbstractC1026c {
        public void c(String str, String str2) {
        }

        public void c(String str, String str2, Throwable th) {
        }

        public void sr(String str, String str2) {
        }

        public void ux(String str, String str2) {
        }

        public void w(String str, String str2) {
        }

        public void xv(String str, String str2) {
        }
    }

    public static void c(int i4) {
        f50231c = i4;
    }

    public static void sr(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f50231c <= 5) {
            Log.w(w(str), str2);
        }
        AbstractC1026c abstractC1026c = f50232w;
        if (abstractC1026c != null) {
            abstractC1026c.ux(w(str), str2);
        }
    }

    public static void ux(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f50231c <= 6) {
            Log.e(w(str), str2);
        }
        AbstractC1026c abstractC1026c = f50232w;
        if (abstractC1026c != null) {
            abstractC1026c.sr(w(str), str2);
        }
    }

    public static String w(String str) {
        if (TextUtils.isEmpty(str)) {
            return "DownloaderLogger";
        }
        return "Downloader-" + str;
    }

    public static void xv(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f50231c <= 4) {
            Log.i(w(str), str2);
        }
        AbstractC1026c abstractC1026c = f50232w;
        if (abstractC1026c != null) {
            abstractC1026c.xv(w(str), str2);
        }
    }

    public static boolean c() {
        return f50231c <= 3;
    }

    public static void c(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f50231c <= 2) {
            Log.v(str, str2);
        }
        AbstractC1026c abstractC1026c = f50232w;
        if (abstractC1026c != null) {
            abstractC1026c.c(w(str), str2);
        }
    }

    public static void w(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f50231c <= 3) {
            Log.d(w(str), str2);
        }
        AbstractC1026c abstractC1026c = f50232w;
        if (abstractC1026c != null) {
            abstractC1026c.w(w(str), str2);
        }
    }

    public static void xv(String str) {
        sr("DownloaderLogger", str);
    }

    public static void c(String str) {
        w("DownloaderLogger", str);
    }

    public static void w(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (f50231c <= 6) {
            Log.e(w(str), str2, th);
        }
        AbstractC1026c abstractC1026c = f50232w;
        if (abstractC1026c != null) {
            abstractC1026c.c(w(str), str2, th);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (f50231c <= 3) {
            Log.d(w(str), str2, th);
        }
        AbstractC1026c abstractC1026c = f50232w;
        if (abstractC1026c != null) {
            String w3 = w(str);
            abstractC1026c.w(w3, str2 + th);
        }
    }
}
