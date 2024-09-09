package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class k extends RecyclerView.f {
    boolean ev = true;

    public final void a(RecyclerView.j jVar) {
        ys(jVar);
    }

    public final void bk(RecyclerView.j jVar) {
        fz(jVar);
    }

    public abstract boolean c(RecyclerView.j jVar);

    public abstract boolean c(RecyclerView.j jVar, int i4, int i5, int i6, int i7);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.f
    public boolean c(RecyclerView.j jVar, RecyclerView.f.xv xvVar, RecyclerView.f.xv xvVar2) {
        int i4 = xvVar.f30506c;
        int i5 = xvVar.f30507w;
        View view = jVar.sr;
        int left = xvVar2 == null ? view.getLeft() : xvVar2.f30506c;
        int top2 = xvVar2 == null ? view.getTop() : xvVar2.f30507w;
        if (!jVar.i() && (i4 != left || i5 != top2)) {
            view.layout(left, top2, view.getWidth() + left, view.getHeight() + top2);
            return c(jVar, i4, i5, left, top2);
        }
        return c(jVar);
    }

    public abstract boolean c(RecyclerView.j jVar, RecyclerView.j jVar2, int i4, int i5, int i6, int i7);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.f
    public boolean ev(RecyclerView.j jVar) {
        return !this.ev || jVar.s();
    }

    public void fp(RecyclerView.j jVar) {
    }

    public void fz(RecyclerView.j jVar) {
    }

    public final void gd(RecyclerView.j jVar) {
        fp(jVar);
        f(jVar);
    }

    public void ia(RecyclerView.j jVar) {
    }

    public final void k(RecyclerView.j jVar) {
        s(jVar);
        f(jVar);
    }

    public final void p(RecyclerView.j jVar) {
        u(jVar);
        f(jVar);
    }

    public void s(RecyclerView.j jVar) {
    }

    public void sr(RecyclerView.j jVar, boolean z3) {
    }

    public final void t(RecyclerView.j jVar) {
        ia(jVar);
    }

    public void u(RecyclerView.j jVar) {
    }

    public abstract boolean w(RecyclerView.j jVar);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.f
    public boolean w(RecyclerView.j jVar, RecyclerView.f.xv xvVar, RecyclerView.f.xv xvVar2) {
        int i4;
        int i5;
        return (xvVar == null || ((i4 = xvVar.f30506c) == (i5 = xvVar2.f30506c) && xvVar.f30507w == xvVar2.f30507w)) ? w(jVar) : c(jVar, i4, xvVar.f30507w, i5, xvVar2.f30507w);
    }

    public void xv(RecyclerView.j jVar, boolean z3) {
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.f
    public boolean xv(RecyclerView.j jVar, RecyclerView.f.xv xvVar, RecyclerView.f.xv xvVar2) {
        int i4 = xvVar.f30506c;
        int i5 = xvVar2.f30506c;
        if (i4 == i5 && xvVar.f30507w == xvVar2.f30507w) {
            p(jVar);
            return false;
        }
        return c(jVar, i4, xvVar.f30507w, i5, xvVar2.f30507w);
    }

    public void ys(RecyclerView.j jVar) {
    }

    public final void w(RecyclerView.j jVar, boolean z3) {
        xv(jVar, z3);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.f
    public boolean c(RecyclerView.j jVar, RecyclerView.j jVar2, RecyclerView.f.xv xvVar, RecyclerView.f.xv xvVar2) {
        int i4;
        int i5;
        int i6 = xvVar.f30506c;
        int i7 = xvVar.f30507w;
        if (jVar2.r()) {
            int i8 = xvVar.f30506c;
            i5 = xvVar.f30507w;
            i4 = i8;
        } else {
            i4 = xvVar2.f30506c;
            i5 = xvVar2.f30507w;
        }
        return c(jVar, jVar2, i6, i7, i4, i5);
    }

    public final void c(RecyclerView.j jVar, boolean z3) {
        sr(jVar, z3);
        f(jVar);
    }
}
