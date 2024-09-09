package com.bumptech.glide.load.engine;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DataFetcherGenerator.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
interface f {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DataFetcherGenerator.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a {
        void a(com.bumptech.glide.load.c cVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource);

        void d();

        void f(com.bumptech.glide.load.c cVar, @Nullable Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.c cVar2);
    }

    boolean b();

    void cancel();
}
