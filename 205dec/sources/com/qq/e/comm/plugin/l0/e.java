package com.qq.e.comm.plugin.l0;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.t2;
import com.qq.e.comm.plugin.util.v0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f44606a;

    private static Integer a(b bVar, com.qq.e.comm.plugin.b.d dVar) {
        return a(bVar, dVar, false, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(b bVar, com.qq.e.comm.plugin.b.d dVar, boolean z3, int i4) {
        if (b(bVar, dVar)) {
            return;
        }
        com.qq.e.comm.plugin.n0.d a4 = a(dVar);
        a4.a("seq", Integer.valueOf(com.qq.e.comm.plugin.m0.a.l().d()));
        com.qq.e.comm.plugin.n0.c a5 = a(bVar);
        a(1400003, null, a(bVar, dVar, z3, i4), a5, dVar.c(), a4);
        if (dVar.K()) {
            a(1408002, null, null, a5, dVar.c(), a4);
        }
        if (f44606a || GlobalSetting.isAgreePrivacyStrategy()) {
            return;
        }
        f44606a = true;
        v.a(9130008, a5);
    }

    public static void c(com.qq.e.comm.plugin.n0.c cVar, int i4) {
        a(cVar, i4, (com.qq.e.comm.plugin.g0.e) null);
    }

    public static void d(com.qq.e.comm.plugin.n0.c cVar, int i4) {
        a(1400010, Integer.valueOf(i4), (Integer) null, cVar, 1);
    }

    private static com.qq.e.comm.plugin.n0.d a(com.qq.e.comm.plugin.b.d dVar) {
        com.qq.e.comm.plugin.n0.d dVar2 = new com.qq.e.comm.plugin.n0.d();
        if (dVar != null && dVar.K()) {
            dVar2.a("tk", dVar.D());
        }
        return dVar2;
    }

    private static Integer a(b bVar, com.qq.e.comm.plugin.b.d dVar, boolean z3, int i4) {
        int A;
        int i5 = 1;
        if (bVar.f44582b != com.qq.e.comm.plugin.b.g.SPLASH || dVar == null) {
            i5 = -1;
        } else if (dVar.r() == null || dVar.r().intValue() != 1) {
            i5 = 2;
        }
        if (z3) {
            i5 += 10;
        }
        if (dVar != null && (A = dVar.A()) > 0) {
            i5 += A * 100;
        }
        if (i4 > 0) {
            i5 += i4 * 1000;
        }
        return Integer.valueOf(i5);
    }

    private static boolean b(b bVar, com.qq.e.comm.plugin.b.d dVar) {
        if (bVar == null || dVar == null) {
            return true;
        }
        return bVar.f44582b == com.qq.e.comm.plugin.b.g.SPLASH && dVar.z() == 1;
    }

    public static void b(com.qq.e.comm.plugin.n0.c cVar, int i4) {
        a(1400005, (Integer) null, (Integer) null, cVar, i4);
    }

    static void a(b bVar, com.qq.e.comm.plugin.b.d dVar, int i4) {
        if (b(bVar, dVar)) {
            return;
        }
        com.qq.e.comm.plugin.n0.c a4 = a(bVar);
        a(1400001, Integer.valueOf(i4), a(bVar, dVar), a4, dVar.c(), a(dVar));
    }

    static void a(b bVar, com.qq.e.comm.plugin.b.d dVar, boolean z3) {
        if (b(bVar, dVar)) {
            return;
        }
        com.qq.e.comm.plugin.n0.c a4 = a(bVar);
        a(1400002, null, a(bVar, dVar), a4, dVar.c(), z3 ? new com.qq.e.comm.plugin.n0.d().a("data", 1) : null);
        if (dVar.K()) {
            a(1408001, (Integer) null, (Integer) null, a4, dVar.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(b bVar, com.qq.e.comm.plugin.b.d dVar, int i4, boolean z3, int i5) {
        if (b(bVar, dVar)) {
            return;
        }
        com.qq.e.comm.plugin.n0.c a4 = a(bVar);
        Integer a5 = a(bVar, dVar, z3, i5);
        com.qq.e.comm.plugin.n0.d a6 = a(dVar).a(ResourceManager.KEY_MD5CHECK, Boolean.valueOf(v0.e())).a("nt", Integer.valueOf(com.qq.e.comm.plugin.d0.a.d().c().n().a()));
        a(1400004, Integer.valueOf(i4), a5, a4, dVar.c(), a6);
        if (dVar.K()) {
            a(1408003, Integer.valueOf(i4), a5, a4, dVar.c(), a6);
        }
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, int i4, boolean z3) {
        a(cVar, i4, 0, (com.qq.e.comm.plugin.n0.d) null, z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(b bVar, com.qq.e.comm.plugin.b.d dVar, String str) {
        if (b(bVar, dVar)) {
            return;
        }
        com.qq.e.comm.plugin.n0.c a4 = a(bVar);
        Integer a5 = a(bVar, dVar);
        com.qq.e.comm.plugin.n0.d dVar2 = null;
        if (!TextUtils.isEmpty(str)) {
            dVar2 = a(dVar);
            dVar2.a("msg", t2.a(str));
        }
        a(a4, 5001, a5.intValue(), dVar2, dVar.K());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(b bVar, com.qq.e.comm.plugin.b.d dVar, Throwable th) {
        if (b(bVar, dVar)) {
            return;
        }
        com.qq.e.comm.plugin.n0.c a4 = a(bVar);
        Integer a5 = a(bVar, dVar);
        com.qq.e.comm.plugin.n0.d dVar2 = null;
        if (th != null) {
            dVar2 = a(dVar);
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
            dVar2.a("msg", t2.a(sb.toString()));
        }
        a(a4, 3000, a5.intValue(), dVar2, dVar.K());
    }

    private static void a(com.qq.e.comm.plugin.n0.c cVar, int i4, int i5, com.qq.e.comm.plugin.n0.d dVar, boolean z3) {
        v.a(1400006, cVar, Integer.valueOf(i5), Integer.valueOf(i4), dVar);
        if (z3) {
            v.a(1408003, cVar, Integer.valueOf(i5), Integer.valueOf(i4), dVar);
        }
    }

    private static com.qq.e.comm.plugin.n0.c a(b bVar) {
        com.qq.e.comm.plugin.n0.c cVar = new com.qq.e.comm.plugin.n0.c();
        cVar.a(bVar.f44582b);
        cVar.c(bVar.f44581a);
        return cVar;
    }

    private static void a(int i4, Integer num, Integer num2, com.qq.e.comm.plugin.n0.c cVar, int i5, com.qq.e.comm.plugin.n0.d dVar) {
        com.qq.e.comm.plugin.n0.e eVar = new com.qq.e.comm.plugin.n0.e(i4);
        eVar.b(i5);
        eVar.a(cVar);
        if (num2 != null) {
            eVar.c(num2.intValue());
        }
        if (num != null) {
            eVar.d(num.intValue());
        }
        if (dVar != null) {
            eVar.a(dVar);
        }
        v.a(eVar);
    }

    private static void a(int i4, Integer num, Integer num2, com.qq.e.comm.plugin.n0.c cVar, int i5) {
        a(i4, num, num2, cVar, i5, null);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, int i4) {
        a(1400007, (Integer) null, (Integer) null, cVar, i4);
    }

    public static void a(int i4, com.qq.e.comm.plugin.n0.c cVar, int i5) {
        a(1400008, Integer.valueOf(i4), (Integer) null, cVar, i5);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, int i4, com.qq.e.comm.plugin.g0.e eVar) {
        a(1400009, null, null, cVar, i4, (eVar == null || eVar.C0() == 0 || eVar.T() == 0) ? null : new com.qq.e.comm.plugin.n0.d().a("du", Long.valueOf(eVar.T() - eVar.C0())));
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, int i4, int i5, int i6, boolean z3, long j4, boolean z4) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("is2s", Integer.valueOf(z3 ? 1 : 0));
        dVar.a("du", Long.valueOf(j4));
        dVar.a("ifs", Integer.valueOf(z4 ? 1 : 0));
        a(1400009, Integer.valueOf(i6), Integer.valueOf(i5), cVar, i4, dVar);
    }
}
