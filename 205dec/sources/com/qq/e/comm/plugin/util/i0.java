package com.qq.e.comm.plugin.util;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i0 {
    public static void a(boolean z3, com.qq.e.comm.plugin.n0.c cVar) {
        com.qq.e.comm.plugin.n0.v.a(z3 ? 1030023 : 1030022, cVar);
    }

    public static void b(com.qq.e.comm.plugin.n0.c cVar) {
        com.qq.e.comm.plugin.n0.v.a(1030013, cVar);
    }

    public static void c(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.c(cVar, j4);
    }

    public static void d(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.d(cVar, j4);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar) {
        com.qq.e.comm.plugin.n0.v.a(1401000, cVar);
    }

    public static void b(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.b(cVar, j4);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, boolean z3, boolean z4) {
        com.qq.e.comm.plugin.n0.v.a(1401002, cVar, Integer.valueOf(!z3 ? 1 : 2), Integer.valueOf(z4 ? 2 : 1), null);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, int i4) {
        com.qq.e.comm.plugin.n0.v.a(1401001, cVar, null, Integer.valueOf(i4), null);
    }

    public static void a(com.qq.e.comm.plugin.b.g gVar, boolean z3, com.qq.e.comm.plugin.n0.c cVar, int i4, Exception exc) {
        int i5;
        if (gVar == com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL_FULLSCREEN) {
            i5 = z3 ? 1030009 : 1030007;
        } else if (gVar != com.qq.e.comm.plugin.b.g.UNIFIED_INTERSTITIAL) {
            return;
        } else {
            i5 = z3 ? 1031007 : 1031008;
        }
        com.qq.e.comm.plugin.n0.v.b(i5, cVar, Integer.valueOf(i4), z3 ? null : a(exc, (String) null));
    }

    private static com.qq.e.comm.plugin.n0.d a(Exception exc, String str) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        if (exc != null) {
            dVar.a("ot", exc.getMessage());
        }
        if (str != null) {
            dVar.a("rs", str);
        }
        return dVar;
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.a(cVar, j4);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4, long j5) {
        w.a(cVar, j4, j5);
    }
}
