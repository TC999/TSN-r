package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.C3770j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.bumptech.glide.load.model.q */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: a */
    private final List<ModelLoader<Model, Data>> f14006a;

    /* renamed from: b */
    private final Pools.Pool<List<Throwable>> f14007b;

    /* compiled from: MultiModelLoader.java */
    /* renamed from: com.bumptech.glide.load.model.q$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class C3681a<Data> implements DataFetcher<Data>, DataFetcher.InterfaceC3562a<Data> {

        /* renamed from: a */
        private final List<DataFetcher<Data>> f14008a;

        /* renamed from: b */
        private final Pools.Pool<List<Throwable>> f14009b;

        /* renamed from: c */
        private int f14010c;

        /* renamed from: d */
        private Priority f14011d;

        /* renamed from: e */
        private DataFetcher.InterfaceC3562a<? super Data> f14012e;
        @Nullable

        /* renamed from: f */
        private List<Throwable> f14013f;

        /* renamed from: g */
        private boolean f14014g;

        C3681a(@NonNull List<DataFetcher<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f14009b = pool;
            C3770j.m44393c(list);
            this.f14008a = list;
            this.f14010c = 0;
        }

        /* renamed from: f */
        private void m45050f() {
            if (this.f14014g) {
                return;
            }
            if (this.f14010c < this.f14008a.size() - 1) {
                this.f14010c++;
                mo45008d(this.f14011d, this.f14012e);
                return;
            }
            C3770j.m44392d(this.f14013f);
            this.f14012e.mo45052c(new GlideException("Fetch failed", new ArrayList(this.f14013f)));
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        /* renamed from: a */
        public Class<Data> mo45010a() {
            return this.f14008a.get(0).mo45010a();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        /* renamed from: b */
        public void mo45009b() {
            List<Throwable> list = this.f14013f;
            if (list != null) {
                this.f14009b.release(list);
            }
            this.f14013f = null;
            for (DataFetcher<Data> dataFetcher : this.f14008a) {
                dataFetcher.mo45009b();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.InterfaceC3562a
        /* renamed from: c */
        public void mo45052c(@NonNull Exception exc) {
            ((List) C3770j.m44392d(this.f14013f)).add(exc);
            m45050f();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.f14014g = true;
            for (DataFetcher<Data> dataFetcher : this.f14008a) {
                dataFetcher.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        /* renamed from: d */
        public void mo45008d(@NonNull Priority priority, @NonNull DataFetcher.InterfaceC3562a<? super Data> interfaceC3562a) {
            this.f14011d = priority;
            this.f14012e = interfaceC3562a;
            this.f14013f = this.f14009b.acquire();
            this.f14008a.get(this.f14010c).mo45008d(priority, this);
            if (this.f14014g) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.InterfaceC3562a
        /* renamed from: e */
        public void mo45051e(@Nullable Data data) {
            if (data != null) {
                this.f14012e.mo45051e(data);
            } else {
                m45050f();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        @NonNull
        public DataSource getDataSource() {
            return this.f14008a.get(0).getDataSource();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiModelLoader(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f14006a = list;
        this.f14007b = pool;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: a */
    public boolean mo45004a(@NonNull Model model) {
        for (ModelLoader<Model, Data> modelLoader : this.f14006a) {
            if (modelLoader.mo45004a(model)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* renamed from: b */
    public ModelLoader.C3678a<Data> mo45003b(@NonNull Model model, int i, int i2, @NonNull Options options) {
        ModelLoader.C3678a<Data> mo45003b;
        int size = this.f14006a.size();
        ArrayList arrayList = new ArrayList(size);
        Key key = null;
        for (int i3 = 0; i3 < size; i3++) {
            ModelLoader<Model, Data> modelLoader = this.f14006a.get(i3);
            if (modelLoader.mo45004a(model) && (mo45003b = modelLoader.mo45003b(model, i, i2, options)) != null) {
                key = mo45003b.f13999a;
                arrayList.add(mo45003b.f14001c);
            }
        }
        if (arrayList.isEmpty() || key == null) {
            return null;
        }
        return new ModelLoader.C3678a<>(key, new C3681a(arrayList, this.f14007b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f14006a.toArray()) + '}';
    }
}
