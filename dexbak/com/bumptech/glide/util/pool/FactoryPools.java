package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.util.pool.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class FactoryPools {

    /* renamed from: a */
    private static final String f14569a = "FactoryPools";

    /* renamed from: b */
    private static final int f14570b = 20;

    /* renamed from: c */
    private static final InterfaceC3780g<Object> f14571c = new C3774a();

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.pool.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3774a implements InterfaceC3780g<Object> {
        C3774a() {
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.InterfaceC3780g
        /* renamed from: a */
        public void mo44352a(@NonNull Object obj) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.pool.a$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3775b<T> implements InterfaceC3777d<List<T>> {
        C3775b() {
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.InterfaceC3777d
        @NonNull
        /* renamed from: b */
        public List<T> mo44354a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.pool.a$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3776c<T> implements InterfaceC3780g<List<T>> {
        C3776c() {
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.InterfaceC3780g
        /* renamed from: b */
        public void mo44352a(@NonNull List<T> list) {
            list.clear();
        }
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.pool.a$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3777d<T> {
        /* renamed from: a */
        T mo44354a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.pool.a$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3778e<T> implements Pools.Pool<T> {

        /* renamed from: a */
        private final InterfaceC3777d<T> f14572a;

        /* renamed from: b */
        private final InterfaceC3780g<T> f14573b;

        /* renamed from: c */
        private final Pools.Pool<T> f14574c;

        C3778e(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC3777d<T> interfaceC3777d, @NonNull InterfaceC3780g<T> interfaceC3780g) {
            this.f14574c = pool;
            this.f14572a = interfaceC3777d;
            this.f14573b = interfaceC3780g;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T acquire = this.f14574c.acquire();
            if (acquire == null) {
                acquire = this.f14572a.mo44354a();
                if (Log.isLoggable(FactoryPools.f14569a, 2)) {
                    Log.v(FactoryPools.f14569a, "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof InterfaceC3779f) {
                ((InterfaceC3779f) acquire).mo44353h().mo44344b(false);
            }
            return acquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            if (t instanceof InterfaceC3779f) {
                ((InterfaceC3779f) t).mo44353h().mo44344b(true);
            }
            this.f14573b.mo44352a(t);
            return this.f14574c.release(t);
        }
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.pool.a$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3779f {
        @NonNull
        /* renamed from: h */
        StateVerifier mo44353h();
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.pool.a$g */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3780g<T> {
        /* renamed from: a */
        void mo44352a(@NonNull T t);
    }

    private FactoryPools() {
    }

    @NonNull
    /* renamed from: a */
    private static <T extends InterfaceC3779f> Pools.Pool<T> m44363a(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC3777d<T> interfaceC3777d) {
        return m44362b(pool, interfaceC3777d, m44361c());
    }

    @NonNull
    /* renamed from: b */
    private static <T> Pools.Pool<T> m44362b(@NonNull Pools.Pool<T> pool, @NonNull InterfaceC3777d<T> interfaceC3777d, @NonNull InterfaceC3780g<T> interfaceC3780g) {
        return new C3778e(pool, interfaceC3777d, interfaceC3780g);
    }

    @NonNull
    /* renamed from: c */
    private static <T> InterfaceC3780g<T> m44361c() {
        return (InterfaceC3780g<T>) f14571c;
    }

    @NonNull
    /* renamed from: d */
    public static <T extends InterfaceC3779f> Pools.Pool<T> m44360d(int i, @NonNull InterfaceC3777d<T> interfaceC3777d) {
        return m44363a(new Pools.SimplePool(i), interfaceC3777d);
    }

    @NonNull
    /* renamed from: e */
    public static <T extends InterfaceC3779f> Pools.Pool<T> m44359e(int i, @NonNull InterfaceC3777d<T> interfaceC3777d) {
        return m44363a(new Pools.SynchronizedPool(i), interfaceC3777d);
    }

    @NonNull
    /* renamed from: f */
    public static <T> Pools.Pool<List<T>> m44358f() {
        return m44357g(20);
    }

    @NonNull
    /* renamed from: g */
    public static <T> Pools.Pool<List<T>> m44357g(int i) {
        return m44362b(new Pools.SynchronizedPool(i), new C3775b(), new C3776c());
    }
}
