package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.util.j;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: GifDrawableTransformation.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class e implements com.bumptech.glide.load.i<GifDrawable> {

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.i<Bitmap> f17536c;

    public e(com.bumptech.glide.load.i<Bitmap> iVar) {
        this.f17536c = (com.bumptech.glide.load.i) j.d(iVar);
    }

    @Override // com.bumptech.glide.load.i
    @NonNull
    public u<GifDrawable> a(@NonNull Context context, @NonNull u<GifDrawable> uVar, int i4, int i5) {
        GifDrawable gifDrawable = uVar.get();
        u<Bitmap> fVar = new com.bumptech.glide.load.resource.bitmap.f(gifDrawable.e(), com.bumptech.glide.d.d(context).g());
        u<Bitmap> a4 = this.f17536c.a(context, fVar, i4, i5);
        if (!fVar.equals(a4)) {
            fVar.recycle();
        }
        gifDrawable.o(this.f17536c, a4.get());
        return uVar;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        this.f17536c.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f17536c.equals(((e) obj).f17536c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f17536c.hashCode();
    }
}
