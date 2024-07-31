package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* renamed from: com.bumptech.glide.load.engine.cache.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DiskCacheAdapter implements DiskCache {

    /* compiled from: DiskCacheAdapter.java */
    /* renamed from: com.bumptech.glide.load.engine.cache.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3594a implements DiskCache.InterfaceC3592a {
        @Override // com.bumptech.glide.load.engine.cache.DiskCache.InterfaceC3592a
        public DiskCache build() {
            return new DiskCacheAdapter();
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    /* renamed from: a */
    public void mo45332a(Key key, DiskCache.InterfaceC3593b interfaceC3593b) {
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    /* renamed from: b */
    public File mo45331b(Key key) {
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void clear() {
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key key) {
    }
}
