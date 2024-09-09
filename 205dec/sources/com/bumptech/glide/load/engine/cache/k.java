package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.cache.j;
import com.bumptech.glide.load.engine.u;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: MemoryCacheAdapter.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class k implements j {

    /* renamed from: a  reason: collision with root package name */
    private j.a f16975a;

    @Override // com.bumptech.glide.load.engine.cache.j
    public void a(int i4) {
    }

    @Override // com.bumptech.glide.load.engine.cache.j
    public void b() {
    }

    @Override // com.bumptech.glide.load.engine.cache.j
    public void c(float f4) {
    }

    @Override // com.bumptech.glide.load.engine.cache.j
    @Nullable
    public u<?> d(@NonNull com.bumptech.glide.load.c cVar, @Nullable u<?> uVar) {
        if (uVar != null) {
            this.f16975a.a(uVar);
            return null;
        }
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.j
    @Nullable
    public u<?> e(@NonNull com.bumptech.glide.load.c cVar) {
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.j
    public void f(@NonNull j.a aVar) {
        this.f16975a = aVar;
    }

    @Override // com.bumptech.glide.load.engine.cache.j
    public long getCurrentSize() {
        return 0L;
    }

    @Override // com.bumptech.glide.load.engine.cache.j
    public long getMaxSize() {
        return 0L;
    }
}
