package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: Target.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface p<R> extends com.bumptech.glide.manager.i {

    /* renamed from: e0  reason: collision with root package name */
    public static final int f18004e0 = Integer.MIN_VALUE;

    void b(@NonNull o oVar);

    void h(@Nullable Drawable drawable);

    @Nullable
    com.bumptech.glide.request.d i();

    void j(@Nullable Drawable drawable);

    void k(@NonNull R r3, @Nullable com.bumptech.glide.request.transition.f<? super R> fVar);

    void m(@Nullable com.bumptech.glide.request.d dVar);

    void n(@Nullable Drawable drawable);

    void q(@NonNull o oVar);
}
