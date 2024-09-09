package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class Encoder {
    public static final int DEFAULT_AZTEC_LAYERS = 0;
    public static final int DEFAULT_EC_PERCENT = 33;
    private static final int MAX_NB_BITS = 32;
    private static final int MAX_NB_BITS_COMPACT = 4;
    private static final int[] WORD_SIZE = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private Encoder() {
    }

    private static int[] bitsToWords(BitArray bitArray, int i4, int i5) {
        int[] iArr = new int[i5];
        int size = bitArray.getSize() / i4;
        for (int i6 = 0; i6 < size; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                i7 |= bitArray.get((i6 * i4) + i8) ? 1 << ((i4 - i8) - 1) : 0;
            }
            iArr[i6] = i7;
        }
        return iArr;
    }

    private static void drawBullsEye(BitMatrix bitMatrix, int i4, int i5) {
        for (int i6 = 0; i6 < i5; i6 += 2) {
            int i7 = i4 - i6;
            int i8 = i7;
            while (true) {
                int i9 = i4 + i6;
                if (i8 <= i9) {
                    bitMatrix.set(i8, i7);
                    bitMatrix.set(i8, i9);
                    bitMatrix.set(i7, i8);
                    bitMatrix.set(i9, i8);
                    i8++;
                }
            }
        }
        int i10 = i4 - i5;
        bitMatrix.set(i10, i10);
        int i11 = i10 + 1;
        bitMatrix.set(i11, i10);
        bitMatrix.set(i10, i11);
        int i12 = i4 + i5;
        bitMatrix.set(i12, i10);
        bitMatrix.set(i12, i11);
        bitMatrix.set(i12, i12 - 1);
    }

    private static void drawModeMessage(BitMatrix bitMatrix, boolean z3, int i4, BitArray bitArray) {
        int i5 = i4 / 2;
        int i6 = 0;
        if (z3) {
            while (i6 < 7) {
                int i7 = (i5 - 3) + i6;
                if (bitArray.get(i6)) {
                    bitMatrix.set(i7, i5 - 5);
                }
                if (bitArray.get(i6 + 7)) {
                    bitMatrix.set(i5 + 5, i7);
                }
                if (bitArray.get(20 - i6)) {
                    bitMatrix.set(i7, i5 + 5);
                }
                if (bitArray.get(27 - i6)) {
                    bitMatrix.set(i5 - 5, i7);
                }
                i6++;
            }
            return;
        }
        while (i6 < 10) {
            int i8 = (i5 - 5) + i6 + (i6 / 5);
            if (bitArray.get(i6)) {
                bitMatrix.set(i8, i5 - 7);
            }
            if (bitArray.get(i6 + 10)) {
                bitMatrix.set(i5 + 7, i8);
            }
            if (bitArray.get(29 - i6)) {
                bitMatrix.set(i8, i5 + 7);
            }
            if (bitArray.get(39 - i6)) {
                bitMatrix.set(i5 - 7, i8);
            }
            i6++;
        }
    }

    public static AztecCode encode(byte[] bArr) {
        return encode(bArr, 33, 0);
    }

    private static BitArray generateCheckWords(BitArray bitArray, int i4, int i5) {
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(getGF(i5));
        int i6 = i4 / i5;
        int[] bitsToWords = bitsToWords(bitArray, i5, i6);
        reedSolomonEncoder.encode(bitsToWords, i6 - (bitArray.getSize() / i5));
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(0, i4 % i5);
        for (int i7 : bitsToWords) {
            bitArray2.appendBits(i7, i5);
        }
        return bitArray2;
    }

    static BitArray generateModeMessage(boolean z3, int i4, int i5) {
        BitArray bitArray = new BitArray();
        if (z3) {
            bitArray.appendBits(i4 - 1, 2);
            bitArray.appendBits(i5 - 1, 6);
            return generateCheckWords(bitArray, 28, 4);
        }
        bitArray.appendBits(i4 - 1, 5);
        bitArray.appendBits(i5 - 1, 11);
        return generateCheckWords(bitArray, 40, 4);
    }

    private static GenericGF getGF(int i4) {
        if (i4 != 4) {
            if (i4 != 6) {
                if (i4 != 8) {
                    if (i4 != 10) {
                        if (i4 == 12) {
                            return GenericGF.AZTEC_DATA_12;
                        }
                        throw new IllegalArgumentException("Unsupported word size " + i4);
                    }
                    return GenericGF.AZTEC_DATA_10;
                }
                return GenericGF.AZTEC_DATA_8;
            }
            return GenericGF.AZTEC_DATA_6;
        }
        return GenericGF.AZTEC_PARAM;
    }

    static BitArray stuffBits(BitArray bitArray, int i4) {
        BitArray bitArray2 = new BitArray();
        int size = bitArray.getSize();
        int i5 = (1 << i4) - 2;
        int i6 = 0;
        while (i6 < size) {
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = i6 + i8;
                if (i9 >= size || bitArray.get(i9)) {
                    i7 |= 1 << ((i4 - 1) - i8);
                }
            }
            int i10 = i7 & i5;
            if (i10 == i5) {
                bitArray2.appendBits(i10, i4);
            } else if (i10 == 0) {
                bitArray2.appendBits(i7 | 1, i4);
            } else {
                bitArray2.appendBits(i7, i4);
                i6 += i4;
            }
            i6--;
            i6 += i4;
        }
        return bitArray2;
    }

    private static int totalBitsInLayer(int i4, boolean z3) {
        return ((z3 ? 88 : 112) + (i4 << 4)) * i4;
    }

    public static AztecCode encode(byte[] bArr, int i4, int i5) {
        BitArray bitArray;
        int i6;
        boolean z3;
        int i7;
        int i8;
        int i9;
        BitArray encode = new HighLevelEncoder(bArr).encode();
        int size = ((encode.getSize() * i4) / 100) + 11;
        int size2 = encode.getSize() + size;
        int i10 = 0;
        int i11 = 1;
        if (i5 != 0) {
            z3 = i5 < 0;
            i7 = Math.abs(i5);
            if (i7 <= (z3 ? 4 : 32)) {
                i8 = totalBitsInLayer(i7, z3);
                i6 = WORD_SIZE[i7];
                int i12 = i8 - (i8 % i6);
                bitArray = stuffBits(encode, i6);
                if (bitArray.getSize() + size <= i12) {
                    if (z3 && bitArray.getSize() > (i6 << 6)) {
                        throw new IllegalArgumentException("Data to large for user specified layer");
                    }
                } else {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i5)));
            }
        } else {
            BitArray bitArray2 = null;
            int i13 = 0;
            int i14 = 0;
            while (i13 <= 32) {
                boolean z4 = i13 <= 3;
                int i15 = z4 ? i13 + 1 : i13;
                int i16 = totalBitsInLayer(i15, z4);
                if (size2 <= i16) {
                    int[] iArr = WORD_SIZE;
                    if (i14 != iArr[i15]) {
                        int i17 = iArr[i15];
                        i14 = i17;
                        bitArray2 = stuffBits(encode, i17);
                    }
                    int i18 = i16 - (i16 % i14);
                    if ((!z4 || bitArray2.getSize() <= (i14 << 6)) && bitArray2.getSize() + size <= i18) {
                        bitArray = bitArray2;
                        i6 = i14;
                        z3 = z4;
                        i7 = i15;
                        i8 = i16;
                    }
                }
                i13++;
                i10 = 0;
                i11 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        BitArray generateCheckWords = generateCheckWords(bitArray, i8, i6);
        int size3 = bitArray.getSize() / i6;
        BitArray generateModeMessage = generateModeMessage(z3, i7, size3);
        int i19 = (z3 ? 11 : 14) + (i7 << 2);
        int[] iArr2 = new int[i19];
        int i20 = 2;
        if (z3) {
            for (int i21 = 0; i21 < i19; i21++) {
                iArr2[i21] = i21;
            }
            i9 = i19;
        } else {
            int i22 = i19 / 2;
            i9 = i19 + 1 + (((i22 - 1) / 15) * 2);
            int i23 = i9 / 2;
            for (int i24 = 0; i24 < i22; i24++) {
                int i25 = (i24 / 15) + i24;
                iArr2[(i22 - i24) - i11] = (i23 - i25) - 1;
                iArr2[i22 + i24] = i25 + i23 + i11;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i9);
        int i26 = 0;
        int i27 = 0;
        while (i26 < i7) {
            int i28 = ((i7 - i26) << i20) + (z3 ? 9 : 12);
            int i29 = 0;
            while (i29 < i28) {
                int i30 = i29 << 1;
                while (i10 < i20) {
                    if (generateCheckWords.get(i27 + i30 + i10)) {
                        int i31 = i26 << 1;
                        bitMatrix.set(iArr2[i31 + i10], iArr2[i31 + i29]);
                    }
                    if (generateCheckWords.get((i28 << 1) + i27 + i30 + i10)) {
                        int i32 = i26 << 1;
                        bitMatrix.set(iArr2[i32 + i29], iArr2[((i19 - 1) - i32) - i10]);
                    }
                    if (generateCheckWords.get((i28 << 2) + i27 + i30 + i10)) {
                        int i33 = (i19 - 1) - (i26 << 1);
                        bitMatrix.set(iArr2[i33 - i10], iArr2[i33 - i29]);
                    }
                    if (generateCheckWords.get((i28 * 6) + i27 + i30 + i10)) {
                        int i34 = i26 << 1;
                        bitMatrix.set(iArr2[((i19 - 1) - i34) - i29], iArr2[i34 + i10]);
                    }
                    i10++;
                    i20 = 2;
                }
                i29++;
                i10 = 0;
                i20 = 2;
            }
            i27 += i28 << 3;
            i26++;
            i10 = 0;
            i20 = 2;
        }
        drawModeMessage(bitMatrix, z3, i9, generateModeMessage);
        if (z3) {
            drawBullsEye(bitMatrix, i9 / 2, 5);
        } else {
            int i35 = i9 / 2;
            drawBullsEye(bitMatrix, i35, 7);
            int i36 = 0;
            int i37 = 0;
            while (i37 < (i19 / 2) - 1) {
                for (int i38 = i35 & 1; i38 < i9; i38 += 2) {
                    int i39 = i35 - i36;
                    bitMatrix.set(i39, i38);
                    int i40 = i35 + i36;
                    bitMatrix.set(i40, i38);
                    bitMatrix.set(i38, i39);
                    bitMatrix.set(i38, i40);
                }
                i37 += 15;
                i36 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.setCompact(z3);
        aztecCode.setSize(i9);
        aztecCode.setLayers(i7);
        aztecCode.setCodeWords(size3);
        aztecCode.setMatrix(bitMatrix);
        return aztecCode;
    }
}
