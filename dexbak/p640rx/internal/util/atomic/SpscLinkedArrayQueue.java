package p640rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p640rx.internal.util.unsafe.Pow2;

/* renamed from: rx.internal.util.atomic.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SpscLinkedArrayQueue<T> implements Queue<T> {

    /* renamed from: i */
    static final int f46459i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: j */
    private static final Object f46460j = new Object();

    /* renamed from: a */
    final AtomicLong f46461a;

    /* renamed from: b */
    int f46462b;

    /* renamed from: c */
    long f46463c;

    /* renamed from: d */
    int f46464d;

    /* renamed from: e */
    AtomicReferenceArray<Object> f46465e;

    /* renamed from: f */
    int f46466f;

    /* renamed from: g */
    AtomicReferenceArray<Object> f46467g;

    /* renamed from: h */
    final AtomicLong f46468h;

    public SpscLinkedArrayQueue(int i) {
        int m756b = Pow2.m756b(i);
        int i2 = m756b - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(m756b + 1);
        this.f46465e = atomicReferenceArray;
        this.f46464d = i2;
        m907a(m756b);
        this.f46467g = atomicReferenceArray;
        this.f46466f = i2;
        this.f46463c = i2 - 1;
        this.f46461a = new AtomicLong();
        this.f46468h = new AtomicLong();
    }

    /* renamed from: a */
    private void m907a(int i) {
        this.f46462b = Math.min(i / 4, f46459i);
    }

    /* renamed from: b */
    private static int m906b(int i) {
        return i;
    }

    /* renamed from: c */
    private static int m905c(long j, int i) {
        return m906b(((int) j) & i);
    }

    /* renamed from: d */
    private long m904d() {
        return this.f46468h.get();
    }

    /* renamed from: e */
    private long m903e() {
        return this.f46461a.get();
    }

    /* renamed from: f */
    private long m902f() {
        return this.f46468h.get();
    }

    /* renamed from: g */
    private static <E> Object m901g(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    /* renamed from: h */
    private AtomicReferenceArray<Object> m900h(AtomicReferenceArray<Object> atomicReferenceArray) {
        return (AtomicReferenceArray) m901g(atomicReferenceArray, m906b(atomicReferenceArray.length() - 1));
    }

    /* renamed from: i */
    private long m899i() {
        return this.f46461a.get();
    }

    /* renamed from: j */
    private T m898j(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.f46467g = atomicReferenceArray;
        return (T) m901g(atomicReferenceArray, m905c(j, i));
    }

    /* renamed from: k */
    private T m897k(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.f46467g = atomicReferenceArray;
        int m905c = m905c(j, i);
        T t = (T) m901g(atomicReferenceArray, m905c);
        if (t == null) {
            return null;
        }
        m893o(atomicReferenceArray, m905c, null);
        m894n(j + 1);
        return t;
    }

    /* renamed from: m */
    private void m895m(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f46465e = atomicReferenceArray2;
        this.f46463c = (j2 + j) - 1;
        m893o(atomicReferenceArray2, i, t);
        m892p(atomicReferenceArray, atomicReferenceArray2);
        m893o(atomicReferenceArray, i, f46460j);
        m891q(j + 1);
    }

    /* renamed from: n */
    private void m894n(long j) {
        this.f46468h.lazySet(j);
    }

    /* renamed from: o */
    private static void m893o(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    /* renamed from: p */
    private void m892p(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        m893o(atomicReferenceArray, m906b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    /* renamed from: q */
    private void m891q(long j) {
        this.f46461a.lazySet(j);
    }

    /* renamed from: r */
    private boolean m890r(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        m893o(atomicReferenceArray, i, t);
        m891q(j + 1);
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
        return m899i() == m902f();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: l */
    public boolean m896l(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f46465e;
        long m899i = m899i();
        int i = this.f46464d;
        long j = 2 + m899i;
        if (m901g(atomicReferenceArray, m905c(j, i)) == null) {
            int m905c = m905c(m899i, i);
            m893o(atomicReferenceArray, m905c + 1, t2);
            m893o(atomicReferenceArray, m905c, t);
            m891q(j);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f46465e = atomicReferenceArray2;
        int m905c2 = m905c(m899i, i);
        m893o(atomicReferenceArray2, m905c2 + 1, t2);
        m893o(atomicReferenceArray2, m905c2, t);
        m892p(atomicReferenceArray, atomicReferenceArray2);
        m893o(atomicReferenceArray, m905c2, f46460j);
        m891q(j);
        return true;
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f46465e;
        long m903e = m903e();
        int i = this.f46464d;
        int m905c = m905c(m903e, i);
        if (m903e < this.f46463c) {
            return m890r(atomicReferenceArray, t, m903e, m905c);
        }
        long j = this.f46462b + m903e;
        if (m901g(atomicReferenceArray, m905c(j, i)) == null) {
            this.f46463c = j - 1;
            return m890r(atomicReferenceArray, t, m903e, m905c);
        } else if (m901g(atomicReferenceArray, m905c(1 + m903e, i)) == null) {
            return m890r(atomicReferenceArray, t, m903e, m905c);
        } else {
            m895m(atomicReferenceArray, m903e, m905c, t, i);
            return true;
        }
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f46467g;
        long m904d = m904d();
        int i = this.f46466f;
        T t = (T) m901g(atomicReferenceArray, m905c(m904d, i));
        return t == f46460j ? m898j(m900h(atomicReferenceArray), m904d, i) : t;
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f46467g;
        long m904d = m904d();
        int i = this.f46466f;
        int m905c = m905c(m904d, i);
        T t = (T) m901g(atomicReferenceArray, m905c);
        boolean z = t == f46460j;
        if (t == null || z) {
            if (z) {
                return m897k(m900h(atomicReferenceArray), m904d, i);
            }
            return null;
        }
        m893o(atomicReferenceArray, m905c, null);
        m894n(m904d + 1);
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
        long m902f = m902f();
        while (true) {
            long m899i = m899i();
            long m902f2 = m902f();
            if (m902f == m902f2) {
                return (int) (m899i - m902f2);
            }
            m902f = m902f2;
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
