package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;
import rx.internal.util.atomic.LinkedQueueNode;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: MpscLinkedQueue.java */
@SuppressAnimalSniffer
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class o<E> extends a<E> {
    public o() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        this.consumerNode = linkedQueueNode;
        g(linkedQueueNode);
    }

    protected LinkedQueueNode<E> g(LinkedQueueNode<E> linkedQueueNode) {
        LinkedQueueNode<E> linkedQueueNode2;
        do {
            linkedQueueNode2 = this.producerNode;
        } while (!io.netty.util.internal.a.a(n0.f64070a, this, e.f64016q, linkedQueueNode2, linkedQueueNode));
        return linkedQueueNode2;
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
        LinkedQueueNode<E> linkedQueueNode = this.consumerNode;
        LinkedQueueNode<E> lvNext2 = linkedQueueNode.lvNext();
        if (lvNext2 != null) {
            return lvNext2.lpValue();
        }
        if (linkedQueueNode != b()) {
            do {
                lvNext = linkedQueueNode.lvNext();
            } while (lvNext == null);
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> d4 = d();
        LinkedQueueNode<E> lvNext2 = d4.lvNext();
        if (lvNext2 != null) {
            E andNullValue = lvNext2.getAndNullValue();
            f(lvNext2);
            return andNullValue;
        } else if (d4 != b()) {
            do {
                lvNext = d4.lvNext();
            } while (lvNext == null);
            E andNullValue2 = lvNext.getAndNullValue();
            this.consumerNode = lvNext;
            return andNullValue2;
        } else {
            return null;
        }
    }
}
