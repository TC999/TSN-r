package com.google.zxing.oned;

import cn.bluemobi.dylan.http.BuildConfig;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
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
    private static final char ESCAPE_FNC_1 = 241;
    private static final char ESCAPE_FNC_2 = 242;
    private static final char ESCAPE_FNC_3 = 243;
    private static final char ESCAPE_FNC_4 = 244;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static int chooseCode(CharSequence charSequence, int i, int i2) {
        CType cType;
        CType findCType;
        CType findCType2;
        CType findCType3 = findCType(charSequence, i);
        CType cType2 = CType.UNCODABLE;
        if (findCType3 != cType2 && findCType3 != (cType = CType.ONE_DIGIT)) {
            if (i2 == 99) {
                return i2;
            }
            if (i2 == 100) {
                CType cType3 = CType.FNC_1;
                if (findCType3 == cType3 || (findCType = findCType(charSequence, i + 2)) == cType2 || findCType == cType) {
                    return i2;
                }
                if (findCType == cType3) {
                    return findCType(charSequence, i + 3) == CType.TWO_DIGITS ? 99 : 100;
                }
                int i3 = i + 4;
                while (true) {
                    findCType2 = findCType(charSequence, i3);
                    if (findCType2 != CType.TWO_DIGITS) {
                        break;
                    }
                    i3 += 2;
                }
                return findCType2 == CType.ONE_DIGIT ? 100 : 99;
            }
            if (findCType3 == CType.FNC_1) {
                findCType3 = findCType(charSequence, i + 1);
            }
            if (findCType3 == CType.TWO_DIGITS) {
                return 99;
            }
        }
        return 100;
    }

    private static CType findCType(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        int i2 = i + 1;
        if (i2 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i2);
        if (charAt2 >= '0' && charAt2 <= '9') {
            return CType.TWO_DIGITS;
        }
        return CType.ONE_DIGIT;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        int length = str.length();
        if (length > 0 && length <= 80) {
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt < ' ' || charAt > '~') {
                    switch (charAt) {
                        case 241:
                        case BuildConfig.VERSION_CODE /* 242 */:
                        case 243:
                        case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE /* 244 */:
                            break;
                        default:
                            throw new IllegalArgumentException("Bad character in input: " + charAt);
                    }
                }
            }
            ArrayList<int[]> arrayList = new ArrayList();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 1;
            while (i3 < length) {
                int chooseCode = chooseCode(str, i3, i5);
                int i7 = 100;
                if (chooseCode == i5) {
                    switch (str.charAt(i3)) {
                        case 241:
                            i7 = 102;
                            break;
                        case BuildConfig.VERSION_CODE /* 242 */:
                            i7 = 97;
                            break;
                        case 243:
                            i7 = 96;
                            break;
                        case IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE /* 244 */:
                            break;
                        default:
                            if (i5 != 100) {
                                i7 = Integer.parseInt(str.substring(i3, i3 + 2));
                                i3++;
                                break;
                            } else {
                                i7 = str.charAt(i3) - ' ';
                                break;
                            }
                    }
                    i3++;
                } else {
                    i7 = i5 == 0 ? chooseCode == 100 ? 104 : 105 : chooseCode;
                    i5 = chooseCode;
                }
                arrayList.add(Code128Reader.CODE_PATTERNS[i7]);
                i4 += i7 * i6;
                if (i3 != 0) {
                    i6++;
                }
            }
            int[][] iArr = Code128Reader.CODE_PATTERNS;
            arrayList.add(iArr[i4 % 103]);
            arrayList.add(iArr[106]);
            int i8 = 0;
            for (int[] iArr2 : arrayList) {
                for (int i9 : iArr2) {
                    i8 += i9;
                }
            }
            boolean[] zArr = new boolean[i8];
            for (int[] iArr3 : arrayList) {
                i += OneDimensionalCodeWriter.appendPattern(zArr, i, iArr3, true);
            }
            return zArr;
        }
        throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
    }
}
