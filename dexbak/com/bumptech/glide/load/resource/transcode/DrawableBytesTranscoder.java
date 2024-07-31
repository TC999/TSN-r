package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* renamed from: com.bumptech.glide.load.resource.transcode.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {

    /* renamed from: a */
    private final BitmapPool f14253a;

    /* renamed from: b */
    private final ResourceTranscoder<Bitmap, byte[]> f14254b;

    /* renamed from: c */
    private final ResourceTranscoder<GifDrawable, byte[]> f14255c;

    public DrawableBytesTranscoder(@NonNull BitmapPool bitmapPool, @NonNull ResourceTranscoder<Bitmap, byte[]> resourceTranscoder, @NonNull ResourceTranscoder<GifDrawable, byte[]> resourceTranscoder2) {
        this.f14253a = bitmapPool;
        this.f14254b = resourceTranscoder;
        this.f14255c = resourceTranscoder2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    /* renamed from: b */
    private static Resource<GifDrawable> m44789b(@NonNull Resource<Drawable> resource) {
        return resource;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    @Nullable
    /* renamed from: a */
    public Resource<byte[]> mo44784a(@NonNull Resource<Drawable> resource, @NonNull Options options) {
        Drawable drawable = resource.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f14254b.mo44784a(BitmapResource.m44977d(((BitmapDrawable) drawable).getBitmap(), this.f14253a), options);
        }
        if (drawable instanceof GifDrawable) {
            return this.f14255c.mo44784a(m44789b(resource), options);
        }
        return null;
    }
}
