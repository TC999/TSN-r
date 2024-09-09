package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.ListIterator;

/* compiled from: TransformedListIterator.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
abstract class h0<F, T> extends g0<F, T> implements ListIterator<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    private ListIterator<? extends F> b() {
        return n.c(this.f17680a);
    }

    @Override // java.util.ListIterator
    public void add(T t3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return b().nextIndex();
    }

    @Override // java.util.ListIterator
    public final T previous() {
        return a(b().previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return b().previousIndex();
    }

    @Override // java.util.ListIterator
    public void set(T t3) {
        throw new UnsupportedOperationException();
    }
}
