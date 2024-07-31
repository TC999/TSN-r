package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.File;

/* renamed from: com.bumptech.glide.load.resource.bitmap.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BitmapDrawableEncoder implements ResourceEncoder<BitmapDrawable> {

    /* renamed from: a */
    private final BitmapPool f14069a;

    /* renamed from: b */
    private final ResourceEncoder<Bitmap> f14070b;

    public BitmapDrawableEncoder(BitmapPool bitmapPool, ResourceEncoder<Bitmap> resourceEncoder) {
        this.f14069a = bitmapPool;
        this.f14070b = resourceEncoder;
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    @NonNull
    /* renamed from: b */
    public EncodeStrategy mo44826b(@NonNull Options options) {
        return this.f14070b.mo44826b(options);
    }

    @Override // com.bumptech.glide.load.Encoder
    /* renamed from: c */
    public boolean mo44827a(@NonNull Resource<BitmapDrawable> resource, @NonNull File file, @NonNull Options options) {
        return this.f14070b.mo44827a(new BitmapResource(resource.get().getBitmap(), this.f14069a), file, options);
    }
}
