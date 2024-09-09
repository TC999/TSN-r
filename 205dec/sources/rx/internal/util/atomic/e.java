package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.p;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SpscLinkedArrayQueue.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class e<T> implements Queue<T> {

    /* renamed from: i  reason: collision with root package name */
    static final int f63890i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j  reason: collision with root package name */
    private static final Object f63891j = new Object();

    /* renamed from: a  reason: collision with root package name */
    final AtomicLong f63892a;

    /* renamed from: b  reason: collision with root package name */
    int f63893b;

    /* renamed from: c  reason: collision with root package name */
    long f63894c;

    /* renamed from: d  reason: collision with root package name */
    int f63895d;

    /* renamed from: e  reason: collision with root package name */
    AtomicReferenceArray<Object> f63896e;

    /* renamed from: f  reason: collision with root package name */
    int f63897f;

    /* renamed from: g  reason: collision with root package name */
    AtomicReferenceArray<Object> f63898g;

    /* renamed from: h  reason: collision with root package name */
    final AtomicLong f63899h;

    public e(int i4) {
        int b4 = p.b(i4);
        int i5 = b4 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(b4 + 1);
        this.f63896e = atomicReferenceArray;
        this.f63895d = i5;
        a(b4);
        this.f63898g = atomicReferenceArray;
        this.f63897f = i5;
        this.f63894c = i5 - 1;
        this.f63892a = new AtomicLong();
        this.f63899h = new AtomicLong();
    }

    private void a(int i4) {
        this.f63893b = Math.min(i4 / 4, f63890i);
    }

    private static int b(int i4) {
        return i4;
    }

    private static int c(long j4, int i4) {
        return b(((int) j4) & i4);
    }

    private long d() {
        return this.f63899h.get();
    }

    private long e() {
        return this.f63892a.get();
    }

    private long f() {
        return this.f63899h.get();
    }

    private static <E> Object g(AtomicReferenceArray<Object> atomicReferenceArray, int i4) {
        return atomicReferenceArray.get(i4);
    }

    private AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) g(atomicReferenceArray, b(atomicReferenceArray.length() - 1));
    }

    private long i() {
        return this.f63892a.get();
    }

    private T j(AtomicReferenceArray<Object> atomicReferenceArray, long j4, int i4) {
        this.f63898g = atomicReferenceArray;
        return (T) g(atomicReferenceArray, c(j4, i4));
    }

    private T k(AtomicReferenceArray<Object> atomicReferenceArray, long j4, int i4) {
        this.f63898g = atomicReferenceArray;
        int c4 = c(j4, i4);
        T t3 = (T) g(atomicReferenceArray, c4);
        if (t3 == null) {
            return null;
        }
        o(atomicReferenceArray, c4, null);
        n(j4 + 1);
        return t3;
    }

    private void m(AtomicReferenceArray<Object> atomicReferenceArray, long j4, int i4, T t3, long j5) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f63896e = atomicReferenceArray2;
        this.f63894c = (j5 + j4) - 1;
        o(atomicReferenceArray2, i4, t3);
        p(atomicReferenceArray, atomicReferenceArray2);
        o(atomicReferenceArray, i4, f63891j);
        q(j4 + 1);
    }

    private void n(long j4) {
        this.f63899h.lazySet(j4);
    }

    private static void o(AtomicReferenceArray<Object> atomicReferenceArray, int i4, Object obj) {
        atomicReferenceArray.lazySet(i4, obj);
    }

    private void p(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        o(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void q(long j4) {
        this.f63892a.lazySet(j4);
    }

    private boolean r(AtomicReferenceArray<Object> atomicReferenceArray, T t3, long j4, int i4) {
        o(atomicReferenceArray, i4, t3);
        q(j4 + 1);
        return true;
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return i() == f();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public boolean l(T t3, T t4) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f63896e;
        long i4 = i();
        int i5 = this.f63895d;
        long j4 = 2 + i4;
        if (g(atomicReferenceArray, c(j4, i5)) == null) {
            int c4 = c(i4, i5);
            o(atomicReferenceArray, c4 + 1, t4);
            o(atomicReferenceArray, c4, t3);
            q(j4);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f63896e = atomicReferenceArray2;
        int c5 = c(i4, i5);
        o(atomicReferenceArray2, c5 + 1, t4);
        o(atomicReferenceArray2, c5, t3);
        p(atomicReferenceArray, atomicReferenceArray2);
        o(atomicReferenceArray, c5, f63891j);
        q(j4);
        return true;
    }

    @Override // java.util.Queue
    public boolean offer(T t3) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f63896e;
        long e4 = e();
        int i4 = this.f63895d;
        int c4 = c(e4, i4);
        if (e4 < this.f63894c) {
            return r(atomicReferenceArray, t3, e4, c4);
        }
        long j4 = this.f63893b + e4;
        if (g(atomicReferenceArray, c(j4, i4)) == null) {
            this.f63894c = j4 - 1;
            return r(atomicReferenceArray, t3, e4, c4);
        } else if (g(atomicReferenceArray, c(1 + e4, i4)) == null) {
            return r(atomicReferenceArray, t3, e4, c4);
        } else {
            m(atomicReferenceArray, e4, c4, t3, i4);
            return true;
        }
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f63898g;
        long d4 = d();
        int i4 = this.f63897f;
        T t3 = (T) g(atomicReferenceArray, c(d4, i4));
        return t3 == f63891j ? j(h(atomicReferenceArray), d4, i4) : t3;
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f63898g;
        long d4 = d();
        int i4 = this.f63897f;
        int c4 = c(d4, i4);
        T t3 = (T) g(atomicReferenceArray, c4);
        boolean z3 = t3 == f63891j;
        if (t3 == null || z3) {
            if (z3) {
                return k(h(atomicReferenceArray), d4, i4);
            }
            return null;
        }
        o(atomicReferenceArray, c4, null);
        n(d4 + 1);
        return t3;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public int size() {
        long f4 = f();
        while (true) {
            long i4 = i();
            long f5 = f();
            if (f4 == f5) {
                return (int) (i4 - f5);
            }
            f4 = f5;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }
}
