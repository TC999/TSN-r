package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BitmapDrawableEncoder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class b implements com.bumptech.glide.load.h<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f17386a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.h<Bitmap> f17387b;

    public b(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.load.h<Bitmap> hVar) {
        this.f17386a = eVar;
        this.f17387b = hVar;
    }

    @Override // com.bumptech.glide.load.h
    @NonNull
    public EncodeStrategy b(@NonNull com.bumptech.glide.load.f fVar) {
        return this.f17387b.b(fVar);
    }

    @Override // com.bumptech.glide.load.a
    /* renamed from: c */
    public boolean a(@NonNull com.bumptech.glide.load.engine.u<BitmapDrawable> uVar, @NonNull File file, @NonNull com.bumptech.glide.load.f fVar) {
        return this.f17387b.a(new f(uVar.get().getBitmap(), this.f17386a), file, fVar);
    }
}
