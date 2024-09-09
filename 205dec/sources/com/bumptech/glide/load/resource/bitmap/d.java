package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BitmapDrawableTransformation.java */
@Deprecated
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class d implements com.bumptech.glide.load.i<BitmapDrawable> {

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.i<Drawable> f17400c;

    public d(com.bumptech.glide.load.i<Bitmap> iVar) {
        this.f17400c = (com.bumptech.glide.load.i) com.bumptech.glide.util.j.d(new p(iVar, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.bumptech.glide.load.engine.u<BitmapDrawable> c(com.bumptech.glide.load.engine.u<Drawable> uVar) {
        if (uVar.get() instanceof BitmapDrawable) {
            return uVar;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + uVar.get());
    }

    private static com.bumptech.glide.load.engine.u<Drawable> d(com.bumptech.glide.load.engine.u<BitmapDrawable> uVar) {
        return uVar;
    }

    @Override // com.bumptech.glide.load.i
    @NonNull
    public com.bumptech.glide.load.engine.u<BitmapDrawable> a(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.u<BitmapDrawable> uVar, int i4, int i5) {
        return c(this.f17400c.a(context, d(uVar), i4, i5));
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        this.f17400c.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f17400c.equals(((d) obj).f17400c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f17400c.hashCode();
    }
}
