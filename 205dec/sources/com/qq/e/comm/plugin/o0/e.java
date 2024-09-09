package com.qq.e.comm.plugin.o0;

import android.text.TextUtils;
import com.qq.e.comm.plugin.n0.h;
import com.qq.e.comm.plugin.n0.v;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {
    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4, boolean z3, com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.n0.d a4 = new com.qq.e.comm.plugin.n0.d().a("duration", Long.valueOf(j4));
        a(cVar, a4, z3 ? 1 : 0, Integer.valueOf(a(eVar, a4)));
    }

    public static void b(com.qq.e.comm.plugin.n0.c cVar, long j4, long j5, boolean z3) {
        a(cVar, new com.qq.e.comm.plugin.n0.d().a("duration", Long.valueOf(j4)).a("position", Long.valueOf(j5)), z3 ? 5 : 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.n0.c cVar, long j4, int i4) {
        h b4 = new h(2020005).b(i4).b(j4);
        b4.a(cVar);
        v.a(b4);
    }

    private static int a(com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.n0.d dVar) {
        if (eVar == null) {
            return 0;
        }
        int b4 = b.a().b();
        int i4 = 1;
        int i5 = eVar.b1() ? 1 : 2;
        String L0 = eVar.L0();
        if (TextUtils.isEmpty(L0) || (!L0.contains("f140112.mp4") && !L0.contains("f140110.mp4"))) {
            i4 = 2;
        }
        if (i5 != i4) {
            dVar.a("url", L0);
        }
        return (b4 * 100) + (i5 * 10) + i4;
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4, long j5, boolean z3) {
        a(cVar, new com.qq.e.comm.plugin.n0.d().a("duration", Long.valueOf(j4)).a("position", Long.valueOf(j5)), z3 ? 3 : 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        a(cVar, new com.qq.e.comm.plugin.n0.d().a("duration", Long.valueOf(j4)), 6);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4, int i4, boolean z3) {
        a(cVar, new com.qq.e.comm.plugin.n0.d().a("duration", Long.valueOf(j4)).a("play_times", Integer.valueOf(i4)), z3 ? 8 : 7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4, int i4) {
        h hVar = new h(2020004);
        hVar.a(cVar);
        hVar.b(j4).b(i4);
        v.a(hVar);
    }

    private static void a(com.qq.e.comm.plugin.n0.c cVar, com.qq.e.comm.plugin.n0.d dVar, int i4) {
        v.a(1130300, cVar, Integer.valueOf(i4), dVar);
    }

    private static void a(com.qq.e.comm.plugin.n0.c cVar, com.qq.e.comm.plugin.n0.d dVar, int i4, Integer num) {
        v.a(1130300, cVar, Integer.valueOf(i4), num, dVar);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, int i4, String str, com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("msg", str);
        v.a(1130301, cVar, Integer.valueOf(a(eVar, dVar)), Integer.valueOf(i4), dVar);
    }

    public static void a(com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.n0.e eVar2 = new com.qq.e.comm.plugin.n0.e(1130302);
        eVar2.a(com.qq.e.comm.plugin.n0.c.a(eVar));
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("vu", eVar.L0());
        eVar2.a(dVar);
        v.a(eVar2);
    }
}
