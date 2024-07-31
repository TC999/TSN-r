package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;

/* renamed from: com.bumptech.glide.load.engine.cache.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MemoryCacheAdapter implements MemoryCache {

    /* renamed from: a */
    private MemoryCache.InterfaceC3603a f13652a;

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    /* renamed from: a */
    public void mo45322a(int i) {
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    /* renamed from: b */
    public void mo45321b() {
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    /* renamed from: c */
    public void mo45320c(float f) {
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    @Nullable
    /* renamed from: d */
    public Resource<?> mo45319d(@NonNull Key key, @Nullable Resource<?> resource) {
        if (resource != null) {
            this.f13652a.mo45217a(resource);
            return null;
        }
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    @Nullable
    /* renamed from: e */
    public Resource<?> mo45318e(@NonNull Key key) {
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    /* renamed from: f */
    public void mo45317f(@NonNull MemoryCache.InterfaceC3603a interfaceC3603a) {
        this.f13652a = interfaceC3603a;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public long getCurrentSize() {
        return 0L;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public long getMaxSize() {
        return 0L;
    }
}
