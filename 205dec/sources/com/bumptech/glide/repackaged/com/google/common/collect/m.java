package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Iterator;

/* compiled from: Iterables.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class m {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterables.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static class a<T> extends g<T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Iterable f17684b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.repackaged.com.google.common.base.e f17685c;

        a(Iterable iterable, com.bumptech.glide.repackaged.com.google.common.base.e eVar) {
            this.f17684b = iterable;
            this.f17685c = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return n.f(this.f17684b.iterator(), this.f17685c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterables.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static class b<T> extends g<T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Iterable f17686b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.repackaged.com.google.common.base.a f17687c;

        b(Iterable iterable, com.bumptech.glide.repackaged.com.google.common.base.a aVar) {
            this.f17686b = iterable;
            this.f17687c = aVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return n.o(this.f17686b.iterator(), this.f17687c);
        }
    }

    public static <T> boolean a(Iterable<T> iterable, com.bumptech.glide.repackaged.com.google.common.base.e<? super T> eVar) {
        return n.b(iterable.iterator(), eVar);
    }

    public static <T> Iterable<T> b(Iterable<T> iterable, com.bumptech.glide.repackaged.com.google.common.base.e<? super T> eVar) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(iterable);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(eVar);
        return new a(iterable, eVar);
    }

    public static <T> T c(Iterable<? extends T> iterable, T t3) {
        return (T) n.i(iterable.iterator(), t3);
    }

    public static <T> T d(Iterable<T> iterable) {
        return (T) n.j(iterable.iterator());
    }

    public static String e(Iterable<?> iterable) {
        return n.n(iterable.iterator());
    }

    public static <F, T> Iterable<T> f(Iterable<F> iterable, com.bumptech.glide.repackaged.com.google.common.base.a<? super F, ? extends T> aVar) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(iterable);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(aVar);
        return new b(iterable, aVar);
    }
}
