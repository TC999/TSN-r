package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.C3771k;

/* renamed from: com.bumptech.glide.load.resource.bitmap.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class BitmapTransformation implements Transformation<Bitmap> {
    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    /* renamed from: a */
    public final Resource<Bitmap> mo44823a(@NonNull Context context, @NonNull Resource<Bitmap> resource, int i, int i2) {
        if (C3771k.m44369v(i, i2)) {
            BitmapPool m45741g = Glide.m45744d(context).m45741g();
            Bitmap bitmap = resource.get();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            Bitmap mo44906c = mo44906c(m45741g, bitmap, i, i2);
            return bitmap.equals(mo44906c) ? resource : BitmapResource.m44977d(mo44906c, m45741g);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    /* renamed from: c */
    protected abstract Bitmap mo44906c(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2);
}
