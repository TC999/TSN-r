package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DrawableBytesTranscoder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class c implements e<Drawable, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f17570a;

    /* renamed from: b  reason: collision with root package name */
    private final e<Bitmap, byte[]> f17571b;

    /* renamed from: c  reason: collision with root package name */
    private final e<GifDrawable, byte[]> f17572c;

    public c(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @NonNull e<Bitmap, byte[]> eVar2, @NonNull e<GifDrawable, byte[]> eVar3) {
        this.f17570a = eVar;
        this.f17571b = eVar2;
        this.f17572c = eVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private static u<GifDrawable> b(@NonNull u<Drawable> uVar) {
        return uVar;
    }

    @Override // com.bumptech.glide.load.resource.transcode.e
    @Nullable
    public u<byte[]> a(@NonNull u<Drawable> uVar, @NonNull com.bumptech.glide.load.f fVar) {
        Drawable drawable = uVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f17571b.a(com.bumptech.glide.load.resource.bitmap.f.d(((BitmapDrawable) drawable).getBitmap(), this.f17570a), fVar);
        }
        if (drawable instanceof GifDrawable) {
            return this.f17572c.a(b(uVar), fVar);
        }
        return null;
    }
}
