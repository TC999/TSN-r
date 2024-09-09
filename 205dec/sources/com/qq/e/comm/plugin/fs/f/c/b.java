package com.qq.e.comm.plugin.fs.f.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.plugin.adview.video.VideoCallback;
import com.qq.e.comm.plugin.callback.biz.LifecycleCallback;
import com.qq.e.comm.plugin.dl.h0;
import com.qq.e.comm.plugin.dl.q;
import com.qq.e.comm.plugin.dl.r;
import com.qq.e.comm.plugin.dl.s;
import com.qq.e.comm.plugin.fs.FSCallback;
import com.qq.e.comm.plugin.fs.e.f;
import com.qq.e.comm.plugin.g.a;
import com.qq.e.comm.plugin.g0.u;
import com.qq.e.comm.plugin.g0.y;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.j0;
import com.qq.e.comm.plugin.util.p0;
import java.io.File;
import java.util.ArrayList;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b implements com.qq.e.comm.plugin.fs.f.c.d, com.qq.e.comm.plugin.fs.f.d.a, com.qq.e.comm.plugin.h.f {
    private static final String H = "b";
    private boolean A;
    private com.qq.e.comm.plugin.fs.f.c.a B;
    private volatile int D;
    private com.qq.e.comm.plugin.util.w2.c E;

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f43321d;

    /* renamed from: e  reason: collision with root package name */
    private final s f43322e;

    /* renamed from: f  reason: collision with root package name */
    private final com.qq.e.comm.plugin.o0.h.f f43323f;

    /* renamed from: h  reason: collision with root package name */
    private com.qq.e.comm.plugin.g.a f43325h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f43326i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f43327j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f43328k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f43329l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f43330m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f43331n;

    /* renamed from: o  reason: collision with root package name */
    private final int f43332o;

    /* renamed from: p  reason: collision with root package name */
    private final FSCallback f43333p;

    /* renamed from: q  reason: collision with root package name */
    private final VideoCallback f43334q;

    /* renamed from: r  reason: collision with root package name */
    private final com.qq.e.comm.plugin.fs.d.d.a f43335r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f43336s;

    /* renamed from: u  reason: collision with root package name */
    private final int f43338u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f43339v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f43340w;

    /* renamed from: y  reason: collision with root package name */
    private int f43342y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f43343z;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.h.e f43320c = new com.qq.e.comm.plugin.h.e();

    /* renamed from: g  reason: collision with root package name */
    private final j0 f43324g = new j0();

    /* renamed from: t  reason: collision with root package name */
    private boolean f43337t = false;

    /* renamed from: x  reason: collision with root package name */
    private boolean f43341x = false;
    private final ArrayList<String> C = new ArrayList<>();
    private boolean F = false;
    private final f.o G = new f();

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a extends com.qq.e.comm.plugin.h.d<com.qq.e.comm.plugin.adview.video.a> {
        a(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(com.qq.e.comm.plugin.adview.video.a aVar) {
            b.this.a("closeVideoAuto");
            b.this.j();
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.fs.f.c.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class C0828b extends com.qq.e.comm.plugin.h.d<LifecycleCallback.a> {
        C0828b(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(LifecycleCallback.a aVar) {
            if (LifecycleCallback.a.DESTROYED == aVar) {
                b.this.i();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements com.qq.e.dl.h.b {

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements Runnable {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ View f43347c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ com.qq.e.comm.plugin.g0.e f43348d;

            a(View view, com.qq.e.comm.plugin.g0.e eVar) {
                this.f43347c = view;
                this.f43348d = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.qq.e.comm.plugin.e.a.a().a(this.f43347c, this.f43348d);
                com.qq.e.comm.plugin.e.i.a d4 = com.qq.e.comm.plugin.e.a.a().d(this.f43347c);
                if (d4 != null) {
                    d4.a(this.f43348d.a0());
                }
                b.this.f43333p.E().a();
                com.qq.e.comm.plugin.fs.e.a.a(this.f43348d, this.f43347c, 3);
            }
        }

        c() {
        }

        @Override // com.qq.e.dl.h.b
        public void a(com.qq.e.dl.l.h hVar, com.qq.e.dl.h.a aVar) {
            com.qq.e.comm.plugin.g0.e a4;
            if (hVar == null || hVar.m() == null || aVar == null) {
                return;
            }
            d1.a(b.H, "View\u53ef\u89c1\u6027\u53d8\u5316,state = %s,params = %s", Integer.valueOf(aVar.f46894a), aVar.f46895b);
            String optString = aVar.f46895b.optString("tid");
            if (aVar.f46894a != 1 || TextUtils.isEmpty(optString) || optString.equals(b.this.f43321d.K0()) || b.this.C.contains(optString) || (a4 = b.this.f43321d.a(optString)) == null) {
                return;
            }
            b.this.C.add(optString);
            View m4 = hVar.m();
            m4.post(new a(m4, a4));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d implements a.InterfaceC0834a {
        d() {
        }

        @Override // com.qq.e.comm.plugin.g.a.InterfaceC0834a
        public void a(float f4) {
            b.this.f43328k = f4 > 0.0f;
            b.this.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e implements com.qq.e.comm.plugin.util.w2.b {
        e() {
        }

        @Override // com.qq.e.comm.plugin.util.w2.b
        public void a(long j4) {
            if (b.this.f43321d.d1()) {
                b.this.f43333p.j().b(Long.valueOf(j4));
            }
        }

        @Override // com.qq.e.comm.plugin.util.w2.b
        public void b(long j4) {
            if (b.this.f43322e != null) {
                b.this.f43324g.a("vdoTime", j4);
                b.this.f43322e.a(b.this.f43324g.a());
            }
        }

        @Override // com.qq.e.comm.plugin.util.w2.b
        public long c() {
            return com.qq.e.comm.plugin.fs.e.d.b();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class f extends com.qq.e.comm.plugin.o0.c {
        f() {
        }

        @Override // com.qq.e.comm.plugin.o0.c, com.qq.e.comm.plugin.o0.h.f.o
        public void a(int i4, Exception exc) {
            super.a(i4, exc);
            b.this.f43334q.m().b(new com.qq.e.comm.plugin.adview.video.a(true, i4, exc, 5003));
            com.qq.e.comm.plugin.fs.e.f.a().e(b.this.f43321d);
        }

        @Override // com.qq.e.comm.plugin.o0.c, com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoComplete() {
            super.onVideoComplete();
            b.this.a(true);
        }

        @Override // com.qq.e.comm.plugin.o0.c, com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoPause() {
            super.onVideoPause();
            b.this.f43334q.onPause().a();
        }

        @Override // com.qq.e.comm.plugin.o0.c, com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoReady() {
            super.onVideoReady();
            b.this.f43336s = true;
            b.this.o();
            b.this.f43334q.c().b(Integer.valueOf(b.this.f43323f == null ? 0 : b.this.f43323f.getDuration()));
        }

        @Override // com.qq.e.comm.plugin.o0.c, com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoResume() {
            super.onVideoResume();
            b.this.f43334q.onResume().a();
            b.this.f43327j = true;
        }

        @Override // com.qq.e.comm.plugin.o0.c, com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoStart() {
            super.onVideoStart();
            b.this.f43326i = true;
            b.this.f43334q.onStart().a();
            com.qq.e.comm.plugin.fs.e.f.a().f(b.this.f43321d);
        }

        @Override // com.qq.e.comm.plugin.o0.c, com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoStop() {
            super.onVideoStop();
            b.this.f43334q.onStop().a();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class g implements View.OnAttachStateChangeListener {
        g() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (b.this.f43325h != null) {
                b.this.f43325h.a(view.getContext());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (b.this.f43325h != null) {
                b.this.f43325h.b(view.getContext());
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class i extends r {
        i(q qVar, com.qq.e.comm.plugin.g0.e eVar) {
            super(qVar, eVar);
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void a(com.qq.e.comm.plugin.i.f fVar, com.qq.e.dl.l.j.c cVar) {
            super.a(fVar, cVar);
            b.this.f43333p.w().b(fVar);
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void c() {
            super.c();
            d1.a(b.H, "volumeChanged");
            b bVar = b.this;
            bVar.f43328k = !bVar.f43328k;
            b.this.o();
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void d(com.qq.e.dl.l.j.c cVar) {
            super.d(cVar);
            d1.a(b.H, "adClose");
            b.this.f43333p.i().a();
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void e(com.qq.e.dl.l.j.c cVar) {
            d1.a(b.H, "onAdLogoClick");
            b.this.f43333p.s().a();
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void f(com.qq.e.dl.l.j.c cVar) {
            d1.a(b.H, "onEndCardClose");
            b.this.f43333p.B().a();
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void g(com.qq.e.dl.l.j.c cVar) {
            super.g(cVar);
            d1.a(b.H, "forceCloseAd");
            b.this.f43333p.B().a();
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void h(com.qq.e.dl.l.j.c cVar) {
            com.qq.e.comm.plugin.fs.e.e.a(b.this.f43321d, 0);
            b.this.f43333p.k().a();
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void l(com.qq.e.dl.l.j.c cVar) {
            if (b.this.B != null) {
                b.this.B.a();
            }
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void m(com.qq.e.dl.l.j.c cVar) {
            if (b.this.B != null) {
                b.this.B.b();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class j implements Runnable {

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements Runnable {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f43357c;

            a(String str) {
                this.f43357c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                File c4 = b1.c(b.this.f43321d.L0());
                if (c4 != null && c4.exists()) {
                    b.this.b(c4.getAbsolutePath());
                    return;
                }
                com.qq.e.comm.plugin.fs.e.f.a().a(b.this.f43321d.L0(), this.f43357c, new C0829a(), b.this.f43321d, false);
                if (TextUtils.isEmpty(this.f43357c)) {
                    return;
                }
                b.this.b(this.f43357c);
            }

            /* compiled from: A */
            /* renamed from: com.qq.e.comm.plugin.fs.f.c.b$j$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\2450172.dex */
            class C0829a extends f.d {
                C0829a() {
                }

                @Override // com.qq.e.comm.plugin.fs.e.f.d, com.qq.e.comm.plugin.fs.e.f.c
                public void a(int i4, long j4, long j5) {
                    super.a(i4, j4, j5);
                    b.this.D = i4;
                }

                @Override // com.qq.e.comm.plugin.fs.e.f.c
                public void onCancel() {
                    d1.b(b.H, "\u89c6\u9891\u4e0b\u8f7d\u88ab\u53d6\u6d88");
                    b.this.f43334q.m().b(new com.qq.e.comm.plugin.adview.video.a(false, -1, null, 5002));
                }

                @Override // com.qq.e.comm.plugin.fs.e.f.d, com.qq.e.comm.plugin.fs.e.f.c
                public void onStart() {
                    super.onStart();
                    b.this.f43334q.C().a();
                }

                @Override // com.qq.e.comm.plugin.fs.e.f.d, com.qq.e.comm.plugin.fs.e.f.c
                public void a(String str) {
                    super.a(str);
                    if ((TextUtils.isEmpty(a.this.f43357c) || !b.this.f43326i) && !TextUtils.isEmpty(str)) {
                        b.this.b(str);
                    }
                }

                @Override // com.qq.e.comm.plugin.fs.e.f.c
                public void a(com.qq.e.comm.plugin.p.d dVar) {
                    d1.a(b.H, "\u89c6\u9891\u4e0b\u8f7d\u5931\u8d25", dVar);
                    b.this.f43334q.m().b(new com.qq.e.comm.plugin.adview.video.a(false, dVar.a(), dVar, 5002));
                }

                @Override // com.qq.e.comm.plugin.fs.e.f.c
                public void a() {
                    d1.b(b.H, "\u89c6\u9891\u4e0b\u8f7d\u8d85\u65f6");
                    b.this.f43334q.m().b(new com.qq.e.comm.plugin.adview.video.a(false, -2, null, 5002));
                }
            }
        }

        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String a4;
            if (!com.qq.e.comm.plugin.fs.e.f.a().d(b.this.f43321d)) {
                a4 = com.qq.e.comm.plugin.p0.e.a().a(b.this.f43321d.L0());
            } else {
                a4 = com.qq.e.comm.plugin.p0.e.a().c(b.this.f43321d.L0(), b.this.f43321d.o().f42000e);
            }
            p0.a((Runnable) new a(a4));
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class k extends com.qq.e.comm.plugin.h.d<Boolean> {
        k(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Boolean bool) {
            if (bool != null) {
                b.this.f43339v = !bool.booleanValue();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class l extends com.qq.e.comm.plugin.h.d<Void> {
        l(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r22) {
            if (b.this.f43337t) {
                b.this.f43333p.B().a();
            } else {
                b.this.a("closeVideo");
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class m extends com.qq.e.comm.plugin.h.d<Void> {
        m(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r3) {
            if (b.this.f43340w) {
                return;
            }
            b.this.f43324g.a("closeVis", 2);
            b.this.f43322e.a(b.this.f43324g.a());
            b.this.f43322e.r();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class n extends com.qq.e.comm.plugin.h.d<Void> {
        n(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r12) {
            b.this.p();
        }
    }

    public b(Context context, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.fs.d.d.a aVar) {
        boolean z3 = false;
        this.f43321d = eVar;
        this.f43335r = aVar;
        y i02 = eVar.i0();
        if (i02 != null) {
            this.f43342y = i02.d();
        }
        if (aVar.j()) {
            l();
        }
        if ((eVar instanceof u) && ((u) eVar).f()) {
            this.f43338u = com.qq.e.comm.plugin.rewardvideo.q.c(this.f43321d) * 1000;
        } else {
            this.f43338u = -1;
        }
        this.f43339v = this.f43338u >= 0;
        this.f43332o = com.qq.e.comm.plugin.rewardvideo.q.a(this.f43321d);
        this.f43333p = (FSCallback) com.qq.e.comm.plugin.h.a.b(eVar.l0(), FSCallback.class);
        this.f43334q = (VideoCallback) com.qq.e.comm.plugin.h.a.b(eVar.l0(), VideoCallback.class);
        boolean x3 = com.qq.e.comm.plugin.d0.a.d().c().x();
        y i03 = eVar.i0();
        if (i03 != null && x3 == i03.v()) {
            z3 = true;
        }
        s a4 = com.qq.e.comm.plugin.dl.i.a().a(context, eVar, z3);
        this.f43322e = a4;
        if (a4 == null) {
            this.f43323f = null;
            return;
        }
        a4.a((h0.c) null);
        com.qq.e.comm.plugin.o0.h.f i4 = this.f43322e.i();
        this.f43323f = i4;
        if (i4 == null) {
            return;
        }
        com.qq.e.comm.plugin.fs.f.c.a aVar2 = new com.qq.e.comm.plugin.fs.f.c.a(this.f43321d, this.f43324g, this.f43322e, this);
        this.B = aVar2;
        aVar2.c();
        this.f43343z = this.f43322e.m();
        this.f43323f.addOnAttachStateChangeListener(new g());
        this.f43323f.a(new h(eVar, com.qq.e.comm.plugin.fs.e.f.a().d(this.f43321d)));
        this.f43328k = this.f43335r.l();
        h();
        this.f43322e.a(new i(this.f43322e, eVar));
        n();
        d0.f46406b.submit(new j());
        m();
        this.f43333p.b().a(new k(this));
        this.f43333p.J().a(new l(this));
        this.f43333p.r().a(new m(this));
        this.f43333p.v().a(new n(this));
        this.f43334q.m().a(new a(this));
        ((LifecycleCallback) com.qq.e.comm.plugin.h.a.b(eVar.l0(), LifecycleCallback.class)).l().a(new C0828b(this));
    }

    @Override // com.qq.e.comm.plugin.h.f
    public boolean isDestroyed() {
        return this.F;
    }

    @Override // com.qq.e.comm.plugin.c.b
    public void onReward(int i4) {
        s sVar = this.f43322e;
        if (sVar != null) {
            sVar.a(i4);
        }
    }

    private void h() {
        j0 j0Var = new j0();
        j0Var.a("callback", this.G);
        if (this.f43335r.k()) {
            this.f43341x = true;
            j0Var.a("closeVis", 0);
        } else {
            j0Var.a("closeVis", 2);
        }
        j0Var.a("autoClickVis", 2);
        com.qq.e.comm.plugin.dl.d.a(j0Var);
        this.f43322e.a(j0Var.a());
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f43341x) {
            return;
        }
        this.f43324g.a("tipVis", 2);
        this.f43324g.a("volumeVis", 2);
        this.f43324g.a("closeVis", 0);
        this.f43322e.a(this.f43324g.a());
        this.f43341x = true;
    }

    private void l() {
        com.qq.e.comm.plugin.util.w2.c cVar = new com.qq.e.comm.plugin.util.w2.c(this.f43321d);
        this.E = cVar;
        cVar.a(new e());
    }

    private void m() {
        this.f43325h = new com.qq.e.comm.plugin.g.a(new d());
    }

    private void n() {
        this.f43322e.a(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.f43324g.a("vidMut", !this.f43328k ? 1 : 0);
        if (this.f43336s) {
            this.f43324g.a("volume", this.f43328k ? 1 : 0);
            this.f43324g.a("volumeVis", 0);
        } else {
            this.f43324g.a("volumeVis", 2);
        }
        this.f43322e.a(this.f43324g.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.f43340w) {
            return;
        }
        this.f43340w = true;
        this.f43329l = true;
        this.f43339v = false;
        this.f43341x = true;
        this.f43324g.a("closeVis", 2);
        this.f43322e.a(this.f43324g.a());
        this.f43322e.r();
    }

    @Override // com.qq.e.comm.plugin.h.f
    public com.qq.e.comm.plugin.h.e g() {
        return this.f43320c;
    }

    public void i() {
        s sVar = this.f43322e;
        if (sVar != null) {
            sVar.b();
        }
        com.qq.e.comm.plugin.o0.h.f fVar = this.f43323f;
        if (fVar != null) {
            fVar.i();
        }
        this.B = null;
        String str = H;
        d1.a(str, "%s, destroy", str);
        com.qq.e.comm.plugin.fs.e.f.a().a(this.f43321d, this.f43323f);
        this.F = true;
    }

    public s k() {
        return this.f43322e;
    }

    @Override // com.qq.e.comm.plugin.fs.f.c.d
    public boolean d() {
        return this.f43327j;
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class h extends com.qq.e.comm.plugin.o0.h.d {
        h(com.qq.e.comm.plugin.g0.e eVar, boolean z3) {
            super(eVar, z3);
        }

        @Override // com.qq.e.comm.plugin.o0.h.d, com.qq.e.comm.plugin.o0.h.f.p
        public void a(int i4, int i5) {
            super.a(i4, i5);
            com.qq.e.comm.plugin.fs.e.f.a().a(b.this.f43321d, i4, i5, b.this.D);
        }

        @Override // com.qq.e.comm.plugin.o0.h.d, com.qq.e.comm.plugin.o0.h.f.p
        public boolean a(int i4, f.t tVar, float f4) {
            if (super.a(i4, tVar, f4)) {
                com.qq.e.comm.plugin.fs.e.f.a().a(b.this.f43321d, i4, tVar);
                return true;
            }
            return false;
        }

        @Override // com.qq.e.comm.plugin.o0.h.d
        public void a() {
            b.this.a(false);
            if (!b.this.f43322e.o()) {
                b.this.f43333p.o().a();
            }
            b.this.f43323f.G();
        }
    }

    @Override // com.qq.e.comm.plugin.c.c
    public com.qq.e.comm.plugin.o0.h.f b() {
        return this.f43323f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z3) {
        if (z3) {
            this.f43334q.onComplete().a();
        }
        j();
        a("closeVideoAuto");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.f43323f == null) {
            d1.b(H, "setVideoSource, mVideoView is null");
            return;
        }
        d1.a(H, "setVideoSource, source = %s", str);
        this.f43334q.D().a();
        this.f43324g.a("videoRes", str);
        this.f43322e.a(this.f43324g.a());
    }

    @Override // com.qq.e.comm.plugin.c.b
    public View a() {
        s sVar = this.f43322e;
        if (sVar == null) {
            return null;
        }
        return sVar.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.f43337t = true;
        if (this.f43323f == null) {
            d1.b(H, "closeVideoView, mVideoView is null");
        } else {
            this.f43322e.a(str);
        }
    }

    @Override // com.qq.e.comm.plugin.c.c
    public void a(com.qq.e.comm.plugin.fs.f.d.c cVar) {
        cVar.a(this);
    }

    @Override // com.qq.e.comm.plugin.fs.f.d.a
    public boolean a(f.t tVar, long j4, long j5) {
        if (j4 <= 0) {
            return true;
        }
        this.f43334q.z().b(Long.valueOf(j5));
        long a4 = com.qq.e.comm.plugin.fs.e.b.a(j4, this.f43335r);
        if (this.f43343z && !this.f43340w && a4 - j5 <= this.f43342y * 1000) {
            p();
        }
        this.f43324g.a("vdoP", ((((float) j5) * 1.0f) / ((float) a4)) * 100.0f);
        com.qq.e.comm.plugin.util.w2.c cVar = this.E;
        if (cVar != null) {
            cVar.a(j5);
        }
        long min = Math.min(a4, this.f43335r.b() * 1000);
        if (!this.f43329l && j5 - min >= 0) {
            this.f43322e.b("showBottomCard");
            this.f43329l = true;
        }
        long e4 = this.f43335r.e() * 1000;
        if (!this.f43331n && j5 >= e4) {
            this.f43324g.a("appInfoVis", 2);
            this.f43331n = true;
        }
        if (!this.f43330m && j5 >= this.f43332o * 1000) {
            this.f43324g.a("autoClickVis", 0);
            this.f43330m = true;
        }
        if (this.f43339v && this.f43336s && j5 >= this.f43338u) {
            this.f43339v = false;
            this.f43322e.b("showGameEntry");
        }
        if (!this.f43341x && j5 >= com.qq.e.comm.plugin.fs.e.d.a()) {
            this.f43324g.a("closeVis", 0);
            this.f43341x = true;
        }
        if (!this.A && com.qq.e.comm.plugin.fs.e.b.a(j5, a4, this.f43335r)) {
            d1.a(H, "video stop before complete");
            if (this.f43323f != null) {
                a(true);
                this.f43323f.G();
            }
            this.A = true;
        }
        this.f43322e.a(j5);
        this.f43322e.a(this.f43324g.a());
        return true;
    }
}
