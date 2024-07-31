package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.ListPreloader;

/* renamed from: com.bumptech.glide.util.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FixedPreloadSizeProvider<T> implements ListPreloader.InterfaceC3551b<T> {

    /* renamed from: a */
    private final int[] f14550a;

    public FixedPreloadSizeProvider(int i, int i2) {
        this.f14550a = new int[]{i, i2};
    }

    @Override // com.bumptech.glide.ListPreloader.InterfaceC3551b
    @Nullable
    /* renamed from: a */
    public int[] mo44367a(@NonNull T t, int i, int i2) {
        return this.f14550a;
    }
}
