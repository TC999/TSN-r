package com.qq.e.comm.plugin.t;

import com.qq.e.comm.plugin.b.g;
import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.t.c;
import com.qq.e.comm.plugin.util.g2;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {
    public static void a(e eVar) {
        g2.a().b(eVar);
        c.C0896c a4 = c.d().a(eVar, "APP", "largee", 0, (c.b<Integer>) null).a(eVar, "APP", "puit", 1, (c.b<Integer>) null).a(eVar, "APP", "alaai", 1, (c.b<Integer>) null).a(eVar, "APP", "oafd", 0, (c.b<Integer>) null).a(eVar, "APP", "oabd", 0, (c.b<Integer>) null).a(eVar, "APP", "oabfd", 0, (c.b<Integer>) null).a(eVar, "APP", "prhs", 0, (c.b<Integer>) null).a(eVar, "APP", "uttc", 0, (c.b<Integer>) null).a(eVar, "APP", "htph", 0, (c.b<Integer>) null).a(eVar, "APP", "aralcen", com.qq.e.comm.plugin.k.b.f44517b.intValue(), (c.b<Integer>) null).a(eVar, eVar.o().b(), "itratcl", 0, (c.b<Integer>) null).a(eVar, eVar.o().b(), "phcirae", 0, (c.b<Integer>) null).a(eVar, "APP", "gssst", 0, (c.b<Integer>) null);
        g o4 = eVar.o();
        if (o4 == g.SPLASH || o4 == g.REWARDVIDEOAD || o4 == g.UNIFIED_INTERSTITIAL_FULLSCREEN || o4 == g.UNIFIED_INTERSTITIAL) {
            a4.a(eVar, "APP", "ftp", 0, (c.b<Integer>) null);
        }
        a(a4, eVar).a();
        com.qq.e.comm.plugin.f.b.d().b();
    }

    private static c.C0896c a(c.C0896c c0896c, e eVar) {
        return a(a(a(a(c0896c, eVar, eVar.o().b(), "eapasc", "", true), eVar, eVar.o().b(), "eapatc", "", true), eVar, eVar.o().b(), "eapcfg", "", false), eVar, eVar.o().b(), "eapcfg2", "", false);
    }

    private static c.C0896c a(c.C0896c c0896c, e eVar, String str, String str2, String str3, boolean z3) {
        c.C0896c a4 = c0896c.a(eVar, str, str2, str3, (c.b<String>) null);
        if (z3) {
            return a4.a(eVar, str, str2 + "_eaexp", str3, (c.b<String>) null);
        }
        return a4;
    }
}
