package com.ss.android.downloadlib.addownload.w;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.k;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private static volatile sr f48718c;

    /* renamed from: w  reason: collision with root package name */
    private final LinkedList<c> f48719w = new LinkedList<>();
    private static final String[] xv = {"com", "android", "ss"};
    private static final int[] sr = {3101, 3102, 3103, 3201, 3202, 3203};

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        public final String f48720c;
        public final String sr;
        public final long ux;

        /* renamed from: w  reason: collision with root package name */
        public final int f48721w;
        public final String xv;

        private c(String str, int i4, String str2, String str3, long j4) {
            this.f48720c = str;
            this.f48721w = i4;
            this.xv = str2 != null ? str2.toLowerCase() : null;
            this.sr = str3 != null ? str3.toLowerCase() : null;
            this.ux = j4;
        }
    }

    private sr() {
    }

    public static sr c() {
        if (f48718c == null) {
            synchronized (sr.class) {
                if (f48718c == null) {
                    f48718c = new sr();
                }
            }
        }
        return f48718c;
    }

    private c xv(String str) {
        try {
            PackageManager packageManager = k.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new c(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void w(String str) {
        w();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f48719w) {
            Iterator<c> it = this.f48719w.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().f48720c)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public void c(String str) {
        c xv2;
        w();
        if (TextUtils.isEmpty(str) || (xv2 = xv(str)) == null) {
            return;
        }
        synchronized (this.f48719w) {
            this.f48719w.add(xv2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
        r7[1] = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<com.ss.android.downloadlib.addownload.w.sr.c, java.lang.Integer> w(com.ss.android.downloadad.api.c.w r19) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.w.sr.w(com.ss.android.downloadad.api.c.w):android.util.Pair");
    }

    public c c(com.ss.android.downloadad.api.c.w wVar) {
        if (wVar == null) {
            return null;
        }
        w();
        synchronized (this.f48719w) {
            Iterator<c> it = this.f48719w.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.ux > wVar.ba()) {
                    return next;
                }
            }
            return null;
        }
    }

    private static boolean c(String str, String str2) {
        String[] split;
        String[] split2;
        boolean z3;
        try {
            split = str.split("\\.");
            split2 = str2.split("\\.");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (split.length != 0 && split2.length != 0) {
            int i4 = 0;
            int i5 = 0;
            for (String str3 : split) {
                String[] strArr = xv;
                int length = strArr.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        z3 = false;
                        break;
                    }
                    String str4 = strArr[i6];
                    if (str4.equals(str3)) {
                        if (i4 < split2.length && str4.equals(split2[i4])) {
                            i4++;
                        }
                        z3 = true;
                    } else {
                        i6++;
                    }
                }
                if (!z3) {
                    int i7 = i5;
                    int i8 = i4;
                    while (i4 < split2.length) {
                        if (str3.equals(split2[i4])) {
                            if (i4 == i8) {
                                i8++;
                            }
                            i7++;
                            if (i7 >= 2) {
                                return true;
                            }
                        }
                        i4++;
                    }
                    i4 = i8;
                    i5 = i7;
                }
            }
            return false;
        }
        return false;
    }

    private void w() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f48719w) {
            Iterator<c> it = this.f48719w.iterator();
            while (it.hasNext() && currentTimeMillis - it.next().ux > 1800000) {
                it.remove();
            }
        }
    }
}
