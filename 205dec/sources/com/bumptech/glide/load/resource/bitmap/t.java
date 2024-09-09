package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LazyBitmapDrawableResource.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class t implements com.bumptech.glide.load.engine.u<BitmapDrawable>, com.bumptech.glide.load.engine.q {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f17471a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.u<Bitmap> f17472b;

    private t(@NonNull Resources resources, @NonNull com.bumptech.glide.load.engine.u<Bitmap> uVar) {
        this.f17471a = (Resources) com.bumptech.glide.util.j.d(resources);
        this.f17472b = (com.bumptech.glide.load.engine.u) com.bumptech.glide.util.j.d(uVar);
    }

    @Nullable
    public static com.bumptech.glide.load.engine.u<BitmapDrawable> d(@NonNull Resources resources, @Nullable com.bumptech.glide.load.engine.u<Bitmap> uVar) {
        if (uVar == null) {
            return null;
        }
        return new t(resources, uVar);
    }

    @Deprecated
    public static t e(Context context, Bitmap bitmap) {
        return (t) d(context.getResources(), f.d(bitmap, com.bumptech.glide.d.d(context).g()));
    }

    @Deprecated
    public static t f(Resources resources, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) {
        return (t) d(resources, f.d(bitmap, eVar));
    }

    @Override // com.bumptech.glide.load.engine.q
    public void a() {
        com.bumptech.glide.load.engine.u<Bitmap> uVar = this.f17472b;
        if (uVar instanceof com.bumptech.glide.load.engine.q) {
            ((com.bumptech.glide.load.engine.q) uVar).a();
        }
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<BitmapDrawable> b() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    /* renamed from: c */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f17471a, this.f17472b.get());
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return this.f17472b.getSize();
    }

    @Override // com.bumptech.glide.load.engine.u
    public void recycle() {
        this.f17472b.recycle();
    }
}
