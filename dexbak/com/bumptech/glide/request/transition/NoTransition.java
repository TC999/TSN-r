package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.InterfaceC3759f;

/* renamed from: com.bumptech.glide.request.transition.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NoTransition<R> implements InterfaceC3759f<R> {

    /* renamed from: a */
    static final NoTransition<?> f14514a = new NoTransition<>();

    /* renamed from: b */
    private static final TransitionFactory<?> f14515b = new C3758a();

    /* compiled from: NoTransition.java */
    /* renamed from: com.bumptech.glide.request.transition.e$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3758a<R> implements TransitionFactory<R> {
        @Override // com.bumptech.glide.request.transition.TransitionFactory
        /* renamed from: a */
        public InterfaceC3759f<R> mo44442a(DataSource dataSource, boolean z) {
            return NoTransition.f14514a;
        }
    }

    /* renamed from: b */
    public static <R> InterfaceC3759f<R> m44446b() {
        return f14514a;
    }

    /* renamed from: c */
    public static <R> TransitionFactory<R> m44445c() {
        return (TransitionFactory<R>) f14515b;
    }

    @Override // com.bumptech.glide.request.transition.InterfaceC3759f
    /* renamed from: a */
    public boolean mo44440a(Object obj, InterfaceC3759f.InterfaceC3760a interfaceC3760a) {
        return false;
    }
}
