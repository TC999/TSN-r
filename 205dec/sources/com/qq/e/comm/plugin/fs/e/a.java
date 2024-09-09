package com.qq.e.comm.plugin.fs.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.plugin.b.g;
import com.qq.e.comm.plugin.g0.s;
import com.qq.e.comm.plugin.g0.u;
import com.qq.e.comm.plugin.g0.y;
import com.qq.e.comm.plugin.h0.i;
import com.qq.e.comm.plugin.h0.l;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.rewardvideo.q;
import com.qq.e.comm.plugin.util.a0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.l1;
import com.qq.e.comm.plugin.util.q1;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.fs.e.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class RunnableC0821a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f43242c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.e f43243d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f43244e;

        RunnableC0821a(View view, com.qq.e.comm.plugin.g0.e eVar, int i4) {
            this.f43242c = view;
            this.f43243d = eVar;
            this.f43244e = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.comm.plugin.l0.c.a(com.qq.e.comm.plugin.e.a.a().c(this.f43242c), this.f43243d, null, this.f43244e, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f43245a;

        static {
            int[] iArr = new int[g.values().length];
            f43245a = iArr;
            try {
                iArr[g.UNIFIED_INTERSTITIAL_FULLSCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43245a[g.REWARDVIDEOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static void a(Context context, com.qq.e.comm.plugin.g0.e eVar, boolean z3) {
        i.f();
        if (context == null) {
            context = com.qq.e.comm.plugin.d0.a.d().a();
            z3 = true;
        }
        Intent intent = new Intent();
        if (z3) {
            intent.addFlags(268435456);
        }
        boolean x3 = com.qq.e.comm.plugin.d0.a.d().c().x();
        y i02 = eVar.i0();
        a(context, intent, x3);
        if (i02 != null) {
            if (i02.v() && x3) {
                a(context, intent, true);
            } else if (!i02.v() && !x3) {
                a(context, intent, false);
            }
        }
        ((com.qq.e.comm.plugin.d0.b.b) com.qq.e.comm.plugin.d0.b.e.a(eVar.l0(), com.qq.e.comm.plugin.d0.b.b.class)).a(eVar);
        intent.putExtra("gdt_activity_delegate_name", com.qq.e.comm.plugin.a.FULLSCREEN_ACTIVITY);
        intent.putExtra("appid", eVar.p());
        intent.putExtra("objectId", eVar.l0());
        l.a().c(1).a();
        try {
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static void a(com.qq.e.comm.plugin.g0.e eVar, View view, int i4) {
        pro.getVresult(209, 1, eVar, view, Integer.valueOf(i4));
    }

    public static void a(com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.fs.f.c.d dVar, boolean z3, int i4) {
        pro.getVresult(210, 1, eVar, dVar, Boolean.valueOf(z3), Integer.valueOf(i4));
    }

    private static void a(Context context, Intent intent, boolean z3) {
        if (z3) {
            intent.setClassName(context, q1.c());
        } else {
            intent.setClassName(context, q1.d());
        }
    }

    public static void a(com.qq.e.comm.plugin.i.d0.d dVar, com.qq.e.comm.plugin.i.f fVar, boolean z3, View view) {
        com.qq.e.comm.plugin.g0.e a4 = fVar.a();
        if (a4 == null) {
            return;
        }
        boolean a5 = a(a4, fVar.f44109f);
        boolean z4 = true;
        boolean z5 = a(fVar) && !a4.k1();
        com.qq.e.comm.plugin.i.g.a(new h.b(a4).a(fVar.f44109f).a(fVar.f44105b).c(fVar.f44106c).b(fVar.f44110g).e(z5).d(fVar.f44107d).a((a5 || z3) ? false : false).b(a4.X0()).e(fVar.f44114k).a(fVar.f44115l).d(fVar.f44120q).a(), dVar);
        l1.a(view, a4, fVar.f44105b);
        if (z5) {
            com.qq.e.comm.plugin.n0.w.f.a(a4.o(), com.qq.e.comm.plugin.n0.c.a(a4));
        }
    }

    public static boolean a(com.qq.e.comm.plugin.i.f fVar) {
        return fVar.f44109f == 10 || fVar.f44116m;
    }

    public static boolean a(com.qq.e.comm.plugin.g0.e eVar, int i4) {
        if (eVar instanceof u) {
            return (((u) eVar).f() && i4 == 4) || i4 == 10;
        }
        return false;
    }

    public static void a(String str, String str2, int i4, long j4, String str3, String str4, com.qq.e.comm.plugin.n0.c cVar) {
        d1.a("trackWebViewEvent, adType : " + str + " area : " + str2 + " endCardType : " + i4 + " costTime : " + j4 + " url : " + str3, new Object[0]);
        com.qq.e.comm.plugin.n0.h b4 = new com.qq.e.comm.plugin.n0.h(i4 == 1 ? 2020031 : i4 == 2 ? 2020034 : 2020030).b(j4);
        b4.a(cVar);
        int a4 = com.qq.e.comm.plugin.d0.a.d().c().n().a();
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("adType", str);
        dVar.a("area", str2);
        dVar.a("nt", Integer.valueOf(a4));
        dVar.a("wu", str3);
        if (!TextUtils.isEmpty(str4)) {
            dVar.a("errorMsg", str4);
        }
        b4.a(dVar);
        v.a(b4);
    }

    public static boolean a(g gVar) {
        if (gVar == null) {
            return false;
        }
        int i4 = b.f43245a[gVar.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                return false;
            }
            return q.a();
        }
        return com.qq.e.comm.plugin.intersitial2.j.c.a();
    }

    public static int a(com.qq.e.comm.plugin.g0.e eVar, boolean z3) {
        if (z3) {
            return 8;
        }
        if (a(eVar.o())) {
            return 147;
        }
        if (a0.a(eVar)) {
            return 120;
        }
        return s.a(eVar) ? 105 : 96;
    }

    public static boolean a(com.qq.e.comm.plugin.g0.e eVar) {
        if (eVar == null) {
            return false;
        }
        return com.qq.e.comm.plugin.d0.a.d().f().a(eVar.o().g() ? "ibcke" : "rbcke", eVar.q0(), 0) == 1;
    }
}
