package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.C3771k;

/* renamed from: com.bumptech.glide.load.resource.bitmap.a0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UnitBitmapDecoder.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.a0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3710a implements Resource<Bitmap> {

        /* renamed from: a */
        private final Bitmap f14068a;

        C3710a(@NonNull Bitmap bitmap) {
            this.f14068a = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        @NonNull
        /* renamed from: a */
        public Bitmap get() {
            return this.f14068a;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        @NonNull
        /* renamed from: b */
        public Class<Bitmap> mo2883b() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public int getSize() {
            return C3771k.m44383h(this.f14068a);
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public void recycle() {
        }
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: c */
    public Resource<Bitmap> mo2813b(@NonNull Bitmap bitmap, int i, int i2, @NonNull Options options) {
        return new C3710a(bitmap);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: d */
    public boolean mo2814a(@NonNull Bitmap bitmap, @NonNull Options options) {
        return true;
    }
}
