package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;

/* renamed from: com.bumptech.glide.load.resource.drawable.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class UnitDrawableDecoder implements ResourceDecoder<Drawable, Drawable> {
    @Override // com.bumptech.glide.load.ResourceDecoder
    @Nullable
    /* renamed from: c */
    public Resource<Drawable> mo2813b(@NonNull Drawable drawable, int i, int i2, @NonNull Options options) {
        return NonOwnedDrawableResource.m44868d(drawable);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: d */
    public boolean mo2814a(@NonNull Drawable drawable, @NonNull Options options) {
        return true;
    }
}
