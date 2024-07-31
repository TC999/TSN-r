package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;
import java.lang.reflect.Field;
import java.util.Iterator;
import sun.misc.Unsafe;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class MpscChunkedArrayQueue<E> extends MpscChunkedArrayQueueConsumerFields<E> implements MessagePassingQueue<E>, QueueProgressIndicators {
    private static final long C_INDEX_OFFSET;
    private static final Object JUMP;
    private static final long P_INDEX_OFFSET;
    private static final long P_LIMIT_OFFSET;

    /* renamed from: p0 */
    long f40332p0;

    /* renamed from: p1 */
    long f40333p1;
    long p10;
    long p11;
    long p12;
    long p13;
    long p14;
    long p15;
    long p16;
    long p17;

    /* renamed from: p2 */
    long f40334p2;

    /* renamed from: p3 */
    long f40335p3;

    /* renamed from: p4 */
    long f40336p4;

    /* renamed from: p5 */
    long f40337p5;

    /* renamed from: p6 */
    long f40338p6;

    /* renamed from: p7 */
    long f40339p7;

    static {
        try {
            Field declaredField = MpscChunkedArrayQueueProducerFields.class.getDeclaredField("producerIndex");
            Unsafe unsafe = UnsafeAccess.UNSAFE;
            P_INDEX_OFFSET = unsafe.objectFieldOffset(declaredField);
            try {
                C_INDEX_OFFSET = unsafe.objectFieldOffset(MpscChunkedArrayQueueConsumerFields.class.getDeclaredField("consumerIndex"));
                try {
                    P_LIMIT_OFFSET = unsafe.objectFieldOffset(MpscChunkedArrayQueueColdProducerFields.class.getDeclaredField("producerLimit"));
                    JUMP = new Object();
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            } catch (NoSuchFieldException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchFieldException e3) {
            throw new RuntimeException(e3);
        }
    }

    public MpscChunkedArrayQueue(int i) {
        this(Math.max(2, Pow2.roundToPowerOfTwo(i / 8)), i, false);
    }

    private boolean casProducerIndex(long j, long j2) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, P_INDEX_OFFSET, j, j2);
    }

    private boolean casProducerLimit(long j, long j2) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, P_LIMIT_OFFSET, j, j2);
    }

    private E[] getNextBuffer(E[] eArr, long j) {
        long nextArrayOffset = nextArrayOffset(j);
        E[] eArr2 = (E[]) ((Object[]) UnsafeRefArrayAccess.lvElement(eArr, nextArrayOffset));
        UnsafeRefArrayAccess.soElement(eArr, nextArrayOffset, null);
        return eArr2;
    }

    private int getNextBufferCapacity(E[] eArr, long j) {
        int length = eArr.length;
        if (this.isFixedChunkSize) {
            return eArr.length;
        }
        if (eArr.length - 1 != j) {
            return (eArr.length * 2) - 1;
        }
        throw new IllegalStateException();
    }

    private long lvConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, C_INDEX_OFFSET);
    }

    private long lvProducerIndex() {
        return UnsafeAccess.UNSAFE.getLongVolatile(this, P_INDEX_OFFSET);
    }

    private long lvProducerLimit() {
        return this.producerLimit;
    }

    private static long modifiedCalcElementOffset(long j, long j2) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((j & j2) << (UnsafeRefArrayAccess.REF_ELEMENT_SHIFT - 1));
    }

    private long newBufferAndOffset(E[] eArr, long j) {
        this.consumerBuffer = eArr;
        long length = (eArr.length - 2) << 1;
        this.consumerMask = length;
        return modifiedCalcElementOffset(j, length);
    }

    private E newBufferPeek(E[] eArr, long j) {
        E e = (E) UnsafeRefArrayAccess.lvElement(eArr, newBufferAndOffset(eArr, j));
        if (e != null) {
            return e;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private E newBufferPoll(E[] eArr, long j) {
        long newBufferAndOffset = newBufferAndOffset(eArr, j);
        E e = (E) UnsafeRefArrayAccess.lvElement(eArr, newBufferAndOffset);
        if (e != null) {
            UnsafeRefArrayAccess.soElement(eArr, newBufferAndOffset, null);
            soConsumerIndex(j + 2);
            return e;
        }
        throw new IllegalStateException("new buffer must have at least one element");
    }

    private long nextArrayOffset(long j) {
        return modifiedCalcElementOffset(j + 2, Long.MAX_VALUE);
    }

    private int offerSlowPath(long j, E[] eArr, long j2, long j3) {
        long lvConsumerIndex = lvConsumerIndex();
        long j4 = this.maxQueueCapacity;
        long currentBufferCapacity = getCurrentBufferCapacity(j, j4) + lvConsumerIndex;
        if (currentBufferCapacity > j2) {
            return !casProducerLimit(j3, currentBufferCapacity) ? 1 : 0;
        } else if (lvConsumerIndex == j2 - j4) {
            return 2;
        } else {
            return casProducerIndex(j2, 1 + j2) ? 3 : 1;
        }
    }

    private void resize(long j, E[] eArr, long j2, long j3, long j4, E e) {
        int nextBufferCapacity = getNextBufferCapacity(eArr, j4);
        E[] eArr2 = (E[]) CircularArrayOffsetCalculator.allocate(nextBufferCapacity);
        this.producerBuffer = eArr2;
        this.producerMask = (nextBufferCapacity - 2) << 1;
        long modifiedCalcElementOffset = modifiedCalcElementOffset(j2, j);
        UnsafeRefArrayAccess.soElement(eArr2, modifiedCalcElementOffset(j2, this.producerMask), e);
        UnsafeRefArrayAccess.soElement(eArr, nextArrayOffset(j), eArr2);
        long j5 = j4 - (j2 - j3);
        if (j5 > 0) {
            soProducerLimit(Math.min(j, j5) + j2);
            UnsafeRefArrayAccess.soElement(eArr, modifiedCalcElementOffset, JUMP);
            soProducerIndex(2 + j2);
            return;
        }
        throw new IllegalStateException();
    }

    private void soConsumerIndex(long j) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, j);
    }

    private void soProducerIndex(long j) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, j);
    }

    private void soProducerLimit(long j) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_LIMIT_OFFSET, j);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return (int) (this.maxQueueCapacity / 2);
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
    public int fill(MessagePassingQueue.Supplier<E> supplier, int i) {
        long j;
        while (true) {
            long lvProducerLimit = lvProducerLimit();
            long lvProducerIndex = lvProducerIndex();
            if ((lvProducerIndex & 1) != 1) {
                long j2 = this.producerMask;
                E[] eArr = this.producerBuffer;
                long min = Math.min(lvProducerLimit, (i * 2) + lvProducerIndex);
                if (lvProducerIndex == lvProducerLimit || lvProducerLimit < min) {
                    int offerSlowPath = offerSlowPath(j2, eArr, lvProducerIndex, lvProducerLimit);
                    if (offerSlowPath == 1) {
                        continue;
                    } else if (offerSlowPath == 2) {
                        return 0;
                    } else {
                        if (offerSlowPath == 3) {
                            resize(j2, eArr, lvProducerIndex, this.consumerIndex, this.maxQueueCapacity, supplier.get());
                            return 1;
                        }
                        j = min;
                    }
                } else {
                    j = min;
                }
                if (casProducerIndex(lvProducerIndex, j)) {
                    int i2 = (int) ((j - lvProducerIndex) / 2);
                    for (int i3 = 0; i3 < i2; i3++) {
                        UnsafeRefArrayAccess.soElement(eArr, modifiedCalcElementOffset((i3 * 2) + lvProducerIndex, j2), supplier.get());
                    }
                    return i2;
                }
            }
        }
    }

    protected long getCurrentBufferCapacity(long j, long j2) {
        return (this.isFixedChunkSize || 2 + j != j2) ? j : j2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        e.getClass();
        while (true) {
            long lvProducerLimit = lvProducerLimit();
            long lvProducerIndex = lvProducerIndex();
            if ((lvProducerIndex & 1) != 1) {
                long j = this.producerMask;
                E[] eArr = this.producerBuffer;
                if (lvProducerLimit <= lvProducerIndex) {
                    int offerSlowPath = offerSlowPath(j, eArr, lvProducerIndex, lvProducerLimit);
                    if (offerSlowPath == 1) {
                        continue;
                    } else if (offerSlowPath == 2) {
                        return false;
                    } else {
                        if (offerSlowPath == 3) {
                            resize(j, eArr, lvProducerIndex, this.consumerIndex, this.maxQueueCapacity, e);
                            return true;
                        }
                    }
                }
                if (casProducerIndex(lvProducerIndex, 2 + lvProducerIndex)) {
                    UnsafeRefArrayAccess.soElement(eArr, modifiedCalcElementOffset(lvProducerIndex, j), e);
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
            r11 = this;
            E[] r0 = r11.consumerBuffer
            long r1 = r11.consumerIndex
            long r3 = r11.consumerMask
            long r5 = modifiedCalcElementOffset(r1, r3)
            java.lang.Object r7 = io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.lvElement(r0, r5)
            if (r7 != 0) goto L1f
            long r8 = r11.lvProducerIndex()
            int r10 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r10 == 0) goto L1f
        L18:
            java.lang.Object r7 = io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.lvElement(r0, r5)
            if (r7 != 0) goto L1f
            goto L18
        L1f:
            java.lang.Object r5 = io.netty.util.internal.shaded.org.jctools.queues.MpscChunkedArrayQueue.JUMP
            if (r7 != r5) goto L2c
            java.lang.Object[] r0 = r11.getNextBuffer(r0, r3)
            java.lang.Object r0 = r11.newBufferPeek(r0, r1)
            return r0
        L2c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.shaded.org.jctools.queues.MpscChunkedArrayQueue.peek():java.lang.Object");
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
            long r5 = modifiedCalcElementOffset(r1, r3)
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
            java.lang.Object r9 = io.netty.util.internal.shaded.org.jctools.queues.MpscChunkedArrayQueue.JUMP
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
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.shaded.org.jctools.queues.MpscChunkedArrayQueue.poll():java.lang.Object");
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        E[] eArr = this.consumerBuffer;
        long j = this.consumerIndex;
        long j2 = this.consumerMask;
        E e = (E) UnsafeRefArrayAccess.lvElement(eArr, modifiedCalcElementOffset(j, j2));
        return e == JUMP ? newBufferPeek(getNextBuffer(eArr, j2), j) : e;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        E[] eArr = this.consumerBuffer;
        long j = this.consumerIndex;
        long j2 = this.consumerMask;
        long modifiedCalcElementOffset = modifiedCalcElementOffset(j, j2);
        E e = (E) UnsafeRefArrayAccess.lvElement(eArr, modifiedCalcElementOffset);
        if (e == null) {
            return null;
        }
        if (e == JUMP) {
            return newBufferPoll(getNextBuffer(eArr, j2), j);
        }
        UnsafeRefArrayAccess.soElement(eArr, modifiedCalcElementOffset, null);
        soConsumerIndex(j + 2);
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final int size() {
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                return ((int) (lvProducerIndex - lvConsumerIndex2)) >> 1;
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }

    public MpscChunkedArrayQueue(int i, int i2, boolean z) {
        if (i < 2) {
            throw new IllegalArgumentException("Initial capacity must be 2 or more");
        }
        if (i2 >= 4) {
            if (Pow2.roundToPowerOfTwo(i) < Pow2.roundToPowerOfTwo(i2)) {
                int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
                long j = (roundToPowerOfTwo - 1) << 1;
                E[] eArr = (E[]) CircularArrayOffsetCalculator.allocate(roundToPowerOfTwo + 1);
                this.producerBuffer = eArr;
                this.producerMask = j;
                this.consumerBuffer = eArr;
                this.consumerMask = j;
                this.maxQueueCapacity = Pow2.roundToPowerOfTwo(i2) << 1;
                this.isFixedChunkSize = z;
                soProducerLimit(j);
                return;
            }
            throw new IllegalArgumentException("Initial capacity cannot exceed maximum capacity(both rounded up to a power of 2)");
        }
        throw new IllegalArgumentException("Max capacity must be 4 or more");
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer) {
        return drain(consumer, capacity());
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> consumer, int i) {
        int i2 = 0;
        while (i2 < i) {
            E relaxedPoll = relaxedPoll();
            if (relaxedPoll == null) {
                break;
            }
            consumer.accept(relaxedPoll);
            i2++;
        }
        return i2;
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

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        while (exitCondition.keepRunning()) {
            do {
            } while (fill(supplier, MpmcArrayQueue.RECOMENDED_OFFER_BATCH) != 0);
            int i = 0;
            while (fill(supplier, MpmcArrayQueue.RECOMENDED_OFFER_BATCH) == 0 && exitCondition.keepRunning()) {
                i = waitStrategy.idle(i);
            }
        }
    }
}
