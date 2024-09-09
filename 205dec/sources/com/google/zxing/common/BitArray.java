package com.google.zxing.common;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class BitArray implements Cloneable {
    private int[] bits;
    private int size;

    public BitArray() {
        this.size = 0;
        this.bits = new int[1];
    }

    private void ensureCapacity(int i4) {
        if (i4 > (this.bits.length << 5)) {
            int[] makeArray = makeArray(i4);
            int[] iArr = this.bits;
            System.arraycopy(iArr, 0, makeArray, 0, iArr.length);
            this.bits = makeArray;
        }
    }

    private static int[] makeArray(int i4) {
        return new int[(i4 + 31) / 32];
    }

    public void appendBit(boolean z3) {
        ensureCapacity(this.size + 1);
        if (z3) {
            int[] iArr = this.bits;
            int i4 = this.size;
            int i5 = i4 / 32;
            iArr[i5] = (1 << (i4 & 31)) | iArr[i5];
        }
        this.size++;
    }

    public void appendBitArray(BitArray bitArray) {
        int i4 = bitArray.size;
        ensureCapacity(this.size + i4);
        for (int i5 = 0; i5 < i4; i5++) {
            appendBit(bitArray.get(i5));
        }
    }

    public void appendBits(int i4, int i5) {
        if (i5 >= 0 && i5 <= 32) {
            ensureCapacity(this.size + i5);
            while (i5 > 0) {
                boolean z3 = true;
                if (((i4 >> (i5 - 1)) & 1) != 1) {
                    z3 = false;
                }
                appendBit(z3);
                i5--;
            }
            return;
        }
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    public void clear() {
        int length = this.bits.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.bits[i4] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof BitArray) {
            BitArray bitArray = (BitArray) obj;
            return this.size == bitArray.size && Arrays.equals(this.bits, bitArray.bits);
        }
        return false;
    }

    public void flip(int i4) {
        int[] iArr = this.bits;
        int i5 = i4 / 32;
        iArr[i5] = (1 << (i4 & 31)) ^ iArr[i5];
    }

    public boolean get(int i4) {
        return ((1 << (i4 & 31)) & this.bits[i4 / 32]) != 0;
    }

    public int[] getBitArray() {
        return this.bits;
    }

    public int getNextSet(int i4) {
        int i5 = this.size;
        if (i4 >= i5) {
            return i5;
        }
        int i6 = i4 / 32;
        int i7 = (((1 << (i4 & 31)) - 1) ^ (-1)) & this.bits[i6];
        while (i7 == 0) {
            i6++;
            int[] iArr = this.bits;
            if (i6 == iArr.length) {
                return this.size;
            }
            i7 = iArr[i6];
        }
        int numberOfTrailingZeros = (i6 << 5) + Integer.numberOfTrailingZeros(i7);
        int i8 = this.size;
        return numberOfTrailingZeros > i8 ? i8 : numberOfTrailingZeros;
    }

    public int getNextUnset(int i4) {
        int i5 = this.size;
        if (i4 >= i5) {
            return i5;
        }
        int i6 = i4 / 32;
        int i7 = (((1 << (i4 & 31)) - 1) ^ (-1)) & (this.bits[i6] ^ (-1));
        while (i7 == 0) {
            i6++;
            int[] iArr = this.bits;
            if (i6 == iArr.length) {
                return this.size;
            }
            i7 = iArr[i6] ^ (-1);
        }
        int numberOfTrailingZeros = (i6 << 5) + Integer.numberOfTrailingZeros(i7);
        int i8 = this.size;
        return numberOfTrailingZeros > i8 ? i8 : numberOfTrailingZeros;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeInBytes() {
        return (this.size + 7) / 8;
    }

    public int hashCode() {
        return (this.size * 31) + Arrays.hashCode(this.bits);
    }

    public boolean isRange(int i4, int i5, boolean z3) {
        if (i5 < i4 || i4 < 0 || i5 > this.size) {
            throw new IllegalArgumentException();
        }
        if (i5 == i4) {
            return true;
        }
        int i6 = i5 - 1;
        int i7 = i4 / 32;
        int i8 = i6 / 32;
        int i9 = i7;
        while (i9 <= i8) {
            int i10 = (2 << (i9 >= i8 ? 31 & i6 : 31)) - (1 << (i9 > i7 ? 0 : i4 & 31));
            int i11 = this.bits[i9] & i10;
            if (!z3) {
                i10 = 0;
            }
            if (i11 != i10) {
                return false;
            }
            i9++;
        }
        return true;
    }

    public void reverse() {
        int[] iArr = new int[this.bits.length];
        int i4 = (this.size - 1) / 32;
        int i5 = i4 + 1;
        for (int i6 = 0; i6 < i5; i6++) {
            long j4 = this.bits[i6];
            long j5 = ((j4 & 1431655765) << 1) | ((j4 >> 1) & 1431655765);
            long j6 = ((j5 & 858993459) << 2) | ((j5 >> 2) & 858993459);
            long j7 = ((j6 & 252645135) << 4) | ((j6 >> 4) & 252645135);
            long j8 = ((j7 & 16711935) << 8) | ((j7 >> 8) & 16711935);
            iArr[i4 - i6] = (int) (((j8 & 65535) << 16) | ((j8 >> 16) & 65535));
        }
        int i7 = this.size;
        int i8 = i5 << 5;
        if (i7 != i8) {
            int i9 = i8 - i7;
            int i10 = iArr[0] >>> i9;
            for (int i11 = 1; i11 < i5; i11++) {
                int i12 = iArr[i11];
                iArr[i11 - 1] = i10 | (i12 << (32 - i9));
                i10 = i12 >>> i9;
            }
            iArr[i5 - 1] = i10;
        }
        this.bits = iArr;
    }

    public void set(int i4) {
        int[] iArr = this.bits;
        int i5 = i4 / 32;
        iArr[i5] = (1 << (i4 & 31)) | iArr[i5];
    }

    public void setBulk(int i4, int i5) {
        this.bits[i4 / 32] = i5;
    }

    public void setRange(int i4, int i5) {
        if (i5 < i4 || i4 < 0 || i5 > this.size) {
            throw new IllegalArgumentException();
        }
        if (i5 == i4) {
            return;
        }
        int i6 = i5 - 1;
        int i7 = i4 / 32;
        int i8 = i6 / 32;
        int i9 = i7;
        while (i9 <= i8) {
            int i10 = 31;
            int i11 = i9 > i7 ? 0 : i4 & 31;
            if (i9 >= i8) {
                i10 = 31 & i6;
            }
            int i12 = (2 << i10) - (1 << i11);
            int[] iArr = this.bits;
            iArr[i9] = i12 | iArr[i9];
            i9++;
        }
    }

    public void toBytes(int i4, byte[] bArr, int i5, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < 8; i9++) {
                if (get(i4)) {
                    i8 |= 1 << (7 - i9);
                }
                i4++;
            }
            bArr[i5 + i7] = (byte) i8;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.size);
        for (int i4 = 0; i4 < this.size; i4++) {
            if ((i4 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(get(i4) ? 'X' : '.');
        }
        return sb.toString();
    }

    public void xor(BitArray bitArray) {
        if (this.size != bitArray.size) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i4 = 0;
        while (true) {
            int[] iArr = this.bits;
            if (i4 >= iArr.length) {
                return;
            }
            iArr[i4] = iArr[i4] ^ bitArray.bits[i4];
            i4++;
        }
    }

    /* renamed from: clone */
    public BitArray m87clone() {
        return new BitArray((int[]) this.bits.clone(), this.size);
    }

    public BitArray(int i4) {
        this.size = i4;
        this.bits = makeArray(i4);
    }

    BitArray(int[] iArr, int i4) {
        this.bits = iArr;
        this.size = i4;
    }
}
