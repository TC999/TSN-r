package com.bytedance.sdk.component.utils;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f30230c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String c(byte[] bArr) {
        if (bArr != null) {
            return c(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static String w(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return c(messageDigest.digest());
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String c(byte[] bArr, int i4, int i5) {
        if (bArr != null) {
            if (i4 >= 0 && i4 + i5 <= bArr.length) {
                int i6 = i5 * 2;
                char[] cArr = new char[i6];
                int i7 = 0;
                for (int i8 = 0; i8 < i5; i8++) {
                    int i9 = bArr[i8 + i4] & 255;
                    int i10 = i7 + 1;
                    char[] cArr2 = f30230c;
                    cArr[i7] = cArr2[i9 >> 4];
                    i7 = i10 + 1;
                    cArr[i10] = cArr2[i9 & 15];
                }
                return new String(cArr, 0, i6);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("bytes is null");
    }

    public static byte[] c(String str) throws IllegalArgumentException {
        if (str != null && str.length() % 2 != 1) {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            byte[] bArr = new byte[length / 2];
            for (int i4 = 0; i4 < length; i4 += 2) {
                bArr[i4 / 2] = (byte) ((Character.digit(charArray[i4], 16) << 4) + Character.digit(charArray[i4 + 1], 16));
            }
            return bArr;
        }
        throw new IllegalArgumentException("hexBinary needs to be even-length: " + str);
    }

    public static String c(File file) {
        FileInputStream fileInputStream;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            if (messageDigest == null) {
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 8192);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                String c4 = c(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
                return c4;
            } catch (Throwable unused2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            fileInputStream = null;
        }
    }
}
