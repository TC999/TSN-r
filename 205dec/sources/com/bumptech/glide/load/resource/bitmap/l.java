package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: CircleCrop.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class l extends g {

    /* renamed from: c  reason: collision with root package name */
    private static final int f17412c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final String f17413d = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1";

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f17414e = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".getBytes(com.bumptech.glide.load.c.f16793b);

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f17414e);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.g
    protected Bitmap c(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i4, int i5) {
        return z.d(eVar, bitmap, i4, i5);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        return obj instanceof l;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return 1101716364;
    }
}
