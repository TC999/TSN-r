package com.amap.api.col.s;

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
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e2 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9818a = "/a/";

    /* renamed from: b  reason: collision with root package name */
    static final String f9819b = "b";

    /* renamed from: c  reason: collision with root package name */
    static final String f9820c = "c";

    /* renamed from: d  reason: collision with root package name */
    static final String f9821d = "d";

    /* renamed from: e  reason: collision with root package name */
    public static String f9822e = "s";

    /* renamed from: f  reason: collision with root package name */
    public static final String f9823f = "g";

    /* renamed from: g  reason: collision with root package name */
    public static final String f9824g = "h";

    /* renamed from: h  reason: collision with root package name */
    public static final String f9825h = "e";

    /* renamed from: i  reason: collision with root package name */
    public static final String f9826i = "f";

    /* renamed from: j  reason: collision with root package name */
    public static final String f9827j = "j";

    /* renamed from: k  reason: collision with root package name */
    public static final String f9828k = "k";

    /* renamed from: l  reason: collision with root package name */
    private static long f9829l;

    /* renamed from: m  reason: collision with root package name */
    private static Vector<i1> f9830m = new Vector<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Log.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a extends z3 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f9831b;

        a(Context context) {
            this.f9831b = context;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            try {
                h2.k(this.f9831b);
                h2.m(this.f9831b);
                h2.l(this.f9831b);
                h3.b(this.f9831b);
                f3.b(this.f9831b);
            } catch (RejectedExecutionException unused) {
            } catch (Throwable th) {
                g2.o(th, "Lg", "proL");
            }
        }
    }

    public static String a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<i1> b() {
        Vector<i1> vector;
        try {
            synchronized (Looper.getMainLooper()) {
                vector = f9830m;
            }
            return vector;
        } catch (Throwable th) {
            th.printStackTrace();
            return f9830m;
        }
    }

    public static void c(Context context) {
        try {
            if (System.currentTimeMillis() - f9829l < 60000) {
                return;
            }
            f9829l = System.currentTimeMillis();
            y3.e().c(new a(context));
        } catch (Throwable th) {
            g2.o(th, "Lg", "proL");
        }
    }

    @TargetApi(9)
    public static void d(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void e(i1 i1Var) {
        try {
            synchronized (Looper.getMainLooper()) {
                if (i1Var == null) {
                    return;
                }
                if (f9830m.contains(i1Var)) {
                    return;
                }
                f9830m.add(i1Var);
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
        if (h(r6, r7[r2].trim()) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean f(java.lang.String[] r6, java.lang.String r7) {
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
            boolean r4 = h(r6, r4)     // Catch: java.lang.Throwable -> L49
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
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.e2.f(java.lang.String[], java.lang.String):boolean");
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
        return context.getFilesDir().getAbsolutePath() + f9818a + str;
    }
}
