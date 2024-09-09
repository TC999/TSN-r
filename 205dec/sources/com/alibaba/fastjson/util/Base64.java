package com.alibaba.fastjson.util;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class Base64 {
    public static final char[] CA;
    public static final int[] IA;

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i4 = 0; i4 < length; i4++) {
            IA[CA[i4]] = i4;
        }
        IA[61] = 0;
    }

    public static byte[] decodeFast(char[] cArr, int i4, int i5) {
        int i6;
        int i7 = 0;
        if (i5 == 0) {
            return new byte[0];
        }
        int i8 = (i4 + i5) - 1;
        while (i4 < i8 && IA[cArr[i4]] < 0) {
            i4++;
        }
        while (i8 > 0 && IA[cArr[i8]] < 0) {
            i8--;
        }
        int i9 = cArr[i8] == '=' ? cArr[i8 + (-1)] == '=' ? 2 : 1 : 0;
        int i10 = (i8 - i4) + 1;
        if (i5 > 76) {
            i6 = (cArr[76] == '\r' ? i10 / 78 : 0) << 1;
        } else {
            i6 = 0;
        }
        int i11 = (((i10 - i6) * 6) >> 3) - i9;
        byte[] bArr = new byte[i11];
        int i12 = (i11 / 3) * 3;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i12) {
            int[] iArr = IA;
            int i15 = i4 + 1;
            int i16 = i15 + 1;
            int i17 = (iArr[cArr[i4]] << 18) | (iArr[cArr[i15]] << 12);
            int i18 = i16 + 1;
            int i19 = i17 | (iArr[cArr[i16]] << 6);
            int i20 = i18 + 1;
            int i21 = i19 | iArr[cArr[i18]];
            int i22 = i13 + 1;
            bArr[i13] = (byte) (i21 >> 16);
            int i23 = i22 + 1;
            bArr[i22] = (byte) (i21 >> 8);
            int i24 = i23 + 1;
            bArr[i23] = (byte) i21;
            if (i6 <= 0 || (i14 = i14 + 1) != 19) {
                i4 = i20;
            } else {
                i4 = i20 + 2;
                i14 = 0;
            }
            i13 = i24;
        }
        if (i13 < i11) {
            int i25 = 0;
            while (i4 <= i8 - i9) {
                i7 |= IA[cArr[i4]] << (18 - (i25 * 6));
                i25++;
                i4++;
            }
            int i26 = 16;
            while (i13 < i11) {
                bArr[i13] = (byte) (i7 >> i26);
                i26 -= 8;
                i13++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str, int i4, int i5) {
        int i6;
        int i7 = 0;
        if (i5 == 0) {
            return new byte[0];
        }
        int i8 = (i4 + i5) - 1;
        while (i4 < i8 && IA[str.charAt(i4)] < 0) {
            i4++;
        }
        while (i8 > 0 && IA[str.charAt(i8)] < 0) {
            i8--;
        }
        int i9 = str.charAt(i8) == '=' ? str.charAt(i8 + (-1)) == '=' ? 2 : 1 : 0;
        int i10 = (i8 - i4) + 1;
        if (i5 > 76) {
            i6 = (str.charAt(76) == '\r' ? i10 / 78 : 0) << 1;
        } else {
            i6 = 0;
        }
        int i11 = (((i10 - i6) * 6) >> 3) - i9;
        byte[] bArr = new byte[i11];
        int i12 = (i11 / 3) * 3;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i12) {
            int[] iArr = IA;
            int i15 = i4 + 1;
            int i16 = i15 + 1;
            int i17 = (iArr[str.charAt(i4)] << 18) | (iArr[str.charAt(i15)] << 12);
            int i18 = i16 + 1;
            int i19 = i17 | (iArr[str.charAt(i16)] << 6);
            int i20 = i18 + 1;
            int i21 = i19 | iArr[str.charAt(i18)];
            int i22 = i13 + 1;
            bArr[i13] = (byte) (i21 >> 16);
            int i23 = i22 + 1;
            bArr[i22] = (byte) (i21 >> 8);
            int i24 = i23 + 1;
            bArr[i23] = (byte) i21;
            if (i6 <= 0 || (i14 = i14 + 1) != 19) {
                i4 = i20;
            } else {
                i4 = i20 + 2;
                i14 = 0;
            }
            i13 = i24;
        }
        if (i13 < i11) {
            int i25 = 0;
            while (i4 <= i8 - i9) {
                i7 |= IA[str.charAt(i4)] << (18 - (i25 * 6));
                i25++;
                i4++;
            }
            int i26 = 16;
            while (i13 < i11) {
                bArr[i13] = (byte) (i7 >> i26);
                i26 -= 8;
                i13++;
            }
        }
        return bArr;
    }

    public static byte[] decodeFast(String str) {
        int i4;
        int length = str.length();
        int i5 = 0;
        if (length == 0) {
            return new byte[0];
        }
        int i6 = length - 1;
        int i7 = 0;
        while (i7 < i6 && IA[str.charAt(i7) & '\u00ff'] < 0) {
            i7++;
        }
        while (i6 > 0 && IA[str.charAt(i6) & '\u00ff'] < 0) {
            i6--;
        }
        int i8 = str.charAt(i6) == '=' ? str.charAt(i6 + (-1)) == '=' ? 2 : 1 : 0;
        int i9 = (i6 - i7) + 1;
        if (length > 76) {
            i4 = (str.charAt(76) == '\r' ? i9 / 78 : 0) << 1;
        } else {
            i4 = 0;
        }
        int i10 = (((i9 - i4) * 6) >> 3) - i8;
        byte[] bArr = new byte[i10];
        int i11 = (i10 / 3) * 3;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int[] iArr = IA;
            int i14 = i7 + 1;
            int i15 = i14 + 1;
            int i16 = (iArr[str.charAt(i7)] << 18) | (iArr[str.charAt(i14)] << 12);
            int i17 = i15 + 1;
            int i18 = i16 | (iArr[str.charAt(i15)] << 6);
            int i19 = i17 + 1;
            int i20 = i18 | iArr[str.charAt(i17)];
            int i21 = i12 + 1;
            bArr[i12] = (byte) (i20 >> 16);
            int i22 = i21 + 1;
            bArr[i21] = (byte) (i20 >> 8);
            int i23 = i22 + 1;
            bArr[i22] = (byte) i20;
            if (i4 <= 0 || (i13 = i13 + 1) != 19) {
                i7 = i19;
            } else {
                i7 = i19 + 2;
                i13 = 0;
            }
            i12 = i23;
        }
        if (i12 < i10) {
            int i24 = 0;
            while (i7 <= i6 - i8) {
                i5 |= IA[str.charAt(i7)] << (18 - (i24 * 6));
                i24++;
                i7++;
            }
            int i25 = 16;
            while (i12 < i10) {
                bArr[i12] = (byte) (i5 >> i25);
                i25 -= 8;
                i12++;
            }
        }
        return bArr;
    }
}
