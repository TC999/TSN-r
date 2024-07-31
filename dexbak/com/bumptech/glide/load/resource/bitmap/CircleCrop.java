package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.resource.bitmap.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CircleCrop extends BitmapTransformation {

    /* renamed from: c */
    private static final int f14095c = 1;

    /* renamed from: d */
    private static final String f14096d = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1";

    /* renamed from: e */
    private static final byte[] f14097e = f14096d.getBytes(Key.f13470b);

    @Override // com.bumptech.glide.load.Key
    /* renamed from: b */
    public void mo44432b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f14097e);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    /* renamed from: c */
    protected Bitmap mo44906c(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        return TransformationUtils.m44898d(bitmapPool, bitmap, i, i2);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return obj instanceof CircleCrop;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return 1101716364;
    }
}
