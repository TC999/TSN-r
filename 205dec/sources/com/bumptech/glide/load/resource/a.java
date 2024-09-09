package com.bumptech.glide.load.resource;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.util.j;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SimpleResource.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class a<T> implements u<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final T f17373a;

    public a(@NonNull T t3) {
        this.f17373a = (T) j.d(t3);
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<T> b() {
        return (Class<T>) this.f17373a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public final T get() {
        return this.f17373a;
    }

    @Override // com.bumptech.glide.load.engine.u
    public final int getSize() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.u
    public void recycle() {
    }
}
