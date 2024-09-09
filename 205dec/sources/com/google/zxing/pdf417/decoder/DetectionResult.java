package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class DetectionResult {
    private static final int ADJUST_ROW_NUMBER_SKIP = 2;
    private final int barcodeColumnCount;
    private final BarcodeMetadata barcodeMetadata;
    private BoundingBox boundingBox;
    private final DetectionResultColumn[] detectionResultColumns;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DetectionResult(BarcodeMetadata barcodeMetadata, BoundingBox boundingBox) {
        this.barcodeMetadata = barcodeMetadata;
        int columnCount = barcodeMetadata.getColumnCount();
        this.barcodeColumnCount = columnCount;
        this.boundingBox = boundingBox;
        this.detectionResultColumns = new DetectionResultColumn[columnCount + 2];
    }

    private void adjustIndicatorColumnRowNumbers(DetectionResultColumn detectionResultColumn) {
        if (detectionResultColumn != null) {
            ((DetectionResultRowIndicatorColumn) detectionResultColumn).adjustCompleteIndicatorColumnRowNumbers(this.barcodeMetadata);
        }
    }

    private static boolean adjustRowNumber(Codeword codeword, Codeword codeword2) {
        if (codeword2 != null && codeword2.hasValidRowNumber() && codeword2.getBucket() == codeword.getBucket()) {
            codeword.setRowNumber(codeword2.getRowNumber());
            return true;
        }
        return false;
    }

    private static int adjustRowNumberIfValid(int i4, int i5, Codeword codeword) {
        if (codeword == null || codeword.hasValidRowNumber()) {
            return i5;
        }
        if (codeword.isValidRowNumber(i4)) {
            codeword.setRowNumber(i4);
            return 0;
        }
        return i5 + 1;
    }

    private int adjustRowNumbers() {
        int adjustRowNumbersByRow = adjustRowNumbersByRow();
        if (adjustRowNumbersByRow == 0) {
            return 0;
        }
        for (int i4 = 1; i4 < this.barcodeColumnCount + 1; i4++) {
            Codeword[] codewords = this.detectionResultColumns[i4].getCodewords();
            for (int i5 = 0; i5 < codewords.length; i5++) {
                if (codewords[i5] != null && !codewords[i5].hasValidRowNumber()) {
                    adjustRowNumbers(i4, i5, codewords);
                }
            }
        }
        return adjustRowNumbersByRow;
    }

    private int adjustRowNumbersByRow() {
        adjustRowNumbersFromBothRI();
        return adjustRowNumbersFromLRI() + adjustRowNumbersFromRRI();
    }

    private void adjustRowNumbersFromBothRI() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        if (detectionResultColumnArr[0] == null || detectionResultColumnArr[this.barcodeColumnCount + 1] == null) {
            return;
        }
        Codeword[] codewords = detectionResultColumnArr[0].getCodewords();
        Codeword[] codewords2 = this.detectionResultColumns[this.barcodeColumnCount + 1].getCodewords();
        for (int i4 = 0; i4 < codewords.length; i4++) {
            if (codewords[i4] != null && codewords2[i4] != null && codewords[i4].getRowNumber() == codewords2[i4].getRowNumber()) {
                for (int i5 = 1; i5 <= this.barcodeColumnCount; i5++) {
                    Codeword codeword = this.detectionResultColumns[i5].getCodewords()[i4];
                    if (codeword != null) {
                        codeword.setRowNumber(codewords[i4].getRowNumber());
                        if (!codeword.hasValidRowNumber()) {
                            this.detectionResultColumns[i5].getCodewords()[i4] = null;
                        }
                    }
                }
            }
        }
    }

    private int adjustRowNumbersFromLRI() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        if (detectionResultColumnArr[0] == null) {
            return 0;
        }
        Codeword[] codewords = detectionResultColumnArr[0].getCodewords();
        int i4 = 0;
        for (int i5 = 0; i5 < codewords.length; i5++) {
            if (codewords[i5] != null) {
                int rowNumber = codewords[i5].getRowNumber();
                int i6 = 0;
                for (int i7 = 1; i7 < this.barcodeColumnCount + 1 && i6 < 2; i7++) {
                    Codeword codeword = this.detectionResultColumns[i7].getCodewords()[i5];
                    if (codeword != null) {
                        i6 = adjustRowNumberIfValid(rowNumber, i6, codeword);
                        if (!codeword.hasValidRowNumber()) {
                            i4++;
                        }
                    }
                }
            }
        }
        return i4;
    }

    private int adjustRowNumbersFromRRI() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        int i4 = this.barcodeColumnCount;
        if (detectionResultColumnArr[i4 + 1] == null) {
            return 0;
        }
        Codeword[] codewords = detectionResultColumnArr[i4 + 1].getCodewords();
        int i5 = 0;
        for (int i6 = 0; i6 < codewords.length; i6++) {
            if (codewords[i6] != null) {
                int rowNumber = codewords[i6].getRowNumber();
                int i7 = 0;
                for (int i8 = this.barcodeColumnCount + 1; i8 > 0 && i7 < 2; i8--) {
                    Codeword codeword = this.detectionResultColumns[i8].getCodewords()[i6];
                    if (codeword != null) {
                        i7 = adjustRowNumberIfValid(rowNumber, i7, codeword);
                        if (!codeword.hasValidRowNumber()) {
                            i5++;
                        }
                    }
                }
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBarcodeColumnCount() {
        return this.barcodeColumnCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBarcodeECLevel() {
        return this.barcodeMetadata.getErrorCorrectionLevel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBarcodeRowCount() {
        return this.barcodeMetadata.getRowCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DetectionResultColumn getDetectionResultColumn(int i4) {
        return this.detectionResultColumns[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DetectionResultColumn[] getDetectionResultColumns() {
        adjustIndicatorColumnRowNumbers(this.detectionResultColumns[0]);
        adjustIndicatorColumnRowNumbers(this.detectionResultColumns[this.barcodeColumnCount + 1]);
        int i4 = 928;
        while (true) {
            int adjustRowNumbers = adjustRowNumbers();
            if (adjustRowNumbers <= 0 || adjustRowNumbers >= i4) {
                break;
            }
            i4 = adjustRowNumbers;
        }
        return this.detectionResultColumns;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDetectionResultColumn(int i4, DetectionResultColumn detectionResultColumn) {
        this.detectionResultColumns[i4] = detectionResultColumn;
    }

    public String toString() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        DetectionResultColumn detectionResultColumn = detectionResultColumnArr[0];
        if (detectionResultColumn == null) {
            detectionResultColumn = detectionResultColumnArr[this.barcodeColumnCount + 1];
        }
        Formatter formatter = new Formatter();
        for (int i4 = 0; i4 < detectionResultColumn.getCodewords().length; i4++) {
            formatter.format("CW %3d:", Integer.valueOf(i4));
            for (int i5 = 0; i5 < this.barcodeColumnCount + 2; i5++) {
                DetectionResultColumn[] detectionResultColumnArr2 = this.detectionResultColumns;
                if (detectionResultColumnArr2[i5] == null) {
                    formatter.format("    |   ", new Object[0]);
                } else {
                    Codeword codeword = detectionResultColumnArr2[i5].getCodewords()[i4];
                    if (codeword == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        formatter.format(" %3d|%3d", Integer.valueOf(codeword.getRowNumber()), Integer.valueOf(codeword.getValue()));
                    }
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    private void adjustRowNumbers(int i4, int i5, Codeword[] codewordArr) {
        Codeword codeword = codewordArr[i5];
        Codeword[] codewords = this.detectionResultColumns[i4 - 1].getCodewords();
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        int i6 = i4 + 1;
        Codeword[] codewords2 = detectionResultColumnArr[i6] != null ? detectionResultColumnArr[i6].getCodewords() : codewords;
        Codeword[] codewordArr2 = new Codeword[14];
        codewordArr2[2] = codewords[i5];
        codewordArr2[3] = codewords2[i5];
        if (i5 > 0) {
            int i7 = i5 - 1;
            codewordArr2[0] = codewordArr[i7];
            codewordArr2[4] = codewords[i7];
            codewordArr2[5] = codewords2[i7];
        }
        if (i5 > 1) {
            int i8 = i5 - 2;
            codewordArr2[8] = codewordArr[i8];
            codewordArr2[10] = codewords[i8];
            codewordArr2[11] = codewords2[i8];
        }
        if (i5 < codewordArr.length - 1) {
            int i9 = i5 + 1;
            codewordArr2[1] = codewordArr[i9];
            codewordArr2[6] = codewords[i9];
            codewordArr2[7] = codewords2[i9];
        }
        if (i5 < codewordArr.length - 2) {
            int i10 = i5 + 2;
            codewordArr2[9] = codewordArr[i10];
            codewordArr2[12] = codewords[i10];
            codewordArr2[13] = codewords2[i10];
        }
        for (int i11 = 0; i11 < 14 && !adjustRowNumber(codeword, codewordArr2[i11]); i11++) {
        }
    }
}
