package com.google.zxing.pdf417.decoder;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.FormatException;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = valueOf;
        int i4 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i4 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i4] = bigIntegerArr2[i4 - 1].multiply(valueOf);
            i4++;
        }
    }

    private DecodedBitStreamParser() {
    }

    private static int byteCompaction(int i4, int[] iArr, Charset charset, int i5, StringBuilder sb) {
        int i6;
        int i7;
        int i8;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i9 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT;
        int i10 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE;
        int i11 = 928;
        int i12 = 902;
        long j4 = 900;
        if (i4 == 901) {
            int[] iArr2 = new int[6];
            i6 = i5 + 1;
            int i13 = iArr[i5];
            boolean z3 = false;
            loop0: while (true) {
                i7 = 0;
                long j5 = 0;
                while (i6 < iArr[0] && !z3) {
                    int i14 = i7 + 1;
                    iArr2[i7] = i13;
                    j5 = (j5 * j4) + i13;
                    int i15 = i6 + 1;
                    i13 = iArr[i6];
                    if (i13 == 900 || i13 == 901 || i13 == 902 || i13 == 924 || i13 == 928 || i13 == i10 || i13 == i9) {
                        i6 = i15 - 1;
                        i7 = i14;
                        i9 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT;
                        i10 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE;
                        j4 = 900;
                        z3 = true;
                    } else if (i14 % 5 != 0 || i14 <= 0) {
                        i6 = i15;
                        i7 = i14;
                        i9 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT;
                        i10 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE;
                        j4 = 900;
                    } else {
                        int i16 = 0;
                        while (i16 < 6) {
                            byteArrayOutputStream.write((byte) (j5 >> ((5 - i16) * 8)));
                            i16++;
                            i9 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT;
                            i10 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE;
                        }
                        i6 = i15;
                        j4 = 900;
                    }
                }
            }
            if (i6 != iArr[0] || i13 >= 900) {
                i8 = i7;
            } else {
                i8 = i7 + 1;
                iArr2[i7] = i13;
            }
            for (int i17 = 0; i17 < i8; i17++) {
                byteArrayOutputStream.write((byte) iArr2[i17]);
            }
        } else if (i4 == 924) {
            int i18 = i5;
            boolean z4 = false;
            int i19 = 0;
            long j6 = 0;
            while (i18 < iArr[0] && !z4) {
                int i20 = i18 + 1;
                int i21 = iArr[i18];
                if (i21 < 900) {
                    i19++;
                    j6 = (j6 * 900) + i21;
                    i18 = i20;
                } else {
                    if (i21 != 900 && i21 != 901 && i21 != i12 && i21 != 924 && i21 != i11) {
                        if (i21 != 923 && i21 != 922) {
                            i18 = i20;
                        }
                    }
                    i18 = i20 - 1;
                    z4 = true;
                }
                if (i19 % 5 == 0 && i19 > 0) {
                    for (int i22 = 0; i22 < 6; i22++) {
                        byteArrayOutputStream.write((byte) (j6 >> ((5 - i22) * 8)));
                    }
                    i19 = 0;
                    j6 = 0;
                }
                i11 = 928;
                i12 = 902;
            }
            i6 = i18;
        } else {
            i6 = i5;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.zxing.common.DecoderResult decode(int[] r6, java.lang.String r7) throws com.google.zxing.FormatException {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r6.length
            r2 = 1
            int r1 = r1 << r2
            r0.<init>(r1)
            java.nio.charset.Charset r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.DEFAULT_ENCODING
            r2 = r6[r2]
            com.google.zxing.pdf417.PDF417ResultMetadata r3 = new com.google.zxing.pdf417.PDF417ResultMetadata
            r3.<init>()
            r4 = 2
        L12:
            r5 = 0
            r5 = r6[r5]
            if (r4 >= r5) goto L6d
            r5 = 913(0x391, float:1.28E-42)
            if (r2 == r5) goto L58
            switch(r2) {
                case 900: goto L53;
                case 901: goto L4e;
                case 902: goto L49;
                default: goto L1e;
            }
        L1e:
            switch(r2) {
                case 922: goto L44;
                case 923: goto L44;
                case 924: goto L4e;
                case 925: goto L41;
                case 926: goto L3e;
                case 927: goto L2d;
                case 928: goto L28;
                default: goto L21;
            }
        L21:
            int r4 = r4 + (-1)
            int r2 = textCompaction(r6, r4, r0)
            goto L60
        L28:
            int r2 = decodeMacroBlock(r6, r4, r3)
            goto L60
        L2d:
            int r2 = r4 + 1
            r1 = r6[r4]
            com.google.zxing.common.CharacterSetECI r1 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByValue(r1)
            java.lang.String r1 = r1.name()
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            goto L60
        L3e:
            int r2 = r4 + 2
            goto L60
        L41:
            int r2 = r4 + 1
            goto L60
        L44:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        L49:
            int r2 = numericCompaction(r6, r4, r0)
            goto L60
        L4e:
            int r2 = byteCompaction(r2, r6, r1, r4, r0)
            goto L60
        L53:
            int r2 = textCompaction(r6, r4, r0)
            goto L60
        L58:
            int r2 = r4 + 1
            r4 = r6[r4]
            char r4 = (char) r4
            r0.append(r4)
        L60:
            int r4 = r6.length
            if (r2 >= r4) goto L68
            int r4 = r2 + 1
            r2 = r6[r2]
            goto L12
        L68:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        L6d:
            int r6 = r0.length()
            if (r6 == 0) goto L81
            com.google.zxing.common.DecoderResult r6 = new com.google.zxing.common.DecoderResult
            java.lang.String r0 = r0.toString()
            r1 = 0
            r6.<init>(r1, r0, r1, r7)
            r6.setOther(r3)
            return r6
        L81:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            goto L87
        L86:
            throw r6
        L87:
            goto L86
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decode(int[], java.lang.String):com.google.zxing.common.DecoderResult");
    }

    private static String decodeBase900toBase10(int[] iArr, int i4) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i5 = 0; i5 < i4; i5++) {
            bigInteger = bigInteger.add(EXP900[(i4 - i5) - 1].multiply(BigInteger.valueOf(iArr[i5])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    private static int decodeMacroBlock(int[] iArr, int i4, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i4 + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i5 = 0;
            while (i5 < 2) {
                iArr2[i5] = iArr[i4];
                i5++;
                i4++;
            }
            pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int textCompaction = textCompaction(iArr, i4, sb);
            pDF417ResultMetadata.setFileId(sb.toString());
            if (iArr[textCompaction] == 923) {
                int i6 = textCompaction + 1;
                int[] iArr3 = new int[iArr[0] - i6];
                boolean z3 = false;
                int i7 = 0;
                while (i6 < iArr[0] && !z3) {
                    int i8 = i6 + 1;
                    int i9 = iArr[i6];
                    if (i9 < 900) {
                        iArr3[i7] = i9;
                        i6 = i8;
                        i7++;
                    } else if (i9 == 922) {
                        pDF417ResultMetadata.setLastSegment(true);
                        i6 = i8 + 1;
                        z3 = true;
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
                pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i7));
                return i6;
            } else if (iArr[textCompaction] == 922) {
                pDF417ResultMetadata.setLastSegment(true);
                return textCompaction + 1;
            } else {
                return textCompaction;
            }
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void decodeTextCompaction(int[] iArr, int[] iArr2, int i4, StringBuilder sb) {
        Mode mode;
        int i5;
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = mode2;
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = iArr[i6];
            char c4 = ' ';
            switch (AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[mode2.ordinal()]) {
                case 1:
                    if (i7 < 26) {
                        i5 = i7 + 65;
                        c4 = (char) i5;
                        break;
                    } else if (i7 != 26) {
                        if (i7 == 27) {
                            mode2 = Mode.LOWER;
                        } else if (i7 == 28) {
                            mode2 = Mode.MIXED;
                        } else if (i7 == 29) {
                            mode = Mode.PUNCT_SHIFT;
                            c4 = 0;
                            Mode mode4 = mode;
                            mode3 = mode2;
                            mode2 = mode4;
                            break;
                        } else if (i7 == 913) {
                            sb.append((char) iArr2[i6]);
                        } else if (i7 == 900) {
                            mode2 = Mode.ALPHA;
                        }
                        c4 = 0;
                        break;
                    }
                    break;
                case 2:
                    if (i7 < 26) {
                        i5 = i7 + 97;
                        c4 = (char) i5;
                        break;
                    } else if (i7 != 26) {
                        if (i7 != 27) {
                            if (i7 == 28) {
                                mode2 = Mode.MIXED;
                            } else if (i7 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                            } else if (i7 == 913) {
                                sb.append((char) iArr2[i6]);
                            } else if (i7 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                            c4 = 0;
                            break;
                        } else {
                            mode = Mode.ALPHA_SHIFT;
                        }
                        c4 = 0;
                        Mode mode42 = mode;
                        mode3 = mode2;
                        mode2 = mode42;
                        break;
                    }
                    break;
                case 3:
                    if (i7 < 25) {
                        c4 = MIXED_CHARS[i7];
                        break;
                    } else {
                        if (i7 == 25) {
                            mode2 = Mode.PUNCT;
                        } else if (i7 != 26) {
                            if (i7 == 27) {
                                mode2 = Mode.LOWER;
                            } else if (i7 == 28) {
                                mode2 = Mode.ALPHA;
                            } else if (i7 == 29) {
                                mode = Mode.PUNCT_SHIFT;
                                c4 = 0;
                                Mode mode422 = mode;
                                mode3 = mode2;
                                mode2 = mode422;
                                break;
                            } else if (i7 == 913) {
                                sb.append((char) iArr2[i6]);
                            } else if (i7 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                        }
                        c4 = 0;
                        break;
                    }
                    break;
                case 4:
                    if (i7 < 29) {
                        c4 = PUNCT_CHARS[i7];
                        break;
                    } else {
                        if (i7 == 29) {
                            mode2 = Mode.ALPHA;
                        } else if (i7 == 913) {
                            sb.append((char) iArr2[i6]);
                        } else if (i7 == 900) {
                            mode2 = Mode.ALPHA;
                        }
                        c4 = 0;
                        break;
                    }
                case 5:
                    if (i7 < 26) {
                        c4 = (char) (i7 + 65);
                    } else if (i7 != 26) {
                        if (i7 == 900) {
                            mode2 = Mode.ALPHA;
                            c4 = 0;
                            break;
                        }
                        mode2 = mode3;
                        c4 = 0;
                    }
                    mode2 = mode3;
                    break;
                case 6:
                    if (i7 < 29) {
                        c4 = PUNCT_CHARS[i7];
                        mode2 = mode3;
                        break;
                    } else {
                        if (i7 == 29) {
                            mode2 = Mode.ALPHA;
                        } else {
                            if (i7 == 913) {
                                sb.append((char) iArr2[i6]);
                            } else if (i7 == 900) {
                                mode2 = Mode.ALPHA;
                            }
                            mode2 = mode3;
                        }
                        c4 = 0;
                        break;
                    }
                default:
                    c4 = 0;
                    break;
            }
            if (c4 != 0) {
                sb.append(c4);
            }
        }
    }

    private static int numericCompaction(int[] iArr, int i4, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z3 = false;
        int i5 = 0;
        while (i4 < iArr[0] && !z3) {
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            if (i6 == iArr[0]) {
                z3 = true;
            }
            if (i7 < 900) {
                iArr2[i5] = i7;
                i5++;
            } else if (i7 == 900 || i7 == 901 || i7 == 924 || i7 == 928 || i7 == 923 || i7 == 922) {
                i6--;
                z3 = true;
            }
            if ((i5 % 15 == 0 || i7 == 902 || z3) && i5 > 0) {
                sb.append(decodeBase900toBase10(iArr2, i5));
                i5 = 0;
            }
            i4 = i6;
        }
        return i4;
    }

    private static int textCompaction(int[] iArr, int i4, StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] - i4) << 1];
        int[] iArr3 = new int[(iArr[0] - i4) << 1];
        boolean z3 = false;
        int i5 = 0;
        while (i4 < iArr[0] && !z3) {
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            if (i7 < 900) {
                iArr2[i5] = i7 / 30;
                iArr2[i5 + 1] = i7 % 30;
                i5 += 2;
            } else if (i7 != 913) {
                if (i7 != 928) {
                    switch (i7) {
                        case 900:
                            iArr2[i5] = 900;
                            i5++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i7) {
                            }
                    }
                }
                i4 = i6 - 1;
                z3 = true;
            } else {
                iArr2[i5] = 913;
                i4 = i6 + 1;
                iArr3[i5] = iArr[i6];
                i5++;
            }
            i4 = i6;
        }
        decodeTextCompaction(iArr2, iArr3, i5, sb);
        return i4;
    }
}
