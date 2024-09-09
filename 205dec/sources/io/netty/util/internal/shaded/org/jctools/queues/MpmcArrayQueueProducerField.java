package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* compiled from: MpmcArrayQueue.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
abstract class MpmcArrayQueueProducerField<E> extends MpmcArrayQueueL1Pad<E> {
    private static final long P_INDEX_OFFSET;
    private volatile long producerIndex;

    static {
        try {
            P_INDEX_OFFSET = UnsafeAccess.UNSAFE.objectFieldOffset(MpmcArrayQueueProducerField.class.getDeclaredField("producerIndex"));
        } catch (NoSuchFieldException e4) {
            throw new RuntimeException(e4);
        }
    }

    public MpmcArrayQueueProducerField(int i4) {
        super(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean casProducerIndex(long j4, long j5) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, P_INDEX_OFFSET, j4, j5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvProducerIndex() {
        return this.producerIndex;
    }
}
