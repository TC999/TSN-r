package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.C3770j;
import java.security.MessageDigest;

@Deprecated
/* renamed from: com.bumptech.glide.load.resource.bitmap.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BitmapDrawableTransformation implements Transformation<BitmapDrawable> {

    /* renamed from: c */
    private final Transformation<Drawable> f14083c;

    public BitmapDrawableTransformation(Transformation<Bitmap> transformation) {
        this.f14083c = (Transformation) C3770j.m44392d(new DrawableTransformation(transformation, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    private static Resource<BitmapDrawable> m44982c(Resource<Drawable> resource) {
        if (resource.get() instanceof BitmapDrawable) {
            return resource;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + resource.get());
    }

    /* renamed from: d */
    private static Resource<Drawable> m44981d(Resource<BitmapDrawable> resource) {
        return resource;
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    /* renamed from: a */
    public Resource<BitmapDrawable> mo44823a(@NonNull Context context, @NonNull Resource<BitmapDrawable> resource, int i, int i2) {
        return m44982c(this.f14083c.mo44823a(context, m44981d(resource), i, i2));
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: b */
    public void mo44432b(@NonNull MessageDigest messageDigest) {
        this.f14083c.mo44432b(messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof BitmapDrawableTransformation) {
            return this.f14083c.equals(((BitmapDrawableTransformation) obj).f14083c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f14083c.hashCode();
    }
}
