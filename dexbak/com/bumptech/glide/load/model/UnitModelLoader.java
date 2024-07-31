package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

/* renamed from: com.bumptech.glide.load.model.v */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class UnitModelLoader<Model> implements ModelLoader<Model, Model> {

    /* renamed from: a */
    private static final UnitModelLoader<?> f14046a = new UnitModelLoader<>();

    /* compiled from: UnitModelLoader.java */
    /* renamed from: com.bumptech.glide.load.model.v$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3697a<Model> implements ModelLoaderFactory<Model, Model> {

        /* renamed from: a */
        private static final C3697a<?> f14047a = new C3697a<>();

        /* renamed from: b */
        public static <T> C3697a<T> m45011b() {
            return (C3697a<T>) f14047a;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        /* renamed from: a */
        public void mo45000a() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        /* renamed from: c */
        public ModelLoader<Model, Model> mo44999c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return UnitModelLoader.m45012c();
        }
    }

    /* compiled from: UnitModelLoader.java */
    /* renamed from: com.bumptech.glide.load.model.v$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3698b<Model> implements DataFetcher<Model> {

        /* renamed from: a */
        private final Model f14048a;

        C3698b(Model model) {
            this.f14048a = model;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        /* renamed from: a */
        public Class<Model> mo45010a() {
            return (Class<Model>) this.f14048a.getClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        /* renamed from: b */
        public void mo45009b() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        /* renamed from: d */
        public void mo45008d(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC3562a<? super Model> interfaceC3562a) {
            interfaceC3562a.mo45051e((Model) this.f14048a);
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    /* renamed from: c */
    public static <T> UnitModelLoader<T> m45012c() {
        return (UnitModelLoader<T>) f14046a;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: a */
    public boolean mo45004a(@NonNull Model model) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: b */
    public ModelLoader.C3678a<Model> mo45003b(@NonNull Model model, int i, int i2, @NonNull Options options) {
        return new ModelLoader.C3678a<>(new ObjectKey(model), new C3698b(model));
    }
}
