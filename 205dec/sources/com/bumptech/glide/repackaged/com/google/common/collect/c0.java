package com.bumptech.glide.repackaged.com.google.common.collect;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SingletonImmutableList.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class c0<E> extends ImmutableList<E> {

    /* renamed from: a  reason: collision with root package name */
    final transient E f17672a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(E e4) {
        this.f17672a = (E) com.bumptech.glide.repackaged.com.google.common.base.d.i(e4);
    }

    @Override // java.util.List
    public E get(int i4) {
        com.bumptech.glide.repackaged.com.google.common.base.d.g(i4, 1);
        return this.f17672a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String obj = this.f17672a.toString();
        StringBuilder sb = new StringBuilder(obj.length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public i0<E> iterator() {
        return n.m(this.f17672a);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
    public ImmutableList<E> subList(int i4, int i5) {
        com.bumptech.glide.repackaged.com.google.common.base.d.m(i4, i5, 1);
        return i4 == i5 ? ImmutableList.of() : this;
    }
}
