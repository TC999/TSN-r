package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.InterfaceC3744d;
import com.bumptech.glide.util.C3771k;

/* renamed from: com.bumptech.glide.request.target.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class CustomTarget<T> implements Target<T> {

    /* renamed from: a */
    private final int f14446a;

    /* renamed from: b */
    private final int f14447b;
    @Nullable

    /* renamed from: c */
    private InterfaceC3744d f14448c;

    public CustomTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: b */
    public final void mo44478b(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: h */
    public void mo44473h(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    @Nullable
    /* renamed from: i */
    public final InterfaceC3744d mo44472i() {
        return this.f14448c;
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: m */
    public final void mo44469m(@Nullable InterfaceC3744d interfaceC3744d) {
        this.f14448c = interfaceC3744d;
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: n */
    public void mo44481n(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: q */
    public final void mo44466q(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.mo44365e(this.f14446a, this.f14447b);
    }

    public CustomTarget(int i, int i2) {
        if (C3771k.m44369v(i, i2)) {
            this.f14446a = i;
            this.f14447b = i2;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i + " and height: " + i2);
    }
}
