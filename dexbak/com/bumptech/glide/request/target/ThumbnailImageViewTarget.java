package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* renamed from: com.bumptech.glide.request.target.q */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class ThumbnailImageViewTarget<T> extends ImageViewTarget<T> {
    public ThumbnailImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget
    /* renamed from: u */
    protected void mo44480u(@Nullable T t) {
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.f14490b).getLayoutParams();
        Drawable mo44479w = mo44479w(t);
        if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
            mo44479w = new FixedSizeDrawable(mo44479w, layoutParams.width, layoutParams.height);
        }
        ((ImageView) this.f14490b).setImageDrawable(mo44479w);
    }

    /* renamed from: w */
    protected abstract Drawable mo44479w(T t);

    @Deprecated
    public ThumbnailImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
