package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BitmapImageViewTarget.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class c extends j<Bitmap> {
    public c(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.j
    /* renamed from: w */
    public void u(Bitmap bitmap) {
        ((ImageView) this.f18008b).setImageBitmap(bitmap);
    }

    @Deprecated
    public c(ImageView imageView, boolean z3) {
        super(imageView, z3);
    }
}
