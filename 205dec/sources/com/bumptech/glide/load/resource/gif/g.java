package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.u;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: GifFrameResourceDecoder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class g implements com.bumptech.glide.load.g<GifDecoder, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f17560a;

    public g(com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        this.f17560a = eVar;
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: c */
    public u<Bitmap> b(@NonNull GifDecoder gifDecoder, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) {
        return com.bumptech.glide.load.resource.bitmap.f.d(gifDecoder.a(), this.f17560a);
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: d */
    public boolean a(@NonNull GifDecoder gifDecoder, @NonNull com.bumptech.glide.load.f fVar) {
        return true;
    }
}
