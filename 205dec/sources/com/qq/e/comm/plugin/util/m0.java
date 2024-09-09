package com.qq.e.comm.plugin.util;

import android.text.TextUtils;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class m0 {

    /* renamed from: a  reason: collision with root package name */
    private static com.qq.e.comm.plugin.g0.e f46527a;

    /* renamed from: b  reason: collision with root package name */
    private static long f46528b;

    private static int a(com.qq.e.comm.plugin.g0.e eVar) {
        return eVar == null ? 0 : -1;
    }

    public static void a(com.qq.e.comm.plugin.i.h hVar) {
        if (hVar == null) {
            return;
        }
        f46527a = hVar.C;
        f46528b = hVar.f44128a;
    }

    public static void b(com.qq.e.comm.plugin.n0.c cVar, com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.n0.v.a(1403012, cVar, Integer.valueOf(a(eVar)));
    }

    public static void c(com.qq.e.comm.plugin.n0.c cVar, com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.n0.v.a(1403006, cVar, Integer.valueOf(a(eVar)));
    }

    public static void d(com.qq.e.comm.plugin.n0.c cVar, com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.g0.e eVar2;
        int a4 = a(eVar);
        com.qq.e.comm.plugin.n0.v.a(1403007, cVar, Integer.valueOf(a4));
        if (f46528b == 0 || (eVar2 = f46527a) == null || eVar == null || !TextUtils.equals(eVar2.K0(), eVar.K0())) {
            return;
        }
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(2040006);
        hVar.a(cVar);
        hVar.b(System.currentTimeMillis() - f46528b);
        hVar.b(a4);
        com.qq.e.comm.plugin.n0.v.a(hVar);
    }

    public static void e(com.qq.e.comm.plugin.n0.c cVar, com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.n0.v.a(1403010, cVar, Integer.valueOf(a(eVar)));
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, int i4, com.qq.e.comm.plugin.n0.d dVar, com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.n0.v.a(1403008, cVar, Integer.valueOf(a(eVar)), Integer.valueOf(i4), dVar);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, com.qq.e.comm.plugin.g0.e eVar, int i4) {
        com.qq.e.comm.plugin.n0.v.a(1403009, cVar, Integer.valueOf(a(eVar)), Integer.valueOf(i4), null);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.n0.v.a(1403013, cVar, Integer.valueOf(a(eVar)));
    }

    public static void a(int i4, long j4, com.qq.e.comm.plugin.n0.c cVar, String str, String str2) {
        com.qq.e.comm.plugin.n0.h b4 = new com.qq.e.comm.plugin.n0.h(i4).b(System.currentTimeMillis() - j4);
        b4.a(cVar);
        b4.a(new com.qq.e.comm.plugin.n0.d().a("url", str).a("msg", str2));
        com.qq.e.comm.plugin.n0.v.a(b4);
    }
}
