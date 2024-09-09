package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Comparator;

/* compiled from: ImmutableSortedAsList.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
final class k<E> extends v<E> implements e0<E> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ImmutableSortedSet<E> immutableSortedSet, ImmutableList<E> immutableList) {
        super(immutableSortedSet, immutableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.v, com.bumptech.glide.repackaged.com.google.common.collect.i
    /* renamed from: c */
    public ImmutableSortedSet<E> a() {
        return (ImmutableSortedSet) super.a();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.e0, java.util.SortedSet
    public Comparator<? super E> comparator() {
        return a().comparator();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.i, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
    public int indexOf(Object obj) {
        int indexOf = a().indexOf(obj);
        if (indexOf < 0 || !get(indexOf).equals(obj)) {
            return -1;
        }
        return indexOf;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
    public int lastIndexOf(Object obj) {
        return indexOf(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList
    public ImmutableList<E> subListUnchecked(int i4, int i5) {
        return new y(super.subListUnchecked(i4, i5), comparator()).asList();
    }
}
