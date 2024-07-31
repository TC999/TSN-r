package com.bumptech.glide.load.resource;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.C3770j;

/* renamed from: com.bumptech.glide.load.resource.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SimpleResource<T> implements Resource<T> {

    /* renamed from: a */
    protected final T f14056a;

    public SimpleResource(@NonNull T t) {
        this.f14056a = (T) C3770j.m44392d(t);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: b */
    public Class<T> mo2883b() {
        return (Class<T>) this.f14056a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public final T get() {
        return this.f14056a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }
}
