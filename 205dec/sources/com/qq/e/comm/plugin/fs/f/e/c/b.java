package com.qq.e.comm.plugin.fs.f.e.c;

import com.qq.e.comm.plugin.r0.n;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends a {
    public b(n nVar, com.qq.e.comm.plugin.g0.e eVar) {
        super(nVar);
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.c.a
    public int a() {
        return com.qq.e.comm.plugin.fs.e.d.a();
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.c.a
    protected void c() {
        this.f43391a.setVisibility(8);
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.c.a
    protected void d() {
        if (this.f43391a.getVisibility() != 0) {
            this.f43391a.setVisibility(0);
        }
        this.f43391a.a("", String.valueOf(a() / 1000), "\u79d2\u540e\u53ef\u5173\u95ed");
    }
}
