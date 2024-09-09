package com.qq.e.comm.plugin.fs.e;

import com.qq.e.comm.plugin.g0.f0;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.rewardvideo.n;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.i0;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f43260a = "e";

    public static void a(com.qq.e.comm.plugin.g0.e eVar, boolean z3) {
        if (a(eVar).equals("Reward")) {
            return;
        }
        i0.a(z3, com.qq.e.comm.plugin.n0.c.a(eVar));
    }

    private static void b(com.qq.e.comm.plugin.g0.e eVar) {
        i0.a(com.qq.e.comm.plugin.n0.c.a(eVar), eVar.N() - eVar.T());
        if (eVar.O0() > 0) {
            i0.d(com.qq.e.comm.plugin.n0.c.a(eVar), eVar.O0() - eVar.N());
        }
        List<Long> w3 = eVar.w();
        if (w3 != null && w3.size() > 0) {
            for (Long l4 : w3) {
                i0.b(com.qq.e.comm.plugin.n0.c.a(eVar), l4.longValue() - eVar.N());
            }
        }
        List<Long> t3 = eVar.t();
        if (t3 != null && t3.size() > 0) {
            for (Long l5 : t3) {
                i0.a(com.qq.e.comm.plugin.n0.c.a(eVar), eVar.M0(), l5.longValue() - eVar.N());
            }
        }
        if (eVar.U() > 0) {
            i0.c(com.qq.e.comm.plugin.n0.c.a(eVar), eVar.U() - eVar.N());
        }
    }

    public static void c(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar != null && eVar.T() != 0) {
            if (a(eVar).equals("Reward")) {
                d(eVar);
                return;
            } else {
                b(eVar);
                return;
            }
        }
        d1.b(f43260a, "tracePerformance, error");
    }

    private static void d(com.qq.e.comm.plugin.g0.e eVar) {
        com.qq.e.comm.plugin.n0.c a4 = com.qq.e.comm.plugin.n0.c.a(eVar);
        n.a(a4, eVar.N() - eVar.T());
        if (eVar.O0() > 0) {
            n.d(a4, eVar.O0() - eVar.N());
        }
        List<Long> w3 = eVar.w();
        if (w3 != null && w3.size() > 0) {
            for (Long l4 : w3) {
                n.b(a4, l4.longValue() - eVar.N());
            }
        }
        if (eVar.U() > 0) {
            n.c(a4, eVar.U() - eVar.N());
        }
    }

    public static void e(com.qq.e.comm.plugin.g0.e eVar) {
        if (a(eVar).equals("Reward")) {
            n.c(com.qq.e.comm.plugin.n0.c.a(eVar));
        }
    }

    public static void a(f.t tVar, com.qq.e.comm.plugin.g0.e eVar, long j4, long j5, long j6) {
        String a4 = a(eVar);
        if (a4.equals("Reward") || a4.equals("Interstitial")) {
            n.a(tVar, com.qq.e.comm.plugin.n0.c.a(eVar), n.a(j4, j5, (int) j6, (String) null, (String) null));
        }
        if ("Reward".equals(a4) || tVar != f.t.END) {
            return;
        }
        i0.b(com.qq.e.comm.plugin.n0.c.a(eVar));
    }

    public static void a(com.qq.e.comm.plugin.g0.e eVar, int i4) {
        v.a(1403018, com.qq.e.comm.plugin.n0.c.a(eVar), Integer.valueOf(i4));
    }

    private static String a(com.qq.e.comm.plugin.g0.e eVar) {
        return eVar instanceof f0 ? "Reward" : eVar instanceof com.qq.e.comm.plugin.g0.v ? "Interstitial" : "";
    }
}
