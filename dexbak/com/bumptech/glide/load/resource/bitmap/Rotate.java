package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.C3771k;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.resource.bitmap.w */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Rotate extends BitmapTransformation {

    /* renamed from: d */
    private static final String f14164d = "com.bumptech.glide.load.resource.bitmap.Rotate";

    /* renamed from: e */
    private static final byte[] f14165e = f14164d.getBytes(Key.f13470b);

    /* renamed from: c */
    private final int f14166c;

    public Rotate(int i) {
        this.f14166c = i;
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: b */
    public void mo44432b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f14165e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f14166c).array());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    /* renamed from: c */
    protected Bitmap mo44906c(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        return TransformationUtils.m44888n(bitmap, this.f14166c);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return (obj instanceof Rotate) && this.f14166c == ((Rotate) obj).f14166c;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return C3771k.m44376o(-950519196, C3771k.m44377n(this.f14166c));
    }
}
