package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.C3770j;

/* renamed from: com.bumptech.glide.load.engine.p */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class EngineResource<Z> implements Resource<Z> {

    /* renamed from: a */
    private final boolean f13858a;

    /* renamed from: b */
    private final boolean f13859b;

    /* renamed from: c */
    private final Resource<Z> f13860c;

    /* renamed from: d */
    private InterfaceC3642a f13861d;

    /* renamed from: e */
    private Key f13862e;

    /* renamed from: f */
    private int f13863f;

    /* renamed from: g */
    private boolean f13864g;

    /* compiled from: EngineResource.java */
    /* renamed from: com.bumptech.glide.load.engine.p$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    interface InterfaceC3642a {
        /* renamed from: d */
        void mo45167d(Key key, EngineResource<?> engineResource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineResource(Resource<Z> resource, boolean z, boolean z2) {
        this.f13860c = (Resource) C3770j.m44392d(resource);
        this.f13858a = z;
        this.f13859b = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m45172a() {
        if (!this.f13864g) {
            this.f13863f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: b */
    public Class<Z> mo2883b() {
        return this.f13860c.mo2883b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public Resource<Z> m45171c() {
        return this.f13860c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean m45170d() {
        return this.f13858a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void m45169e() {
        synchronized (this.f13861d) {
            synchronized (this) {
                int i = this.f13863f;
                if (i > 0) {
                    int i2 = i - 1;
                    this.f13863f = i2;
                    if (i2 == 0) {
                        this.f13861d.mo45167d(this.f13862e, this);
                    }
                } else {
                    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public synchronized void m45168f(Key key, InterfaceC3642a interfaceC3642a) {
        this.f13862e = key;
        this.f13861d = interfaceC3642a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Z get() {
        return this.f13860c.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.f13860c.getSize();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void recycle() {
        if (this.f13863f <= 0) {
            if (!this.f13864g) {
                this.f13864g = true;
                if (this.f13859b) {
                    this.f13860c.recycle();
                }
            } else {
                throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
    }

    public synchronized String toString() {
        return "EngineResource{isCacheable=" + this.f13858a + ", listener=" + this.f13861d + ", key=" + this.f13862e + ", acquired=" + this.f13863f + ", isRecycled=" + this.f13864g + ", resource=" + this.f13860c + '}';
    }
}
