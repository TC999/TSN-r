package io.reactivex.internal.queue;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {
    AtomicReferenceArray<Object> consumerBuffer;
    final int consumerMask;
    AtomicReferenceArray<Object> producerBuffer;
    long producerLookAhead;
    int producerLookAheadStep;
    final int producerMask;
    static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object HAS_NEXT = new Object();
    final AtomicLong producerIndex = new AtomicLong();
    final AtomicLong consumerIndex = new AtomicLong();

    public SpscLinkedArrayQueue(int i4) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(Math.max(8, i4));
        int i5 = roundToPowerOfTwo - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(roundToPowerOfTwo + 1);
        this.producerBuffer = atomicReferenceArray;
        this.producerMask = i5;
        adjustLookAheadStep(roundToPowerOfTwo);
        this.consumerBuffer = atomicReferenceArray;
        this.consumerMask = i5;
        this.producerLookAhead = i5 - 1;
        soProducerIndex(0L);
    }

    private void adjustLookAheadStep(int i4) {
        this.producerLookAheadStep = Math.min(i4 / 4, MAX_LOOK_AHEAD_STEP);
    }

    private static int calcDirectOffset(int i4) {
        return i4;
    }

    private static int calcWrappedOffset(long j4, int i4) {
        return calcDirectOffset(((int) j4) & i4);
    }

    private long lpConsumerIndex() {
        return this.consumerIndex.get();
    }

    private long lpProducerIndex() {
        return this.producerIndex.get();
    }

    private long lvConsumerIndex() {
        return this.consumerIndex.get();
    }

    private static <E> Object lvElement(AtomicReferenceArray<Object> atomicReferenceArray, int i4) {
        return atomicReferenceArray.get(i4);
    }

    private AtomicReferenceArray<Object> lvNextBufferAndUnlink(AtomicReferenceArray<Object> atomicReferenceArray, int i4) {
        int calcDirectOffset = calcDirectOffset(i4);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) lvElement(atomicReferenceArray, calcDirectOffset);
        soElement(atomicReferenceArray, calcDirectOffset, null);
        return atomicReferenceArray2;
    }

    private long lvProducerIndex() {
        return this.producerIndex.get();
    }

    private T newBufferPeek(AtomicReferenceArray<Object> atomicReferenceArray, long j4, int i4) {
        this.consumerBuffer = atomicReferenceArray;
        return (T) lvElement(atomicReferenceArray, calcWrappedOffset(j4, i4));
    }

    private T newBufferPoll(AtomicReferenceArray<Object> atomicReferenceArray, long j4, int i4) {
        this.consumerBuffer = atomicReferenceArray;
        int calcWrappedOffset = calcWrappedOffset(j4, i4);
        T t3 = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
        if (t3 != null) {
            soElement(atomicReferenceArray, calcWrappedOffset, null);
            soConsumerIndex(j4 + 1);
        }
        return t3;
    }

    private void resize(AtomicReferenceArray<Object> atomicReferenceArray, long j4, int i4, T t3, long j5) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.producerBuffer = atomicReferenceArray2;
        this.producerLookAhead = (j5 + j4) - 1;
        soElement(atomicReferenceArray2, i4, t3);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, i4, HAS_NEXT);
        soProducerIndex(j4 + 1);
    }

    private void soConsumerIndex(long j4) {
        this.consumerIndex.lazySet(j4);
    }

    private static void soElement(AtomicReferenceArray<Object> atomicReferenceArray, int i4, Object obj) {
        atomicReferenceArray.lazySet(i4, obj);
    }

    private void soNext(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        soElement(atomicReferenceArray, calcDirectOffset(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void soProducerIndex(long j4) {
        this.producerIndex.lazySet(j4);
    }

    private boolean writeToQueue(AtomicReferenceArray<Object> atomicReferenceArray, T t3, long j4, int i4) {
        soElement(atomicReferenceArray, i4, t3);
        soProducerIndex(j4 + 1);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return lvProducerIndex() == lvConsumerIndex();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t3) {
        if (t3 != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
            long lpProducerIndex = lpProducerIndex();
            int i4 = this.producerMask;
            int calcWrappedOffset = calcWrappedOffset(lpProducerIndex, i4);
            if (lpProducerIndex < this.producerLookAhead) {
                return writeToQueue(atomicReferenceArray, t3, lpProducerIndex, calcWrappedOffset);
            }
            long j4 = this.producerLookAheadStep + lpProducerIndex;
            if (lvElement(atomicReferenceArray, calcWrappedOffset(j4, i4)) == null) {
                this.producerLookAhead = j4 - 1;
                return writeToQueue(atomicReferenceArray, t3, lpProducerIndex, calcWrappedOffset);
            } else if (lvElement(atomicReferenceArray, calcWrappedOffset(1 + lpProducerIndex, i4)) == null) {
                return writeToQueue(atomicReferenceArray, t3, lpProducerIndex, calcWrappedOffset);
            } else {
                resize(atomicReferenceArray, lpProducerIndex, calcWrappedOffset, t3, i4);
                return true;
            }
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        int i4 = this.consumerMask;
        T t3 = (T) lvElement(atomicReferenceArray, calcWrappedOffset(lpConsumerIndex, i4));
        return t3 == HAS_NEXT ? newBufferPeek(lvNextBufferAndUnlink(atomicReferenceArray, i4 + 1), lpConsumerIndex, i4) : t3;
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        int i4 = this.consumerMask;
        int calcWrappedOffset = calcWrappedOffset(lpConsumerIndex, i4);
        T t3 = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
        boolean z3 = t3 == HAS_NEXT;
        if (t3 == null || z3) {
            if (z3) {
                return newBufferPoll(lvNextBufferAndUnlink(atomicReferenceArray, i4 + 1), lpConsumerIndex, i4);
            }
            return null;
        }
        soElement(atomicReferenceArray, calcWrappedOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return t3;
    }

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

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t3, T t4) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
        long lvProducerIndex = lvProducerIndex();
        int i4 = this.producerMask;
        long j4 = 2 + lvProducerIndex;
        if (lvElement(atomicReferenceArray, calcWrappedOffset(j4, i4)) == null) {
            int calcWrappedOffset = calcWrappedOffset(lvProducerIndex, i4);
            soElement(atomicReferenceArray, calcWrappedOffset + 1, t4);
            soElement(atomicReferenceArray, calcWrappedOffset, t3);
            soProducerIndex(j4);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.producerBuffer = atomicReferenceArray2;
        int calcWrappedOffset2 = calcWrappedOffset(lvProducerIndex, i4);
        soElement(atomicReferenceArray2, calcWrappedOffset2 + 1, t4);
        soElement(atomicReferenceArray2, calcWrappedOffset2, t3);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, calcWrappedOffset2, HAS_NEXT);
        soProducerIndex(j4);
        return true;
    }
}
