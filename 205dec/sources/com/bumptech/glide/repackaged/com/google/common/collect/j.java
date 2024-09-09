package com.bumptech.glide.repackaged.com.google.common.collect;

import java.lang.Enum;
import java.util.Collection;
import java.util.EnumSet;

/* compiled from: ImmutableEnumSet.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
final class j<E extends Enum<E>> extends ImmutableSet<E> {

    /* renamed from: a  reason: collision with root package name */
    private final transient EnumSet<E> f17682a;

    /* renamed from: b  reason: collision with root package name */
    private transient int f17683b;

    private j(EnumSet<E> enumSet) {
        this.f17682a = enumSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ImmutableSet a(EnumSet enumSet) {
        int size = enumSet.size();
        if (size != 0) {
            if (size != 1) {
                return new j(enumSet);
            }
            return ImmutableSet.of(m.d(enumSet));
        }
        return ImmutableSet.of();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f17682a.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof j) {
            collection = ((j) collection).f17682a;
        }
        return this.f17682a.containsAll(collection);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            obj = ((j) obj).f17682a;
        }
        return this.f17682a.equals(obj);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        int i4 = this.f17683b;
        if (i4 == 0) {
            int hashCode = this.f17682a.hashCode();
            this.f17683b = hashCode;
            return hashCode;
        }
        return i4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f17682a.isEmpty();
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
        return this.f17682a.size();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return this.f17682a.toString();
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public i0<E> iterator() {
        return n.p(this.f17682a.iterator());
    }
}
