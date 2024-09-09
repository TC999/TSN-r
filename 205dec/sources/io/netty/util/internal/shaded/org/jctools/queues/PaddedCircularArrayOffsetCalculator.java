package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.JvmInfo;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class PaddedCircularArrayOffsetCalculator {
    static final long REF_ARRAY_BASE;
    static final int REF_BUFFER_PAD;

    static {
        int i4 = UnsafeRefArrayAccess.REF_ELEMENT_SHIFT;
        int i5 = (JvmInfo.CACHE_LINE_SIZE * 2) >> i4;
        REF_BUFFER_PAD = i5;
        REF_ARRAY_BASE = UnsafeRefArrayAccess.REF_ARRAY_BASE + (i5 << i4);
    }

    private PaddedCircularArrayOffsetCalculator() {
    }

    public static <E> E[] allocate(int i4) {
        return (E[]) new Object[i4 + (REF_BUFFER_PAD * 2)];
    }

    protected static long calcElementOffset(long j4, long j5) {
        return REF_ARRAY_BASE + ((j4 & j5) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT);
    }
}
