package com.qq.e.comm.plugin.e0.d.j;

import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c<T> extends a<T> {
    public c(com.qq.e.comm.plugin.e0.e.a aVar, d<T> dVar) {
        super(aVar, dVar);
    }

    @Override // com.qq.e.comm.plugin.e0.d.j.a
    public void a() {
        super.a();
        d1.a("MSDK SerialLoadStrategy execute", new Object[0]);
        this.f42871o.e();
        this.f42869m.e();
    }

    protected void f() {
        com.qq.e.comm.plugin.e0.e.d dVar = this.f42874r;
        this.B = dVar != null ? dVar.f() : -1;
        com.qq.e.comm.plugin.e0.e.d dVar2 = this.f42878v;
        int f4 = dVar2 != null ? dVar2.f() : -1;
        this.C = f4;
        if (this.f42879w && this.f42880x) {
            this.f42870n.a(Math.max(f4, this.B), true);
            this.f42870n.f();
        }
    }

    @Override // com.qq.e.comm.plugin.e0.d.h.c
    public void a(com.qq.e.comm.plugin.e0.d.h.a<T> aVar, T t3, com.qq.e.comm.plugin.e0.e.d dVar) {
        d1.a("MSDK SerialLoadStrategy onFinish loader: " + aVar + ", adapter: " + t3 + ", networkConfig: " + dVar, new Object[0]);
        if (aVar == this.f42869m) {
            this.f42873q = t3;
            this.f42874r = dVar;
            this.f42879w = true;
            f();
        } else if (aVar == this.f42871o) {
            this.f42877u = t3;
            this.f42878v = dVar;
            this.f42880x = true;
            f();
        } else if (aVar == this.f42870n) {
            this.f42875s = t3;
            this.f42876t = dVar;
            b();
        }
    }
}
