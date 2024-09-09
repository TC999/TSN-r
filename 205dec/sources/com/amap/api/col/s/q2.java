package com.amap.api.col.s;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: XXTEA.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class q2 {

    /* renamed from: a  reason: collision with root package name */
    private static int f10132a = 4;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length;
        int i4 = f10132a;
        int i5 = i4 - (length % i4);
        int i6 = ((length / i4) + 1) * i4;
        byte[] bArr3 = new byte[i6];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        while (length < i6) {
            bArr3[length] = (byte) i5;
            length++;
        }
        int[] b4 = b(bArr3);
        int[] b5 = b(bArr2);
        int length2 = b4.length - 1;
        if (length2 > 0) {
            if (b5.length < 4) {
                int[] iArr = new int[4];
                System.arraycopy(b5, 0, iArr, 0, b5.length);
                b5 = iArr;
            }
            int i7 = b4[length2];
            int i8 = (52 / (length2 + 1)) + 6;
            int i9 = 0;
            while (true) {
                int i10 = i8 - 1;
                if (i8 <= 0) {
                    break;
                }
                i9 -= 1640531527;
                int i11 = (i9 >>> 2) & 3;
                int i12 = 0;
                while (i12 < length2) {
                    int i13 = i12 + 1;
                    int i14 = b4[i13];
                    i7 = ((((i7 >>> 5) ^ (i14 << 2)) + ((i14 >>> 3) ^ (i7 << 4))) ^ ((i14 ^ i9) + (i7 ^ b5[(i12 & 3) ^ i11]))) + b4[i12];
                    b4[i12] = i7;
                    i12 = i13;
                }
                int i15 = b4[0];
                i7 = ((((i7 >>> 5) ^ (i15 << 2)) + ((i15 >>> 3) ^ (i7 << 4))) ^ ((i15 ^ i9) + (i7 ^ b5[i11 ^ (i12 & 3)]))) + b4[length2];
                b4[length2] = i7;
                i8 = i10;
            }
        }
        int length3 = b4.length << 2;
        byte[] bArr4 = new byte[length3];
        for (int i16 = 0; i16 < length3; i16++) {
            bArr4[i16] = (byte) ((b4[i16 >>> 2] >>> ((i16 & 3) << 3)) & 255);
        }
        return bArr4;
    }

    private static int[] b(byte[] bArr) {
        int[] iArr = new int[bArr.length >>> 2];
        int length = bArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i4 >>> 2;
            iArr[i5] = iArr[i5] | ((bArr[i4] & 255) << ((i4 & 3) << 3));
        }
        return iArr;
    }
}
