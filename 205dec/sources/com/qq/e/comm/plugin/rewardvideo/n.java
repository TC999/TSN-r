package com.qq.e.comm.plugin.rewardvideo;

import android.text.TextUtils;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.util.w;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class n {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f45983a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f45984b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f45985c;

        static {
            int[] iArr = new int[com.qq.e.comm.plugin.b.g.values().length];
            f45985c = iArr;
            try {
                iArr[com.qq.e.comm.plugin.b.g.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45985c[com.qq.e.comm.plugin.b.g.REWARDVIDEOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[f.values().length];
            f45984b = iArr2;
            try {
                iArr2[f.MEDIA.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45984b[f.PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[f.t.values().length];
            f45983a = iArr3;
            try {
                iArr3[f.t.END.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f45983a[f.t.PLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f45983a[f.t.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f45983a[f.t.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static void a(f.t tVar, com.qq.e.comm.plugin.n0.c cVar, com.qq.e.comm.plugin.n0.d dVar) {
        int i4;
        int i5 = a.f45983a[tVar.ordinal()];
        if (i5 == 1) {
            if (dVar != null) {
                dVar.a("ps", "1");
            }
            i4 = 1020013;
        } else if (i5 == 2) {
            if (dVar != null) {
                dVar.a("ps", "4");
            }
            i4 = 1020011;
        } else if (i5 != 3) {
            return;
        } else {
            if (dVar != null) {
                dVar.a("ps", "2");
                dVar.a("sr", "1");
            }
            i4 = 1020010;
        }
        v.a(i4, cVar, null, null, dVar, a(cVar));
    }

    public static void b(f fVar, com.qq.e.comm.plugin.g0.e eVar, long j4, long j5, int i4, f.t tVar, boolean z3, boolean z4) {
        int i5;
        com.qq.e.comm.plugin.n0.d a4;
        com.qq.e.comm.plugin.n0.c a5 = com.qq.e.comm.plugin.n0.c.a(eVar);
        int i6 = a.f45984b[fVar.ordinal()];
        if (i6 == 1) {
            i5 = 1020033;
            a4 = a(j4, j5, i4, a(tVar), (String) null);
            a4.a("sr", tVar == f.t.PAUSE ? "1" : "-999");
        } else if (i6 != 2) {
            return;
        } else {
            i5 = 1022032;
            a4 = a(eVar, i4, j5, z3, z4, (String) null);
        }
        v.a(i5, a5, null, null, a4, a(a5));
    }

    public static void c(com.qq.e.comm.plugin.n0.c cVar) {
        v.b(1020073, cVar, 1);
    }

    public static void d(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.d(cVar, j4);
    }

    public static void c(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.c(cVar, j4);
    }

    public static void b(com.qq.e.comm.plugin.g0.e eVar, int i4, long j4, boolean z3, boolean z4) {
        com.qq.e.comm.plugin.n0.c a4 = com.qq.e.comm.plugin.n0.c.a(eVar);
        v.a(1022030, a4, null, null, a(eVar, i4, j4, z3, z4, (String) null), a(a4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.qq.e.comm.plugin.n0.c cVar) {
        v.a(1401000, cVar);
    }

    public static void b(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.b(cVar, j4);
    }

    public static void a(f fVar, com.qq.e.comm.plugin.g0.e eVar, long j4, long j5, int i4, f.t tVar, boolean z3, boolean z4) {
        int i5;
        com.qq.e.comm.plugin.n0.d a4;
        com.qq.e.comm.plugin.n0.c a5 = com.qq.e.comm.plugin.n0.c.a(eVar);
        int i6 = a.f45984b[fVar.ordinal()];
        if (i6 == 1) {
            i5 = 1020012;
            a4 = a(j4, j5, i4, a(tVar), (String) null);
            a4.a("sr", tVar == f.t.PAUSE ? "1" : "-999");
        } else if (i6 != 2) {
            return;
        } else {
            i5 = 1022007;
            a4 = a(eVar, i4, j5, z3, z4, (String) null);
        }
        v.a(i5, a5, null, null, a4, a(a5));
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4, long j5, int i4, f.t tVar, long j6, long j7) {
        long currentTimeMillis = System.currentTimeMillis();
        com.qq.e.comm.plugin.n0.d a4 = a(j4, j5, i4, a(tVar), (String) null);
        a4.a("dpu", a(j6, currentTimeMillis));
        a4.a("rcdu", a(j7, currentTimeMillis));
        v.a(1020034, cVar, null, null, a4, a(cVar));
    }

    private static String a(long j4, long j5) {
        return j4 <= 0 ? "-999" : String.valueOf(j5 - j4);
    }

    public static void a(com.qq.e.comm.plugin.g0.e eVar, int i4, int i5, long j4, boolean z3, boolean z4) {
        int i6;
        com.qq.e.comm.plugin.n0.c a4 = com.qq.e.comm.plugin.n0.c.a(eVar);
        com.qq.e.comm.plugin.n0.d a5 = a(eVar, i4, j4, z3, z4, (String) null);
        if (i5 == 1) {
            i6 = 1022033;
            a5.a("sr", "1");
        } else if (i5 == 2) {
            i6 = 1022034;
        } else if (i5 != 3) {
            return;
        } else {
            i6 = 1022016;
        }
        v.a(i6, a4, null, null, a5, a(a4));
    }

    public static void a(com.qq.e.comm.plugin.g0.e eVar, int i4, long j4, long j5, long j6, boolean z3, boolean z4) {
        com.qq.e.comm.plugin.n0.c a4 = com.qq.e.comm.plugin.n0.c.a(eVar);
        com.qq.e.comm.plugin.n0.d a5 = a(eVar, i4, j5, z3, z4, (String) null);
        long currentTimeMillis = System.currentTimeMillis();
        a5.a("dpu", a(j6, currentTimeMillis));
        a5.a("rcdu", a(j4, currentTimeMillis));
        v.a(1022016, a4, null, null, a5, a(a4));
    }

    public static void a(f fVar, com.qq.e.comm.plugin.n0.c cVar) {
        int i4 = a.f45984b[fVar.ordinal()];
        v.a(i4 != 1 ? i4 != 2 ? 0 : 1022004 : 1020008, cVar);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4, long j5, int i4) {
        v.a(1020006, cVar, null, null, a(j4, j5, i4, "4", (String) null), a(cVar));
    }

    public static void a(int i4, com.qq.e.comm.plugin.n0.c cVar, String str, Exception exc, long j4, long j5, int i5) {
        com.qq.e.comm.plugin.n0.d a4 = a(exc, str);
        a4.a("tt", j4 == -1 ? "-999" : String.valueOf(j4));
        a4.a("pt", j5 == -1 ? "-999" : String.valueOf(j5));
        a4.a("rt", String.valueOf(i5));
        a4.a("ps", "3");
        a4.a("sr", "-999");
        v.a(1020009, cVar, null, Integer.valueOf(i4), a4, a(cVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.n0.c cVar, boolean z3, boolean z4) {
        v.a(1401002, cVar, Integer.valueOf(!z3 ? 1 : 2), Integer.valueOf(z4 ? 2 : 1), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.n0.c cVar, int i4) {
        v.b(1401001, cVar, Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z3, int i4, String str, String str2, com.qq.e.comm.plugin.n0.c cVar) {
        if (z3) {
            v.a(1022002, cVar);
            return;
        }
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("rs", str);
        dVar.a("ot", str2);
        v.b(1022003, cVar, Integer.valueOf(i4), dVar);
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

    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4, boolean z3, String str) {
        com.qq.e.comm.plugin.n0.d a4 = new com.qq.e.comm.plugin.n0.d().a("page", str).a("hasReward", Boolean.valueOf(z3));
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(2052002);
        hVar.a(cVar);
        hVar.a(a4);
        hVar.b(j4);
        v.a(hVar);
    }

    public static void a(com.qq.e.comm.plugin.n0.c cVar, long j4) {
        w.a(cVar, j4);
    }

    public static void a(com.qq.e.comm.plugin.g0.e eVar, int i4, long j4) {
        v.a(1022018, com.qq.e.comm.plugin.n0.c.a(eVar), Integer.valueOf(com.qq.e.comm.plugin.b.b.a(eVar.b0()) ? 1 : 0), a(eVar, i4, j4, true, true, (String) null));
    }

    public static void a(com.qq.e.comm.plugin.g0.e eVar, int i4, long j4, boolean z3, boolean z4) {
        com.qq.e.comm.plugin.n0.c a4 = com.qq.e.comm.plugin.n0.c.a(eVar);
        v.a(1022019, a4, null, null, a(eVar, i4, j4, z3, z4, (String) null), a(a4));
    }

    public static void a(com.qq.e.comm.plugin.g0.e eVar, long j4) {
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(2020038);
        hVar.a(com.qq.e.comm.plugin.n0.c.a(eVar));
        hVar.b(j4);
        v.a(hVar);
    }

    public static boolean a(com.qq.e.comm.plugin.n0.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.e()) || com.qq.e.comm.plugin.d0.a.d().f().a("rdasiy", cVar.e(), 1) != 1) ? false : true;
    }

    public static String a(f.t tVar) {
        if (tVar != null) {
            int i4 = a.f45983a[tVar.ordinal()];
            if (i4 == 1) {
                return "1";
            }
            if (i4 == 2) {
                return "4";
            }
            if (i4 == 3) {
                return "2";
            }
            if (i4 == 4) {
                return "3";
            }
        }
        return "-999";
    }

    public static com.qq.e.comm.plugin.n0.d a(long j4, long j5, int i4, String str, String str2) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("tt", j4 == -1 ? "-999" : String.valueOf(j4));
        dVar.a("pt", j5 == -1 ? "-999" : String.valueOf(j5));
        dVar.a("rt", String.valueOf(i4));
        if (TextUtils.isEmpty(str)) {
            str = "-999";
        }
        dVar.a("ps", str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "-999";
        }
        dVar.a("sr", str2);
        return dVar;
    }

    public static com.qq.e.comm.plugin.n0.d a(com.qq.e.comm.plugin.g0.e eVar, int i4, long j4, boolean z3, boolean z4, String str) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("rt", String.valueOf(i4));
        dVar.a("rpt", z3 ? "2" : "1");
        dVar.a("pt", j4 == -1 ? "-999" : String.valueOf(j4));
        dVar.a("fi", z4 ? "1" : "-1");
        if (TextUtils.isEmpty(str)) {
            str = "-999";
        }
        dVar.a("sr", str);
        String a4 = a(eVar);
        if (!TextUtils.isEmpty(a4)) {
            dVar.a("mt", a4);
        }
        return dVar;
    }

    private static String a(com.qq.e.comm.plugin.g0.e eVar) {
        int i4 = a.f45985c[eVar.o().ordinal()];
        return i4 != 1 ? i4 != 2 ? "" : "RewardVideo" : "Splash";
    }
}
