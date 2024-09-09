package com.bumptech.glide.repackaged.com.google.common.collect;

import com.google.j2objc.annotations.Weak;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableAsList.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public class v<E> extends i<E> {
    @Weak

    /* renamed from: a  reason: collision with root package name */
    private final ImmutableCollection<E> f17709a;

    /* renamed from: b  reason: collision with root package name */
    private final ImmutableList<? extends E> f17710b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ImmutableCollection<E> immutableCollection, ImmutableList<? extends E> immutableList) {
        this.f17709a = immutableCollection;
        this.f17710b = immutableList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.i
    public ImmutableCollection<E> a() {
        return this.f17709a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i4) {
        return this.f17710b.copyIntoArray(objArr, i4);
    }

    @Override // java.util.List
    public E get(int i4) {
        return this.f17710b.get(i4);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
    public j0<E> listIterator(int i4) {
        return (j0<? extends E>) this.f17710b.listIterator(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ImmutableCollection<E> immutableCollection, Object[] objArr) {
        this(immutableCollection, ImmutableList.asImmutableList(objArr));
    }
}
