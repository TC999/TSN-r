package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ResourceBitmapDecoder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class v implements com.bumptech.glide.load.g<Uri, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.resource.drawable.e f17479a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f17480b;

    public v(com.bumptech.glide.load.resource.drawable.e eVar, com.bumptech.glide.load.engine.bitmap_recycle.e eVar2) {
        this.f17479a = eVar;
        this.f17480b = eVar2;
    }

    @Override // com.bumptech.glide.load.g
    @Nullable
    /* renamed from: c */
    public com.bumptech.glide.load.engine.u<Bitmap> b(@NonNull Uri uri, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) {
        com.bumptech.glide.load.engine.u<Drawable> b4 = this.f17479a.b(uri, i4, i5, fVar);
        if (b4 == null) {
            return null;
        }
        return o.a(this.f17480b, b4.get(), i4, i5);
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: d */
    public boolean a(@NonNull Uri uri, @NonNull com.bumptech.glide.load.f fVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
