package com.qq.e.comm.plugin.u.k;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.plugin.dl.r;
import com.qq.e.comm.plugin.dl.s;
import com.qq.e.comm.plugin.g0.q;
import com.qq.e.comm.plugin.i.f;
import com.qq.e.comm.plugin.u.g;
import com.qq.e.comm.plugin.u.h;
import com.qq.e.comm.plugin.u.k.b;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.j0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d implements h {

    /* renamed from: a  reason: collision with root package name */
    private final VideoOption f46323a;

    /* renamed from: b  reason: collision with root package name */
    private g f46324b;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.u.k.b f46325c;

    /* renamed from: d  reason: collision with root package name */
    private final q f46326d;

    /* renamed from: e  reason: collision with root package name */
    private com.qq.e.comm.plugin.u.k.e f46327e;

    /* renamed from: f  reason: collision with root package name */
    private s f46328f;

    /* renamed from: g  reason: collision with root package name */
    private int f46329g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f46330h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f46331i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements com.qq.e.comm.plugin.u.k.a {
        b() {
        }

        @Override // com.qq.e.comm.plugin.u.k.a
        public void a() {
            if (com.qq.e.comm.plugin.d0.a.d().f().a("ntvbc", d.this.f46326d.q0(), 1) == 1) {
                d.this.j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements b.InterfaceC0902b {
        c() {
        }

        @Override // com.qq.e.comm.plugin.u.k.b.InterfaceC0902b
        public void dispatchTouchEvent(MotionEvent motionEvent) {
            com.qq.e.comm.plugin.e.i.a d4 = com.qq.e.comm.plugin.e.a.a().d(d.this.f46325c);
            if (d4 != null) {
                d4.a(motionEvent, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.u.k.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class C0903d implements b.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f46335a;

        C0903d(s sVar) {
            this.f46335a = sVar;
        }

        @Override // com.qq.e.comm.plugin.u.k.b.c
        public void a(boolean z3) {
            d1.a("NativeTemplateViewController", "visibility changed " + z3);
            if (!d.this.f46330h && z3) {
                d1.a("NativeTemplateViewController", "first exposure");
                d.this.f46330h = true;
            }
            if (!z3 || d.this.f46324b == null) {
                return;
            }
            d.this.f46324b.c();
        }

        @Override // com.qq.e.comm.plugin.u.k.b.c
        public void b(boolean z3) {
            if (d.this.f46327e != null) {
                d.this.f46327e.c(z3);
            }
            this.f46335a.a(new j0().a("vVis", z3).a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e extends r {
        public e(com.qq.e.comm.plugin.dl.q qVar, com.qq.e.comm.plugin.g0.e eVar) {
            super(qVar, eVar);
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void a(f fVar, com.qq.e.dl.l.j.c cVar) {
            super.a(fVar, cVar);
            d.this.a(fVar, cVar);
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void d(com.qq.e.dl.l.j.c cVar) {
            if (d.this.f46328f.o()) {
                if (d.this.f46327e != null) {
                    d.this.f46327e.d(true);
                }
                d.this.k();
            } else if (d.this.f46324b != null) {
                d.this.f46324b.a(true);
            }
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void e(com.qq.e.dl.l.j.c cVar) {
            if (d.this.f46324b != null) {
                d.this.f46324b.b();
            }
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void f(com.qq.e.dl.l.j.c cVar) {
            if (d.this.f46324b != null) {
                d.this.f46324b.a();
            }
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void k(com.qq.e.dl.l.j.c cVar) {
            if (d.this.f46327e != null) {
                d.this.f46327e.a();
            }
            if (d.this.f46328f != null) {
                d.this.f46328f.p();
            }
        }
    }

    public d(Context context, com.qq.e.comm.plugin.u.k.b bVar, q qVar, VideoOption videoOption, com.qq.e.comm.plugin.n0.c cVar) {
        this.f46325c = bVar;
        this.f46326d = qVar;
        this.f46323a = videoOption;
    }

    private int i() {
        if (this.f46329g == 0) {
            this.f46329g = com.qq.e.comm.plugin.d0.a.d().f().a("ihsppcid", 10024);
        }
        return this.f46329g;
    }

    @Override // com.qq.e.comm.plugin.u.h
    public int g() {
        com.qq.e.comm.plugin.u.k.e eVar = this.f46327e;
        if (eVar == null) {
            return 2;
        }
        return eVar.i();
    }

    @Override // com.qq.e.comm.plugin.u.h
    public int getCurrentPosition() {
        com.qq.e.comm.plugin.u.k.e eVar = this.f46327e;
        if (eVar == null) {
            return 0;
        }
        return eVar.e();
    }

    @Override // com.qq.e.comm.plugin.u.h
    public int getDuration() {
        com.qq.e.comm.plugin.u.k.e eVar = this.f46327e;
        if (eVar == null) {
            return 0;
        }
        return eVar.f();
    }

    public void h() {
        s sVar = this.f46328f;
        if (sVar != null) {
            sVar.b();
        }
        com.qq.e.comm.plugin.u.k.e eVar = this.f46327e;
        if (eVar != null) {
            eVar.c();
        }
        com.qq.e.comm.plugin.e.a.a().b(this.f46325c);
    }

    public void j() {
        com.qq.e.comm.plugin.e.a a4 = com.qq.e.comm.plugin.e.a.a();
        com.qq.e.comm.plugin.e.i.a d4 = a4.d(this.f46325c);
        if (d4 != null) {
            d4.d(0);
            d4.a(-999);
            d4.b(i());
        }
        f fVar = new f(this.f46326d);
        fVar.f44106c = i();
        fVar.f44105b = a4.a(this.f46325c);
        g gVar = this.f46324b;
        if (gVar != null) {
            gVar.a(fVar);
        }
    }

    public void k() {
        s sVar = this.f46328f;
        if (sVar != null) {
            sVar.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements g {
        a() {
        }

        @Override // com.qq.e.comm.plugin.u.g
        public void a(f fVar) {
            if (d.this.f46324b != null) {
                d.this.f46324b.a(fVar);
            }
        }

        @Override // com.qq.e.comm.plugin.u.g
        public void b() {
            if (d.this.f46324b != null) {
                d.this.f46324b.b();
            }
        }

        @Override // com.qq.e.comm.plugin.u.g
        public void c() {
            if (d.this.f46324b != null) {
                d.this.f46324b.c();
            }
        }

        @Override // com.qq.e.comm.plugin.u.g
        public void a(String str) {
            if (d.this.f46324b != null) {
                d.this.f46324b.a(str);
            }
        }

        @Override // com.qq.e.comm.plugin.u.g
        public void a(int i4, int... iArr) {
            if (d.this.f46324b != null) {
                d.this.f46324b.a(i4, iArr);
            } else if (i4 == 1001) {
                d.this.f46331i = true;
            }
        }

        @Override // com.qq.e.comm.plugin.u.g
        public void a(boolean z3) {
            if (d.this.f46324b != null) {
                d.this.f46324b.a(z3);
            }
        }

        @Override // com.qq.e.comm.plugin.u.g
        public void a() {
            if (d.this.f46324b != null) {
                d.this.f46324b.a();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.u.h
    public void c() {
        com.qq.e.comm.plugin.u.k.e eVar = this.f46327e;
        if (eVar != null) {
            eVar.n();
        }
    }

    @Override // com.qq.e.comm.plugin.u.h
    public int d() {
        com.qq.e.comm.plugin.u.k.e eVar = this.f46327e;
        if (eVar == null) {
            return 0;
        }
        return eVar.g();
    }

    @Override // com.qq.e.comm.plugin.u.h
    public int e() {
        com.qq.e.comm.plugin.u.k.e eVar = this.f46327e;
        if (eVar == null) {
            return 0;
        }
        return eVar.j();
    }

    @Override // com.qq.e.comm.plugin.u.h
    public int f() {
        com.qq.e.comm.plugin.u.k.e eVar = this.f46327e;
        if (eVar == null) {
            return 0;
        }
        return eVar.h();
    }

    @Override // com.qq.e.comm.plugin.u.h
    public com.qq.e.comm.plugin.o0.h.f b() {
        com.qq.e.comm.plugin.u.k.e eVar = this.f46327e;
        if (eVar != null) {
            return eVar.k();
        }
        return null;
    }

    public void a(s sVar, com.qq.e.comm.plugin.o0.h.f fVar, com.qq.e.comm.plugin.gdtnativead.p.a aVar, FrameLayout frameLayout, com.qq.e.comm.plugin.gdtnativead.p.b.g gVar, com.qq.e.comm.plugin.r0.a aVar2, boolean z3) {
        if (fVar != null && aVar != null) {
            com.qq.e.comm.plugin.u.k.e eVar = new com.qq.e.comm.plugin.u.k.e(sVar, fVar, aVar, frameLayout, gVar, aVar2, this.f46323a, this.f46326d, z3, new a());
            this.f46327e = eVar;
            eVar.a(new b());
        }
        a(sVar);
        sVar.a(new e(sVar, this.f46326d));
        this.f46326d.c(3);
        com.qq.e.comm.plugin.e.a.a().a(this.f46325c, this.f46326d);
    }

    public void b(s sVar) {
        this.f46328f = sVar;
    }

    private void a(s sVar) {
        this.f46325c.a(new c());
        this.f46325c.a(new C0903d(sVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, com.qq.e.dl.l.j.c cVar) {
        s sVar;
        com.qq.e.comm.plugin.e.a a4 = com.qq.e.comm.plugin.e.a.a();
        com.qq.e.comm.plugin.e.i.a d4 = a4.d(this.f46325c);
        if (d4 != null) {
            int i4 = fVar.f44110g;
            if (2 == i4) {
                d4.a(fVar.f44111h);
            } else if (5 == i4) {
                d4.a(fVar.f44112i, fVar.f44113j);
            }
            d4.b(fVar.f44106c);
            d4.d(fVar.f44110g);
            d4.a(fVar.f44109f);
            d4.a(fVar.b());
            d4.a(fVar.f44117n);
            d4.a(fVar.f44118o);
            d4.b(fVar.f44119p);
        }
        fVar.f44105b = a4.a(this.f46325c);
        g gVar = this.f46324b;
        if (gVar != null) {
            gVar.a(fVar);
        }
        if (!this.f46326d.o().e() || (sVar = this.f46328f) == null || sVar.j() == null) {
            return;
        }
        com.qq.e.comm.plugin.util.q.a((View) this.f46328f.j().getParent());
    }

    @Override // com.qq.e.comm.plugin.u.h
    public void a(g gVar) {
        g gVar2;
        this.f46324b = gVar;
        if (this.f46330h && gVar != null) {
            gVar.c();
        }
        if (!this.f46331i || (gVar2 = this.f46324b) == null) {
            return;
        }
        gVar2.a(1001, new int[0]);
        this.f46331i = false;
    }

    @Override // com.qq.e.comm.plugin.u.h
    public void a(long j4, long j5, int i4) {
        com.qq.e.comm.plugin.u.k.e eVar = this.f46327e;
        if (eVar != null) {
            eVar.a(j4, j5, i4);
        }
    }

    @Override // com.qq.e.comm.plugin.u.h
    public void a(String str) {
        com.qq.e.comm.plugin.u.k.e eVar = this.f46327e;
        if (eVar != null) {
            eVar.a(str);
        }
    }

    @Override // com.qq.e.comm.plugin.u.h
    public View a() {
        return this.f46325c;
    }
}
