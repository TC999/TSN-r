package com.kuaishou.weapon.p0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class i {
    public static byte[] a(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return c(bArr, str);
    }

    public static byte[] b(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return c(bArr, str);
    }

    private static byte[] c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        byte[] bytes = str.getBytes();
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i4 * 2;
            bArr[i4] = a(bytes[i5], bytes[i5 + 1]);
        }
        return bArr;
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return new String(c(c(str), str2));
    }

    private static byte[] b(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return c(str.getBytes(), str2);
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b4 : bArr) {
            stringBuffer.append((char) b4);
        }
        return stringBuffer.toString();
    }

    private static String b(String str) {
        String str2 = "";
        for (int i4 = 0; i4 < str.length(); i4++) {
            String hexString = Integer.toHexString(str.charAt(i4) & '\u00ff');
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            str2 = str2 + hexString;
        }
        return str2;
    }

    private static byte[] c(byte[] bArr, String str) {
        byte[] a4 = a(str);
        byte[] bArr2 = new byte[bArr.length];
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < bArr.length; i6++) {
            i4 = (i4 + 1) & 255;
            i5 = ((a4[i4] & 255) + i5) & 255;
            byte b4 = a4[i4];
            a4[i4] = a4[i5];
            a4[i5] = b4;
            bArr2[i6] = (byte) (a4[((a4[i4] & 255) + (a4[i5] & 255)) & 255] ^ bArr[i6]);
        }
        return bArr2;
    }

    private static byte[] a(String str) {
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[256];
        for (int i4 = 0; i4 < 256; i4++) {
            bArr[i4] = (byte) i4;
        }
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < 256; i7++) {
            i6 = ((bytes[i5] & 255) + (bArr[i7] & 255) + i6) & 255;
            byte b4 = bArr[i7];
            bArr[i7] = bArr[i6];
            bArr[i6] = b4;
            i5 = (i5 + 1) % bytes.length;
        }
        return bArr;
    }

    private static byte a(byte b4, byte b5) {
        return (byte) (((char) (((char) Byte.decode("0x" + new String(new byte[]{b4})).byteValue()) << 4)) ^ ((char) Byte.decode("0x" + new String(new byte[]{b5})).byteValue()));
    }
}
