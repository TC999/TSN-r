package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.JvmInfo;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;
import sun.misc.Unsafe;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class ConcurrentSequencedCircularArrayQueue<E> extends ConcurrentCircularArrayQueue<E> {
    private static final long ARRAY_BASE;
    private static final int ELEMENT_SHIFT;
    protected static final int SEQ_BUFFER_PAD;
    protected final long[] sequenceBuffer;

    static {
        Unsafe unsafe = UnsafeAccess.UNSAFE;
        int arrayIndexScale = unsafe.arrayIndexScale(long[].class);
        if (8 == arrayIndexScale) {
            ELEMENT_SHIFT = SparsePaddedCircularArrayOffsetCalculator.SPARSE_SHIFT + 3;
            int i = (JvmInfo.CACHE_LINE_SIZE * 2) / arrayIndexScale;
            SEQ_BUFFER_PAD = i;
            ARRAY_BASE = unsafe.arrayBaseOffset(long[].class) + (i * arrayIndexScale);
            return;
        }
        throw new IllegalStateException("Unexpected long[] element size");
    }

    public ConcurrentSequencedCircularArrayQueue(int i) {
        super(i);
        int i2 = (int) (this.mask + 1);
        this.sequenceBuffer = new long[(i2 << SparsePaddedCircularArrayOffsetCalculator.SPARSE_SHIFT) + (SEQ_BUFFER_PAD * 2)];
        for (long j = 0; j < i2; j++) {
            soSequence(this.sequenceBuffer, calcSequenceOffset(j), j);
        }
    }

    protected final long calcSequenceOffset(long j) {
        return calcSequenceOffset(j, this.mask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long lvSequence(long[] jArr, long j) {
        return UnsafeAccess.UNSAFE.getLongVolatile(jArr, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void soSequence(long[] jArr, long j, long j2) {
        UnsafeAccess.UNSAFE.putOrderedLong(jArr, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long calcSequenceOffset(long j, long j2) {
        return ARRAY_BASE + ((j & j2) << ELEMENT_SHIFT);
    }
}
