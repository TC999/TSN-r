package io.netty.util.internal.shaded.org.jctools.queues.atomic;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SpscLinkedAtomicQueue<E> extends BaseLinkedAtomicQueue<E> {
    public SpscLinkedAtomicQueue() {
        LinkedQueueAtomicNode<E> linkedQueueAtomicNode = new LinkedQueueAtomicNode<>();
        spProducerNode(linkedQueueAtomicNode);
        spConsumerNode(linkedQueueAtomicNode);
        linkedQueueAtomicNode.soNext(null);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        e.getClass();
        LinkedQueueAtomicNode<E> linkedQueueAtomicNode = new LinkedQueueAtomicNode<>(e);
        lpProducerNode().soNext(linkedQueueAtomicNode);
        spProducerNode(linkedQueueAtomicNode);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueAtomicNode<E> lvNext = lpConsumerNode().lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueAtomicNode<E> lpConsumerNode = lpConsumerNode();
        LinkedQueueAtomicNode<E> lvNext = lpConsumerNode.lvNext();
        if (lvNext != null) {
            return getSingleConsumerNodeValue(lpConsumerNode, lvNext);
        }
        return null;
    }
}
