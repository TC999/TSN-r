package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: GifBitmapProvider.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class b implements GifDecoder.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f17533a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f17534b;

    public b(com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        this(eVar, null);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    public void a(@NonNull Bitmap bitmap) {
        this.f17533a.d(bitmap);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    @NonNull
    public byte[] b(int i4) {
        com.bumptech.glide.load.engine.bitmap_recycle.b bVar = this.f17534b;
        if (bVar == null) {
            return new byte[i4];
        }
        return (byte[]) bVar.c(i4, byte[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    @NonNull
    public Bitmap c(int i4, int i5, @NonNull Bitmap.Config config) {
        return this.f17533a.f(i4, i5, config);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    @NonNull
    public int[] d(int i4) {
        com.bumptech.glide.load.engine.bitmap_recycle.b bVar = this.f17534b;
        if (bVar == null) {
            return new int[i4];
        }
        return (int[]) bVar.c(i4, int[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    public void e(@NonNull byte[] bArr) {
        com.bumptech.glide.load.engine.bitmap_recycle.b bVar = this.f17534b;
        if (bVar == null) {
            return;
        }
        bVar.put(bArr);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.a
    public void f(@NonNull int[] iArr) {
        com.bumptech.glide.load.engine.bitmap_recycle.b bVar = this.f17534b;
        if (bVar == null) {
            return;
        }
        bVar.put(iArr);
    }

    public b(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @Nullable com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f17533a = eVar;
        this.f17534b = bVar;
    }
}
