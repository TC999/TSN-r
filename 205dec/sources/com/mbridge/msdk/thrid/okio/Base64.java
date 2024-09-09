package com.mbridge.msdk.thrid.okio;

import java.io.UnsupportedEncodingException;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class Base64 {
    private static final byte[] MAP = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_MAP = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    private Base64() {
    }

    public static byte[] decode(String str) {
        int i4;
        char charAt;
        int length = str.length();
        while (length > 0 && ((charAt = str.charAt(length - 1)) == '=' || charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
            length--;
        }
        int i5 = (int) ((length * 6) / 8);
        byte[] bArr = new byte[i5];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            char charAt2 = str.charAt(i9);
            if (charAt2 >= 'A' && charAt2 <= 'Z') {
                i4 = charAt2 - 'A';
            } else if (charAt2 >= 'a' && charAt2 <= 'z') {
                i4 = charAt2 - 'G';
            } else if (charAt2 >= '0' && charAt2 <= '9') {
                i4 = charAt2 + 4;
            } else if (charAt2 == '+' || charAt2 == '-') {
                i4 = 62;
            } else if (charAt2 == '/' || charAt2 == '_') {
                i4 = 63;
            } else {
                if (charAt2 != '\n' && charAt2 != '\r' && charAt2 != ' ' && charAt2 != '\t') {
                    return null;
                }
            }
            i7 = (i7 << 6) | ((byte) i4);
            i6++;
            if (i6 % 4 == 0) {
                int i10 = i8 + 1;
                bArr[i8] = (byte) (i7 >> 16);
                int i11 = i10 + 1;
                bArr[i10] = (byte) (i7 >> 8);
                bArr[i11] = (byte) i7;
                i8 = i11 + 1;
            }
        }
        int i12 = i6 % 4;
        if (i12 == 1) {
            return null;
        }
        if (i12 == 2) {
            bArr[i8] = (byte) ((i7 << 12) >> 16);
            i8++;
        } else if (i12 == 3) {
            int i13 = i7 << 6;
            int i14 = i8 + 1;
            bArr[i8] = (byte) (i13 >> 16);
            i8 = i14 + 1;
            bArr[i14] = (byte) (i13 >> 8);
        }
        if (i8 == i5) {
            return bArr;
        }
        byte[] bArr2 = new byte[i8];
        System.arraycopy(bArr, 0, bArr2, 0, i8);
        return bArr2;
    }

    public static String encode(byte[] bArr) {
        return encode(bArr, MAP);
    }

    public static String encodeUrl(byte[] bArr) {
        return encode(bArr, URL_MAP);
    }

    private static String encode(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int i6 = i4 + 1;
            bArr3[i4] = bArr2[(bArr[i5] & 255) >> 2];
            int i7 = i6 + 1;
            int i8 = i5 + 1;
            bArr3[i6] = bArr2[((bArr[i5] & 3) << 4) | ((bArr[i8] & 255) >> 4)];
            int i9 = i7 + 1;
            int i10 = i5 + 2;
            bArr3[i7] = bArr2[((bArr[i8] & 15) << 2) | ((bArr[i10] & 255) >> 6)];
            i4 = i9 + 1;
            bArr3[i9] = bArr2[bArr[i10] & 63];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            int i11 = i4 + 1;
            bArr3[i4] = bArr2[(bArr[length] & 255) >> 2];
            int i12 = i11 + 1;
            bArr3[i11] = bArr2[(bArr[length] & 3) << 4];
            bArr3[i12] = 61;
            bArr3[i12 + 1] = 61;
        } else if (length2 == 2) {
            int i13 = i4 + 1;
            bArr3[i4] = bArr2[(bArr[length] & 255) >> 2];
            int i14 = i13 + 1;
            int i15 = length + 1;
            bArr3[i13] = bArr2[((bArr[i15] & 255) >> 4) | ((bArr[length] & 3) << 4)];
            bArr3[i14] = bArr2[(bArr[i15] & 15) << 2];
            bArr3[i14 + 1] = 61;
        }
        try {
            return new String(bArr3, "US-ASCII");
        } catch (UnsupportedEncodingException e4) {
            throw new AssertionError(e4);
        }
    }
}
