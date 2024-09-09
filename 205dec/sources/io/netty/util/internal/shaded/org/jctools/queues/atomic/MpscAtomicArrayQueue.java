package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class MpscAtomicArrayQueue<E> extends MpscAtomicArrayQueueL3Pad<E> {
    public MpscAtomicArrayQueue(int i4) {
        super(i4);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return drain(consumer, capacity());
    }

    public final int failFastOffer(E e4) {
        e4.getClass();
        int i4 = this.mask;
        long j4 = i4 + 1;
        long lvProducerIndex = lvProducerIndex();
        if (lvProducerIndex >= lvProducerLimit()) {
            long lvConsumerIndex = lvConsumerIndex() + j4;
            if (lvProducerIndex >= lvConsumerIndex) {
                return 1;
            }
            soProducerLimit(lvConsumerIndex);
        }
        if (casProducerIndex(lvProducerIndex, 1 + lvProducerIndex)) {
            AtomicReferenceArrayQueue.soElement(this.buffer, calcElementOffset(lvProducerIndex, i4), e4);
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

    @Override // io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(E e4) {
        long lvProducerIndex;
        e4.getClass();
        int i4 = this.mask;
        long lvProducerLimit = lvProducerLimit();
        do {
            lvProducerIndex = lvProducerIndex();
            if (lvProducerIndex >= lvProducerLimit) {
                lvProducerLimit = lvConsumerIndex() + i4 + 1;
                if (lvProducerIndex >= lvProducerLimit) {
                    return false;
                }
                soProducerLimit(lvProducerLimit);
            }
        } while (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex));
        AtomicReferenceArrayQueue.soElement(this.buffer, calcElementOffset(lvProducerIndex, i4), e4);
        return true;
    }

    public boolean offerIfBelowThreshold(E e4, int i4) {
        long lvProducerIndex;
        e4.getClass();
        int i5 = this.mask;
        long j4 = i5 + 1;
        long lvProducerLimit = lvProducerLimit();
        do {
            lvProducerIndex = lvProducerIndex();
            long j5 = i4;
            if (j4 - (lvProducerLimit - lvProducerIndex) >= j5) {
                long lvConsumerIndex = lvConsumerIndex();
                if (lvProducerIndex - lvConsumerIndex >= j5) {
                    return false;
                }
                lvProducerLimit = lvConsumerIndex + j4;
                soProducerLimit(lvProducerLimit);
            }
        } while (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex));
        AtomicReferenceArrayQueue.soElement(this.buffer, calcElementOffset(lvProducerIndex, i5), e4);
        return true;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E peek() {
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        long lpConsumerIndex = lpConsumerIndex();
        int calcElementOffset = calcElementOffset(lpConsumerIndex);
        E e4 = (E) AtomicReferenceArrayQueue.lvElement(atomicReferenceArray, calcElementOffset);
        if (e4 != null) {
            return e4;
        }
        if (lpConsumerIndex != lvProducerIndex()) {
            do {
                e4 = (E) AtomicReferenceArrayQueue.lvElement(atomicReferenceArray, calcElementOffset);
            } while (e4 == null);
            return e4;
        }
        return null;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E poll() {
        long lpConsumerIndex = lpConsumerIndex();
        int calcElementOffset = calcElementOffset(lpConsumerIndex);
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        E e4 = (E) AtomicReferenceArrayQueue.lvElement(atomicReferenceArray, calcElementOffset);
        if (e4 == null) {
            if (lpConsumerIndex != lvProducerIndex()) {
                do {
                    e4 = (E) AtomicReferenceArrayQueue.lvElement(atomicReferenceArray, calcElementOffset);
                } while (e4 == null);
                AtomicReferenceArrayQueue.spElement(atomicReferenceArray, calcElementOffset, null);
                soConsumerIndex(lpConsumerIndex + 1);
                return e4;
            }
            return null;
        }
        AtomicReferenceArrayQueue.spElement(atomicReferenceArray, calcElementOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return e4;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e4) {
        return offer(e4);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        return (E) AtomicReferenceArrayQueue.lvElement(this.buffer, calcElementOffset(lpConsumerIndex(), this.mask));
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        long lpConsumerIndex = lpConsumerIndex();
        int calcElementOffset = calcElementOffset(lpConsumerIndex);
        E e4 = (E) AtomicReferenceArrayQueue.lvElement(atomicReferenceArray, calcElementOffset);
        if (e4 == null) {
            return null;
        }
        AtomicReferenceArrayQueue.spElement(atomicReferenceArray, calcElementOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return e4;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractCollection
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Deprecated
    public int weakOffer(E e4) {
        return failFastOffer(e4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i4) {
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        int i5 = this.mask;
        long lpConsumerIndex = lpConsumerIndex();
        for (int i6 = 0; i6 < i4; i6++) {
            long j4 = i6 + lpConsumerIndex;
            int calcElementOffset = calcElementOffset(j4, i5);
            Object lvElement = AtomicReferenceArrayQueue.lvElement(atomicReferenceArray, calcElementOffset);
            if (lvElement == null) {
                return i6;
            }
            AtomicReferenceArrayQueue.spElement(atomicReferenceArray, calcElementOffset, null);
            soConsumerIndex(j4 + 1);
            consumer.accept(lvElement);
        }
        return i4;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i4) {
        long lvProducerIndex;
        int i5;
        int min;
        int i6 = this.mask;
        long j4 = i6 + 1;
        long lvProducerLimit = lvProducerLimit();
        do {
            lvProducerIndex = lvProducerIndex();
            long j5 = lvProducerLimit - lvProducerIndex;
            if (j5 <= 0) {
                lvProducerLimit = lvConsumerIndex() + j4;
                j5 = lvProducerLimit - lvProducerIndex;
                if (j5 <= 0) {
                    return 0;
                }
                soProducerLimit(lvProducerLimit);
            }
            min = Math.min((int) j5, i4);
        } while (!casProducerIndex(lvProducerIndex, min + lvProducerIndex));
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        for (i5 = 0; i5 < min; i5++) {
            AtomicReferenceArrayQueue.soElement(atomicReferenceArray, calcElementOffset(i5 + lvProducerIndex, i6), supplier.get());
        }
        return min;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        int i4 = this.mask;
        long lpConsumerIndex = lpConsumerIndex();
        int i5 = 0;
        while (exitCondition.keepRunning()) {
            for (int i6 = 0; i6 < 4096; i6++) {
                int calcElementOffset = calcElementOffset(lpConsumerIndex, i4);
                Object lvElement = AtomicReferenceArrayQueue.lvElement(atomicReferenceArray, calcElementOffset);
                if (lvElement == null) {
                    i5 = waitStrategy.idle(i5);
                } else {
                    lpConsumerIndex++;
                    AtomicReferenceArrayQueue.spElement(atomicReferenceArray, calcElementOffset, null);
                    soConsumerIndex(lpConsumerIndex);
                    consumer.accept(lvElement);
                    i5 = 0;
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
