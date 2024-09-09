package com.bumptech.glide.repackaged.com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\4499832.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private transient ImmutableList<E> asList;

    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static abstract class a<E> extends b<E> {

        /* renamed from: a  reason: collision with root package name */
        Object[] f17654a;

        /* renamed from: b  reason: collision with root package name */
        int f17655b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i4) {
            c.a(i4, "initialCapacity");
            this.f17654a = new Object[i4];
            this.f17655b = 0;
        }

        private void e(int i4) {
            Object[] objArr = this.f17654a;
            if (objArr.length < i4) {
                this.f17654a = r.a(objArr, b.c(objArr.length, i4));
            }
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection.b
        /* renamed from: d */
        public a<E> a(E e4) {
            com.bumptech.glide.repackaged.com.google.common.base.d.i(e4);
            e(this.f17655b + 1);
            Object[] objArr = this.f17654a;
            int i4 = this.f17655b;
            this.f17655b = i4 + 1;
            objArr[i4] = e4;
            return this;
        }
    }

    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static abstract class b<E> {
        b() {
        }

        static int c(int i4, int i5) {
            if (i5 >= 0) {
                int i6 = i4 + (i4 >> 1) + 1;
                if (i6 < i5) {
                    i6 = Integer.highestOneBit(i5 - 1) << 1;
                }
                if (i6 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i6;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        public abstract b<E> a(E e4);

        public b<E> b(Iterator<? extends E> it) {
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e4) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList == null) {
            ImmutableList<E> createAsList = createAsList();
            this.asList = createAsList;
            return createAsList;
        }
        return immutableList;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(Object obj);

    int copyIntoArray(Object[] objArr, int i4) {
        Iterator it = iterator();
        while (it.hasNext()) {
            objArr[i4] = it.next();
            i4++;
        }
        return i4;
    }

    ImmutableList<E> createAsList() {
        int size = size();
        if (size != 0) {
            if (size != 1) {
                return new v(this, toArray());
            }
            return ImmutableList.of((Object) iterator().next());
        }
        return ImmutableList.of();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract i0<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        int size = size();
        if (size == 0) {
            return r.f17708a;
        }
        Object[] objArr = new Object[size];
        copyIntoArray(objArr, 0);
        return objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(tArr);
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) r.e(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }
}
