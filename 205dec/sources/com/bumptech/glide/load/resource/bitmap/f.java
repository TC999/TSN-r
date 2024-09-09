package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BitmapResource.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class f implements com.bumptech.glide.load.engine.u<Bitmap>, com.bumptech.glide.load.engine.q {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap f17405a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f17406b;

    public f(@NonNull Bitmap bitmap, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        this.f17405a = (Bitmap) com.bumptech.glide.util.j.e(bitmap, "Bitmap must not be null");
        this.f17406b = (com.bumptech.glide.load.engine.bitmap_recycle.e) com.bumptech.glide.util.j.e(eVar, "BitmapPool must not be null");
    }

    @Nullable
    public static f d(@Nullable Bitmap bitmap, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new f(bitmap, eVar);
    }

    @Override // com.bumptech.glide.load.engine.q
    public void a() {
        this.f17405a.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<Bitmap> b() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    /* renamed from: c */
    public Bitmap get() {
        return this.f17405a;
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return com.bumptech.glide.util.k.h(this.f17405a);
    }

    @Override // com.bumptech.glide.load.engine.u
    public void recycle() {
        this.f17406b.d(this.f17405a);
    }
}
