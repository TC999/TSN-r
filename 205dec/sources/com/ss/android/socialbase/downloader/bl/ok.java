package com.ss.android.socialbase.downloader.bl;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok {

    /* renamed from: a  reason: collision with root package name */
    private static AbstractC0973ok f49301a = null;
    private static int ok = 4;

    /* renamed from: com.ss.android.socialbase.downloader.bl.ok$ok  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static abstract class AbstractC0973ok {
        public void a(String str, String str2) {
        }

        public void bl(String str, String str2) {
        }

        public void n(String str, String str2) {
        }

        public void ok(String str, String str2) {
        }

        public void ok(String str, String str2, Throwable th) {
        }

        public void s(String str, String str2) {
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "DownloaderLogger";
        }
        return "Downloader-" + str;
    }

    public static void bl(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (ok <= 4) {
            Log.i(a(str), str2);
        }
        AbstractC0973ok abstractC0973ok = f49301a;
        if (abstractC0973ok != null) {
            abstractC0973ok.bl(a(str), str2);
        }
    }

    public static void n(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (ok <= 6) {
            Log.e(a(str), str2);
        }
        AbstractC0973ok abstractC0973ok = f49301a;
        if (abstractC0973ok != null) {
            abstractC0973ok.s(a(str), str2);
        }
    }

    public static void ok(int i4) {
        ok = i4;
    }

    public static void s(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (ok <= 5) {
            Log.w(a(str), str2);
        }
        AbstractC0973ok abstractC0973ok = f49301a;
        if (abstractC0973ok != null) {
            abstractC0973ok.n(a(str), str2);
        }
    }

    public static boolean ok() {
        return ok <= 3;
    }

    public static void a(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (ok <= 3) {
            Log.d(a(str), str2);
        }
        AbstractC0973ok abstractC0973ok = f49301a;
        if (abstractC0973ok != null) {
            abstractC0973ok.a(a(str), str2);
        }
    }

    public static void ok(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (ok <= 2) {
            Log.v(str, str2);
        }
        AbstractC0973ok abstractC0973ok = f49301a;
        if (abstractC0973ok != null) {
            abstractC0973ok.ok(a(str), str2);
        }
    }

    public static void bl(String str) {
        s("DownloaderLogger", str);
    }

    public static void a(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (ok <= 6) {
            Log.e(a(str), str2, th);
        }
        AbstractC0973ok abstractC0973ok = f49301a;
        if (abstractC0973ok != null) {
            abstractC0973ok.ok(a(str), str2, th);
        }
    }

    public static void ok(String str) {
        a("DownloaderLogger", str);
    }

    public static void ok(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (ok <= 3) {
            Log.d(a(str), str2, th);
        }
        AbstractC0973ok abstractC0973ok = f49301a;
        if (abstractC0973ok != null) {
            String a4 = a(str);
            abstractC0973ok.a(a4, str2 + th);
        }
    }
}
