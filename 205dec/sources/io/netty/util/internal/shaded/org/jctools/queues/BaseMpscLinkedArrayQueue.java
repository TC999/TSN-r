package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.RangeUtil;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class BaseMpscLinkedArrayQueue<E> extends BaseMpscLinkedArrayQueueColdProducerFields<E> implements MessagePassingQueue<E>, QueueProgressIndicators {
    private static final int CONTINUE_TO_P_INDEX_CAS = 0;
    private static final Object JUMP = new Object();
    private static final int QUEUE_FULL = 2;
    private static final int QUEUE_RESIZE = 3;
    private static final int RETRY = 1;

    public BaseMpscLinkedArrayQueue(int i4) {
        RangeUtil.checkGreaterThanOrEqual(i4, 2, "initialCapacity");
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i4);
        long j4 = (roundToPowerOfTwo - 1) << 1;
        E[] eArr = (E[]) CircularArrayOffsetCalculator.allocate(roundToPowerOfTwo + 1);
        this.producerBuffer = eArr;
        this.producerMask = j4;
        this.consumerBuffer = eArr;
        this.consumerMask = j4;
        soProducerLimit(j4);
    }

    private E[] getNextBuffer(E[] eArr, long j4) {
        long nextArrayOffset = nextArrayOffset(j4);
        E[] eArr2 = (E[]) ((Object[]) UnsafeRefArrayAccess.lvElement(eArr, nextArrayOffset));
        UnsafeRefArrayAccess.soElement(eArr, nextArrayOffset, null);
        return eArr2;
    }

    private long newBufferAndOffset(E[] eArr, long j4) {
        this.consumerBuffer = eArr;
        long length = (LinkedArrayQueueUtil.length(eArr) - 2) << 1;
        this.consumerMask = length;
        return LinkedArrayQueueUtil.modifiedCalcElementOffset(j4, length);
    }

    private E newBufferPeek(E[] eArr, long j4) {
        E e4 = (E) UnsafeRefArrayAccess.lvElement(eArr, newBufferAndOffset(eArr, j4));
        if (e4 != null) {
            return e4;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private E newBufferPoll(E[] eArr, long j4) {
        long newBufferAndOffset = newBufferAndOffset(eArr, j4);
        E e4 = (E) UnsafeRefArrayAccess.lvElement(eArr, newBufferAndOffset);
        if (e4 != null) {
            UnsafeRefArrayAccess.soElement(eArr, newBufferAndOffset, null);
            soConsumerIndex(j4 + 2);
            return e4;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private long nextArrayOffset(long j4) {
        return LinkedArrayQueueUtil.modifiedCalcElementOffset(j4 + 2, Long.MAX_VALUE);
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

    private void resize(long j4, E[] eArr, long j5, E e4) {
        int nextBufferSize = getNextBufferSize(eArr);
        E[] eArr2 = (E[]) CircularArrayOffsetCalculator.allocate(nextBufferSize);
        this.producerBuffer = eArr2;
        long j6 = (nextBufferSize - 2) << 1;
        this.producerMask = j6;
        long modifiedCalcElementOffset = LinkedArrayQueueUtil.modifiedCalcElementOffset(j5, j4);
        UnsafeRefArrayAccess.soElement(eArr2, LinkedArrayQueueUtil.modifiedCalcElementOffset(j5, j6), e4);
        UnsafeRefArrayAccess.soElement(eArr, nextArrayOffset(j4), eArr2);
        long availableInQueue = availableInQueue(j5, lvConsumerIndex());
        RangeUtil.checkPositive(availableInQueue, "availableInQueue");
        soProducerLimit(Math.min(j6, availableInQueue) + j5);
        soProducerIndex(j5 + 2);
        UnsafeRefArrayAccess.soElement(eArr, modifiedCalcElementOffset, JUMP);
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

    protected abstract int getNextBufferSize(E[] eArr);

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
                E[] eArr = this.producerBuffer;
                if (lvProducerLimit <= lvProducerIndex) {
                    int offerSlowPath = offerSlowPath(j4, lvProducerIndex, lvProducerLimit);
                    if (offerSlowPath == 1) {
                        continue;
                    } else if (offerSlowPath == 2) {
                        return false;
                    } else {
                        if (offerSlowPath == 3) {
                            resize(j4, eArr, lvProducerIndex, e4);
                            return true;
                        }
                    }
                }
                if (casProducerIndex(lvProducerIndex, 2 + lvProducerIndex)) {
                    UnsafeRefArrayAccess.soElement(eArr, LinkedArrayQueueUtil.modifiedCalcElementOffset(lvProducerIndex, j4), e4);
                    return true;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b A[RETURN] */
    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public E peek() {
        /*
            r11 = this;
            E[] r0 = r11.consumerBuffer
            long r1 = r11.consumerIndex
            long r3 = r11.consumerMask
            long r5 = io.netty.util.internal.shaded.org.jctools.queues.LinkedArrayQueueUtil.modifiedCalcElementOffset(r1, r3)
            java.lang.Object r7 = io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.lvElement(r0, r5)
            if (r7 != 0) goto L1e
            long r8 = r11.lvProducerIndex()
            int r10 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r10 == 0) goto L1e
        L18:
            java.lang.Object r7 = io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.lvElement(r0, r5)
            if (r7 == 0) goto L18
        L1e:
            java.lang.Object r5 = io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue.JUMP
            if (r7 != r5) goto L2b
            java.lang.Object[] r0 = r11.getNextBuffer(r0, r3)
            java.lang.Object r0 = r11.newBufferPeek(r0, r1)
            return r0
        L2b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue.peek():java.lang.Object");
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
            r11 = this;
            E[] r0 = r11.consumerBuffer
            long r1 = r11.consumerIndex
            long r3 = r11.consumerMask
            long r5 = io.netty.util.internal.shaded.org.jctools.queues.LinkedArrayQueueUtil.modifiedCalcElementOffset(r1, r3)
            java.lang.Object r7 = io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.lvElement(r0, r5)
            r8 = 0
            if (r7 != 0) goto L21
            long r9 = r11.lvProducerIndex()
            int r7 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r7 == 0) goto L20
        L19:
            java.lang.Object r7 = io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.lvElement(r0, r5)
            if (r7 == 0) goto L19
            goto L21
        L20:
            return r8
        L21:
            java.lang.Object r9 = io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue.JUMP
            if (r7 != r9) goto L2e
            java.lang.Object[] r0 = r11.getNextBuffer(r0, r3)
            java.lang.Object r0 = r11.newBufferPoll(r0, r1)
            return r0
        L2e:
            io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.soElement(r0, r5, r8)
            r3 = 2
            long r1 = r1 + r3
            r11.soConsumerIndex(r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue.poll():java.lang.Object");
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e4) {
        return offer(e4);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        E[] eArr = this.consumerBuffer;
        long j4 = this.consumerIndex;
        long j5 = this.consumerMask;
        E e4 = (E) UnsafeRefArrayAccess.lvElement(eArr, LinkedArrayQueueUtil.modifiedCalcElementOffset(j4, j5));
        return e4 == JUMP ? newBufferPeek(getNextBuffer(eArr, j5), j4) : e4;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        E[] eArr = this.consumerBuffer;
        long j4 = this.consumerIndex;
        long j5 = this.consumerMask;
        long modifiedCalcElementOffset = LinkedArrayQueueUtil.modifiedCalcElementOffset(j4, j5);
        E e4 = (E) UnsafeRefArrayAccess.lvElement(eArr, modifiedCalcElementOffset);
        if (e4 == null) {
            return null;
        }
        if (e4 == JUMP) {
            return newBufferPoll(getNextBuffer(eArr, j5), j4);
        }
        UnsafeRefArrayAccess.soElement(eArr, modifiedCalcElementOffset, null);
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
                E[] eArr = this.producerBuffer;
                long min = Math.min(lvProducerLimit, (i4 * 2) + lvProducerIndex);
                if (lvProducerIndex >= lvProducerLimit || lvProducerLimit < min) {
                    int offerSlowPath = offerSlowPath(j4, lvProducerIndex, lvProducerLimit);
                    if (offerSlowPath != 0 && offerSlowPath != 1) {
                        if (offerSlowPath == 2) {
                            return 0;
                        }
                        if (offerSlowPath == 3) {
                            resize(j4, eArr, lvProducerIndex, supplier.get());
                            return 1;
                        }
                    }
                }
                if (casProducerIndex(lvProducerIndex, min)) {
                    int i5 = (int) ((min - lvProducerIndex) / 2);
                    for (int i6 = 0; i6 < i5; i6++) {
                        UnsafeRefArrayAccess.soElement(eArr, LinkedArrayQueueUtil.modifiedCalcElementOffset((i6 * 2) + lvProducerIndex, j4), supplier.get());
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
            if (fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH) == 0) {
                int i4 = 0;
                while (exitCondition.keepRunning() && fill(supplier, PortableJvmInfo.RECOMENDED_OFFER_BATCH) == 0) {
                    i4 = waitStrategy.idle(i4);
                }
            }
        }
    }
}
