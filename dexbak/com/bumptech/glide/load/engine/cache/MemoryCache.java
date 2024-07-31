package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

/* renamed from: com.bumptech.glide.load.engine.cache.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface MemoryCache {

    /* compiled from: MemoryCache.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.j$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3603a {
        /* renamed from: a */
        void mo45217a(@NonNull Resource<?> resource);
    }

    /* renamed from: a */
    void mo45322a(int i);

    /* renamed from: b */
    void mo45321b();

    /* renamed from: c */
    void mo45320c(float f);

    @Nullable
    /* renamed from: d */
    Resource<?> mo45319d(@NonNull Key key, @Nullable Resource<?> resource);

    @Nullable
    /* renamed from: e */
    Resource<?> mo45318e(@NonNull Key key);

    /* renamed from: f */
    void mo45317f(@NonNull InterfaceC3603a interfaceC3603a);

    long getCurrentSize();

    long getMaxSize();
}
