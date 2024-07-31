package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.util.C3770j;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.bumptech.glide.load.engine.t */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class LockedResource<Z> implements Resource<Z>, FactoryPools.InterfaceC3779f {

    /* renamed from: e */
    private static final Pools.Pool<LockedResource<?>> f13903e = FactoryPools.m44359e(20, new C3646a());

    /* renamed from: a */
    private final StateVerifier f13904a = StateVerifier.m44345a();

    /* renamed from: b */
    private Resource<Z> f13905b;

    /* renamed from: c */
    private boolean f13906c;

    /* renamed from: d */
    private boolean f13907d;

    /* compiled from: LockedResource.java */
    /* renamed from: com.bumptech.glide.load.engine.t$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3646a implements FactoryPools.InterfaceC3777d<LockedResource<?>> {
        C3646a() {
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.InterfaceC3777d
        /* renamed from: b */
        public LockedResource<?> mo44354a() {
            return new LockedResource<>();
        }
    }

    LockedResource() {
    }

    /* renamed from: a */
    private void m45138a(Resource<Z> resource) {
        this.f13907d = false;
        this.f13906c = true;
        this.f13905b = resource;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: c */
    public static <Z> LockedResource<Z> m45137c(Resource<Z> resource) {
        LockedResource<Z> lockedResource = (LockedResource) C3770j.m44392d(f13903e.acquire());
        lockedResource.m45138a(resource);
        return lockedResource;
    }

    /* renamed from: d */
    private void m45136d() {
        this.f13905b = null;
        f13903e.release(this);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: b */
    public Class<Z> mo2883b() {
        return this.f13905b.mo2883b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public synchronized void m45135e() {
        this.f13904a.mo44343c();
        if (this.f13906c) {
            this.f13906c = false;
            if (this.f13907d) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Z get() {
        return this.f13905b.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.f13905b.getSize();
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.InterfaceC3779f
    @NonNull
    /* renamed from: h */
    public StateVerifier mo44353h() {
        return this.f13904a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void recycle() {
        this.f13904a.mo44343c();
        this.f13907d = true;
        if (!this.f13906c) {
            this.f13905b.recycle();
            m45136d();
        }
    }
}
