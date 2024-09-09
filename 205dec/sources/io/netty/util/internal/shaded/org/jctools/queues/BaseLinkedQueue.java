package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
abstract class BaseLinkedQueue<E> extends BaseLinkedQueuePad2<E> {
    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return -1;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        long j4 = 0;
        do {
            int drain = drain(consumer, 4096);
            j4 += drain;
            if (drain != 4096) {
                break;
            }
        } while (j4 <= 2147479551);
        return (int) j4;
    }

    protected E getSingleConsumerNodeValue(LinkedQueueNode<E> linkedQueueNode, LinkedQueueNode<E> linkedQueueNode2) {
        E andNullValue = linkedQueueNode2.getAndNullValue();
        linkedQueueNode.soNext(linkedQueueNode);
        spConsumerNode(linkedQueueNode2);
        return andNullValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final boolean isEmpty() {
        return lvConsumerNode() == lvProducerNode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> newNode() {
        return new LinkedQueueNode<>();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e4) {
        return offer(e4);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        LinkedQueueNode<E> lvNext = lpConsumerNode().lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        LinkedQueueNode<E> lpConsumerNode = lpConsumerNode();
        LinkedQueueNode<E> lvNext = lpConsumerNode.lvNext();
        if (lvNext != null) {
            return getSingleConsumerNodeValue(lpConsumerNode, lvNext);
        }
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final int size() {
        LinkedQueueNode<E> lvConsumerNode = lvConsumerNode();
        LinkedQueueNode<E> lvProducerNode = lvProducerNode();
        int i4 = 0;
        while (lvConsumerNode != lvProducerNode && lvConsumerNode != null && i4 < Integer.MAX_VALUE) {
            LinkedQueueNode<E> lvNext = lvConsumerNode.lvNext();
            if (lvNext == lvConsumerNode) {
                return i4;
            }
            i4++;
            lvConsumerNode = lvNext;
        }
        return i4;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return getClass().getName();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i4) {
        LinkedQueueNode<E> linkedQueueNode = this.consumerNode;
        int i5 = 0;
        while (i5 < i4) {
            LinkedQueueNode<E> lvNext = linkedQueueNode.lvNext();
            if (lvNext == null) {
                return i5;
            }
            consumer.accept(getSingleConsumerNodeValue(linkedQueueNode, lvNext));
            i5++;
            linkedQueueNode = lvNext;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> newNode(E e4) {
        return new LinkedQueueNode<>(e4);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        LinkedQueueNode<E> linkedQueueNode = this.consumerNode;
        int i4 = 0;
        while (exitCondition.keepRunning()) {
            for (int i5 = 0; i5 < 4096; i5++) {
                LinkedQueueNode<E> lvNext = linkedQueueNode.lvNext();
                if (lvNext == null) {
                    i4 = waitStrategy.idle(i4);
                } else {
                    consumer.accept(getSingleConsumerNodeValue(linkedQueueNode, lvNext));
                    linkedQueueNode = lvNext;
                    i4 = 0;
                }
            }
        }
    }
}
