package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.C3770j;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.resource.gif.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GifDrawableTransformation implements Transformation<GifDrawable> {

    /* renamed from: c */
    private final Transformation<Bitmap> f14219c;

    public GifDrawableTransformation(Transformation<Bitmap> transformation) {
        this.f14219c = (Transformation) C3770j.m44392d(transformation);
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    /* renamed from: a */
    public Resource<GifDrawable> mo44823a(@NonNull Context context, @NonNull Resource<GifDrawable> resource, int i, int i2) {
        GifDrawable gifDrawable = resource.get();
        Resource<Bitmap> bitmapResource = new BitmapResource(gifDrawable.m44856e(), Glide.m45744d(context).m45741g());
        Resource<Bitmap> mo44823a = this.f14219c.mo44823a(context, bitmapResource, i, i2);
        if (!bitmapResource.equals(mo44823a)) {
            bitmapResource.recycle();
        }
        gifDrawable.m44846o(this.f14219c, mo44823a.get());
        return resource;
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: b */
    public void mo44432b(@NonNull MessageDigest messageDigest) {
        this.f14219c.mo44432b(messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof GifDrawableTransformation) {
            return this.f14219c.equals(((GifDrawableTransformation) obj).f14219c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f14219c.hashCode();
    }
}
