package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CircularArrayOffsetCalculator {
    private CircularArrayOffsetCalculator() {
    }

    public static <E> E[] allocate(int i) {
        return (E[]) new Object[i];
    }

    public static long calcElementOffset(long j, long j2) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((j & j2) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT);
    }
}
