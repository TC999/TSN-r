package com.bumptech.glide.repackaged.com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComparatorOrdering.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class e<T> extends s<T> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    final Comparator<T> f17676a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Comparator<T> comparator) {
        this.f17676a = (Comparator) com.bumptech.glide.repackaged.com.google.common.base.d.i(comparator);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.s, java.util.Comparator
    public int compare(T t3, T t4) {
        return this.f17676a.compare(t3, t4);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            return this.f17676a.equals(((e) obj).f17676a);
        }
        return false;
    }

    public int hashCode() {
        return this.f17676a.hashCode();
    }

    public String toString() {
        return this.f17676a.toString();
    }
}
