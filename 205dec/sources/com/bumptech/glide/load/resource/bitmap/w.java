package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: Rotate.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class w extends g {

    /* renamed from: d  reason: collision with root package name */
    private static final String f17481d = "com.bumptech.glide.load.resource.bitmap.Rotate";

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f17482e = "com.bumptech.glide.load.resource.bitmap.Rotate".getBytes(com.bumptech.glide.load.c.f16793b);

    /* renamed from: c  reason: collision with root package name */
    private final int f17483c;

    public w(int i4) {
        this.f17483c = i4;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f17482e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f17483c).array());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.g
    protected Bitmap c(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i4, int i5) {
        return z.n(bitmap, this.f17483c);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        return (obj instanceof w) && this.f17483c == ((w) obj).f17483c;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return com.bumptech.glide.util.k.o(-950519196, com.bumptech.glide.util.k.n(this.f17483c));
    }
}
