package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.C3770j;
import com.bumptech.glide.util.C3771k;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.resource.bitmap.x */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class RoundedCorners extends BitmapTransformation {

    /* renamed from: d */
    private static final String f14167d = "com.bumptech.glide.load.resource.bitmap.RoundedCorners";

    /* renamed from: e */
    private static final byte[] f14168e = f14167d.getBytes(Key.f13470b);

    /* renamed from: c */
    private final int f14169c;

    public RoundedCorners(int i) {
        C3770j.m44395a(i > 0, "roundingRadius must be greater than 0.");
        this.f14169c = i;
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: b */
    public void mo44432b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f14168e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f14169c).array());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    /* renamed from: c */
    protected Bitmap mo44906c(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        return TransformationUtils.m44886p(bitmapPool, bitmap, this.f14169c);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return (obj instanceof RoundedCorners) && this.f14169c == ((RoundedCorners) obj).f14169c;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return C3771k.m44376o(-569625254, C3771k.m44377n(this.f14169c));
    }
}
