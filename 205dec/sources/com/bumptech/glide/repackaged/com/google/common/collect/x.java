package com.bumptech.glide.repackaged.com.google.common.collect;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableSet.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class x<E> extends ImmutableSet<E> {

    /* renamed from: e  reason: collision with root package name */
    static final x<Object> f17715e = new x<>(r.f17708a, 0, null, 0);

    /* renamed from: a  reason: collision with root package name */
    private final transient Object[] f17716a;

    /* renamed from: b  reason: collision with root package name */
    final transient Object[] f17717b;

    /* renamed from: c  reason: collision with root package name */
    private final transient int f17718c;

    /* renamed from: d  reason: collision with root package name */
    private final transient int f17719d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Object[] objArr, int i4, Object[] objArr2, int i5) {
        this.f17716a = objArr;
        this.f17717b = objArr2;
        this.f17718c = i5;
        this.f17719d = i4;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        Object[] objArr = this.f17717b;
        if (obj == null || objArr == null) {
            return false;
        }
        int b4 = h.b(obj);
        while (true) {
            int i4 = b4 & this.f17718c;
            Object obj2 = objArr[i4];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            b4 = i4 + 1;
        }
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] objArr, int i4) {
        Object[] objArr2 = this.f17716a;
        System.arraycopy(objArr2, 0, objArr, i4, objArr2.length);
        return i4 + this.f17716a.length;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    ImmutableList<E> createAsList() {
        return this.f17717b == null ? ImmutableList.of() : new v(this, this.f17716a);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f17719d;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet
    boolean isHashCodeFast() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f17716a.length;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public i0<E> iterator() {
        return n.g(this.f17716a);
    }
}
