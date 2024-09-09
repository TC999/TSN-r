package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RoundedCorners.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class x extends g {

    /* renamed from: d  reason: collision with root package name */
    private static final String f17484d = "com.bumptech.glide.load.resource.bitmap.RoundedCorners";

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f17485e = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(com.bumptech.glide.load.c.f16793b);

    /* renamed from: c  reason: collision with root package name */
    private final int f17486c;

    public x(int i4) {
        com.bumptech.glide.util.j.a(i4 > 0, "roundingRadius must be greater than 0.");
        this.f17486c = i4;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f17485e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f17486c).array());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.g
    protected Bitmap c(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i4, int i5) {
        return z.p(eVar, bitmap, this.f17486c);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        return (obj instanceof x) && this.f17486c == ((x) obj).f17486c;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return com.bumptech.glide.util.k.o(-569625254, com.bumptech.glide.util.k.n(this.f17486c));
    }
}
