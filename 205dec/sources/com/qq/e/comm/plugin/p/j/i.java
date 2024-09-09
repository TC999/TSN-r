package com.qq.e.comm.plugin.p.j;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class i implements c {

    /* renamed from: a  reason: collision with root package name */
    private final long f45258a;

    /* renamed from: b  reason: collision with root package name */
    private volatile long f45259b;

    /* renamed from: c  reason: collision with root package name */
    private com.qq.e.comm.plugin.p.g f45260c;

    public i(long j4, long j5) {
        this.f45258a = j4;
        this.f45259b = j5;
    }

    @Override // com.qq.e.comm.plugin.p.j.c
    public void a(long j4) {
        this.f45259b = j4;
        com.qq.e.comm.plugin.p.g gVar = this.f45260c;
        if (gVar != null) {
            gVar.a(a(), b());
        }
    }

    public long b() {
        return this.f45258a;
    }

    @Override // com.qq.e.comm.plugin.p.j.d
    public void a(com.qq.e.comm.plugin.p.g gVar) {
        this.f45260c = gVar;
    }

    @Override // com.qq.e.comm.plugin.p.j.d
    public long a() {
        return this.f45259b;
    }
}
