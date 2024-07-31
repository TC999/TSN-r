package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BitmapPoolAdapter implements BitmapPool {
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    /* renamed from: a */
    public void mo45376a(int i) {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    /* renamed from: b */
    public void mo45375b() {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    /* renamed from: c */
    public void mo45374c(float f) {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    /* renamed from: d */
    public void mo44924d(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    /* renamed from: e */
    public Bitmap mo45373e(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    @NonNull
    /* renamed from: f */
    public Bitmap mo45372f(int i, int i2, Bitmap.Config config) {
        return mo45373e(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
    public long getMaxSize() {
        return 0L;
    }
}
