package io.netty.util.internal.shaded.org.jctools.queues;

/* compiled from: MpscChunkedArrayQueue.java */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
abstract class MpscChunkedArrayQueueColdProducerFields<E> extends MpscChunkedArrayQueuePad2<E> {
    protected boolean isFixedChunkSize = false;
    protected long maxQueueCapacity;
    protected E[] producerBuffer;
    protected volatile long producerLimit;
    protected long producerMask;
}
