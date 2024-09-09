package rx.internal.util.atomic;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SpscLinkedAtomicQueue.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class f<E> extends b<E> {
    public f() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        f(linkedQueueNode);
        e(linkedQueueNode);
        linkedQueueNode.soNext(null);
    }

    @Override // java.util.Queue
    public boolean offer(E e4) {
        if (e4 != null) {
            LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e4);
            b().soNext(linkedQueueNode);
            f(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> lvNext = a().lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext = a().lvNext();
        if (lvNext != null) {
            E andNullValue = lvNext.getAndNullValue();
            e(lvNext);
            return andNullValue;
        }
        return null;
    }
}
