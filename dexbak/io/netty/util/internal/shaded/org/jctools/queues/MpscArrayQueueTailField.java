package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* compiled from: MpscArrayQueue.java */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
abstract class MpscArrayQueueTailField<E> extends MpscArrayQueueL1Pad<E> {
    private static final long P_INDEX_OFFSET;
    private volatile long producerIndex;

    static {
        try {
            P_INDEX_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(MpscArrayQueueTailField.class.getDeclaredField("producerIndex"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public MpscArrayQueueTailField(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean casProducerIndex(long j, long j2) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, P_INDEX_OFFSET, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long lvProducerIndex() {
        return this.producerIndex;
    }
}
