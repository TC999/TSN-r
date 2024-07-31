package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.C3770j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.bumptech.glide.load.model.r */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MultiModelLoaderFactory {

    /* renamed from: e */
    private static final C3684c f14015e = new C3684c();

    /* renamed from: f */
    private static final ModelLoader<Object, Object> f14016f = new C3682a();

    /* renamed from: a */
    private final List<C3683b<?, ?>> f14017a;

    /* renamed from: b */
    private final C3684c f14018b;

    /* renamed from: c */
    private final Set<C3683b<?, ?>> f14019c;

    /* renamed from: d */
    private final Pools.Pool<List<Throwable>> f14020d;

    /* compiled from: MultiModelLoaderFactory.java */
    /* renamed from: com.bumptech.glide.load.model.r$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3682a implements ModelLoader<Object, Object> {
        C3682a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        /* renamed from: a */
        public boolean mo45004a(@NonNull Object obj) {
            return false;
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        @Nullable
        /* renamed from: b */
        public ModelLoader.C3678a<Object> mo45003b(@NonNull Object obj, int i, int i2, @NonNull Options options) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MultiModelLoaderFactory.java */
    /* renamed from: com.bumptech.glide.load.model.r$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3683b<Model, Data> {

        /* renamed from: a */
        private final Class<Model> f14021a;

        /* renamed from: b */
        final Class<Data> f14022b;

        /* renamed from: c */
        final ModelLoaderFactory<? extends Model, ? extends Data> f14023c;

        public C3683b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
            this.f14021a = cls;
            this.f14022b = cls2;
            this.f14023c = modelLoaderFactory;
        }

        /* renamed from: a */
        public boolean m45038a(@NonNull Class<?> cls) {
            return this.f14021a.isAssignableFrom(cls);
        }

        /* renamed from: b */
        public boolean m45037b(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return m45038a(cls) && this.f14022b.isAssignableFrom(cls2);
        }
    }

    /* compiled from: MultiModelLoaderFactory.java */
    /* renamed from: com.bumptech.glide.load.model.r$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class C3684c {
        C3684c() {
        }

        @NonNull
        /* renamed from: a */
        public <Model, Data> MultiModelLoader<Model, Data> m45036a(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new MultiModelLoader<>(list, pool);
        }
    }

    public MultiModelLoaderFactory(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f14015e);
    }

    /* renamed from: a */
    private <Model, Data> void m45049a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory, boolean z) {
        C3683b<?, ?> c3683b = new C3683b<>(cls, cls2, modelLoaderFactory);
        List<C3683b<?, ?>> list = this.f14017a;
        list.add(z ? list.size() : 0, c3683b);
    }

    @NonNull
    /* renamed from: c */
    private <Model, Data> ModelLoader<Model, Data> m45047c(@NonNull C3683b<?, ?> c3683b) {
        return (ModelLoader) C3770j.m44392d(c3683b.f14023c.mo44999c(this));
    }

    @NonNull
    /* renamed from: f */
    private static <Model, Data> ModelLoader<Model, Data> m45044f() {
        return (ModelLoader<Model, Data>) f14016f;
    }

    @NonNull
    /* renamed from: h */
    private <Model, Data> ModelLoaderFactory<Model, Data> m45042h(@NonNull C3683b<?, ?> c3683b) {
        return (ModelLoaderFactory<Model, Data>) c3683b.f14023c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized <Model, Data> void m45048b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        m45049a(cls, cls2, modelLoaderFactory, true);
    }

    @NonNull
    /* renamed from: d */
    public synchronized <Model, Data> ModelLoader<Model, Data> m45046d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (C3683b<?, ?> c3683b : this.f14017a) {
                if (this.f14019c.contains(c3683b)) {
                    z = true;
                } else if (c3683b.m45037b(cls, cls2)) {
                    this.f14019c.add(c3683b);
                    arrayList.add(m45047c(c3683b));
                    this.f14019c.remove(c3683b);
                }
            }
            if (arrayList.size() > 1) {
                return this.f14018b.m45036a(arrayList, this.f14020d);
            } else if (arrayList.size() == 1) {
                return (ModelLoader) arrayList.get(0);
            } else if (z) {
                return m45044f();
            } else {
                throw new Registry.NoModelLoaderAvailableException(cls, cls2);
            }
        } catch (Throwable th) {
            this.f14019c.clear();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: e */
    public synchronized <Model> List<ModelLoader<Model, ?>> m45045e(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (C3683b<?, ?> c3683b : this.f14017a) {
                if (!this.f14019c.contains(c3683b) && c3683b.m45038a(cls)) {
                    this.f14019c.add(c3683b);
                    arrayList.add(m45047c(c3683b));
                    this.f14019c.remove(c3683b);
                }
            }
        } catch (Throwable th) {
            this.f14019c.clear();
            throw th;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: g */
    public synchronized List<Class<?>> m45043g(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (C3683b<?, ?> c3683b : this.f14017a) {
            if (!arrayList.contains(c3683b.f14022b) && c3683b.m45038a(cls)) {
                arrayList.add(c3683b.f14022b);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public synchronized <Model, Data> void m45041i(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        m45049a(cls, cls2, modelLoaderFactory, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: j */
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> m45040j(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<C3683b<?, ?>> it = this.f14017a.iterator();
        while (it.hasNext()) {
            C3683b<?, ?> next = it.next();
            if (next.m45037b(cls, cls2)) {
                it.remove();
                arrayList.add(m45042h(next));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: k */
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> m45039k(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        List<ModelLoaderFactory<? extends Model, ? extends Data>> m45040j;
        m45040j = m45040j(cls, cls2);
        m45048b(cls, cls2, modelLoaderFactory);
        return m45040j;
    }

    @VisibleForTesting
    MultiModelLoaderFactory(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull C3684c c3684c) {
        this.f14017a = new ArrayList();
        this.f14019c = new HashSet();
        this.f14020d = pool;
        this.f14018b = c3684c;
    }
}
