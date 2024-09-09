package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
class DetectionResultColumn {
    private static final int MAX_NEARBY_DISTANCE = 5;
    private final BoundingBox boundingBox;
    private final Codeword[] codewords;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DetectionResultColumn(BoundingBox boundingBox) {
        this.boundingBox = new BoundingBox(boundingBox);
        this.codewords = new Codeword[(boundingBox.getMaxY() - boundingBox.getMinY()) + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Codeword getCodeword(int i4) {
        return this.codewords[imageRowToCodewordIndex(i4)];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Codeword getCodewordNearby(int i4) {
        Codeword codeword;
        Codeword codeword2;
        Codeword codeword3 = getCodeword(i4);
        if (codeword3 != null) {
            return codeword3;
        }
        for (int i5 = 1; i5 < 5; i5++) {
            int imageRowToCodewordIndex = imageRowToCodewordIndex(i4) - i5;
            if (imageRowToCodewordIndex >= 0 && (codeword2 = this.codewords[imageRowToCodewordIndex]) != null) {
                return codeword2;
            }
            int imageRowToCodewordIndex2 = imageRowToCodewordIndex(i4) + i5;
            Codeword[] codewordArr = this.codewords;
            if (imageRowToCodewordIndex2 < codewordArr.length && (codeword = codewordArr[imageRowToCodewordIndex2]) != null) {
                return codeword;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Codeword[] getCodewords() {
        return this.codewords;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int imageRowToCodewordIndex(int i4) {
        return i4 - this.boundingBox.getMinY();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setCodeword(int i4, Codeword codeword) {
        this.codewords[imageRowToCodewordIndex(i4)] = codeword;
    }

    public String toString() {
        Codeword[] codewordArr;
        Formatter formatter = new Formatter();
        int i4 = 0;
        for (Codeword codeword : this.codewords) {
            if (codeword == null) {
                formatter.format("%3d:    |   %n", Integer.valueOf(i4));
                i4++;
            } else {
                formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i4), Integer.valueOf(codeword.getRowNumber()), Integer.valueOf(codeword.getValue()));
                i4++;
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
