package com.bumptech.glide.request;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ThumbnailRequestCoordinator.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class k implements e, d {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final e f17954a;

    /* renamed from: b  reason: collision with root package name */
    private d f17955b;

    /* renamed from: c  reason: collision with root package name */
    private d f17956c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17957d;

    @VisibleForTesting
    k() {
        this(null);
    }

    private boolean m() {
        e eVar = this.f17954a;
        return eVar == null || eVar.l(this);
    }

    private boolean n() {
        e eVar = this.f17954a;
        return eVar == null || eVar.c(this);
    }

    private boolean o() {
        e eVar = this.f17954a;
        return eVar == null || eVar.e(this);
    }

    private boolean p() {
        e eVar = this.f17954a;
        return eVar != null && eVar.b();
    }

    @Override // com.bumptech.glide.request.d
    public boolean a() {
        return this.f17955b.a() || this.f17956c.a();
    }

    @Override // com.bumptech.glide.request.e
    public boolean b() {
        return p() || d();
    }

    @Override // com.bumptech.glide.request.e
    public boolean c(d dVar) {
        return n() && dVar.equals(this.f17955b) && !b();
    }

    @Override // com.bumptech.glide.request.d
    public void clear() {
        this.f17957d = false;
        this.f17956c.clear();
        this.f17955b.clear();
    }

    @Override // com.bumptech.glide.request.d
    public boolean d() {
        return this.f17955b.d() || this.f17956c.d();
    }

    @Override // com.bumptech.glide.request.e
    public boolean e(d dVar) {
        return o() && (dVar.equals(this.f17955b) || !this.f17955b.d());
    }

    @Override // com.bumptech.glide.request.d
    public boolean f() {
        return this.f17955b.f();
    }

    @Override // com.bumptech.glide.request.d
    public boolean g() {
        return this.f17955b.g();
    }

    @Override // com.bumptech.glide.request.e
    public void h(d dVar) {
        e eVar;
        if (dVar.equals(this.f17955b) && (eVar = this.f17954a) != null) {
            eVar.h(this);
        }
    }

    @Override // com.bumptech.glide.request.d
    public boolean i(d dVar) {
        if (dVar instanceof k) {
            k kVar = (k) dVar;
            d dVar2 = this.f17955b;
            if (dVar2 == null) {
                if (kVar.f17955b != null) {
                    return false;
                }
            } else if (!dVar2.i(kVar.f17955b)) {
                return false;
            }
            d dVar3 = this.f17956c;
            d dVar4 = kVar.f17956c;
            if (dVar3 == null) {
                if (dVar4 != null) {
                    return false;
                }
            } else if (!dVar3.i(dVar4)) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.d
    public boolean isRunning() {
        return this.f17955b.isRunning();
    }

    @Override // com.bumptech.glide.request.d
    public void j() {
        this.f17957d = true;
        if (!this.f17955b.a() && !this.f17956c.isRunning()) {
            this.f17956c.j();
        }
        if (!this.f17957d || this.f17955b.isRunning()) {
            return;
        }
        this.f17955b.j();
    }

    @Override // com.bumptech.glide.request.e
    public void k(d dVar) {
        if (dVar.equals(this.f17956c)) {
            return;
        }
        e eVar = this.f17954a;
        if (eVar != null) {
            eVar.k(this);
        }
        if (this.f17956c.a()) {
            return;
        }
        this.f17956c.clear();
    }

    @Override // com.bumptech.glide.request.e
    public boolean l(d dVar) {
        return m() && dVar.equals(this.f17955b);
    }

    public void q(d dVar, d dVar2) {
        this.f17955b = dVar;
        this.f17956c = dVar2;
    }

    @Override // com.bumptech.glide.request.d
    public void recycle() {
        this.f17955b.recycle();
        this.f17956c.recycle();
    }

    public k(@Nullable e eVar) {
        this.f17954a = eVar;
    }
}
