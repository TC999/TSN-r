package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class Encoder {
    private static final int[] ALPHANUMERIC_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    static final String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.google.zxing.qrcode.encoder.Encoder$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$qrcode$decoder$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private Encoder() {
    }

    static void append8BitBytes(String str, BitArray bitArray, String str2) throws WriterException {
        try {
            for (byte b4 : str.getBytes(str2)) {
                bitArray.appendBits(b4, 8);
            }
        } catch (UnsupportedEncodingException e4) {
            throw new WriterException(e4);
        }
    }

    static void appendAlphanumericBytes(CharSequence charSequence, BitArray bitArray) throws WriterException {
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length) {
            int alphanumericCode = getAlphanumericCode(charSequence.charAt(i4));
            if (alphanumericCode == -1) {
                throw new WriterException();
            }
            int i5 = i4 + 1;
            if (i5 < length) {
                int alphanumericCode2 = getAlphanumericCode(charSequence.charAt(i5));
                if (alphanumericCode2 != -1) {
                    bitArray.appendBits((alphanumericCode * 45) + alphanumericCode2, 11);
                    i4 += 2;
                } else {
                    throw new WriterException();
                }
            } else {
                bitArray.appendBits(alphanumericCode, 6);
                i4 = i5;
            }
        }
    }

    static void appendBytes(String str, Mode mode, BitArray bitArray, String str2) throws WriterException {
        int i4 = AnonymousClass1.$SwitchMap$com$google$zxing$qrcode$decoder$Mode[mode.ordinal()];
        if (i4 == 1) {
            appendNumericBytes(str, bitArray);
        } else if (i4 == 2) {
            appendAlphanumericBytes(str, bitArray);
        } else if (i4 == 3) {
            append8BitBytes(str, bitArray, str2);
        } else if (i4 == 4) {
            appendKanjiBytes(str, bitArray);
        } else {
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    private static void appendECI(CharacterSetECI characterSetECI, BitArray bitArray) {
        bitArray.appendBits(Mode.ECI.getBits(), 4);
        bitArray.appendBits(characterSetECI.getValue(), 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[LOOP:0: B:4:0x0008->B:17:0x0035, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void appendKanjiBytes(java.lang.String r6, com.google.zxing.common.BitArray r7) throws com.google.zxing.WriterException {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L4d
            int r0 = r6.length
            r1 = 0
        L8:
            if (r1 >= r0) goto L4c
            r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L24
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L24
        L22:
            int r2 = r2 - r3
            goto L33
        L24:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L32
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L32
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L22
        L32:
            r2 = -1
        L33:
            if (r2 == r4) goto L44
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.appendBits(r3, r2)
            int r1 = r1 + 2
            goto L8
        L44:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>(r7)
            throw r6
        L4c:
            return
        L4d:
            r6 = move-exception
            com.google.zxing.WriterException r7 = new com.google.zxing.WriterException
            r7.<init>(r6)
            goto L55
        L54:
            throw r7
        L55:
            goto L54
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.Encoder.appendKanjiBytes(java.lang.String, com.google.zxing.common.BitArray):void");
    }

    static void appendLengthInfo(int i4, Version version, Mode mode, BitArray bitArray) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(version);
        int i5 = 1 << characterCountBits;
        if (i4 < i5) {
            bitArray.appendBits(i4, characterCountBits);
            return;
        }
        throw new WriterException(i4 + " is bigger than " + (i5 - 1));
    }

    static void appendModeInfo(Mode mode, BitArray bitArray) {
        bitArray.appendBits(mode.getBits(), 4);
    }

    static void appendNumericBytes(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length) {
            int charAt = charSequence.charAt(i4) - '0';
            int i5 = i4 + 2;
            if (i5 < length) {
                bitArray.appendBits((charAt * 100) + ((charSequence.charAt(i4 + 1) - '0') * 10) + (charSequence.charAt(i5) - '0'), 10);
                i4 += 3;
            } else {
                i4++;
                if (i4 < length) {
                    bitArray.appendBits((charAt * 10) + (charSequence.charAt(i4) - '0'), 7);
                    i4 = i5;
                } else {
                    bitArray.appendBits(charAt, 4);
                }
            }
        }
    }

    private static int calculateBitsNeeded(Mode mode, BitArray bitArray, BitArray bitArray2, Version version) {
        return bitArray.getSize() + mode.getCharacterCountBits(version) + bitArray2.getSize();
    }

    private static int calculateMaskPenalty(ByteMatrix byteMatrix) {
        return MaskUtil.applyMaskPenaltyRule1(byteMatrix) + MaskUtil.applyMaskPenaltyRule2(byteMatrix) + MaskUtil.applyMaskPenaltyRule3(byteMatrix) + MaskUtil.applyMaskPenaltyRule4(byteMatrix);
    }

    private static int chooseMaskPattern(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, ByteMatrix byteMatrix) throws WriterException {
        int i4 = Integer.MAX_VALUE;
        int i5 = -1;
        for (int i6 = 0; i6 < 8; i6++) {
            MatrixUtil.buildMatrix(bitArray, errorCorrectionLevel, version, i6, byteMatrix);
            int calculateMaskPenalty = calculateMaskPenalty(byteMatrix);
            if (calculateMaskPenalty < i4) {
                i5 = i6;
                i4 = calculateMaskPenalty;
            }
        }
        return i5;
    }

    public static Mode chooseMode(String str) {
        return chooseMode(str, null);
    }

    private static Version chooseVersion(int i4, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i5 = 1; i5 <= 40; i5++) {
            Version versionForNumber = Version.getVersionForNumber(i5);
            if (willFit(i4, versionForNumber, errorCorrectionLevel)) {
                return versionForNumber;
            }
        }
        throw new WriterException("Data too big");
    }

    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        return encode(str, errorCorrectionLevel, null);
    }

    static byte[] generateECBytes(byte[] bArr, int i4) {
        int length = bArr.length;
        int[] iArr = new int[length + i4];
        for (int i5 = 0; i5 < length; i5++) {
            iArr[i5] = bArr[i5] & 255;
        }
        new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256).encode(iArr, i4);
        byte[] bArr2 = new byte[i4];
        for (int i6 = 0; i6 < i4; i6++) {
            bArr2[i6] = (byte) iArr[length + i6];
        }
        return bArr2;
    }

    static int getAlphanumericCode(int i4) {
        int[] iArr = ALPHANUMERIC_TABLE;
        if (i4 < iArr.length) {
            return iArr[i4];
        }
        return -1;
    }

    static void getNumDataBytesAndNumECBytesForBlockID(int i4, int i5, int i6, int i7, int[] iArr, int[] iArr2) throws WriterException {
        if (i7 < i6) {
            int i8 = i4 % i6;
            int i9 = i6 - i8;
            int i10 = i4 / i6;
            int i11 = i10 + 1;
            int i12 = i5 / i6;
            int i13 = i12 + 1;
            int i14 = i10 - i12;
            int i15 = i11 - i13;
            if (i14 != i15) {
                throw new WriterException("EC bytes mismatch");
            }
            if (i6 != i9 + i8) {
                throw new WriterException("RS blocks mismatch");
            }
            if (i4 != ((i12 + i14) * i9) + ((i13 + i15) * i8)) {
                throw new WriterException("Total bytes mismatch");
            }
            if (i7 < i9) {
                iArr[0] = i12;
                iArr2[0] = i14;
                return;
            }
            iArr[0] = i13;
            iArr2[0] = i15;
            return;
        }
        throw new WriterException("Block ID too large");
    }

    static BitArray interleaveWithECBytes(BitArray bitArray, int i4, int i5, int i6) throws WriterException {
        if (bitArray.getSizeInBytes() == i5) {
            ArrayList<BlockPair> arrayList = new ArrayList(i6);
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                getNumDataBytesAndNumECBytesForBlockID(i4, i5, i6, i10, iArr, iArr2);
                int i11 = iArr[0];
                byte[] bArr = new byte[i11];
                bitArray.toBytes(i7 << 3, bArr, 0, i11);
                byte[] generateECBytes = generateECBytes(bArr, iArr2[0]);
                arrayList.add(new BlockPair(bArr, generateECBytes));
                i8 = Math.max(i8, i11);
                i9 = Math.max(i9, generateECBytes.length);
                i7 += iArr[0];
            }
            if (i5 == i7) {
                BitArray bitArray2 = new BitArray();
                for (int i12 = 0; i12 < i8; i12++) {
                    for (BlockPair blockPair : arrayList) {
                        byte[] dataBytes = blockPair.getDataBytes();
                        if (i12 < dataBytes.length) {
                            bitArray2.appendBits(dataBytes[i12], 8);
                        }
                    }
                }
                for (int i13 = 0; i13 < i9; i13++) {
                    for (BlockPair blockPair2 : arrayList) {
                        byte[] errorCorrectionBytes = blockPair2.getErrorCorrectionBytes();
                        if (i13 < errorCorrectionBytes.length) {
                            bitArray2.appendBits(errorCorrectionBytes[i13], 8);
                        }
                    }
                }
                if (i4 == bitArray2.getSizeInBytes()) {
                    return bitArray2;
                }
                throw new WriterException("Interleaving error: " + i4 + " and " + bitArray2.getSizeInBytes() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    private static boolean isOnlyDoubleByteKanji(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i4 = 0; i4 < length; i4 += 2) {
                int i5 = bytes[i4] & 255;
                if ((i5 < 129 || i5 > 159) && (i5 < 224 || i5 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static Version recommendVersion(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, BitArray bitArray, BitArray bitArray2) throws WriterException {
        return chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, Version.getVersionForNumber(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    static void terminateBits(int i4, BitArray bitArray) throws WriterException {
        int i5 = i4 << 3;
        if (bitArray.getSize() <= i5) {
            for (int i6 = 0; i6 < 4 && bitArray.getSize() < i5; i6++) {
                bitArray.appendBit(false);
            }
            int size = bitArray.getSize() & 7;
            if (size > 0) {
                while (size < 8) {
                    bitArray.appendBit(false);
                    size++;
                }
            }
            int sizeInBytes = i4 - bitArray.getSizeInBytes();
            for (int i7 = 0; i7 < sizeInBytes; i7++) {
                bitArray.appendBits((i7 & 1) == 0 ? 236 : 17, 8);
            }
            if (bitArray.getSize() != i5) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + bitArray.getSize() + " > " + i5);
    }

    private static boolean willFit(int i4, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        return version.getTotalCodewords() - version.getECBlocksForLevel(errorCorrectionLevel).getTotalECCodewords() >= (i4 + 7) / 8;
    }

    private static Mode chooseMode(String str, String str2) {
        if ("Shift_JIS".equals(str2) && isOnlyDoubleByteKanji(str)) {
            return Mode.KANJI;
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (charAt >= '0' && charAt <= '9') {
                z4 = true;
            } else if (getAlphanumericCode(charAt) == -1) {
                return Mode.BYTE;
            } else {
                z3 = true;
            }
        }
        if (z3) {
            return Mode.ALPHANUMERIC;
        }
        if (z4) {
            return Mode.NUMERIC;
        }
        return Mode.BYTE;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.zxing.qrcode.encoder.QRCode encode(java.lang.String r6, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r7, java.util.Map<com.google.zxing.EncodeHintType, ?> r8) throws com.google.zxing.WriterException {
        /*
            java.lang.String r0 = "ISO-8859-1"
            if (r8 == 0) goto L15
            com.google.zxing.EncodeHintType r1 = com.google.zxing.EncodeHintType.CHARACTER_SET
            boolean r2 = r8.containsKey(r1)
            if (r2 == 0) goto L15
            java.lang.Object r1 = r8.get(r1)
            java.lang.String r1 = r1.toString()
            goto L16
        L15:
            r1 = r0
        L16:
            com.google.zxing.qrcode.decoder.Mode r2 = chooseMode(r6, r1)
            com.google.zxing.common.BitArray r3 = new com.google.zxing.common.BitArray
            r3.<init>()
            com.google.zxing.qrcode.decoder.Mode r4 = com.google.zxing.qrcode.decoder.Mode.BYTE
            if (r2 != r4) goto L32
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L32
            com.google.zxing.common.CharacterSetECI r0 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByName(r1)
            if (r0 == 0) goto L32
            appendECI(r0, r3)
        L32:
            appendModeInfo(r2, r3)
            com.google.zxing.common.BitArray r0 = new com.google.zxing.common.BitArray
            r0.<init>()
            appendBytes(r6, r2, r0, r1)
            if (r8 == 0) goto L6a
            com.google.zxing.EncodeHintType r1 = com.google.zxing.EncodeHintType.QR_VERSION
            boolean r5 = r8.containsKey(r1)
            if (r5 == 0) goto L6a
            java.lang.Object r8 = r8.get(r1)
            java.lang.String r8 = r8.toString()
            int r8 = java.lang.Integer.parseInt(r8)
            com.google.zxing.qrcode.decoder.Version r8 = com.google.zxing.qrcode.decoder.Version.getVersionForNumber(r8)
            int r1 = calculateBitsNeeded(r2, r3, r0, r8)
            boolean r1 = willFit(r1, r8, r7)
            if (r1 == 0) goto L62
            goto L6e
        L62:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Data too big for requested version"
            r6.<init>(r7)
            throw r6
        L6a:
            com.google.zxing.qrcode.decoder.Version r8 = recommendVersion(r7, r2, r3, r0)
        L6e:
            com.google.zxing.common.BitArray r1 = new com.google.zxing.common.BitArray
            r1.<init>()
            r1.appendBitArray(r3)
            if (r2 != r4) goto L7d
            int r6 = r0.getSizeInBytes()
            goto L81
        L7d:
            int r6 = r6.length()
        L81:
            appendLengthInfo(r6, r8, r2, r1)
            r1.appendBitArray(r0)
            com.google.zxing.qrcode.decoder.Version$ECBlocks r6 = r8.getECBlocksForLevel(r7)
            int r0 = r8.getTotalCodewords()
            int r3 = r6.getTotalECCodewords()
            int r0 = r0 - r3
            terminateBits(r0, r1)
            int r3 = r8.getTotalCodewords()
            int r6 = r6.getNumBlocks()
            com.google.zxing.common.BitArray r6 = interleaveWithECBytes(r1, r3, r0, r6)
            com.google.zxing.qrcode.encoder.QRCode r0 = new com.google.zxing.qrcode.encoder.QRCode
            r0.<init>()
            r0.setECLevel(r7)
            r0.setMode(r2)
            r0.setVersion(r8)
            int r1 = r8.getDimensionForVersion()
            com.google.zxing.qrcode.encoder.ByteMatrix r2 = new com.google.zxing.qrcode.encoder.ByteMatrix
            r2.<init>(r1, r1)
            int r1 = chooseMaskPattern(r6, r7, r8, r2)
            r0.setMaskPattern(r1)
            com.google.zxing.qrcode.encoder.MatrixUtil.buildMatrix(r6, r7, r8, r1, r2)
            r0.setMatrix(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.Encoder.encode(java.lang.String, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):com.google.zxing.qrcode.encoder.QRCode");
    }
}
