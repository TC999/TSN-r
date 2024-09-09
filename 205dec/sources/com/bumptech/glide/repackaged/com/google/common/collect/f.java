package com.bumptech.glide.repackaged.com.google.common.collect;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DescendingImmutableSortedSet.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public class f<E> extends ImmutableSortedSet<E> {

    /* renamed from: a  reason: collision with root package name */
    private final ImmutableSortedSet<E> f17677a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ImmutableSortedSet<E> immutableSortedSet) {
        super(s.a(immutableSortedSet.comparator()).c());
        this.f17677a = immutableSortedSet;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E ceiling(E e4) {
        return this.f17677a.floor(e4);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f17677a.contains(obj);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> createDescendingSet() {
        throw new AssertionError("should never be called");
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E floor(E e4) {
        return this.f17677a.ceiling(e4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> headSetImpl(E e4, boolean z3) {
        return this.f17677a.tailSet((ImmutableSortedSet<E>) e4, z3).descendingSet();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E higher(E e4) {
        return this.f17677a.lower(e4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    public int indexOf(Object obj) {
        int indexOf = this.f17677a.indexOf(obj);
        return indexOf == -1 ? indexOf : (size() - 1) - indexOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f17677a.isPartialView();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E lower(E e4) {
        return this.f17677a.higher(e4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f17677a.size();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> subSetImpl(E e4, boolean z3, E e5, boolean z4) {
        return this.f17677a.subSet((boolean) e5, z4, (boolean) e4, z3).descendingSet();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> tailSetImpl(E e4, boolean z3) {
        return this.f17677a.headSet((ImmutableSortedSet<E>) e4, z3).descendingSet();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public i0<E> descendingIterator() {
        return this.f17677a.iterator();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public ImmutableSortedSet<E> descendingSet() {
        return this.f17677a;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public i0<E> iterator() {
        return this.f17677a.descendingIterator();
    }
}
