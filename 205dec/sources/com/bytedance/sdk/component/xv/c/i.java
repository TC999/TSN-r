package com.bytedance.sdk.component.xv.c;

import java.nio.charset.Charset;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
final class i {

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f30685c = Charset.forName("UTF-8");

    public static int c(int i4) {
        return ((i4 & 255) << 24) | (((-16777216) & i4) >>> 24) | ((16711680 & i4) >>> 8) | ((65280 & i4) << 8);
    }

    public static short c(short s3) {
        int i4 = s3 & 65535;
        return (short) (((i4 & 255) << 8) | ((65280 & i4) >>> 8));
    }

    public static void c(long j4, long j5, long j6) {
        if ((j5 | j6) < 0 || j5 > j4 || j4 - j5 < j6) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6)));
        }
    }

    private static <T extends Throwable> void w(Throwable th) throws Throwable {
        throw th;
    }

    public static void c(Throwable th) {
        w(th);
    }

    public static boolean c(byte[] bArr, int i4, byte[] bArr2, int i5, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            if (bArr[i7 + i4] != bArr2[i7 + i5]) {
                return false;
            }
        }
        return true;
    }
}
