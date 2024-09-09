package com.bumptech.glide.request;

import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ErrorRequestCoordinator.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class b implements e, d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final e f17906a;

    /* renamed from: b  reason: collision with root package name */
    private d f17907b;

    /* renamed from: c  reason: collision with root package name */
    private d f17908c;

    public b(@Nullable e eVar) {
        this.f17906a = eVar;
    }

    private boolean m(d dVar) {
        return dVar.equals(this.f17907b) || (this.f17907b.f() && dVar.equals(this.f17908c));
    }

    private boolean n() {
        e eVar = this.f17906a;
        return eVar == null || eVar.l(this);
    }

    private boolean o() {
        e eVar = this.f17906a;
        return eVar == null || eVar.c(this);
    }

    private boolean p() {
        e eVar = this.f17906a;
        return eVar == null || eVar.e(this);
    }

    private boolean q() {
        e eVar = this.f17906a;
        return eVar != null && eVar.b();
    }

    @Override // com.bumptech.glide.request.d
    public boolean a() {
        return (this.f17907b.f() ? this.f17908c : this.f17907b).a();
    }

    @Override // com.bumptech.glide.request.e
    public boolean b() {
        return q() || d();
    }

    @Override // com.bumptech.glide.request.e
    public boolean c(d dVar) {
        return o() && m(dVar);
    }

    @Override // com.bumptech.glide.request.d
    public void clear() {
        this.f17907b.clear();
        if (this.f17908c.isRunning()) {
            this.f17908c.clear();
        }
    }

    @Override // com.bumptech.glide.request.d
    public boolean d() {
        return (this.f17907b.f() ? this.f17908c : this.f17907b).d();
    }

    @Override // com.bumptech.glide.request.e
    public boolean e(d dVar) {
        return p() && m(dVar);
    }

    @Override // com.bumptech.glide.request.d
    public boolean f() {
        return this.f17907b.f() && this.f17908c.f();
    }

    @Override // com.bumptech.glide.request.d
    public boolean g() {
        return (this.f17907b.f() ? this.f17908c : this.f17907b).g();
    }

    @Override // com.bumptech.glide.request.e
    public void h(d dVar) {
        if (!dVar.equals(this.f17908c)) {
            if (this.f17908c.isRunning()) {
                return;
            }
            this.f17908c.j();
            return;
        }
        e eVar = this.f17906a;
        if (eVar != null) {
            eVar.h(this);
        }
    }

    @Override // com.bumptech.glide.request.d
    public boolean i(d dVar) {
        if (dVar instanceof b) {
            b bVar = (b) dVar;
            return this.f17907b.i(bVar.f17907b) && this.f17908c.i(bVar.f17908c);
        }
        return false;
    }

    @Override // com.bumptech.glide.request.d
    public boolean isRunning() {
        return (this.f17907b.f() ? this.f17908c : this.f17907b).isRunning();
    }

    @Override // com.bumptech.glide.request.d
    public void j() {
        if (this.f17907b.isRunning()) {
            return;
        }
        this.f17907b.j();
    }

    @Override // com.bumptech.glide.request.e
    public void k(d dVar) {
        e eVar = this.f17906a;
        if (eVar != null) {
            eVar.k(this);
        }
    }

    @Override // com.bumptech.glide.request.e
    public boolean l(d dVar) {
        return n() && m(dVar);
    }

    public void r(d dVar, d dVar2) {
        this.f17907b = dVar;
        this.f17908c = dVar2;
    }

    @Override // com.bumptech.glide.request.d
    public void recycle() {
        this.f17907b.recycle();
        this.f17908c.recycle();
    }
}
