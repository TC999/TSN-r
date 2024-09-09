package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ModelLoader.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface n<Model, Data> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ModelLoader.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a<Data> {

        /* renamed from: a  reason: collision with root package name */
        public final com.bumptech.glide.load.c f17316a;

        /* renamed from: b  reason: collision with root package name */
        public final List<com.bumptech.glide.load.c> f17317b;

        /* renamed from: c  reason: collision with root package name */
        public final com.bumptech.glide.load.data.d<Data> f17318c;

        public a(@NonNull com.bumptech.glide.load.c cVar, @NonNull com.bumptech.glide.load.data.d<Data> dVar) {
            this(cVar, Collections.emptyList(), dVar);
        }

        public a(@NonNull com.bumptech.glide.load.c cVar, @NonNull List<com.bumptech.glide.load.c> list, @NonNull com.bumptech.glide.load.data.d<Data> dVar) {
            this.f17316a = (com.bumptech.glide.load.c) com.bumptech.glide.util.j.d(cVar);
            this.f17317b = (List) com.bumptech.glide.util.j.d(list);
            this.f17318c = (com.bumptech.glide.load.data.d) com.bumptech.glide.util.j.d(dVar);
        }
    }

    boolean a(@NonNull Model model);

    @Nullable
    a<Data> b(@NonNull Model model, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar);
}
