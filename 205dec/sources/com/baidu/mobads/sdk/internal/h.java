package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f12855a = {48, 75, 97, 106, 68, 55, 65, 90, 99, 70, 50, 81, 110, 80, 114, 53, 102, 119, 105, 72, 82, 78, 121, 103, 109, 117, 112, 85, 84, 73, 88, 120, 54, 57, 66, 87, 98, 45, 104, 77, 67, 71, 74, 111, 95, 86, 56, 69, 115, 107, 122, 49, 89, 100, 118, 76, 51, 52, 108, 101, 116, 113, 83, 79};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f12856b = new byte[128];

    static {
        int i4 = 0;
        while (true) {
            byte[] bArr = f12855a;
            if (i4 >= bArr.length) {
                return;
            }
            f12856b[bArr[i4]] = (byte) i4;
            i4++;
        }
    }

    public static String b(String str) {
        if (str == null || str.length() < 4) {
            return null;
        }
        try {
            String str2 = new String(c(str));
            while (str2.endsWith("$")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            return str2;
        } catch (Exception unused) {
            return "";
        }
    }

    private static byte[] c(String str) {
        byte[] bArr;
        if (d(str) || str == null || str.length() < 4) {
            return null;
        }
        if (str.charAt(str.length() - 2) == '$') {
            bArr = new byte[(((str.length() / 4) - 1) * 3) + 1];
        } else if (str.charAt(str.length() - 1) == '$') {
            bArr = new byte[(((str.length() / 4) - 1) * 3) + 2];
        } else {
            bArr = new byte[(str.length() / 4) * 3];
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < str.length() - 4) {
            byte[] bArr2 = f12856b;
            byte b4 = bArr2[str.charAt(i4)];
            byte b5 = bArr2[str.charAt(i4 + 1)];
            byte b6 = bArr2[str.charAt(i4 + 2)];
            byte b7 = bArr2[str.charAt(i4 + 3)];
            bArr[i5] = (byte) ((b4 << 2) | (b5 >> 4));
            bArr[i5 + 1] = (byte) ((b5 << 4) | (b6 >> 2));
            bArr[i5 + 2] = (byte) (b7 | (b6 << 6));
            i4 += 4;
            i5 += 3;
        }
        if (str.charAt(str.length() - 2) == '$') {
            byte[] bArr3 = f12856b;
            byte b8 = bArr3[str.charAt(str.length() - 4)];
            bArr[bArr.length - 1] = (byte) ((bArr3[str.charAt(str.length() - 3)] >> 4) | (b8 << 2));
        } else if (str.charAt(str.length() - 1) == '$') {
            byte[] bArr4 = f12856b;
            byte b9 = bArr4[str.charAt(str.length() - 4)];
            byte b10 = bArr4[str.charAt(str.length() - 3)];
            byte b11 = bArr4[str.charAt(str.length() - 2)];
            bArr[bArr.length - 2] = (byte) ((b9 << 2) | (b10 >> 4));
            bArr[bArr.length - 1] = (byte) ((b11 >> 2) | (b10 << 4));
        } else {
            byte[] bArr5 = f12856b;
            byte b12 = bArr5[str.charAt(str.length() - 4)];
            byte b13 = bArr5[str.charAt(str.length() - 3)];
            byte b14 = bArr5[str.charAt(str.length() - 2)];
            byte b15 = bArr5[str.charAt(str.length() - 1)];
            bArr[bArr.length - 3] = (byte) ((b12 << 2) | (b13 >> 4));
            bArr[bArr.length - 2] = (byte) ((b13 << 4) | (b14 >> 2));
            bArr[bArr.length - 1] = (byte) (b15 | (b14 << 6));
        }
        return bArr;
    }

    private static boolean d(String str) {
        if (str == null) {
            return true;
        }
        for (int i4 = 0; i4 < str.length(); i4++) {
            if (!a((byte) str.charAt(i4))) {
                return true;
            }
        }
        return false;
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (int length = str.getBytes().length % 3; length > 0 && length < 3; length++) {
            str = str + "$";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[(bytes.length / 3) * 4];
        int i4 = 0;
        int i5 = 0;
        while (i4 < bytes.length) {
            byte[] bArr2 = f12855a;
            bArr[i5] = bArr2[(bytes[i4] & 252) >> 2];
            int i6 = i4 + 1;
            bArr[i5 + 1] = bArr2[((bytes[i4] & 3) << 4) + ((bytes[i6] & 240) >> 4)];
            int i7 = i4 + 2;
            bArr[i5 + 2] = bArr2[((bytes[i6] & 15) << 2) + ((bytes[i7] & 192) >> 6)];
            bArr[i5 + 3] = bArr2[bytes[i7] & 63];
            i4 += 3;
            i5 += 4;
        }
        return new String(bArr);
    }

    private static boolean a(byte b4) {
        if (b4 == 36) {
            return true;
        }
        return b4 >= 0 && b4 < 128 && f12856b[b4] != -1;
    }
}
