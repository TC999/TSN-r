package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BitmapPool.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface e {
    void a(int i4);

    void b();

    void c(float f4);

    void d(Bitmap bitmap);

    @NonNull
    Bitmap e(int i4, int i5, Bitmap.Config config);

    @NonNull
    Bitmap f(int i4, int i5, Bitmap.Config config);

    long getMaxSize();
}
