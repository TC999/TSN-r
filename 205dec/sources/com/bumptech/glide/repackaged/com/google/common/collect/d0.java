package com.bumptech.glide.repackaged.com.google.common.collect;

/* compiled from: SingletonImmutableSet.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
final class d0<E> extends ImmutableSet<E> {

    /* renamed from: a  reason: collision with root package name */
    final transient E f17674a;

    /* renamed from: b  reason: collision with root package name */
    private transient int f17675b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(E e4) {
        this.f17674a = (E) com.bumptech.glide.repackaged.com.google.common.base.d.i(e4);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f17674a.equals(obj);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] objArr, int i4) {
        objArr[i4] = this.f17674a;
        return i4 + 1;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i4 = this.f17675b;
        if (i4 == 0) {
            int hashCode = this.f17674a.hashCode();
            this.f17675b = hashCode;
            return hashCode;
        }
        return i4;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet
    boolean isHashCodeFast() {
        return this.f17675b != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String obj = this.f17674a.toString();
        StringBuilder sb = new StringBuilder(obj.length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public i0<E> iterator() {
        return n.m(this.f17674a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(E e4, int i4) {
        this.f17674a = e4;
        this.f17675b = i4;
    }
}
