package com.p521ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;

/* renamed from: com.ss.android.socialbase.appdownloader.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12310h {

    /* renamed from: com.ss.android.socialbase.appdownloader.h$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12311ok {

        /* renamed from: a */
        private String f34667a;

        /* renamed from: bl */
        private Drawable f34668bl;

        /* renamed from: h */
        private boolean f34669h;

        /* renamed from: kf */
        private int f34670kf;

        /* renamed from: n */
        private String f34671n;

        /* renamed from: ok */
        private String f34672ok;

        /* renamed from: s */
        private String f34673s;

        public C12311ok(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            m18375a(str2);
            m18367ok(drawable);
            m18366ok(str);
            m18373bl(str3);
            m18363s(str4);
            m18368ok(i);
            m18365ok(z);
        }

        /* renamed from: a */
        public boolean m18376a() {
            return this.f34669h;
        }

        /* renamed from: bl */
        public String m18374bl() {
            return this.f34672ok;
        }

        /* renamed from: h */
        public String m18372h() {
            return this.f34671n;
        }

        /* renamed from: kf */
        public int m18371kf() {
            return this.f34670kf;
        }

        /* renamed from: n */
        public String m18370n() {
            return this.f34673s;
        }

        /* renamed from: ok */
        public Drawable m18369ok() {
            return this.f34668bl;
        }

        /* renamed from: s */
        public String m18364s() {
            return this.f34667a;
        }

        public String toString() {
            return "{\n  pkg name: " + m18374bl() + "\n  app icon: " + m18369ok() + "\n  app name: " + m18364s() + "\n  app path: " + m18370n() + "\n  app v name: " + m18372h() + "\n  app v code: " + m18371kf() + "\n  is system: " + m18376a() + "}";
        }

        /* renamed from: a */
        public void m18375a(String str) {
            this.f34667a = str;
        }

        /* renamed from: bl */
        public void m18373bl(String str) {
            this.f34673s = str;
        }

        /* renamed from: ok */
        public void m18367ok(Drawable drawable) {
            this.f34668bl = drawable;
        }

        /* renamed from: s */
        public void m18363s(String str) {
            this.f34671n = str;
        }

        /* renamed from: ok */
        public void m18365ok(boolean z) {
            this.f34669h = z;
        }

        /* renamed from: ok */
        public void m18366ok(String str) {
            this.f34672ok = str;
        }

        /* renamed from: ok */
        public void m18368ok(int i) {
            this.f34670kf = i;
        }
    }

    /* renamed from: a */
    public static C12311ok m18380a(String str) {
        try {
            PackageManager packageManager = C12490bl.m17807l().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return m18378ok(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: bl */
    private static boolean m18379bl(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ok */
    public static int m18377ok(String str) {
        if (m18379bl(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = C12490bl.m17807l().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: ok */
    private static C12311ok m18378ok(PackageManager packageManager, PackageInfo packageInfo) {
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
        return new C12311ok(str, charSequence, drawable, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }
}
