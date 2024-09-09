package com.google.zxing.qrcode.encoder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class MaskUtil {
    private static final int N1 = 3;
    private static final int N2 = 3;
    private static final int N3 = 40;
    private static final int N4 = 10;

    private MaskUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int applyMaskPenaltyRule1(ByteMatrix byteMatrix) {
        return applyMaskPenaltyRule1Internal(byteMatrix, true) + applyMaskPenaltyRule1Internal(byteMatrix, false);
    }

    private static int applyMaskPenaltyRule1Internal(ByteMatrix byteMatrix, boolean z3) {
        int height = z3 ? byteMatrix.getHeight() : byteMatrix.getWidth();
        int width = z3 ? byteMatrix.getWidth() : byteMatrix.getHeight();
        byte[][] array = byteMatrix.getArray();
        int i4 = 0;
        for (int i5 = 0; i5 < height; i5++) {
            byte b4 = -1;
            int i6 = 0;
            for (int i7 = 0; i7 < width; i7++) {
                byte b5 = z3 ? array[i5][i7] : array[i7][i5];
                if (b5 == b4) {
                    i6++;
                } else {
                    if (i6 >= 5) {
                        i4 += (i6 - 5) + 3;
                    }
                    b4 = b5;
                    i6 = 1;
                }
            }
            if (i6 >= 5) {
                i4 += (i6 - 5) + 3;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int applyMaskPenaltyRule2(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i4 = 0;
        for (int i5 = 0; i5 < height - 1; i5++) {
            int i6 = 0;
            while (i6 < width - 1) {
                byte b4 = array[i5][i6];
                int i7 = i6 + 1;
                if (b4 == array[i5][i7]) {
                    int i8 = i5 + 1;
                    if (b4 == array[i8][i6] && b4 == array[i8][i7]) {
                        i4++;
                    }
                }
                i6 = i7;
            }
        }
        return i4 * 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int applyMaskPenaltyRule3(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i4 = 0;
        for (int i5 = 0; i5 < height; i5++) {
            for (int i6 = 0; i6 < width; i6++) {
                byte[] bArr = array[i5];
                int i7 = i6 + 6;
                if (i7 < width && bArr[i6] == 1 && bArr[i6 + 1] == 0 && bArr[i6 + 2] == 1 && bArr[i6 + 3] == 1 && bArr[i6 + 4] == 1 && bArr[i6 + 5] == 0 && bArr[i7] == 1 && (isWhiteHorizontal(bArr, i6 - 4, i6) || isWhiteHorizontal(bArr, i6 + 7, i6 + 11))) {
                    i4++;
                }
                int i8 = i5 + 6;
                if (i8 < height && array[i5][i6] == 1 && array[i5 + 1][i6] == 0 && array[i5 + 2][i6] == 1 && array[i5 + 3][i6] == 1 && array[i5 + 4][i6] == 1 && array[i5 + 5][i6] == 0 && array[i8][i6] == 1 && (isWhiteVertical(array, i6, i5 - 4, i5) || isWhiteVertical(array, i6, i5 + 7, i5 + 11))) {
                    i4++;
                }
            }
        }
        return i4 * 40;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int applyMaskPenaltyRule4(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i4 = 0;
        for (int i5 = 0; i5 < height; i5++) {
            byte[] bArr = array[i5];
            for (int i6 = 0; i6 < width; i6++) {
                if (bArr[i6] == 1) {
                    i4++;
                }
            }
        }
        int height2 = byteMatrix.getHeight() * byteMatrix.getWidth();
        return ((Math.abs((i4 << 1) - height2) * 10) / height2) * 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean getDataMaskBit(int i4, int i5, int i6) {
        int i7;
        int i8;
        switch (i4) {
            case 0:
                i6 += i5;
                i7 = i6 & 1;
                break;
            case 1:
                i7 = i6 & 1;
                break;
            case 2:
                i7 = i5 % 3;
                break;
            case 3:
                i7 = (i6 + i5) % 3;
                break;
            case 4:
                i6 /= 2;
                i5 /= 3;
                i6 += i5;
                i7 = i6 & 1;
                break;
            case 5:
                int i9 = i6 * i5;
                i7 = (i9 & 1) + (i9 % 3);
                break;
            case 6:
                int i10 = i6 * i5;
                i8 = (i10 & 1) + (i10 % 3);
                i7 = i8 & 1;
                break;
            case 7:
                i8 = ((i6 * i5) % 3) + ((i6 + i5) & 1);
                i7 = i8 & 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: " + i4);
        }
        return i7 == 0;
    }

    private static boolean isWhiteHorizontal(byte[] bArr, int i4, int i5) {
        int min = Math.min(i5, bArr.length);
        for (int max = Math.max(i4, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isWhiteVertical(byte[][] bArr, int i4, int i5, int i6) {
        int min = Math.min(i6, bArr.length);
        for (int max = Math.max(i5, 0); max < min; max++) {
            if (bArr[max][i4] == 1) {
                return false;
            }
        }
        return true;
    }
}
