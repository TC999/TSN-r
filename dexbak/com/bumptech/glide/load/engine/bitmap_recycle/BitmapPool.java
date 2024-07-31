package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface BitmapPool {
    /* renamed from: a */
    void mo45376a(int i);

    /* renamed from: b */
    void mo45375b();

    /* renamed from: c */
    void mo45374c(float f);

    /* renamed from: d */
    void mo44924d(Bitmap bitmap);

    @NonNull
    /* renamed from: e */
    Bitmap mo45373e(int i, int i2, Bitmap.Config config);

    @NonNull
    /* renamed from: f */
    Bitmap mo45372f(int i, int i2, Bitmap.Config config);

    long getMaxSize();
}
