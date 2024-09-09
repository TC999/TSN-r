package com.qq.e.comm.plugin.splash;

import android.text.TextUtils;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.w;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z3, com.qq.e.comm.plugin.n0.c cVar, int i4, boolean z4) {
        int i5 = j.f46124a;
        int i6 = z3 ? 1013010 : 1013009;
        int min = Math.min(i4 / 500, 20);
        v.a(i6, cVar, Integer.valueOf(min), Integer.valueOf(Math.min(i5 / 500, 20)), null);
        v.a(1013021, cVar, Integer.valueOf(z4 ? 1 : 2), Integer.valueOf(min), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.n0.c cVar, int i4) {
        v.a(1010406, cVar, Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(h hVar) {
        if (hVar != null && hVar.f46113y > 0) {
            w.b(hVar.c(), System.currentTimeMillis() - hVar.f46113y);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(h hVar) {
        if (hVar == null) {
            return;
        }
        com.qq.e.comm.plugin.n0.c a4 = com.qq.e.comm.plugin.n0.c.a(hVar.b());
        Boolean bool = hVar.f46111w.get();
        if (bool != null) {
            a4.a(bool.booleanValue());
        }
        v.a(1010027, a4);
        if (hVar.f46113y > 0) {
            w.a(hVar.c(), hVar.b() == null ? 0 : hVar.b().M0(), System.currentTimeMillis() - hVar.f46113y);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(h hVar) {
        if (hVar == null) {
            return;
        }
        v.a(1401000, hVar.c(), Integer.valueOf(hVar.f46105q ? 11 : 10), Integer.valueOf(hVar.f46106r ? 1 : 2), null);
    }

    public static void f(h hVar) {
        if (hVar == null) {
            return;
        }
        v.a(1010402, hVar.c());
    }

    public static void g(h hVar) {
        v.a(1013003, hVar.c(), 2);
        if (hVar.b() == null || TextUtils.isEmpty(hVar.b().Q0())) {
            return;
        }
        v.a(1013003, hVar.c(), 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(h hVar, boolean z3, int i4) {
        if (hVar == null) {
            return;
        }
        v.a(1013008, hVar.c(), Integer.valueOf(i4), Integer.valueOf(z3 ? 2 : 1), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1013002, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.n0.c cVar) {
        a(2011004, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(h hVar) {
        if (hVar != null && hVar.f46113y > 0) {
            w.c(hVar.c(), System.currentTimeMillis() - hVar.f46113y);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, int i4, boolean z3) {
        if (hVar == null) {
            return;
        }
        int min = Math.min(hVar.f46104p / 500, 20);
        com.qq.e.comm.plugin.n0.c c4 = hVar.c();
        v.a(1010062, c4, Integer.valueOf(i4), Integer.valueOf(min), null);
        v.a(1013022, c4, Integer.valueOf(z3 ? 1 : 2), Integer.valueOf(min), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1013006, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, boolean z3, long j4, boolean z4) {
        if (hVar == null) {
            return;
        }
        com.qq.e.comm.plugin.l0.e.a(hVar.c(), 1, hVar.f46105q ? 11 : 10, hVar.f46106r ? 1 : 2, z3, j4, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, Integer num) {
        if (hVar == null) {
            return;
        }
        int i4 = hVar.f46105q ? 11 : 10;
        com.qq.e.comm.plugin.n0.c a4 = com.qq.e.comm.plugin.n0.c.a(hVar.b());
        Boolean bool = hVar.f46111w.get();
        if (bool != null) {
            a4.a(bool.booleanValue());
        }
        if (num == null) {
            v.a(1401002, a4, Integer.valueOf(i4));
        } else {
            v.a(1401001, a4, Integer.valueOf(i4), num, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, boolean z3) {
        if (hVar == null) {
            return;
        }
        v.a(z3 ? 1012050 : 1012051, hVar.c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar) {
        if (hVar == null) {
            return;
        }
        v.a(1012053, hVar.c(), Integer.valueOf(j.a(hVar.f46091c)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z3, com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1012052, cVar, Integer.valueOf(z3 ? 1 : 0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1013007, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, boolean z3, int i4) {
        if (hVar == null) {
            return;
        }
        a(z3 ? 2011002 : 2011001, hVar.c());
        v.a(1013005, hVar.c(), Integer.valueOf(i4), Integer.valueOf(z3 ? 2 : 1), null);
    }

    private static void a(int i4, com.qq.e.comm.plugin.n0.c cVar) {
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(i4);
        hVar.b(j.c());
        hVar.b(0);
        hVar.a(cVar);
        v.a(hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar, long j4) {
        if (hVar == null) {
            return;
        }
        w.d(hVar.c(), System.currentTimeMillis() - j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.n0.c cVar, int i4) {
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(2010020);
        hVar.a(cVar);
        hVar.b(i4);
        v.a(hVar);
    }

    public static void a(h hVar, com.qq.e.comm.plugin.splash.r.a aVar) {
        if (aVar == null || hVar == null) {
            return;
        }
        v.a(1013004, hVar.c(), Integer.valueOf(aVar.f46176b == 8 ? 4 : 2), Integer.valueOf(aVar.f46175a.f44110g), null);
    }
}
