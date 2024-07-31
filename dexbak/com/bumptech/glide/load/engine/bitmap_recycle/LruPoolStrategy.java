package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

/* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
interface LruPoolStrategy {
    /* renamed from: a */
    String mo45350a(Bitmap bitmap);

    /* renamed from: b */
    String mo45349b(int i, int i2, Bitmap.Config config);

    /* renamed from: c */
    int mo45348c(Bitmap bitmap);

    /* renamed from: d */
    void mo45347d(Bitmap bitmap);

    @Nullable
    /* renamed from: e */
    Bitmap mo45346e(int i, int i2, Bitmap.Config config);

    @Nullable
    Bitmap removeLast();
}
