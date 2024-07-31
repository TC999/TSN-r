package com.p521ss.android.downloadlib.addownload.p528a;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.addownload.C12128r;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.ss.android.downloadlib.addownload.a.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12042s {

    /* renamed from: ok */
    private static volatile C12042s f34096ok;

    /* renamed from: a */
    private final LinkedList<C12044ok> f34098a = new LinkedList<>();

    /* renamed from: bl */
    private static final String[] f34095bl = {"com", FaceEnvironment.f8430OS, "ss"};

    /* renamed from: s */
    private static final int[] f34097s = {3101, 3102, 3103, 3201, 3202, 3203};

    /* renamed from: com.ss.android.downloadlib.addownload.a.s$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12044ok {

        /* renamed from: a */
        public final int f34099a;

        /* renamed from: bl */
        public final String f34100bl;

        /* renamed from: n */
        public final long f34101n;

        /* renamed from: ok */
        public final String f34102ok;

        /* renamed from: s */
        public final String f34103s;

        private C12044ok(String str, int i, String str2, String str3, long j) {
            this.f34102ok = str;
            this.f34099a = i;
            this.f34100bl = str2 != null ? str2.toLowerCase() : null;
            this.f34103s = str3 != null ? str3.toLowerCase() : null;
            this.f34101n = j;
        }
    }

    private C12042s() {
    }

    /* renamed from: bl */
    private C12044ok m19269bl(String str) {
        try {
            PackageManager packageManager = C12128r.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new C12044ok(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: ok */
    public static C12042s m19268ok() {
        if (f34096ok == null) {
            synchronized (C12042s.class) {
                if (f34096ok == null) {
                    f34096ok = new C12042s();
                }
            }
        }
        return f34096ok;
    }

    /* renamed from: a */
    public void m19270a(String str) {
        m19272a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f34098a) {
            Iterator<C12044ok> it = this.f34098a.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().f34102ok)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    /* renamed from: ok */
    public void m19266ok(String str) {
        C12044ok m19269bl;
        m19272a();
        if (TextUtils.isEmpty(str) || (m19269bl = m19269bl(str)) == null) {
            return;
        }
        synchronized (this.f34098a) {
            this.f34098a.add(m19269bl);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
        r7[1] = r11;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<com.p521ss.android.downloadlib.addownload.p528a.C12042s.C12044ok, java.lang.Integer> m19271a(com.p521ss.android.downloadad.api.p526ok.C11998a r19) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.downloadlib.addownload.p528a.C12042s.m19271a(com.ss.android.downloadad.api.ok.a):android.util.Pair");
    }

    /* renamed from: ok */
    public C12044ok m19267ok(C11998a c11998a) {
        if (c11998a == null) {
            return null;
        }
        m19272a();
        synchronized (this.f34098a) {
            Iterator<C12044ok> it = this.f34098a.iterator();
            while (it.hasNext()) {
                C12044ok next = it.next();
                if (next.f34101n > c11998a.m19505er()) {
                    return next;
                }
            }
            return null;
        }
    }

    /* renamed from: ok */
    private static boolean m19265ok(String str, String str2) {
        String[] split;
        String[] split2;
        boolean z;
        try {
            split = str.split("\\.");
            split2 = str2.split("\\.");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (split.length != 0 && split2.length != 0) {
            int i = 0;
            int i2 = 0;
            for (String str3 : split) {
                String[] strArr = f34095bl;
                int length = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = false;
                        break;
                    }
                    String str4 = strArr[i3];
                    if (str4.equals(str3)) {
                        if (i < split2.length && str4.equals(split2[i])) {
                            i++;
                        }
                        z = true;
                    } else {
                        i3++;
                    }
                }
                if (!z) {
                    int i4 = i2;
                    int i5 = i;
                    while (i < split2.length) {
                        if (str3.equals(split2[i])) {
                            if (i == i5) {
                                i5++;
                            }
                            i4++;
                            if (i4 >= 2) {
                                return true;
                            }
                        }
                        i++;
                    }
                    i = i5;
                    i2 = i4;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: a */
    private void m19272a() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f34098a) {
            Iterator<C12044ok> it = this.f34098a.iterator();
            while (it.hasNext() && currentTimeMillis - it.next().f34101n > 1800000) {
                it.remove();
            }
        }
    }
}
