package com.bumptech.glide.load.engine;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;

/* renamed from: com.bumptech.glide.load.engine.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
interface DataFetcherGenerator {

    /* compiled from: DataFetcherGenerator.java */
    /* renamed from: com.bumptech.glide.load.engine.f$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3616a {
        /* renamed from: a */
        void mo45130a(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource);

        /* renamed from: d */
        void mo45128d();

        /* renamed from: f */
        void mo45127f(Key key, @Nullable Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2);
    }

    /* renamed from: b */
    boolean mo45129b();

    void cancel();
}
