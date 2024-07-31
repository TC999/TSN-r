package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;

/* renamed from: com.bumptech.glide.load.engine.u */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface Resource<Z> {
    @NonNull
    /* renamed from: b */
    Class<Z> mo2883b();

    @NonNull
    Z get();

    int getSize();

    void recycle();
}
