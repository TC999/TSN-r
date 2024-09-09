package androidx.collection;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class CircularArray<E> {
    private int mCapacityBitmask;
    private E[] mElements;
    private int mHead;
    private int mTail;

    public CircularArray() {
        this(8);
    }

    private void doubleCapacity() {
        E[] eArr = this.mElements;
        int length = eArr.length;
        int i4 = this.mHead;
        int i5 = length - i4;
        int i6 = length << 1;
        if (i6 >= 0) {
            E[] eArr2 = (E[]) new Object[i6];
            System.arraycopy(eArr, i4, eArr2, 0, i5);
            System.arraycopy(this.mElements, 0, eArr2, i5, this.mHead);
            this.mElements = eArr2;
            this.mHead = 0;
            this.mTail = length;
            this.mCapacityBitmask = i6 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void addFirst(E e4) {
        int i4 = (this.mHead - 1) & this.mCapacityBitmask;
        this.mHead = i4;
        this.mElements[i4] = e4;
        if (i4 == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(E e4) {
        E[] eArr = this.mElements;
        int i4 = this.mTail;
        eArr[i4] = e4;
        int i5 = this.mCapacityBitmask & (i4 + 1);
        this.mTail = i5;
        if (i5 == this.mHead) {
            doubleCapacity();
        }
    }

    public void clear() {
        removeFromStart(size());
    }

    public E get(int i4) {
        if (i4 >= 0 && i4 < size()) {
            return this.mElements[this.mCapacityBitmask & (this.mHead + i4)];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getFirst() {
        int i4 = this.mHead;
        if (i4 != this.mTail) {
            return this.mElements[i4];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getLast() {
        int i4 = this.mHead;
        int i5 = this.mTail;
        if (i4 != i5) {
            return this.mElements[(i5 - 1) & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return this.mHead == this.mTail;
    }

    public E popFirst() {
        int i4 = this.mHead;
        if (i4 != this.mTail) {
            E[] eArr = this.mElements;
            E e4 = eArr[i4];
            eArr[i4] = null;
            this.mHead = (i4 + 1) & this.mCapacityBitmask;
            return e4;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E popLast() {
        int i4 = this.mHead;
        int i5 = this.mTail;
        if (i4 != i5) {
            int i6 = this.mCapacityBitmask & (i5 - 1);
            E[] eArr = this.mElements;
            E e4 = eArr[i6];
            eArr[i6] = null;
            this.mTail = i6;
            return e4;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int i4) {
        int i5;
        if (i4 <= 0) {
            return;
        }
        if (i4 <= size()) {
            int i6 = this.mTail;
            int i7 = i4 < i6 ? i6 - i4 : 0;
            int i8 = i7;
            while (true) {
                i5 = this.mTail;
                if (i8 >= i5) {
                    break;
                }
                this.mElements[i8] = null;
                i8++;
            }
            int i9 = i5 - i7;
            int i10 = i4 - i9;
            this.mTail = i5 - i9;
            if (i10 > 0) {
                int length = this.mElements.length;
                this.mTail = length;
                int i11 = length - i10;
                for (int i12 = i11; i12 < this.mTail; i12++) {
                    this.mElements[i12] = null;
                }
                this.mTail = i11;
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int i4) {
        if (i4 <= 0) {
            return;
        }
        if (i4 <= size()) {
            int length = this.mElements.length;
            int i5 = this.mHead;
            if (i4 < length - i5) {
                length = i5 + i4;
            }
            while (i5 < length) {
                this.mElements[i5] = null;
                i5++;
            }
            int i6 = this.mHead;
            int i7 = length - i6;
            int i8 = i4 - i7;
            this.mHead = this.mCapacityBitmask & (i6 + i7);
            if (i8 > 0) {
                for (int i9 = 0; i9 < i8; i9++) {
                    this.mElements[i9] = null;
                }
                this.mHead = i8;
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }

    public CircularArray(int i4) {
        if (i4 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i4 <= 1073741824) {
            i4 = Integer.bitCount(i4) != 1 ? Integer.highestOneBit(i4 - 1) << 1 : i4;
            this.mCapacityBitmask = i4 - 1;
            this.mElements = (E[]) new Object[i4];
            return;
        }
        throw new IllegalArgumentException("capacity must be <= 2^30");
    }
}
