package rx.internal.util.unsafe;

import rx.internal.util.atomic.LinkedQueueNode;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SpscLinkedQueue.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class g0<E> extends a<E> {
    public g0() {
        c(new LinkedQueueNode<>());
        f(this.producerNode);
        this.consumerNode.soNext(null);
    }

    @Override // java.util.Queue
    public boolean offer(E e4) {
        if (e4 != null) {
            LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e4);
            this.producerNode.soNext(linkedQueueNode);
            this.producerNode = linkedQueueNode;
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> lvNext = this.consumerNode.lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext = this.consumerNode.lvNext();
        if (lvNext != null) {
            E andNullValue = lvNext.getAndNullValue();
            this.consumerNode = lvNext;
            return andNullValue;
        }
        return null;
    }
}
