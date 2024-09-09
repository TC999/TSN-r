package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BitmapThumbnailImageViewTarget.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class d extends q<Bitmap> {
    public d(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.q
    /* renamed from: x */
    public Drawable w(Bitmap bitmap) {
        return new BitmapDrawable(((ImageView) this.f18008b).getResources(), bitmap);
    }

    @Deprecated
    public d(ImageView imageView, boolean z3) {
        super(imageView, z3);
    }
}
