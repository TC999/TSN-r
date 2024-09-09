package com.google.zxing.common;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class BitMatrix implements Cloneable {
    private final int[] bits;
    private final int height;
    private final int rowSize;
    private final int width;

    public BitMatrix(int i4) {
        this(i4, i4);
    }

    private String buildToString(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.height * (this.width + 1));
        for (int i4 = 0; i4 < this.height; i4++) {
            for (int i5 = 0; i5 < this.width; i5++) {
                sb.append(get(i5, i4) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public static BitMatrix parse(String str, String str2, String str3) {
        if (str != null) {
            boolean[] zArr = new boolean[str.length()];
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = -1;
            int i8 = 0;
            while (i4 < str.length()) {
                if (str.charAt(i4) == '\n' || str.charAt(i4) == '\r') {
                    if (i5 > i6) {
                        if (i7 == -1) {
                            i7 = i5 - i6;
                        } else if (i5 - i6 != i7) {
                            throw new IllegalArgumentException("row lengths do not match");
                        }
                        i8++;
                        i6 = i5;
                    }
                    i4++;
                } else {
                    if (str.substring(i4, str2.length() + i4).equals(str2)) {
                        i4 += str2.length();
                        zArr[i5] = true;
                    } else if (str.substring(i4, str3.length() + i4).equals(str3)) {
                        i4 += str3.length();
                        zArr[i5] = false;
                    } else {
                        throw new IllegalArgumentException("illegal character encountered: " + str.substring(i4));
                    }
                    i5++;
                }
            }
            if (i5 > i6) {
                if (i7 == -1) {
                    i7 = i5 - i6;
                } else if (i5 - i6 != i7) {
                    throw new IllegalArgumentException("row lengths do not match");
                }
                i8++;
            }
            BitMatrix bitMatrix = new BitMatrix(i7, i8);
            for (int i9 = 0; i9 < i5; i9++) {
                if (zArr[i9]) {
                    bitMatrix.set(i9 % i7, i9 / i7);
                }
            }
            return bitMatrix;
        }
        throw new IllegalArgumentException();
    }

    public void clear() {
        int length = this.bits.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.bits[i4] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof BitMatrix) {
            BitMatrix bitMatrix = (BitMatrix) obj;
            return this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && Arrays.equals(this.bits, bitMatrix.bits);
        }
        return false;
    }

    public void flip(int i4, int i5) {
        int i6 = (i5 * this.rowSize) + (i4 / 32);
        int[] iArr = this.bits;
        iArr[i6] = (1 << (i4 & 31)) ^ iArr[i6];
    }

    public boolean get(int i4, int i5) {
        return ((this.bits[(i5 * this.rowSize) + (i4 / 32)] >>> (i4 & 31)) & 1) != 0;
    }

    public int[] getBottomRightOnBit() {
        int length = this.bits.length - 1;
        while (length >= 0 && this.bits[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i4 = this.rowSize;
        int i5 = length / i4;
        int i6 = (length % i4) << 5;
        int i7 = 31;
        while ((this.bits[length] >>> i7) == 0) {
            i7--;
        }
        return new int[]{i6 + i7, i5};
    }

    public int[] getEnclosingRectangle() {
        int i4 = this.width;
        int i5 = this.height;
        int i6 = -1;
        int i7 = -1;
        for (int i8 = 0; i8 < this.height; i8++) {
            int i9 = 0;
            while (true) {
                int i10 = this.rowSize;
                if (i9 < i10) {
                    int i11 = this.bits[(i10 * i8) + i9];
                    if (i11 != 0) {
                        if (i8 < i5) {
                            i5 = i8;
                        }
                        if (i8 > i7) {
                            i7 = i8;
                        }
                        int i12 = i9 << 5;
                        if (i12 < i4) {
                            int i13 = 0;
                            while ((i11 << (31 - i13)) == 0) {
                                i13++;
                            }
                            int i14 = i13 + i12;
                            if (i14 < i4) {
                                i4 = i14;
                            }
                        }
                        if (i12 + 31 > i6) {
                            int i15 = 31;
                            while ((i11 >>> i15) == 0) {
                                i15--;
                            }
                            int i16 = i12 + i15;
                            if (i16 > i6) {
                                i6 = i16;
                            }
                        }
                    }
                    i9++;
                }
            }
        }
        if (i6 < i4 || i7 < i5) {
            return null;
        }
        return new int[]{i4, i5, (i6 - i4) + 1, (i7 - i5) + 1};
    }

    public int getHeight() {
        return this.height;
    }

    public BitArray getRow(int i4, BitArray bitArray) {
        if (bitArray != null && bitArray.getSize() >= this.width) {
            bitArray.clear();
        } else {
            bitArray = new BitArray(this.width);
        }
        int i5 = i4 * this.rowSize;
        for (int i6 = 0; i6 < this.rowSize; i6++) {
            bitArray.setBulk(i6 << 5, this.bits[i5 + i6]);
        }
        return bitArray;
    }

    public int getRowSize() {
        return this.rowSize;
    }

    public int[] getTopLeftOnBit() {
        int[] iArr;
        int i4 = 0;
        while (true) {
            iArr = this.bits;
            if (i4 >= iArr.length || iArr[i4] != 0) {
                break;
            }
            i4++;
        }
        if (i4 == iArr.length) {
            return null;
        }
        int i5 = this.rowSize;
        int i6 = i4 / i5;
        int i7 = (i4 % i5) << 5;
        int i8 = iArr[i4];
        int i9 = 0;
        while ((i8 << (31 - i9)) == 0) {
            i9++;
        }
        return new int[]{i7 + i9, i6};
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i4 = this.width;
        return (((((((i4 * 31) + i4) * 31) + this.height) * 31) + this.rowSize) * 31) + Arrays.hashCode(this.bits);
    }

    public void rotate180() {
        int width = getWidth();
        int height = getHeight();
        BitArray bitArray = new BitArray(width);
        BitArray bitArray2 = new BitArray(width);
        for (int i4 = 0; i4 < (height + 1) / 2; i4++) {
            bitArray = getRow(i4, bitArray);
            int i5 = (height - 1) - i4;
            bitArray2 = getRow(i5, bitArray2);
            bitArray.reverse();
            bitArray2.reverse();
            setRow(i4, bitArray2);
            setRow(i5, bitArray);
        }
    }

    public void set(int i4, int i5) {
        int i6 = (i5 * this.rowSize) + (i4 / 32);
        int[] iArr = this.bits;
        iArr[i6] = (1 << (i4 & 31)) | iArr[i6];
    }

    public void setRegion(int i4, int i5, int i6, int i7) {
        if (i5 < 0 || i4 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i7 > 0 && i6 > 0) {
            int i8 = i6 + i4;
            int i9 = i7 + i5;
            if (i9 > this.height || i8 > this.width) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i5 < i9) {
                int i10 = this.rowSize * i5;
                for (int i11 = i4; i11 < i8; i11++) {
                    int[] iArr = this.bits;
                    int i12 = (i11 / 32) + i10;
                    iArr[i12] = iArr[i12] | (1 << (i11 & 31));
                }
                i5++;
            }
            return;
        }
        throw new IllegalArgumentException("Height and width must be at least 1");
    }

    public void setRow(int i4, BitArray bitArray) {
        int[] bitArray2 = bitArray.getBitArray();
        int[] iArr = this.bits;
        int i5 = this.rowSize;
        System.arraycopy(bitArray2, 0, iArr, i4 * i5, i5);
    }

    public String toString() {
        return toString("X ", "  ");
    }

    public void unset(int i4, int i5) {
        int i6 = (i5 * this.rowSize) + (i4 / 32);
        int[] iArr = this.bits;
        iArr[i6] = ((1 << (i4 & 31)) ^ (-1)) & iArr[i6];
    }

    public void xor(BitMatrix bitMatrix) {
        if (this.width == bitMatrix.getWidth() && this.height == bitMatrix.getHeight() && this.rowSize == bitMatrix.getRowSize()) {
            BitArray bitArray = new BitArray((this.width / 32) + 1);
            for (int i4 = 0; i4 < this.height; i4++) {
                int i5 = this.rowSize * i4;
                int[] bitArray2 = bitMatrix.getRow(i4, bitArray).getBitArray();
                for (int i6 = 0; i6 < this.rowSize; i6++) {
                    int[] iArr = this.bits;
                    int i7 = i5 + i6;
                    iArr[i7] = iArr[i7] ^ bitArray2[i6];
                }
            }
            return;
        }
        throw new IllegalArgumentException("input matrix dimensions do not match");
    }

    public BitMatrix(int i4, int i5) {
        if (i4 > 0 && i5 > 0) {
            this.width = i4;
            this.height = i5;
            int i6 = (i4 + 31) / 32;
            this.rowSize = i6;
            this.bits = new int[i6 * i5];
            return;
        }
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    /* renamed from: clone */
    public BitMatrix m88clone() {
        return new BitMatrix(this.width, this.height, this.rowSize, (int[]) this.bits.clone());
    }

    public String toString(String str, String str2) {
        return buildToString(str, str2, "\n");
    }

    @Deprecated
    public String toString(String str, String str2, String str3) {
        return buildToString(str, str2, str3);
    }

    private BitMatrix(int i4, int i5, int i6, int[] iArr) {
        this.width = i4;
        this.height = i5;
        this.rowSize = i6;
        this.bits = iArr;
    }
}
