package com.umeng.analytics.pro;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: EncodingUtils.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bo {
    public static final void a(int i4, byte[] bArr) {
        a(i4, bArr, 0);
    }

    public static final boolean a(int i4, int i5) {
        return (i4 & (1 << i5)) != 0;
    }

    public static final boolean a(long j4, int i4) {
        return (j4 & (1 << i4)) != 0;
    }

    public static final byte b(byte b4, int i4) {
        return (byte) b((int) b4, i4);
    }

    public static final int b(int i4, int i5) {
        return i4 & ((1 << i5) ^ (-1));
    }

    public static final long b(long j4, int i4) {
        return j4 & ((1 << i4) ^ (-1));
    }

    public static final void a(int i4, byte[] bArr, int i5) {
        bArr[i5] = (byte) ((i4 >> 24) & 255);
        bArr[i5 + 1] = (byte) ((i4 >> 16) & 255);
        bArr[i5 + 2] = (byte) ((i4 >> 8) & 255);
        bArr[i5 + 3] = (byte) (i4 & 255);
    }

    public static final short b(short s3, int i4) {
        return (short) b((int) s3, i4);
    }

    public static final int a(byte[] bArr) {
        return a(bArr, 0);
    }

    public static final int a(byte[] bArr, int i4) {
        return (bArr[i4 + 3] & 255) | ((bArr[i4] & 255) << 24) | ((bArr[i4 + 1] & 255) << 16) | ((bArr[i4 + 2] & 255) << 8);
    }

    public static final boolean a(byte b4, int i4) {
        return a((int) b4, i4);
    }

    public static final boolean a(short s3, int i4) {
        return a((int) s3, i4);
    }

    public static final byte a(byte b4, int i4, boolean z3) {
        return (byte) a((int) b4, i4, z3);
    }

    public static final short a(short s3, int i4, boolean z3) {
        return (short) a((int) s3, i4, z3);
    }

    public static final int a(int i4, int i5, boolean z3) {
        return z3 ? i4 | (1 << i5) : b(i4, i5);
    }

    public static final long a(long j4, int i4, boolean z3) {
        return z3 ? j4 | (1 << i4) : b(j4, i4);
    }
}
