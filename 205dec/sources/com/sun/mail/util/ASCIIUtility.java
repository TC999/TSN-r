package com.sun.mail.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ASCIIUtility {
    private ASCIIUtility() {
    }

    public static byte[] getBytes(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            bArr[i4] = (byte) charArray[i4];
        }
        return bArr;
    }

    public static int parseInt(byte[] bArr, int i4, int i5, int i6) throws NumberFormatException {
        int i7;
        int i8;
        boolean z3;
        if (bArr != null) {
            if (i5 > i4) {
                int i9 = 0;
                if (bArr[i4] == 45) {
                    i7 = Integer.MIN_VALUE;
                    i8 = i4 + 1;
                    z3 = true;
                } else {
                    i7 = -2147483647;
                    i8 = i4;
                    z3 = false;
                }
                int i10 = i7 / i6;
                if (i8 < i5) {
                    int i11 = i8 + 1;
                    int digit = Character.digit((char) bArr[i8], i6);
                    if (digit < 0) {
                        throw new NumberFormatException("illegal number: " + toString(bArr, i4, i5));
                    }
                    i9 = -digit;
                    i8 = i11;
                }
                while (i8 < i5) {
                    int i12 = i8 + 1;
                    int digit2 = Character.digit((char) bArr[i8], i6);
                    if (digit2 < 0) {
                        throw new NumberFormatException("illegal number");
                    }
                    if (i9 < i10) {
                        throw new NumberFormatException("illegal number");
                    }
                    int i13 = i9 * i6;
                    if (i13 < i7 + digit2) {
                        throw new NumberFormatException("illegal number");
                    }
                    i9 = i13 - digit2;
                    i8 = i12;
                }
                if (z3) {
                    if (i8 > i4 + 1) {
                        return i9;
                    }
                    throw new NumberFormatException("illegal number");
                }
                return -i9;
            }
            throw new NumberFormatException("illegal number");
        }
        throw new NumberFormatException("null");
    }

    public static long parseLong(byte[] bArr, int i4, int i5, int i6) throws NumberFormatException {
        int i7;
        long j4;
        boolean z3;
        int i8 = i4;
        int i9 = i5;
        if (bArr != null) {
            long j5 = 0;
            if (i9 > i8) {
                if (bArr[i8] == 45) {
                    i7 = i8 + 1;
                    j4 = Long.MIN_VALUE;
                    z3 = true;
                } else {
                    i7 = i8;
                    j4 = -9223372036854775807L;
                    z3 = false;
                }
                long j6 = i6;
                long j7 = j4 / j6;
                if (i7 < i9) {
                    int i10 = i7 + 1;
                    int digit = Character.digit((char) bArr[i7], i6);
                    if (digit < 0) {
                        throw new NumberFormatException("illegal number: " + toString(bArr, i4, i5));
                    }
                    i7 = i10;
                    j5 = -digit;
                }
                while (i7 < i9) {
                    int i11 = i7 + 1;
                    int digit2 = Character.digit((char) bArr[i7], i6);
                    if (digit2 < 0) {
                        throw new NumberFormatException("illegal number");
                    }
                    if (j5 < j7) {
                        throw new NumberFormatException("illegal number");
                    }
                    long j8 = j5 * j6;
                    long j9 = digit2;
                    if (j8 < j4 + j9) {
                        throw new NumberFormatException("illegal number");
                    }
                    j5 = j8 - j9;
                    i8 = i4;
                    i9 = i5;
                    i7 = i11;
                }
                if (z3) {
                    if (i7 > i8 + 1) {
                        return j5;
                    }
                    throw new NumberFormatException("illegal number");
                }
                return -j5;
            }
            throw new NumberFormatException("illegal number");
        }
        throw new NumberFormatException("null");
    }

    public static String toString(byte[] bArr, int i4, int i5) {
        int i6 = i5 - i4;
        char[] cArr = new char[i6];
        int i7 = 0;
        while (i7 < i6) {
            cArr[i7] = (char) (bArr[i4] & 255);
            i7++;
            i4++;
        }
        return new String(cArr);
    }

    public static String toString(ByteArrayInputStream byteArrayInputStream) {
        int available = byteArrayInputStream.available();
        char[] cArr = new char[available];
        byte[] bArr = new byte[available];
        byteArrayInputStream.read(bArr, 0, available);
        for (int i4 = 0; i4 < available; i4++) {
            cArr[i4] = (char) (bArr[i4] & 255);
        }
        return new String(cArr);
    }

    public static byte[] getBytes(InputStream inputStream) throws IOException {
        if (inputStream instanceof ByteArrayInputStream) {
            int available = inputStream.available();
            byte[] bArr = new byte[available];
            inputStream.read(bArr, 0, available);
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr2, 0, 1024);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }

    public static int parseInt(byte[] bArr, int i4, int i5) throws NumberFormatException {
        return parseInt(bArr, i4, i5, 10);
    }

    public static long parseLong(byte[] bArr, int i4, int i5) throws NumberFormatException {
        return parseLong(bArr, i4, i5, 10);
    }
}
