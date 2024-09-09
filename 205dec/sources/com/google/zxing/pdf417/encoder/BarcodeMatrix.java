package com.google.zxing.pdf417.encoder;

import java.lang.reflect.Array;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class BarcodeMatrix {
    private int currentRow;
    private final int height;
    private final BarcodeRow[] matrix;
    private final int width;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BarcodeMatrix(int i4, int i5) {
        BarcodeRow[] barcodeRowArr = new BarcodeRow[i4];
        this.matrix = barcodeRowArr;
        int length = barcodeRowArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.matrix[i6] = new BarcodeRow(((i5 + 4) * 17) + 1);
        }
        this.width = i5 * 17;
        this.height = i4;
        this.currentRow = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BarcodeRow getCurrentRow() {
        return this.matrix[this.currentRow];
    }

    public byte[][] getMatrix() {
        return getScaledMatrix(1, 1);
    }

    public byte[][] getScaledMatrix(int i4, int i5) {
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, this.height * i5, this.width * i4);
        int i6 = this.height * i5;
        for (int i7 = 0; i7 < i6; i7++) {
            bArr[(i6 - i7) - 1] = this.matrix[i7 / i5].getScaledRow(i4);
        }
        return bArr;
    }

    void set(int i4, int i5, byte b4) {
        this.matrix[i5].set(i4, b4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startRow() {
        this.currentRow++;
    }
}
