package com.bytedance.sdk.component.adexpress.w;

import com.bytedance.sdk.component.adexpress.w.p;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a implements p.c {

    /* renamed from: c  reason: collision with root package name */
    ys f29414c;
    private AtomicBoolean sr = new AtomicBoolean(false);

    /* renamed from: w  reason: collision with root package name */
    private List<p> f29415w;
    private gd xv;

    public a(List<p> list, gd gdVar) {
        this.f29415w = list;
        this.xv = gdVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.w.p.c
    public void c() {
        this.xv.k();
        Iterator<p> it = this.f29415w.iterator();
        while (it.hasNext() && !it.next().c(this)) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.w.p.c
    public boolean w(p pVar) {
        int indexOf = this.f29415w.indexOf(pVar);
        return indexOf < this.f29415w.size() - 1 && indexOf >= 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.w.p.c
    public boolean xv() {
        return this.sr.get();
    }

    @Override // com.bytedance.sdk.component.adexpress.w.p.c
    public ys w() {
        return this.f29414c;
    }

    @Override // com.bytedance.sdk.component.adexpress.w.p.c
    public void c(p pVar) {
        int indexOf = this.f29415w.indexOf(pVar);
        if (indexOf < 0) {
            return;
        }
        do {
            indexOf++;
            if (indexOf >= this.f29415w.size()) {
                return;
            }
        } while (!this.f29415w.get(indexOf).c(this));
    }

    @Override // com.bytedance.sdk.component.adexpress.w.p.c
    public void c(ys ysVar) {
        this.f29414c = ysVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.w.p.c
    public void c(boolean z3) {
        this.sr.getAndSet(z3);
    }
}
