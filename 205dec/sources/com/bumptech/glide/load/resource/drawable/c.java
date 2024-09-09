package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.k;
import com.bumptech.glide.request.transition.c;
import com.bumptech.glide.request.transition.g;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DrawableTransitionOptions.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class c extends k<c, Drawable> {
    @NonNull
    public static c l(@NonNull g<Drawable> gVar) {
        return new c().f(gVar);
    }

    @NonNull
    public static c m() {
        return new c().h();
    }

    @NonNull
    public static c n(int i4) {
        return new c().i(i4);
    }

    @NonNull
    public static c o(@NonNull c.a aVar) {
        return new c().j(aVar);
    }

    @NonNull
    public static c p(@NonNull com.bumptech.glide.request.transition.c cVar) {
        return new c().k(cVar);
    }

    @NonNull
    public c h() {
        return j(new c.a());
    }

    @NonNull
    public c i(int i4) {
        return j(new c.a(i4));
    }

    @NonNull
    public c j(@NonNull c.a aVar) {
        return k(aVar.a());
    }

    @NonNull
    public c k(@NonNull com.bumptech.glide.request.transition.c cVar) {
        return f(cVar);
    }
}
