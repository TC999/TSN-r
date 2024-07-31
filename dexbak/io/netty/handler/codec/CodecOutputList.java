package io.netty.handler.codec;

import io.netty.util.Recycler;
import io.netty.util.internal.ObjectUtil;
import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class CodecOutputList extends AbstractList<Object> implements RandomAccess {
    private static final Recycler<CodecOutputList> RECYCLER = new Recycler<CodecOutputList>() { // from class: io.netty.handler.codec.CodecOutputList.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.Recycler
        public CodecOutputList newObject(Recycler.Handle<CodecOutputList> handle) {
            return new CodecOutputList(handle);
        }
    };
    private Object[] array;
    private final Recycler.Handle<CodecOutputList> handle;
    private boolean insertSinceRecycled;
    private int size;

    private void checkIndex(int i) {
        if (i >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void expandArray() {
        Object[] objArr = this.array;
        int length = objArr.length << 1;
        if (length >= 0) {
            Object[] objArr2 = new Object[length];
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
            this.array = objArr2;
            return;
        }
        throw new OutOfMemoryError();
    }

    private void insert(int i, Object obj) {
        this.array[i] = obj;
        this.insertSinceRecycled = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CodecOutputList newInstance() {
        return RECYCLER.get();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        ObjectUtil.checkNotNull(obj, "element");
        try {
            insert(this.size, obj);
        } catch (IndexOutOfBoundsException unused) {
            expandArray();
            insert(this.size, obj);
        }
        this.size++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.size = 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        checkIndex(i);
        return this.array[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getUnsafe(int i) {
        return this.array[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean insertSinceRecycled() {
        return this.insertSinceRecycled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recycle() {
        for (int i = 0; i < this.size; i++) {
            this.array[i] = null;
        }
        clear();
        this.insertSinceRecycled = false;
        this.handle.recycle(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i) {
        checkIndex(i);
        Object[] objArr = this.array;
        Object obj = objArr[i];
        int i2 = (this.size - i) - 1;
        if (i2 > 0) {
            System.arraycopy(objArr, i + 1, objArr, i, i2);
        }
        Object[] objArr2 = this.array;
        int i3 = this.size - 1;
        this.size = i3;
        objArr2[i3] = null;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        ObjectUtil.checkNotNull(obj, "element");
        checkIndex(i);
        Object obj2 = this.array[i];
        insert(i, obj);
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private CodecOutputList(Recycler.Handle<CodecOutputList> handle) {
        this.array = new Object[16];
        this.handle = handle;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        ObjectUtil.checkNotNull(obj, "element");
        checkIndex(i);
        if (this.size == this.array.length) {
            expandArray();
        }
        int i2 = this.size;
        if (i != i2 - 1) {
            Object[] objArr = this.array;
            System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
        }
        insert(i, obj);
        this.size++;
    }
}
