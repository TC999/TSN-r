package com.amap.api.col.p0003l;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Log.java */
/* renamed from: com.amap.api.col.3l.r5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class r5 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8892a = "/a/";

    /* renamed from: b  reason: collision with root package name */
    static final String f8893b = "b";

    /* renamed from: c  reason: collision with root package name */
    static final String f8894c = "c";

    /* renamed from: d  reason: collision with root package name */
    static final String f8895d = "d";

    /* renamed from: e  reason: collision with root package name */
    public static String f8896e = "s";

    /* renamed from: f  reason: collision with root package name */
    public static final String f8897f = "g";

    /* renamed from: g  reason: collision with root package name */
    public static final String f8898g = "h";

    /* renamed from: h  reason: collision with root package name */
    public static final String f8899h = "e";

    /* renamed from: i  reason: collision with root package name */
    public static final String f8900i = "f";

    /* renamed from: j  reason: collision with root package name */
    public static final String f8901j = "j";

    /* renamed from: k  reason: collision with root package name */
    public static final String f8902k = "k";

    /* renamed from: l  reason: collision with root package name */
    private static long f8903l;

    /* renamed from: m  reason: collision with root package name */
    private static Vector<p4> f8904m = new Vector<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Log.java */
    /* renamed from: com.amap.api.col.3l.r5$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a extends a8 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f8905a;

        a(Context context) {
            this.f8905a = context;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            try {
                v5.o(this.f8905a);
                v5.q(this.f8905a);
                v5.p(this.f8905a);
                h7.b(this.f8905a);
                f7.d(this.f8905a);
            } catch (RejectedExecutionException unused) {
            } catch (Throwable th) {
                u5.p(th, "Lg", "proL");
            }
        }
    }

    public static String a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<p4> b() {
        Vector<p4> vector;
        try {
            synchronized (Looper.getMainLooper()) {
                vector = f8904m;
            }
            return vector;
        } catch (Throwable th) {
            th.printStackTrace();
            return f8904m;
        }
    }

    public static void c(Context context) {
        try {
            if (System.currentTimeMillis() - f8903l < 60000) {
                return;
            }
            f8903l = System.currentTimeMillis();
            z7.h().b(new a(context));
        } catch (Throwable th) {
            u5.p(th, "Lg", "proL");
        }
    }

    @TargetApi(9)
    public static void d(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void e(p4 p4Var) {
        try {
            synchronized (Looper.getMainLooper()) {
                if (p4Var == null) {
                    return;
                }
                if (f8904m.contains(p4Var)) {
                    return;
                }
                f8904m.add(p4Var);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
        r1 = r7.length;
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
        if (r2 >= r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
        if (h(r6, r7[r2].trim()) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean f(java.lang.String[] r6, java.lang.String r7) {
        /*
            r0 = 0
            if (r6 == 0) goto L4e
            if (r7 != 0) goto L6
            goto L4e
        L6:
            java.lang.String r1 = "\n"
            java.lang.String[] r7 = r7.split(r1)     // Catch: java.lang.Throwable -> L4a
            int r1 = r7.length     // Catch: java.lang.Throwable -> L4a
            r2 = 0
        Le:
            r3 = 1
            if (r2 >= r1) goto L36
            r4 = r7[r2]     // Catch: java.lang.Throwable -> L4a
            java.lang.String r4 = r4.trim()     // Catch: java.lang.Throwable -> L4a
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L4a
            if (r5 != 0) goto L2f
            java.lang.String r5 = "at "
            boolean r5 = r4.startsWith(r5)     // Catch: java.lang.Throwable -> L4a
            if (r5 == 0) goto L2f
            java.lang.String r5 = "uncaughtException"
            boolean r4 = r4.contains(r5)     // Catch: java.lang.Throwable -> L4a
            if (r4 == 0) goto L2f
            goto L30
        L2f:
            r3 = 0
        L30:
            if (r3 == 0) goto L33
            return r0
        L33:
            int r2 = r2 + 1
            goto Le
        L36:
            int r1 = r7.length     // Catch: java.lang.Throwable -> L4a
            r2 = 0
        L38:
            if (r2 >= r1) goto L4e
            r4 = r7[r2]     // Catch: java.lang.Throwable -> L4a
            java.lang.String r4 = r4.trim()     // Catch: java.lang.Throwable -> L4a
            boolean r4 = h(r6, r4)     // Catch: java.lang.Throwable -> L4a
            if (r4 == 0) goto L47
            return r3
        L47:
            int r2 = r2 + 1
            goto L38
        L4a:
            r6 = move-exception
            r6.printStackTrace()
        L4e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.r5.f(java.lang.String[], java.lang.String):boolean");
    }

    public static void g(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(String[] strArr, String str) {
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

    public static String i(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + f8892a + str;
    }
}
