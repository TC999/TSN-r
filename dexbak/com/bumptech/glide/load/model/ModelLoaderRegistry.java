package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.model.p */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ModelLoaderRegistry {

    /* renamed from: a */
    private final MultiModelLoaderFactory f14002a;

    /* renamed from: b */
    private final C3679a f14003b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ModelLoaderRegistry.java */
    /* renamed from: com.bumptech.glide.load.model.p$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3679a {

        /* renamed from: a */
        private final Map<Class<?>, C3680a<?>> f14004a = new HashMap();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ModelLoaderRegistry.java */
        /* renamed from: com.bumptech.glide.load.model.p$a$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public static class C3680a<Model> {

            /* renamed from: a */
            final List<ModelLoader<Model, ?>> f14005a;

            public C3680a(List<ModelLoader<Model, ?>> list) {
                this.f14005a = list;
            }
        }

        C3679a() {
        }

        /* renamed from: a */
        public void m45055a() {
            this.f14004a.clear();
        }

        @Nullable
        /* renamed from: b */
        public <Model> List<ModelLoader<Model, ?>> m45054b(Class<Model> cls) {
            C3680a<?> c3680a = this.f14004a.get(cls);
            if (c3680a == null) {
                return null;
            }
            return (List<ModelLoader<Model, ?>>) c3680a.f14005a;
        }

        /* renamed from: c */
        public <Model> void m45053c(Class<Model> cls, List<ModelLoader<Model, ?>> list) {
            if (this.f14004a.put(cls, new C3680a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public ModelLoaderRegistry(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new MultiModelLoaderFactory(pool));
    }

    @NonNull
    /* renamed from: c */
    private static <A> Class<A> m45063c(@NonNull A a) {
        return (Class<A>) a.getClass();
    }

    @NonNull
    /* renamed from: f */
    private synchronized <A> List<ModelLoader<A, ?>> m45060f(@NonNull Class<A> cls) {
        List<ModelLoader<A, ?>> m45054b;
        m45054b = this.f14003b.m45054b(cls);
        if (m45054b == null) {
            m45054b = Collections.unmodifiableList(this.f14002a.m45045e(cls));
            this.f14003b.m45053c(cls, m45054b);
        }
        return m45054b;
    }

    /* renamed from: j */
    private <Model, Data> void m45056j(@NonNull List<ModelLoaderFactory<? extends Model, ? extends Data>> list) {
        for (ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory : list) {
            modelLoaderFactory.mo45000a();
        }
    }

    /* renamed from: a */
    public synchronized <Model, Data> void m45065a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f14002a.m45048b(cls, cls2, modelLoaderFactory);
        this.f14003b.m45055a();
    }

    /* renamed from: b */
    public synchronized <Model, Data> ModelLoader<Model, Data> m45064b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        return this.f14002a.m45046d(cls, cls2);
    }

    @NonNull
    /* renamed from: d */
    public synchronized List<Class<?>> m45062d(@NonNull Class<?> cls) {
        return this.f14002a.m45043g(cls);
    }

    @NonNull
    /* renamed from: e */
    public <A> List<ModelLoader<A, ?>> m45061e(@NonNull A a) {
        List<ModelLoader<A, ?>> m45060f = m45060f(m45063c(a));
        int size = m45060f.size();
        List<ModelLoader<A, ?>> emptyList = Collections.emptyList();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            ModelLoader<A, ?> modelLoader = m45060f.get(i);
            if (modelLoader.mo45004a(a)) {
                if (z) {
                    emptyList = new ArrayList<>(size - i);
                    z = false;
                }
                emptyList.add(modelLoader);
            }
        }
        return emptyList;
    }

    /* renamed from: g */
    public synchronized <Model, Data> void m45059g(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f14002a.m45041i(cls, cls2, modelLoaderFactory);
        this.f14003b.m45055a();
    }

    /* renamed from: h */
    public synchronized <Model, Data> void m45058h(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        m45056j(this.f14002a.m45040j(cls, cls2));
        this.f14003b.m45055a();
    }

    /* renamed from: i */
    public synchronized <Model, Data> void m45057i(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        m45056j(this.f14002a.m45039k(cls, cls2, modelLoaderFactory));
        this.f14003b.m45055a();
    }

    private ModelLoaderRegistry(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
        this.f14003b = new C3679a();
        this.f14002a = multiModelLoaderFactory;
    }
}
