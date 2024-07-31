package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class MpscArrayQueue<E> extends MpscArrayQueueConsumerField<E> implements QueueProgressIndicators {
    long p01;
    long p02;
    long p03;
    long p04;
    long p05;
    long p06;
    long p07;
    long p10;
    long p11;
    long p12;
    long p13;
    long p14;
    long p15;
    long p16;
    long p17;

    public MpscArrayQueue(int i) {
        super(i);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public long currentConsumerIndex() {
        return lvConsumerIndex();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public long currentProducerIndex() {
        return lvProducerIndex();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return drain(consumer, capacity());
    }

    public final int failFastOffer(E e) {
        e.getClass();
        long j = this.mask;
        long j2 = j + 1;
        long lvProducerIndex = lvProducerIndex();
        if (lvProducerIndex >= lvProducerLimit()) {
            long lvConsumerIndex = lvConsumerIndex() + j2;
            if (lvProducerIndex >= lvConsumerIndex) {
                return 1;
            }
            soProducerLimit(lvConsumerIndex);
        }
        if (casProducerIndex(lvProducerIndex, 1 + lvProducerIndex)) {
            UnsafeRefArrayAccess.soElement(this.buffer, ConcurrentCircularArrayQueue.calcElementOffset(lvProducerIndex, j), e);
            return 0;
        }
        return -1;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        int capacity = capacity();
        long j = 0;
        do {
            int fill = fill(supplier, MpmcArrayQueue.RECOMENDED_OFFER_BATCH);
            if (fill == 0) {
                return (int) j;
            }
            j += fill;
        } while (j <= capacity);
        return (int) j;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean isEmpty() {
        return lvConsumerIndex() == lvProducerIndex();
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        long lvProducerIndex;
        e.getClass();
        long j = this.mask;
        long lvProducerLimit = lvProducerLimit();
        do {
            lvProducerIndex = lvProducerIndex();
            if (lvProducerIndex >= lvProducerLimit) {
                lvProducerLimit = lvConsumerIndex() + j + 1;
                if (lvProducerIndex >= lvProducerLimit) {
                    return false;
                }
                soProducerLimit(lvProducerLimit);
            }
        } while (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex));
        UnsafeRefArrayAccess.soElement(this.buffer, ConcurrentCircularArrayQueue.calcElementOffset(lvProducerIndex, j), e);
        return true;
    }

    public boolean offerIfBelowThreshold(E e, int i) {
        e.getClass();
        long j = this.mask;
        long j2 = j + 1;
        long lvProducerLimit = lvProducerLimit();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long j3 = i;
            if (j2 - (lvProducerLimit - lvProducerIndex) >= j3) {
                long lvConsumerIndex = lvConsumerIndex();
                if (lvProducerIndex - lvConsumerIndex >= j3) {
                    return false;
                }
                lvProducerLimit = lvConsumerIndex + j2;
                soProducerLimit(lvProducerLimit);
            }
            if (casProducerIndex(lvProducerIndex, lvProducerIndex + 1)) {
                UnsafeRefArrayAccess.soElement(this.buffer, ConcurrentCircularArrayQueue.calcElementOffset(lvProducerIndex, j), e);
                return true;
            }
        }
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E peek() {
        E[] eArr = this.buffer;
        long lpConsumerIndex = lpConsumerIndex();
        long calcElementOffset = calcElementOffset(lpConsumerIndex);
        E e = (E) UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
        if (e != null) {
            return e;
        }
        if (lpConsumerIndex != lvProducerIndex()) {
            do {
                e = (E) UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
            } while (e == null);
            return e;
        }
        return null;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E poll() {
        long lpConsumerIndex = lpConsumerIndex();
        long calcElementOffset = calcElementOffset(lpConsumerIndex);
        E[] eArr = this.buffer;
        E e = (E) UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
        if (e == null) {
            if (lpConsumerIndex != lvProducerIndex()) {
                do {
                    e = (E) UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
                } while (e == null);
                UnsafeRefArrayAccess.spElement(eArr, calcElementOffset, null);
                soConsumerIndex(lpConsumerIndex + 1);
                return e;
            }
            return null;
        }
        UnsafeRefArrayAccess.spElement(eArr, calcElementOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return e;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        return offer(e);
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
        E e = (E) UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
        if (e == null) {
            return null;
        }
        UnsafeRefArrayAccess.spElement(eArr, calcElementOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int size() {
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                return (int) (lvProducerIndex - lvConsumerIndex2);
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i) {
        E[] eArr = this.buffer;
        long j = this.mask;
        long lpConsumerIndex = lpConsumerIndex();
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = i2 + lpConsumerIndex;
            long calcElementOffset = ConcurrentCircularArrayQueue.calcElementOffset(j2, j);
            Object lvElement = UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
            if (lvElement == null) {
                return i2;
            }
            UnsafeRefArrayAccess.soElement(eArr, calcElementOffset, null);
            soConsumerIndex(j2 + 1);
            consumer.accept(lvElement);
        }
        return i;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i) {
        long lvProducerIndex;
        int i2;
        int min;
        long j = this.mask;
        long j2 = 1 + j;
        long lvProducerLimit = lvProducerLimit();
        do {
            lvProducerIndex = lvProducerIndex();
            long j3 = lvProducerLimit - lvProducerIndex;
            if (j3 <= 0) {
                lvProducerLimit = lvConsumerIndex() + j2;
                j3 = lvProducerLimit - lvProducerIndex;
                if (j3 <= 0) {
                    return 0;
                }
                soProducerLimit(lvProducerLimit);
            }
            min = Math.min((int) j3, i);
        } while (!casProducerIndex(lvProducerIndex, min + lvProducerIndex));
        E[] eArr = this.buffer;
        for (i2 = 0; i2 < min; i2++) {
            UnsafeRefArrayAccess.soElement(eArr, ConcurrentCircularArrayQueue.calcElementOffset(i2 + lvProducerIndex, j), supplier.get());
        }
        return min;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        E[] eArr = this.buffer;
        long j = this.mask;
        long lpConsumerIndex = lpConsumerIndex();
        int i = 0;
        while (exitCondition.keepRunning()) {
            for (int i2 = 0; i2 < 4096; i2++) {
                long calcElementOffset = ConcurrentCircularArrayQueue.calcElementOffset(lpConsumerIndex, j);
                Object lvElement = UnsafeRefArrayAccess.lvElement(eArr, calcElementOffset);
                if (lvElement == null) {
                    i = waitStrategy.idle(i);
                } else {
                    lpConsumerIndex++;
                    UnsafeRefArrayAccess.soElement(eArr, calcElementOffset, null);
                    soConsumerIndex(lpConsumerIndex);
                    consumer.accept(lvElement);
                    i = 0;
                }
            }
        }
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        while (true) {
            while (exitCondition.keepRunning()) {
                int idle = fill(supplier, MpmcArrayQueue.RECOMENDED_OFFER_BATCH) == 0 ? waitStrategy.idle(idle) : 0;
            }
            return;
        }
    }
}
