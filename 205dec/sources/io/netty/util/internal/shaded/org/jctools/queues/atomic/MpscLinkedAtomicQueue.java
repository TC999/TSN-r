package io.netty.util.internal.shaded.org.jctools.queues.atomic;

/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class MpscLinkedAtomicQueue<E> extends BaseLinkedAtomicQueue<E> {
    public MpscLinkedAtomicQueue() {
        LinkedQueueAtomicNode<E> linkedQueueAtomicNode = new LinkedQueueAtomicNode<>();
        spConsumerNode(linkedQueueAtomicNode);
        xchgProducerNode(linkedQueueAtomicNode);
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final boolean offer(E e4) {
        e4.getClass();
        LinkedQueueAtomicNode<E> linkedQueueAtomicNode = new LinkedQueueAtomicNode<>(e4);
        xchgProducerNode(linkedQueueAtomicNode).soNext(linkedQueueAtomicNode);
        return true;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final E peek() {
        LinkedQueueAtomicNode<E> lvNext;
        LinkedQueueAtomicNode<E> lpConsumerNode = lpConsumerNode();
        LinkedQueueAtomicNode<E> lvNext2 = lpConsumerNode.lvNext();
        if (lvNext2 != null) {
            return lvNext2.lpValue();
        }
        if (lpConsumerNode != lvProducerNode()) {
            do {
                lvNext = lpConsumerNode.lvNext();
            } while (lvNext == null);
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final E poll() {
        LinkedQueueAtomicNode<E> lvNext;
        LinkedQueueAtomicNode<E> lpConsumerNode = lpConsumerNode();
        LinkedQueueAtomicNode<E> lvNext2 = lpConsumerNode.lvNext();
        if (lvNext2 != null) {
            return getSingleConsumerNodeValue(lpConsumerNode, lvNext2);
        }
        if (lpConsumerNode != lvProducerNode()) {
            do {
                lvNext = lpConsumerNode.lvNext();
            } while (lvNext == null);
            return getSingleConsumerNodeValue(lpConsumerNode, lvNext);
        }
        return null;
    }
}
