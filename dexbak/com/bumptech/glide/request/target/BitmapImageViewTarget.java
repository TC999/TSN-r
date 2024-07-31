package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* renamed from: com.bumptech.glide.request.target.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BitmapImageViewTarget extends ImageViewTarget<Bitmap> {
    public BitmapImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.ImageViewTarget
    /* renamed from: w */
    public void mo44480u(Bitmap bitmap) {
        ((ImageView) this.f14490b).setImageBitmap(bitmap);
    }

    @Deprecated
    public BitmapImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
