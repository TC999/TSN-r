package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SpscAtomicArrayQueue.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class d<E> extends a<E> {

    /* renamed from: g  reason: collision with root package name */
    private static final Integer f63885g = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: c  reason: collision with root package name */
    final AtomicLong f63886c;

    /* renamed from: d  reason: collision with root package name */
    long f63887d;

    /* renamed from: e  reason: collision with root package name */
    final AtomicLong f63888e;

    /* renamed from: f  reason: collision with root package name */
    final int f63889f;

    public d(int i4) {
        super(i4);
        this.f63886c = new AtomicLong();
        this.f63888e = new AtomicLong();
        this.f63889f = Math.min(i4 / 4, f63885g.intValue());
    }

    private long l() {
        return this.f63888e.get();
    }

    private long m() {
        return this.f63886c.get();
    }

    private void n(long j4) {
        this.f63888e.lazySet(j4);
    }

    private void o(long j4) {
        this.f63886c.lazySet(j4);
    }

    @Override // rx.internal.util.atomic.a, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return m() == l();
    }

    @Override // rx.internal.util.atomic.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // java.util.Queue
    public boolean offer(E e4) {
        if (e4 != null) {
            AtomicReferenceArray<E> atomicReferenceArray = this.f63881a;
            int i4 = this.f63882b;
            long j4 = this.f63886c.get();
            int b4 = b(j4, i4);
            if (j4 >= this.f63887d) {
                long j5 = this.f63889f + j4;
                if (f(atomicReferenceArray, b(j5, i4)) == null) {
                    this.f63887d = j5;
                } else if (f(atomicReferenceArray, b4) != null) {
                    return false;
                }
            }
            h(atomicReferenceArray, b4, e4);
            o(j4 + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // java.util.Queue
    public E peek() {
        return e(a(this.f63888e.get()));
    }

    @Override // java.util.Queue
    public E poll() {
        long j4 = this.f63888e.get();
        int a4 = a(j4);
        AtomicReferenceArray<E> atomicReferenceArray = this.f63881a;
        E f4 = f(atomicReferenceArray, a4);
        if (f4 == null) {
            return null;
        }
        h(atomicReferenceArray, a4, null);
        n(j4 + 1);
        return f4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long l4 = l();
        while (true) {
            long m4 = m();
            long l5 = l();
            if (l4 == l5) {
                return (int) (m4 - l5);
            }
            l4 = l5;
        }
    }
}
