package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.InterfaceC3759f;

/* renamed from: com.bumptech.glide.request.transition.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class BitmapContainerTransitionFactory<R> implements TransitionFactory<R> {

    /* renamed from: a */
    private final TransitionFactory<Drawable> f14503a;

    /* compiled from: BitmapContainerTransitionFactory.java */
    /* renamed from: com.bumptech.glide.request.transition.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private final class C3756a implements InterfaceC3759f<R> {

        /* renamed from: a */
        private final InterfaceC3759f<Drawable> f14504a;

        C3756a(InterfaceC3759f<Drawable> interfaceC3759f) {
            this.f14504a = interfaceC3759f;
        }

        @Override // com.bumptech.glide.request.transition.InterfaceC3759f
        /* renamed from: a */
        public boolean mo44440a(R r, InterfaceC3759f.InterfaceC3760a interfaceC3760a) {
            return this.f14504a.mo44440a(new BitmapDrawable(interfaceC3760a.getView().getResources(), BitmapContainerTransitionFactory.this.mo44452b(r)), interfaceC3760a);
        }
    }

    public BitmapContainerTransitionFactory(TransitionFactory<Drawable> transitionFactory) {
        this.f14503a = transitionFactory;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    /* renamed from: a */
    public InterfaceC3759f<R> mo44442a(DataSource dataSource, boolean z) {
        return new C3756a(this.f14503a.mo44442a(dataSource, z));
    }

    /* renamed from: b */
    protected abstract Bitmap mo44452b(R r);
}
