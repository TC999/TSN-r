package com.qq.e.comm.plugin.dl;

import com.qq.e.comm.plugin.util.p0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ s f42390c;

        a(s sVar) {
            this.f42390c = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.comm.plugin.util.j0 j0Var = new com.qq.e.comm.plugin.util.j0();
            j0Var.a("endCardClsVis", 0);
            this.f42390c.a(j0Var.a());
        }
    }

    public static void a(com.qq.e.comm.plugin.util.j0 j0Var) {
        j0Var.a("frontCardVis", 0);
        j0Var.a("endCardVis", 2);
        j0Var.a("endCardClsVis", 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0036 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b(com.qq.e.comm.plugin.g0.e r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            com.qq.e.comm.plugin.b.g r1 = r5.o()
            if (r1 == 0) goto L25
            boolean r2 = r1.h()
            if (r2 == 0) goto L13
            java.lang.String r1 = "dlendclstih"
            goto L27
        L13:
            boolean r2 = r1.g()
            if (r2 == 0) goto L1c
            java.lang.String r1 = "dlendclstif"
            goto L27
        L1c:
            boolean r1 = r1.j()
            if (r1 == 0) goto L25
            java.lang.String r1 = "dlendclstrv"
            goto L27
        L25:
            java.lang.String r1 = ""
        L27:
            java.lang.String r2 = r5.q0()
            com.qq.e.comm.plugin.g0.b0 r3 = r5.p0()
            r4 = -1
            int r1 = com.qq.e.comm.plugin.t.c.a(r1, r2, r4, r3)
            if (r1 < 0) goto L37
            return r1
        L37:
            com.qq.e.comm.plugin.g0.y r1 = r5.i0()
            if (r1 == 0) goto L48
            com.qq.e.comm.plugin.g0.y r5 = r5.i0()
            int r5 = r5.d()
            if (r5 < 0) goto L48
            return r5
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.dl.d.b(com.qq.e.comm.plugin.g0.e):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.g0.y i02;
        if (eVar == null || (i02 = eVar.i0()) == null) {
            return -1;
        }
        return i02.e();
    }

    public static boolean d(com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.g0.y i02;
        com.qq.e.comm.plugin.b.g o4;
        String str;
        if (eVar == null || (i02 = eVar.i0()) == null || !i02.t() || (o4 = eVar.o()) == null) {
            return false;
        }
        if (o4.h()) {
            str = "dlendenih";
        } else if (o4.j()) {
            str = "dlendenrv";
        } else if (o4.g()) {
            str = "dlendenif";
        } else if (o4.f()) {
            str = "dlendenfe";
        } else if (o4.i()) {
            str = "dlendenfu";
        } else if (!o4.k()) {
            return false;
        } else {
            str = "dlendens";
        }
        return com.qq.e.comm.plugin.t.c.a(str, eVar.q0(), 1, eVar.p0()) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(s sVar, com.qq.e.comm.plugin.g0.e eVar) {
        if (d(eVar)) {
            com.qq.e.comm.plugin.util.j0 j0Var = new com.qq.e.comm.plugin.util.j0();
            int b4 = b(eVar);
            j0Var.a("frontCardVis", 2);
            j0Var.a("endCardVis", 0);
            if (b4 <= 0) {
                j0Var.a("endCardClsVis", 0);
            }
            sVar.a(j0Var.a());
            sVar.b("showEndCard");
            if (b4 > 0) {
                p0.a(new a(sVar), b4 * 1000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(s sVar) {
        com.qq.e.comm.plugin.util.j0 j0Var = new com.qq.e.comm.plugin.util.j0();
        a(j0Var);
        sVar.a(j0Var.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.g0.y i02;
        return d(eVar) && (i02 = eVar.i0()) != null && i02.f() == 1;
    }
}
