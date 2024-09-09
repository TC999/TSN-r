package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class LinkedArrayQueueUtil {
    private LinkedArrayQueueUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int length(Object[] objArr) {
        return objArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long modifiedCalcElementOffset(long j4, long j5) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((j4 & j5) << (UnsafeRefArrayAccess.REF_ELEMENT_SHIFT - 1));
    }

    static long nextArrayOffset(Object[] objArr) {
        return UnsafeRefArrayAccess.REF_ARRAY_BASE + ((length(objArr) - 1) << UnsafeRefArrayAccess.REF_ELEMENT_SHIFT);
    }
}
