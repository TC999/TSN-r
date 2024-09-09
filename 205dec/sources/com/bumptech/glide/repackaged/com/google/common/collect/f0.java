package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

/* compiled from: SortedIterables.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
final class f0 {
    public static <E> Comparator<? super E> a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        return comparator == null ? s.b() : comparator;
    }

    public static boolean b(Comparator<?> comparator, Iterable<?> iterable) {
        Comparator comparator2;
        com.bumptech.glide.repackaged.com.google.common.base.d.i(comparator);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = a((SortedSet) iterable);
        } else if (!(iterable instanceof e0)) {
            return false;
        } else {
            comparator2 = ((e0) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
