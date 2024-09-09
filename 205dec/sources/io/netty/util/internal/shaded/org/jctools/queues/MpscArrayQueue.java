package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class MpscArrayQueue<E> extends MpscArrayQueueL3Pad<E> {
    public MpscArrayQueue(int i4) {
        super(i4);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return drain(consumer, capacity());
    }

    public final int failFastOffer(E e4) {
        e4.getClass();
        long j4 = this.mask;
        long j5 = j4 + 1;
        long lvProducerIndex = lvProducerIndex();
        if (lvProducerIndex >= lvProducerLimit()) {
            long lvConsumerIndex = lvConsumerIndex() + j5;
            if (lvProducerIndex >= lvConsumerIndex) {
                return 1;
            }
            soProducerLimit(lvConsumerIndex);
        }
        if (casProducerIndex(lvProducerIndex, 1 + lvProducerIndex)) {
            UnsafeRefArrayAccess.soElement(this.buffer, ConcurrentCircularArrayQueue.calcElementOffset(lvProducerIndex, j4), e4);
            return 0;
        }
        return -1;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        int capacity = capacity();
        long j4 = 0;
        do {
            int fill = fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH);
            if (fill == 0) {
                return (int) j4;
            }
            j4 += fill;
        } while (j4 <= capacity);
        return (int) j4;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(E e4) {
        long lvProducerIndex;
        e4.getClass();
        long j4 = this.mask;
        long lvProducerLimit = lvProducerLimit();
        do {
            lvProducerIndex = lvProducerIndex();
            if (lvProducerIndex >= lvProducerLimit) {
                lvProducerLimit = lvConsumerIndex() + j4 + 1;
                if (lvProducerIndex >= lvProducerLimit) {
                    return false;
                }
                soProducerLimit(lvProducerLimit);
            }
        } while (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex));
        UnsafeRefArrayAccess.soElement(this.buffer, ConcurrentCircularArrayQueue.calcElementOffset(lvProducerIndex, j4), e4);
        return true;
    }

    public boolean offerIfBelowThreshold(E e4, int i4) {
        e4.getClass();
        long j4 = this.mask;
        long j5 = j4 + 1;
        long lvProducerLimit = lvProducerLimit();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long j6 = i4;
            if (j5 - (lvProducerLimit - lvProducerIndex) >= j6) {
                long lvConsumerIndex = lvConsumerIndex();
                if (lvProducerIndex - lvConsumerIndex >= j6) {
                    return false;
                }
                lvProducerLimit = lvConsumerIndex + j5;
                soProducerLimit(lvProducerLimit);
            }
            if (casProducerIndex(lvProducerIndex, lvProducerIndex + 1)) {
                UnsafeRefArrayAccess.soElement(this.buffer, ConcurrentCircularArrayQueue.calcElementOffset(lvProducerIndex, j4), e4);
                return true;
            }
        }
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E peek() {
        E[] eArr = this.buffer;
        long lpConsumerIndex = lpConsumerIndex();
        long calcElementOffset = calcElementOffset(lpConsumerIndex);
        E e4 = (E) UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
        if (e4 != null) {
            return e4;
        }
        if (lpConsumerIndex != lvProducerIndex()) {
            do {
                e4 = (E) UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
            } while (e4 == null);
            return e4;
        }
        return null;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E poll() {
        long lpConsumerIndex = lpConsumerIndex();
        long calcElementOffset = calcElementOffset(lpConsumerIndex);
        E[] eArr = this.buffer;
        E e4 = (E) UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
        if (e4 == null) {
            if (lpConsumerIndex != lvProducerIndex()) {
                do {
                    e4 = (E) UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
                } while (e4 == null);
                UnsafeRefArrayAccess.spElement(eArr, calcElementOffset, null);
                soConsumerIndex(lpConsumerIndex + 1);
                return e4;
            }
            return null;
        }
        UnsafeRefArrayAccess.spElement(eArr, calcElementOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return e4;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e4) {
        return offer(e4);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        return (E) UnsafeRefArrayAccess.lvElement(this.buffer, ConcurrentCircularArrayQueue.calcElementOffset(lpConsumerIndex(), this.mask));
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        E[] eArr = this.buffer;
        long lpConsumerIndex = lpConsumerIndex();
        long calcElementOffset = calcElementOffset(lpConsumerIndex);
        E e4 = (E) UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
        if (e4 == null) {
            return null;
        }
        UnsafeRefArrayAccess.spElement(eArr, calcElementOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return e4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i4) {
        E[] eArr = this.buffer;
        long j4 = this.mask;
        long lpConsumerIndex = lpConsumerIndex();
        for (int i5 = 0; i5 < i4; i5++) {
            long j5 = i5 + lpConsumerIndex;
            long calcElementOffset = ConcurrentCircularArrayQueue.calcElementOffset(j5, j4);
            Object lvElement = UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
            if (lvElement == null) {
                return i5;
            }
            UnsafeRefArrayAccess.spElement(eArr, calcElementOffset, null);
            soConsumerIndex(j5 + 1);
            consumer.accept(lvElement);
        }
        return i4;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i4) {
        long lvProducerIndex;
        int i5;
        int min;
        long j4 = this.mask;
        long j5 = 1 + j4;
        long lvProducerLimit = lvProducerLimit();
        do {
            lvProducerIndex = lvProducerIndex();
            long j6 = lvProducerLimit - lvProducerIndex;
            if (j6 <= 0) {
                lvProducerLimit = lvConsumerIndex() + j5;
                j6 = lvProducerLimit - lvProducerIndex;
                if (j6 <= 0) {
                    return 0;
                }
                soProducerLimit(lvProducerLimit);
            }
            min = Math.min((int) j6, i4);
        } while (!casProducerIndex(lvProducerIndex, min + lvProducerIndex));
        E[] eArr = this.buffer;
        for (i5 = 0; i5 < min; i5++) {
            UnsafeRefArrayAccess.soElement(eArr, ConcurrentCircularArrayQueue.calcElementOffset(i5 + lvProducerIndex, j4), supplier.get());
        }
        return min;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        E[] eArr = this.buffer;
        long j4 = this.mask;
        long lpConsumerIndex = lpConsumerIndex();
        int i4 = 0;
        while (exitCondition.keepRunning()) {
            for (int i5 = 0; i5 < 4096; i5++) {
                long calcElementOffset = ConcurrentCircularArrayQueue.calcElementOffset(lpConsumerIndex, j4);
                Object lvElement = UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
                if (lvElement == null) {
                    i4 = waitStrategy.idle(i4);
                } else {
                    lpConsumerIndex++;
                    UnsafeRefArrayAccess.spElement(eArr, calcElementOffset, null);
                    soConsumerIndex(lpConsumerIndex);
                    consumer.accept(lvElement);
                    i4 = 0;
                }
            }
        }
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        while (true) {
            while (exitCondition.keepRunning()) {
                int idle = fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH) == 0 ? waitStrategy.idle(idle) : 0;
            }
            return;
        }
    }
}
