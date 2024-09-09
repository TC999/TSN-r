package com.qq.e.comm.plugin.gdtnativead.p.b;

import com.qq.e.comm.plugin.g0.t;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.b0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f43953a;

    /* renamed from: b  reason: collision with root package name */
    private final com.qq.e.comm.plugin.n0.c f43954b;

    /* renamed from: c  reason: collision with root package name */
    private long f43955c;

    public a(com.qq.e.comm.plugin.g0.e eVar) {
        this.f43953a = eVar;
        this.f43954b = com.qq.e.comm.plugin.n0.c.a(eVar);
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.d
    public void a(int i4) {
        b0.b(this.f43954b, 0, i4, new com.qq.e.comm.plugin.n0.d().a("url", e()));
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.d
    public com.qq.e.comm.plugin.g0.e d() {
        return this.f43953a;
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.d
    public String e() {
        com.qq.e.comm.plugin.g0.e eVar = this.f43953a;
        return eVar instanceof t ? ((t) eVar).e() : "";
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.d
    public void f() {
        b0.b(this.f43954b, 0);
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.d
    public void g() {
        b0.a(this.f43954b, 0);
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.d
    public void h() {
        b0.d(this.f43954b, 0);
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(2020030);
        hVar.b(System.currentTimeMillis() - this.f43955c);
        hVar.a(this.f43954b);
        v.a(hVar);
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.d
    public void i() {
        b0.e(this.f43954b, 0);
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.d
    public void j() {
        b0.f(this.f43954b, 0);
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.d
    public void k() {
        this.f43955c = System.currentTimeMillis();
        b0.c(this.f43954b, 0);
    }

    @Override // com.qq.e.comm.plugin.gdtnativead.p.b.d
    public void a(String str) {
        b0.a(this.f43954b, 0, 0, new com.qq.e.comm.plugin.n0.d().a("url", str));
    }
}
