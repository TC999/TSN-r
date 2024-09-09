package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: NonOwnedDrawableResource.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
final class d extends b<Drawable> {
    private d(Drawable drawable) {
        super(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static u<Drawable> d(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new d(drawable);
        }
        return null;
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<Drawable> b() {
        return this.f17500a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return Math.max(1, this.f17500a.getIntrinsicWidth() * this.f17500a.getIntrinsicHeight() * 4);
    }

    @Override // com.bumptech.glide.load.engine.u
    public void recycle() {
    }
}
