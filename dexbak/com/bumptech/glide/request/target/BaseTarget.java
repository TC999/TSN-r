package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.InterfaceC3744d;

@Deprecated
/* renamed from: com.bumptech.glide.request.target.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class BaseTarget<Z> implements Target<Z> {

    /* renamed from: a */
    private InterfaceC3744d f14445a;

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: h */
    public void mo44473h(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    @Nullable
    /* renamed from: i */
    public InterfaceC3744d mo44472i() {
        return this.f14445a;
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: j */
    public void mo44471j(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: m */
    public void mo44469m(@Nullable InterfaceC3744d interfaceC3744d) {
        this.f14445a = interfaceC3744d;
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
}
