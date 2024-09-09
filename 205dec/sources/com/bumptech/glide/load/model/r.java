package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.model.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MultiModelLoaderFactory.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class r {

    /* renamed from: e  reason: collision with root package name */
    private static final c f17332e = new c();

    /* renamed from: f  reason: collision with root package name */
    private static final n<Object, Object> f17333f = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<b<?, ?>> f17334a;

    /* renamed from: b  reason: collision with root package name */
    private final c f17335b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<b<?, ?>> f17336c;

    /* renamed from: d  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f17337d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MultiModelLoaderFactory.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class a implements n<Object, Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.model.n
        public boolean a(@NonNull Object obj) {
            return false;
        }

        @Override // com.bumptech.glide.load.model.n
        @Nullable
        public n.a<Object> b(@NonNull Object obj, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MultiModelLoaderFactory.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class b<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<Model> f17338a;

        /* renamed from: b  reason: collision with root package name */
        final Class<Data> f17339b;

        /* renamed from: c  reason: collision with root package name */
        final o<? extends Model, ? extends Data> f17340c;

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
            this.f17338a = cls;
            this.f17339b = cls2;
            this.f17340c = oVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f17338a.isAssignableFrom(cls);
        }

        public boolean b(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return a(cls) && this.f17339b.isAssignableFrom(cls2);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MultiModelLoaderFactory.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static class c {
        c() {
        }

        @NonNull
        public <Model, Data> q<Model, Data> a(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new q<>(list, pool);
        }
    }

    public r(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f17332e);
    }

    private <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar, boolean z3) {
        b<?, ?> bVar = new b<>(cls, cls2, oVar);
        List<b<?, ?>> list = this.f17334a;
        list.add(z3 ? list.size() : 0, bVar);
    }

    @NonNull
    private <Model, Data> n<Model, Data> c(@NonNull b<?, ?> bVar) {
        return (n) com.bumptech.glide.util.j.d(bVar.f17340c.c(this));
    }

    @NonNull
    private static <Model, Data> n<Model, Data> f() {
        return (n<Model, Data>) f17333f;
    }

    @NonNull
    private <Model, Data> o<Model, Data> h(@NonNull b<?, ?> bVar) {
        return (o<Model, Data>) bVar.f17340c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    @NonNull
    public synchronized <Model, Data> n<Model, Data> d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z3 = false;
            for (b<?, ?> bVar : this.f17334a) {
                if (this.f17336c.contains(bVar)) {
                    z3 = true;
                } else if (bVar.b(cls, cls2)) {
                    this.f17336c.add(bVar);
                    arrayList.add(c(bVar));
                    this.f17336c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f17335b.a(arrayList, this.f17337d);
            } else if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            } else if (z3) {
                return f();
            } else {
                throw new Registry.NoModelLoaderAvailableException(cls, cls2);
            }
        } catch (Throwable th) {
            this.f17336c.clear();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model> List<n<Model, ?>> e(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f17334a) {
                if (!this.f17336c.contains(bVar) && bVar.a(cls)) {
                    this.f17336c.add(bVar);
                    arrayList.add(c(bVar));
                    this.f17336c.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.f17336c.clear();
            throw th;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized List<Class<?>> g(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f17334a) {
            if (!arrayList.contains(bVar.f17339b) && bVar.a(cls)) {
                arrayList.add(bVar.f17339b);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized <Model, Data> void i(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model, Data> List<o<? extends Model, ? extends Data>> j(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<b<?, ?>> it = this.f17334a.iterator();
        while (it.hasNext()) {
            b<?, ?> next = it.next();
            if (next.b(cls, cls2)) {
                it.remove();
                arrayList.add(h(next));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model, Data> List<o<? extends Model, ? extends Data>> k(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        List<o<? extends Model, ? extends Data>> j4;
        j4 = j(cls, cls2);
        b(cls, cls2, oVar);
        return j4;
    }

    @VisibleForTesting
    r(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull c cVar) {
        this.f17334a = new ArrayList();
        this.f17336c = new HashSet();
        this.f17337d = pool;
        this.f17335b = cVar;
    }
}
