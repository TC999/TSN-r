package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: FactoryPools.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18087a = "FactoryPools";

    /* renamed from: b  reason: collision with root package name */
    private static final int f18088b = 20;

    /* renamed from: c  reason: collision with root package name */
    private static final g<Object> f18089c = new C0186a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FactoryPools.java */
    /* renamed from: com.bumptech.glide.util.pool.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class C0186a implements g<Object> {
        C0186a() {
        }

        @Override // com.bumptech.glide.util.pool.a.g
        public void a(@NonNull Object obj) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FactoryPools.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class b<T> implements d<List<T>> {
        b() {
        }

        @Override // com.bumptech.glide.util.pool.a.d
        @NonNull
        /* renamed from: b */
        public List<T> a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FactoryPools.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class c<T> implements g<List<T>> {
        c() {
        }

        @Override // com.bumptech.glide.util.pool.a.g
        /* renamed from: b */
        public void a(@NonNull List<T> list) {
            list.clear();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FactoryPools.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface d<T> {
        T a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FactoryPools.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class e<T> implements Pools.Pool<T> {

        /* renamed from: a  reason: collision with root package name */
        private final d<T> f18090a;

        /* renamed from: b  reason: collision with root package name */
        private final g<T> f18091b;

        /* renamed from: c  reason: collision with root package name */
        private final Pools.Pool<T> f18092c;

        e(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
            this.f18092c = pool;
            this.f18090a = dVar;
            this.f18091b = gVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T acquire = this.f18092c.acquire();
            if (acquire == null) {
                acquire = this.f18090a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof f) {
                ((f) acquire).h().b(false);
            }
            return acquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t3) {
            if (t3 instanceof f) {
                ((f) t3).h().b(true);
            }
            this.f18091b.a(t3);
            return this.f18092c.release(t3);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FactoryPools.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface f {
        @NonNull
        com.bumptech.glide.util.pool.c h();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: FactoryPools.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface g<T> {
        void a(@NonNull T t3);
    }

    private a() {
    }

    @NonNull
    private static <T extends f> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar) {
        return b(pool, dVar, c());
    }

    @NonNull
    private static <T> Pools.Pool<T> b(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
        return new e(pool, dVar, gVar);
    }

    @NonNull
    private static <T> g<T> c() {
        return (g<T>) f18089c;
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> d(int i4, @NonNull d<T> dVar) {
        return a(new Pools.SimplePool(i4), dVar);
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> e(int i4, @NonNull d<T> dVar) {
        return a(new Pools.SynchronizedPool(i4), dVar);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> f() {
        return g(20);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> g(int i4) {
        return b(new Pools.SynchronizedPool(i4), new b(), new c());
    }
}
