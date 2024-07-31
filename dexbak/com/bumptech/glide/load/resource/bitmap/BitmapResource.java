package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.C3770j;
import com.bumptech.glide.util.C3771k;

/* renamed from: com.bumptech.glide.load.resource.bitmap.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BitmapResource implements Resource<Bitmap>, Initializable {

    /* renamed from: a */
    private final Bitmap f14088a;

    /* renamed from: b */
    private final BitmapPool f14089b;

    public BitmapResource(@NonNull Bitmap bitmap, @NonNull BitmapPool bitmapPool) {
        this.f14088a = (Bitmap) C3770j.m44391e(bitmap, "Bitmap must not be null");
        this.f14089b = (BitmapPool) C3770j.m44391e(bitmapPool, "BitmapPool must not be null");
    }

    @Nullable
    /* renamed from: d */
    public static BitmapResource m44977d(@Nullable Bitmap bitmap, @NonNull BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bitmapPool);
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    /* renamed from: a */
    public void mo44824a() {
        this.f14088a.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: b */
    public Class<Bitmap> mo2883b() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: c */
    public Bitmap get() {
        return this.f14088a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return C3771k.m44383h(this.f14088a);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        this.f14089b.mo44924d(this.f14088a);
    }
}
