package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ModelLoaderRegistry.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private final r f17319a;

    /* renamed from: b  reason: collision with root package name */
    private final a f17320b;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ModelLoaderRegistry.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, C0177a<?>> f17321a = new HashMap();

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: ModelLoaderRegistry.java */
        /* renamed from: com.bumptech.glide.load.model.p$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        public static class C0177a<Model> {

            /* renamed from: a  reason: collision with root package name */
            final List<n<Model, ?>> f17322a;

            public C0177a(List<n<Model, ?>> list) {
                this.f17322a = list;
            }
        }

        a() {
        }

        public void a() {
            this.f17321a.clear();
        }

        @Nullable
        public <Model> List<n<Model, ?>> b(Class<Model> cls) {
            C0177a<?> c0177a = this.f17321a.get(cls);
            if (c0177a == null) {
                return null;
            }
            return (List<n<Model, ?>>) c0177a.f17322a;
        }

        public <Model> void c(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.f17321a.put(cls, new C0177a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public p(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new r(pool));
    }

    @NonNull
    private static <A> Class<A> c(@NonNull A a4) {
        return (Class<A>) a4.getClass();
    }

    @NonNull
    private synchronized <A> List<n<A, ?>> f(@NonNull Class<A> cls) {
        List<n<A, ?>> b4;
        b4 = this.f17320b.b(cls);
        if (b4 == null) {
            b4 = Collections.unmodifiableList(this.f17319a.e(cls));
            this.f17320b.c(cls, b4);
        }
        return b4;
    }

    private <Model, Data> void j(@NonNull List<o<? extends Model, ? extends Data>> list) {
        for (o<? extends Model, ? extends Data> oVar : list) {
            oVar.a();
        }
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.f17319a.b(cls, cls2, oVar);
        this.f17320b.a();
    }

    public synchronized <Model, Data> n<Model, Data> b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        return this.f17319a.d(cls, cls2);
    }

    @NonNull
    public synchronized List<Class<?>> d(@NonNull Class<?> cls) {
        return this.f17319a.g(cls);
    }

    @NonNull
    public <A> List<n<A, ?>> e(@NonNull A a4) {
        List<n<A, ?>> f4 = f(c(a4));
        int size = f4.size();
        List<n<A, ?>> emptyList = Collections.emptyList();
        boolean z3 = true;
        for (int i4 = 0; i4 < size; i4++) {
            n<A, ?> nVar = f4.get(i4);
            if (nVar.a(a4)) {
                if (z3) {
                    emptyList = new ArrayList<>(size - i4);
                    z3 = false;
                }
                emptyList.add(nVar);
            }
        }
        return emptyList;
    }

    public synchronized <Model, Data> void g(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        this.f17319a.i(cls, cls2, oVar);
        this.f17320b.a();
    }

    public synchronized <Model, Data> void h(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        j(this.f17319a.j(cls, cls2));
        this.f17320b.a();
    }

    public synchronized <Model, Data> void i(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        j(this.f17319a.k(cls, cls2, oVar));
        this.f17320b.a();
    }

    private p(@NonNull r rVar) {
        this.f17320b = new a();
        this.f17319a = rVar;
    }
}
