package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: UnitBitmapDecoder.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class a0 implements com.bumptech.glide.load.g<Bitmap, Bitmap> {

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: UnitBitmapDecoder.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class a implements com.bumptech.glide.load.engine.u<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private final Bitmap f17385a;

        a(@NonNull Bitmap bitmap) {
            this.f17385a = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.u
        @NonNull
        /* renamed from: a */
        public Bitmap get() {
            return this.f17385a;
        }

        @Override // com.bumptech.glide.load.engine.u
        @NonNull
        public Class<Bitmap> b() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.u
        public int getSize() {
            return com.bumptech.glide.util.k.h(this.f17385a);
        }

        @Override // com.bumptech.glide.load.engine.u
        public void recycle() {
        }
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: c */
    public com.bumptech.glide.load.engine.u<Bitmap> b(@NonNull Bitmap bitmap, int i4, int i5, @NonNull com.bumptech.glide.load.f fVar) {
        return new a(bitmap);
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: d */
    public boolean a(@NonNull Bitmap bitmap, @NonNull com.bumptech.glide.load.f fVar) {
        return true;
    }
}
