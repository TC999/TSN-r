package com.qq.e.comm.plugin.fs.e;

import com.qq.e.comm.plugin.g0.y;
import com.qq.e.comm.plugin.rewardvideo.l;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f43256a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile int f43257b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile int f43258c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile int f43259d;

    public static int a() {
        return (f43257b - f43259d) * 1000;
    }

    public static int b() {
        return (f43258c - f43259d) * 1000;
    }

    public static int c(com.qq.e.comm.plugin.g0.e eVar) {
        return com.qq.e.comm.plugin.t.c.a("fsricst", eVar.q0(), 0, eVar.p0());
    }

    public static int d(com.qq.e.comm.plugin.g0.e eVar) {
        int p3;
        y i02 = eVar.i0();
        if (i02 != null && (p3 = i02.p()) != 1 && !l.a(p3)) {
            return a(eVar, p3);
        }
        return com.qq.e.comm.plugin.t.c.a("fsirt", eVar.q0(), 15, eVar.p0());
    }

    public static int e(com.qq.e.comm.plugin.g0.e eVar) {
        return com.qq.e.comm.plugin.t.c.a("rewardPageCloseTime", eVar.q0(), 0, eVar.p0());
    }

    public static int f(com.qq.e.comm.plugin.g0.e eVar) {
        return com.qq.e.comm.plugin.t.c.a("rewardPageEffectiveTime", eVar.q0(), 15, eVar.p0());
    }

    public static int g(com.qq.e.comm.plugin.g0.e eVar) {
        return Math.min(eVar.M0() - 1, com.qq.e.comm.plugin.t.c.a("rewardVideoCloseShowTime", eVar.q0(), 0, eVar.p0()));
    }

    public static void h(com.qq.e.comm.plugin.g0.e eVar) {
        int a4;
        int a5;
        if (eVar.l0().equals(f43256a)) {
            return;
        }
        f43256a = eVar.l0();
        if (eVar.o().j()) {
            if (eVar.i0() != null && eVar.i0().y()) {
                a4 = f(eVar);
                a5 = e(eVar);
            } else if (eVar.l1()) {
                a4 = b(eVar, false);
                a5 = g(eVar);
            } else {
                a4 = d(eVar);
                a5 = c(eVar);
            }
        } else {
            a4 = eVar.h1() ? a(eVar, false) : -1;
            if (eVar.l1()) {
                a5 = b(eVar) / 1000;
            } else {
                a5 = a(eVar);
            }
        }
        f43258c = a4;
        f43257b = a5;
        f43259d = 0;
    }

    public static void a(int i4) {
        f43259d = i4;
    }

    public static int b(com.qq.e.comm.plugin.g0.e eVar, boolean z3) {
        int p3;
        y i02 = eVar.i0();
        if (i02 != null && (p3 = i02.p()) != 1 && !l.a(p3)) {
            return a(eVar, p3);
        }
        return a(eVar, z3, "restpl", 0, "rewardVideoEffectiveTime", 30);
    }

    private static int a(com.qq.e.comm.plugin.g0.e eVar, int i4) {
        int M0 = eVar.l1() ? eVar.M0() - 1 : Integer.MAX_VALUE;
        return Math.min(M0, com.qq.e.comm.plugin.t.c.a("skcrd_" + i4, eVar.q0(), 5, eVar.p0()));
    }

    public static int a(com.qq.e.comm.plugin.g0.e eVar, boolean z3) {
        return a(eVar, z3, "instpl", 0, "itsvet", 30);
    }

    public static int b(com.qq.e.comm.plugin.g0.e eVar) {
        return Math.min((eVar.M0() - 1) * 1000, com.qq.e.comm.plugin.t.c.a("ifsvmpt", eVar.q0(), 5000, eVar.p0()));
    }

    private static int a(com.qq.e.comm.plugin.g0.e eVar, boolean z3, String str, int i4, String str2, int i5) {
        int a4;
        int M0 = eVar.M0() - 1;
        if (!z3 && (a4 = com.qq.e.comm.plugin.t.c.a(str, eVar.q0(), i4, eVar.p0())) > 0) {
            M0 = Math.min(M0, a4);
        }
        return Math.min(M0, com.qq.e.comm.plugin.t.c.a(str2, eVar.q0(), i5, eVar.p0()));
    }

    public static int a(com.qq.e.comm.plugin.g0.e eVar) {
        return com.qq.e.comm.plugin.t.c.a("ifscst", eVar.q0(), 0, eVar.p0());
    }
}
