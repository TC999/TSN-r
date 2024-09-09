package com.qq.e.comm.plugin.fs.f.b;

import android.content.Context;
import com.qq.e.comm.plugin.callback.biz.LifecycleCallback;
import com.qq.e.comm.plugin.dl.q;
import com.qq.e.comm.plugin.dl.r;
import com.qq.e.comm.plugin.h.f;
import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends com.qq.e.comm.plugin.fs.f.b.a {

    /* renamed from: p  reason: collision with root package name */
    private static final String f43304p = "b";

    /* renamed from: n  reason: collision with root package name */
    private boolean f43305n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f43306o;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a extends com.qq.e.comm.plugin.h.d<Void> {
        a(f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r22) {
            d1.a(b.f43304p, "onNovelLastPageClick");
            b.this.f43291e.r();
            b.this.f43305n = true;
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.fs.f.b.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class C0826b extends com.qq.e.comm.plugin.h.d<Float> {
        C0826b(f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Float f4) {
            b.this.f43295i.a("novelPageCardVis", f4.floatValue() > 0.0f ? 0 : 2);
            b.this.f43295i.a("novelPageCardY", com.qq.e.dl.j.f.b(f4.doubleValue()));
            b bVar = b.this;
            bVar.f43291e.a(bVar.f43295i.a());
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c extends com.qq.e.comm.plugin.h.d<Void> {
        c(f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(Void r22) {
            b.this.f43291e.r();
            b.this.f43305n = true;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class d extends com.qq.e.comm.plugin.h.d<LifecycleCallback.a> {
        d(f fVar) {
            super(fVar);
        }

        @Override // com.qq.e.comm.plugin.h.d
        /* renamed from: a */
        public void b(LifecycleCallback.a aVar) {
            if (LifecycleCallback.a.DESTROYED == aVar) {
                b.this.h();
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class e extends r {
        e(q qVar, com.qq.e.comm.plugin.g0.e eVar) {
            super(qVar, eVar);
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void a(com.qq.e.comm.plugin.i.f fVar, com.qq.e.dl.l.j.c cVar) {
            super.a(fVar, cVar);
            b.this.f43293g.w().b(fVar);
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void d(com.qq.e.dl.l.j.c cVar) {
            super.d(cVar);
            d1.a(b.f43304p, "adClose");
            if (b.this.f43305n && b.this.f43306o) {
                b.this.f43293g.B().a();
            } else {
                b.this.f43293g.i().a();
            }
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void e(com.qq.e.dl.l.j.c cVar) {
            d1.a(b.f43304p, "onAdLogoClick");
            b.this.f43293g.s().a();
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void f(com.qq.e.dl.l.j.c cVar) {
            d1.a(b.f43304p, "onEndCardClose");
            b.this.f43293g.B().a();
        }
    }

    public b(Context context, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.fs.d.d.a aVar) {
        super(context, eVar, aVar);
        this.f43305n = false;
        this.f43306o = false;
    }

    private void o() {
        com.qq.e.comm.plugin.fs.e.c.a().a(this.f43290d.K0(), 10012);
    }

    @Override // com.qq.e.comm.plugin.fs.f.b.a
    protected void k() {
        this.f43291e.a(new e(this.f43291e, this.f43290d));
    }

    @Override // com.qq.e.comm.plugin.fs.f.b.a
    protected void m() {
        this.f43293g.H().a(new a(this));
        this.f43293g.e().a(new C0826b(this));
        this.f43293g.r().a(new c(this));
        ((LifecycleCallback) com.qq.e.comm.plugin.h.a.b(this.f43290d.l0(), LifecycleCallback.class)).l().a(new d(this));
    }

    @Override // com.qq.e.comm.plugin.fs.f.b.a, com.qq.e.comm.plugin.util.w2.b
    public void a(long j4) {
        if (this.f43290d.d1()) {
            this.f43306o = true;
            this.f43293g.j().b(Long.valueOf(j4));
            o();
        }
    }
}
