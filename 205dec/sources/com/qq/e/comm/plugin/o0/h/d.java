package com.qq.e.comm.plugin.o0.h;

import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.util.i2;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d implements f.p {

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f45123a;

    /* renamed from: b  reason: collision with root package name */
    private int f45124b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f45125c;

    /* renamed from: d  reason: collision with root package name */
    private int f45126d;

    /* renamed from: e  reason: collision with root package name */
    private int f45127e;

    /* renamed from: f  reason: collision with root package name */
    private int f45128f;

    /* renamed from: g  reason: collision with root package name */
    private int f45129g;

    /* renamed from: h  reason: collision with root package name */
    private int f45130h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f45131i;

    /* renamed from: j  reason: collision with root package name */
    private final StringBuilder f45132j = new StringBuilder();

    /* renamed from: k  reason: collision with root package name */
    private final StringBuilder f45133k = new StringBuilder();

    /* renamed from: l  reason: collision with root package name */
    private final int f45134l = a(false);

    /* renamed from: m  reason: collision with root package name */
    private final int f45135m = a(true);

    public d(com.qq.e.comm.plugin.g0.e eVar, boolean z3) {
        this.f45123a = eVar;
        this.f45131i = z3;
    }

    public void a() {
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.p
    public void a(int i4, int i5) {
        this.f45124b = i4;
        this.f45125c = false;
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.p
    public boolean a(int i4, f.t tVar, float f4) {
        this.f45130h = this.f45124b;
        if (!this.f45125c) {
            this.f45126d++;
            if (this.f45132j.length() < 1) {
                this.f45132j.append(com.qq.e.comm.plugin.d0.a.d().c().n().a());
            }
            if (this.f45133k.length() < 1) {
                this.f45133k.append(f4);
                this.f45133k.append("-");
            }
            if (f4 > 1.0f) {
                this.f45127e++;
            }
            this.f45128f = Math.max(this.f45128f, i4);
            this.f45129g += i4;
        }
        this.f45125c = true;
        int i5 = this.f45124b == 0 ? this.f45134l : this.f45135m;
        if (i5 != -1 && i4 >= i5 * 1000) {
            a();
            return false;
        }
        return true;
    }

    @Override // com.qq.e.comm.plugin.o0.h.f.p
    public void a(int i4) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        int i5 = this.f45126d;
        if (i5 > 0) {
            dVar.a("bts", Integer.valueOf(i5));
            dVar.a("spbt", Integer.valueOf(this.f45127e));
            dVar.a("bmd", Integer.valueOf(this.f45128f));
            dVar.a("btd", Integer.valueOf(this.f45129g));
            dVar.a("lbt", Integer.valueOf(this.f45130h));
            dVar.a("ilv", Integer.valueOf(i4));
            dVar.a("url", i2.b(this.f45123a.L0()));
            dVar.a("nets", this.f45132j);
            dVar.a("rate", this.f45133k);
            dVar.a("mdd", Integer.valueOf(this.f45131i ? 1 : 0));
        }
        dVar.a("pdn", Integer.valueOf(this.f45124b));
        dVar.a("vdn", Integer.valueOf(this.f45123a.M0()));
        com.qq.e.comm.plugin.n0.c a4 = com.qq.e.comm.plugin.n0.c.a(this.f45123a);
        int i6 = this.f45126d;
        if (i6 > 8) {
            i6 = 100;
        }
        v.a(1430000, a4, Integer.valueOf(i6), Integer.valueOf(i4), dVar);
    }

    private int a(boolean z3) {
        int a4 = com.qq.e.comm.plugin.t.c.a(com.qq.e.comm.plugin.d0.d.h.a(z3 ? "evpbdw" : "evpbd", this.f45123a.o()), this.f45123a.q0(), -1, this.f45123a.p0());
        if (a4 == -1) {
            return com.qq.e.comm.plugin.t.c.a(z3 ? "evpbdw" : "evpbd", this.f45123a.q0(), -1, this.f45123a.p0());
        }
        return a4;
    }
}
