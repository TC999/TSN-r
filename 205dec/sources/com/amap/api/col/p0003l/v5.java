package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ErrorLogManager.java */
/* renamed from: com.amap.api.col.3l.v5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class v5 {

    /* renamed from: a  reason: collision with root package name */
    private static WeakReference<b7> f9214a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f9215b = true;

    /* renamed from: c  reason: collision with root package name */
    private static WeakReference<w7> f9216c;

    /* renamed from: d  reason: collision with root package name */
    private static WeakReference<w7> f9217d;

    /* renamed from: e  reason: collision with root package name */
    private static String[] f9218e = new String[10];

    /* renamed from: f  reason: collision with root package name */
    private static int f9219f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f9220g;

    /* renamed from: h  reason: collision with root package name */
    private static int f9221h;

    /* renamed from: i  reason: collision with root package name */
    private static p4 f9222i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ErrorLogManager.java */
    /* renamed from: com.amap.api.col.3l.v5$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a extends a8 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f9223a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ p4 f9224b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f9225c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f9226d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ b7 f9227e;

        a(Context context, p4 p4Var, String str, String str2, b7 b7Var) {
            this.f9223a = context;
            this.f9224b = p4Var;
            this.f9225c = str;
            this.f9226d = str2;
            this.f9227e = b7Var;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            String b4 = v5.b(this.f9223a, this.f9224b, this.f9225c, this.f9226d);
            b7 b7Var = this.f9227e;
            if (b7Var.f7268e == null) {
                b7Var.f7268e = new h6(new i6(new k6(new l6())));
            }
            try {
                c7.c(m4.e(b4), q4.o(b4), this.f9227e);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ErrorLogManager.java */
    /* renamed from: com.amap.api.col.3l.v5$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class b extends a8 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f9228a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9229b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ w7 f9230c;

        b(Context context, String str, w7 w7Var) {
            this.f9228a = context;
            this.f9229b = str;
            this.f9230c = w7Var;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            try {
                synchronized (v5.class) {
                    b7 a4 = i7.a(v5.f9214a);
                    i7.f(this.f9228a, a4, this.f9229b, 1000, 4096000, "1");
                    a4.f7269f = this.f9230c;
                    if (a4.f7270g == null) {
                        a4.f7270g = new m7(new l7(this.f9228a, new q7(), new i6(new k6(new l6())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", e4.j(this.f9228a), i4.P(), i4.Z(this.f9228a), e4.g(this.f9228a), Build.MODEL, e4.e(this.f9228a), e4.h(this.f9228a), Build.VERSION.RELEASE));
                    }
                    a4.f7271h = 3600000;
                    c7.a(a4);
                }
            } catch (Throwable th) {
                u5.p(th, "lg", "pul");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ErrorLogManager.java */
    /* renamed from: com.amap.api.col.3l.v5$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class c extends a8 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b7 f9231a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f9232b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f9233c;

        c(b7 b7Var, Context context, d dVar) {
            this.f9231a = b7Var;
            this.f9232b = context;
            this.f9233c = dVar;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            try {
                synchronized (v5.class) {
                    b7 b7Var = this.f9231a;
                    if (b7Var.f7270g == null) {
                        b7Var.f7270g = new m7(new l7(this.f9232b, new q7(), new i6(new k6(new l6())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", e4.j(this.f9232b), i4.P(), i4.Z(this.f9232b), e4.g(this.f9232b), Build.MODEL, e4.e(this.f9232b), e4.h(this.f9232b), Build.VERSION.RELEASE));
                    }
                    int a4 = c7.a(this.f9231a);
                    d dVar = this.f9233c;
                    if (dVar != null) {
                        dVar.a(a4);
                    }
                }
            } catch (Throwable th) {
                u5.p(th, "lg", "pul");
            }
        }
    }

    /* compiled from: ErrorLogManager.java */
    /* renamed from: com.amap.api.col.3l.v5$d */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface d {
        void a(int i4);
    }

    private static p4 a(String str) {
        List<p4> b4 = r5.b();
        if (b4 == null) {
            b4 = new ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (p4 p4Var : b4) {
                if (r5.f(p4Var.i(), str)) {
                    return p4Var;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return q4.a();
                } catch (fk e4) {
                    e4.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    p4 p3 = q4.p();
                    p3.c(true);
                    return p3;
                } catch (fk e5) {
                    e5.printStackTrace();
                }
            }
        }
        return null;
    }

    static /* synthetic */ String b(Context context, p4 p4Var, String str, String str2) {
        String b4 = i7.b();
        String c4 = i7.c(context, p4Var);
        e4.a(context);
        return i7.e(c4, b4, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0101 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x00f5 -> B:107:0x00f8). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String c(java.util.List<com.amap.api.col.p0003l.p4> r11) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.v5.c(java.util.List):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(Context context) {
        String c4;
        p4 p4Var;
        List<p4> b4 = r5.b();
        if (b4 == null || b4.size() == 0 || (c4 = c(b4)) == null || "".equals(c4) || (p4Var = f9222i) == null) {
            return;
        }
        f(context, p4Var, 2, "ANR", c4);
    }

    private static void f(Context context, p4 p4Var, int i4, String str, String str2) {
        String str3;
        String b4 = i7.b();
        String c4 = i7.c(context, p4Var);
        e4.a(context);
        String d4 = i7.d(c4, b4, i4, str, str2);
        if (d4 == null || "".equals(d4)) {
            return;
        }
        String e4 = m4.e(str2);
        if (i4 == 1) {
            str3 = r5.f8893b;
        } else if (i4 == 2) {
            str3 = r5.f8895d;
        } else if (i4 != 0) {
            return;
        } else {
            str3 = r5.f8894c;
        }
        String str4 = str3;
        b7 a4 = i7.a(f9214a);
        i7.f(context, a4, str4, 1000, 4096000, "1");
        if (a4.f7268e == null) {
            a4.f7268e = new h6(new i6(new k6(new l6())));
        }
        try {
            c7.c(e4, q4.o(d4.replaceAll("\n", "<br/>")), a4);
        } catch (Throwable unused) {
        }
    }

    public static void g(Context context, p4 p4Var, String str, int i4, String str2, String str3) {
        if (str2 == null || "".equals(str2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("class:");
        sb.append(str2);
        if (str3 != null) {
            sb.append(" method:");
            sb.append(str3);
            sb.append("$<br/>");
        }
        sb.append(str);
        f(context, p4Var, i4, str2, sb.toString());
    }

    public static void h(Context context, p4 p4Var, String str, b7 b7Var, String str2) {
        try {
            z7.h().b(new a(context, p4Var, str, str2, b7Var));
        } catch (Throwable unused) {
        }
    }

    public static void i(Context context, b7 b7Var, d dVar) {
        try {
            z7.h().b(new c(b7Var, context, dVar));
        } catch (Throwable unused) {
        }
    }

    private static void j(Context context, w7 w7Var, String str) {
        z7.h().b(new b(context, str, w7Var));
    }

    public static void k(Context context, Throwable th, int i4, String str, String str2) {
        String e4 = q4.e(th);
        p4 a4 = a(e4);
        if (m(a4)) {
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
            f(context, a4, i4, th2, sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(p4 p4Var, Context context, String str, String str2) {
        if (!m(p4Var) || str == null || "".equals(str)) {
            return;
        }
        f(context, p4Var, 1, str, str2);
    }

    private static boolean m(p4 p4Var) {
        return p4Var != null && p4Var.h();
    }

    private static String n() {
        StringBuilder sb = new StringBuilder();
        try {
            for (int i4 = f9219f; i4 < 10 && i4 <= 9; i4++) {
                sb.append(f9218e[i4]);
            }
            for (int i5 = 0; i5 < f9219f; i5++) {
                sb.append(f9218e[i5]);
            }
        } catch (Throwable th) {
            u5.p(th, "alg", "gLI");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void o(Context context) {
        u7 u7Var = new u7(f9215b);
        f9215b = false;
        j(context, u7Var, r5.f8894c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void p(Context context) {
        WeakReference<w7> weakReference = f9216c;
        if (weakReference == null || weakReference.get() == null) {
            f9216c = new WeakReference<>(new v7(context, 3600000, "hKey", new x7(context, false)));
        }
        j(context, f9216c.get(), r5.f8895d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void q(Context context) {
        WeakReference<w7> weakReference = f9217d;
        if (weakReference == null || weakReference.get() == null) {
            f9217d = new WeakReference<>(new v7(context, 3600000, "gKey", new x7(context, false)));
        }
        j(context, f9217d.get(), r5.f8893b);
    }
}
