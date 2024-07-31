package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

/* renamed from: com.bumptech.glide.load.resource.gif.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class GifFrameResourceDecoder implements ResourceDecoder<GifDecoder, Bitmap> {

    /* renamed from: a */
    private final BitmapPool f14243a;

    public GifFrameResourceDecoder(BitmapPool bitmapPool) {
        this.f14243a = bitmapPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: c */
    public Resource<Bitmap> mo2813b(@NonNull GifDecoder gifDecoder, int i, int i2, @NonNull Options options) {
        return BitmapResource.m44977d(gifDecoder.mo45596a(), this.f14243a);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: d */
    public boolean mo2814a(@NonNull GifDecoder gifDecoder, @NonNull Options options) {
        return true;
    }
}
