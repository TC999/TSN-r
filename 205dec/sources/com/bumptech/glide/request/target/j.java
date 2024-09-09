package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.f;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ImageViewTarget.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class j<Z> extends r<ImageView, Z> implements f.a {
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Animatable f17992j;

    public j(ImageView imageView) {
        super(imageView);
    }

    private void t(@Nullable Z z3) {
        if (z3 instanceof Animatable) {
            Animatable animatable = (Animatable) z3;
            this.f17992j = animatable;
            animatable.start();
            return;
        }
        this.f17992j = null;
    }

    private void v(@Nullable Z z3) {
        u(z3);
        t(z3);
    }

    @Override // com.bumptech.glide.request.transition.f.a
    public void a(Drawable drawable) {
        ((ImageView) this.f18008b).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.transition.f.a
    @Nullable
    public Drawable c() {
        return ((ImageView) this.f18008b).getDrawable();
    }

    @Override // com.bumptech.glide.request.target.r, com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.p
    public void h(@Nullable Drawable drawable) {
        super.h(drawable);
        v(null);
        a(drawable);
    }

    @Override // com.bumptech.glide.request.target.r, com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.p
    public void j(@Nullable Drawable drawable) {
        super.j(drawable);
        Animatable animatable = this.f17992j;
        if (animatable != null) {
            animatable.stop();
        }
        v(null);
        a(drawable);
    }

    @Override // com.bumptech.glide.request.target.p
    public void k(@NonNull Z z3, @Nullable com.bumptech.glide.request.transition.f<? super Z> fVar) {
        if (fVar != null && fVar.a(z3, this)) {
            t(z3);
        } else {
            v(z3);
        }
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.p
    public void n(@Nullable Drawable drawable) {
        super.n(drawable);
        v(null);
        a(drawable);
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.manager.i
    public void onStart() {
        Animatable animatable = this.f17992j;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.manager.i
    public void onStop() {
        Animatable animatable = this.f17992j;
        if (animatable != null) {
            animatable.stop();
        }
    }

    protected abstract void u(@Nullable Z z3);

    @Deprecated
    public j(ImageView imageView, boolean z3) {
        super(imageView, z3);
    }
}
