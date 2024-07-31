package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.C3770j;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.resource.bitmap.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BitmapDrawableDecoder<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {

    /* renamed from: a */
    private final ResourceDecoder<DataType, Bitmap> f14066a;

    /* renamed from: b */
    private final Resources f14067b;

    public BitmapDrawableDecoder(Context context, ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this(context.getResources(), resourceDecoder);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: a */
    public boolean mo2814a(@NonNull DataType datatype, @NonNull Options options) throws IOException {
        return this.f14066a.mo2814a(datatype, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: b */
    public Resource<BitmapDrawable> mo2813b(@NonNull DataType datatype, int i, int i2, @NonNull Options options) throws IOException {
        return LazyBitmapDrawableResource.m44915d(this.f14067b, this.f14066a.mo2813b(datatype, i, i2, options));
    }

    @Deprecated
    public BitmapDrawableDecoder(Resources resources, BitmapPool bitmapPool, ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this(resources, resourceDecoder);
    }

    public BitmapDrawableDecoder(@NonNull Resources resources, @NonNull ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this.f14067b = (Resources) C3770j.m44392d(resources);
        this.f14066a = (ResourceDecoder) C3770j.m44392d(resourceDecoder);
    }
}
