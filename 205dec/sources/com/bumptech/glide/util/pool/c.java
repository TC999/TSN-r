package com.bumptech.glide.util.pool;

import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: StateVerifier.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f18095a = false;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: StateVerifier.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class b extends c {

        /* renamed from: b  reason: collision with root package name */
        private volatile RuntimeException f18096b;

        b() {
            super();
        }

        @Override // com.bumptech.glide.util.pool.c
        void b(boolean z3) {
            if (z3) {
                this.f18096b = new RuntimeException("Released");
            } else {
                this.f18096b = null;
            }
        }

        @Override // com.bumptech.glide.util.pool.c
        public void c() {
            if (this.f18096b != null) {
                throw new IllegalStateException("Already released", this.f18096b);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: StateVerifier.java */
    /* renamed from: com.bumptech.glide.util.pool.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class C0187c extends c {

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f18097b;

        C0187c() {
            super();
        }

        @Override // com.bumptech.glide.util.pool.c
        public void b(boolean z3) {
            this.f18097b = z3;
        }

        @Override // com.bumptech.glide.util.pool.c
        public void c() {
            if (this.f18097b) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    @NonNull
    public static c a() {
        return new C0187c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(boolean z3);

    public abstract void c();

    private c() {
    }
}
