package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.p;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: AtomicReferenceArrayQueue.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
abstract class a<E> extends AbstractQueue<E> {

    /* renamed from: a  reason: collision with root package name */
    protected final AtomicReferenceArray<E> f63881a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f63882b;

    public a(int i4) {
        int b4 = p.b(i4);
        this.f63882b = b4 - 1;
        this.f63881a = new AtomicReferenceArray<>(b4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(long j4) {
        return this.f63882b & ((int) j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int b(long j4, int i4) {
        return ((int) j4) & i4;
    }

    protected final E c(int i4) {
        return this.f63881a.get(i4);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    protected final E d(AtomicReferenceArray<E> atomicReferenceArray, int i4) {
        return atomicReferenceArray.get(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E e(int i4) {
        return f(this.f63881a, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E f(AtomicReferenceArray<E> atomicReferenceArray, int i4) {
        return atomicReferenceArray.get(i4);
    }

    protected final void g(int i4, E e4) {
        this.f63881a.lazySet(i4, e4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(AtomicReferenceArray<E> atomicReferenceArray, int i4, E e4) {
        atomicReferenceArray.lazySet(i4, e4);
    }

    protected final void i(int i4, E e4) {
        this.f63881a.lazySet(i4, e4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    protected final void j(AtomicReferenceArray<E> atomicReferenceArray, int i4, E e4) {
        atomicReferenceArray.lazySet(i4, e4);
    }

    protected final void k(AtomicReferenceArray<E> atomicReferenceArray, int i4, E e4) {
        atomicReferenceArray.set(i4, e4);
    }
}
