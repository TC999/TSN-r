package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class DefaultPlacement {
    private final byte[] bits;
    private final CharSequence codewords;
    private final int numcols;
    private final int numrows;

    public DefaultPlacement(CharSequence charSequence, int i4, int i5) {
        this.codewords = charSequence;
        this.numcols = i4;
        this.numrows = i5;
        byte[] bArr = new byte[i4 * i5];
        this.bits = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    private void corner1(int i4) {
        module(this.numrows - 1, 0, i4, 1);
        module(this.numrows - 1, 1, i4, 2);
        module(this.numrows - 1, 2, i4, 3);
        module(0, this.numcols - 2, i4, 4);
        module(0, this.numcols - 1, i4, 5);
        module(1, this.numcols - 1, i4, 6);
        module(2, this.numcols - 1, i4, 7);
        module(3, this.numcols - 1, i4, 8);
    }

    private void corner2(int i4) {
        module(this.numrows - 3, 0, i4, 1);
        module(this.numrows - 2, 0, i4, 2);
        module(this.numrows - 1, 0, i4, 3);
        module(0, this.numcols - 4, i4, 4);
        module(0, this.numcols - 3, i4, 5);
        module(0, this.numcols - 2, i4, 6);
        module(0, this.numcols - 1, i4, 7);
        module(1, this.numcols - 1, i4, 8);
    }

    private void corner3(int i4) {
        module(this.numrows - 3, 0, i4, 1);
        module(this.numrows - 2, 0, i4, 2);
        module(this.numrows - 1, 0, i4, 3);
        module(0, this.numcols - 2, i4, 4);
        module(0, this.numcols - 1, i4, 5);
        module(1, this.numcols - 1, i4, 6);
        module(2, this.numcols - 1, i4, 7);
        module(3, this.numcols - 1, i4, 8);
    }

    private void corner4(int i4) {
        module(this.numrows - 1, 0, i4, 1);
        module(this.numrows - 1, this.numcols - 1, i4, 2);
        module(0, this.numcols - 3, i4, 3);
        module(0, this.numcols - 2, i4, 4);
        module(0, this.numcols - 1, i4, 5);
        module(1, this.numcols - 3, i4, 6);
        module(1, this.numcols - 2, i4, 7);
        module(1, this.numcols - 1, i4, 8);
    }

    private boolean hasBit(int i4, int i5) {
        return this.bits[(i5 * this.numcols) + i4] >= 0;
    }

    private void module(int i4, int i5, int i6, int i7) {
        if (i4 < 0) {
            int i8 = this.numrows;
            i4 += i8;
            i5 += 4 - ((i8 + 4) % 8);
        }
        if (i5 < 0) {
            int i9 = this.numcols;
            i5 += i9;
            i4 += 4 - ((i9 + 4) % 8);
        }
        setBit(i5, i4, (this.codewords.charAt(i6) & (1 << (8 - i7))) != 0);
    }

    private void setBit(int i4, int i5, boolean z3) {
        this.bits[(i5 * this.numcols) + i4] = z3 ? (byte) 1 : (byte) 0;
    }

    private void utah(int i4, int i5, int i6) {
        int i7 = i4 - 2;
        int i8 = i5 - 2;
        module(i7, i8, i6, 1);
        int i9 = i5 - 1;
        module(i7, i9, i6, 2);
        int i10 = i4 - 1;
        module(i10, i8, i6, 3);
        module(i10, i9, i6, 4);
        module(i10, i5, i6, 5);
        module(i4, i8, i6, 6);
        module(i4, i9, i6, 7);
        module(i4, i5, i6, 8);
    }

    public final boolean getBit(int i4, int i5) {
        return this.bits[(i5 * this.numcols) + i4] == 1;
    }

    final byte[] getBits() {
        return this.bits;
    }

    final int getNumcols() {
        return this.numcols;
    }

    final int getNumrows() {
        return this.numrows;
    }

    public final void place() {
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 0;
        int i8 = 4;
        while (true) {
            if (i8 == this.numrows && i6 == 0) {
                corner1(i7);
                i7++;
            }
            if (i8 == this.numrows - 2 && i6 == 0 && this.numcols % 4 != 0) {
                corner2(i7);
                i7++;
            }
            if (i8 == this.numrows - 2 && i6 == 0 && this.numcols % 8 == 4) {
                corner3(i7);
                i7++;
            }
            if (i8 == this.numrows + 4 && i6 == 2 && this.numcols % 8 == 0) {
                corner4(i7);
                i7++;
            }
            do {
                if (i8 < this.numrows && i6 >= 0 && !hasBit(i6, i8)) {
                    utah(i8, i6, i7);
                    i7++;
                }
                i8 -= 2;
                i6 += 2;
                if (i8 < 0) {
                    break;
                }
            } while (i6 < this.numcols);
            int i9 = i8 + 1;
            int i10 = i6 + 3;
            do {
                if (i9 >= 0 && i10 < this.numcols && !hasBit(i10, i9)) {
                    utah(i9, i10, i7);
                    i7++;
                }
                i9 += 2;
                i10 -= 2;
                i4 = this.numrows;
                if (i9 >= i4) {
                    break;
                }
            } while (i10 >= 0);
            i8 = i9 + 3;
            i6 = i10 + 1;
            if (i8 >= i4 && i6 >= (i5 = this.numcols)) {
                break;
            }
        }
        if (hasBit(i5 - 1, i4 - 1)) {
            return;
        }
        setBit(this.numcols - 1, this.numrows - 1, true);
        setBit(this.numcols - 2, this.numrows - 2, true);
    }
}
