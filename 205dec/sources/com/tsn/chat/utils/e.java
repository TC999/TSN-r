package com.tsn.chat.utils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Test16Binary.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class e {
    public static int a(byte[] bArr) {
        return (bArr[3] << 24) | (bArr[0] & 255) | ((bArr[1] << 8) & 65280) | ((bArr[2] << 24) >>> 8);
    }

    public static short b(byte[] bArr) {
        return (short) (((short) (((short) (bArr[1] & 255)) << 8)) | ((short) (bArr[0] & 255)));
    }

    public static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        int i4 = 0;
        for (byte b4 : bArr) {
            i4++;
            sb.append("0123456789abcdef".charAt((b4 >> 4) & 15));
            sb.append("0123456789abcdef".charAt(b4 & 15));
            sb.append(" ");
            if (i4 == 8) {
                sb.append("  ");
            } else if (i4 == 16) {
                sb.append("\n");
                i4 = 0;
            }
        }
        return sb.toString();
    }

    public static String d(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b4 : bArr) {
            sb.append("0123456789abcdef".charAt((b4 >> 4) & 15));
            sb.append("0123456789abcdef".charAt(b4 & 15));
            sb.append("-");
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    public static String e(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b4 : bArr) {
            sb.append("0123456789abcdef".charAt((b4 >> 4) & 15));
            sb.append("0123456789abcdef".charAt(b4 & 15));
        }
        return sb.toString();
    }

    public static byte[] f(byte b4) {
        byte[] bArr = new byte[8];
        for (int i4 = 7; i4 >= 0; i4--) {
            bArr[i4] = (byte) (b4 & 1);
            b4 = (byte) (b4 >> 1);
        }
        return bArr;
    }

    public static byte[] g(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i4 * 2;
            int i6 = i5 + 1;
            bArr[i4] = k(str.substring(i5, i6), str.substring(i6, i6 + 1));
        }
        return bArr;
    }

    public static String h(String str) {
        char[] charArray = str.toCharArray();
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i4 * 2;
            bArr[i4] = (byte) ((("0123456789ABCDEF".indexOf(charArray[i5]) * 16) + "0123456789ABCDEF".indexOf(charArray[i5 + 1])) & 255);
        }
        return new String(bArr);
    }

    public static byte[] i(int i4) {
        return new byte[]{(byte) (i4 & 255), (byte) ((65280 & i4) >> 8), (byte) ((16711680 & i4) >> 16), (byte) ((i4 & (-16777216)) >> 24)};
    }

    public static String j(String str) {
        String str2 = "";
        for (int i4 = 0; i4 < str.length(); i4++) {
            str2 = String.valueOf(str2) + Integer.toHexString(str.charAt(i4));
        }
        return str2;
    }

    private static byte k(String str, String str2) {
        return (byte) (((byte) (Byte.decode("0x" + str).byteValue() << 4)) | Byte.decode("0x" + str2).byteValue());
    }
}
