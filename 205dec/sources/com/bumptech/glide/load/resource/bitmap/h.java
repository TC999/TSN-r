package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.request.transition.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BitmapTransitionOptions.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class h extends com.bumptech.glide.k<h, Bitmap> {
    @NonNull
    public static h m(@NonNull com.bumptech.glide.request.transition.g<Bitmap> gVar) {
        return new h().f(gVar);
    }

    @NonNull
    public static h n() {
        return new h().h();
    }

    @NonNull
    public static h o(int i4) {
        return new h().i(i4);
    }

    @NonNull
    public static h p(@NonNull c.a aVar) {
        return new h().j(aVar);
    }

    @NonNull
    public static h q(@NonNull com.bumptech.glide.request.transition.c cVar) {
        return new h().k(cVar);
    }

    @NonNull
    public static h r(@NonNull com.bumptech.glide.request.transition.g<Drawable> gVar) {
        return new h().l(gVar);
    }

    @NonNull
    public h h() {
        return j(new c.a());
    }

    @NonNull
    public h i(int i4) {
        return j(new c.a(i4));
    }

    @NonNull
    public h j(@NonNull c.a aVar) {
        return l(aVar.a());
    }

    @NonNull
    public h k(@NonNull com.bumptech.glide.request.transition.c cVar) {
        return l(cVar);
    }

    @NonNull
    public h l(@NonNull com.bumptech.glide.request.transition.g<Drawable> gVar) {
        return f(new com.bumptech.glide.request.transition.b(gVar));
    }
}
