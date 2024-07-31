package com.amap.api.col.p0463l;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.amap.api.col.3l.q5 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class Log {

    /* renamed from: a */
    public static final String f5118a = "/a/";

    /* renamed from: b */
    static final String f5119b = "b";

    /* renamed from: c */
    static final String f5120c = "c";

    /* renamed from: d */
    static final String f5121d = "d";

    /* renamed from: e */
    public static String f5122e = "s";

    /* renamed from: f */
    public static final String f5123f = "g";

    /* renamed from: g */
    public static final String f5124g = "h";

    /* renamed from: h */
    public static final String f5125h = "e";

    /* renamed from: i */
    public static final String f5126i = "f";

    /* renamed from: j */
    public static final String f5127j = "j";

    /* renamed from: k */
    public static final String f5128k = "k";

    /* renamed from: l */
    private static long f5129l;

    /* renamed from: m */
    private static Vector<SDKInfo> f5130m = new Vector<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Log.java */
    /* renamed from: com.amap.api.col.3l.q5$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C1927a extends ThreadTask {

        /* renamed from: a */
        final /* synthetic */ Context f5131a;

        C1927a(Context context) {
            this.f5131a = context;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            try {
                ErrorLogManager.m53773o(this.f5131a);
                ErrorLogManager.m53771q(this.f5131a);
                ErrorLogManager.m53772p(this.f5131a);
                StatisticsManager.m54913b(this.f5131a);
                OfflineLocManager.m55214d(this.f5131a);
            } catch (RejectedExecutionException unused) {
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "Lg", "proL");
            }
        }
    }

    /* renamed from: a */
    public static String m54114a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static List<SDKInfo> m54113b() {
        Vector<SDKInfo> vector;
        try {
            synchronized (Looper.getMainLooper()) {
                vector = f5130m;
            }
            return vector;
        } catch (Throwable th) {
            th.printStackTrace();
            return f5130m;
        }
    }

    /* renamed from: c */
    public static void m54112c(Context context) {
        try {
            if (System.currentTimeMillis() - f5129l < 60000) {
                return;
            }
            f5129l = System.currentTimeMillis();
            ThreadPool.m53398h().m55654b(new C1927a(context));
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "Lg", "proL");
        }
    }

    @TargetApi(9)
    /* renamed from: d */
    public static void m54111d(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    /* renamed from: e */
    public static void m54110e(SDKInfo sDKInfo) {
        try {
            synchronized (Looper.getMainLooper()) {
                if (sDKInfo == null) {
                    return;
                }
                if (f5130m.contains(sDKInfo)) {
                    return;
                }
                f5130m.add(sDKInfo);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
        r1 = r7.length;
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
        if (r2 >= r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
        if (m54107h(r6, r7[r2].trim()) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
        r2 = r2 + 1;
     */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m54109f(java.lang.String[] r6, java.lang.String r7) {
        /*
            r0 = 0
            if (r6 == 0) goto L4d
            if (r7 != 0) goto L6
            goto L4d
        L6:
            java.lang.String r1 = "\n"
            java.lang.String[] r7 = r7.split(r1)     // Catch: java.lang.Throwable -> L49
            int r1 = r7.length     // Catch: java.lang.Throwable -> L49
            r2 = 0
        Le:
            r3 = 1
            if (r2 >= r1) goto L35
            r4 = r7[r2]     // Catch: java.lang.Throwable -> L49
            java.lang.String r4 = r4.trim()     // Catch: java.lang.Throwable -> L49
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L49
            if (r5 != 0) goto L2e
            java.lang.String r5 = "at "
            boolean r5 = r4.startsWith(r5)     // Catch: java.lang.Throwable -> L49
            if (r5 == 0) goto L2e
            java.lang.String r5 = "uncaughtException"
            boolean r4 = r4.contains(r5)     // Catch: java.lang.Throwable -> L49
            if (r4 == 0) goto L2e
            goto L2f
        L2e:
            r3 = 0
        L2f:
            if (r3 == 0) goto L32
            return r0
        L32:
            int r2 = r2 + 1
            goto Le
        L35:
            int r1 = r7.length     // Catch: java.lang.Throwable -> L49
            r2 = 0
        L37:
            if (r2 >= r1) goto L4d
            r4 = r7[r2]     // Catch: java.lang.Throwable -> L49
            java.lang.String r4 = r4.trim()     // Catch: java.lang.Throwable -> L49
            boolean r4 = m54107h(r6, r4)     // Catch: java.lang.Throwable -> L49
            if (r4 == 0) goto L46
            return r3
        L46:
            int r2 = r2 + 1
            goto L37
        L49:
            r6 = move-exception
            r6.printStackTrace()
        L4d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.Log.m54109f(java.lang.String[], java.lang.String):boolean");
    }

    /* renamed from: g */
    public static void m54108g(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static boolean m54107h(String[] strArr, String str) {
        if (strArr != null && str != null) {
            try {
                for (String str2 : strArr) {
                    str = str.trim();
                    if (str.startsWith("at ")) {
                        if (str.contains(str2 + ".") && str.endsWith(")") && !str.contains("uncaughtException")) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: i */
    public static String m54106i(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + f5118a + str;
    }
}
