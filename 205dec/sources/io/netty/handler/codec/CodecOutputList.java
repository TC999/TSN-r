package io.netty.handler.codec;

import io.netty.util.Recycler;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
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

    /* renamed from: io.netty.handler.codec.CodecOutputList$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    static class AnonymousClass2 extends FastThreadLocal<CodecOutputLists> {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public CodecOutputLists initialValue() throws Exception {
            return new CodecOutputLists(16);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private interface CodecOutputListRecycler {
        void recycle(CodecOutputList codecOutputList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class CodecOutputLists implements CodecOutputListRecycler {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int count;
        private int currentIdx;
        private final CodecOutputList[] elements;
        private final int mask;

        CodecOutputLists(int i4) {
            this.elements = new CodecOutputList[MathUtil.safeFindNextPositivePowerOfTwo(i4)];
            int i5 = 0;
            while (true) {
                CodecOutputList[] codecOutputListArr = this.elements;
                if (i5 < codecOutputListArr.length) {
                    codecOutputListArr[i5] = new CodecOutputList(this, 16, null);
                    i5++;
                } else {
                    this.count = codecOutputListArr.length;
                    this.currentIdx = codecOutputListArr.length;
                    this.mask = codecOutputListArr.length - 1;
                    return;
                }
            }
        }

        public CodecOutputList getOrCreate() {
            int i4 = this.count;
            if (i4 == 0) {
                return new CodecOutputList(CodecOutputList.access$100(), 4, null);
            }
            this.count = i4 - 1;
            int i5 = (this.currentIdx - 1) & this.mask;
            CodecOutputList codecOutputList = this.elements[i5];
            this.currentIdx = i5;
            return codecOutputList;
        }

        @Override // io.netty.handler.codec.CodecOutputList.CodecOutputListRecycler
        public void recycle(CodecOutputList codecOutputList) {
            int i4 = this.currentIdx;
            this.elements[i4] = codecOutputList;
            this.currentIdx = this.mask & (i4 + 1);
            this.count++;
        }
    }

    private void checkIndex(int i4) {
        if (i4 >= this.size) {
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

    private void insert(int i4, Object obj) {
        this.array[i4] = obj;
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
    public Object get(int i4) {
        checkIndex(i4);
        return this.array[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getUnsafe(int i4) {
        return this.array[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean insertSinceRecycled() {
        return this.insertSinceRecycled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recycle() {
        for (int i4 = 0; i4 < this.size; i4++) {
            this.array[i4] = null;
        }
        clear();
        this.insertSinceRecycled = false;
        this.handle.recycle(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i4) {
        checkIndex(i4);
        Object[] objArr = this.array;
        Object obj = objArr[i4];
        int i5 = (this.size - i4) - 1;
        if (i5 > 0) {
            System.arraycopy(objArr, i4 + 1, objArr, i4, i5);
        }
        Object[] objArr2 = this.array;
        int i6 = this.size - 1;
        this.size = i6;
        objArr2[i6] = null;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i4, Object obj) {
        ObjectUtil.checkNotNull(obj, "element");
        checkIndex(i4);
        Object obj2 = this.array[i4];
        insert(i4, obj);
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
    public void add(int i4, Object obj) {
        ObjectUtil.checkNotNull(obj, "element");
        checkIndex(i4);
        if (this.size == this.array.length) {
            expandArray();
        }
        int i5 = this.size;
        if (i4 != i5 - 1) {
            Object[] objArr = this.array;
            System.arraycopy(objArr, i4, objArr, i4 + 1, i5 - i4);
        }
        insert(i4, obj);
        this.size++;
    }
}
