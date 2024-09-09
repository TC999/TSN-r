package com.qq.e.comm.plugin.e0.d.j;

import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b<T> extends a<T> {
    private boolean E;

    public b(com.qq.e.comm.plugin.e0.e.a aVar, d<T> dVar) {
        super(aVar, dVar);
    }

    private void g() {
        if (this.E && this.f42879w && this.f42880x) {
            b();
        }
    }

    @Override // com.qq.e.comm.plugin.e0.d.j.a
    public void a() {
        super.a();
        d1.a("MSDK ParallelLoadStrategy execute", new Object[0]);
        this.f42871o.e();
        this.f42869m.e();
        this.f42870n.f();
    }

    protected void f() {
        if (this.f42879w) {
            com.qq.e.comm.plugin.e0.e.d dVar = this.f42874r;
            int f4 = dVar != null ? dVar.f() : -1;
            this.B = f4;
            if (f4 > this.C) {
                this.f42870n.a(f4, false);
            }
        }
        if (this.f42880x) {
            com.qq.e.comm.plugin.e0.e.d dVar2 = this.f42878v;
            int f5 = dVar2 != null ? dVar2.f() : -1;
            this.C = f5;
            if (f5 > this.B) {
                this.f42870n.a(f5, false);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.e0.d.h.c
    public void a(com.qq.e.comm.plugin.e0.d.h.a<T> aVar, T t3, com.qq.e.comm.plugin.e0.e.d dVar) {
        d1.a("MSDK ParallelLoadStrategy onFinish loader: " + aVar + ", adapter: " + t3 + ", networkConfig: " + dVar, new Object[0]);
        if (aVar == this.f42869m) {
            this.f42873q = t3;
            this.f42874r = dVar;
            this.f42879w = true;
            f();
        } else if (aVar == this.f42870n) {
            this.f42875s = t3;
            this.f42876t = dVar;
            this.E = true;
        } else if (aVar == this.f42871o) {
            this.f42877u = t3;
            this.f42878v = dVar;
            this.f42880x = true;
            f();
        }
        g();
    }
}
