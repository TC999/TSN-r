package com.amap.api.col.s;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: XXTEA.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    private static int f9854a = 4;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length;
        int i4 = f9854a;
        int i5 = i4 - (length % i4);
        int i6 = ((length / i4) + 1) * i4;
        byte[] bArr3 = new byte[i6];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        while (length < i6) {
            bArr3[length] = (byte) i5;
            length++;
        }
        return b(d(c(bArr3), c(bArr2)));
    }

    private static byte[] b(int[] iArr) {
        int length = iArr.length << 2;
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            bArr[i4] = (byte) ((iArr[i4 >>> 2] >>> ((i4 & 3) << 3)) & 255);
        }
        return bArr;
    }

    private static int[] c(byte[] bArr) {
        int[] iArr = new int[bArr.length >>> 2];
        int length = bArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i4 >>> 2;
            iArr[i5] = iArr[i5] | ((bArr[i4] & 255) << ((i4 & 3) << 3));
        }
        return iArr;
    }

    private static int[] d(int[] iArr, int[] iArr2) {
        int length = iArr.length - 1;
        if (length <= 0) {
            return iArr;
        }
        if (iArr2.length < 4) {
            int[] iArr3 = new int[4];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            iArr2 = iArr3;
        }
        int i4 = iArr[length];
        int i5 = (52 / (length + 1)) + 6;
        int i6 = 0;
        while (true) {
            int i7 = i5 - 1;
            if (i5 <= 0) {
                return iArr;
            }
            i6 -= 1640531527;
            int i8 = (i6 >>> 2) & 3;
            int i9 = 0;
            while (i9 < length) {
                int i10 = i9 + 1;
                int i11 = iArr[i10];
                i4 = ((((i4 >>> 5) ^ (i11 << 2)) + ((i11 >>> 3) ^ (i4 << 4))) ^ ((i11 ^ i6) + (i4 ^ iArr2[(i9 & 3) ^ i8]))) + iArr[i9];
                iArr[i9] = i4;
                i9 = i10;
            }
            int i12 = iArr[0];
            i4 = ((((i4 >>> 5) ^ (i12 << 2)) + ((i12 >>> 3) ^ (i4 << 4))) ^ ((i12 ^ i6) + (i4 ^ iArr2[i8 ^ (i9 & 3)]))) + iArr[length];
            iArr[length] = i4;
            i5 = i7;
        }
    }
}
