package com.bumptech.glide.repackaged.com.google.common.collect;

import java.io.Serializable;

/* compiled from: ReverseNaturalOrdering.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
final class z extends s<Comparable> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    static final z f17721a = new z();

    private z() {
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.s
    public <S extends Comparable> s<S> c() {
        return s.b();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.s, java.util.Comparator
    /* renamed from: d */
    public int compare(Comparable comparable, Comparable comparable2) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}
