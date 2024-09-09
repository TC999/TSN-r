package com.qq.e.comm.plugin.e.i;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c implements d {

    /* renamed from: a  reason: collision with root package name */
    private final int f42743a;

    /* renamed from: b  reason: collision with root package name */
    private final d f42744b;

    /* renamed from: c  reason: collision with root package name */
    private com.qq.e.comm.plugin.e.k.b f42745c;

    public c(String str, d dVar) {
        this.f42744b = dVar;
        this.f42743a = com.qq.e.comm.plugin.d0.a.d().f().a("skasss", str, 0);
        b();
    }

    private void b() {
        this.f42745c = new com.qq.e.comm.plugin.e.k.a();
    }

    @Override // com.qq.e.comm.plugin.e.i.d
    public com.qq.e.comm.plugin.e.c a() {
        com.qq.e.comm.plugin.e.c a4 = this.f42744b.a();
        int i4 = this.f42743a;
        if (i4 <= 0) {
            i4 = -999;
        }
        a4.L0 = String.valueOf(i4);
        a4.M0 = this.f42745c.a();
        return a4;
    }
}
