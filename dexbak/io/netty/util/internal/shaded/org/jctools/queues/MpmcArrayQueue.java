package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.util.JvmInfo;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class MpmcArrayQueue<E> extends MpmcArrayQueueConsumerField<E> implements QueueProgressIndicators {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int RECOMENDED_OFFER_BATCH;
    static final int RECOMENDED_POLL_BATCH;
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

    static {
        int i = JvmInfo.CPUs;
        RECOMENDED_POLL_BATCH = i * 4;
        RECOMENDED_OFFER_BATCH = i * 4;
    }

    public MpmcArrayQueue(int i) {
        super(validateCapacity(i));
    }

    private static int validateCapacity(int i) {
        if (i >= 2) {
            return i;
        }
        throw new IllegalArgumentException("Minimum size is 2");
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
        int capacity = capacity();
        int i = 0;
        while (i < capacity) {
            int drain = drain(consumer, RECOMENDED_POLL_BATCH);
            if (drain == 0) {
                break;
            }
            i += drain;
        }
        return i;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> supplier) {
        int capacity = capacity();
        long j = 0;
        do {
            int fill = fill(supplier, RECOMENDED_OFFER_BATCH);
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
        e.getClass();
        long j = this.mask;
        long j2 = j + 1;
        long[] jArr = this.sequenceBuffer;
        long j3 = Long.MAX_VALUE;
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long calcSequenceOffset = ConcurrentSequencedCircularArrayQueue.calcSequenceOffset(lvProducerIndex, j);
            long lvSequence = lvSequence(jArr, calcSequenceOffset);
            if (lvSequence < lvProducerIndex) {
                long j4 = lvProducerIndex - j2;
                if (j4 <= j3) {
                    j3 = lvConsumerIndex();
                    if (j4 <= j3) {
                        return false;
                    }
                }
                lvSequence = lvProducerIndex + 1;
            }
            if (lvSequence <= lvProducerIndex) {
                long j5 = lvProducerIndex + 1;
                if (casProducerIndex(lvProducerIndex, j5)) {
                    UnsafeRefArrayAccess.soElement(this.buffer, ConcurrentCircularArrayQueue.calcElementOffset(lvProducerIndex, j), e);
                    soSequence(jArr, calcSequenceOffset, j5);
                    return true;
                }
            }
        }
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E peek() {
        long lvConsumerIndex;
        E e;
        do {
            lvConsumerIndex = lvConsumerIndex();
            e = (E) UnsafeRefArrayAccess.lpElement(this.buffer, calcElementOffset(lvConsumerIndex));
            if (e != null) {
                break;
            }
        } while (lvConsumerIndex != lvProducerIndex());
        return e;
    }

    @Override // java.util.Queue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E poll() {
        long[] jArr = this.sequenceBuffer;
        long j = this.mask;
        long j2 = -1;
        while (true) {
            long lvConsumerIndex = lvConsumerIndex();
            long calcSequenceOffset = ConcurrentSequencedCircularArrayQueue.calcSequenceOffset(lvConsumerIndex, j);
            long lvSequence = lvSequence(jArr, calcSequenceOffset);
            long j3 = lvConsumerIndex + 1;
            if (lvSequence < j3) {
                if (lvConsumerIndex >= j2) {
                    j2 = lvProducerIndex();
                    if (lvConsumerIndex == j2) {
                        return null;
                    }
                }
                lvSequence = j3 + 1;
            }
            if (lvSequence <= j3 && casConsumerIndex(lvConsumerIndex, j3)) {
                long calcElementOffset = ConcurrentCircularArrayQueue.calcElementOffset(lvConsumerIndex, j);
                E e = (E) UnsafeRefArrayAccess.lpElement(this.buffer, calcElementOffset);
                UnsafeRefArrayAccess.soElement(this.buffer, calcElementOffset, null);
                soSequence(jArr, calcSequenceOffset, lvConsumerIndex + j + 1);
                return e;
            }
        }
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        e.getClass();
        long j = this.mask;
        long[] jArr = this.sequenceBuffer;
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long calcSequenceOffset = ConcurrentSequencedCircularArrayQueue.calcSequenceOffset(lvProducerIndex, j);
            long lvSequence = lvSequence(jArr, calcSequenceOffset);
            if (lvSequence < lvProducerIndex) {
                return false;
            }
            if (lvSequence <= lvProducerIndex) {
                long j2 = 1 + lvProducerIndex;
                if (casProducerIndex(lvProducerIndex, j2)) {
                    UnsafeRefArrayAccess.soElement(this.buffer, ConcurrentCircularArrayQueue.calcElementOffset(lvProducerIndex, j), e);
                    soSequence(jArr, calcSequenceOffset, j2);
                    return true;
                }
            }
        }
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        return (E) UnsafeRefArrayAccess.lpElement(this.buffer, calcElementOffset(lvConsumerIndex()));
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        long[] jArr = this.sequenceBuffer;
        long j = this.mask;
        while (true) {
            long lvConsumerIndex = lvConsumerIndex();
            long calcSequenceOffset = ConcurrentSequencedCircularArrayQueue.calcSequenceOffset(lvConsumerIndex, j);
            long lvSequence = lvSequence(jArr, calcSequenceOffset);
            long j2 = lvConsumerIndex + 1;
            if (lvSequence < j2) {
                return null;
            }
            if (lvSequence <= j2 && casConsumerIndex(lvConsumerIndex, j2)) {
                long calcElementOffset = ConcurrentCircularArrayQueue.calcElementOffset(lvConsumerIndex, j);
                E e = (E) UnsafeRefArrayAccess.lpElement(this.buffer, calcElementOffset);
                UnsafeRefArrayAccess.soElement(this.buffer, calcElementOffset, null);
                soSequence(jArr, calcSequenceOffset, lvConsumerIndex + j + 1);
                return e;
            }
        }
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
        r2 = io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue.calcElementOffset(r0, r9);
        r4 = io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.lpElement(r11, r2);
        io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.soElement(r11, r2, null);
        soSequence(r8, r2, 1 + (r0 + r9));
        r19.accept(r4);
        r12 = r12 + 1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int drain(io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer<E> r19, int r20) {
        /*
            r18 = this;
            r6 = r18
            r7 = r20
            long[] r8 = r6.sequenceBuffer
            long r9 = r6.mask
            E[] r11 = r6.buffer
            r0 = 0
            r12 = 0
        Lc:
            if (r12 >= r7) goto L50
        Le:
            long r0 = r18.lvConsumerIndex()
            long r2 = io.netty.util.internal.shaded.org.jctools.queues.ConcurrentSequencedCircularArrayQueue.calcSequenceOffset(r0, r9)
            long r4 = r6.lvSequence(r8, r2)
            r13 = 1
            r15 = r2
            long r2 = r0 + r13
            int r17 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r17 >= 0) goto L24
            return r12
        L24:
            int r17 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r17 > 0) goto L4d
            boolean r2 = r6.casConsumerIndex(r0, r2)
            if (r2 == 0) goto L4d
            long r2 = io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue.calcElementOffset(r0, r9)
            java.lang.Object r4 = io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.lpElement(r11, r2)
            r5 = 0
            io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.soElement(r11, r2, r5)
            long r0 = r0 + r9
            long r13 = r13 + r0
            r0 = r18
            r1 = r8
            r2 = r15
            r15 = r4
            r4 = r13
            r0.soSequence(r1, r2, r4)
            r0 = r19
            r0.accept(r15)
            int r12 = r12 + 1
            goto Lc
        L4d:
            r0 = r19
            goto Le
        L50:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.shaded.org.jctools.queues.MpmcArrayQueue.drain(io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue$Consumer, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.soElement(r9, io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue.calcElementOffset(r0, r7), r13.get());
        soSequence(r6, r2, r4);
        r10 = r10 + 1;
     */
    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int fill(io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Supplier<E> r13, int r14) {
        /*
            r12 = this;
            long[] r6 = r12.sequenceBuffer
            long r7 = r12.mask
            E[] r9 = r12.buffer
            r0 = 0
            r10 = 0
        L8:
            if (r10 >= r14) goto L3b
        La:
            long r0 = r12.lvProducerIndex()
            long r2 = io.netty.util.internal.shaded.org.jctools.queues.ConcurrentSequencedCircularArrayQueue.calcSequenceOffset(r0, r7)
            long r4 = r12.lvSequence(r6, r2)
            int r11 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r11 >= 0) goto L1b
            return r10
        L1b:
            int r11 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r11 > 0) goto La
            r4 = 1
            long r4 = r4 + r0
            boolean r11 = r12.casProducerIndex(r0, r4)
            if (r11 == 0) goto La
            long r0 = io.netty.util.internal.shaded.org.jctools.queues.ConcurrentCircularArrayQueue.calcElementOffset(r0, r7)
            java.lang.Object r11 = r13.get()
            io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess.soElement(r9, r0, r11)
            r0 = r12
            r1 = r6
            r0.soSequence(r1, r2, r4)
            int r10 = r10 + 1
            goto L8
        L3b:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.shaded.org.jctools.queues.MpmcArrayQueue.fill(io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue$Supplier, int):int");
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        while (true) {
            while (exitCondition.keepRunning()) {
                int idle = fill(supplier, RECOMENDED_OFFER_BATCH) == 0 ? waitStrategy.idle(idle) : 0;
            }
            return;
        }
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        while (true) {
            while (exitCondition.keepRunning()) {
                int idle = drain(consumer, RECOMENDED_POLL_BATCH) == 0 ? waitStrategy.idle(idle) : 0;
            }
            return;
        }
    }
}
