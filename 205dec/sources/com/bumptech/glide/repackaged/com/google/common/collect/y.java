package com.bumptech.glide.repackaged.com.google.common.collect;

import com.bumptech.glide.repackaged.com.google.common.collect.SortedLists;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableSortedSet.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class y<E> extends ImmutableSortedSet<E> {

    /* renamed from: a  reason: collision with root package name */
    private final transient ImmutableList<E> f17720a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ImmutableList<E> immutableList, Comparator<? super E> comparator) {
        super(comparator);
        this.f17720a = immutableList;
    }

    private int k(Object obj) throws ClassCastException {
        return Collections.binarySearch(this.f17720a, obj, l());
    }

    y<E> a(int i4, int i5) {
        if (i4 == 0 && i5 == size()) {
            return this;
        }
        if (i4 < i5) {
            return new y<>(this.f17720a.subList(i4, i5), this.comparator);
        }
        return ImmutableSortedSet.emptySet(this.comparator);
    }

    int c(E e4, boolean z3) {
        return SortedLists.a(this.f17720a, com.bumptech.glide.repackaged.com.google.common.base.d.i(e4), comparator(), z3 ? SortedLists.KeyPresentBehavior.FIRST_AFTER : SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E ceiling(E e4) {
        int g4 = g(e4, true);
        if (g4 == size()) {
            return null;
        }
        return this.f17720a.get(g4);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj != null) {
            try {
                return k(obj) >= 0;
            } catch (ClassCastException unused) {
                return false;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof p) {
            collection = ((p) collection).h();
        }
        if (f0.b(comparator(), collection) && collection.size() > 1) {
            t l4 = n.l(iterator());
            Iterator<?> it = collection.iterator();
            Object next = it.next();
            while (l4.hasNext()) {
                try {
                    int unsafeCompare = unsafeCompare(l4.peek(), next);
                    if (unsafeCompare < 0) {
                        l4.next();
                    } else if (unsafeCompare == 0) {
                        if (!it.hasNext()) {
                            return true;
                        }
                        next = it.next();
                    } else if (unsafeCompare > 0) {
                        break;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return false;
        }
        return super.containsAll(collection);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] objArr, int i4) {
        return this.f17720a.copyIntoArray(objArr, i4);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    ImmutableList<E> createAsList() {
        return size() <= 1 ? this.f17720a : new k(this, this.f17720a);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> createDescendingSet() {
        s c4 = s.a(this.comparator).c();
        return isEmpty() ? ImmutableSortedSet.emptySet(c4) : new y(this.f17720a.reverse(), c4);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034 A[Catch: ClassCastException | NoSuchElementException -> 0x0046, TryCatch #0 {ClassCastException | NoSuchElementException -> 0x0046, blocks: (B:17:0x002a, B:18:0x002e, B:20:0x0034, B:22:0x003e), top: B:29:0x002a }] */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L4
            return r0
        L4:
            boolean r1 = r6 instanceof java.util.Set
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            java.util.Set r6 = (java.util.Set) r6
            int r1 = r5.size()
            int r3 = r6.size()
            if (r1 == r3) goto L17
            return r2
        L17:
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L1e
            return r0
        L1e:
            java.util.Comparator<? super E> r1 = r5.comparator
            boolean r1 = com.bumptech.glide.repackaged.com.google.common.collect.f0.b(r1, r6)
            if (r1 == 0) goto L47
            java.util.Iterator r6 = r6.iterator()
            com.bumptech.glide.repackaged.com.google.common.collect.i0 r1 = r5.iterator()     // Catch: java.lang.Throwable -> L46
        L2e:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Throwable -> L46
            if (r3 == 0) goto L45
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L46
            java.lang.Object r4 = r6.next()     // Catch: java.lang.Throwable -> L46
            if (r4 == 0) goto L44
            int r3 = r5.unsafeCompare(r3, r4)     // Catch: java.lang.Throwable -> L46
            if (r3 == 0) goto L2e
        L44:
            return r2
        L45:
            return r0
        L46:
            return r2
        L47:
            boolean r6 = r5.containsAll(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.repackaged.com.google.common.collect.y.equals(java.lang.Object):boolean");
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E first() {
        if (!isEmpty()) {
            return this.f17720a.get(0);
        }
        throw new NoSuchElementException();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E floor(E e4) {
        int c4 = c(e4, true) - 1;
        if (c4 == -1) {
            return null;
        }
        return this.f17720a.get(c4);
    }

    int g(E e4, boolean z3) {
        return SortedLists.a(this.f17720a, com.bumptech.glide.repackaged.com.google.common.base.d.i(e4), comparator(), z3 ? SortedLists.KeyPresentBehavior.FIRST_PRESENT : SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> headSetImpl(E e4, boolean z3) {
        return a(0, c(e4, z3));
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E higher(E e4) {
        int g4 = g(e4, false);
        if (g4 == size()) {
            return null;
        }
        return this.f17720a.get(g4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int a4 = SortedLists.a(this.f17720a, obj, l(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.INVERTED_INSERTION_INDEX);
            if (a4 >= 0) {
                return a4;
            }
            return -1;
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f17720a.isPartialView();
    }

    Comparator<Object> l() {
        return this.comparator;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E last() {
        if (!isEmpty()) {
            return this.f17720a.get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E lower(E e4) {
        int c4 = c(e4, false) - 1;
        if (c4 == -1) {
            return null;
        }
        return this.f17720a.get(c4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f17720a.size();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> subSetImpl(E e4, boolean z3, E e5, boolean z4) {
        return tailSetImpl(e4, z3).headSetImpl(e5, z4);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> tailSetImpl(E e4, boolean z3) {
        return a(g(e4, z3), size());
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public i0<E> descendingIterator() {
        return this.f17720a.reverse().iterator();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSortedSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public i0<E> iterator() {
        return this.f17720a.iterator();
    }
}
