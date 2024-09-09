package com.bumptech.glide.repackaged.com.google.common.collect;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableList.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public class w<E> extends ImmutableList<E> {

    /* renamed from: d  reason: collision with root package name */
    static final ImmutableList<Object> f17711d = new w(r.f17708a);

    /* renamed from: a  reason: collision with root package name */
    private final transient int f17712a;

    /* renamed from: b  reason: collision with root package name */
    private final transient int f17713b;

    /* renamed from: c  reason: collision with root package name */
    private final transient Object[] f17714c;

    w(Object[] objArr, int i4, int i5) {
        this.f17712a = i4;
        this.f17713b = i5;
        this.f17714c = objArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i4) {
        System.arraycopy(this.f17714c, this.f17712a, objArr, i4, this.f17713b);
        return i4 + this.f17713b;
    }

    @Override // java.util.List
    public E get(int i4) {
        com.bumptech.glide.repackaged.com.google.common.base.d.g(i4, this.f17713b);
        return (E) this.f17714c[i4 + this.f17712a];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f17713b != this.f17714c.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f17713b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList
    public ImmutableList<E> subListUnchecked(int i4, int i5) {
        return new w(this.f17714c, this.f17712a + i4, i5 - i4);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
    public j0<E> listIterator(int i4) {
        return n.h(this.f17714c, this.f17712a, this.f17713b, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(Object[] objArr) {
        this(objArr, 0, objArr.length);
    }
}
