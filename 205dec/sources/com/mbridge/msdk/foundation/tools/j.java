package com.mbridge.msdk.foundation.tools;

import android.os.Build;
import java.nio.charset.StandardCharsets;

/* compiled from: FastBuffer.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f39857a;

    /* renamed from: b  reason: collision with root package name */
    public int f39858b;

    /* renamed from: c  reason: collision with root package name */
    private char[] f39859c;

    public j(int i4) {
        this(new byte[i4], 0);
    }

    public final byte a() {
        byte[] bArr = this.f39857a;
        int i4 = this.f39858b;
        this.f39858b = i4 + 1;
        return bArr[i4];
    }

    public final short b() {
        byte[] bArr = this.f39857a;
        int i4 = this.f39858b;
        int i5 = i4 + 1;
        this.f39858b = i5;
        this.f39858b = i5 + 1;
        return (short) ((bArr[i5] << 8) | (bArr[i4] & 255));
    }

    public final int c() {
        byte[] bArr = this.f39857a;
        int i4 = this.f39858b;
        int i5 = i4 + 1;
        this.f39858b = i5;
        int i6 = i5 + 1;
        this.f39858b = i6;
        int i7 = (bArr[i4] & 255) | ((bArr[i5] & 255) << 8);
        int i8 = i6 + 1;
        this.f39858b = i8;
        int i9 = i7 | ((bArr[i6] & 255) << 16);
        this.f39858b = i8 + 1;
        return (bArr[i8] << 24) | i9;
    }

    public final long d() {
        long c4 = c(this.f39858b);
        this.f39858b += 8;
        return c4;
    }

    public j(byte[] bArr) {
        this(bArr, 0);
    }

    public static int b(String str) {
        int length = str.length();
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = i4 + 1;
            char charAt = str.charAt(i4);
            if (charAt < '\u0080') {
                i5++;
            } else if (charAt < '\u0800') {
                i5 += 2;
            } else if (charAt < '\ud800' || charAt > '\udfff') {
                i5 += 3;
            } else {
                i6++;
                i5 += 4;
            }
            i4 = i6;
        }
        return i5;
    }

    private long c(int i4) {
        byte[] bArr = this.f39857a;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        int i9 = i8 + 1;
        int i10 = i9 + 1;
        return (bArr[i10 + 1] << 56) | (bArr[i4] & 255) | ((bArr[i5] & 255) << 8) | ((bArr[i6] & 255) << 16) | ((bArr[i7] & 255) << 24) | ((bArr[i8] & 255) << 32) | ((bArr[i9] & 255) << 40) | ((255 & bArr[i10]) << 48);
    }

    public final void a(byte b4) {
        byte[] bArr = this.f39857a;
        int i4 = this.f39858b;
        this.f39858b = i4 + 1;
        bArr[i4] = b4;
    }

    public j(byte[] bArr, int i4) {
        this.f39859c = null;
        this.f39857a = bArr;
        this.f39858b = i4;
    }

    public final void a(short s3) {
        byte[] bArr = this.f39857a;
        int i4 = this.f39858b;
        int i5 = i4 + 1;
        this.f39858b = i5;
        bArr[i4] = (byte) s3;
        this.f39858b = i5 + 1;
        bArr[i5] = (byte) (s3 >> 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long b(int i4, int i5) {
        long j4 = 0;
        if (i5 <= 0) {
            return 0L;
        }
        int i6 = i5 >> 3;
        int i7 = i5 & 7;
        int i8 = 0;
        int i9 = i4;
        for (int i10 = 0; i10 < i6; i10++) {
            j4 ^= c(i9);
            i9 += 8;
        }
        int i11 = i7 << 3;
        while (i8 < i11) {
            j4 ^= (this.f39857a[i9] & 255) << i8;
            i8 += 8;
            i9++;
        }
        int i12 = (i4 & 7) << 3;
        return (j4 >>> (64 - i12)) | (j4 << i12);
    }

    public final void a(int i4) {
        byte[] bArr = this.f39857a;
        int i5 = this.f39858b;
        int i6 = i5 + 1;
        this.f39858b = i6;
        bArr[i5] = (byte) i4;
        int i7 = i6 + 1;
        this.f39858b = i7;
        bArr[i6] = (byte) (i4 >> 8);
        int i8 = i7 + 1;
        this.f39858b = i8;
        bArr[i7] = (byte) (i4 >> 16);
        this.f39858b = i8 + 1;
        bArr[i8] = (byte) (i4 >> 24);
    }

    public final String b(int i4) {
        String str;
        if (i4 < 0) {
            return null;
        }
        if (i4 == 0) {
            return "";
        }
        if (i4 > 2048) {
            if (Build.VERSION.SDK_INT >= 19) {
                str = new String(this.f39857a, this.f39858b, i4, StandardCharsets.UTF_8);
            } else {
                str = new String(this.f39857a, this.f39858b, i4);
            }
        } else {
            char[] cArr = this.f39859c;
            if (cArr == null) {
                if (i4 <= 256) {
                    this.f39859c = new char[256];
                } else {
                    this.f39859c = new char[2048];
                }
            } else if (cArr.length < i4) {
                this.f39859c = new char[2048];
            }
            char[] cArr2 = this.f39859c;
            byte[] bArr = this.f39857a;
            int i5 = this.f39858b;
            int i6 = i5 + i4;
            int i7 = 0;
            while (i5 < i6) {
                int i8 = i5 + 1;
                byte b4 = bArr[i5];
                if (b4 > 0) {
                    cArr2[i7] = (char) b4;
                    i5 = i8;
                    i7++;
                } else if (b4 < -32) {
                    cArr2[i7] = (char) (((b4 & 31) << 6) | (bArr[i8] & 63));
                    i5 = i8 + 1;
                    i7++;
                } else if (b4 < -16) {
                    int i9 = i8 + 1;
                    cArr2[i7] = (char) (((b4 & 15) << 12) | ((bArr[i8] & 63) << 6) | (bArr[i9] & 63));
                    i5 = i9 + 1;
                    i7++;
                } else {
                    int i10 = i8 + 1;
                    int i11 = i10 + 1;
                    int i12 = ((b4 & 7) << 18) | ((bArr[i8] & 63) << 12) | ((bArr[i10] & 63) << 6) | (bArr[i11] & 63);
                    int i13 = i7 + 1;
                    cArr2[i7] = (char) ((i12 >>> 10) + 55232);
                    i7 = i13 + 1;
                    cArr2[i13] = (char) ((i12 & 1023) + 56320);
                    i5 = i11 + 1;
                }
            }
            if (i5 <= i6) {
                str = new String(cArr2, 0, i7);
            } else {
                throw new IllegalArgumentException("Invalid String");
            }
        }
        this.f39858b += i4;
        return str;
    }

    public final void a(int i4, int i5) {
        byte[] bArr = this.f39857a;
        int i6 = i4 + 1;
        bArr[i4] = (byte) i5;
        int i7 = i6 + 1;
        bArr[i6] = (byte) (i5 >> 8);
        bArr[i7] = (byte) (i5 >> 16);
        bArr[i7 + 1] = (byte) (i5 >> 24);
    }

    public final void a(int i4, long j4) {
        byte[] bArr = this.f39857a;
        int i5 = i4 + 1;
        bArr[i4] = (byte) j4;
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j4 >> 8);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j4 >> 16);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (j4 >> 24);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (j4 >> 32);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (j4 >> 40);
        bArr[i10] = (byte) (j4 >> 48);
        bArr[i10 + 1] = (byte) (j4 >> 56);
    }

    public final void a(long j4) {
        a(this.f39858b, j4);
        this.f39858b += 8;
    }

    public final void a(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.f39857a, this.f39858b, length);
            this.f39858b += length;
        }
    }

    public final void a(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        byte[] bArr = this.f39857a;
        int i4 = this.f39858b;
        int i5 = 0;
        int length = str.length();
        while (i5 < length) {
            int i6 = i5 + 1;
            char charAt = str.charAt(i5);
            if (charAt < '\u0080') {
                bArr[i4] = (byte) charAt;
                i5 = i6;
                i4++;
            } else if (charAt < '\u0800') {
                int i7 = i4 + 1;
                bArr[i4] = (byte) ((charAt >>> 6) | 192);
                i4 = i7 + 1;
                bArr[i7] = (byte) ((charAt & '?') | 128);
                i5 = i6;
            } else if (charAt >= '\ud800' && charAt <= '\udfff') {
                int i8 = i6 + 1;
                int charAt2 = ((charAt << '\n') + str.charAt(i6)) - 56613888;
                int i9 = i4 + 1;
                bArr[i4] = (byte) ((charAt2 >>> 18) | 240);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i11 = i10 + 1;
                bArr[i10] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i4 = i11 + 1;
                bArr[i11] = (byte) ((charAt2 & 63) | 128);
                i5 = i8;
            } else {
                int i12 = i4 + 1;
                bArr[i4] = (byte) ((charAt >>> '\f') | 224);
                int i13 = i12 + 1;
                bArr[i12] = (byte) (((charAt >>> 6) & 63) | 128);
                bArr[i13] = (byte) ((charAt & '?') | 128);
                i5 = i6;
                i4 = i13 + 1;
            }
        }
        this.f39858b = i4;
    }
}
