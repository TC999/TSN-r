package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class MatrixUtil {
    private static final int TYPE_INFO_MASK_PATTERN = 21522;
    private static final int TYPE_INFO_POLY = 1335;
    private static final int VERSION_INFO_POLY = 7973;
    private static final int[][] POSITION_DETECTION_PATTERN = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
    private static final int[][] TYPE_INFO_COORDINATES = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    private MatrixUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void buildMatrix(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, int i4, ByteMatrix byteMatrix) throws WriterException {
        clearMatrix(byteMatrix);
        embedBasicPatterns(version, byteMatrix);
        embedTypeInfo(errorCorrectionLevel, i4, byteMatrix);
        maybeEmbedVersionInfo(version, byteMatrix);
        embedDataBits(bitArray, i4, byteMatrix);
    }

    static int calculateBCHCode(int i4, int i5) {
        if (i5 != 0) {
            int findMSBSet = findMSBSet(i5);
            int i6 = i4 << (findMSBSet - 1);
            while (findMSBSet(i6) >= findMSBSet) {
                i6 ^= i5 << (findMSBSet(i6) - findMSBSet);
            }
            return i6;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    static void clearMatrix(ByteMatrix byteMatrix) {
        byteMatrix.clear((byte) -1);
    }

    static void embedBasicPatterns(Version version, ByteMatrix byteMatrix) throws WriterException {
        embedPositionDetectionPatternsAndSeparators(byteMatrix);
        embedDarkDotAtLeftBottomCorner(byteMatrix);
        maybeEmbedPositionAdjustmentPatterns(version, byteMatrix);
        embedTimingPatterns(byteMatrix);
    }

    private static void embedDarkDotAtLeftBottomCorner(ByteMatrix byteMatrix) throws WriterException {
        if (byteMatrix.get(8, byteMatrix.getHeight() - 8) != 0) {
            byteMatrix.set(8, byteMatrix.getHeight() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    static void embedDataBits(BitArray bitArray, int i4, ByteMatrix byteMatrix) throws WriterException {
        boolean z3;
        int width = byteMatrix.getWidth() - 1;
        int height = byteMatrix.getHeight() - 1;
        int i5 = 0;
        int i6 = -1;
        while (width > 0) {
            if (width == 6) {
                width--;
            }
            while (height >= 0 && height < byteMatrix.getHeight()) {
                for (int i7 = 0; i7 < 2; i7++) {
                    int i8 = width - i7;
                    if (isEmpty(byteMatrix.get(i8, height))) {
                        if (i5 < bitArray.getSize()) {
                            z3 = bitArray.get(i5);
                            i5++;
                        } else {
                            z3 = false;
                        }
                        if (i4 != -1 && MaskUtil.getDataMaskBit(i4, i8, height)) {
                            z3 = !z3;
                        }
                        byteMatrix.set(i8, height, z3);
                    }
                }
                height += i6;
            }
            i6 = -i6;
            height += i6;
            width -= 2;
        }
        if (i5 == bitArray.getSize()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i5 + '/' + bitArray.getSize());
    }

    private static void embedHorizontalSeparationPattern(int i4, int i5, ByteMatrix byteMatrix) throws WriterException {
        for (int i6 = 0; i6 < 8; i6++) {
            int i7 = i4 + i6;
            if (isEmpty(byteMatrix.get(i7, i5))) {
                byteMatrix.set(i7, i5, 0);
            } else {
                throw new WriterException();
            }
        }
    }

    private static void embedPositionAdjustmentPattern(int i4, int i5, ByteMatrix byteMatrix) {
        for (int i6 = 0; i6 < 5; i6++) {
            for (int i7 = 0; i7 < 5; i7++) {
                byteMatrix.set(i4 + i7, i5 + i6, POSITION_ADJUSTMENT_PATTERN[i6][i7]);
            }
        }
    }

    private static void embedPositionDetectionPattern(int i4, int i5, ByteMatrix byteMatrix) {
        for (int i6 = 0; i6 < 7; i6++) {
            for (int i7 = 0; i7 < 7; i7++) {
                byteMatrix.set(i4 + i7, i5 + i6, POSITION_DETECTION_PATTERN[i6][i7]);
            }
        }
    }

    private static void embedPositionDetectionPatternsAndSeparators(ByteMatrix byteMatrix) throws WriterException {
        int length = POSITION_DETECTION_PATTERN[0].length;
        embedPositionDetectionPattern(0, 0, byteMatrix);
        embedPositionDetectionPattern(byteMatrix.getWidth() - length, 0, byteMatrix);
        embedPositionDetectionPattern(0, byteMatrix.getWidth() - length, byteMatrix);
        embedHorizontalSeparationPattern(0, 7, byteMatrix);
        embedHorizontalSeparationPattern(byteMatrix.getWidth() - 8, 7, byteMatrix);
        embedHorizontalSeparationPattern(0, byteMatrix.getWidth() - 8, byteMatrix);
        embedVerticalSeparationPattern(7, 0, byteMatrix);
        embedVerticalSeparationPattern((byteMatrix.getHeight() - 7) - 1, 0, byteMatrix);
        embedVerticalSeparationPattern(7, byteMatrix.getHeight() - 7, byteMatrix);
    }

    private static void embedTimingPatterns(ByteMatrix byteMatrix) {
        int i4 = 8;
        while (i4 < byteMatrix.getWidth() - 8) {
            int i5 = i4 + 1;
            int i6 = i5 % 2;
            if (isEmpty(byteMatrix.get(i4, 6))) {
                byteMatrix.set(i4, 6, i6);
            }
            if (isEmpty(byteMatrix.get(6, i4))) {
                byteMatrix.set(6, i4, i6);
            }
            i4 = i5;
        }
    }

    static void embedTypeInfo(ErrorCorrectionLevel errorCorrectionLevel, int i4, ByteMatrix byteMatrix) throws WriterException {
        BitArray bitArray = new BitArray();
        makeTypeInfoBits(errorCorrectionLevel, i4, bitArray);
        for (int i5 = 0; i5 < bitArray.getSize(); i5++) {
            boolean z3 = bitArray.get((bitArray.getSize() - 1) - i5);
            int[][] iArr = TYPE_INFO_COORDINATES;
            byteMatrix.set(iArr[i5][0], iArr[i5][1], z3);
            if (i5 < 8) {
                byteMatrix.set((byteMatrix.getWidth() - i5) - 1, 8, z3);
            } else {
                byteMatrix.set(8, (byteMatrix.getHeight() - 7) + (i5 - 8), z3);
            }
        }
    }

    private static void embedVerticalSeparationPattern(int i4, int i5, ByteMatrix byteMatrix) throws WriterException {
        for (int i6 = 0; i6 < 7; i6++) {
            int i7 = i5 + i6;
            if (isEmpty(byteMatrix.get(i4, i7))) {
                byteMatrix.set(i4, i7, 0);
            } else {
                throw new WriterException();
            }
        }
    }

    static int findMSBSet(int i4) {
        return 32 - Integer.numberOfLeadingZeros(i4);
    }

    private static boolean isEmpty(int i4) {
        return i4 == -1;
    }

    static void makeTypeInfoBits(ErrorCorrectionLevel errorCorrectionLevel, int i4, BitArray bitArray) throws WriterException {
        if (QRCode.isValidMaskPattern(i4)) {
            int bits = (errorCorrectionLevel.getBits() << 3) | i4;
            bitArray.appendBits(bits, 5);
            bitArray.appendBits(calculateBCHCode(bits, 1335), 10);
            BitArray bitArray2 = new BitArray();
            bitArray2.appendBits(21522, 15);
            bitArray.xor(bitArray2);
            if (bitArray.getSize() == 15) {
                return;
            }
            throw new WriterException("should not happen but we got: " + bitArray.getSize());
        }
        throw new WriterException("Invalid mask pattern");
    }

    static void makeVersionInfoBits(Version version, BitArray bitArray) throws WriterException {
        bitArray.appendBits(version.getVersionNumber(), 6);
        bitArray.appendBits(calculateBCHCode(version.getVersionNumber(), 7973), 12);
        if (bitArray.getSize() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + bitArray.getSize());
    }

    private static void maybeEmbedPositionAdjustmentPatterns(Version version, ByteMatrix byteMatrix) {
        if (version.getVersionNumber() < 2) {
            return;
        }
        int versionNumber = version.getVersionNumber() - 1;
        int[][] iArr = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE;
        int[] iArr2 = iArr[versionNumber];
        int length = iArr[versionNumber].length;
        for (int i4 = 0; i4 < length; i4++) {
            for (int i5 = 0; i5 < length; i5++) {
                int i6 = iArr2[i4];
                int i7 = iArr2[i5];
                if (i7 != -1 && i6 != -1 && isEmpty(byteMatrix.get(i7, i6))) {
                    embedPositionAdjustmentPattern(i7 - 2, i6 - 2, byteMatrix);
                }
            }
        }
    }

    static void maybeEmbedVersionInfo(Version version, ByteMatrix byteMatrix) throws WriterException {
        if (version.getVersionNumber() < 7) {
            return;
        }
        BitArray bitArray = new BitArray();
        makeVersionInfoBits(version, bitArray);
        int i4 = 17;
        for (int i5 = 0; i5 < 6; i5++) {
            for (int i6 = 0; i6 < 3; i6++) {
                boolean z3 = bitArray.get(i4);
                i4--;
                byteMatrix.set(i5, (byteMatrix.getHeight() - 11) + i6, z3);
                byteMatrix.set((byteMatrix.getHeight() - 11) + i6, i5, z3);
            }
        }
    }
}
