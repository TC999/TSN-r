package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LruPoolStrategy.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
interface l {
    String a(Bitmap bitmap);

    String b(int i4, int i5, Bitmap.Config config);

    int c(Bitmap bitmap);

    void d(Bitmap bitmap);

    @Nullable
    Bitmap e(int i4, int i5, Bitmap.Config config);

    @Nullable
    Bitmap removeLast();
}
