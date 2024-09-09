package com.tencent.turingfd.sdk.ams.au;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class Eridanus {
    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i4 = 0; i4 < 256; i4++) {
            bArr2[i4] = bArr[i4 >>> 4];
            bArr3[i4] = bArr[i4 & 15];
        }
    }

    public static boolean a(int i4, int i5) {
        return i4 == i5;
    }

    public static boolean a(long j4, long j5) {
        return j4 == j5;
    }
}
