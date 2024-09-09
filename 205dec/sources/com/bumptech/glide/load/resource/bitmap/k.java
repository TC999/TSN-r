package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: CenterInside.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class k extends g {

    /* renamed from: c  reason: collision with root package name */
    private static final String f17410c = "com.bumptech.glide.load.resource.bitmap.CenterInside";

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f17411d = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(com.bumptech.glide.load.c.f16793b);

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f17411d);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.g
    protected Bitmap c(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i4, int i5) {
        return z.c(eVar, bitmap, i4, i5);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        return obj instanceof k;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return -670243078;
    }
}
