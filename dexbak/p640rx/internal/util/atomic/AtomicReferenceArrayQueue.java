package p640rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p640rx.internal.util.unsafe.Pow2;

/* renamed from: rx.internal.util.atomic.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
abstract class AtomicReferenceArrayQueue<E> extends AbstractQueue<E> {

    /* renamed from: a */
    protected final AtomicReferenceArray<E> f46450a;

    /* renamed from: b */
    protected final int f46451b;

    public AtomicReferenceArrayQueue(int i) {
        int m756b = Pow2.m756b(i);
        this.f46451b = m756b - 1;
        this.f46450a = new AtomicReferenceArray<>(m756b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final int m929a(long j) {
        return this.f46451b & ((int) j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final int m928b(long j, int i) {
        return ((int) j) & i;
    }

    /* renamed from: c */
    protected final E m927c(int i) {
        return this.f46450a.get(i);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* renamed from: d */
    protected final E m926d(AtomicReferenceArray<E> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public final E m925e(int i) {
        return m924f(this.f46450a, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public final E m924f(AtomicReferenceArray<E> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    /* renamed from: g */
    protected final void m923g(int i, E e) {
        this.f46450a.lazySet(i, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public final void m922h(AtomicReferenceArray<E> atomicReferenceArray, int i, E e) {
        atomicReferenceArray.lazySet(i, e);
    }

    /* renamed from: i */
    protected final void m921i(int i, E e) {
        this.f46450a.lazySet(i, e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: j */
    protected final void m920j(AtomicReferenceArray<E> atomicReferenceArray, int i, E e) {
        atomicReferenceArray.lazySet(i, e);
    }

    /* renamed from: k */
    protected final void m919k(AtomicReferenceArray<E> atomicReferenceArray, int i, E e) {
        atomicReferenceArray.set(i, e);
    }
}
