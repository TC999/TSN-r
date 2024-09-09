package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ErrorLogManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class h2 {

    /* renamed from: a  reason: collision with root package name */
    private static WeakReference<c3> f9879a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f9880b = true;

    /* renamed from: c  reason: collision with root package name */
    private static WeakReference<v3> f9881c;

    /* renamed from: d  reason: collision with root package name */
    private static WeakReference<v3> f9882d;

    /* renamed from: e  reason: collision with root package name */
    private static String[] f9883e = new String[10];

    /* renamed from: f  reason: collision with root package name */
    private static int f9884f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f9885g;

    /* renamed from: h  reason: collision with root package name */
    private static int f9886h;

    /* renamed from: i  reason: collision with root package name */
    private static i1 f9887i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ErrorLogManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a extends z3 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f9888b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f9889c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ v3 f9890d;

        a(Context context, String str, v3 v3Var) {
            this.f9888b = context;
            this.f9889c = str;
            this.f9890d = v3Var;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            try {
                synchronized (h2.class) {
                    c3 a4 = i3.a(h2.f9879a);
                    i3.e(this.f9888b, a4, this.f9889c, 1000, 4096000, "1");
                    a4.f9704f = this.f9890d;
                    if (a4.f9705g == null) {
                        a4.f9705g = new m3(new l3(this.f9888b, new q3(), new m2(new o2(new p2())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", x0.i(this.f9888b), c1.H(), c1.K(this.f9888b), x0.f(this.f9888b), Build.MODEL, x0.d(this.f9888b), x0.g(this.f9888b), Build.VERSION.RELEASE));
                    }
                    a4.f9706h = 3600000;
                    d3.a(a4);
                }
            } catch (Throwable th) {
                g2.o(th, "lg", "pul");
            }
        }
    }

    private static i1 a(String str) {
        List<i1> b4 = e2.b();
        if (b4 == null) {
            b4 = new ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (i1 i1Var : b4) {
                if (e2.f(i1Var.i(), str)) {
                    return i1Var;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return j1.a();
                } catch (bv e4) {
                    e4.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    i1 p3 = j1.p();
                    p3.b();
                    return p3;
                } catch (bv e5) {
                    e5.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0101 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x00f5 -> B:107:0x00f8). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String b(java.util.List<com.amap.api.col.s.i1> r11) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.h2.b(java.util.List):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context) {
        String b4;
        i1 i1Var;
        List<i1> b5 = e2.b();
        if (b5 == null || b5.size() == 0 || (b4 = b(b5)) == null || "".equals(b4) || (i1Var = f9887i) == null) {
            return;
        }
        e(context, i1Var, 2, "ANR", b4);
    }

    private static void e(Context context, i1 i1Var, int i4, String str, String str2) {
        String str3;
        String b4 = i3.b();
        String c4 = i3.c(context, i1Var);
        x0.a(context);
        String d4 = i3.d(c4, b4, i4, str, str2);
        if (d4 == null || "".equals(d4)) {
            return;
        }
        String d5 = g1.d(str2);
        if (i4 == 1) {
            str3 = e2.f9819b;
        } else if (i4 == 2) {
            str3 = e2.f9821d;
        } else if (i4 != 0) {
            return;
        } else {
            str3 = e2.f9820c;
        }
        String str4 = str3;
        c3 a4 = i3.a(f9879a);
        i3.e(context, a4, str4, 1000, 4096000, "1");
        if (a4.f9703e == null) {
            a4.f9703e = new l2(new m2(new o2(new p2())));
        }
        try {
            d3.c(d5, j1.o(d4.replaceAll("\n", "<br/>")), a4);
        } catch (Throwable unused) {
        }
    }

    private static void f(Context context, v3 v3Var, String str) {
        y3.e().c(new a(context, str, v3Var));
    }

    public static void g(Context context, Throwable th, int i4, String str, String str2) {
        String e4 = j1.e(th);
        i1 a4 = a(e4);
        if (i(a4)) {
            String replaceAll = e4.replaceAll("\n", "<br/>");
            String th2 = th.toString();
            if (th2 == null || "".equals(th2)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                sb.append("class:");
                sb.append(str);
            }
            if (str2 != null) {
                sb.append(" method:");
                sb.append(str2);
                sb.append("$<br/>");
            }
            sb.append(replaceAll);
            e(context, a4, i4, th2, sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(i1 i1Var, Context context, String str, String str2) {
        if (!i(i1Var) || str == null || "".equals(str)) {
            return;
        }
        e(context, i1Var, 1, str, str2);
    }

    private static boolean i(i1 i1Var) {
        return i1Var != null && i1Var.h();
    }

    private static String j() {
        StringBuilder sb = new StringBuilder();
        try {
            for (int i4 = f9884f; i4 < 10 && i4 <= 9; i4++) {
                sb.append(f9883e[i4]);
            }
            for (int i5 = 0; i5 < f9884f; i5++) {
                sb.append(f9883e[i5]);
            }
        } catch (Throwable th) {
            g2.o(th, "alg", "gLI");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(Context context) {
        t3 t3Var = new t3(f9880b);
        f9880b = false;
        f(context, t3Var, e2.f9820c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(Context context) {
        WeakReference<v3> weakReference = f9881c;
        if (weakReference == null || weakReference.get() == null) {
            f9881c = new WeakReference<>(new u3(context, 3600000, "hKey", new w3(context)));
        }
        f(context, f9881c.get(), e2.f9821d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void m(Context context) {
        WeakReference<v3> weakReference = f9882d;
        if (weakReference == null || weakReference.get() == null) {
            f9882d = new WeakReference<>(new u3(context, 3600000, "gKey", new w3(context)));
        }
        f(context, f9882d.get(), e2.f9819b);
    }
}
