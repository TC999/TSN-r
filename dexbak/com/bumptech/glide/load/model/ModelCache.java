package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.C3769g;
import com.bumptech.glide.util.C3771k;
import java.util.Queue;

/* renamed from: com.bumptech.glide.load.model.m */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ModelCache<A, B> {

    /* renamed from: b */
    private static final int f13992b = 250;

    /* renamed from: a */
    private final C3769g<C3677b<A>, B> f13993a;

    /* compiled from: ModelCache.java */
    /* renamed from: com.bumptech.glide.load.model.m$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3676a extends C3769g<C3677b<A>, B> {
        C3676a(long j) {
            super(j);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.util.C3769g
        /* renamed from: p */
        public void mo44403l(@NonNull C3677b<A> c3677b, @Nullable B b) {
            c3677b.m45066c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ModelCache.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.model.m$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3677b<A> {

        /* renamed from: d */
        private static final Queue<C3677b<?>> f13995d = C3771k.m44385f(0);

        /* renamed from: a */
        private int f13996a;

        /* renamed from: b */
        private int f13997b;

        /* renamed from: c */
        private A f13998c;

        private C3677b() {
        }

        /* renamed from: a */
        static <A> C3677b<A> m45068a(A a, int i, int i2) {
            C3677b<A> c3677b;
            Queue<C3677b<?>> queue = f13995d;
            synchronized (queue) {
                c3677b = (C3677b<A>) queue.poll();
            }
            if (c3677b == null) {
                c3677b = new C3677b<>();
            }
            c3677b.m45067b(a, i, i2);
            return c3677b;
        }

        /* renamed from: b */
        private void m45067b(A a, int i, int i2) {
            this.f13998c = a;
            this.f13997b = i;
            this.f13996a = i2;
        }

        /* renamed from: c */
        public void m45066c() {
            Queue<C3677b<?>> queue = f13995d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof C3677b) {
                C3677b c3677b = (C3677b) obj;
                return this.f13997b == c3677b.f13997b && this.f13996a == c3677b.f13996a && this.f13998c.equals(c3677b.f13998c);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f13996a * 31) + this.f13997b) * 31) + this.f13998c.hashCode();
        }
    }

    public ModelCache() {
        this(250L);
    }

    /* renamed from: a */
    public void m45072a() {
        this.f13993a.m44410b();
    }

    @Nullable
    /* renamed from: b */
    public B m45071b(A a, int i, int i2) {
        C3677b<A> m45068a = C3677b.m45068a(a, i, i2);
        B m44406i = this.f13993a.m44406i(m45068a);
        m45068a.m45066c();
        return m44406i;
    }

    /* renamed from: c */
    public void m45070c(A a, int i, int i2, B b) {
        this.f13993a.m44402m(C3677b.m45068a(a, i, i2), b);
    }

    public ModelCache(long j) {
        this.f13993a = new C3676a(j);
    }
}
