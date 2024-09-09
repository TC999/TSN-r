package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BitmapPoolAdapter.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class f implements e {
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void a(int i4) {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void c(float f4) {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void d(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap e(int i4, int i5, Bitmap.Config config) {
        return Bitmap.createBitmap(i4, i5, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    @NonNull
    public Bitmap f(int i4, int i5, Bitmap.Config config) {
        return e(i4, i5, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public long getMaxSize() {
        return 0L;
    }
}
