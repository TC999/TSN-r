package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewTransition;

/* renamed from: com.bumptech.glide.request.transition.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ViewAnimationFactory<R> implements TransitionFactory<R> {

    /* renamed from: a */
    private final ViewTransition.InterfaceC3764a f14516a;

    /* renamed from: b */
    private InterfaceC3759f<R> f14517b;

    /* compiled from: ViewAnimationFactory.java */
    /* renamed from: com.bumptech.glide.request.transition.h$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3761a implements ViewTransition.InterfaceC3764a {

        /* renamed from: a */
        private final Animation f14518a;

        C3761a(Animation animation) {
            this.f14518a = animation;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.InterfaceC3764a
        /* renamed from: a */
        public Animation mo44439a(Context context) {
            return this.f14518a;
        }
    }

    /* compiled from: ViewAnimationFactory.java */
    /* renamed from: com.bumptech.glide.request.transition.h$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3762b implements ViewTransition.InterfaceC3764a {

        /* renamed from: a */
        private final int f14519a;

        C3762b(int i) {
            this.f14519a = i;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.InterfaceC3764a
        /* renamed from: a */
        public Animation mo44439a(Context context) {
            return AnimationUtils.loadAnimation(context, this.f14519a);
        }
    }

    public ViewAnimationFactory(Animation animation) {
        this(new C3761a(animation));
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    /* renamed from: a */
    public InterfaceC3759f<R> mo44442a(DataSource dataSource, boolean z) {
        if (dataSource != DataSource.MEMORY_CACHE && z) {
            if (this.f14517b == null) {
                this.f14517b = new ViewTransition(this.f14516a);
            }
            return this.f14517b;
        }
        return NoTransition.m44446b();
    }

    public ViewAnimationFactory(int i) {
        this(new C3762b(i));
    }

    ViewAnimationFactory(ViewTransition.InterfaceC3764a interfaceC3764a) {
        this.f14516a = interfaceC3764a;
    }
}
