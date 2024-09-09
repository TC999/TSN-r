package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING;
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF8";

    static {
        String name = Charset.defaultCharset().name();
        PLATFORM_DEFAULT_ENCODING = name;
        ASSUME_SHIFT_JIS = "SJIS".equalsIgnoreCase(name) || "EUC_JP".equalsIgnoreCase(name);
    }

    private StringUtils() {
    }

    public static String guessEncoding(byte[] bArr, Map<DecodeHintType, ?> map) {
        byte[] bArr2 = bArr;
        if (map != null) {
            DecodeHintType decodeHintType = DecodeHintType.CHARACTER_SET;
            if (map.containsKey(decodeHintType)) {
                return map.get(decodeHintType).toString();
            }
        }
        int length = bArr2.length;
        boolean z3 = true;
        int i4 = 0;
        boolean z4 = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        int i5 = 0;
        boolean z5 = true;
        boolean z6 = true;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i6 < length && (z3 || z5 || z6)) {
            int i16 = bArr2[i6] & 255;
            if (z6) {
                if (i7 > 0) {
                    if ((i16 & 128) != 0) {
                        i7--;
                    }
                    z6 = false;
                } else if ((i16 & 128) != 0) {
                    if ((i16 & 64) != 0) {
                        i7++;
                        if ((i16 & 32) == 0) {
                            i9++;
                        } else {
                            i7++;
                            if ((i16 & 16) == 0) {
                                i10++;
                            } else {
                                i7++;
                                if ((i16 & 8) == 0) {
                                    i11++;
                                }
                            }
                        }
                    }
                    z6 = false;
                }
            }
            if (z3) {
                if (i16 > 127 && i16 < 160) {
                    z3 = false;
                } else if (i16 > 159 && (i16 < 192 || i16 == 215 || i16 == 247)) {
                    i13++;
                }
            }
            if (z5) {
                if (i8 > 0) {
                    if (i16 >= 64 && i16 != 127 && i16 <= 252) {
                        i8--;
                    }
                    z5 = false;
                } else {
                    if (i16 != 128 && i16 != 160 && i16 <= 239) {
                        if (i16 <= 160 || i16 >= 224) {
                            if (i16 > 127) {
                                i8++;
                                int i17 = i14 + 1;
                                if (i17 > i4) {
                                    i4 = i17;
                                    i14 = i4;
                                } else {
                                    i14 = i17;
                                }
                            } else {
                                i14 = 0;
                            }
                            i15 = 0;
                        } else {
                            i5++;
                            int i18 = i15 + 1;
                            if (i18 > i12) {
                                i12 = i18;
                                i15 = i12;
                            } else {
                                i15 = i18;
                            }
                            i14 = 0;
                        }
                    }
                    z5 = false;
                }
            }
            i6++;
            bArr2 = bArr;
        }
        if (z6 && i7 > 0) {
            z6 = false;
        }
        if (z5 && i8 > 0) {
            z5 = false;
        }
        return (!z6 || (!z4 && (i9 + i10) + i11 <= 0)) ? (!z5 || (!ASSUME_SHIFT_JIS && i12 < 3 && i4 < 3)) ? (z3 && z5) ? (!(i12 == 2 && i5 == 2) && i13 * 10 < length) ? "ISO8859_1" : "SJIS" : z3 ? "ISO8859_1" : z5 ? "SJIS" : z6 ? "UTF8" : PLATFORM_DEFAULT_ENCODING : "SJIS" : "UTF8";
    }
}
