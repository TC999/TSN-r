package io.netty.buffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class HeapByteBufUtil {
    private HeapByteBufUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte getByte(byte[] bArr, int i4) {
        return bArr[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(byte[] bArr, int i4) {
        return (bArr[i4 + 3] & 255) | ((bArr[i4] & 255) << 24) | ((bArr[i4 + 1] & 255) << 16) | ((bArr[i4 + 2] & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getIntLE(byte[] bArr, int i4) {
        return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(byte[] bArr, int i4) {
        return (bArr[i4 + 7] & 255) | ((bArr[i4] & 255) << 56) | ((bArr[i4 + 1] & 255) << 48) | ((bArr[i4 + 2] & 255) << 40) | ((bArr[i4 + 3] & 255) << 32) | ((bArr[i4 + 4] & 255) << 24) | ((bArr[i4 + 5] & 255) << 16) | ((bArr[i4 + 6] & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLongLE(byte[] bArr, int i4) {
        return ((bArr[i4 + 7] & 255) << 56) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16) | ((bArr[i4 + 3] & 255) << 24) | ((bArr[i4 + 4] & 255) << 32) | ((bArr[i4 + 5] & 255) << 40) | ((bArr[i4 + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShort(byte[] bArr, int i4) {
        return (short) ((bArr[i4 + 1] & 255) | (bArr[i4] << 8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShortLE(byte[] bArr, int i4) {
        return (short) ((bArr[i4 + 1] << 8) | (bArr[i4] & 255));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getUnsignedMedium(byte[] bArr, int i4) {
        return (bArr[i4 + 2] & 255) | ((bArr[i4] & 255) << 16) | ((bArr[i4 + 1] & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getUnsignedMediumLE(byte[] bArr, int i4) {
        return ((bArr[i4 + 2] & 255) << 16) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setByte(byte[] bArr, int i4, int i5) {
        bArr[i4] = (byte) i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setInt(byte[] bArr, int i4, int i5) {
        bArr[i4] = (byte) (i5 >>> 24);
        bArr[i4 + 1] = (byte) (i5 >>> 16);
        bArr[i4 + 2] = (byte) (i5 >>> 8);
        bArr[i4 + 3] = (byte) i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setIntLE(byte[] bArr, int i4, int i5) {
        bArr[i4] = (byte) i5;
        bArr[i4 + 1] = (byte) (i5 >>> 8);
        bArr[i4 + 2] = (byte) (i5 >>> 16);
        bArr[i4 + 3] = (byte) (i5 >>> 24);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLong(byte[] bArr, int i4, long j4) {
        bArr[i4] = (byte) (j4 >>> 56);
        bArr[i4 + 1] = (byte) (j4 >>> 48);
        bArr[i4 + 2] = (byte) (j4 >>> 40);
        bArr[i4 + 3] = (byte) (j4 >>> 32);
        bArr[i4 + 4] = (byte) (j4 >>> 24);
        bArr[i4 + 5] = (byte) (j4 >>> 16);
        bArr[i4 + 6] = (byte) (j4 >>> 8);
        bArr[i4 + 7] = (byte) j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLongLE(byte[] bArr, int i4, long j4) {
        bArr[i4] = (byte) j4;
        bArr[i4 + 1] = (byte) (j4 >>> 8);
        bArr[i4 + 2] = (byte) (j4 >>> 16);
        bArr[i4 + 3] = (byte) (j4 >>> 24);
        bArr[i4 + 4] = (byte) (j4 >>> 32);
        bArr[i4 + 5] = (byte) (j4 >>> 40);
        bArr[i4 + 6] = (byte) (j4 >>> 48);
        bArr[i4 + 7] = (byte) (j4 >>> 56);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMedium(byte[] bArr, int i4, int i5) {
        bArr[i4] = (byte) (i5 >>> 16);
        bArr[i4 + 1] = (byte) (i5 >>> 8);
        bArr[i4 + 2] = (byte) i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMediumLE(byte[] bArr, int i4, int i5) {
        bArr[i4] = (byte) i5;
        bArr[i4 + 1] = (byte) (i5 >>> 8);
        bArr[i4 + 2] = (byte) (i5 >>> 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setShort(byte[] bArr, int i4, int i5) {
        bArr[i4] = (byte) (i5 >>> 8);
        bArr[i4 + 1] = (byte) i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setShortLE(byte[] bArr, int i4, int i5) {
        bArr[i4] = (byte) i5;
        bArr[i4 + 1] = (byte) (i5 >>> 8);
    }
}
