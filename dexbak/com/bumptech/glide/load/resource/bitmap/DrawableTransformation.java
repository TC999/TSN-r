package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.resource.bitmap.p */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DrawableTransformation implements Transformation<Drawable> {

    /* renamed from: c */
    private final Transformation<Bitmap> f14143c;

    /* renamed from: d */
    private final boolean f14144d;

    public DrawableTransformation(Transformation<Bitmap> transformation, boolean z) {
        this.f14143c = transformation;
        this.f14144d = z;
    }

    /* renamed from: d */
    private Resource<Drawable> m44922d(Context context, Resource<Bitmap> resource) {
        return LazyBitmapDrawableResource.m44915d(context.getResources(), resource);
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    /* renamed from: a */
    public Resource<Drawable> mo44823a(@NonNull Context context, @NonNull Resource<Drawable> resource, int i, int i2) {
        BitmapPool m45741g = Glide.m45744d(context).m45741g();
        Drawable drawable = resource.get();
        Resource<Bitmap> m44926a = DrawableToBitmapConverter.m44926a(m45741g, drawable, i, i2);
        if (m44926a == null) {
            if (this.f14144d) {
                throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
            }
            return resource;
        }
        Resource<Bitmap> mo44823a = this.f14143c.mo44823a(context, m44926a, i, i2);
        if (mo44823a.equals(m44926a)) {
            mo44823a.recycle();
            return resource;
        }
        return m44922d(context, mo44823a);
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: b */
    public void mo44432b(@NonNull MessageDigest messageDigest) {
        this.f14143c.mo44432b(messageDigest);
    }

    /* renamed from: c */
    public Transformation<BitmapDrawable> m44923c() {
        return this;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof DrawableTransformation) {
            return this.f14143c.equals(((DrawableTransformation) obj).f14143c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f14143c.hashCode();
    }
}
