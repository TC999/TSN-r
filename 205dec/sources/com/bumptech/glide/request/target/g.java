package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DrawableImageViewTarget.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class g extends j<Drawable> {
    public g(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.j
    /* renamed from: w */
    public void u(@Nullable Drawable drawable) {
        ((ImageView) this.f18008b).setImageDrawable(drawable);
    }

    @Deprecated
    public g(ImageView imageView, boolean z3) {
        super(imageView, z3);
    }
}
