package p640rx.internal.util.atomic;

/* renamed from: rx.internal.util.atomic.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class MpscLinkedAtomicQueue<E> extends BaseLinkedAtomicQueue<E> {
    public MpscLinkedAtomicQueue() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        m914e(linkedQueueNode);
        m912g(linkedQueueNode);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e != null) {
            LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e);
            m912g(linkedQueueNode).soNext(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> m918a = m918a();
        LinkedQueueNode<E> lvNext2 = m918a.lvNext();
        if (lvNext2 != null) {
            return lvNext2.lpValue();
        }
        if (m918a != m915d()) {
            do {
                lvNext = m918a.lvNext();
            } while (lvNext == null);
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> m918a = m918a();
        LinkedQueueNode<E> lvNext2 = m918a.lvNext();
        if (lvNext2 != null) {
            E andNullValue = lvNext2.getAndNullValue();
            m914e(lvNext2);
            return andNullValue;
        } else if (m918a != m915d()) {
            do {
                lvNext = m918a.lvNext();
            } while (lvNext == null);
            E andNullValue2 = lvNext.getAndNullValue();
            m914e(lvNext);
            return andNullValue2;
        } else {
            return null;
        }
    }
}
