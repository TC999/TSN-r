package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Iterator;

/* compiled from: TransformedIterator.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
abstract class g0<F, T> implements Iterator<T> {

    /* renamed from: a  reason: collision with root package name */
    final Iterator<? extends F> f17680a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g0(Iterator<? extends F> it) {
        this.f17680a = (Iterator) com.bumptech.glide.repackaged.com.google.common.base.d.i(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T a(F f4);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f17680a.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f17680a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f17680a.remove();
    }
}
