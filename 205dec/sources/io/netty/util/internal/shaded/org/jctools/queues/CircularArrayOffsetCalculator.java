package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class CircularArrayOffsetCalculator {
    public static <E> E[] allocate(int i4) {
        return (E[]) new Object[i4];
    }

    public static long calcElementOffset(long j4, long j5) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((j4 & j5) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT);
    }
}
