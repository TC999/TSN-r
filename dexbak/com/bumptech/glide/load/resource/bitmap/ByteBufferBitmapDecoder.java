package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.load.resource.bitmap.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ByteBufferBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {

    /* renamed from: a */
    private final Downsampler f14090a;

    public ByteBufferBitmapDecoder(Downsampler downsampler) {
        this.f14090a = downsampler;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: c */
    public Resource<Bitmap> mo2813b(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull Options options) throws IOException {
        return this.f14090a.m44945d(ByteBufferUtil.m44426f(byteBuffer), i, i2, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: d */
    public boolean mo2814a(@NonNull ByteBuffer byteBuffer, @NonNull Options options) {
        return this.f14090a.m44935n(byteBuffer);
    }
}
