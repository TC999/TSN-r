package com.qq.e.comm.plugin.splash.s;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.plugin.dl.h0;
import com.qq.e.comm.plugin.dl.q;
import com.qq.e.comm.plugin.dl.r;
import com.qq.e.comm.plugin.dl.s;
import com.qq.e.comm.plugin.f0.g;
import com.qq.e.comm.plugin.g0.c0;
import com.qq.e.comm.plugin.g0.y;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.splash.s.b;
import com.qq.e.comm.plugin.util.j0;
import com.qq.e.comm.plugin.util.t;
import java.io.File;
import java.util.Locale;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i implements b, g.b {

    /* renamed from: l  reason: collision with root package name */
    private static final boolean f46225l;

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.splash.h f46226c;

    /* renamed from: d  reason: collision with root package name */
    private final b.a f46227d;

    /* renamed from: e  reason: collision with root package name */
    private final b.InterfaceC0895b f46228e;

    /* renamed from: f  reason: collision with root package name */
    private final s f46229f;

    /* renamed from: g  reason: collision with root package name */
    private com.qq.e.comm.plugin.o0.h.f f46230g;

    /* renamed from: h  reason: collision with root package name */
    private final j0 f46231h = new j0();

    /* renamed from: i  reason: collision with root package name */
    private long f46232i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f46233j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f46234k;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a extends r {
        a(q qVar, com.qq.e.comm.plugin.g0.e eVar, g.b bVar) {
            super(qVar, eVar, bVar);
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void a(com.qq.e.comm.plugin.i.f fVar, com.qq.e.dl.l.j.c cVar) {
            super.a(fVar, cVar);
            i.this.f46228e.b(new com.qq.e.comm.plugin.splash.r.a(fVar));
        }

        @Override // com.qq.e.comm.plugin.dl.r
        public void d(com.qq.e.dl.l.j.c cVar) {
            i.this.f46228e.a(0, 2, 0);
        }
    }

    static {
        f46225l = com.qq.e.comm.plugin.d0.a.d().f().a("sscdtoe", 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(com.qq.e.comm.plugin.splash.h hVar, b.InterfaceC0895b interfaceC0895b, boolean z3) {
        this.f46226c = hVar;
        this.f46228e = interfaceC0895b;
        this.f46227d = new b.a(hVar);
        c0 b4 = hVar.b();
        boolean x3 = com.qq.e.comm.plugin.d0.a.d().c().x();
        y i02 = b4 != null ? b4.i0() : null;
        boolean z4 = true;
        this.f46229f = com.qq.e.comm.plugin.dl.i.a().a(hVar.f46089a, b4, (z3 || !(i02 != null && x3 == i02.v())) ? false : false, z3);
    }

    @Override // com.qq.e.comm.plugin.splash.s.b
    public com.qq.e.comm.plugin.o0.h.f b() {
        return this.f46230g;
    }

    @Override // com.qq.e.comm.plugin.f0.g.b
    public void c() {
        this.f46228e.c();
    }

    @Override // com.qq.e.comm.plugin.splash.s.b
    public void d() {
        c0 b4 = this.f46226c.b();
        if (b4 == null || this.f46229f == null) {
            return;
        }
        if (this.f46230g != null) {
            this.f46227d.setAlpha(1.0f);
        }
        this.f46229f.a(new a(this.f46229f, b4, this));
    }

    @Override // com.qq.e.comm.plugin.f0.g.b
    public void h() {
        this.f46228e.h();
    }

    @Override // com.qq.e.comm.plugin.splash.s.b
    public ViewGroup a() {
        if (this.f46229f == null) {
            return null;
        }
        return this.f46227d;
    }

    @Override // com.qq.e.comm.plugin.splash.s.b
    public void a(File file) {
        s sVar = this.f46229f;
        if (sVar == null) {
            return;
        }
        View j4 = sVar.j();
        c0 b4 = this.f46226c.b();
        j0 j0Var = new j0();
        j0Var.a("imgObj", b4.X());
        a(j0Var, j4, b4);
    }

    @Override // com.qq.e.comm.plugin.splash.s.b
    public void a(String str, f.o oVar) {
        s sVar = this.f46229f;
        if (sVar == null) {
            return;
        }
        sVar.a((h0.c) null);
        com.qq.e.comm.plugin.o0.h.f i4 = this.f46229f.i();
        this.f46230g = i4;
        if (i4 == null) {
            return;
        }
        this.f46227d.f46188d = i4;
        c0 b4 = this.f46226c.b();
        if (!h0.f42444z) {
            this.f46230g.a(new com.qq.e.comm.plugin.o0.h.d(b4, false));
        }
        h0.b e4 = this.f46229f.e();
        if (e4 != null && !e4.c()) {
            if (b4.Y0()) {
                this.f46230g.a(f.r.f45183d);
            } else if (b4.N0() > b4.R0()) {
                this.f46230g.a(f.r.f45184e);
            }
        }
        j0 j0Var = new j0();
        j0Var.a("callback", oVar);
        j0Var.a("videoRes", str);
        this.f46227d.setAlpha(0.0f);
        a(j0Var, this.f46229f.j(), b4);
    }

    private void a(j0 j0Var, View view, c0 c0Var) {
        Bitmap a4;
        long d4 = this.f46226c.d();
        this.f46232i = d4;
        this.f46233j = d4 > 5000 && f46225l;
        com.qq.e.comm.plugin.splash.h hVar = this.f46226c;
        if (hVar.f46105q && ((a4 = t.a(hVar.f46089a, hVar.f46101m)) != null || (a4 = t.a(this.f46226c.f46102n)) != null)) {
            j0Var.a("devLogo", a4);
        }
        com.qq.e.comm.plugin.dl.d.a(j0Var);
        a(j0Var, this.f46232i);
        this.f46227d.addView(view, b.f46186b);
    }

    @Override // com.qq.e.comm.plugin.splash.s.b
    public void a(long j4) {
        int n4;
        s sVar = this.f46229f;
        if (sVar != null) {
            if (sVar.o() && (n4 = this.f46229f.n()) > 0) {
                if (!this.f46234k && j4 <= n4) {
                    this.f46234k = true;
                    this.f46229f.r();
                }
                long j5 = n4;
                if (j4 > j5) {
                    j4 -= j5;
                }
            }
            a(this.f46231h, j4);
        }
    }

    private void a(j0 j0Var, long j4) {
        long max = Math.max(j4 - 1, 0L);
        float f4 = ((float) max) / 1000.0f;
        if (this.f46233j) {
            f4 = (float) Math.floor(f4);
        }
        j0Var.a("timeLeft", String.format(Locale.getDefault(), "%d", Integer.valueOf(Math.round(f4))));
        this.f46229f.a(this.f46232i - max);
        this.f46229f.a(j0Var.a());
    }

    @Override // com.qq.e.comm.plugin.splash.s.b
    public void a(boolean z3) {
        s sVar = this.f46229f;
        if (sVar != null) {
            sVar.b();
        }
        com.qq.e.comm.plugin.o0.h.f fVar = this.f46230g;
        if (fVar != null) {
            if (!z3) {
                fVar.pause();
                this.f46230g.a((f.o) null);
                this.f46230g.i();
            }
            this.f46230g = null;
        }
        this.f46227d.a();
    }
}
