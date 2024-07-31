package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

/* renamed from: com.bumptech.glide.load.resource.gif.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class GifBitmapProvider implements GifDecoder.InterfaceC3554a {

    /* renamed from: a */
    private final BitmapPool f14216a;
    @Nullable

    /* renamed from: b */
    private final ArrayPool f14217b;

    public GifBitmapProvider(BitmapPool bitmapPool) {
        this(bitmapPool, null);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.InterfaceC3554a
    /* renamed from: a */
    public void mo44833a(@NonNull Bitmap bitmap) {
        this.f14216a.mo44924d(bitmap);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.InterfaceC3554a
    @NonNull
    /* renamed from: b */
    public byte[] mo44832b(int i) {
        ArrayPool arrayPool = this.f14217b;
        if (arrayPool == null) {
            return new byte[i];
        }
        return (byte[]) arrayPool.mo45394c(i, byte[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.InterfaceC3554a
    @NonNull
    /* renamed from: c */
    public Bitmap mo44831c(int i, int i2, @NonNull Bitmap.Config config) {
        return this.f14216a.mo45372f(i, i2, config);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.InterfaceC3554a
    @NonNull
    /* renamed from: d */
    public int[] mo44830d(int i) {
        ArrayPool arrayPool = this.f14217b;
        if (arrayPool == null) {
            return new int[i];
        }
        return (int[]) arrayPool.mo45394c(i, int[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.InterfaceC3554a
    /* renamed from: e */
    public void mo44829e(@NonNull byte[] bArr) {
        ArrayPool arrayPool = this.f14217b;
        if (arrayPool == null) {
            return;
        }
        arrayPool.put(bArr);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.InterfaceC3554a
    /* renamed from: f */
    public void mo44828f(@NonNull int[] iArr) {
        ArrayPool arrayPool = this.f14217b;
        if (arrayPool == null) {
            return;
        }
        arrayPool.put(iArr);
    }

    public GifBitmapProvider(BitmapPool bitmapPool, @Nullable ArrayPool arrayPool) {
        this.f14216a = bitmapPool;
        this.f14217b = arrayPool;
    }
}
