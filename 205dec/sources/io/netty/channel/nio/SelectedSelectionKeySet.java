package io.netty.channel.nio;

import java.nio.channels.SelectionKey;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class SelectedSelectionKeySet extends AbstractSet<SelectionKey> {
    private boolean isA = true;
    private SelectionKey[] keysA;
    private int keysASize;
    private SelectionKey[] keysB;
    private int keysBSize;

    /* renamed from: io.netty.channel.nio.SelectedSelectionKeySet$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    class AnonymousClass1 implements Iterator<SelectionKey> {
        private int idx;

        AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.idx < SelectedSelectionKeySet.this.size;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public SelectionKey next() {
            if (hasNext()) {
                SelectionKey[] selectionKeyArr = SelectedSelectionKeySet.this.keys;
                int i4 = this.idx;
                this.idx = i4 + 1;
                return selectionKeyArr[i4];
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SelectedSelectionKeySet() {
        SelectionKey[] selectionKeyArr = new SelectionKey[1024];
        this.keysA = selectionKeyArr;
        this.keysB = (SelectionKey[]) selectionKeyArr.clone();
    }

    private void doubleCapacityA() {
        SelectionKey[] selectionKeyArr = this.keysA;
        SelectionKey[] selectionKeyArr2 = new SelectionKey[selectionKeyArr.length << 1];
        System.arraycopy(selectionKeyArr, 0, selectionKeyArr2, 0, this.keysASize);
        this.keysA = selectionKeyArr2;
    }

    private void doubleCapacityB() {
        SelectionKey[] selectionKeyArr = this.keysB;
        SelectionKey[] selectionKeyArr2 = new SelectionKey[selectionKeyArr.length << 1];
        System.arraycopy(selectionKeyArr, 0, selectionKeyArr2, 0, this.keysBSize);
        this.keysB = selectionKeyArr2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SelectionKey[] flip() {
        if (this.isA) {
            this.isA = false;
            SelectionKey[] selectionKeyArr = this.keysA;
            selectionKeyArr[this.keysASize] = null;
            this.keysBSize = 0;
            return selectionKeyArr;
        }
        this.isA = true;
        SelectionKey[] selectionKeyArr2 = this.keysB;
        selectionKeyArr2[this.keysBSize] = null;
        this.keysASize = 0;
        return selectionKeyArr2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<SelectionKey> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        if (this.isA) {
            return this.keysASize;
        }
        return this.keysBSize;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(SelectionKey selectionKey) {
        if (selectionKey == null) {
            return false;
        }
        if (this.isA) {
            int i4 = this.keysASize;
            SelectionKey[] selectionKeyArr = this.keysA;
            int i5 = i4 + 1;
            selectionKeyArr[i4] = selectionKey;
            this.keysASize = i5;
            if (i5 == selectionKeyArr.length) {
                doubleCapacityA();
                return true;
            }
            return true;
        }
        int i6 = this.keysBSize;
        SelectionKey[] selectionKeyArr2 = this.keysB;
        int i7 = i6 + 1;
        selectionKeyArr2[i6] = selectionKey;
        this.keysBSize = i7;
        if (i7 == selectionKeyArr2.length) {
            doubleCapacityB();
            return true;
        }
        return true;
    }
}
