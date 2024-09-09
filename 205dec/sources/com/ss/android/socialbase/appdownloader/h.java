package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class h {

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok {

        /* renamed from: a  reason: collision with root package name */
        private String f49096a;
        private Drawable bl;

        /* renamed from: h  reason: collision with root package name */
        private boolean f49097h;
        private int kf;

        /* renamed from: n  reason: collision with root package name */
        private String f49098n;
        private String ok;

        /* renamed from: s  reason: collision with root package name */
        private String f49099s;

        public ok(String str, String str2, Drawable drawable, String str3, String str4, int i4, boolean z3) {
            a(str2);
            ok(drawable);
            ok(str);
            bl(str3);
            s(str4);
            ok(i4);
            ok(z3);
        }

        public boolean a() {
            return this.f49097h;
        }

        public String bl() {
            return this.ok;
        }

        public String h() {
            return this.f49098n;
        }

        public int kf() {
            return this.kf;
        }

        public String n() {
            return this.f49099s;
        }

        public Drawable ok() {
            return this.bl;
        }

        public String s() {
            return this.f49096a;
        }

        public String toString() {
            return "{\n  pkg name: " + bl() + "\n  app icon: " + ok() + "\n  app name: " + s() + "\n  app path: " + n() + "\n  app v name: " + h() + "\n  app v code: " + kf() + "\n  is system: " + a() + "}";
        }

        public void a(String str) {
            this.f49096a = str;
        }

        public void bl(String str) {
            this.f49099s = str;
        }

        public void ok(Drawable drawable) {
            this.bl = drawable;
        }

        public void s(String str) {
            this.f49098n = str;
        }

        public void ok(boolean z3) {
            this.f49097h = z3;
        }

        public void ok(String str) {
            this.ok = str;
        }

        public void ok(int i4) {
            this.kf = i4;
        }
    }

    public static ok a(String str) {
        try {
            PackageManager packageManager = com.ss.android.socialbase.downloader.downloader.bl.l().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return ok(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static boolean bl(String str) {
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

    public static int ok(String str) {
        if (bl(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = com.ss.android.socialbase.downloader.downloader.bl.l().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return -1;
        }
    }

    private static ok ok(PackageManager packageManager, PackageInfo packageInfo) {
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
        return new ok(str, charSequence, drawable, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }
}
