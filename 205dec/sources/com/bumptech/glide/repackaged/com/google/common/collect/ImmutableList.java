package com.bumptech.glide.repackaged.com.google.common.collect;

import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: E:\TSN-r\205dec\4499832.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class a extends com.bumptech.glide.repackaged.com.google.common.collect.a<E> {
        a(int i4, int i5) {
            super(i4, i5);
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.a
        protected E a(int i4) {
            return ImmutableList.this.get(i4);
        }
    }

    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class b<E> extends ImmutableCollection.a<E> {
        public b() {
            this(4);
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection.a
        /* renamed from: f */
        public b<E> d(E e4) {
            super.a(e4);
            return this;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection.b
        /* renamed from: g */
        public b<E> b(Iterator<? extends E> it) {
            super.b(it);
            return this;
        }

        public ImmutableList<E> h() {
            return ImmutableList.asImmutableList(this.f17654a, this.f17655b);
        }

        b(int i4) {
            super(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static class c<E> extends ImmutableList<E> {

        /* renamed from: a  reason: collision with root package name */
        private final transient ImmutableList<E> f17657a;

        c(ImmutableList<E> immutableList) {
            this.f17657a = immutableList;
        }

        private int a(int i4) {
            return (size() - 1) - i4;
        }

        private int c(int i4) {
            return size() - i4;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f17657a.contains(obj);
        }

        @Override // java.util.List
        public E get(int i4) {
            com.bumptech.glide.repackaged.com.google.common.base.d.g(i4, size());
            return this.f17657a.get(a(i4));
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(Object obj) {
            int lastIndexOf = this.f17657a.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return a(lastIndexOf);
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.f17657a.isPartialView();
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(Object obj) {
            int indexOf = this.f17657a.indexOf(obj);
            if (indexOf >= 0) {
                return a(indexOf);
            }
            return -1;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.f17657a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f17657a.size();
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i4) {
            return super.listIterator(i4);
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i4, int i5) {
            com.bumptech.glide.repackaged.com.google.common.base.d.m(i4, i5, size());
            return this.f17657a.subList(c(i5), c(i4)).reverse();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public class d extends ImmutableList<E> {

        /* renamed from: a  reason: collision with root package name */
        final transient int f17658a;

        /* renamed from: b  reason: collision with root package name */
        final transient int f17659b;

        d(int i4, int i5) {
            this.f17658a = i4;
            this.f17659b = i5;
        }

        @Override // java.util.List
        public E get(int i4) {
            com.bumptech.glide.repackaged.com.google.common.base.d.g(i4, this.f17659b);
            return ImmutableList.this.get(i4 + this.f17658a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f17659b;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i4) {
            return super.listIterator(i4);
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i4, int i5) {
            com.bumptech.glide.repackaged.com.google.common.base.d.m(i4, i5, this.f17659b);
            ImmutableList immutableList = ImmutableList.this;
            int i6 = this.f17658a;
            return immutableList.subList(i4 + i6, i5 + i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableList<E> asImmutableList(Object[] objArr) {
        return asImmutableList(objArr, objArr.length);
    }

    private static <E> ImmutableList<E> construct(Object... objArr) {
        return asImmutableList(r.c(objArr));
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> iterable) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(iterable);
        return iterable instanceof Collection ? copyOf((Collection) iterable) : copyOf(iterable.iterator());
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) w.f17711d;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i4, E e4) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i4, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    public final ImmutableList<E> asList() {
        return this;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i4) {
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            objArr[i4 + i5] = get(i5);
        }
        return i4 + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return o.a(this, obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i4 = 1;
        for (int i5 = 0; i5 < size; i5++) {
            i4 = (((i4 * 31) + get(i5).hashCode()) ^ (-1)) ^ (-1);
        }
        return i4;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return o.b(this, obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return o.d(this, obj);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i4) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> reverse() {
        return size() <= 1 ? this : new c(this);
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i4, E e4) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableList<E> subListUnchecked(int i4, int i5) {
        return new d(i4, i5 - i4);
    }

    static <E> ImmutableList<E> asImmutableList(Object[] objArr, int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 < objArr.length) {
                    objArr = r.a(objArr, i4);
                }
                return new w(objArr);
            }
            return new c0(objArr[0]);
        }
        return of();
    }

    public static <E> ImmutableList<E> of(E e4) {
        return new c0(e4);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public i0<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int i4, int i5) {
        com.bumptech.glide.repackaged.com.google.common.base.d.m(i4, i5, size());
        int i6 = i5 - i4;
        if (i6 == size()) {
            return this;
        }
        if (i6 != 0) {
            if (i6 != 1) {
                return subListUnchecked(i4, i5);
            }
            return of((Object) get(i4));
        }
        return of();
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> collection) {
        if (collection instanceof ImmutableCollection) {
            ImmutableList<E> asList = ((ImmutableCollection) collection).asList();
            return asList.isPartialView() ? asImmutableList(asList.toArray()) : asList;
        }
        return construct(collection.toArray());
    }

    public static <E> ImmutableList<E> of(E e4, E e5) {
        return construct(e4, e5);
    }

    @Override // java.util.List
    public j0<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public j0<E> listIterator(int i4) {
        return new a(size(), i4);
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new b().d(next).b(it).h();
    }
}
