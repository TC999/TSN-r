package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.NoSuchElementException;

/* compiled from: AbstractIndexedListIterator.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
abstract class a<E> extends j0<E> {

    /* renamed from: a  reason: collision with root package name */
    private final int f17661a;

    /* renamed from: b  reason: collision with root package name */
    private int f17662b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(int i4, int i5) {
        com.bumptech.glide.repackaged.com.google.common.base.d.k(i5, i4);
        this.f17661a = i4;
        this.f17662b = i5;
    }

    protected abstract E a(int i4);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f17662b < this.f17661a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f17662b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i4 = this.f17662b;
            this.f17662b = i4 + 1;
            return a(i4);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f17662b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i4 = this.f17662b - 1;
            this.f17662b = i4;
            return a(i4);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f17662b - 1;
    }
}
