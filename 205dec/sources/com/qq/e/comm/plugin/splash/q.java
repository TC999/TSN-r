package com.qq.e.comm.plugin.splash;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.e.comm.plugin.g0.c0;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.splash.s.b;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.u0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class q implements Object<h>, Runnable, b.InterfaceC0895b {

    /* renamed from: l  reason: collision with root package name */
    private static final FrameLayout.LayoutParams f46161l = new FrameLayout.LayoutParams(-1, -1, 17);

    /* renamed from: c  reason: collision with root package name */
    private h f46162c;

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.comm.plugin.splash.r.i f46163d = new com.qq.e.comm.plugin.splash.r.i();

    /* renamed from: e  reason: collision with root package name */
    private com.qq.e.comm.plugin.splash.s.b f46164e;

    /* renamed from: f  reason: collision with root package name */
    private b f46165f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f46166g;

    /* renamed from: h  reason: collision with root package name */
    private p f46167h;

    /* renamed from: i  reason: collision with root package name */
    private int f46168i;

    /* renamed from: j  reason: collision with root package name */
    private String f46169j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f46170k;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        long f46171c;

        /* renamed from: d  reason: collision with root package name */
        com.qq.e.comm.plugin.splash.s.b f46172d;

        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.comm.plugin.splash.s.b bVar = this.f46172d;
            if (bVar != null) {
                bVar.a(this.f46171c);
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private class c implements f.o {

        /* renamed from: a  reason: collision with root package name */
        final long f46173a;

        private c() {
            this.f46173a = System.currentTimeMillis();
        }

        private boolean d() {
            h hVar = q.this.f46162c;
            return q.this.d() || q.this.f46164e == null || q.this.f46164e.b() == null || hVar.f46111w.get() == null || !hVar.f46111w.get().booleanValue();
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void a() {
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void a(int i4, Exception exc) {
            h hVar = q.this.f46162c;
            if (d()) {
                return;
            }
            if (!hVar.f() && q.this.f46167h != null) {
                q.this.f46167h.a(2, q.this.f46168i);
                q.this.f46167h = null;
            }
            q.this.l();
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void b() {
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void c() {
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoComplete() {
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoPause() {
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoReady() {
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoResume() {
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoStart() {
            h hVar = q.this.f46162c;
            q.this.f46167h = new p(hVar, q.this.f46164e == null ? null : q.this.f46164e.b());
            if (q.this.f46170k) {
                q qVar = q.this;
                qVar.a(qVar.f46164e);
            }
            u0.a(hVar.b().P0());
            n.a(hVar, this.f46173a);
        }

        @Override // com.qq.e.comm.plugin.o0.h.f.o
        public void onVideoStop() {
        }
    }

    public void f() {
        h hVar = this.f46162c;
        if (hVar == null || hVar == null || TextUtils.isEmpty(this.f46169j) || TextUtils.equals(this.f46169j, this.f46163d.g()) || !hVar.f46111w.compareAndSet(Boolean.TRUE, null)) {
            return;
        }
        k();
        n.d(hVar.c());
    }

    @Override // com.qq.e.comm.plugin.f0.g.b
    public void h() {
        h hVar = this.f46162c;
        if (hVar == null || hVar.f46111w.get() == null) {
            return;
        }
        this.f46163d.h();
    }

    public void i() {
        com.qq.e.comm.plugin.splash.s.b bVar = this.f46164e;
        com.qq.e.comm.plugin.o0.h.f b4 = bVar == null ? null : bVar.b();
        if (b4 == null || b4.getVideoState() != f.t.PAUSE) {
            return;
        }
        b4.play();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void k() {
        /*
            r7 = this;
            com.qq.e.comm.plugin.splash.h r0 = r7.f46162c
            boolean r1 = r7.d()
            if (r1 == 0) goto L9
            return
        L9:
            com.qq.e.comm.plugin.splash.r.i r1 = r7.f46163d
            java.lang.String r1 = r1.g()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L18
            goto L35
        L18:
            boolean r2 = r0.f()
            if (r2 == 0) goto L37
            com.qq.e.comm.plugin.g0.c0 r2 = r0.b()
            int r2 = r2.D0()
            if (r4 != r2) goto L35
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r1 = r2.exists()
            if (r1 == 0) goto L35
            r1 = 1
            goto L3f
        L35:
            r1 = 0
            goto L3f
        L37:
            com.qq.e.comm.plugin.g0.c0 r1 = r0.b()
            boolean r1 = r1.l1()
        L3f:
            com.qq.e.comm.plugin.splash.h r2 = r7.f46162c
            com.qq.e.comm.plugin.g0.c0 r2 = r2.b()
            if (r2 == 0) goto L5a
            java.lang.String r5 = r2.q0()
            com.qq.e.comm.plugin.g0.b0 r2 = r2.p0()
            java.lang.String r6 = "svrsavs"
            int r2 = com.qq.e.comm.plugin.t.c.a(r6, r5, r3, r2)
            if (r2 != r4) goto L58
            r3 = 1
        L58:
            r7.f46170k = r3
        L5a:
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r0 = r0.f46111w
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2 = 0
            boolean r0 = r0.compareAndSet(r2, r1)
            if (r0 == 0) goto L6a
            com.qq.e.comm.plugin.util.p0.d(r7)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.splash.q.k():void");
    }

    public void l() {
        h hVar = this.f46162c;
        if (d()) {
            return;
        }
        if (hVar.f46111w.compareAndSet(null, Boolean.FALSE) || hVar.f46111w.compareAndSet(Boolean.TRUE, Boolean.FALSE)) {
            p0.d(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Boolean bool;
        h hVar = this.f46162c;
        if (d() || (bool = hVar.f46111w.get()) == null) {
            return;
        }
        ViewGroup viewGroup = hVar.f46107s;
        if (!o.a(viewGroup)) {
            this.f46163d.a(new com.qq.e.comm.plugin.s.a(4004));
            return;
        }
        o.d(hVar.f46091c);
        b();
        if (viewGroup.getChildCount() > 0) {
            viewGroup.removeAllViews();
        }
        com.qq.e.comm.plugin.splash.s.b a4 = com.qq.e.comm.plugin.splash.s.j.a(hVar, this, bool.booleanValue());
        this.f46164e = a4;
        if (bool.booleanValue()) {
            String g4 = this.f46163d.g();
            this.f46169j = g4;
            d1.a("gdt_tag_splash", "show video: %s", g4);
            a4.a(this.f46169j, new c());
            if (!this.f46170k) {
                a(a4);
            }
        } else {
            a4.a(this.f46163d.q());
            a(a4);
        }
        b(a4);
        viewGroup.addView(a4.a(), f46161l);
        o.a(viewGroup, hVar.f46105q, this, hVar.c());
    }

    private void b() {
        if (this.f46164e != null) {
            if (this.f46167h != null && !this.f46162c.f()) {
                this.f46167h.a(0, this.f46168i);
            }
            this.f46164e.a(this.f46166g);
            this.f46164e = null;
        }
    }

    @Override // com.qq.e.comm.plugin.f0.g.b
    public void c() {
        h hVar = this.f46162c;
        if (hVar == null || hVar.f46111w.get() == null) {
            return;
        }
        this.f46163d.c();
    }

    public boolean d() {
        return this.f46162c == null || this.f46163d.f46179c == null;
    }

    public void e() {
        com.qq.e.comm.plugin.splash.s.b bVar = this.f46164e;
        com.qq.e.comm.plugin.o0.h.f b4 = bVar == null ? null : bVar.b();
        if (b4 == null || b4.getVideoState() != f.t.PLAY) {
            return;
        }
        b4.pause();
    }

    public void a(h hVar, com.qq.e.comm.plugin.splash.r.h hVar2) {
        this.f46162c = hVar;
        this.f46163d.f46179c = hVar2;
        this.f46168i = 1;
        this.f46166g = false;
    }

    public void a() {
        b();
        b bVar = this.f46165f;
        if (bVar != null) {
            bVar.f46172d = null;
            this.f46165f = null;
        }
        this.f46163d.f46179c = null;
    }

    private void b(com.qq.e.comm.plugin.splash.s.b bVar) {
        h hVar = this.f46162c;
        if (bVar == null || d() || hVar.f46111w.get() == null) {
            return;
        }
        hVar.f46113y = System.currentTimeMillis();
        hVar.f46112x = bVar.a();
        this.f46163d.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.qq.e.comm.plugin.splash.s.b bVar) {
        h hVar = this.f46162c;
        if (bVar == null || d() || hVar.f46111w.get() == null) {
            return;
        }
        bVar.d();
    }

    @Override // com.qq.e.comm.plugin.splash.s.b.InterfaceC0895b
    public void b(com.qq.e.comm.plugin.splash.r.a aVar) {
        h hVar;
        Boolean bool;
        p pVar;
        if (aVar != null) {
            if ((aVar.f46175a.f44109f == 0 && aVar.f46176b == 0) || (hVar = this.f46162c) == null || (bool = hVar.f46111w.get()) == null) {
                return;
            }
            if (bool.booleanValue() && (pVar = this.f46167h) != null) {
                pVar.a(3, this.f46168i);
            }
            this.f46163d.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j4) {
        if (this.f46165f == null) {
            b bVar = new b();
            this.f46165f = bVar;
            bVar.f46172d = this.f46164e;
        }
        b bVar2 = this.f46165f;
        bVar2.f46171c = j4;
        p0.d(bVar2);
    }

    @Override // com.qq.e.comm.plugin.splash.s.b.InterfaceC0895b
    public void a(int i4, int i5, int i6) {
        c0 b4;
        h hVar = this.f46162c;
        if (hVar == null || (b4 = hVar.b()) == null) {
            return;
        }
        com.qq.e.comm.plugin.splash.r.a aVar = new com.qq.e.comm.plugin.splash.r.a(new com.qq.e.comm.plugin.i.f(b4));
        aVar.f46176b = i5;
        com.qq.e.comm.plugin.i.f fVar = aVar.f46175a;
        fVar.f44109f = i4;
        fVar.f44110g = i6;
        b(aVar);
    }

    public void a(boolean z3, int i4) {
        h hVar = this.f46162c;
        if (hVar == null || hVar.f46111w.get() == null) {
            return;
        }
        if (z3) {
            this.f46163d.n();
        } else {
            this.f46163d.a(new com.qq.e.comm.plugin.s.a(i4));
        }
    }
}
