package com.bytedance.adsdk.lottie;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
abstract class j<K, V> {

    /* renamed from: a  reason: collision with root package name */
    j<K, V>.b f25634a;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    final class a<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f25635a;

        /* renamed from: b  reason: collision with root package name */
        int f25636b;

        /* renamed from: c  reason: collision with root package name */
        int f25637c;

        /* renamed from: d  reason: collision with root package name */
        boolean f25638d = false;

        a(int i4) {
            this.f25635a = i4;
            this.f25636b = j.this.a();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25637c < this.f25636b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T t3 = (T) j.this.c(this.f25637c, this.f25635a);
                this.f25637c++;
                this.f25638d = true;
                return t3;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f25638d) {
                int i4 = this.f25637c - 1;
                this.f25637c = i4;
                this.f25636b--;
                this.f25638d = false;
                j.this.d(i4);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    final class b implements Set<K> {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k4) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            j.this.l();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return j.this.b(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return j.e(j.this.i(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return j.f(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i4 = 0;
            for (int a4 = j.this.a() - 1; a4 >= 0; a4--) {
                Object c4 = j.this.c(a4, 0);
                i4 += c4 == null ? 0 : c4.hashCode();
            }
            return i4;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return j.this.a() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int b4 = j.this.b(obj);
            if (b4 >= 0) {
                j.this.d(b4);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return j.j(j.this.i(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return j.m(j.this.i(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return j.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return j.this.k(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) j.this.g(tArr, 0);
        }
    }

    public static <K, V> boolean e(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean f(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean m(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int a();

    protected abstract int b(Object obj);

    protected abstract Object c(int i4, int i5);

    protected abstract void d(int i4);

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] g(T[] tArr, int i4) {
        int a4 = a();
        if (tArr.length < a4) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), a4));
        }
        for (int i5 = 0; i5 < a4; i5++) {
            tArr[i5] = c(i5, i4);
        }
        if (tArr.length > a4) {
            tArr[a4] = null;
        }
        return tArr;
    }

    public Set<K> h() {
        if (this.f25634a == null) {
            this.f25634a = new b();
        }
        return this.f25634a;
    }

    protected abstract Map<K, V> i();

    public Object[] k(int i4) {
        int a4 = a();
        Object[] objArr = new Object[a4];
        for (int i5 = 0; i5 < a4; i5++) {
            objArr[i5] = c(i5, i4);
        }
        return objArr;
    }

    protected abstract void l();
}
