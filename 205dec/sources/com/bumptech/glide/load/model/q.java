package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MultiModelLoader.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class q<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n<Model, Data>> f17323a;

    /* renamed from: b  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f17324b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MultiModelLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static class a<Data> implements com.bumptech.glide.load.data.d<Data>, d.a<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final List<com.bumptech.glide.load.data.d<Data>> f17325a;

        /* renamed from: b  reason: collision with root package name */
        private final Pools.Pool<List<Throwable>> f17326b;

        /* renamed from: c  reason: collision with root package name */
        private int f17327c;

        /* renamed from: d  reason: collision with root package name */
        private Priority f17328d;

        /* renamed from: e  reason: collision with root package name */
        private d.a<? super Data> f17329e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private List<Throwable> f17330f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f17331g;

        a(@NonNull List<com.bumptech.glide.load.data.d<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f17326b = pool;
            com.bumptech.glide.util.j.c(list);
            this.f17325a = list;
            this.f17327c = 0;
        }

        private void f() {
            if (this.f17331g) {
                return;
            }
            if (this.f17327c < this.f17325a.size() - 1) {
                this.f17327c++;
                d(this.f17328d, this.f17329e);
                return;
            }
            com.bumptech.glide.util.j.d(this.f17330f);
            this.f17329e.c(new GlideException("Fetch failed", new ArrayList(this.f17330f)));
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f17325a.get(0).a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            List<Throwable> list = this.f17330f;
            if (list != null) {
                this.f17326b.release(list);
            }
            this.f17330f = null;
            for (com.bumptech.glide.load.data.d<Data> dVar : this.f17325a) {
                dVar.b();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void c(@NonNull Exception exc) {
            ((List) com.bumptech.glide.util.j.d(this.f17330f)).add(exc);
            f();
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.f17331g = true;
            for (com.bumptech.glide.load.data.d<Data> dVar : this.f17325a) {
                dVar.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void d(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            this.f17328d = priority;
            this.f17329e = aVar;
            this.f17330f = this.f17326b.acquire();
            this.f17325a.get(this.f17327c).d(priority, this);
            if (this.f17331g) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void e(@Nullable Data data) {
            if (data != null) {
                this.f17329e.e(data);
            } else {
                f();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource getDataSource() {
            return this.f17325a.get(0).getDataSource();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(@NonNull List<n<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f17323a = list;
        this.f17324b = pool;
    }

    @Override // com.bumptech.glide.load.model.n
    public boolean a(@NonNull Model model) {
        for (n<Model, Data> nVar : this.f17323a) {
            if (nVar.a(model)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.model.n
    public n.a<Data> b(@NonNull Model model, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) {
        n.a<Data> b4;
        int size = this.f17323a.size();
        ArrayList arrayList = new ArrayList(size);
        com.bumptech.glide.load.c cVar = null;
        for (int i6 = 0; i6 < size; i6++) {
            n<Model, Data> nVar = this.f17323a.get(i6);
            if (nVar.a(model) && (b4 = nVar.b(model, i4, i5, fVar)) != null) {
                cVar = b4.f17316a;
                arrayList.add(b4.f17318c);
            }
        }
        if (arrayList.isEmpty() || cVar == null) {
            return null;
        }
        return new n.a<>(cVar, new a(arrayList, this.f17324b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f17323a.toArray()) + '}';
    }
}
