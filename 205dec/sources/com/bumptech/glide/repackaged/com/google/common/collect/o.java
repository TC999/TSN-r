package com.bumptech.glide.repackaged.com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: Lists.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class o {

    /* compiled from: Lists.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    private static class a<F, T> extends AbstractList<T> implements Serializable, RandomAccess {

        /* renamed from: a  reason: collision with root package name */
        final List<F> f17701a;

        /* renamed from: b  reason: collision with root package name */
        final com.bumptech.glide.repackaged.com.google.common.base.a<? super F, ? extends T> f17702b;

        /* compiled from: Lists.java */
        /* renamed from: com.bumptech.glide.repackaged.com.google.common.collect.o$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        class C0182a extends h0<F, T> {
            C0182a(ListIterator listIterator) {
                super(listIterator);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.bumptech.glide.repackaged.com.google.common.collect.g0
            public T a(F f4) {
                return a.this.f17702b.apply(f4);
            }
        }

        a(List<F> list, com.bumptech.glide.repackaged.com.google.common.base.a<? super F, ? extends T> aVar) {
            this.f17701a = (List) com.bumptech.glide.repackaged.com.google.common.base.d.i(list);
            this.f17702b = (com.bumptech.glide.repackaged.com.google.common.base.a) com.bumptech.glide.repackaged.com.google.common.base.d.i(aVar);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.f17701a.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i4) {
            return this.f17702b.apply((F) this.f17701a.get(i4));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f17701a.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i4) {
            return new C0182a(this.f17701a.listIterator(i4));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i4) {
            return this.f17702b.apply((F) this.f17701a.remove(i4));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f17701a.size();
        }
    }

    /* compiled from: Lists.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    private static class b<F, T> extends AbstractSequentialList<T> implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        final List<F> f17704a;

        /* renamed from: b  reason: collision with root package name */
        final com.bumptech.glide.repackaged.com.google.common.base.a<? super F, ? extends T> f17705b;

        /* compiled from: Lists.java */
        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        class a extends h0<F, T> {
            a(ListIterator listIterator) {
                super(listIterator);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.bumptech.glide.repackaged.com.google.common.collect.g0
            public T a(F f4) {
                return b.this.f17705b.apply(f4);
            }
        }

        b(List<F> list, com.bumptech.glide.repackaged.com.google.common.base.a<? super F, ? extends T> aVar) {
            this.f17704a = (List) com.bumptech.glide.repackaged.com.google.common.base.d.i(list);
            this.f17705b = (com.bumptech.glide.repackaged.com.google.common.base.a) com.bumptech.glide.repackaged.com.google.common.base.d.i(aVar);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.f17704a.clear();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i4) {
            return new a(this.f17704a.listIterator(i4));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f17704a.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(List<?> list, Object obj) {
        if (obj == com.bumptech.glide.repackaged.com.google.common.base.d.i(list)) {
            return true;
        }
        if (obj instanceof List) {
            List list2 = (List) obj;
            int size = list.size();
            if (size != list2.size()) {
                return false;
            }
            if ((list instanceof RandomAccess) && (list2 instanceof RandomAccess)) {
                for (int i4 = 0; i4 < size; i4++) {
                    if (!com.bumptech.glide.repackaged.com.google.common.base.c.a(list.get(i4), list2.get(i4))) {
                        return false;
                    }
                }
                return true;
            }
            return n.d(list.iterator(), list2.iterator());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return c(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (com.bumptech.glide.repackaged.com.google.common.base.c.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int c(List<?> list, Object obj) {
        int size = list.size();
        int i4 = 0;
        if (obj == null) {
            while (i4 < size) {
                if (list.get(i4) == null) {
                    return i4;
                }
                i4++;
            }
            return -1;
        }
        while (i4 < size) {
            if (obj.equals(list.get(i4))) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return e(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (com.bumptech.glide.repackaged.com.google.common.base.c.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int e(List<?> list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> ArrayList<E> f() {
        return new ArrayList<>();
    }

    public static <E> ArrayList<E> g(Iterable<? extends E> iterable) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(iterable);
        return iterable instanceof Collection ? new ArrayList<>(d.a(iterable)) : h(iterable.iterator());
    }

    public static <E> ArrayList<E> h(Iterator<? extends E> it) {
        ArrayList<E> f4 = f();
        n.a(f4, it);
        return f4;
    }

    public static <F, T> List<T> i(List<F> list, com.bumptech.glide.repackaged.com.google.common.base.a<? super F, ? extends T> aVar) {
        return list instanceof RandomAccess ? new a(list, aVar) : new b(list, aVar);
    }
}
