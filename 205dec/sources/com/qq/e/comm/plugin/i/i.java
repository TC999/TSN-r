package com.qq.e.comm.plugin.i;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static int f44170a;

    /* renamed from: b  reason: collision with root package name */
    private static int f44171b;

    /* renamed from: c  reason: collision with root package name */
    private static Set<String> f44172c;

    public static int a() {
        if (f44170a <= 0) {
            int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("crto", 8);
            f44170a = a4;
            if (a4 > 10000) {
                f44170a = com.qq.e.comm.plugin.t.a.b().a(String.valueOf(f44170a), 8);
            }
        }
        return f44170a;
    }

    public static int b() {
        if (f44171b <= 0) {
            f44171b = com.qq.e.comm.plugin.d0.a.d().f().a("rrto", 4);
        }
        return f44171b;
    }

    public static boolean c(com.qq.e.comm.plugin.g0.e eVar, int i4) {
        return eVar.X0() && b(eVar, i4);
    }

    private static boolean b(com.qq.e.comm.plugin.g0.e eVar, int i4) {
        if (com.qq.e.comm.plugin.apkmanager.w.d.d(i4)) {
            int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("icwai", eVar == null ? null : eVar.q0(), 0);
            return (eVar == null || a4 < 10000) ? a4 == 1 : com.qq.e.comm.plugin.t.a.b().a(eVar.p0(), String.valueOf(a4), 0) == 1;
        }
        return true;
    }

    public static boolean a(int i4) {
        if (f44172c == null) {
            f44172c = new HashSet(Arrays.asList(com.qq.e.comm.plugin.d0.a.d().f().b("cta_cidsw", "1008,2008").split(",")));
        }
        return f44172c.contains(String.valueOf(i4));
    }

    public static boolean a(com.qq.e.comm.plugin.g0.e eVar, boolean z3, int i4) {
        return z3 ? eVar.X0() && a(eVar) && b(eVar, i4) : eVar.X0() && b(eVar, i4);
    }

    public static boolean a(com.qq.e.comm.plugin.g0.e eVar) {
        return eVar.o().e() || com.qq.e.comm.plugin.t.c.a("cta_dcwai", eVar.q0(), 0) == 1;
    }

    public static boolean a(com.qq.e.comm.plugin.g0.e eVar, int i4) {
        return (com.qq.e.comm.plugin.t.c.a("lp_dcwai", eVar.q0(), 0) == 1) && b(eVar, i4);
    }
}
