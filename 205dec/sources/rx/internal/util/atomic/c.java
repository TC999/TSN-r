package rx.internal.util.atomic;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: MpscLinkedAtomicQueue.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class c<E> extends b<E> {
    public c() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        e(linkedQueueNode);
        g(linkedQueueNode);
    }

    @Override // java.util.Queue
    public boolean offer(E e4) {
        if (e4 != null) {
            LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e4);
            g(linkedQueueNode).soNext(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> a4 = a();
        LinkedQueueNode<E> lvNext2 = a4.lvNext();
        if (lvNext2 != null) {
            return lvNext2.lpValue();
        }
        if (a4 != d()) {
            do {
                lvNext = a4.lvNext();
            } while (lvNext == null);
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> a4 = a();
        LinkedQueueNode<E> lvNext2 = a4.lvNext();
        if (lvNext2 != null) {
            E andNullValue = lvNext2.getAndNullValue();
            e(lvNext2);
            return andNullValue;
        } else if (a4 != d()) {
            do {
                lvNext = a4.lvNext();
            } while (lvNext == null);
            E andNullValue2 = lvNext.getAndNullValue();
            e(lvNext);
            return andNullValue2;
        } else {
            return null;
        }
    }
}
