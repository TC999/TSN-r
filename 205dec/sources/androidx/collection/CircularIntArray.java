package androidx.collection;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class CircularIntArray {
    private int mCapacityBitmask;
    private int[] mElements;
    private int mHead;
    private int mTail;

    public CircularIntArray() {
        this(8);
    }

    private void doubleCapacity() {
        int[] iArr = this.mElements;
        int length = iArr.length;
        int i4 = this.mHead;
        int i5 = length - i4;
        int i6 = length << 1;
        if (i6 >= 0) {
            int[] iArr2 = new int[i6];
            System.arraycopy(iArr, i4, iArr2, 0, i5);
            System.arraycopy(this.mElements, 0, iArr2, i5, this.mHead);
            this.mElements = iArr2;
            this.mHead = 0;
            this.mTail = length;
            this.mCapacityBitmask = i6 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void addFirst(int i4) {
        int i5 = (this.mHead - 1) & this.mCapacityBitmask;
        this.mHead = i5;
        this.mElements[i5] = i4;
        if (i5 == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(int i4) {
        int[] iArr = this.mElements;
        int i5 = this.mTail;
        iArr[i5] = i4;
        int i6 = this.mCapacityBitmask & (i5 + 1);
        this.mTail = i6;
        if (i6 == this.mHead) {
            doubleCapacity();
        }
    }

    public void clear() {
        this.mTail = this.mHead;
    }

    public int get(int i4) {
        if (i4 >= 0 && i4 < size()) {
            return this.mElements[this.mCapacityBitmask & (this.mHead + i4)];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getFirst() {
        int i4 = this.mHead;
        if (i4 != this.mTail) {
            return this.mElements[i4];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getLast() {
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

    public int popFirst() {
        int i4 = this.mHead;
        if (i4 != this.mTail) {
            int i5 = this.mElements[i4];
            this.mHead = (i4 + 1) & this.mCapacityBitmask;
            return i5;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int popLast() {
        int i4 = this.mHead;
        int i5 = this.mTail;
        if (i4 != i5) {
            int i6 = this.mCapacityBitmask & (i5 - 1);
            int i7 = this.mElements[i6];
            this.mTail = i6;
            return i7;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int i4) {
        if (i4 <= 0) {
            return;
        }
        if (i4 <= size()) {
            this.mTail = this.mCapacityBitmask & (this.mTail - i4);
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int i4) {
        if (i4 <= 0) {
            return;
        }
        if (i4 <= size()) {
            this.mHead = this.mCapacityBitmask & (this.mHead + i4);
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }

    public CircularIntArray(int i4) {
        if (i4 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i4 <= 1073741824) {
            i4 = Integer.bitCount(i4) != 1 ? Integer.highestOneBit(i4 - 1) << 1 : i4;
            this.mCapacityBitmask = i4 - 1;
            this.mElements = new int[i4];
            return;
        }
        throw new IllegalArgumentException("capacity must be <= 2^30");
    }
}
