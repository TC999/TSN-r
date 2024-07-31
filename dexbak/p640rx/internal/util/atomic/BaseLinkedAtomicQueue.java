package p640rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: rx.internal.util.atomic.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
abstract class BaseLinkedAtomicQueue<E> extends AbstractQueue<E> {

    /* renamed from: a */
    private final AtomicReference<LinkedQueueNode<E>> f46452a = new AtomicReference<>();

    /* renamed from: b */
    private final AtomicReference<LinkedQueueNode<E>> f46453b = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final LinkedQueueNode<E> m918a() {
        return this.f46453b.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final LinkedQueueNode<E> m917b() {
        return this.f46452a.get();
    }

    /* renamed from: c */
    protected final LinkedQueueNode<E> m916c() {
        return this.f46453b.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final LinkedQueueNode<E> m915d() {
        return this.f46452a.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public final void m914e(LinkedQueueNode<E> linkedQueueNode) {
        this.f46453b.lazySet(linkedQueueNode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public final void m913f(LinkedQueueNode<E> linkedQueueNode) {
        this.f46452a.lazySet(linkedQueueNode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public final LinkedQueueNode<E> m912g(LinkedQueueNode<E> linkedQueueNode) {
        return this.f46452a.getAndSet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return m916c() == m915d();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> m916c = m916c();
        LinkedQueueNode<E> m915d = m915d();
        int i = 0;
        while (m916c != m915d && i < Integer.MAX_VALUE) {
            do {
                lvNext = m916c.lvNext();
            } while (lvNext == null);
            i++;
            m916c = lvNext;
        }
        return i;
    }
}
