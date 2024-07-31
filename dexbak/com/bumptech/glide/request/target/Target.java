package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.InterfaceC3744d;
import com.bumptech.glide.request.transition.InterfaceC3759f;

/* renamed from: com.bumptech.glide.request.target.p */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface Target<R> extends LifecycleListener {

    /* renamed from: e0 */
    public static final int f14486e0 = Integer.MIN_VALUE;

    /* renamed from: b */
    void mo44478b(@NonNull SizeReadyCallback sizeReadyCallback);

    /* renamed from: h */
    void mo44473h(@Nullable Drawable drawable);

    @Nullable
    /* renamed from: i */
    InterfaceC3744d mo44472i();

    /* renamed from: j */
    void mo44471j(@Nullable Drawable drawable);

    /* renamed from: k */
    void mo44364k(@NonNull R r, @Nullable InterfaceC3759f<? super R> interfaceC3759f);

    /* renamed from: m */
    void mo44469m(@Nullable InterfaceC3744d interfaceC3744d);

    /* renamed from: n */
    void mo44481n(@Nullable Drawable drawable);

    /* renamed from: q */
    void mo44466q(@NonNull SizeReadyCallback sizeReadyCallback);
}
