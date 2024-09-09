package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class AtomicReferenceArrayQueue<E> extends AbstractQueue<E> implements IndexedQueueSizeUtil.IndexedQueue, QueueProgressIndicators, MessagePassingQueue<E> {
    protected final AtomicReferenceArray<E> buffer;
    protected final int mask;

    public AtomicReferenceArrayQueue(int i4) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i4);
        this.mask = roundToPowerOfTwo - 1;
        this.buffer = new AtomicReferenceArray<>(roundToPowerOfTwo);
    }

    public static <E> E lpElement(AtomicReferenceArray<E> atomicReferenceArray, int i4) {
        return atomicReferenceArray.get(i4);
    }

    public static <E> E lvElement(AtomicReferenceArray<E> atomicReferenceArray, int i4) {
        return atomicReferenceArray.get(i4);
    }

    public static <E> void soElement(AtomicReferenceArray<E> atomicReferenceArray, int i4, E e4) {
        atomicReferenceArray.lazySet(i4, e4);
    }

    public static <E> void spElement(AtomicReferenceArray<E> atomicReferenceArray, int i4, E e4) {
        atomicReferenceArray.lazySet(i4, e4);
    }

    public static <E> void svElement(AtomicReferenceArray<E> atomicReferenceArray, int i4, E e4) {
        atomicReferenceArray.set(i4, e4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int calcElementOffset(long j4) {
        return this.mask & ((int) j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int calcElementOffset(long j4, int i4) {
        return ((int) j4) & i4;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final int capacity() {
        return this.mask + 1;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public void clear() {
        do {
        } while (poll() != null);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public final long currentConsumerIndex() {
        return lvConsumerIndex();
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public final long currentProducerIndex() {
        return lvProducerIndex();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final boolean isEmpty() {
        return IndexedQueueSizeUtil.isEmpty(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public final int size() {
        return IndexedQueueSizeUtil.size(this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return getClass().getName();
    }

    protected final E lpElement(int i4) {
        return this.buffer.get(i4);
    }

    protected final E lvElement(int i4) {
        return (E) lvElement(this.buffer, i4);
    }

    protected final void soElement(int i4, E e4) {
        this.buffer.lazySet(i4, e4);
    }

    protected final void spElement(int i4, E e4) {
        this.buffer.lazySet(i4, e4);
    }
}
