package com.google.zxing.pdf417.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class PDF417HighLevelEncoder {
    private static final int BYTE_COMPACTION = 1;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final int LATCH_TO_BYTE = 924;
    private static final int LATCH_TO_BYTE_PADDED = 901;
    private static final int LATCH_TO_NUMERIC = 902;
    private static final int LATCH_TO_TEXT = 900;
    private static final byte[] MIXED;
    private static final int NUMERIC_COMPACTION = 2;
    private static final int SHIFT_TO_BYTE = 913;
    private static final int SUBMODE_ALPHA = 0;
    private static final int SUBMODE_LOWER = 1;
    private static final int SUBMODE_MIXED = 2;
    private static final int SUBMODE_PUNCTUATION = 3;
    private static final int TEXT_COMPACTION = 0;
    private static final byte[] TEXT_MIXED_RAW = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};
    private static final byte[] TEXT_PUNCTUATION_RAW = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};
    private static final byte[] PUNCTUATION = new byte[128];
    private static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");

    static {
        byte[] bArr = new byte[128];
        MIXED = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i4 = 0;
        int i5 = 0;
        while (true) {
            byte[] bArr2 = TEXT_MIXED_RAW;
            if (i5 >= bArr2.length) {
                break;
            }
            byte b4 = bArr2[i5];
            if (b4 > 0) {
                MIXED[b4] = (byte) i5;
            }
            i5++;
        }
        Arrays.fill(PUNCTUATION, (byte) -1);
        while (true) {
            byte[] bArr3 = TEXT_PUNCTUATION_RAW;
            if (i4 >= bArr3.length) {
                return;
            }
            byte b5 = bArr3[i4];
            if (b5 > 0) {
                PUNCTUATION[b5] = (byte) i4;
            }
            i4++;
        }
    }

    private PDF417HighLevelEncoder() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
        return r1 - r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int determineConsecutiveBinaryCount(java.lang.String r5, int r6, java.nio.charset.Charset r7) throws com.google.zxing.WriterException {
        /*
            java.nio.charset.CharsetEncoder r7 = r7.newEncoder()
            int r0 = r5.length()
            r1 = r6
        L9:
            if (r1 >= r0) goto L57
            char r2 = r5.charAt(r1)
            r3 = 0
        L10:
            r4 = 13
            if (r3 >= r4) goto L25
            boolean r2 = isDigit(r2)
            if (r2 == 0) goto L25
            int r3 = r3 + 1
            int r2 = r1 + r3
            if (r2 >= r0) goto L25
            char r2 = r5.charAt(r2)
            goto L10
        L25:
            if (r3 < r4) goto L29
            int r1 = r1 - r6
            return r1
        L29:
            char r2 = r5.charAt(r1)
            boolean r3 = r7.canEncode(r2)
            if (r3 == 0) goto L36
            int r1 = r1 + 1
            goto L9
        L36:
            com.google.zxing.WriterException r5 = new com.google.zxing.WriterException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Non-encodable character detected: "
            r6.<init>(r7)
            r6.append(r2)
            java.lang.String r7 = " (Unicode: "
            r6.append(r7)
            r6.append(r2)
            r7 = 41
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L57:
            int r1 = r1 - r6
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.determineConsecutiveBinaryCount(java.lang.String, int, java.nio.charset.Charset):int");
    }

    private static int determineConsecutiveDigitCount(CharSequence charSequence, int i4) {
        int length = charSequence.length();
        int i5 = 0;
        if (i4 < length) {
            char charAt = charSequence.charAt(i4);
            while (isDigit(charAt) && i4 < length) {
                i5++;
                i4++;
                if (i4 < length) {
                    charAt = charSequence.charAt(i4);
                }
            }
        }
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        return (r1 - r7) - r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int determineConsecutiveTextCount(java.lang.CharSequence r6, int r7) {
        /*
            int r0 = r6.length()
            r1 = r7
        L5:
            if (r1 >= r0) goto L37
            char r2 = r6.charAt(r1)
            r3 = 0
        Lc:
            r4 = 13
            if (r3 >= r4) goto L23
            boolean r5 = isDigit(r2)
            if (r5 == 0) goto L23
            if (r1 >= r0) goto L23
            int r3 = r3 + 1
            int r1 = r1 + 1
            if (r1 >= r0) goto Lc
            char r2 = r6.charAt(r1)
            goto Lc
        L23:
            if (r3 < r4) goto L28
            int r1 = r1 - r7
            int r1 = r1 - r3
            return r1
        L28:
            if (r3 > 0) goto L5
            char r2 = r6.charAt(r1)
            boolean r2 = isText(r2)
            if (r2 == 0) goto L37
            int r1 = r1 + 1
            goto L5
        L37:
            int r1 = r1 - r7
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.determineConsecutiveTextCount(java.lang.CharSequence, int):int");
    }

    private static void encodeBinary(byte[] bArr, int i4, int i5, int i6, StringBuilder sb) {
        int i7;
        if (i5 == 1 && i6 == 0) {
            sb.append('\u0391');
        } else if (i5 % 6 == 0) {
            sb.append('\u039c');
        } else {
            sb.append('\u0385');
        }
        if (i5 >= 6) {
            char[] cArr = new char[5];
            i7 = i4;
            while ((i4 + i5) - i7 >= 6) {
                long j4 = 0;
                for (int i8 = 0; i8 < 6; i8++) {
                    j4 = (j4 << 8) + (bArr[i7 + i8] & 255);
                }
                for (int i9 = 0; i9 < 5; i9++) {
                    cArr[i9] = (char) (j4 % 900);
                    j4 /= 900;
                }
                for (int i10 = 4; i10 >= 0; i10--) {
                    sb.append(cArr[i10]);
                }
                i7 += 6;
            }
        } else {
            i7 = i4;
        }
        while (i7 < i4 + i5) {
            sb.append((char) (bArr[i7] & 255));
            i7++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String encodeHighLevel(String str, Compaction compaction, Charset charset) throws WriterException {
        CharacterSetECI characterSetECIByName;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = DEFAULT_ENCODING;
        } else if (!DEFAULT_ENCODING.equals(charset) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(charset.name())) != null) {
            encodingECI(characterSetECIByName.getValue(), sb);
        }
        int length = str.length();
        if (compaction == Compaction.TEXT) {
            encodeText(str, 0, length, sb, 0);
        } else if (compaction == Compaction.BYTE) {
            byte[] bytes = str.getBytes(charset);
            encodeBinary(bytes, 0, bytes.length, 1, sb);
        } else if (compaction == Compaction.NUMERIC) {
            sb.append('\u0386');
            encodeNumeric(str, 0, length, sb);
        } else {
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i4 < length) {
                int determineConsecutiveDigitCount = determineConsecutiveDigitCount(str, i4);
                if (determineConsecutiveDigitCount >= 13) {
                    sb.append('\u0386');
                    i6 = 2;
                    encodeNumeric(str, i4, determineConsecutiveDigitCount, sb);
                    i4 += determineConsecutiveDigitCount;
                    i5 = 0;
                } else {
                    int determineConsecutiveTextCount = determineConsecutiveTextCount(str, i4);
                    if (determineConsecutiveTextCount < 5 && determineConsecutiveDigitCount != length) {
                        int determineConsecutiveBinaryCount = determineConsecutiveBinaryCount(str, i4, charset);
                        if (determineConsecutiveBinaryCount == 0) {
                            determineConsecutiveBinaryCount = 1;
                        }
                        int i7 = determineConsecutiveBinaryCount + i4;
                        byte[] bytes2 = str.substring(i4, i7).getBytes(charset);
                        if (bytes2.length == 1 && i6 == 0) {
                            encodeBinary(bytes2, 0, 1, 0, sb);
                        } else {
                            encodeBinary(bytes2, 0, bytes2.length, i6, sb);
                            i5 = 0;
                            i6 = 1;
                        }
                        i4 = i7;
                    } else {
                        if (i6 != 0) {
                            sb.append('\u0384');
                            i5 = 0;
                            i6 = 0;
                        }
                        i5 = encodeText(str, i4, determineConsecutiveTextCount, sb, i5);
                        i4 += determineConsecutiveTextCount;
                    }
                }
            }
        }
        return sb.toString();
    }

    private static void encodeNumeric(String str, int i4, int i5, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i5 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900L);
        BigInteger valueOf2 = BigInteger.valueOf(0L);
        int i6 = 0;
        while (i6 < i5) {
            sb2.setLength(0);
            int min = Math.min(44, i5 - i6);
            StringBuilder sb3 = new StringBuilder("1");
            int i7 = i4 + i6;
            sb3.append(str.substring(i7, i7 + min));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i6 += min;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x00f6 A[EDGE_INSN: B:76:0x00f6->B:55:0x00f6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0011 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int encodeText(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.encodeText(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    private static void encodingECI(int i4, StringBuilder sb) throws WriterException {
        if (i4 >= 0 && i4 < 900) {
            sb.append('\u039f');
            sb.append((char) i4);
        } else if (i4 < 810900) {
            sb.append('\u039e');
            sb.append((char) ((i4 / 900) - 1));
            sb.append((char) (i4 % 900));
        } else if (i4 < 811800) {
            sb.append('\u039d');
            sb.append((char) (810900 - i4));
        } else {
            throw new WriterException("ECI number not in valid range from 0..811799, but was " + i4);
        }
    }

    private static boolean isAlphaLower(char c4) {
        if (c4 != ' ') {
            return c4 >= 'a' && c4 <= 'z';
        }
        return true;
    }

    private static boolean isAlphaUpper(char c4) {
        if (c4 != ' ') {
            return c4 >= 'A' && c4 <= 'Z';
        }
        return true;
    }

    private static boolean isDigit(char c4) {
        return c4 >= '0' && c4 <= '9';
    }

    private static boolean isMixed(char c4) {
        return MIXED[c4] != -1;
    }

    private static boolean isPunctuation(char c4) {
        return PUNCTUATION[c4] != -1;
    }

    private static boolean isText(char c4) {
        if (c4 == '\t' || c4 == '\n' || c4 == '\r') {
            return true;
        }
        return c4 >= ' ' && c4 <= '~';
    }
}
