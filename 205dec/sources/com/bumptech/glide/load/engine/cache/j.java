package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MemoryCache.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface j {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: MemoryCache.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a {
        void a(@NonNull u<?> uVar);
    }

    void a(int i4);

    void b();

    void c(float f4);

    @Nullable
    u<?> d(@NonNull com.bumptech.glide.load.c cVar, @Nullable u<?> uVar);

    @Nullable
    u<?> e(@NonNull com.bumptech.glide.load.c cVar);

    void f(@NonNull a aVar);

    long getCurrentSize();

    long getMaxSize();
}
