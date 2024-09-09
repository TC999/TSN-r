package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Queue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ModelCache.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class m<A, B> {

    /* renamed from: b  reason: collision with root package name */
    private static final int f17309b = 250;

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.util.g<b<A>, B> f17310a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ModelCache.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a extends com.bumptech.glide.util.g<b<A>, B> {
        a(long j4) {
            super(j4);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.util.g
        /* renamed from: p */
        public void l(@NonNull b<A> bVar, @Nullable B b4) {
            bVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ModelCache.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class b<A> {

        /* renamed from: d  reason: collision with root package name */
        private static final Queue<b<?>> f17312d = com.bumptech.glide.util.k.f(0);

        /* renamed from: a  reason: collision with root package name */
        private int f17313a;

        /* renamed from: b  reason: collision with root package name */
        private int f17314b;

        /* renamed from: c  reason: collision with root package name */
        private A f17315c;

        private b() {
        }

        static <A> b<A> a(A a4, int i4, int i5) {
            b<A> bVar;
            Queue<b<?>> queue = f17312d;
            synchronized (queue) {
                bVar = (b<A>) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a4, i4, i5);
            return bVar;
        }

        private void b(A a4, int i4, int i5) {
            this.f17315c = a4;
            this.f17314b = i4;
            this.f17313a = i5;
        }

        public void c() {
            Queue<b<?>> queue = f17312d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.f17314b == bVar.f17314b && this.f17313a == bVar.f17313a && this.f17315c.equals(bVar.f17315c);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f17313a * 31) + this.f17314b) * 31) + this.f17315c.hashCode();
        }
    }

    public m() {
        this(250L);
    }

    public void a() {
        this.f17310a.b();
    }

    @Nullable
    public B b(A a4, int i4, int i5) {
        b<A> a5 = b.a(a4, i4, i5);
        B i6 = this.f17310a.i(a5);
        a5.c();
        return i6;
    }

    public void c(A a4, int i4, int i5, B b4) {
        this.f17310a.m(b.a(a4, i4, i5), b4);
    }

    public m(long j4) {
        this.f17310a = new a(j4);
    }
}
