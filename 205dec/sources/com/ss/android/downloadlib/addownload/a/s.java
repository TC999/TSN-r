package com.ss.android.downloadlib.addownload.a;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.r;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s {
    private static volatile s ok;

    /* renamed from: a  reason: collision with root package name */
    private final LinkedList<ok> f48382a = new LinkedList<>();
    private static final String[] bl = {"com", "android", "ss"};

    /* renamed from: s  reason: collision with root package name */
    private static final int[] f48381s = {3101, 3102, 3103, 3201, 3202, 3203};

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok {

        /* renamed from: a  reason: collision with root package name */
        public final int f48383a;
        public final String bl;

        /* renamed from: n  reason: collision with root package name */
        public final long f48384n;
        public final String ok;

        /* renamed from: s  reason: collision with root package name */
        public final String f48385s;

        private ok(String str, int i4, String str2, String str3, long j4) {
            this.ok = str;
            this.f48383a = i4;
            this.bl = str2 != null ? str2.toLowerCase() : null;
            this.f48385s = str3 != null ? str3.toLowerCase() : null;
            this.f48384n = j4;
        }
    }

    private s() {
    }

    private ok bl(String str) {
        try {
            PackageManager packageManager = r.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new ok(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static s ok() {
        if (ok == null) {
            synchronized (s.class) {
                if (ok == null) {
                    ok = new s();
                }
            }
        }
        return ok;
    }

    public void a(String str) {
        a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f48382a) {
            Iterator<ok> it = this.f48382a.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().ok)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public void ok(String str) {
        ok bl2;
        a();
        if (TextUtils.isEmpty(str) || (bl2 = bl(str)) == null) {
            return;
        }
        synchronized (this.f48382a) {
            this.f48382a.add(bl2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
        r7[1] = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<com.ss.android.downloadlib.addownload.a.s.ok, java.lang.Integer> a(com.ss.android.downloadad.api.ok.a r19) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.a.s.a(com.ss.android.downloadad.api.ok.a):android.util.Pair");
    }

    public ok ok(com.ss.android.downloadad.api.ok.a aVar) {
        if (aVar == null) {
            return null;
        }
        a();
        synchronized (this.f48382a) {
            Iterator<ok> it = this.f48382a.iterator();
            while (it.hasNext()) {
                ok next = it.next();
                if (next.f48384n > aVar.er()) {
                    return next;
                }
            }
            return null;
        }
    }

    private static boolean ok(String str, String str2) {
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
                String[] strArr = bl;
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

    private void a() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f48382a) {
            Iterator<ok> it = this.f48382a.iterator();
            while (it.hasNext() && currentTimeMillis - it.next().f48384n > 1800000) {
                it.remove();
            }
        }
    }
}
