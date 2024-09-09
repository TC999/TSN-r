package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BitmapTransformation.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class g implements com.bumptech.glide.load.i<Bitmap> {
    @Override // com.bumptech.glide.load.i
    @NonNull
    public final com.bumptech.glide.load.engine.u<Bitmap> a(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.u<Bitmap> uVar, int i4, int i5) {
        if (com.bumptech.glide.util.k.v(i4, i5)) {
            com.bumptech.glide.load.engine.bitmap_recycle.e g4 = com.bumptech.glide.d.d(context).g();
            Bitmap bitmap = uVar.get();
            if (i4 == Integer.MIN_VALUE) {
                i4 = bitmap.getWidth();
            }
            if (i5 == Integer.MIN_VALUE) {
                i5 = bitmap.getHeight();
            }
            Bitmap c4 = c(g4, bitmap, i4, i5);
            return bitmap.equals(c4) ? uVar : f.d(c4, g4);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i4 + " or height: " + i5 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    protected abstract Bitmap c(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i4, int i5);
}
