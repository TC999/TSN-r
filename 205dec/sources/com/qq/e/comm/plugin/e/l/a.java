package com.qq.e.comm.plugin.e.l;

import com.qq.e.comm.plugin.n0.v;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private final c f42764a = new com.qq.e.comm.plugin.e.d();

    protected abstract com.qq.e.comm.plugin.e.c a();

    @Override // com.qq.e.comm.plugin.e.l.d
    public String a(int i4) {
        com.qq.e.comm.plugin.e.c a4 = a(b(i4), a());
        String a5 = a(a4, i4);
        if (i4 == 2 && a4 != null && "1".equals(a4.f42707z)) {
            com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
            dVar.a("msg", a5);
            v.a(9300004, null, 0, dVar);
        }
        return a5;
    }

    protected abstract com.qq.e.comm.plugin.e.c b(int i4);

    private com.qq.e.comm.plugin.e.c a(com.qq.e.comm.plugin.e.c cVar, com.qq.e.comm.plugin.e.c cVar2) {
        c cVar3 = this.f42764a;
        if (cVar3 != null) {
            return cVar3.a(cVar, cVar2, String.valueOf(-999));
        }
        return null;
    }

    private String a(com.qq.e.comm.plugin.e.c cVar, int i4) {
        c cVar2 = this.f42764a;
        return (cVar2 == null || cVar == null) ? "" : cVar2.a(cVar, i4);
    }
}
