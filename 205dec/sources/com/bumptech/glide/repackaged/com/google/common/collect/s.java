package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Comparator;

/* compiled from: Ordering.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public abstract class s<T> implements Comparator<T> {
    public static <T> s<T> a(Comparator<T> comparator) {
        return comparator instanceof s ? (s) comparator : new e(comparator);
    }

    public static <C extends Comparable> s<C> b() {
        return q.f17707a;
    }

    public <S extends T> s<S> c() {
        return new a0(this);
    }

    @Override // java.util.Comparator
    public abstract int compare(T t3, T t4);
}
