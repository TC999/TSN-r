package com.bumptech.glide.repackaged.com.google.common.collect;

import java.io.Serializable;

/* compiled from: ReverseOrdering.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
final class a0<T> extends s<T> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    final s<? super T> f17663a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(s<? super T> sVar) {
        this.f17663a = (s) com.bumptech.glide.repackaged.com.google.common.base.d.i(sVar);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.s
    public <S extends T> s<S> c() {
        return (s<? super T>) this.f17663a;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.s, java.util.Comparator
    public int compare(T t3, T t4) {
        return this.f17663a.compare(t4, t3);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a0) {
            return this.f17663a.equals(((a0) obj).f17663a);
        }
        return false;
    }

    public int hashCode() {
        return -this.f17663a.hashCode();
    }

    public String toString() {
        return this.f17663a + ".reverse()";
    }
}
