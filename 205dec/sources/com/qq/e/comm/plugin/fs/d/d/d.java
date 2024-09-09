package com.qq.e.comm.plugin.fs.d.d;

import android.content.Context;
import com.qq.e.comm.plugin.g0.f0;
import com.qq.e.comm.plugin.rewardvideo.q;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class d extends a {
    public d(com.qq.e.comm.plugin.g0.e eVar) {
        super(eVar);
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public void a(Context context) {
        com.qq.e.comm.plugin.g0.e eVar = this.f43240a;
        if (eVar instanceof f0) {
            q.a(context, (f0) eVar);
        }
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public int b() {
        com.qq.e.comm.plugin.g0.e eVar = this.f43240a;
        if (eVar instanceof f0) {
            return ((f0) eVar).p1();
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public int c() {
        return com.qq.e.comm.plugin.t.c.a("restpl", this.f43240a.q0(), 0, this.f43240a.p0());
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public String d() {
        return "Reward";
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public int e() {
        int l4;
        int a4 = com.qq.e.comm.plugin.t.c.a("fsrmidt", this.f43240a.q0(), -1, this.f43240a.p0());
        if (a4 != -1) {
            return a4;
        }
        if (this.f43240a.i0() == null || (l4 = this.f43240a.i0().l()) < 0) {
            return 4;
        }
        return l4;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public long f() {
        return Long.MAX_VALUE;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public int h() {
        return this.f43240a.l1() ? 1 : 2;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public boolean j() {
        return true;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public boolean k() {
        return com.qq.e.comm.plugin.fs.e.d.a() == 0 && com.qq.e.comm.plugin.t.c.a("fsrcids", this.f43240a.q0(), 0, this.f43240a.p0()) != 0;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public boolean m() {
        return com.qq.e.comm.plugin.t.c.a("te_rvnsdbr", this.f43240a.q0(), 0, this.f43240a.p0()) == 1;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public boolean n() {
        return true;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public boolean o() {
        return com.qq.e.comm.plugin.t.c.a("te_rvnsdaecar", this.f43240a.q0(), 0, this.f43240a.p0()) == 1;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public boolean p() {
        return false;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public void q() {
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public void r() {
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public boolean s() {
        return true;
    }

    @Override // com.qq.e.comm.plugin.fs.d.d.a
    public boolean a() {
        return com.qq.e.comm.plugin.t.c.a("te_rvnsecwvf", this.f43240a.q0(), 0, this.f43240a.p0()) == 1;
    }
}
