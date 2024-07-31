package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;

/* renamed from: com.bumptech.glide.load.resource.bitmap.v */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {

    /* renamed from: a */
    private final ResourceDrawableDecoder f14162a;

    /* renamed from: b */
    private final BitmapPool f14163b;

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder, BitmapPool bitmapPool) {
        this.f14162a = resourceDrawableDecoder;
        this.f14163b = bitmapPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    @Nullable
    /* renamed from: c */
    public Resource<Bitmap> mo2813b(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        Resource<Drawable> mo2813b = this.f14162a.mo2813b(uri, i, i2, options);
        if (mo2813b == null) {
            return null;
        }
        return DrawableToBitmapConverter.m44926a(this.f14163b, mo2813b.get(), i, i2);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: d */
    public boolean mo2814a(@NonNull Uri uri, @NonNull Options options) {
        return "android.resource".equals(uri.getScheme());
    }
}
