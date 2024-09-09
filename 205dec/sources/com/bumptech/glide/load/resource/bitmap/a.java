package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BitmapDrawableDecoder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class a<DataType> implements com.bumptech.glide.load.g<DataType, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.g<DataType, Bitmap> f17383a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f17384b;

    public a(Context context, com.bumptech.glide.load.g<DataType, Bitmap> gVar) {
        this(context.getResources(), gVar);
    }

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull DataType datatype, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return this.f17383a.a(datatype, fVar);
    }

    @Override // com.bumptech.glide.load.g
    public com.bumptech.glide.load.engine.u<BitmapDrawable> b(@NonNull DataType datatype, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return t.d(this.f17384b, this.f17383a.b(datatype, i4, i5, fVar));
    }

    @Deprecated
    public a(Resources resources, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.load.g<DataType, Bitmap> gVar) {
        this(resources, gVar);
    }

    public a(@NonNull Resources resources, @NonNull com.bumptech.glide.load.g<DataType, Bitmap> gVar) {
        this.f17384b = (Resources) com.bumptech.glide.util.j.d(resources);
        this.f17383a = (com.bumptech.glide.load.g) com.bumptech.glide.util.j.d(gVar);
    }
}
