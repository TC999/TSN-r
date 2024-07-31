package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.JvmInfo;
import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class PaddedCircularArrayOffsetCalculator {
    static final long REF_ARRAY_BASE;
    static final int REF_BUFFER_PAD;

    static {
        int i = UnsafeRefArrayAccess.REF_ELEMENT_SHIFT;
        int i2 = (JvmInfo.CACHE_LINE_SIZE * 2) >> i;
        REF_BUFFER_PAD = i2;
        REF_ARRAY_BASE = UnsafeRefArrayAccess.REF_ARRAY_BASE + (i2 << i);
    }

    private PaddedCircularArrayOffsetCalculator() {
    }

    public static <E> E[] allocate(int i) {
        return (E[]) new Object[i + (REF_BUFFER_PAD * 2)];
    }

    protected static long calcElementOffset(long j, long j2) {
        return REF_ARRAY_BASE + ((j & j2) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT);
    }
}
