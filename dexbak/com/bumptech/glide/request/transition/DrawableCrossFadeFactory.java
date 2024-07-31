package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* renamed from: com.bumptech.glide.request.transition.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {

    /* renamed from: a */
    private final int f14506a;

    /* renamed from: b */
    private final boolean f14507b;

    /* renamed from: c */
    private DrawableCrossFadeTransition f14508c;

    /* compiled from: DrawableCrossFadeFactory.java */
    /* renamed from: com.bumptech.glide.request.transition.c$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3757a {

        /* renamed from: c */
        private static final int f14509c = 300;

        /* renamed from: a */
        private final int f14510a;

        /* renamed from: b */
        private boolean f14511b;

        public C3757a() {
            this(300);
        }

        /* renamed from: a */
        public DrawableCrossFadeFactory m44449a() {
            return new DrawableCrossFadeFactory(this.f14510a, this.f14511b);
        }

        /* renamed from: b */
        public C3757a m44448b(boolean z) {
            this.f14511b = z;
            return this;
        }

        public C3757a(int i) {
            this.f14510a = i;
        }
    }

    protected DrawableCrossFadeFactory(int i, boolean z) {
        this.f14506a = i;
        this.f14507b = z;
    }

    /* renamed from: b */
    private InterfaceC3759f<Drawable> m44450b() {
        if (this.f14508c == null) {
            this.f14508c = new DrawableCrossFadeTransition(this.f14506a, this.f14507b);
        }
        return this.f14508c;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    /* renamed from: a */
    public InterfaceC3759f<Drawable> mo44442a(DataSource dataSource, boolean z) {
        return dataSource == DataSource.MEMORY_CACHE ? NoTransition.m44446b() : m44450b();
    }
}
