package p640rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p640rx.internal.util.unsafe.Pow2;

/* renamed from: rx.internal.util.atomic.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SpscUnboundedAtomicArrayQueue<T> implements Queue<T> {

    /* renamed from: i */
    static final int f46469i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j */
    private static final Object f46470j = new Object();

    /* renamed from: a */
    final AtomicLong f46471a;

    /* renamed from: b */
    int f46472b;

    /* renamed from: c */
    long f46473c;

    /* renamed from: d */
    int f46474d;

    /* renamed from: e */
    AtomicReferenceArray<Object> f46475e;

    /* renamed from: f */
    int f46476f;

    /* renamed from: g */
    AtomicReferenceArray<Object> f46477g;

    /* renamed from: h */
    final AtomicLong f46478h;

    public SpscUnboundedAtomicArrayQueue(int i) {
        int m756b = Pow2.m756b(Math.max(8, i));
        int i2 = m756b - 1;
        this.f46471a = new AtomicLong();
        this.f46478h = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(m756b + 1);
        this.f46475e = atomicReferenceArray;
        this.f46474d = i2;
        m889a(m756b);
        this.f46477g = atomicReferenceArray;
        this.f46476f = i2;
        this.f46473c = i2 - 1;
        m874p(0L);
    }

    /* renamed from: a */
    private void m889a(int i) {
        this.f46472b = Math.min(i / 4, f46469i);
    }

    /* renamed from: b */
    private static int m888b(int i) {
        return i;
    }

    /* renamed from: c */
    private static int m887c(long j, int i) {
        return m888b(((int) j) & i);
    }

    /* renamed from: d */
    private long m886d() {
        return this.f46478h.get();
    }

    /* renamed from: e */
    private long m885e() {
        return this.f46471a.get();
    }

    /* renamed from: f */
    private long m884f() {
        return this.f46478h.get();
    }

    /* renamed from: g */
    private static <E> Object m883g(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    /* renamed from: h */
    private AtomicReferenceArray<Object> m882h(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) m883g(atomicReferenceArray, m888b(atomicReferenceArray.length() - 1));
    }

    /* renamed from: i */
    private long m881i() {
        return this.f46471a.get();
    }

    /* renamed from: j */
    private T m880j(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.f46477g = atomicReferenceArray;
        return (T) m883g(atomicReferenceArray, m887c(j, i));
    }

    /* renamed from: k */
    private T m879k(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.f46477g = atomicReferenceArray;
        int m887c = m887c(j, i);
        T t = (T) m883g(atomicReferenceArray, m887c);
        if (t == null) {
            return null;
        }
        m877m(j + 1);
        m876n(atomicReferenceArray, m887c, null);
        return t;
    }

    /* renamed from: l */
    private void m878l(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f46475e = atomicReferenceArray2;
        this.f46473c = (j2 + j) - 1;
        m874p(j + 1);
        m876n(atomicReferenceArray2, i, t);
        m875o(atomicReferenceArray, atomicReferenceArray2);
        m876n(atomicReferenceArray, i, f46470j);
    }

    /* renamed from: m */
    private void m877m(long j) {
        this.f46478h.lazySet(j);
    }

    /* renamed from: n */
    private static void m876n(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    /* renamed from: o */
    private void m875o(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        m876n(atomicReferenceArray, m888b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    /* renamed from: p */
    private void m874p(long j) {
        this.f46471a.lazySet(j);
    }

    /* renamed from: q */
    private boolean m873q(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        m874p(j + 1);
        m876n(atomicReferenceArray, i, t);
        return true;
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t) {
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
        return m881i() == m884f();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        t.getClass();
        AtomicReferenceArray<Object> atomicReferenceArray = this.f46475e;
        long m885e = m885e();
        int i = this.f46474d;
        int m887c = m887c(m885e, i);
        if (m885e < this.f46473c) {
            return m873q(atomicReferenceArray, t, m885e, m887c);
        }
        long j = this.f46472b + m885e;
        if (m883g(atomicReferenceArray, m887c(j, i)) == null) {
            this.f46473c = j - 1;
            return m873q(atomicReferenceArray, t, m885e, m887c);
        } else if (m883g(atomicReferenceArray, m887c(1 + m885e, i)) != null) {
            return m873q(atomicReferenceArray, t, m885e, m887c);
        } else {
            m878l(atomicReferenceArray, m885e, m887c, t, i);
            return true;
        }
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f46477g;
        long m886d = m886d();
        int i = this.f46476f;
        T t = (T) m883g(atomicReferenceArray, m887c(m886d, i));
        return t == f46470j ? m880j(m882h(atomicReferenceArray), m886d, i) : t;
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f46477g;
        long m886d = m886d();
        int i = this.f46476f;
        int m887c = m887c(m886d, i);
        T t = (T) m883g(atomicReferenceArray, m887c);
        boolean z = t == f46470j;
        if (t == null || z) {
            if (z) {
                return m879k(m882h(atomicReferenceArray), m886d, i);
            }
            return null;
        }
        m877m(m886d + 1);
        m876n(atomicReferenceArray, m887c, null);
        return t;
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
        long m884f = m884f();
        while (true) {
            long m881i = m881i();
            long m884f2 = m884f();
            if (m884f == m884f2) {
                return (int) (m881i - m884f2);
            }
            m884f = m884f2;
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
