package com.amap.api.col.p047s;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Log.java */
/* renamed from: com.amap.api.col.s.e2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2051e2 {

    /* renamed from: a */
    public static final String f6090a = "/a/";

    /* renamed from: b */
    static final String f6091b = "b";

    /* renamed from: c */
    static final String f6092c = "c";

    /* renamed from: d */
    static final String f6093d = "d";

    /* renamed from: e */
    public static String f6094e = "s";

    /* renamed from: f */
    public static final String f6095f = "g";

    /* renamed from: g */
    public static final String f6096g = "h";

    /* renamed from: h */
    public static final String f6097h = "e";

    /* renamed from: i */
    public static final String f6098i = "f";

    /* renamed from: j */
    public static final String f6099j = "j";

    /* renamed from: k */
    public static final String f6100k = "k";

    /* renamed from: l */
    private static long f6101l;

    /* renamed from: m */
    private static Vector<C2073i1> f6102m = new Vector<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Log.java */
    /* renamed from: com.amap.api.col.s.e2$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C2052a extends AbstractRunnableC2229z3 {

        /* renamed from: b */
        final /* synthetic */ Context f6103b;

        C2052a(Context context) {
            this.f6103b = context;
        }

        @Override // com.amap.api.col.p047s.AbstractRunnableC2229z3
        /* renamed from: a */
        public final void mo52171a() {
            try {
                C2068h2.m52949k(this.f6103b);
                C2068h2.m52947m(this.f6103b);
                C2068h2.m52948l(this.f6103b);
                C2070h3.m52945b(this.f6103b);
                C2056f3.m53008b(this.f6103b);
            } catch (RejectedExecutionException unused) {
            } catch (Throwable th) {
                C2060g2.m52972o(th, "Lg", "proL");
            }
        }
    }

    /* renamed from: a */
    public static String m53025a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static List<C2073i1> m53024b() {
        Vector<C2073i1> vector;
        try {
            synchronized (Looper.getMainLooper()) {
                vector = f6102m;
            }
            return vector;
        } catch (Throwable th) {
            th.printStackTrace();
            return f6102m;
        }
    }

    /* renamed from: c */
    public static void m53023c(Context context) {
        try {
            if (System.currentTimeMillis() - f6101l < 60000) {
                return;
            }
            f6101l = System.currentTimeMillis();
            C2225y3.m52184e().m53246c(new C2052a(context));
        } catch (Throwable th) {
            C2060g2.m52972o(th, "Lg", "proL");
        }
    }

    @TargetApi(9)
    /* renamed from: d */
    public static void m53022d(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    /* renamed from: e */
    public static void m53021e(C2073i1 c2073i1) {
        try {
            synchronized (Looper.getMainLooper()) {
                if (c2073i1 == null) {
                    return;
                }
                if (f6102m.contains(c2073i1)) {
                    return;
                }
                f6102m.add(c2073i1);
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
        if (m53018h(r6, r7[r2].trim()) == false) goto L26;
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
    public static boolean m53020f(java.lang.String[] r6, java.lang.String r7) {
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
            boolean r4 = m53018h(r6, r4)     // Catch: java.lang.Throwable -> L49
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
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p047s.C2051e2.m53020f(java.lang.String[], java.lang.String):boolean");
    }

    /* renamed from: g */
    public static void m53019g(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static boolean m53018h(String[] strArr, String str) {
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
    public static String m53017i(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + f6090a + str;
    }
}
