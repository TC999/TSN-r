package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.C3771k;

/* renamed from: com.bumptech.glide.load.resource.bitmap.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BitmapDrawableResource extends DrawableResource<BitmapDrawable> implements Initializable {

    /* renamed from: b */
    private final BitmapPool f14071b;

    public BitmapDrawableResource(BitmapDrawable bitmapDrawable, BitmapPool bitmapPool) {
        super(bitmapDrawable);
        this.f14071b = bitmapPool;
    }

    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
    /* renamed from: a */
    public void mo44824a() {
        ((BitmapDrawable) this.f14183a).getBitmap().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: b */
    public Class<BitmapDrawable> mo2883b() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return C3771k.m44383h(((BitmapDrawable) this.f14183a).getBitmap());
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        this.f14071b.mo44924d(((BitmapDrawable) this.f14183a).getBitmap());
    }
}
