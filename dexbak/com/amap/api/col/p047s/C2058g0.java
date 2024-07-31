package com.amap.api.col.p047s;

import kotlin.UByte;

/* compiled from: XXTEA.java */
/* renamed from: com.amap.api.col.s.g0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2058g0 {

    /* renamed from: a */
    private static int f6126a = 4;

    /* renamed from: a */
    public static byte[] m52996a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length;
        int i = f6126a;
        int i2 = i - (length % i);
        int i3 = ((length / i) + 1) * i;
        byte[] bArr3 = new byte[i3];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        while (length < i3) {
            bArr3[length] = (byte) i2;
            length++;
        }
        return m52995b(m52993d(m52994c(bArr3), m52994c(bArr2)));
    }

    /* renamed from: b */
    private static byte[] m52995b(int[] iArr) {
        int length = iArr.length << 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) ((iArr[i >>> 2] >>> ((i & 3) << 3)) & 255);
        }
        return bArr;
    }

    /* renamed from: c */
    private static int[] m52994c(byte[] bArr) {
        int[] iArr = new int[bArr.length >>> 2];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = i >>> 2;
            iArr[i2] = iArr[i2] | ((bArr[i] & UByte.f41242c) << ((i & 3) << 3));
        }
        return iArr;
    }

    /* renamed from: d */
    private static int[] m52993d(int[] iArr, int[] iArr2) {
        int length = iArr.length - 1;
        if (length <= 0) {
            return iArr;
        }
        if (iArr2.length < 4) {
            int[] iArr3 = new int[4];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            iArr2 = iArr3;
        }
        int i = iArr[length];
        int i2 = (52 / (length + 1)) + 6;
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                return iArr;
            }
            i3 -= 1640531527;
            int i5 = (i3 >>> 2) & 3;
            int i6 = 0;
            while (i6 < length) {
                int i7 = i6 + 1;
                int i8 = iArr[i7];
                i = ((((i >>> 5) ^ (i8 << 2)) + ((i8 >>> 3) ^ (i << 4))) ^ ((i8 ^ i3) + (i ^ iArr2[(i6 & 3) ^ i5]))) + iArr[i6];
                iArr[i6] = i;
                i6 = i7;
            }
            int i9 = iArr[0];
            i = ((((i >>> 5) ^ (i9 << 2)) + ((i9 >>> 3) ^ (i << 4))) ^ ((i9 ^ i3) + (i ^ iArr2[i5 ^ (i6 & 3)]))) + iArr[length];
            iArr[length] = i;
            i2 = i4;
        }
    }
}
