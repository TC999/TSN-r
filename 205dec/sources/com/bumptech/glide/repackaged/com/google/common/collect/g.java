package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Iterator;

/* compiled from: FluentIterable.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public abstract class g<E> implements Iterable<E> {

    /* renamed from: a  reason: collision with root package name */
    private final Iterable<E> f17678a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FluentIterable.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static class a extends g<E> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Iterable f17679b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Iterable iterable, Iterable iterable2) {
            super(iterable);
            this.f17679b = iterable2;
        }

        @Override // java.lang.Iterable
        public Iterator<E> iterator() {
            return this.f17679b.iterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g() {
        this.f17678a = this;
    }

    public static <E> g<E> g(Iterable<E> iterable) {
        return iterable instanceof g ? (g) iterable : new a(iterable, iterable);
    }

    public final boolean a(com.bumptech.glide.repackaged.com.google.common.base.e<? super E> eVar) {
        return m.a(this.f17678a, eVar);
    }

    public final g<E> c(com.bumptech.glide.repackaged.com.google.common.base.e<? super E> eVar) {
        return g(m.b(this.f17678a, eVar));
    }

    public final String k(com.bumptech.glide.repackaged.com.google.common.base.b bVar) {
        return bVar.c(this);
    }

    public final ImmutableList<E> l() {
        return ImmutableList.copyOf(this.f17678a);
    }

    public final ImmutableSet<E> m() {
        return ImmutableSet.copyOf(this.f17678a);
    }

    public final <T> g<T> n(com.bumptech.glide.repackaged.com.google.common.base.a<? super E, T> aVar) {
        return g(m.f(this.f17678a, aVar));
    }

    public String toString() {
        return m.e(this.f17678a);
    }

    g(Iterable<E> iterable) {
        this.f17678a = (Iterable) com.bumptech.glide.repackaged.com.google.common.base.d.i(iterable);
    }
}
