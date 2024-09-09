package com.ss.android.socialbase.appdownloader;

import android.content.Context;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class gd {
    public static int c(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.xv.gw().getResources().getIdentifier(str, "layout", com.ss.android.socialbase.downloader.downloader.xv.gw().getPackageName());
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static int f(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.xv.gw().getResources().getIdentifier(str, "color", com.ss.android.socialbase.downloader.downloader.xv.gw().getPackageName());
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static int sr(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.xv.gw().getResources().getIdentifier(str, "style", com.ss.android.socialbase.downloader.downloader.xv.gw().getPackageName());
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static int ux(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.xv.gw().getResources().getIdentifier(str, "id", com.ss.android.socialbase.downloader.downloader.xv.gw().getPackageName());
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static int w(String str) {
        return c(com.ss.android.socialbase.downloader.downloader.xv.gw(), str);
    }

    public static int xv(String str) {
        try {
            return c(str, com.ss.android.socialbase.downloader.downloader.xv.gw().getPackageName());
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static int w(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.xv.gw().getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static int c(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "string", context.getPackageName());
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static int c(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.xv.gw().getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }
}
