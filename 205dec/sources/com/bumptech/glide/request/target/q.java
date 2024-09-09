package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ThumbnailImageViewTarget.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class q<T> extends j<T> {
    public q(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.request.target.j
    protected void u(@Nullable T t3) {
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.f18008b).getLayoutParams();
        Drawable w3 = w(t3);
        if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
            w3 = new i(w3, layoutParams.width, layoutParams.height);
        }
        ((ImageView) this.f18008b).setImageDrawable(w3);
    }

    protected abstract Drawable w(T t3);

    @Deprecated
    public q(ImageView imageView, boolean z3) {
        super(imageView, z3);
    }
}
