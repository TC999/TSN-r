package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class LinkedAtomicArrayQueueUtil {
    private LinkedAtomicArrayQueueUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> AtomicReferenceArray<E> allocate(int i4) {
        return new AtomicReferenceArray<>(i4);
    }

    static int calcElementOffset(long j4, long j5) {
        return (int) (j4 & j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int length(AtomicReferenceArray<?> atomicReferenceArray) {
        return atomicReferenceArray.length();
    }

    public static <E> E lpElement(AtomicReferenceArray<E> atomicReferenceArray, int i4) {
        return (E) AtomicReferenceArrayQueue.lpElement(atomicReferenceArray, i4);
    }

    public static <E> E lvElement(AtomicReferenceArray<E> atomicReferenceArray, int i4) {
        return (E) AtomicReferenceArrayQueue.lvElement(atomicReferenceArray, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int modifiedCalcElementOffset(long j4, long j5) {
        return ((int) (j4 & j5)) >> 1;
    }

    static int nextArrayOffset(AtomicReferenceArray<?> atomicReferenceArray) {
        return length(atomicReferenceArray) - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> void soElement(AtomicReferenceArray atomicReferenceArray, int i4, Object obj) {
        atomicReferenceArray.lazySet(i4, obj);
    }

    public static <E> void spElement(AtomicReferenceArray<E> atomicReferenceArray, int i4, E e4) {
        AtomicReferenceArrayQueue.spElement(atomicReferenceArray, i4, e4);
    }

    public static <E> void svElement(AtomicReferenceArray<E> atomicReferenceArray, int i4, E e4) {
        AtomicReferenceArrayQueue.svElement(atomicReferenceArray, i4, e4);
    }
}
