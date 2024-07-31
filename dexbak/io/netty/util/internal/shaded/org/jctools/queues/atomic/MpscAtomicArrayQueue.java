package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class MpscAtomicArrayQueue<E> extends AtomicReferenceArrayQueue<E> implements QueueProgressIndicators {
    private final AtomicLong consumerIndex;
    private volatile long headCache;
    private final AtomicLong producerIndex;

    public MpscAtomicArrayQueue(int i) {
        super(i);
        this.consumerIndex = new AtomicLong();
        this.producerIndex = new AtomicLong();
    }

    private long lvConsumerIndex() {
        return this.consumerIndex.get();
    }

    private long lvProducerIndex() {
        return this.producerIndex.get();
    }

    protected final boolean casProducerIndex(long j, long j2) {
        return this.producerIndex.compareAndSet(j, j2);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public long currentConsumerIndex() {
        return lvConsumerIndex();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public long currentProducerIndex() {
        return lvProducerIndex();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return lvConsumerIndex() == lvProducerIndex();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    protected final long lvConsumerIndexCache() {
        return this.headCache;
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        long lvProducerIndex;
        e.getClass();
        int i = this.mask;
        long j = i + 1;
        long lvConsumerIndexCache = lvConsumerIndexCache();
        do {
            lvProducerIndex = lvProducerIndex();
            long j2 = lvProducerIndex - j;
            if (lvConsumerIndexCache <= j2) {
                lvConsumerIndexCache = lvConsumerIndex();
                if (lvConsumerIndexCache <= j2) {
                    return false;
                }
                svConsumerIndexCache(lvConsumerIndexCache);
            }
        } while (!casProducerIndex(lvProducerIndex, 1 + lvProducerIndex));
        soElement(calcElementOffset(lvProducerIndex, i), e);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        long lvConsumerIndex = lvConsumerIndex();
        int calcElementOffset = calcElementOffset(lvConsumerIndex);
        E lvElement = lvElement(atomicReferenceArray, calcElementOffset);
        if (lvElement != null) {
            return lvElement;
        }
        if (lvConsumerIndex != lvProducerIndex()) {
            do {
                lvElement = lvElement(atomicReferenceArray, calcElementOffset);
            } while (lvElement == null);
            return lvElement;
        }
        return null;
    }

    @Override // java.util.Queue
    public E poll() {
        long lvConsumerIndex = lvConsumerIndex();
        int calcElementOffset = calcElementOffset(lvConsumerIndex);
        AtomicReferenceArray<E> atomicReferenceArray = this.buffer;
        E lvElement = lvElement(atomicReferenceArray, calcElementOffset);
        if (lvElement == null) {
            if (lvConsumerIndex != lvProducerIndex()) {
                do {
                    lvElement = lvElement(atomicReferenceArray, calcElementOffset);
                } while (lvElement == null);
                spElement(atomicReferenceArray, calcElementOffset, null);
                soConsumerIndex(lvConsumerIndex + 1);
                return lvElement;
            }
            return null;
        }
        spElement(atomicReferenceArray, calcElementOffset, null);
        soConsumerIndex(lvConsumerIndex + 1);
        return lvElement;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
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

    protected void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    protected final void svConsumerIndexCache(long j) {
        this.headCache = j;
    }

    public final int weakOffer(E e) {
        if (e != null) {
            int i = this.mask;
            long lvProducerIndex = lvProducerIndex();
            long j = lvProducerIndex - (i + 1);
            if (lvConsumerIndexCache() <= j) {
                long lvConsumerIndex = lvConsumerIndex();
                if (lvConsumerIndex <= j) {
                    return 1;
                }
                svConsumerIndexCache(lvConsumerIndex);
            }
            if (casProducerIndex(lvProducerIndex, 1 + lvProducerIndex)) {
                soElement(calcElementOffset(lvProducerIndex, i), e);
                return 0;
            }
            return -1;
        }
        throw new NullPointerException("Null is not a valid element");
    }
}
