package com.bumptech.glide.repackaged.com.google.common.collect;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImmutableAsList.java */
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public abstract class i<E> extends ImmutableList<E> {
    abstract ImmutableCollection<E> a();

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return a().contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return a().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return a().isPartialView();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return a().size();
    }
}
