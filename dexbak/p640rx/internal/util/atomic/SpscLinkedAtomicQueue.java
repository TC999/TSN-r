package p640rx.internal.util.atomic;

/* renamed from: rx.internal.util.atomic.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SpscLinkedAtomicQueue<E> extends BaseLinkedAtomicQueue<E> {
    public SpscLinkedAtomicQueue() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        m913f(linkedQueueNode);
        m914e(linkedQueueNode);
        linkedQueueNode.soNext(null);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e != null) {
            LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e);
            m917b().soNext(linkedQueueNode);
            m913f(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> lvNext = m918a().lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext = m918a().lvNext();
        if (lvNext != null) {
            E andNullValue = lvNext.getAndNullValue();
            m914e(lvNext);
            return andNullValue;
        }
        return null;
    }
}
