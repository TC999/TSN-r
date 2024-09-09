package com.google.zxing.oned;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class Code128Writer extends OneDimensionalCodeWriter {
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = '\u00f1';
    private static final char ESCAPE_FNC_2 = '\u00f2';
    private static final char ESCAPE_FNC_3 = '\u00f3';
    private static final char ESCAPE_FNC_4 = '\u00f4';

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static int chooseCode(CharSequence charSequence, int i4, int i5) {
        CType cType;
        CType findCType;
        CType findCType2;
        CType findCType3 = findCType(charSequence, i4);
        CType cType2 = CType.UNCODABLE;
        if (findCType3 != cType2 && findCType3 != (cType = CType.ONE_DIGIT)) {
            if (i5 == 99) {
                return i5;
            }
            if (i5 == 100) {
                CType cType3 = CType.FNC_1;
                if (findCType3 == cType3 || (findCType = findCType(charSequence, i4 + 2)) == cType2 || findCType == cType) {
                    return i5;
                }
                if (findCType == cType3) {
                    return findCType(charSequence, i4 + 3) == CType.TWO_DIGITS ? 99 : 100;
                }
                int i6 = i4 + 4;
                while (true) {
                    findCType2 = findCType(charSequence, i6);
                    if (findCType2 != CType.TWO_DIGITS) {
                        break;
                    }
                    i6 += 2;
                }
                return findCType2 == CType.ONE_DIGIT ? 100 : 99;
            }
            if (findCType3 == CType.FNC_1) {
                findCType3 = findCType(charSequence, i4 + 1);
            }
            if (findCType3 == CType.TWO_DIGITS) {
                return 99;
            }
        }
        return 100;
    }

    private static CType findCType(CharSequence charSequence, int i4) {
        int length = charSequence.length();
        if (i4 >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i4);
        if (charAt == '\u00f1') {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i5 = i4 + 1;
        if (i5 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i5);
        if (charAt2 >= '0' && charAt2 <= '9') {
            return CType.TWO_DIGITS;
        }
        return CType.ONE_DIGIT;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i4, int i5, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i4, i5, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length > 0 && length <= 80) {
            int i4 = 0;
            for (int i5 = 0; i5 < length; i5++) {
                char charAt = str.charAt(i5);
                if (charAt < ' ' || charAt > '~') {
                    switch (charAt) {
                        case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE /* 241 */:
                        case '\u00f2':
                        case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE /* 243 */:
                        case '\u00f4':
                            break;
                        default:
                            throw new IllegalArgumentException("Bad character in input: " + charAt);
                    }
                }
            }
            ArrayList<int[]> arrayList = new ArrayList();
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 1;
            while (i6 < length) {
                int chooseCode = chooseCode(str, i6, i8);
                int i10 = 100;
                if (chooseCode == i8) {
                    switch (str.charAt(i6)) {
                        case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE /* 241 */:
                            i10 = 102;
                            break;
                        case '\u00f2':
                            i10 = 97;
                            break;
                        case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE /* 243 */:
                            i10 = 96;
                            break;
                        case '\u00f4':
                            break;
                        default:
                            if (i8 != 100) {
                                i10 = Integer.parseInt(str.substring(i6, i6 + 2));
                                i6++;
                                break;
                            } else {
                                i10 = str.charAt(i6) - ' ';
                                break;
                            }
                    }
                    i6++;
                } else {
                    i10 = i8 == 0 ? chooseCode == 100 ? 104 : 105 : chooseCode;
                    i8 = chooseCode;
                }
                arrayList.add(Code128Reader.CODE_PATTERNS[i10]);
                i7 += i10 * i9;
                if (i6 != 0) {
                    i9++;
                }
            }
            int[][] iArr = Code128Reader.CODE_PATTERNS;
            arrayList.add(iArr[i7 % 103]);
            arrayList.add(iArr[106]);
            int i11 = 0;
            for (int[] iArr2 : arrayList) {
                for (int i12 : iArr2) {
                    i11 += i12;
                }
            }
            boolean[] zArr = new boolean[i11];
            for (int[] iArr3 : arrayList) {
                i4 += OneDimensionalCodeWriter.appendPattern(zArr, i4, iArr3, true);
            }
            return zArr;
        }
        throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
    }
}
