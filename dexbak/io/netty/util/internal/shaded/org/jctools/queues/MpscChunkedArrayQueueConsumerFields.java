package io.netty.util.internal.shaded.org.jctools.queues;

/* compiled from: MpscChunkedArrayQueue.java */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
abstract class MpscChunkedArrayQueueConsumerFields<E> extends MpscChunkedArrayQueuePad3<E> {
    protected E[] consumerBuffer;
    protected long consumerIndex;
    protected long consumerMask;
}
