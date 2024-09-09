package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.JvmInfo;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;
import sun.misc.Unsafe;

/* loaded from: E:\TSN-r\205dec\5406560.dex */
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
            int i4 = (JvmInfo.CACHE_LINE_SIZE * 2) / arrayIndexScale;
            SEQ_BUFFER_PAD = i4;
            ARRAY_BASE = unsafe.arrayBaseOffset(long[].class) + (i4 * arrayIndexScale);
            return;
        }
        throw new IllegalStateException("Unexpected long[] element size");
    }

    public ConcurrentSequencedCircularArrayQueue(int i4) {
        super(i4);
        int i5 = (int) (this.mask + 1);
        this.sequenceBuffer = new long[(i5 << SparsePaddedCircularArrayOffsetCalculator.SPARSE_SHIFT) + (SEQ_BUFFER_PAD * 2)];
        for (long j4 = 0; j4 < i5; j4++) {
            soSequence(this.sequenceBuffer, calcSequenceOffset(j4), j4);
        }
    }

    protected final long calcSequenceOffset(long j4) {
        return calcSequenceOffset(j4, this.mask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long lvSequence(long[] jArr, long j4) {
        return UnsafeAccess.UNSAFE.getLongVolatile(jArr, j4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void soSequence(long[] jArr, long j4, long j5) {
        UnsafeAccess.UNSAFE.putOrderedLong(jArr, j4, j5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long calcSequenceOffset(long j4, long j5) {
        return ARRAY_BASE + ((j4 & j5) << ELEMENT_SHIFT);
    }
}
