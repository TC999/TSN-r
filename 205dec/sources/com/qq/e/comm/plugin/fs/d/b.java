package com.qq.e.comm.plugin.fs.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.plugin.adview.video.VideoCallback;
import com.qq.e.comm.plugin.fs.FSCallback;
import com.qq.e.comm.plugin.g0.u;
import com.qq.e.comm.plugin.g0.y;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.rewardvideo.n;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.l1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class b implements com.qq.e.comm.plugin.fs.f.e.d.a, com.qq.e.comm.plugin.h.f {

    /* renamed from: c  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.g0.e f43211c;

    /* renamed from: d  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.n0.c f43212d;

    /* renamed from: e  reason: collision with root package name */
    protected Activity f43213e;

    /* renamed from: f  reason: collision with root package name */
    protected com.qq.e.comm.plugin.fs.d.d.a f43214f;

    /* renamed from: g  reason: collision with root package name */
    protected ViewGroup f43215g;

    /* renamed from: h  reason: collision with root package name */
    protected com.qq.e.comm.plugin.fs.f.a f43216h;

    /* renamed from: i  reason: collision with root package name */
    protected com.qq.e.comm.plugin.fs.f.e.d.f f43217i;

    /* renamed from: j  reason: collision with root package name */
    protected com.qq.e.comm.plugin.c.c f43218j;

    /* renamed from: k  reason: collision with root package name */
    protected com.qq.e.comm.plugin.o0.h.f f43219k;

    /* renamed from: l  reason: collision with root package name */
    protected com.qq.e.comm.plugin.fs.f.d.c f43220l;

    /* renamed from: m  reason: collision with root package name */
    protected boolean f43221m;

    /* renamed from: n  reason: collision with root package name */
    protected boolean f43222n;

    /* renamed from: o  reason: collision with root package name */
    protected com.qq.e.comm.plugin.i.d0.d f43223o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f43224p = false;

    /* renamed from: q  reason: collision with root package name */
    private final com.qq.e.comm.plugin.h.e f43225q = new com.qq.e.comm.plugin.h.e();

    /* renamed from: r  reason: collision with root package name */
    protected int f43226r = -1;

    /* renamed from: s  reason: collision with root package name */
    private long f43227s;

    /* renamed from: t  reason: collision with root package name */
    protected long f43228t;

    /* renamed from: u  reason: collision with root package name */
    protected boolean f43229u;

    /* renamed from: v  reason: collision with root package name */
    protected boolean f43230v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a extends com.qq.e.comm.plugin.i.d0.d {
        a(Context context) {
            super(context);
        }

        @Override // com.qq.e.comm.plugin.i.d0.d, com.qq.e.comm.plugin.i.d0.b
        public void a(boolean z3) {
            super.a(z3);
            if (z3) {
                b.this.h().a().a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.fs.d.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class C0820b extends com.qq.e.comm.plugin.h.d<Void> {
        C0820b(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r12) {
            b.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c extends com.qq.e.comm.plugin.h.d<com.qq.e.comm.plugin.i.f> {
        c(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(com.qq.e.comm.plugin.i.f fVar) {
            b.this.a(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d extends com.qq.e.comm.plugin.h.d<Boolean> {
        d(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Boolean bool) {
            com.qq.e.comm.plugin.fs.f.e.d.f fVar = b.this.f43217i;
            if (fVar != null) {
                fVar.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e extends com.qq.e.comm.plugin.h.d<com.qq.e.comm.plugin.adview.video.a> {
        e(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(com.qq.e.comm.plugin.adview.video.a aVar) {
            if (b.this.f43219k != null) {
                int a4 = aVar.a();
                b bVar = b.this;
                n.a(a4, bVar.f43212d, bVar.f43211c.L0(), aVar.c(), b.this.f43219k.getDuration(), b.this.f43219k.getCurrentPosition(), com.qq.e.comm.plugin.fs.e.d.b());
            } else {
                int a5 = aVar.a();
                b bVar2 = b.this;
                n.a(a5, bVar2.f43212d, bVar2.f43211c.L0(), aVar.c(), -1L, -1L, com.qq.e.comm.plugin.fs.e.d.b());
            }
            com.qq.e.comm.plugin.fs.f.d.c cVar = b.this.f43220l;
            if (cVar != null) {
                cVar.a(!aVar.d());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class f extends com.qq.e.comm.plugin.h.d<Void> {
        f(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r14) {
            b.this.f43211c.i(System.currentTimeMillis());
            b bVar = b.this;
            com.qq.e.comm.plugin.o0.h.f fVar = bVar.f43219k;
            if (fVar != null) {
                n.a(bVar.f43212d, fVar.getDuration(), b.this.f43219k.getCurrentPosition(), com.qq.e.comm.plugin.fs.e.d.b());
            } else {
                n.a(bVar.f43212d, -1L, -1L, com.qq.e.comm.plugin.fs.e.d.b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class g extends com.qq.e.comm.plugin.h.d<Void> {
        g(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r20) {
            com.qq.e.comm.plugin.o0.h.f fVar;
            b bVar = b.this;
            if (bVar.f43219k != null) {
                com.qq.e.comm.plugin.fs.e.e.a(f.t.END, bVar.f43211c, fVar.getDuration(), b.this.f43219k.getCurrentPosition(), com.qq.e.comm.plugin.fs.e.d.b());
            } else {
                com.qq.e.comm.plugin.fs.e.e.a(f.t.END, bVar.f43211c, -1L, -1L, com.qq.e.comm.plugin.fs.e.d.b());
            }
            b bVar2 = b.this;
            bVar2.f43226r = 1;
            if (bVar2.f43221m && bVar2.f43211c.d1()) {
                long M0 = b.this.f43211c.M0() * 1000;
                com.qq.e.comm.plugin.o0.h.f fVar2 = b.this.f43219k;
                if (fVar2 != null) {
                    M0 = fVar2.getCurrentPosition();
                }
                b.this.h().j().b(Long.valueOf(M0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class h extends com.qq.e.comm.plugin.h.d<Void> {
        h(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r20) {
            b bVar = b.this;
            com.qq.e.comm.plugin.o0.h.f fVar = bVar.f43219k;
            if (fVar != null) {
                com.qq.e.comm.plugin.fs.e.e.a(f.t.PAUSE, bVar.f43211c, fVar.getDuration(), b.this.f43219k.getCurrentPosition(), com.qq.e.comm.plugin.fs.e.d.b());
            } else {
                com.qq.e.comm.plugin.fs.e.e.a(f.t.PAUSE, bVar.f43211c, -1L, -1L, com.qq.e.comm.plugin.fs.e.d.b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class i extends com.qq.e.comm.plugin.h.d<Boolean> {
        i(com.qq.e.comm.plugin.h.f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Boolean bool) {
            b bVar = b.this;
            com.qq.e.comm.plugin.o0.h.f fVar = bVar.f43219k;
            if (fVar != null) {
                com.qq.e.comm.plugin.fs.e.e.a(f.t.PLAY, bVar.f43211c, fVar.getDuration(), b.this.f43219k.getCurrentPosition(), com.qq.e.comm.plugin.fs.e.d.b());
            } else {
                com.qq.e.comm.plugin.fs.e.e.a(f.t.PLAY, bVar.f43211c, -1L, -1L, com.qq.e.comm.plugin.fs.e.d.b());
            }
        }
    }

    public b(Activity activity, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.fs.d.d.a aVar) {
        this.f43213e = activity;
        this.f43211c = eVar;
        this.f43212d = com.qq.e.comm.plugin.n0.c.a(eVar);
        this.f43214f = aVar;
        this.f43222n = !this.f43211c.l1();
        this.f43221m = aVar.j();
        q();
    }

    public void e() {
        d1.a("FSPresenter", "closeAD");
        com.qq.e.comm.plugin.o0.h.f fVar = this.f43219k;
        if (fVar != null) {
            n.a(this.f43212d, fVar.getDuration(), this.f43219k.getCurrentPosition(), com.qq.e.comm.plugin.fs.e.d.b(), this.f43219k.getVideoState(), this.f43227s, this.f43228t);
        } else {
            n.a(this.f43212d, -1L, -1L, com.qq.e.comm.plugin.fs.e.d.b(), (f.t) null, this.f43227s, this.f43228t);
        }
        Activity activity = this.f43213e;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        this.f43213e.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f() {
        y i02 = this.f43211c.i0();
        int i4 = -1;
        if (i02 == null) {
            return -1;
        }
        if (i02.p() != 1 && (this.f43211c.c1() ? this.f43229u : !this.f43230v)) {
            i4 = 1;
        }
        this.f43229u = false;
        return i4;
    }

    @Override // com.qq.e.comm.plugin.h.f
    public com.qq.e.comm.plugin.h.e g() {
        return this.f43225q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FSCallback h() {
        return (FSCallback) com.qq.e.comm.plugin.h.a.b(this.f43214f.g(), FSCallback.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VideoCallback i() {
        return (VideoCallback) com.qq.e.comm.plugin.h.a.b(this.f43214f.g(), VideoCallback.class);
    }

    @Override // com.qq.e.comm.plugin.h.f
    public boolean isDestroyed() {
        return this.f43224p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        this.f43217i.a(this);
        com.qq.e.comm.plugin.fs.f.d.c cVar = this.f43220l;
        if (cVar != null) {
            cVar.a(this.f43217i);
        }
    }

    protected void k() {
        com.qq.e.comm.plugin.fs.f.d.c cVar = new com.qq.e.comm.plugin.fs.f.d.c();
        this.f43220l = cVar;
        cVar.a(this.f43219k);
        this.f43216h.a(this.f43220l);
    }

    public abstract void l();

    public abstract void m();

    public void n() {
        d1.a("FSPresenter", "onDestroy");
        this.f43224p = true;
        com.qq.e.comm.plugin.fs.f.d.c cVar = this.f43220l;
        if (cVar != null) {
            cVar.a();
            this.f43220l = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean o() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f43219k;
        if (fVar != null) {
            fVar.pause();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        com.qq.e.comm.plugin.o0.h.f fVar = this.f43219k;
        if (fVar != null) {
            fVar.play();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
        this.f43223o = new a(this.f43213e);
        h().B().a(new C0820b(this));
        h().h().a(new c(this));
        h().o().a(new d(this));
        i().m().a(new e(this));
        i().onStart().a(new f(this));
        i().onComplete().a(new g(this));
        i().onPause().a(new h(this));
        i().onResume().a(new i(this));
    }

    public void a(ViewGroup viewGroup, com.qq.e.comm.plugin.fs.f.a aVar, com.qq.e.comm.plugin.fs.f.e.d.f fVar) {
        this.f43227s = System.currentTimeMillis();
        this.f43215g = viewGroup;
        this.f43216h = aVar;
        this.f43217i = fVar;
        if (!this.f43222n && !this.f43211c.i0().y()) {
            com.qq.e.comm.plugin.c.c b4 = this.f43216h.b();
            this.f43218j = b4;
            this.f43219k = b4 == null ? null : b4.b();
            k();
        }
        if (this.f43217i != null) {
            j();
        }
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.d.a
    public void a(com.qq.e.comm.plugin.i.f fVar, boolean z3) {
        int i4;
        com.qq.e.comm.plugin.g0.e a4 = fVar.a();
        if (a4 == null) {
            return;
        }
        if (z3) {
            i4 = 10;
        } else {
            i4 = ((a4 instanceof u) && ((u) a4).f()) ? 4 : 2;
        }
        fVar.f44109f = i4;
        com.qq.e.comm.plugin.e.a a5 = com.qq.e.comm.plugin.e.a.a();
        a5.a(this.f43215g, a4, fVar.f44105b);
        com.qq.e.comm.plugin.e.i.a d4 = a5.d(this.f43215g);
        if (d4 != null) {
            d4.b(fVar.f44106c);
            d4.a(i4);
            d4.a(fVar.f44117n);
        }
        fVar.f44105b = a5.a(this.f43215g);
        com.qq.e.comm.plugin.fs.e.a.a(this.f43223o, fVar, false, (View) this.f43215g);
        h().y().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.qq.e.comm.plugin.i.f fVar) {
        com.qq.e.comm.plugin.g0.e a4 = fVar.a();
        if (a4 == null) {
            return;
        }
        com.qq.e.comm.plugin.e.a a5 = com.qq.e.comm.plugin.e.a.a();
        if (!TextUtils.isEmpty(fVar.f44105b)) {
            a5.a(this.f43215g, a4, fVar.f44105b);
        }
        int f4 = f();
        com.qq.e.comm.plugin.e.i.a d4 = a5.d(this.f43215g);
        if (d4 != null) {
            d4.b(fVar.f44106c);
            d4.a(fVar.f44109f);
            d4.d(fVar.f44110g);
            d4.a(fVar.b());
            d4.a(fVar.f44117n);
            d4.a(fVar.f44118o);
            d4.b(fVar.f44119p);
            d4.c(f4);
        }
        String a6 = a5.a(this.f43215g);
        if (TextUtils.isEmpty(a6)) {
            return;
        }
        com.qq.e.comm.plugin.i.g.a(new h.b(a4).a(a6).a(fVar.f44109f).c(fVar.f44106c).b(fVar.f44110g).e(fVar.f44116m).a(TextUtils.isEmpty(((u) a4).a())).b(a4.X0()).e(fVar.f44114k).a(fVar.f44115l).d(f4).a(), this.f43223o);
        l1.a(this.f43215g, a4, a6);
    }
}
