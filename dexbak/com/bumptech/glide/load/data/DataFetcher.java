package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* renamed from: com.bumptech.glide.load.data.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface DataFetcher<T> {

    /* compiled from: DataFetcher.java */
    /* renamed from: com.bumptech.glide.load.data.d$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3562a<T> {
        /* renamed from: c */
        void mo45052c(@NonNull Exception exc);

        /* renamed from: e */
        void mo45051e(@Nullable T t);
    }

    @NonNull
    /* renamed from: a */
    Class<T> mo45010a();

    /* renamed from: b */
    void mo45009b();

    void cancel();

    /* renamed from: d */
    void mo45008d(@NonNull Priority priority, @NonNull InterfaceC3562a<? super T> interfaceC3562a);

    @NonNull
    DataSource getDataSource();
}
