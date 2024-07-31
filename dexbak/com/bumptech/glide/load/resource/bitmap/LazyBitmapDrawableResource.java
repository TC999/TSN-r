package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.C3770j;

/* renamed from: com.bumptech.glide.load.resource.bitmap.t */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class LazyBitmapDrawableResource implements Resource<BitmapDrawable>, Initializable {

    /* renamed from: a */
    private final Resources f14154a;

    /* renamed from: b */
    private final Resource<Bitmap> f14155b;

    private LazyBitmapDrawableResource(@NonNull Resources resources, @NonNull Resource<Bitmap> resource) {
        this.f14154a = (Resources) C3770j.m44392d(resources);
        this.f14155b = (Resource) C3770j.m44392d(resource);
    }

    @Nullable
    /* renamed from: d */
    public static Resource<BitmapDrawable> m44915d(@NonNull Resources resources, @Nullable Resource<Bitmap> resource) {
        if (resource == null) {
            return null;
        }
        return new LazyBitmapDrawableResource(resources, resource);
    }

    @Deprecated
    /* renamed from: e */
    public static LazyBitmapDrawableResource m44914e(Context context, Bitmap bitmap) {
        return (LazyBitmapDrawableResource) m44915d(context.getResources(), BitmapResource.m44977d(bitmap, Glide.m45744d(context).m45741g()));
    }

    @Deprecated
    /* renamed from: f */
    public static LazyBitmapDrawableResource m44913f(Resources resources, BitmapPool bitmapPool, Bitmap bitmap) {
        return (LazyBitmapDrawableResource) m44915d(resources, BitmapResource.m44977d(bitmap, bitmapPool));
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    /* renamed from: a */
    public void mo44824a() {
        Resource<Bitmap> resource = this.f14155b;
        if (resource instanceof Initializable) {
            ((Initializable) resource).mo44824a();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: b */
    public Class<BitmapDrawable> mo2883b() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: c */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f14154a, this.f14155b.get());
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.f14155b.getSize();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        this.f14155b.recycle();
    }
}
