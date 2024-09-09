package com.google.zxing.aztec.decoder;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class Decoder {
    private AztecDetectorResult ddata;
    private static final String[] UPPER_TABLE = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] LOWER_TABLE = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", CampaignEx.JSON_KEY_AD_Q, "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] MIXED_TABLE = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] PUNCT_TABLE = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", TTPathConst.sSeparator, ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] DIGIT_TABLE = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.google.zxing.aztec.decoder.Decoder$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table;

        static {
            int[] iArr = new int[Table.values().length];
            $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table = iArr;
            try {
                iArr[Table.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    static byte[] convertBoolArrayToByteArray(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            bArr[i4] = readByte(zArr, i4 << 3);
        }
        return bArr;
    }

    private boolean[] correctBits(boolean[] zArr) throws FormatException {
        GenericGF genericGF;
        int i4 = 8;
        if (this.ddata.getNbLayers() <= 2) {
            i4 = 6;
            genericGF = GenericGF.AZTEC_DATA_6;
        } else if (this.ddata.getNbLayers() <= 8) {
            genericGF = GenericGF.AZTEC_DATA_8;
        } else if (this.ddata.getNbLayers() <= 22) {
            i4 = 10;
            genericGF = GenericGF.AZTEC_DATA_10;
        } else {
            i4 = 12;
            genericGF = GenericGF.AZTEC_DATA_12;
        }
        int nbDatablocks = this.ddata.getNbDatablocks();
        int length = zArr.length / i4;
        if (length >= nbDatablocks) {
            int length2 = zArr.length % i4;
            int[] iArr = new int[length];
            int i5 = 0;
            while (i5 < length) {
                iArr[i5] = readCode(zArr, length2, i4);
                i5++;
                length2 += i4;
            }
            try {
                new ReedSolomonDecoder(genericGF).decode(iArr, length - nbDatablocks);
                int i6 = (1 << i4) - 1;
                int i7 = 0;
                for (int i8 = 0; i8 < nbDatablocks; i8++) {
                    int i9 = iArr[i8];
                    if (i9 == 0 || i9 == i6) {
                        throw FormatException.getFormatInstance();
                    }
                    if (i9 == 1 || i9 == i6 - 1) {
                        i7++;
                    }
                }
                boolean[] zArr2 = new boolean[(nbDatablocks * i4) - i7];
                int i10 = 0;
                for (int i11 = 0; i11 < nbDatablocks; i11++) {
                    int i12 = iArr[i11];
                    if (i12 == 1 || i12 == i6 - 1) {
                        Arrays.fill(zArr2, i10, (i10 + i4) - 1, i12 > 1);
                        i10 += i4 - 1;
                    } else {
                        int i13 = i4 - 1;
                        while (i13 >= 0) {
                            int i14 = i10 + 1;
                            zArr2[i10] = ((1 << i13) & i12) != 0;
                            i13--;
                            i10 = i14;
                        }
                    }
                }
                return zArr2;
            } catch (ReedSolomonException e4) {
                throw FormatException.getFormatInstance(e4);
            }
        }
        throw FormatException.getFormatInstance();
    }

    private boolean[] extractBits(BitMatrix bitMatrix) {
        boolean isCompact = this.ddata.isCompact();
        int nbLayers = this.ddata.getNbLayers();
        int i4 = (isCompact ? 11 : 14) + (nbLayers << 2);
        int[] iArr = new int[i4];
        boolean[] zArr = new boolean[totalBitsInLayer(nbLayers, isCompact)];
        int i5 = 2;
        if (isCompact) {
            for (int i6 = 0; i6 < i4; i6++) {
                iArr[i6] = i6;
            }
        } else {
            int i7 = i4 / 2;
            int i8 = ((i4 + 1) + (((i7 - 1) / 15) * 2)) / 2;
            for (int i9 = 0; i9 < i7; i9++) {
                int i10 = (i9 / 15) + i9;
                iArr[(i7 - i9) - 1] = (i8 - i10) - 1;
                iArr[i7 + i9] = i10 + i8 + 1;
            }
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < nbLayers) {
            int i13 = ((nbLayers - i11) << i5) + (isCompact ? 9 : 12);
            int i14 = i11 << 1;
            int i15 = (i4 - 1) - i14;
            int i16 = 0;
            while (i16 < i13) {
                int i17 = i16 << 1;
                int i18 = 0;
                while (i18 < i5) {
                    int i19 = i14 + i18;
                    int i20 = i14 + i16;
                    zArr[i12 + i17 + i18] = bitMatrix.get(iArr[i19], iArr[i20]);
                    int i21 = iArr[i20];
                    int i22 = i15 - i18;
                    boolean z3 = isCompact;
                    zArr[(i13 * 2) + i12 + i17 + i18] = bitMatrix.get(i21, iArr[i22]);
                    int i23 = i15 - i16;
                    zArr[(i13 * 4) + i12 + i17 + i18] = bitMatrix.get(iArr[i22], iArr[i23]);
                    zArr[(i13 * 6) + i12 + i17 + i18] = bitMatrix.get(iArr[i23], iArr[i19]);
                    i18++;
                    nbLayers = nbLayers;
                    isCompact = z3;
                    i5 = 2;
                }
                i16++;
                i5 = 2;
            }
            i12 += i13 << 3;
            i11++;
            i5 = 2;
        }
        return zArr;
    }

    private static String getCharacter(Table table, int i4) {
        int i5 = AnonymousClass1.$SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[table.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                        if (i5 == 5) {
                            return DIGIT_TABLE[i4];
                        }
                        throw new IllegalStateException("Bad table");
                    }
                    return PUNCT_TABLE[i4];
                }
                return MIXED_TABLE[i4];
            }
            return LOWER_TABLE[i4];
        }
        return UPPER_TABLE[i4];
    }

    private static String getEncodedData(boolean[] zArr) {
        int length = zArr.length;
        Table table = Table.UPPER;
        StringBuilder sb = new StringBuilder(20);
        Table table2 = table;
        int i4 = 0;
        while (i4 < length) {
            if (table != Table.BINARY) {
                int i5 = table == Table.DIGIT ? 4 : 5;
                if (length - i4 < i5) {
                    break;
                }
                int readCode = readCode(zArr, i4, i5);
                i4 += i5;
                String character = getCharacter(table, readCode);
                if (character.startsWith("CTRL_")) {
                    table2 = getTable(character.charAt(5));
                    if (character.charAt(6) != 'L') {
                        table2 = table;
                        table = table2;
                    }
                } else {
                    sb.append(character);
                }
                table = table2;
            } else if (length - i4 < 5) {
                break;
            } else {
                int readCode2 = readCode(zArr, i4, 5);
                i4 += 5;
                if (readCode2 == 0) {
                    if (length - i4 < 11) {
                        break;
                    }
                    readCode2 = readCode(zArr, i4, 11) + 31;
                    i4 += 11;
                }
                int i6 = 0;
                while (true) {
                    if (i6 >= readCode2) {
                        break;
                    } else if (length - i4 < 8) {
                        i4 = length;
                        break;
                    } else {
                        sb.append((char) readCode(zArr, i4, 8));
                        i4 += 8;
                        i6++;
                    }
                }
                table = table2;
            }
        }
        return sb.toString();
    }

    private static Table getTable(char c4) {
        if (c4 != 'B') {
            if (c4 != 'D') {
                if (c4 != 'P') {
                    if (c4 != 'L') {
                        if (c4 != 'M') {
                            return Table.UPPER;
                        }
                        return Table.MIXED;
                    }
                    return Table.LOWER;
                }
                return Table.PUNCT;
            }
            return Table.DIGIT;
        }
        return Table.BINARY;
    }

    public static String highLevelDecode(boolean[] zArr) {
        return getEncodedData(zArr);
    }

    private static byte readByte(boolean[] zArr, int i4) {
        int readCode;
        int length = zArr.length - i4;
        if (length >= 8) {
            readCode = readCode(zArr, i4, 8);
        } else {
            readCode = readCode(zArr, i4, length) << (8 - length);
        }
        return (byte) readCode;
    }

    private static int readCode(boolean[] zArr, int i4, int i5) {
        int i6 = 0;
        for (int i7 = i4; i7 < i4 + i5; i7++) {
            i6 <<= 1;
            if (zArr[i7]) {
                i6 |= 1;
            }
        }
        return i6;
    }

    private static int totalBitsInLayer(int i4, boolean z3) {
        return ((z3 ? 88 : 112) + (i4 << 4)) * i4;
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) throws FormatException {
        this.ddata = aztecDetectorResult;
        boolean[] correctBits = correctBits(extractBits(aztecDetectorResult.getBits()));
        DecoderResult decoderResult = new DecoderResult(convertBoolArrayToByteArray(correctBits), getEncodedData(correctBits), null, null);
        decoderResult.setNumBits(correctBits.length);
        return decoderResult;
    }
}
