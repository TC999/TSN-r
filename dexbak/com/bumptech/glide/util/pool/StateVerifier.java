package com.bumptech.glide.util.pool;

import androidx.annotation.NonNull;

/* renamed from: com.bumptech.glide.util.pool.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class StateVerifier {

    /* renamed from: a */
    private static final boolean f14577a = false;

    /* compiled from: StateVerifier.java */
    /* renamed from: com.bumptech.glide.util.pool.c$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3782b extends StateVerifier {

        /* renamed from: b */
        private volatile RuntimeException f14578b;

        C3782b() {
            super();
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        /* renamed from: b */
        void mo44344b(boolean z) {
            if (z) {
                this.f14578b = new RuntimeException("Released");
            } else {
                this.f14578b = null;
            }
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        /* renamed from: c */
        public void mo44343c() {
            if (this.f14578b != null) {
                throw new IllegalStateException("Already released", this.f14578b);
            }
        }
    }

    /* compiled from: StateVerifier.java */
    /* renamed from: com.bumptech.glide.util.pool.c$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static class C3783c extends StateVerifier {

        /* renamed from: b */
        private volatile boolean f14579b;

        C3783c() {
            super();
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        /* renamed from: b */
        public void mo44344b(boolean z) {
            this.f14579b = z;
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        /* renamed from: c */
        public void mo44343c() {
            if (this.f14579b) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    @NonNull
    /* renamed from: a */
    public static StateVerifier m44345a() {
        return new C3783c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract void mo44344b(boolean z);

    /* renamed from: c */
    public abstract void mo44343c();

    private StateVerifier() {
    }
}
