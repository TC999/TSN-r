package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* loaded from: E:\TSN-r\205dec\4499832.dex */
public abstract class ImmutableSortedSet<E> extends l<E> implements e0<E>, NavigableSet<E> {
    private static final y<Comparable> NATURAL_EMPTY_SET;
    private static final Comparator<Comparable> NATURAL_ORDER;
    final transient Comparator<? super E> comparator;
    transient ImmutableSortedSet<E> descendingSet;

    static {
        s b4 = s.b();
        NATURAL_ORDER = b4;
        NATURAL_EMPTY_SET = new y<>(ImmutableList.of(), b4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedSet(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> y<E> emptySet(Comparator<? super E> comparator) {
        if (NATURAL_ORDER.equals(comparator)) {
            return (y<E>) NATURAL_EMPTY_SET;
        }
        return new y<>(ImmutableList.of(), comparator);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e4) {
        return (E) m.c(tailSet((ImmutableSortedSet<E>) e4, true), null);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.e0, java.util.SortedSet
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    ImmutableSortedSet<E> createDescendingSet() {
        return new f(this);
    }

    @Override // java.util.NavigableSet
    public abstract i0<E> descendingIterator();

    @Override // java.util.SortedSet
    public E first() {
        return iterator().next();
    }

    @Override // java.util.NavigableSet
    public E floor(E e4) {
        return (E) n.i(headSet((ImmutableSortedSet<E>) e4, true).descendingIterator(), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object obj, boolean z3) {
        return headSet((ImmutableSortedSet<E>) obj, z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ImmutableSortedSet<E> headSetImpl(E e4, boolean z3);

    @Override // java.util.NavigableSet
    public E higher(E e4) {
        return (E) m.c(tailSet((ImmutableSortedSet<E>) e4, false), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int indexOf(Object obj);

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract i0<E> iterator();

    @Override // java.util.SortedSet
    public E last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    public E lower(E e4) {
        return (E) n.i(headSet((ImmutableSortedSet<E>) e4, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object obj, boolean z3, Object obj2, boolean z4) {
        return subSet((boolean) obj, z3, (boolean) obj2, z4);
    }

    abstract ImmutableSortedSet<E> subSetImpl(E e4, boolean z3, E e5, boolean z4);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object obj, boolean z3) {
        return tailSet((ImmutableSortedSet<E>) obj, z3);
    }

    abstract ImmutableSortedSet<E> tailSetImpl(E e4, boolean z3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int unsafeCompare(Object obj, Object obj2) {
        return unsafeCompare(this.comparator, obj, obj2);
    }

    static int unsafeCompare(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.descendingSet;
        if (immutableSortedSet == null) {
            ImmutableSortedSet<E> createDescendingSet = createDescendingSet();
            this.descendingSet = createDescendingSet;
            createDescendingSet.descendingSet = this;
            return createDescendingSet;
        }
        return immutableSortedSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return headSet((ImmutableSortedSet<E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet((ImmutableSortedSet<E>) obj);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> headSet(E e4) {
        return headSet((ImmutableSortedSet<E>) e4, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> subSet(E e4, E e5) {
        return subSet((boolean) e4, true, (boolean) e5, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> tailSet(E e4) {
        return tailSet((ImmutableSortedSet<E>) e4, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> headSet(E e4, boolean z3) {
        return headSetImpl(com.bumptech.glide.repackaged.com.google.common.base.d.i(e4), z3);
    }

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> subSet(E e4, boolean z3, E e5, boolean z4) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(e4);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(e5);
        com.bumptech.glide.repackaged.com.google.common.base.d.d(this.comparator.compare(e4, e5) <= 0);
        return subSetImpl(e4, z3, e5, z4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> tailSet(E e4, boolean z3) {
        return tailSetImpl(com.bumptech.glide.repackaged.com.google.common.base.d.i(e4), z3);
    }
}
