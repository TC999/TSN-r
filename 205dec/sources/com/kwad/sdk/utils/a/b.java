package com.kwad.sdk.utils.a;

import java.nio.charset.Charset;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private char[] aRn;
    public byte[] aRo;
    public int position;

    public b(int i4) {
        this(new byte[i4], 0);
    }

    private int C(int i4, int i5) {
        while ((i5 & (-128)) != 0) {
            this.aRo[i4] = (byte) ((i5 & 127) | 128);
            i5 >>>= 7;
            i4++;
        }
        int i6 = i4 + 1;
        this.aRo[i4] = (byte) i5;
        return i6;
    }

    public static int eg(int i4) {
        if ((i4 >> 7) == 0) {
            return 1;
        }
        if ((i4 >> 14) == 0) {
            return 2;
        }
        if ((i4 >> 21) == 0) {
            return 3;
        }
        return (i4 >> 28) == 0 ? 4 : 5;
    }

    private char[] ei(int i4) {
        char[] cArr = this.aRn;
        if (cArr == null) {
            if (i4 <= 256) {
                this.aRn = new char[256];
            } else {
                this.aRn = new char[2048];
            }
        } else if (cArr.length < i4) {
            this.aRn = new char[2048];
        }
        return this.aRn;
    }

    private String ej(int i4) {
        if (i4 > 2048) {
            return new String(this.aRo, this.position, i4, UTF_8);
        }
        char[] ei = ei(i4);
        byte[] bArr = this.aRo;
        int i5 = this.position;
        int i6 = i4 + i5;
        int i7 = 0;
        while (i5 < i6) {
            int i8 = i5 + 1;
            byte b4 = bArr[i5];
            if (b4 > 0) {
                ei[i7] = (char) (b4 ^ 1);
                i5 = i8;
                i7++;
            } else if (b4 < -32) {
                ei[i7] = (char) (((b4 & 31) << 6) | (bArr[i8] & 63));
                i5 = i8 + 1;
                i7++;
            } else if (b4 < -16) {
                int i9 = i8 + 1;
                ei[i7] = (char) (((b4 & 15) << 12) | ((bArr[i8] & 63) << 6) | (bArr[i9] & 63));
                i5 = i9 + 1;
                i7++;
            } else {
                int i10 = i8 + 1;
                int i11 = i10 + 1;
                int i12 = ((b4 & 7) << 18) | ((bArr[i8] & 63) << 12) | ((bArr[i10] & 63) << 6) | (bArr[i11] & 63);
                int i13 = i7 + 1;
                ei[i7] = (char) ((i12 >>> 10) + 55232);
                i7 = i13 + 1;
                ei[i13] = (char) ((i12 & 1023) + 56320);
                i5 = i11 + 1;
            }
        }
        if (i5 <= i6) {
            return new String(ei, 0, i7);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private String ek(int i4) {
        if (i4 > 2048) {
            return new String(this.aRo, this.position, i4, UTF_8);
        }
        char[] ei = ei(i4);
        byte[] bArr = this.aRo;
        int i5 = this.position;
        int i6 = i4 + i5;
        int i7 = 0;
        while (i5 < i6) {
            int i8 = i5 + 1;
            byte b4 = bArr[i5];
            if (b4 > 0) {
                ei[i7] = (char) b4;
                i5 = i8;
                i7++;
            } else if (b4 < -32) {
                ei[i7] = (char) (((b4 & 31) << 6) | (bArr[i8] & 63));
                i5 = i8 + 1;
                i7++;
            } else if (b4 < -16) {
                int i9 = i8 + 1;
                ei[i7] = (char) (((b4 & 15) << 12) | ((bArr[i8] & 63) << 6) | (bArr[i9] & 63));
                i5 = i9 + 1;
                i7++;
            } else {
                int i10 = i8 + 1;
                int i11 = i10 + 1;
                int i12 = ((b4 & 7) << 18) | ((bArr[i8] & 63) << 12) | ((bArr[i10] & 63) << 6) | (bArr[i11] & 63);
                int i13 = i7 + 1;
                ei[i7] = (char) ((i12 >>> 10) + 55232);
                i7 = i13 + 1;
                ei[i13] = (char) ((i12 & 1023) + 56320);
                i5 = i11 + 1;
            }
        }
        if (i5 <= i6) {
            return new String(ei, 0, i7);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    private long getLong(int i4) {
        byte[] bArr = this.aRo;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        int i9 = i8 + 1;
        int i10 = i9 + 1;
        return (bArr[i10 + 1] << 56) | (bArr[i4] & 255) | ((bArr[i5] & 255) << 8) | ((bArr[i6] & 255) << 16) | ((bArr[i7] & 255) << 24) | ((bArr[i8] & 255) << 32) | ((bArr[i9] & 255) << 40) | ((255 & bArr[i10]) << 48);
    }

    public static int he(String str) {
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
                i4 = i6 + 1;
                i5 += 4;
            }
            i4 = i6;
        }
        return i5;
    }

    private void hf(String str) {
        byte[] bArr = this.aRo;
        int i4 = this.position;
        int length = str.length();
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + 1;
            char charAt = str.charAt(i5);
            if (charAt < '\u0080') {
                bArr[i4] = (byte) (charAt ^ 1);
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
        this.position = i4;
    }

    public static byte[] hg(String str) {
        byte[] bArr = new byte[he(str)];
        int length = str.length();
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = i4 + 1;
            char charAt = str.charAt(i4);
            if (charAt < '\u0080') {
                bArr[i5] = (byte) (charAt ^ 1);
                i4 = i6;
                i5++;
            } else if (charAt < '\u0800') {
                int i7 = i5 + 1;
                bArr[i5] = (byte) ((charAt >>> 6) | 192);
                i5 = i7 + 1;
                bArr[i7] = (byte) ((charAt & '?') | 128);
                i4 = i6;
            } else if (charAt >= '\ud800' && charAt <= '\udfff') {
                int i8 = i6 + 1;
                int charAt2 = ((charAt << '\n') + str.charAt(i6)) - 56613888;
                int i9 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 18) | 240);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((charAt2 >>> 12) & 63) | 128);
                int i11 = i10 + 1;
                bArr[i10] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i5 = i11 + 1;
                bArr[i11] = (byte) ((charAt2 & 63) | 128);
                i4 = i8;
            } else {
                int i12 = i5 + 1;
                bArr[i5] = (byte) ((charAt >>> '\f') | 224);
                int i13 = i12 + 1;
                bArr[i12] = (byte) (((charAt >>> 6) & 63) | 128);
                bArr[i13] = (byte) ((charAt & '?') | 128);
                i4 = i6;
                i5 = i13 + 1;
            }
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String j(byte[] bArr, int i4) {
        char[] cArr = new char[bArr.length];
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            int i7 = i5 + 1;
            byte b4 = bArr[i5];
            if (b4 > 0) {
                cArr[i6] = (char) (b4 ^ 1);
                i5 = i7;
                i6++;
            } else if (b4 < -32) {
                cArr[i6] = (char) (((b4 & 31) << 6) | (bArr[i7] & 63));
                i5 = i7 + 1;
                i6++;
            } else if (b4 < -16) {
                int i8 = i7 + 1;
                cArr[i6] = (char) (((b4 & 15) << 12) | ((bArr[i7] & 63) << 6) | (bArr[i8] & 63));
                i5 = i8 + 1;
                i6++;
            } else {
                int i9 = i7 + 1;
                int i10 = i9 + 1;
                int i11 = ((b4 & 7) << 18) | ((bArr[i7] & 63) << 12) | ((bArr[i9] & 63) << 6) | (bArr[i10] & 63);
                int i12 = i6 + 1;
                cArr[i6] = (char) ((i11 >>> 10) + 55232);
                i6 = i12 + 1;
                cArr[i12] = (char) ((i11 & 1023) + 56320);
                i5 = i10 + 1;
            }
        }
        if (i5 <= i4) {
            return new String(cArr, 0, i6);
        }
        throw new IllegalArgumentException("Invalid String");
    }

    public final void B(int i4, int i5) {
        byte[] bArr = this.aRo;
        int i6 = i4 + 1;
        bArr[i4] = (byte) i5;
        int i7 = i6 + 1;
        bArr[i6] = (byte) (i5 >> 8);
        bArr[i7] = (byte) (i5 >> 16);
        bArr[i7 + 1] = (byte) (i5 >> 24);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long D(int i4, int i5) {
        long j4 = 0;
        if (i5 <= 0) {
            return 0L;
        }
        int i6 = i5 >> 3;
        int i7 = i5 & 7;
        int i8 = 0;
        int i9 = i4;
        for (int i10 = 0; i10 < i6; i10++) {
            j4 ^= getLong(i9);
            i9 += 8;
        }
        int i11 = i7 << 3;
        while (i8 < i11) {
            j4 ^= (this.aRo[i9] & 255) << i8;
            i8 += 8;
            i9++;
        }
        int i12 = (i4 & 7) << 3;
        return (j4 >>> (64 - i12)) | (j4 << i12);
    }

    public final int Nt() {
        byte[] bArr = this.aRo;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        byte b4 = bArr[i4];
        if ((b4 >> 7) == 0) {
            return b4;
        }
        int i6 = i5 + 1;
        this.position = i6;
        int i7 = (b4 & Byte.MAX_VALUE) | (bArr[i5] << 7);
        if ((i7 >> 14) == 0) {
            return i7;
        }
        int i8 = i6 + 1;
        this.position = i8;
        int i9 = (i7 & 16383) | (bArr[i6] << 14);
        if ((i9 >> 21) == 0) {
            return i9;
        }
        int i10 = i8 + 1;
        this.position = i10;
        int i11 = (i9 & 2097151) | (bArr[i8] << 21);
        if ((i11 >> 28) == 0) {
            return i11;
        }
        this.position = i10 + 1;
        return (bArr[i10] << 28) | (i11 & 268435455);
    }

    public final void a(short s3) {
        byte[] bArr = this.aRo;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        bArr[i4] = (byte) s3;
        this.position = i5 + 1;
        bArr[i5] = (byte) (s3 >> 8);
    }

    public final void aH(long j4) {
        f(this.position, j4);
        this.position += 8;
    }

    public final void e(byte b4) {
        byte[] bArr = this.aRo;
        int i4 = this.position;
        this.position = i4 + 1;
        bArr[i4] = b4;
    }

    public final void ee(int i4) {
        byte[] bArr = this.aRo;
        int i5 = this.position;
        int i6 = i5 + 1;
        this.position = i6;
        bArr[i5] = (byte) i4;
        int i7 = i6 + 1;
        this.position = i7;
        bArr[i6] = (byte) (i4 >> 8);
        int i8 = i7 + 1;
        this.position = i8;
        bArr[i7] = (byte) (i4 >> 16);
        this.position = i8 + 1;
        bArr[i8] = (byte) (i4 >> 24);
    }

    public final void ef(int i4) {
        this.position = C(this.position, i4);
    }

    public final String eh(int i4) {
        if (i4 < 0) {
            return null;
        }
        if (i4 == 0) {
            return "";
        }
        String ek = ek(i4);
        this.position += i4;
        return ek;
    }

    public final void f(int i4, long j4) {
        byte[] bArr = this.aRo;
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

    public final byte get() {
        byte[] bArr = this.aRo;
        int i4 = this.position;
        this.position = i4 + 1;
        return bArr[i4];
    }

    public final byte[] getBytes(int i4) {
        byte[] bArr = new byte[i4];
        System.arraycopy(this.aRo, this.position, bArr, 0, i4);
        this.position += i4;
        return bArr;
    }

    public final double getDouble() {
        return Double.longBitsToDouble(getLong());
    }

    public final float getFloat() {
        return Float.intBitsToFloat(getInt());
    }

    public final int getInt() {
        byte[] bArr = this.aRo;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        int i6 = i5 + 1;
        this.position = i6;
        int i7 = (bArr[i4] & 255) | ((bArr[i5] & 255) << 8);
        int i8 = i6 + 1;
        this.position = i8;
        int i9 = i7 | ((bArr[i6] & 255) << 16);
        this.position = i8 + 1;
        return (bArr[i8] << 24) | i9;
    }

    public final short getShort() {
        byte[] bArr = this.aRo;
        int i4 = this.position;
        int i5 = i4 + 1;
        this.position = i5;
        this.position = i5 + 1;
        return (short) ((bArr[i5] << 8) | (bArr[i4] & 255));
    }

    public final String getString(int i4) {
        if (i4 < 0) {
            return null;
        }
        if (i4 == 0) {
            return "";
        }
        String ej = ej(i4);
        this.position += i4;
        return ej;
    }

    public final void hd(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        hf(str);
    }

    public final void n(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.aRo, this.position, length);
            this.position += length;
        }
    }

    public b(byte[] bArr) {
        this(bArr, 0);
    }

    public final long getLong() {
        long j4 = getLong(this.position);
        this.position += 8;
        return j4;
    }

    public b(byte[] bArr, int i4) {
        this.aRn = null;
        this.aRo = bArr;
        this.position = i4;
    }
}
