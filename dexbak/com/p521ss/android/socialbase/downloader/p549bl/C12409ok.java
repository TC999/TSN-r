package com.p521ss.android.socialbase.downloader.p549bl;

import android.text.TextUtils;
import android.util.Log;

/* renamed from: com.ss.android.socialbase.downloader.bl.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12409ok {

    /* renamed from: a */
    private static AbstractC12410ok f34962a = null;

    /* renamed from: ok */
    private static int f34963ok = 4;

    /* renamed from: com.ss.android.socialbase.downloader.bl.ok$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static abstract class AbstractC12410ok {
        /* renamed from: a */
        public void m17893a(String str, String str2) {
        }

        /* renamed from: bl */
        public void m17892bl(String str, String str2) {
        }

        /* renamed from: n */
        public void m17891n(String str, String str2) {
        }

        /* renamed from: ok */
        public void m17890ok(String str, String str2) {
        }

        /* renamed from: ok */
        public void m17889ok(String str, String str2, Throwable th) {
        }

        /* renamed from: s */
        public void m17888s(String str, String str2) {
        }
    }

    /* renamed from: a */
    public static String m17905a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "DownloaderLogger";
        }
        return "Downloader-" + str;
    }

    /* renamed from: bl */
    public static void m17901bl(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f34963ok <= 4) {
            Log.i(m17905a(str), str2);
        }
        AbstractC12410ok abstractC12410ok = f34962a;
        if (abstractC12410ok != null) {
            abstractC12410ok.m17892bl(m17905a(str), str2);
        }
    }

    /* renamed from: n */
    public static void m17900n(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f34963ok <= 6) {
            Log.e(m17905a(str), str2);
        }
        AbstractC12410ok abstractC12410ok = f34962a;
        if (abstractC12410ok != null) {
            abstractC12410ok.m17888s(m17905a(str), str2);
        }
    }

    /* renamed from: ok */
    public static void m17898ok(int i) {
        f34963ok = i;
    }

    /* renamed from: s */
    public static void m17894s(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f34963ok <= 5) {
            Log.w(m17905a(str), str2);
        }
        AbstractC12410ok abstractC12410ok = f34962a;
        if (abstractC12410ok != null) {
            abstractC12410ok.m17891n(m17905a(str), str2);
        }
    }

    /* renamed from: ok */
    public static boolean m17899ok() {
        return f34963ok <= 3;
    }

    /* renamed from: a */
    public static void m17904a(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f34963ok <= 3) {
            Log.d(m17905a(str), str2);
        }
        AbstractC12410ok abstractC12410ok = f34962a;
        if (abstractC12410ok != null) {
            abstractC12410ok.m17893a(m17905a(str), str2);
        }
    }

    /* renamed from: ok */
    public static void m17896ok(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (f34963ok <= 2) {
            Log.v(str, str2);
        }
        AbstractC12410ok abstractC12410ok = f34962a;
        if (abstractC12410ok != null) {
            abstractC12410ok.m17890ok(m17905a(str), str2);
        }
    }

    /* renamed from: bl */
    public static void m17902bl(String str) {
        m17894s("DownloaderLogger", str);
    }

    /* renamed from: a */
    public static void m17903a(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (f34963ok <= 6) {
            Log.e(m17905a(str), str2, th);
        }
        AbstractC12410ok abstractC12410ok = f34962a;
        if (abstractC12410ok != null) {
            abstractC12410ok.m17889ok(m17905a(str), str2, th);
        }
    }

    /* renamed from: ok */
    public static void m17897ok(String str) {
        m17904a("DownloaderLogger", str);
    }

    /* renamed from: ok */
    public static void m17895ok(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (f34963ok <= 3) {
            Log.d(m17905a(str), str2, th);
        }
        AbstractC12410ok abstractC12410ok = f34962a;
        if (abstractC12410ok != null) {
            String m17905a = m17905a(str);
            abstractC12410ok.m17893a(m17905a, str2 + th);
        }
    }
}
