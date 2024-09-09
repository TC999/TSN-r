package io.netty.util.internal.shaded.org.jctools.queues;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class IndexedQueueSizeUtil {

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface IndexedQueue {
        long lvConsumerIndex();

        long lvProducerIndex();
    }

    public static boolean isEmpty(IndexedQueue indexedQueue) {
        return indexedQueue.lvConsumerIndex() == indexedQueue.lvProducerIndex();
    }

    public static int size(IndexedQueue indexedQueue) {
        long lvProducerIndex;
        long lvConsumerIndex;
        long lvConsumerIndex2 = indexedQueue.lvConsumerIndex();
        while (true) {
            lvProducerIndex = indexedQueue.lvProducerIndex();
            lvConsumerIndex = indexedQueue.lvConsumerIndex();
            if (lvConsumerIndex2 == lvConsumerIndex) {
                break;
            }
            lvConsumerIndex2 = lvConsumerIndex;
        }
        long j4 = lvProducerIndex - lvConsumerIndex;
        if (j4 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j4;
    }
}
