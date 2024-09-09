package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: Iterators.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    static final j0<Object> f17688a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final Iterator<Object> f17689b = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterators.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static class a<T> extends com.bumptech.glide.repackaged.com.google.common.collect.a<T> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object[] f17690c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f17691d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i4, int i5, Object[] objArr, int i6) {
            super(i4, i5);
            this.f17690c = objArr;
            this.f17691d = i6;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.a
        protected T a(int i4) {
            return (T) this.f17690c[this.f17691d + i4];
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterators.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static class b<T> extends i0<T> {

        /* renamed from: a  reason: collision with root package name */
        boolean f17692a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f17693b;

        b(Object obj) {
            this.f17693b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f17692a;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f17692a) {
                this.f17692a = true;
                return (T) this.f17693b;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: Iterators.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static class c extends j0<Object> {
        c() {
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return false;
        }

        @Override // java.util.Iterator, java.util.ListIterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return 0;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return -1;
        }
    }

    /* compiled from: Iterators.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static class d implements Iterator<Object> {
        d() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            com.bumptech.glide.repackaged.com.google.common.collect.c.b(false);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterators.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static class e<T> extends i0<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterator f17694a;

        e(Iterator it) {
            this.f17694a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f17694a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.f17694a.next();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterators.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static class f<T> extends com.bumptech.glide.repackaged.com.google.common.collect.b<T> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Iterator f17695c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.repackaged.com.google.common.base.e f17696d;

        f(Iterator it, com.bumptech.glide.repackaged.com.google.common.base.e eVar) {
            this.f17695c = it;
            this.f17696d = eVar;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.b
        protected T a() {
            while (this.f17695c.hasNext()) {
                T t3 = (T) this.f17695c.next();
                if (this.f17696d.apply(t3)) {
                    return t3;
                }
            }
            return b();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, F] */
    /* compiled from: Iterators.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static class g<F, T> extends g0<F, T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.repackaged.com.google.common.base.a f17697b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(Iterator it, com.bumptech.glide.repackaged.com.google.common.base.a aVar) {
            super(it);
            this.f17697b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.bumptech.glide.repackaged.com.google.common.collect.g0
        public T a(F f4) {
            return (T) this.f17697b.apply(f4);
        }
    }

    /* compiled from: Iterators.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    private static class h<E> implements t<E> {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<? extends E> f17698a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f17699b;

        /* renamed from: c  reason: collision with root package name */
        private E f17700c;

        public h(Iterator<? extends E> it) {
            this.f17698a = (Iterator) com.bumptech.glide.repackaged.com.google.common.base.d.i(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f17699b || this.f17698a.hasNext();
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.t, java.util.Iterator
        public E next() {
            if (!this.f17699b) {
                return this.f17698a.next();
            }
            E e4 = this.f17700c;
            this.f17699b = false;
            this.f17700c = null;
            return e4;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.t
        public E peek() {
            if (!this.f17699b) {
                this.f17700c = this.f17698a.next();
                this.f17699b = true;
            }
            return this.f17700c;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.bumptech.glide.repackaged.com.google.common.base.d.o(!this.f17699b, "Can't remove after you've peeked at next");
            this.f17698a.remove();
        }
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(collection);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(it);
        boolean z3 = false;
        while (it.hasNext()) {
            z3 |= collection.add(it.next());
        }
        return z3;
    }

    public static <T> boolean b(Iterator<T> it, com.bumptech.glide.repackaged.com.google.common.base.e<? super T> eVar) {
        return k(it, eVar) != -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> ListIterator<T> c(Iterator<T> it) {
        return (ListIterator) it;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean d(java.util.Iterator<?> r3, java.util.Iterator<?> r4) {
        /*
        L0:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L1d
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 != 0) goto Le
            return r1
        Le:
            java.lang.Object r0 = r3.next()
            java.lang.Object r2 = r4.next()
            boolean r0 = com.bumptech.glide.repackaged.com.google.common.base.c.a(r0, r2)
            if (r0 != 0) goto L0
            return r1
        L1d:
            boolean r3 = r4.hasNext()
            r3 = r3 ^ 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.repackaged.com.google.common.collect.n.d(java.util.Iterator, java.util.Iterator):boolean");
    }

    static <T> j0<T> e() {
        return (j0<T>) f17688a;
    }

    public static <T> i0<T> f(Iterator<T> it, com.bumptech.glide.repackaged.com.google.common.base.e<? super T> eVar) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(it);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(eVar);
        return new f(it, eVar);
    }

    public static <T> i0<T> g(T... tArr) {
        return h(tArr, 0, tArr.length, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> j0<T> h(T[] tArr, int i4, int i5, int i6) {
        com.bumptech.glide.repackaged.com.google.common.base.d.d(i5 >= 0);
        com.bumptech.glide.repackaged.com.google.common.base.d.m(i4, i4 + i5, tArr.length);
        com.bumptech.glide.repackaged.com.google.common.base.d.k(i6, i5);
        if (i5 == 0) {
            return e();
        }
        return new a(i5, i6, tArr, i4);
    }

    public static <T> T i(Iterator<? extends T> it, T t3) {
        return it.hasNext() ? it.next() : t3;
    }

    public static <T> T j(Iterator<T> it) {
        T next = it.next();
        if (it.hasNext()) {
            StringBuilder sb = new StringBuilder();
            sb.append("expected one element but was: <" + next);
            for (int i4 = 0; i4 < 4 && it.hasNext(); i4++) {
                sb.append(", " + it.next());
            }
            if (it.hasNext()) {
                sb.append(", ...");
            }
            sb.append('>');
            throw new IllegalArgumentException(sb.toString());
        }
        return next;
    }

    public static <T> int k(Iterator<T> it, com.bumptech.glide.repackaged.com.google.common.base.e<? super T> eVar) {
        com.bumptech.glide.repackaged.com.google.common.base.d.j(eVar, "predicate");
        int i4 = 0;
        while (it.hasNext()) {
            if (eVar.apply(it.next())) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public static <T> t<T> l(Iterator<? extends T> it) {
        if (it instanceof h) {
            return (h) it;
        }
        return new h(it);
    }

    public static <T> i0<T> m(T t3) {
        return new b(t3);
    }

    public static String n(Iterator<?> it) {
        com.bumptech.glide.repackaged.com.google.common.base.b bVar = com.bumptech.glide.repackaged.com.google.common.collect.d.f17673a;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        StringBuilder b4 = bVar.b(sb, it);
        b4.append(']');
        return b4.toString();
    }

    public static <F, T> Iterator<T> o(Iterator<F> it, com.bumptech.glide.repackaged.com.google.common.base.a<? super F, ? extends T> aVar) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(aVar);
        return new g(it, aVar);
    }

    public static <T> i0<T> p(Iterator<T> it) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(it);
        if (it instanceof i0) {
            return (i0) it;
        }
        return new e(it);
    }
}
