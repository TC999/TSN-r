package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: EngineResource.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class p<Z> implements u<Z> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f17175a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17176b;

    /* renamed from: c  reason: collision with root package name */
    private final u<Z> f17177c;

    /* renamed from: d  reason: collision with root package name */
    private a f17178d;

    /* renamed from: e  reason: collision with root package name */
    private com.bumptech.glide.load.c f17179e;

    /* renamed from: f  reason: collision with root package name */
    private int f17180f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f17181g;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: EngineResource.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    interface a {
        void d(com.bumptech.glide.load.c cVar, p<?> pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(u<Z> uVar, boolean z3, boolean z4) {
        this.f17177c = (u) com.bumptech.glide.util.j.d(uVar);
        this.f17175a = z3;
        this.f17176b = z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a() {
        if (!this.f17181g) {
            this.f17180f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<Z> b() {
        return this.f17177c.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u<Z> c() {
        return this.f17177c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f17175a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        synchronized (this.f17178d) {
            synchronized (this) {
                int i4 = this.f17180f;
                if (i4 > 0) {
                    int i5 = i4 - 1;
                    this.f17180f = i5;
                    if (i5 == 0) {
                        this.f17178d.d(this.f17179e, this);
                    }
                } else {
                    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void f(com.bumptech.glide.load.c cVar, a aVar) {
        this.f17179e = cVar;
        this.f17178d = aVar;
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Z get() {
        return this.f17177c.get();
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return this.f17177c.getSize();
    }

    @Override // com.bumptech.glide.load.engine.u
    public synchronized void recycle() {
        if (this.f17180f <= 0) {
            if (!this.f17181g) {
                this.f17181g = true;
                if (this.f17176b) {
                    this.f17177c.recycle();
                }
            } else {
                throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
    }

    public synchronized String toString() {
        return "EngineResource{isCacheable=" + this.f17175a + ", listener=" + this.f17178d + ", key=" + this.f17179e + ", acquired=" + this.f17180f + ", isRecycled=" + this.f17181g + ", resource=" + this.f17177c + '}';
    }
}
