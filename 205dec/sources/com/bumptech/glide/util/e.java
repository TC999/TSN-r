package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.g;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: FixedPreloadSizeProvider.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class e<T> implements g.b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f18068a;

    public e(int i4, int i5) {
        this.f18068a = new int[]{i4, i5};
    }

    @Override // com.bumptech.glide.g.b
    @Nullable
    public int[] a(@NonNull T t3, int i4, int i5) {
        return this.f18068a;
    }
}
