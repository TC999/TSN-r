package com.autonavi.base.amap.mapcore.tools;

import java.io.ByteArrayOutputStream;
import kotlin.UByte;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GLConvertUtil {
    public static double convertDouble(byte[] bArr, int i) {
        long j = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            j += (bArr[i2 + i] & UByte.f41242c) << (i2 * 8);
        }
        return Double.longBitsToDouble(j);
    }

    public static byte[] convertInt(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    public static byte[] convertShort(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255)};
    }

    public static byte[] get1BString(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = str.getBytes("UTF-8");
            byteArrayOutputStream.write(new byte[]{(byte) bytes.length});
            byteArrayOutputStream.write(bytes);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[1];
        }
    }

    public static int getInt(byte[] bArr, int i) {
        return ((bArr[i + 3] & UByte.f41242c) << 24) + ((bArr[i + 2] & UByte.f41242c) << 16) + ((bArr[i + 1] & UByte.f41242c) << 8) + ((bArr[i + 0] & UByte.f41242c) << 0);
    }

    public static int getInt2(byte[] bArr, int i) {
        return ((bArr[i + 0] & UByte.f41242c) << 24) + ((bArr[i + 1] & UByte.f41242c) << 16) + ((bArr[i + 2] & UByte.f41242c) << 8) + ((bArr[i + 3] & UByte.f41242c) << 0);
    }

    public static long getLong(byte[] bArr, int i) {
        return ((bArr[i + 7] & UByte.f41242c) << 56) + ((bArr[i + 6] & UByte.f41242c) << 48) + ((bArr[i + 5] & UByte.f41242c) << 40) + ((bArr[i + 4] & UByte.f41242c) << 32) + ((bArr[i + 3] & UByte.f41242c) << 24) + ((bArr[i + 2] & UByte.f41242c) << 16) + ((bArr[i + 1] & UByte.f41242c) << 8) + ((bArr[i + 0] & UByte.f41242c) << 0);
    }

    public static short getShort(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & UByte.f41242c) << 8) + ((bArr[i + 0] & UByte.f41242c) << 0));
    }

    public static short getShort2(byte[] bArr, int i) {
        return (short) (((bArr[i + 0] & UByte.f41242c) << 8) + ((bArr[i + 1] & UByte.f41242c) << 0));
    }

    public static String getString(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    public static byte[] getSubBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static int getUShort(byte[] bArr, int i) {
        return ((bArr[i + 1] & UByte.f41242c) << 8) + ((bArr[i + 0] & UByte.f41242c) << 0);
    }

    public static void moveArray(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        byte[] bArr3 = new byte[i3];
        System.arraycopy(bArr, i, bArr3, 0, i3);
        System.arraycopy(bArr3, 0, bArr2, i2, i3);
    }

    public static void writeInt(byte[] bArr, int i, int i2) {
        System.arraycopy(convertInt(i2), 0, bArr, i, 4);
    }

    public static void writeShort(byte[] bArr, int i, short s) {
        System.arraycopy(convertShort(s), 0, bArr, i, 2);
    }
}
