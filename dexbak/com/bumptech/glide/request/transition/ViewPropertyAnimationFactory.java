package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

/* renamed from: com.bumptech.glide.request.transition.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ViewPropertyAnimationFactory<R> implements TransitionFactory<R> {

    /* renamed from: a */
    private final ViewPropertyTransition.InterfaceC3763a f14520a;

    /* renamed from: b */
    private ViewPropertyTransition<R> f14521b;

    public ViewPropertyAnimationFactory(ViewPropertyTransition.InterfaceC3763a interfaceC3763a) {
        this.f14520a = interfaceC3763a;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    /* renamed from: a */
    public InterfaceC3759f<R> mo44442a(DataSource dataSource, boolean z) {
        if (dataSource != DataSource.MEMORY_CACHE && z) {
            if (this.f14521b == null) {
                this.f14521b = new ViewPropertyTransition<>(this.f14520a);
            }
            return this.f14521b;
        }
        return NoTransition.m44446b();
    }
}
