package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class MpscChunkedArrayQueue<E> extends MpscChunkedArrayQueueColdProducerFields<E> {

    /* renamed from: p0  reason: collision with root package name */
    long f54825p0;

    /* renamed from: p1  reason: collision with root package name */
    long f54826p1;
    long p10;
    long p11;
    long p12;
    long p13;
    long p14;
    long p15;
    long p16;
    long p17;

    /* renamed from: p2  reason: collision with root package name */
    long f54827p2;
    long p3;
    long p4;
    long p5;
    long p6;
    long p7;

    public MpscChunkedArrayQueue(int i4) {
        super(Math.max(2, Math.min(1024, Pow2.roundToPowerOfTwo(i4 / 8))), i4);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue
    protected long availableInQueue(long j4, long j5) {
        return this.maxQueueCapacity - (j4 - j5);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue, io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return (int) (this.maxQueueCapacity / 2);
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue
    protected long getCurrentBufferCapacity(long j4) {
        return j4;
    }

    @Override // io.netty.util.internal.shaded.org.jctools.queues.BaseMpscLinkedArrayQueue
    protected int getNextBufferSize(E[] eArr) {
        return LinkedArrayQueueUtil.length(eArr);
    }

    public MpscChunkedArrayQueue(int i4, int i5) {
        super(i4, i5);
    }
}
