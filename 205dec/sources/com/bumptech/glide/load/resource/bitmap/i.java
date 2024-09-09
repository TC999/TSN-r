package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ByteBufferBitmapDecoder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class i implements com.bumptech.glide.load.g<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final n f17407a;

    public i(n nVar) {
        this.f17407a = nVar;
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: c */
    public com.bumptech.glide.load.engine.u<Bitmap> b(@NonNull ByteBuffer byteBuffer, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return this.f17407a.d(com.bumptech.glide.util.a.f(byteBuffer), i4, i5, fVar);
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: d */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.f fVar) {
        return this.f17407a.n(byteBuffer);
    }
}
