package com.qq.e.comm.plugin.splash;

import com.qq.e.comm.plugin.g0.c0;
import com.qq.e.comm.plugin.t.c;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    static int f46124a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f46125b = String.valueOf(com.qq.e.comm.plugin.b.g.SPLASH.d());

    /* renamed from: c  reason: collision with root package name */
    private static int f46126c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i4) {
        f46124a = i4;
        if (i4 <= 0) {
            d1.a("\u5f00\u5c4f\u8d85\u65f6\u65f6\u957f\u5df2\u8bbe\u4e3a\u9ed8\u8ba4\u503c", new Object[0]);
            return;
        }
        com.qq.e.comm.plugin.d0.d.h f4 = com.qq.e.comm.plugin.d0.a.d().f();
        if (f46126c <= 0) {
            int i5 = 1500;
            int a4 = f4.a("spl_ltime_min", 1500);
            if (a4 <= 5000 && a4 > 0) {
                i5 = a4;
            }
            f46126c = i5;
        }
        int i6 = f46126c;
        if (i4 < i6) {
            GDTLogger.w("\u5f00\u5c4f\u8d85\u65f6\u65f6\u957f\u53d6\u503c\u8303\u56f4\u4e3a[" + f46126c + ", 5000]\uff0c\u5df2\u5c06\u8d85\u65f6\u65f6\u957f\u8bbe\u4e3a" + f46126c + "ms\u3002", null);
            i4 = i6;
        } else if (i4 > 5000) {
            GDTLogger.w("\u5f00\u5c4f\u8d85\u65f6\u65f6\u957f\u53d6\u503c\u8303\u56f4\u4e3a[" + f46126c + ", 5000]\uff0c\u5df2\u5c06\u8d85\u65f6\u65f6\u957f\u8bbe\u4e3a5000ms\u3002", null);
            i4 = 5000;
        }
        f4.a("spl_ltime", Integer.valueOf(i4));
    }

    private static int b() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("splashSkipShowDelay", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar == null) {
            return;
        }
        d(eVar);
        com.qq.e.comm.plugin.t.c.d().a(eVar, f46125b, "spsc", 0).a(eVar, f46125b, "slfup", 0).a(eVar, f46125b, "softc", "").a(eVar, f46125b, "sskphe", 0).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(String str) {
        return com.qq.e.comm.plugin.t.c.a("slfup", f46125b, str, 0, (c.b<Integer>) null) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("splashLoadedEnqueueHead", 0) == 1;
    }

    public static boolean f() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("sksned", -1) == -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("splashVideoMd5Check", 1) == 1;
    }

    public static boolean b(c0 c0Var) {
        return (c0Var == null || c0Var.Y0() || b() == 0) ? false : true;
    }

    static void d(com.qq.e.comm.plugin.g0.e eVar) {
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("spl_lptime", 5);
        if (a4 <= 10000 || eVar == null) {
            return;
        }
        o.a(com.qq.e.comm.plugin.t.a.b().a(eVar.p0(), String.valueOf(a4), 5));
    }

    public static boolean b(com.qq.e.comm.plugin.g0.e eVar) {
        return (eVar == null || eVar.q() == null || eVar.q().b() == null || com.qq.e.comm.plugin.d0.a.d().f().a("ssmi", eVar.q0(), 0) != 1) ? false : true;
    }

    public static boolean d() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("scsnt", 1) == 1;
    }

    public static boolean b(String str) {
        return com.qq.e.comm.plugin.t.c.a("sskphe", f46125b, str, 0) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0040 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(boolean r4, java.lang.String r5) {
        /*
            java.lang.String r0 = com.qq.e.comm.plugin.splash.j.f46125b
            java.lang.String r1 = "softc"
            java.lang.String r2 = ""
            java.lang.String r5 = com.qq.e.comm.plugin.t.c.a(r1, r0, r5, r2)
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            r2 = -1
            if (r0 != 0) goto L32
            java.lang.String r0 = ","
            java.lang.String[] r5 = r5.split(r0)     // Catch: java.lang.Exception -> L28
            r0 = r5[r1]     // Catch: java.lang.Exception -> L28
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L28
            r3 = 1
            r5 = r5[r3]     // Catch: java.lang.Exception -> L26
            int r2 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.Exception -> L26
            goto L33
        L26:
            r5 = move-exception
            goto L2a
        L28:
            r5 = move-exception
            r0 = -1
        L2a:
            java.lang.String r3 = r5.getMessage()
            com.qq.e.comm.plugin.util.d1.a(r3, r5)
            goto L33
        L32:
            r0 = -1
        L33:
            if (r2 <= 0) goto L41
            if (r0 < 0) goto L41
            int r5 = com.qq.e.comm.plugin.splash.j.f46124a
            if (r5 == 0) goto L3c
            r1 = 2
        L3c:
            int r4 = r4 + r1
            r4 = r4 & r0
            if (r4 != 0) goto L41
            return r2
        L41:
            com.qq.e.comm.plugin.d0.a r4 = com.qq.e.comm.plugin.d0.a.d()
            com.qq.e.comm.plugin.d0.d.h r4 = r4.f()
            r5 = 3000(0xbb8, float:4.204E-42)
            java.lang.String r0 = "spl_ltime"
            int r4 = r4.a(r0, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.splash.j.a(boolean, java.lang.String):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c() {
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("spl_lptime", 5);
        if (a4 > 10000) {
            a4 = o.a();
        }
        if (a4 <= -1) {
            return -1;
        }
        return a4 * 100;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(String str) {
        return com.qq.e.comm.plugin.d0.a.d().f().a("deepLink_confirm", str, 0) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(String str) {
        return com.qq.e.comm.plugin.t.c.a("spsc", f46125b, str, 0, (c.b<Integer>) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(com.qq.e.comm.plugin.g0.e eVar) {
        String q02 = eVar.q0();
        int a4 = com.qq.e.comm.plugin.t.c.a("spl_exptime_exp", q02, 5, eVar.p0());
        return a4 != 5 ? a4 * 1000 : com.qq.e.comm.plugin.d0.a.d().f().a("spl_exptime", q02, 5000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("pis", 7200);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double a(boolean z3, boolean z4) {
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a(z4 ? z3 ? "chrffsl" : "chrl" : z3 ? "chrffs" : "chr", 0);
        if (a4 > 0) {
            double d4 = a4;
            Double.isNaN(d4);
            return d4 / 100.0d;
        } else if (z3) {
            return 0.95d;
        } else {
            return z4 ? 0.93d : 0.75d;
        }
    }

    public static int a(c0 c0Var) {
        if (c0Var == null || c0Var.Y0()) {
            return 0;
        }
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("splashSkipPos", 3);
        if (a4 < 0 || a4 > 4) {
            return 3;
        }
        return a4;
    }

    public static boolean a(com.qq.e.comm.plugin.b.d dVar) {
        return dVar != null && dVar.x() == com.qq.e.comm.plugin.b.g.SPLASH.d();
    }
}
