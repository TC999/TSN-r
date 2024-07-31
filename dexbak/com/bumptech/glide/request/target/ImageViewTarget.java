package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.InterfaceC3759f;

/* renamed from: com.bumptech.glide.request.target.j */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements InterfaceC3759f.InterfaceC3760a {
    @Nullable

    /* renamed from: j */
    private Animatable f14474j;

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* renamed from: t */
    private void m44487t(@Nullable Z z) {
        if (z instanceof Animatable) {
            Animatable animatable = (Animatable) z;
            this.f14474j = animatable;
            animatable.start();
            return;
        }
        this.f14474j = null;
    }

    /* renamed from: v */
    private void m44486v(@Nullable Z z) {
        mo44480u(z);
        m44487t(z);
    }

    @Override // com.bumptech.glide.request.transition.InterfaceC3759f.InterfaceC3760a
    /* renamed from: a */
    public void mo44444a(Drawable drawable) {
        ((ImageView) this.f14490b).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.transition.InterfaceC3759f.InterfaceC3760a
    @Nullable
    /* renamed from: c */
    public Drawable mo44443c() {
        return ((ImageView) this.f14490b).getDrawable();
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    /* renamed from: h */
    public void mo44473h(@Nullable Drawable drawable) {
        super.mo44473h(drawable);
        m44486v(null);
        mo44444a(drawable);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    /* renamed from: j */
    public void mo44471j(@Nullable Drawable drawable) {
        super.mo44471j(drawable);
        Animatable animatable = this.f14474j;
        if (animatable != null) {
            animatable.stop();
        }
        m44486v(null);
        mo44444a(drawable);
    }

    @Override // com.bumptech.glide.request.target.Target
    /* renamed from: k */
    public void mo44364k(@NonNull Z z, @Nullable InterfaceC3759f<? super Z> interfaceC3759f) {
        if (interfaceC3759f != null && interfaceC3759f.mo44440a(z, this)) {
            m44487t(z);
        } else {
            m44486v(z);
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    /* renamed from: n */
    public void mo44481n(@Nullable Drawable drawable) {
        super.mo44481n(drawable);
        m44486v(null);
        mo44444a(drawable);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        Animatable animatable = this.f14474j;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        Animatable animatable = this.f14474j;
        if (animatable != null) {
            animatable.stop();
        }
    }

    /* renamed from: u */
    protected abstract void mo44480u(@Nullable Z z);

    @Deprecated
    public ImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
