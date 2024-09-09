package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class MpscChunkedAtomicArrayQueue<E> extends MpscChunkedAtomicArrayQueueColdProducerFields<E> {

    /* renamed from: p0  reason: collision with root package name */
    long f54837p0;

    /* renamed from: p1  reason: collision with root package name */
    long f54838p1;
    long p10;
    long p11;
    long p12;
    long p13;
    long p14;
    long p15;
    long p16;
    long p17;

    /* renamed from: p2  reason: collision with root package name */
    long f54839p2;
    long p3;
    long p4;
    long p5;
    long p6;
    long p7;

    public MpscChunkedAtomicArrayQueue(int i4) {
        super(Math.max(2, Math.min(1024, Pow2.roundToPowerOfTwo(i4 / 8))), i4);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    protected long availableInQueue(long j4, long j5) {
        return this.maxQueueCapacity - (j4 - j5);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return (int) (this.maxQueueCapacity / 2);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    protected long getCurrentBufferCapacity(long j4) {
        return j4;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    protected int getNextBufferSize(AtomicReferenceArray<E> atomicReferenceArray) {
        return LinkedAtomicArrayQueueUtil.length(atomicReferenceArray);
    }

    public MpscChunkedAtomicArrayQueue(int i4, int i5) {
        super(i4, i5);
    }
}
