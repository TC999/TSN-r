package com.qq.e.comm.plugin.util;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class w {
    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4, boolean z3, int i4) {
        a(2300001, cVar, j4, z3, i4);
    }

    public static void b(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        a(2300002, cVar, j4);
    }

    public static void c(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        a(2300003, cVar, j4);
    }

    public static void d(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        a(2300006, cVar, j4);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        a(2300004, cVar, j4);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4, long j5) {
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(2300005);
        hVar.a(cVar);
        hVar.b((int) j4);
        hVar.b(j5);
        com.qq.e.comm.plugin.n0.v.a(hVar);
    }

    private static void a(int i4, com.qq.e.comm.plugin.n0.c cVar, long j4) {
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(i4);
        hVar.a(cVar);
        hVar.b(j4);
        com.qq.e.comm.plugin.n0.v.a(hVar);
    }

    private static void a(int i4, com.qq.e.comm.plugin.n0.c cVar, long j4, boolean z3, int i5) {
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(i4);
        hVar.a(cVar);
        hVar.b(j4);
        hVar.b((i5 * 10) + (z3 ? 1 : 0));
        com.qq.e.comm.plugin.n0.v.a(hVar);
    }
}
