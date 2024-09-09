package io.netty.util.internal.shaded.org.jctools.util;

import sun.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class UnsafeRefArrayAccess {
    public static final long REF_ARRAY_BASE;
    public static final int REF_ELEMENT_SHIFT;

    static {
        Unsafe unsafe = UnsafeAccess.UNSAFE;
        int arrayIndexScale = unsafe.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = 2;
        } else if (8 == arrayIndexScale) {
            REF_ELEMENT_SHIFT = 3;
        } else {
            throw new IllegalStateException("Unknown pointer size");
        }
        REF_ARRAY_BASE = unsafe.arrayBaseOffset(Object[].class);
    }

    public static long calcElementOffset(long j4) {
        return REF_ARRAY_BASE + (j4 << REF_ELEMENT_SHIFT);
    }

    public static <E> E lpElement(E[] eArr, long j4) {
        return (E) UnsafeAccess.UNSAFE.getObject(eArr, j4);
    }

    public static <E> E lvElement(E[] eArr, long j4) {
        return (E) UnsafeAccess.UNSAFE.getObjectVolatile(eArr, j4);
    }

    public static <E> void soElement(E[] eArr, long j4, E e4) {
        UnsafeAccess.UNSAFE.putOrderedObject(eArr, j4, e4);
    }

    public static <E> void spElement(E[] eArr, long j4, E e4) {
        UnsafeAccess.UNSAFE.putObject(eArr, j4, e4);
    }
}
