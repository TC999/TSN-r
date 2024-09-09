package com.qq.e.comm.plugin.i;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i4, long j4, h hVar) {
        if (j4 <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - j4;
        com.qq.e.comm.plugin.n0.h hVar2 = new com.qq.e.comm.plugin.n0.h(i4);
        hVar2.a(hVar.f44153z);
        hVar2.b(currentTimeMillis);
        com.qq.e.comm.plugin.n0.v.a(hVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z3, int i4, h hVar) {
        if (z3) {
            com.qq.e.comm.plugin.n0.v.b(1101002, hVar.f44153z, Integer.valueOf(i4));
            return;
        }
        com.qq.e.comm.plugin.n0.v.a(1101001, hVar.f44153z);
        com.qq.e.comm.plugin.g0.e eVar = hVar.C;
        if (eVar != null && eVar.X0() && eVar.j1()) {
            com.qq.e.comm.plugin.n0.v.a(1101008, hVar.f44153z, Integer.valueOf(eVar.G()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Boolean bool, int i4, h hVar) {
        if (bool == null) {
            com.qq.e.comm.plugin.n0.v.a(4000001, hVar.f44153z);
        } else if (bool.booleanValue()) {
            com.qq.e.comm.plugin.n0.v.b(4000002, hVar.f44153z, Integer.valueOf(i4));
        } else {
            com.qq.e.comm.plugin.n0.v.a(4000003, hVar.f44153z);
        }
    }

    static void a(h hVar) {
        com.qq.e.comm.plugin.n0.e eVar = new com.qq.e.comm.plugin.n0.e(4000000);
        eVar.a(hVar.f44153z);
        eVar.c(hVar.D);
        eVar.d(hVar.f44146s.intValue());
        new com.qq.e.comm.plugin.n0.d().a("ir", Integer.valueOf(hVar.H));
        com.qq.e.comm.plugin.n0.v.a(eVar);
    }
}
