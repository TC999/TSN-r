package com.bumptech.glide.load.engine.cache;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.util.C3769g;

/* renamed from: com.bumptech.glide.load.engine.cache.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LruResourceCache extends C3769g<Key, Resource<?>> implements MemoryCache {

    /* renamed from: e */
    private MemoryCache.InterfaceC3603a f13651e;

    public LruResourceCache(long j) {
        super(j);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public void mo45322a(int i) {
        if (i >= 40) {
            m44410b();
        } else if (i >= 20 || i == 15) {
            m44400o(getMaxSize() / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    @Nullable
    /* renamed from: d */
    public /* bridge */ /* synthetic */ Resource mo45319d(@NonNull Key key, @Nullable Resource resource) {
        return (Resource) super.m44402m(key, resource);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    @Nullable
    /* renamed from: e */
    public /* bridge */ /* synthetic */ Resource mo45318e(@NonNull Key key) {
        return (Resource) super.m44401n(key);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    /* renamed from: f */
    public void mo45317f(@NonNull MemoryCache.InterfaceC3603a interfaceC3603a) {
        this.f13651e = interfaceC3603a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.C3769g
    /* renamed from: p */
    public int mo44404k(@Nullable Resource<?> resource) {
        if (resource == null) {
            return super.mo44404k(null);
        }
        return resource.getSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.C3769g
    /* renamed from: q */
    public void mo44403l(@NonNull Key key, @Nullable Resource<?> resource) {
        MemoryCache.InterfaceC3603a interfaceC3603a = this.f13651e;
        if (interfaceC3603a == null || resource == null) {
            return;
        }
        interfaceC3603a.mo45217a(resource);
    }
}
