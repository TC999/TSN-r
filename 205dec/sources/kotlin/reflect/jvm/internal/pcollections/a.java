package kotlin.reflect.jvm.internal.pcollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: ConsPStack.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class a<E> implements Iterable<E> {

    /* renamed from: d  reason: collision with root package name */
    private static final a<Object> f58612d = new a<>();

    /* renamed from: a  reason: collision with root package name */
    final E f58613a;

    /* renamed from: b  reason: collision with root package name */
    final a<E> f58614b;

    /* renamed from: c  reason: collision with root package name */
    private final int f58615c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConsPStack.java */
    /* renamed from: kotlin.reflect.jvm.internal.pcollections.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class C1192a<E> implements Iterator<E> {

        /* renamed from: a  reason: collision with root package name */
        private a<E> f58616a;

        public C1192a(a<E> aVar) {
            this.f58616a = aVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return ((a) this.f58616a).f58615c > 0;
        }

        @Override // java.util.Iterator
        public E next() {
            a<E> aVar = this.f58616a;
            E e4 = aVar.f58613a;
            this.f58616a = aVar.f58614b;
            return e4;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private a() {
        this.f58615c = 0;
        this.f58613a = null;
        this.f58614b = null;
    }

    public static <E> a<E> c() {
        return (a<E>) f58612d;
    }

    private Iterator<E> g(int i4) {
        return new C1192a(n(i4));
    }

    private a<E> l(Object obj) {
        if (this.f58615c == 0) {
            return this;
        }
        if (this.f58613a.equals(obj)) {
            return this.f58614b;
        }
        a<E> l4 = this.f58614b.l(obj);
        return l4 == this.f58614b ? this : new a<>(this.f58613a, l4);
    }

    private a<E> n(int i4) {
        if (i4 < 0 || i4 > this.f58615c) {
            throw new IndexOutOfBoundsException();
        }
        return i4 == 0 ? this : this.f58614b.n(i4 - 1);
    }

    public E get(int i4) {
        if (i4 >= 0 && i4 <= this.f58615c) {
            try {
                return g(i4).next();
            } catch (NoSuchElementException unused) {
                throw new IndexOutOfBoundsException("Index: " + i4);
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return g(0);
    }

    public a<E> k(int i4) {
        return l(get(i4));
    }

    public a<E> m(E e4) {
        return new a<>(e4, this);
    }

    public int size() {
        return this.f58615c;
    }

    private a(E e4, a<E> aVar) {
        this.f58613a = e4;
        this.f58614b = aVar;
        this.f58615c = aVar.f58615c + 1;
    }
}
