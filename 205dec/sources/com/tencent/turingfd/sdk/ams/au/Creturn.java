package com.tencent.turingfd.sdk.ams.au;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.return  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Creturn {
    public static byte[] a() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            String a4 = Cextends.a(Cextends.D0);
            int[] iArr = {-36, -46, -45, -77, -22, -10, 47, -77, -72, -69, -32, 25, 21, -21, -6, -75, -71, 31, -39, -49, -49};
            for (int i4 = 0; i4 < a4.length(); i4++) {
                stringBuffer.append((char) (a4.charAt(i4) + iArr[i4]));
            }
            return stringBuffer.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        byte[] a4 = a(bArr2);
        if (bArr == null || a4 == null || bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length % 4 == 0 ? (bArr.length >>> 2) + 1 : (bArr.length >>> 2) + 2;
        int[] iArr = new int[length];
        a(bArr, iArr);
        int i4 = length - 1;
        iArr[i4] = bArr.length;
        int length2 = a4.length % 4 == 0 ? a4.length >>> 2 : (a4.length >>> 2) + 1;
        int i5 = length2 >= 4 ? length2 : 4;
        int[] iArr2 = new int[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            iArr2[i6] = 0;
        }
        a(a4, iArr2);
        int i7 = iArr[i4];
        int i8 = iArr[0];
        int i9 = (52 / (i4 + 1)) + 6;
        int i10 = 0;
        while (true) {
            int i11 = i9 - 1;
            if (i9 > 0) {
                i10 -= 1640531527;
                int i12 = (i10 >>> 2) & 3;
                int i13 = 0;
                while (i13 < i4) {
                    int i14 = i13 + 1;
                    int i15 = iArr[i14];
                    i7 = ((((i7 >>> 5) ^ (i15 << 2)) + ((i15 >>> 3) ^ (i7 << 4))) ^ ((i15 ^ i10) + (i7 ^ iArr2[(i13 & 3) ^ i12]))) + iArr[i13];
                    iArr[i13] = i7;
                    i13 = i14;
                }
                int i16 = iArr[0];
                i7 = ((((i7 >>> 5) ^ (i16 << 2)) + ((i16 >>> 3) ^ (i7 << 4))) ^ ((i16 ^ i10) + (i7 ^ iArr2[i12 ^ (i13 & 3)]))) + iArr[i4];
                iArr[i4] = i7;
                i9 = i11;
            } else {
                byte[] bArr3 = new byte[length << 2];
                a(iArr, length, bArr3);
                return bArr3;
            }
        }
    }

    public static void a(byte[] bArr, int[] iArr) {
        int length = bArr.length >> 2;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = i5 + 1;
            iArr[i4] = bArr[i5] & 255;
            int i7 = i6 + 1;
            iArr[i4] = iArr[i4] | ((bArr[i6] & 255) << 8);
            int i8 = i7 + 1;
            iArr[i4] = iArr[i4] | ((bArr[i7] & 255) << 16);
            iArr[i4] = iArr[i4] | ((bArr[i8] & 255) << 24);
            i4++;
            i5 = i8 + 1;
        }
        if (i5 < bArr.length) {
            int i9 = i5 + 1;
            iArr[i4] = bArr[i5] & 255;
            int i10 = 8;
            while (i9 < bArr.length) {
                iArr[i4] = iArr[i4] | ((bArr[i9] & 255) << i10);
                i9++;
                i10 += 8;
            }
        }
    }

    public static void a(int[] iArr, int i4, byte[] bArr) {
        int i5;
        int length = bArr.length >> 2;
        if (length > i4) {
            length = i4;
        }
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i5 = 8;
            if (i6 >= length) {
                break;
            }
            int i8 = i7 + 1;
            bArr[i7] = (byte) (iArr[i6] & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) ((iArr[i6] >>> 8) & 255);
            int i10 = i9 + 1;
            bArr[i9] = (byte) ((iArr[i6] >>> 16) & 255);
            i7 = i10 + 1;
            bArr[i10] = (byte) ((iArr[i6] >>> 24) & 255);
            i6++;
        }
        if (i4 <= length || i7 >= bArr.length) {
            return;
        }
        bArr[i7] = (byte) (iArr[i6] & 255);
        for (int i11 = i7 + 1; i5 <= 24 && i11 < bArr.length; i11++) {
            bArr[i11] = (byte) ((iArr[i6] >>> i5) & 255);
            i5 += 8;
        }
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length <= 16) {
            return bArr;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] a4 = a(bArr2);
        if (bArr == null || a4 == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr.length % 4 == 0 && bArr.length >= 8) {
            int length = bArr.length >>> 2;
            int[] iArr = new int[length];
            a(bArr, iArr);
            int length2 = a4.length % 4 == 0 ? a4.length >>> 2 : (a4.length >>> 2) + 1;
            int i4 = length2 >= 4 ? length2 : 4;
            int[] iArr2 = new int[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                iArr2[i5] = 0;
            }
            a(a4, iArr2);
            int i6 = length - 1;
            int i7 = iArr[i6];
            int i8 = iArr[0];
            for (int i9 = ((52 / (i6 + 1)) + 6) * (-1640531527); i9 != 0; i9 -= -1640531527) {
                int i10 = (i9 >>> 2) & 3;
                int i11 = i6;
                while (i11 > 0) {
                    int i12 = iArr[i11 - 1];
                    i8 = iArr[i11] - (((i8 ^ i9) + (i12 ^ iArr2[(i11 & 3) ^ i10])) ^ (((i12 >>> 5) ^ (i8 << 2)) + ((i8 >>> 3) ^ (i12 << 4))));
                    iArr[i11] = i8;
                    i11--;
                }
                int i13 = iArr[i6];
                i8 = iArr[0] - (((i8 ^ i9) + (iArr2[i10 ^ (i11 & 3)] ^ i13)) ^ (((i13 >>> 5) ^ (i8 << 2)) + ((i8 >>> 3) ^ (i13 << 4))));
                iArr[0] = i8;
            }
            int i14 = iArr[i6];
            if (i14 >= 0 && i14 <= (i6 << 2)) {
                byte[] bArr3 = new byte[i14];
                a(iArr, i6, bArr3);
                return bArr3;
            }
        }
        return null;
    }
}
