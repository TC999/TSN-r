package com.kwad.components.core.e.b;

import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    private final int[] Kd;

    private c(int[] iArr) {
        this.Kd = iArr;
    }

    public static c a(int[] iArr) {
        return new c(iArr);
    }

    private static long b(long j4, int[] iArr) {
        int i4 = 31;
        while (i4 > 23) {
            j4 = d(i4, iArr, j4);
            i4--;
        }
        while (i4 > 15) {
            j4 = c(i4, iArr, j4);
            i4--;
        }
        while (i4 > 7) {
            j4 = d(i4, iArr, j4);
            i4--;
        }
        while (i4 >= 0) {
            j4 = c(i4, iArr, j4);
            i4--;
        }
        return j4;
    }

    private static long c(int i4, int[] iArr, long j4) {
        long j5 = j4 >>> 48;
        long j6 = (j4 >> 32) & 65535;
        long f4 = f(i4, iArr, j6);
        return ((i4 + 1) ^ (j5 ^ j6)) | ((j4 & 65535) << 16) | (f4 << 48) | (((j4 >> 16) & 65535) << 32);
    }

    private static long d(int i4, int[] iArr, long j4) {
        long j5 = j4 >>> 48;
        long j6 = (j4 >> 32) & 65535;
        long f4 = f(i4, iArr, j6);
        long f5 = f(i4, iArr, j6);
        return (((i4 + 1) ^ (f5 ^ ((j4 >> 16) & 65535))) << 32) | (f4 << 48) | ((j4 & 65535) << 16) | j5;
    }

    private static long e(int i4, int[] iArr, long j4) {
        int i5 = (int) (j4 >>> 8);
        int i6 = (int) (j4 & 255);
        int i7 = i4 * 4;
        int i8 = iArr[i7 % 10];
        int i9 = iArr[(i7 + 1) % 10];
        int i10 = iArr[(i7 + 2) % 10];
        int i11 = iArr[(i7 + 3) % 10];
        int[] iArr2 = b.Kc;
        int i12 = iArr2[i8 ^ i6] ^ i5;
        int i13 = i6 ^ iArr2[i9 ^ i12];
        int i14 = i12 ^ iArr2[i13 ^ i10];
        return (i14 << 8) | (iArr2[i11 ^ i14] ^ i13);
    }

    private static long f(int i4, int[] iArr, long j4) {
        int i5 = (int) (j4 >>> 8);
        int i6 = i4 * 4;
        int i7 = iArr[(i6 + 3) % 10];
        int i8 = iArr[(i6 + 2) % 10];
        int i9 = iArr[(i6 + 1) % 10];
        int i10 = iArr[i6 % 10];
        int[] iArr2 = b.Kc;
        int i11 = iArr2[i7 ^ i5] ^ ((int) (255 & j4));
        int i12 = i5 ^ iArr2[i11 ^ i8];
        int i13 = i11 ^ iArr2[i12 ^ i9];
        return ((iArr2[i10 ^ i13] ^ i12) << 8) | i13;
    }

    public final long ad(String str) {
        byte[] decode = com.kwad.sdk.core.a.c.Dv().decode(str);
        if (decode != null && decode.length == 8) {
            return b(ByteBuffer.wrap(decode).getLong(), this.Kd);
        }
        throw new RuntimeException("fail to decode: " + str);
    }

    public final String u(long j4) {
        return com.kwad.sdk.core.a.c.Dt().encodeToString(ByteBuffer.allocate(8).putLong(a(j4, this.Kd)).array());
    }

    private static long a(long j4, int[] iArr) {
        int i4 = 0;
        while (i4 < 8) {
            j4 = a(i4, iArr, j4);
            i4++;
        }
        while (i4 < 16) {
            j4 = b(i4, iArr, j4);
            i4++;
        }
        while (i4 < 24) {
            j4 = a(i4, iArr, j4);
            i4++;
        }
        while (i4 < 32) {
            j4 = b(i4, iArr, j4);
            i4++;
        }
        return j4;
    }

    private static long b(int i4, int[] iArr, long j4) {
        long j5 = j4 >>> 48;
        long e4 = e(i4, iArr, j5);
        return (((i4 + 1) ^ (j5 ^ ((j4 >> 32) & 65535))) << 16) | ((j4 & 65535) << 48) | (e4 << 32) | ((j4 >> 16) & 65535);
    }

    private static long a(int i4, int[] iArr, long j4) {
        long j5 = j4 >>> 48;
        return (e(i4, iArr, j5) << 32) | ((((j4 & 65535) ^ e(i4, iArr, j5)) ^ (i4 + 1)) << 48) | (((j4 >> 32) & 65535) << 16) | ((j4 >> 16) & 65535);
    }
}
