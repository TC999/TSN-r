package com.qq.e.comm.plugin.fs.f.b;

import android.content.Context;
import android.view.View;
import com.qq.e.comm.plugin.callback.biz.LifecycleCallback;
import com.qq.e.comm.plugin.dl.i;
import com.qq.e.comm.plugin.dl.q;
import com.qq.e.comm.plugin.dl.r;
import com.qq.e.comm.plugin.dl.s;
import com.qq.e.comm.plugin.fs.FSCallback;
import com.qq.e.comm.plugin.g.a;
import com.qq.e.comm.plugin.g0.y;
import com.qq.e.comm.plugin.h.f;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.j0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a implements com.qq.e.comm.plugin.c.b, com.qq.e.comm.plugin.util.w2.b, f {

    /* renamed from: m  reason: collision with root package name */
    private static final String f43288m = "a";

    /* renamed from: d  reason: collision with root package name */
    protected final com.qq.e.comm.plugin.g0.e f43290d;

    /* renamed from: e  reason: collision with root package name */
    protected s f43291e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f43292f;

    /* renamed from: g  reason: collision with root package name */
    protected final FSCallback f43293g;

    /* renamed from: h  reason: collision with root package name */
    private final com.qq.e.comm.plugin.util.w2.c f43294h;

    /* renamed from: j  reason: collision with root package name */
    private final com.qq.e.comm.plugin.fs.d.d.a f43296j;

    /* renamed from: k  reason: collision with root package name */
    private com.qq.e.comm.plugin.g.a f43297k;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.h.e f43289c = new com.qq.e.comm.plugin.h.e();

    /* renamed from: i  reason: collision with root package name */
    protected final j0 f43295i = new j0();

    /* renamed from: l  reason: collision with root package name */
    private boolean f43298l = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.fs.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class C0825a implements a.InterfaceC0834a {
        C0825a() {
        }

        @Override // com.qq.e.comm.plugin.g.a.InterfaceC0834a
        public void a(float f4) {
            a.this.f43292f = f4 > 0.0f;
            a.this.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (a.this.f43297k != null) {
                a.this.f43297k.a(view.getContext());
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (a.this.f43297k != null) {
                a.this.f43297k.b(view.getContext());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c extends com.qq.e.comm.plugin.h.d<Void> {
        c(f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r12) {
            a.this.f43291e.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d extends com.qq.e.comm.plugin.h.d<LifecycleCallback.a> {
        d(f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(LifecycleCallback.a aVar) {
            if (LifecycleCallback.a.DESTROYED == aVar) {
                a.this.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e extends r {
        e(q qVar, com.qq.e.comm.plugin.g0.e eVar) {
            super(qVar, eVar);
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void a(com.qq.e.comm.plugin.i.f fVar, com.qq.e.dl.l.j.c cVar) {
            super.a(fVar, cVar);
            a.this.f43293g.w().b(fVar);
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void c() {
            super.c();
            d1.a(a.f43288m, "volumeChanged");
            a aVar = a.this;
            aVar.f43292f = !aVar.f43292f;
            a.this.l();
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void d(com.qq.e.dl.l.j.c cVar) {
            super.d(cVar);
            d1.a(a.f43288m, "adClose");
            a.this.f43293g.i().a();
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void e(com.qq.e.dl.l.j.c cVar) {
            d1.a(a.f43288m, "onAdLogoClick");
            a.this.f43293g.s().a();
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void f(com.qq.e.dl.l.j.c cVar) {
            d1.a(a.f43288m, "onEndCardClose");
            a.this.f43293g.B().a();
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void g(com.qq.e.dl.l.j.c cVar) {
            super.g(cVar);
            d1.a(a.f43288m, "forceCloseAd");
            a.this.f43293g.B().a();
        }
    }

    public a(Context context, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.fs.d.d.a aVar) {
        this.f43290d = eVar;
        this.f43296j = aVar;
        com.qq.e.comm.plugin.util.w2.c cVar = new com.qq.e.comm.plugin.util.w2.c(eVar);
        this.f43294h = cVar;
        cVar.a(this, true);
        this.f43293g = (FSCallback) com.qq.e.comm.plugin.h.a.b(eVar.l0(), FSCallback.class);
        a(context);
    }

    private void f() {
        this.f43292f = this.f43296j.l();
        j0 j0Var = new j0();
        j0Var.a("volume", this.f43292f ? 1 : 0);
        if (com.qq.e.comm.plugin.fs.e.d.a() > 0) {
            j0Var.a("closeVis", 2);
        } else {
            j0Var.a("closeVis", 0);
        }
        com.qq.e.comm.plugin.dl.d.a(j0Var);
        this.f43291e.a(j0Var.a());
    }

    private void j() {
        View a4 = a();
        if (a4 == null) {
            return;
        }
        this.f43297k = new com.qq.e.comm.plugin.g.a(new C0825a());
        a4.addOnAttachStateChangeListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.f43295i.a("volume", this.f43292f ? 1 : 0);
        this.f43291e.a(this.f43295i.a());
    }

    @Override // com.qq.e.comm.plugin.h.f
    public com.qq.e.comm.plugin.h.e g() {
        return this.f43289c;
    }

    public void h() {
        com.qq.e.comm.plugin.util.w2.c cVar = this.f43294h;
        if (cVar != null) {
            cVar.a();
        }
        s sVar = this.f43291e;
        if (sVar != null) {
            sVar.b();
        }
        this.f43298l = true;
    }

    public s i() {
        return this.f43291e;
    }

    @Override // com.qq.e.comm.plugin.h.f
    public boolean isDestroyed() {
        return this.f43298l;
    }

    protected void k() {
        this.f43291e.a(new e(this.f43291e, this.f43290d));
    }

    protected void m() {
        this.f43293g.r().a(new c(this));
        ((LifecycleCallback) com.qq.e.comm.plugin.h.a.b(this.f43290d.l0(), LifecycleCallback.class)).l().a(new d(this));
    }

    @Override // com.qq.e.comm.plugin.c.b
    public void onReward(int i4) {
        s sVar = this.f43291e;
        if (sVar != null) {
            sVar.a(i4);
        }
    }

    @Override // com.qq.e.comm.plugin.util.w2.b
    public void b(long j4) {
        if (this.f43291e == null) {
            return;
        }
        if (com.qq.e.comm.plugin.fs.e.d.a() <= j4) {
            this.f43295i.a("closeVis", 0);
        }
        this.f43295i.a("vdoTime", j4);
        this.f43291e.a(j4);
        this.f43291e.a(this.f43295i.a());
    }

    @Override // com.qq.e.comm.plugin.util.w2.b
    public long c() {
        return com.qq.e.comm.plugin.fs.e.d.b();
    }

    private void a(Context context) {
        boolean x3 = com.qq.e.comm.plugin.d0.a.d().c().x();
        y i02 = this.f43290d.i0();
        s a4 = i.a().a(context, this.f43290d, i02 != null && x3 == i02.v());
        this.f43291e = a4;
        if (a4 == null) {
            return;
        }
        k();
        m();
        f();
        j();
    }

    @Override // com.qq.e.comm.plugin.c.b
    public View a() {
        s sVar = this.f43291e;
        if (sVar == null) {
            return null;
        }
        return sVar.j();
    }

    @Override // com.qq.e.comm.plugin.util.w2.b
    public void a(long j4) {
        if (this.f43290d.o().g()) {
            return;
        }
        if (this.f43290d.d1()) {
            this.f43293g.j().b(Long.valueOf(j4));
        }
        if (this.f43296j.a()) {
            this.f43293g.B().a();
        } else if (com.qq.e.comm.plugin.t.c.a("fsrieas", this.f43290d.q0(), 0, this.f43290d.p0()) == 1) {
            if (this.f43291e.o()) {
                this.f43291e.r();
            } else {
                this.f43293g.o().a();
            }
        }
    }
}
