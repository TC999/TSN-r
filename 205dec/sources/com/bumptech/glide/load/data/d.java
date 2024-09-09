package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DataFetcher.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface d<T> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DataFetcher.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a<T> {
        void c(@NonNull Exception exc);

        void e(@Nullable T t3);
    }

    @NonNull
    Class<T> a();

    void b();

    void cancel();

    void d(@NonNull Priority priority, @NonNull a<? super T> aVar);

    @NonNull
    DataSource getDataSource();
}
