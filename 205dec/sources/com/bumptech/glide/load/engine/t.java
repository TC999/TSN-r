package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.util.pool.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LockedResource.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class t<Z> implements u<Z>, a.f {

    /* renamed from: e  reason: collision with root package name */
    private static final Pools.Pool<t<?>> f17220e = com.bumptech.glide.util.pool.a.e(20, new a());

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.util.pool.c f17221a = com.bumptech.glide.util.pool.c.a();

    /* renamed from: b  reason: collision with root package name */
    private u<Z> f17222b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17223c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17224d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: LockedResource.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements a.d<t<?>> {
        a() {
        }

        @Override // com.bumptech.glide.util.pool.a.d
        /* renamed from: b */
        public t<?> a() {
            return new t<>();
        }
    }

    t() {
    }

    private void a(u<Z> uVar) {
        this.f17224d = false;
        this.f17223c = true;
        this.f17222b = uVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static <Z> t<Z> c(u<Z> uVar) {
        t<Z> tVar = (t) com.bumptech.glide.util.j.d(f17220e.acquire());
        tVar.a(uVar);
        return tVar;
    }

    private void d() {
        this.f17222b = null;
        f17220e.release(this);
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<Z> b() {
        return this.f17222b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void e() {
        this.f17221a.c();
        if (this.f17223c) {
            this.f17223c = false;
            if (this.f17224d) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Z get() {
        return this.f17222b.get();
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return this.f17222b.getSize();
    }

    @Override // com.bumptech.glide.util.pool.a.f
    @NonNull
    public com.bumptech.glide.util.pool.c h() {
        return this.f17221a;
    }

    @Override // com.bumptech.glide.load.engine.u
    public synchronized void recycle() {
        this.f17221a.c();
        this.f17224d = true;
        if (!this.f17223c) {
            this.f17222b.recycle();
            d();
        }
    }
}
