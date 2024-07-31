package p640rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* renamed from: rx.internal.util.atomic.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SpscAtomicArrayQueue<E> extends AtomicReferenceArrayQueue<E> {

    /* renamed from: g */
    private static final Integer f46454g = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: c */
    final AtomicLong f46455c;

    /* renamed from: d */
    long f46456d;

    /* renamed from: e */
    final AtomicLong f46457e;

    /* renamed from: f */
    final int f46458f;

    public SpscAtomicArrayQueue(int i) {
        super(i);
        this.f46455c = new AtomicLong();
        this.f46457e = new AtomicLong();
        this.f46458f = Math.min(i / 4, f46454g.intValue());
    }

    /* renamed from: l */
    private long m911l() {
        return this.f46457e.get();
    }

    /* renamed from: m */
    private long m910m() {
        return this.f46455c.get();
    }

    /* renamed from: n */
    private void m909n(long j) {
        this.f46457e.lazySet(j);
    }

    /* renamed from: o */
    private void m908o(long j) {
        this.f46455c.lazySet(j);
    }

    @Override // p640rx.internal.util.atomic.AtomicReferenceArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return m910m() == m911l();
    }

    @Override // p640rx.internal.util.atomic.AtomicReferenceArrayQueue, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e != null) {
            AtomicReferenceArray<E> atomicReferenceArray = this.f46450a;
            int i = this.f46451b;
            long j = this.f46455c.get();
            int m928b = m928b(j, i);
            if (j >= this.f46456d) {
                long j2 = this.f46458f + j;
                if (m924f(atomicReferenceArray, m928b(j2, i)) == null) {
                    this.f46456d = j2;
                } else if (m924f(atomicReferenceArray, m928b) != null) {
                    return false;
                }
            }
            m922h(atomicReferenceArray, m928b, e);
            m908o(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // java.util.Queue
    public E peek() {
        return m925e(m929a(this.f46457e.get()));
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.f46457e.get();
        int m929a = m929a(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.f46450a;
        E m924f = m924f(atomicReferenceArray, m929a);
        if (m924f == null) {
            return null;
        }
        m922h(atomicReferenceArray, m929a, null);
        m909n(j + 1);
        return m924f;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long m911l = m911l();
        while (true) {
            long m910m = m910m();
            long m911l2 = m911l();
            if (m911l == m911l2) {
                return (int) (m910m - m911l2);
            }
            m911l = m911l2;
        }
    }
}
