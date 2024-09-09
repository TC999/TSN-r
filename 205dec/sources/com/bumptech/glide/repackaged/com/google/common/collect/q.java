package com.bumptech.glide.repackaged.com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NaturalOrdering.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class q extends s<Comparable> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    static final q f17707a = new q();

    private q() {
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.s
    public <S extends Comparable> s<S> c() {
        return z.f17721a;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.s, java.util.Comparator
    /* renamed from: d */
    public int compare(Comparable comparable, Comparable comparable2) {
        com.bumptech.glide.repackaged.com.google.common.base.d.i(comparable);
        com.bumptech.glide.repackaged.com.google.common.base.d.i(comparable2);
        return comparable.compareTo(comparable2);
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
