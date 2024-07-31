package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.C3770j;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bumptech.glide.load.model.n */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface ModelLoader<Model, Data> {

    /* compiled from: ModelLoader.java */
    /* renamed from: com.bumptech.glide.load.model.n$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3678a<Data> {

        /* renamed from: a */
        public final Key f13999a;

        /* renamed from: b */
        public final List<Key> f14000b;

        /* renamed from: c */
        public final DataFetcher<Data> f14001c;

        public C3678a(@NonNull Key key, @NonNull DataFetcher<Data> dataFetcher) {
            this(key, Collections.emptyList(), dataFetcher);
        }

        public C3678a(@NonNull Key key, @NonNull List<Key> list, @NonNull DataFetcher<Data> dataFetcher) {
            this.f13999a = (Key) C3770j.m44392d(key);
            this.f14000b = (List) C3770j.m44392d(list);
            this.f14001c = (DataFetcher) C3770j.m44392d(dataFetcher);
        }
    }

    /* renamed from: a */
    boolean mo45004a(@NonNull Model model);

    @Nullable
    /* renamed from: b */
    C3678a<Data> mo45003b(@NonNull Model model, int i, int i2, @NonNull Options options);
}
