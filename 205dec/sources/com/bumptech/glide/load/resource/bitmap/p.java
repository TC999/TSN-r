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
/* compiled from: DrawableTransformation.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class p implements com.bumptech.glide.load.i<Drawable> {

    /* renamed from: c  reason: collision with root package name */
    private final com.bumptech.glide.load.i<Bitmap> f17460c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f17461d;

    public p(com.bumptech.glide.load.i<Bitmap> iVar, boolean z3) {
        this.f17460c = iVar;
        this.f17461d = z3;
    }

    private com.bumptech.glide.load.engine.u<Drawable> d(Context context, com.bumptech.glide.load.engine.u<Bitmap> uVar) {
        return t.d(context.getResources(), uVar);
    }

    @Override // com.bumptech.glide.load.i
    @NonNull
    public com.bumptech.glide.load.engine.u<Drawable> a(@NonNull Context context, @NonNull com.bumptech.glide.load.engine.u<Drawable> uVar, int i4, int i5) {
        com.bumptech.glide.load.engine.bitmap_recycle.e g4 = com.bumptech.glide.d.d(context).g();
        Drawable drawable = uVar.get();
        com.bumptech.glide.load.engine.u<Bitmap> a4 = o.a(g4, drawable, i4, i5);
        if (a4 == null) {
            if (this.f17461d) {
                throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
            }
            return uVar;
        }
        com.bumptech.glide.load.engine.u<Bitmap> a5 = this.f17460c.a(context, a4, i4, i5);
        if (a5.equals(a4)) {
            a5.recycle();
            return uVar;
        }
        return d(context, a5);
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        this.f17460c.b(messageDigest);
    }

    public com.bumptech.glide.load.i<BitmapDrawable> c() {
        return this;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof p) {
            return this.f17460c.equals(((p) obj).f17460c);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f17460c.hashCode();
    }
}
