package com.qq.e.comm.plugin.fs.d.d;

import android.content.Context;
import com.qq.e.comm.plugin.b.g;
import com.qq.e.comm.plugin.b.k;
import com.qq.e.comm.plugin.n0.v;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class c extends a {

    /* renamed from: b  reason: collision with root package name */
    private final k.b f43241b;

    public c(com.qq.e.comm.plugin.g0.e eVar) {
        super(eVar);
        this.f43241b = k.a(k.c.FULL_SCREEN_INTERSTITIAL, eVar);
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public void a(Context context) {
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public boolean a() {
        return com.qq.e.comm.plugin.t.c.a("te_ifsrnsecwvf", this.f43240a.q0(), 0, this.f43240a.p0()) == 1;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public int b() {
        return com.qq.e.comm.plugin.intersitial2.j.c.a(this.f43240a);
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public int c() {
        return com.qq.e.comm.plugin.t.c.a("instpl", this.f43240a.q0(), 0, this.f43240a.p0());
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public String d() {
        return "Interstitial";
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public int e() {
        int l4;
        int a4 = com.qq.e.comm.plugin.t.c.a("fsimidt", this.f43240a.q0(), -1, this.f43240a.p0());
        if (a4 != -1) {
            return a4;
        }
        if (this.f43240a.i0() == null || (l4 = this.f43240a.i0().l()) < 0) {
            return 5;
        }
        return l4;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public long f() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("ifsvmpt", this.f43240a.q0(), 5000);
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public int h() {
        return 4;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public boolean j() {
        return this.f43240a.h1();
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public boolean k() {
        return com.qq.e.comm.plugin.fs.e.d.a() == 0 && com.qq.e.comm.plugin.t.c.a("fsicids", this.f43240a.q0(), 0, this.f43240a.p0()) != 0;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public boolean m() {
        return com.qq.e.comm.plugin.t.c.a("te_ifsrnsdbr", this.f43240a.q0(), 0, this.f43240a.p0()) == 1;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public boolean n() {
        return com.qq.e.comm.plugin.t.c.a("te_ifsnrnsec", this.f43240a.q0(), 0, this.f43240a.p0()) == 1;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public boolean o() {
        return com.qq.e.comm.plugin.t.c.a("te_ifsrnsdaecar", this.f43240a.q0(), 0, this.f43240a.p0()) == 1;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public boolean p() {
        return true;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public void q() {
        if (this.f43240a.o() == g.UNIFIED_INTERSTITIAL_FULLSCREEN) {
            v.a(9120025, com.qq.e.comm.plugin.n0.c.a(this.f43240a), Integer.valueOf(this.f43241b.f42017b));
        }
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public void r() {
        if (this.f43240a.o() == g.UNIFIED_INTERSTITIAL_FULLSCREEN) {
            v.a(9120024, com.qq.e.comm.plugin.n0.c.a(this.f43240a), Integer.valueOf(this.f43241b.f42017b));
        }
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public boolean s() {
        return this.f43240a.l1();
    }
}
