package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class r {

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private String f49173c;

        /* renamed from: f  reason: collision with root package name */
        private int f49174f;

        /* renamed from: r  reason: collision with root package name */
        private boolean f49175r;
        private String sr;
        private String ux;

        /* renamed from: w  reason: collision with root package name */
        private String f49176w;
        private Drawable xv;

        public c(String str, String str2, Drawable drawable, String str3, String str4, int i4, boolean z3) {
            w(str2);
            c(drawable);
            c(str);
            xv(str3);
            sr(str4);
            c(i4);
            c(z3);
        }

        public Drawable c() {
            return this.xv;
        }

        public int f() {
            return this.f49174f;
        }

        public String r() {
            return this.ux;
        }

        public String sr() {
            return this.f49176w;
        }

        public String toString() {
            return "{\n  pkg name: " + xv() + "\n  app icon: " + c() + "\n  app name: " + sr() + "\n  app path: " + ux() + "\n  app v name: " + r() + "\n  app v code: " + f() + "\n  is system: " + w() + "}";
        }

        public String ux() {
            return this.sr;
        }

        public boolean w() {
            return this.f49175r;
        }

        public String xv() {
            return this.f49173c;
        }

        public void c(Drawable drawable) {
            this.xv = drawable;
        }

        public void sr(String str) {
            this.ux = str;
        }

        public void w(String str) {
            this.f49176w = str;
        }

        public void xv(String str) {
            this.sr = str;
        }

        public void c(boolean z3) {
            this.f49175r = z3;
        }

        public void c(String str) {
            this.f49173c = str;
        }

        public void c(int i4) {
            this.f49174f = i4;
        }
    }

    public static int c(String str) {
        if (xv(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = com.ss.android.socialbase.downloader.downloader.xv.gw().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return -1;
        }
    }

    public static c w(String str) {
        try {
            PackageManager packageManager = com.ss.android.socialbase.downloader.downloader.xv.gw().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return c(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static boolean xv(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            if (!Character.isWhitespace(str.charAt(i4))) {
                return false;
            }
        }
        return true;
    }

    private static c c(PackageManager packageManager, PackageInfo packageInfo) {
        Drawable drawable = null;
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String str = packageInfo.packageName;
        String charSequence = (applicationInfo == null || applicationInfo.loadLabel(packageManager) == null) ? "" : applicationInfo.loadLabel(packageManager).toString();
        try {
            drawable = applicationInfo.loadIcon(packageManager);
        } catch (Exception unused) {
        }
        return new c(str, charSequence, drawable, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }
}
