package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BitmapDrawableResource.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class c extends com.bumptech.glide.load.resource.drawable.b<BitmapDrawable> implements com.bumptech.glide.load.engine.q {

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f17388b;

    public c(BitmapDrawable bitmapDrawable, com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        super(bitmapDrawable);
        this.f17388b = eVar;
    }

    @Override // com.bumptech.glide.load.resource.drawable.b, com.bumptech.glide.load.engine.q
    public void a() {
        ((BitmapDrawable) this.f17500a).getBitmap().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<BitmapDrawable> b() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return com.bumptech.glide.util.k.h(((BitmapDrawable) this.f17500a).getBitmap());
    }

    @Override // com.bumptech.glide.load.engine.u
    public void recycle() {
        this.f17388b.d(((BitmapDrawable) this.f17500a).getBitmap());
    }
}
