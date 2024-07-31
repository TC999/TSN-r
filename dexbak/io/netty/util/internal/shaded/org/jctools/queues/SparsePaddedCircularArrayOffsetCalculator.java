package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SparsePaddedCircularArrayOffsetCalculator {
    private static final long REF_ARRAY_BASE;
    private static final int REF_ELEMENT_SHIFT;
    static final int SPARSE_SHIFT;

    static {
        int intValue = Integer.getInteger("io.netty.util.internal.shaded.org.jctools.sparse.shift", 0).intValue();
        SPARSE_SHIFT = intValue;
        REF_ELEMENT_SHIFT = UnsafeRefArrayAccess.REF_ELEMENT_SHIFT + intValue;
        REF_ARRAY_BASE = PaddedCircularArrayOffsetCalculator.REF_ARRAY_BASE;
    }

    private SparsePaddedCircularArrayOffsetCalculator() {
    }

    public static <E> E[] allocate(int i) {
        return (E[]) new Object[(i << SPARSE_SHIFT) + (PaddedCircularArrayOffsetCalculator.REF_BUFFER_PAD * 2)];
    }

    public static long calcElementOffset(long j, long j2) {
        return REF_ARRAY_BASE + ((j & j2) << REF_ELEMENT_SHIFT);
    }
}
