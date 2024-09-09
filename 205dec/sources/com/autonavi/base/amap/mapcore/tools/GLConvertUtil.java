package com.autonavi.base.amap.mapcore.tools;

import java.io.ByteArrayOutputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GLConvertUtil {
    public static double convertDouble(byte[] bArr, int i4) {
        long j4 = 0;
        for (int i5 = 0; i5 < 8; i5++) {
            j4 += (bArr[i5 + i4] & 255) << (i5 * 8);
        }
        return Double.longBitsToDouble(j4);
    }

    public static byte[] convertInt(int i4) {
        return new byte[]{(byte) (i4 & 255), (byte) ((i4 >> 8) & 255), (byte) ((i4 >> 16) & 255), (byte) ((i4 >> 24) & 255)};
    }

    public static byte[] convertShort(int i4) {
        return new byte[]{(byte) (i4 & 255), (byte) ((i4 >> 8) & 255)};
    }

    public static byte[] get1BString(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = str.getBytes("UTF-8");
            byteArrayOutputStream.write(new byte[]{(byte) bytes.length});
            byteArrayOutputStream.write(bytes);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e4) {
            e4.printStackTrace();
            return new byte[1];
        }
    }

    public static int getInt(byte[] bArr, int i4) {
        return ((bArr[i4 + 3] & 255) << 24) + ((bArr[i4 + 2] & 255) << 16) + ((bArr[i4 + 1] & 255) << 8) + ((bArr[i4 + 0] & 255) << 0);
    }

    public static int getInt2(byte[] bArr, int i4) {
        return ((bArr[i4 + 0] & 255) << 24) + ((bArr[i4 + 1] & 255) << 16) + ((bArr[i4 + 2] & 255) << 8) + ((bArr[i4 + 3] & 255) << 0);
    }

    public static long getLong(byte[] bArr, int i4) {
        return ((bArr[i4 + 7] & 255) << 56) + ((bArr[i4 + 6] & 255) << 48) + ((bArr[i4 + 5] & 255) << 40) + ((bArr[i4 + 4] & 255) << 32) + ((bArr[i4 + 3] & 255) << 24) + ((bArr[i4 + 2] & 255) << 16) + ((bArr[i4 + 1] & 255) << 8) + ((bArr[i4 + 0] & 255) << 0);
    }

    public static short getShort(byte[] bArr, int i4) {
        return (short) (((bArr[i4 + 1] & 255) << 8) + ((bArr[i4 + 0] & 255) << 0));
    }

    public static short getShort2(byte[] bArr, int i4) {
        return (short) (((bArr[i4 + 0] & 255) << 8) + ((bArr[i4 + 1] & 255) << 0));
    }

    public static String getString(byte[] bArr, int i4, int i5) {
        try {
            return new String(bArr, i4, i5, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    public static byte[] getSubBytes(byte[] bArr, int i4, int i5) {
        byte[] bArr2 = new byte[i5];
        System.arraycopy(bArr, i4, bArr2, 0, i5);
        return bArr2;
    }

    public static int getUShort(byte[] bArr, int i4) {
        return ((bArr[i4 + 1] & 255) << 8) + ((bArr[i4 + 0] & 255) << 0);
    }

    public static void moveArray(byte[] bArr, int i4, byte[] bArr2, int i5, int i6) {
        byte[] bArr3 = new byte[i6];
        System.arraycopy(bArr, i4, bArr3, 0, i6);
        System.arraycopy(bArr3, 0, bArr2, i5, i6);
    }

    public static void writeInt(byte[] bArr, int i4, int i5) {
        System.arraycopy(convertInt(i5), 0, bArr, i4, 4);
    }

    public static void writeShort(byte[] bArr, int i4, short s3) {
        System.arraycopy(convertShort(s3), 0, bArr, i4, 2);
    }
}
