package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: BaseLinkedAtomicQueue.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
abstract class b<E> extends AbstractQueue<E> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<LinkedQueueNode<E>> f63883a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<LinkedQueueNode<E>> f63884b = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> a() {
        return this.f63884b.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> b() {
        return this.f63883a.get();
    }

    protected final LinkedQueueNode<E> c() {
        return this.f63884b.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> d() {
        return this.f63883a.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e(LinkedQueueNode<E> linkedQueueNode) {
        this.f63884b.lazySet(linkedQueueNode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f(LinkedQueueNode<E> linkedQueueNode) {
        this.f63883a.lazySet(linkedQueueNode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> g(LinkedQueueNode<E> linkedQueueNode) {
        return this.f63883a.getAndSet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return c() == d();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> c4 = c();
        LinkedQueueNode<E> d4 = d();
        int i4 = 0;
        while (c4 != d4 && i4 < Integer.MAX_VALUE) {
            do {
                lvNext = c4.lvNext();
            } while (lvNext == null);
            i4++;
            c4 = lvNext;
        }
        return i4;
    }
}
