package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators;
import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class BaseMpscLinkedAtomicArrayQueue<E> extends BaseMpscLinkedAtomicArrayQueueColdProducerFields<E> implements MessagePassingQueue<E>, QueueProgressIndicators {
    private static final Object JUMP = new Object();

    public BaseMpscLinkedAtomicArrayQueue(int i4) {
        RangeUtil.checkGreaterThanOrEqual(i4, 2, "initialCapacity");
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i4);
        long j4 = (roundToPowerOfTwo - 1) << 1;
        AtomicReferenceArray<E> allocate = LinkedAtomicArrayQueueUtil.allocate(roundToPowerOfTwo + 1);
        this.producerBuffer = allocate;
        this.producerMask = j4;
        this.consumerBuffer = allocate;
        this.consumerMask = j4;
        soProducerLimit(j4);
    }

    private AtomicReferenceArray<E> getNextBuffer(AtomicReferenceArray<E> atomicReferenceArray, long j4) {
        int nextArrayOffset = nextArrayOffset(j4);
        AtomicReferenceArray<E> atomicReferenceArray2 = (AtomicReferenceArray) LinkedAtomicArrayQueueUtil.lvElement(atomicReferenceArray, nextArrayOffset);
        LinkedAtomicArrayQueueUtil.soElement(atomicReferenceArray, nextArrayOffset, null);
        return atomicReferenceArray2;
    }

    private int newBufferAndOffset(AtomicReferenceArray<E> atomicReferenceArray, long j4) {
        this.consumerBuffer = atomicReferenceArray;
        long length = (LinkedAtomicArrayQueueUtil.length(atomicReferenceArray) - 2) << 1;
        this.consumerMask = length;
        return LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset(j4, length);
    }

    private E newBufferPeek(AtomicReferenceArray<E> atomicReferenceArray, long j4) {
        E e4 = (E) LinkedAtomicArrayQueueUtil.lvElement(atomicReferenceArray, newBufferAndOffset(atomicReferenceArray, j4));
        if (e4 != null) {
            return e4;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private E newBufferPoll(AtomicReferenceArray<E> atomicReferenceArray, long j4) {
        int newBufferAndOffset = newBufferAndOffset(atomicReferenceArray, j4);
        E e4 = (E) LinkedAtomicArrayQueueUtil.lvElement(atomicReferenceArray, newBufferAndOffset);
        if (e4 != null) {
            LinkedAtomicArrayQueueUtil.soElement(atomicReferenceArray, newBufferAndOffset, null);
            soConsumerIndex(j4 + 2);
            return e4;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private int nextArrayOffset(long j4) {
        return LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset(j4 + 2, Long.MAX_VALUE);
    }

    private int offerSlowPath(long j4, long j5, long j6) {
        long lvConsumerIndex = lvConsumerIndex();
        long currentBufferCapacity = getCurrentBufferCapacity(j4) + lvConsumerIndex;
        if (currentBufferCapacity > j5) {
            return !casProducerLimit(j6, currentBufferCapacity) ? 1 : 0;
        } else if (availableInQueue(j5, lvConsumerIndex) <= 0) {
            return 2;
        } else {
            return casProducerIndex(j5, 1 + j5) ? 3 : 1;
        }
    }

    private void resize(long j4, AtomicReferenceArray<E> atomicReferenceArray, long j5, E e4) {
        int nextBufferSize = getNextBufferSize(atomicReferenceArray);
        AtomicReferenceArray<E> allocate = LinkedAtomicArrayQueueUtil.allocate(nextBufferSize);
        this.producerBuffer = allocate;
        long j6 = (nextBufferSize - 2) << 1;
        this.producerMask = j6;
        int modifiedCalcElementOffset = LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset(j5, j4);
        LinkedAtomicArrayQueueUtil.soElement(allocate, LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset(j5, j6), e4);
        LinkedAtomicArrayQueueUtil.soElement(atomicReferenceArray, nextArrayOffset(j4), allocate);
        long availableInQueue = availableInQueue(j5, lvConsumerIndex());
        RangeUtil.checkPositive(availableInQueue, "availableInQueue");
        soProducerLimit(Math.min(j6, availableInQueue) + j5);
        soProducerIndex(j5 + 2);
        LinkedAtomicArrayQueueUtil.soElement(atomicReferenceArray, modifiedCalcElementOffset, JUMP);
    }

    protected abstract long availableInQueue(long j4, long j5);

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public abstract int capacity();

    @Override // io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public long currentConsumerIndex() {
        return lvConsumerIndex() / 2;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public long currentProducerIndex() {
        return lvProducerIndex() / 2;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return drain(consumer, capacity());
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

    protected abstract long getCurrentBufferCapacity(long j4);

    protected abstract int getNextBufferSize(AtomicReferenceArray<E> atomicReferenceArray);

    @Override // java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final boolean isEmpty() {
        return lvConsumerIndex() == lvProducerIndex();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(E e4) {
        e4.getClass();
        while (true) {
            long lvProducerLimit = lvProducerLimit();
            long lvProducerIndex = lvProducerIndex();
            if ((lvProducerIndex & 1) != 1) {
                long j4 = this.producerMask;
                AtomicReferenceArray<E> atomicReferenceArray = this.producerBuffer;
                if (lvProducerLimit <= lvProducerIndex) {
                    int offerSlowPath = offerSlowPath(j4, lvProducerIndex, lvProducerLimit);
                    if (offerSlowPath == 1) {
                        continue;
                    } else if (offerSlowPath == 2) {
                        return false;
                    } else {
                        if (offerSlowPath == 3) {
                            resize(j4, atomicReferenceArray, lvProducerIndex, e4);
                            return true;
                        }
                    }
                }
                if (casProducerIndex(lvProducerIndex, 2 + lvProducerIndex)) {
                    LinkedAtomicArrayQueueUtil.soElement(atomicReferenceArray, LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset(lvProducerIndex, j4), e4);
                    return true;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c A[RETURN] */
    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public E peek() {
        /*
            r10 = this;
            java.util.concurrent.atomic.AtomicReferenceArray<E> r0 = r10.consumerBuffer
            long r1 = r10.consumerIndex
            long r3 = r10.consumerMask
            int r5 = io.netty.util.internal.shaded.org.jctools.queues.atomic.LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset(r1, r3)
            java.lang.Object r6 = io.netty.util.internal.shaded.org.jctools.queues.atomic.LinkedAtomicArrayQueueUtil.lvElement(r0, r5)
            if (r6 != 0) goto L1f
            long r7 = r10.lvProducerIndex()
            int r9 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r9 == 0) goto L1f
        L18:
            java.lang.Object r6 = io.netty.util.internal.shaded.org.jctools.queues.atomic.LinkedAtomicArrayQueueUtil.lvElement(r0, r5)
            if (r6 != 0) goto L1f
            goto L18
        L1f:
            java.lang.Object r5 = io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue.JUMP
            if (r6 != r5) goto L2c
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r10.getNextBuffer(r0, r3)
            java.lang.Object r0 = r10.newBufferPeek(r0, r1)
            return r0
        L2c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue.peek():java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public E poll() {
        /*
            r10 = this;
            java.util.concurrent.atomic.AtomicReferenceArray<E> r0 = r10.consumerBuffer
            long r1 = r10.consumerIndex
            long r3 = r10.consumerMask
            int r5 = io.netty.util.internal.shaded.org.jctools.queues.atomic.LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset(r1, r3)
            java.lang.Object r6 = io.netty.util.internal.shaded.org.jctools.queues.atomic.LinkedAtomicArrayQueueUtil.lvElement(r0, r5)
            r7 = 0
            if (r6 != 0) goto L21
            long r8 = r10.lvProducerIndex()
            int r6 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r6 == 0) goto L20
        L19:
            java.lang.Object r6 = io.netty.util.internal.shaded.org.jctools.queues.atomic.LinkedAtomicArrayQueueUtil.lvElement(r0, r5)
            if (r6 == 0) goto L19
            goto L21
        L20:
            return r7
        L21:
            java.lang.Object r8 = io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue.JUMP
            if (r6 != r8) goto L2e
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r10.getNextBuffer(r0, r3)
            java.lang.Object r0 = r10.newBufferPoll(r0, r1)
            return r0
        L2e:
            io.netty.util.internal.shaded.org.jctools.queues.atomic.LinkedAtomicArrayQueueUtil.soElement(r0, r5, r7)
            r3 = 2
            long r1 = r1 + r3
            r10.soConsumerIndex(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue.poll():java.lang.Object");
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e4) {
        return offer(e4);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        AtomicReferenceArray<E> atomicReferenceArray = this.consumerBuffer;
        long j4 = this.consumerIndex;
        long j5 = this.consumerMask;
        E e4 = (E) LinkedAtomicArrayQueueUtil.lvElement(atomicReferenceArray, LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset(j4, j5));
        return e4 == JUMP ? newBufferPeek(getNextBuffer(atomicReferenceArray, j5), j4) : e4;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        AtomicReferenceArray<E> atomicReferenceArray = this.consumerBuffer;
        long j4 = this.consumerIndex;
        long j5 = this.consumerMask;
        int modifiedCalcElementOffset = LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset(j4, j5);
        E e4 = (E) LinkedAtomicArrayQueueUtil.lvElement(atomicReferenceArray, modifiedCalcElementOffset);
        if (e4 == null) {
            return null;
        }
        if (e4 == JUMP) {
            return newBufferPoll(getNextBuffer(atomicReferenceArray, j5), j4);
        }
        LinkedAtomicArrayQueueUtil.soElement(atomicReferenceArray, modifiedCalcElementOffset, null);
        soConsumerIndex(j4 + 2);
        return e4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final int size() {
        long lvProducerIndex;
        long lvConsumerIndex;
        long lvConsumerIndex2 = lvConsumerIndex();
        while (true) {
            lvProducerIndex = lvProducerIndex();
            lvConsumerIndex = lvConsumerIndex();
            if (lvConsumerIndex2 == lvConsumerIndex) {
                break;
            }
            lvConsumerIndex2 = lvConsumerIndex;
        }
        long j4 = (lvProducerIndex - lvConsumerIndex) >> 1;
        if (j4 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j4;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return getClass().getName();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i4) {
        int i5 = 0;
        while (i5 < i4) {
            E relaxedPoll = relaxedPoll();
            if (relaxedPoll == null) {
                break;
            }
            consumer.accept(relaxedPoll);
            i5++;
        }
        return i5;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i4) {
        while (true) {
            long lvProducerLimit = lvProducerLimit();
            long lvProducerIndex = lvProducerIndex();
            if ((lvProducerIndex & 1) != 1) {
                long j4 = this.producerMask;
                AtomicReferenceArray<E> atomicReferenceArray = this.producerBuffer;
                long min = Math.min(lvProducerLimit, (i4 * 2) + lvProducerIndex);
                if (lvProducerIndex == lvProducerLimit || lvProducerLimit < min) {
                    int offerSlowPath = offerSlowPath(j4, lvProducerIndex, lvProducerLimit);
                    if (offerSlowPath == 1) {
                        continue;
                    } else if (offerSlowPath == 2) {
                        return 0;
                    } else {
                        if (offerSlowPath == 3) {
                            resize(j4, atomicReferenceArray, lvProducerIndex, supplier.get());
                            return 1;
                        }
                    }
                }
                if (casProducerIndex(lvProducerIndex, min)) {
                    int i5 = (int) ((min - lvProducerIndex) / 2);
                    for (int i6 = 0; i6 < i5; i6++) {
                        LinkedAtomicArrayQueueUtil.soElement(atomicReferenceArray, LinkedAtomicArrayQueueUtil.modifiedCalcElementOffset((i6 * 2) + lvProducerIndex, j4), supplier.get());
                    }
                    return i5;
                }
            }
        }
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        E relaxedPoll;
        while (true) {
            while (exitCondition.keepRunning()) {
                relaxedPoll = relaxedPoll();
                int idle = relaxedPoll == null ? waitStrategy.idle(idle) : 0;
            }
            return;
            consumer.accept(relaxedPoll);
        }
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        while (exitCondition.keepRunning()) {
            while (fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH) != 0 && exitCondition.keepRunning()) {
            }
            int i4 = 0;
            while (exitCondition.keepRunning() && fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH) == 0) {
                i4 = waitStrategy.idle(i4);
            }
        }
    }
}
