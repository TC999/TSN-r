package cn.bluemobi.dylan.base.utils;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Base64.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1779a = 128;

    /* renamed from: b  reason: collision with root package name */
    private static final int f1780b = 64;

    /* renamed from: c  reason: collision with root package name */
    private static final int f1781c = 24;

    /* renamed from: d  reason: collision with root package name */
    private static final int f1782d = 8;

    /* renamed from: e  reason: collision with root package name */
    private static final int f1783e = 16;

    /* renamed from: f  reason: collision with root package name */
    private static final int f1784f = 4;

    /* renamed from: g  reason: collision with root package name */
    private static final int f1785g = -128;

    /* renamed from: h  reason: collision with root package name */
    private static final char f1786h = '=';

    /* renamed from: i  reason: collision with root package name */
    private static final boolean f1787i = false;

    /* renamed from: j  reason: collision with root package name */
    private static final byte[] f1788j = new byte[128];

    /* renamed from: k  reason: collision with root package name */
    private static final char[] f1789k = new char[64];

    static {
        int i4;
        int i5;
        int i6 = 0;
        for (int i7 = 0; i7 < 128; i7++) {
            f1788j[i7] = -1;
        }
        for (int i8 = 90; i8 >= 65; i8--) {
            f1788j[i8] = (byte) (i8 - 65);
        }
        int i9 = 122;
        while (true) {
            i4 = 26;
            if (i9 < 97) {
                break;
            }
            f1788j[i9] = (byte) ((i9 - 97) + 26);
            i9--;
        }
        int i10 = 57;
        while (true) {
            i5 = 52;
            if (i10 < 48) {
                break;
            }
            f1788j[i10] = (byte) ((i10 - 48) + 52);
            i10--;
        }
        byte[] bArr = f1788j;
        bArr[43] = 62;
        bArr[47] = 63;
        for (int i11 = 0; i11 <= 25; i11++) {
            f1789k[i11] = (char) (i11 + 65);
        }
        int i12 = 0;
        while (i4 <= 51) {
            f1789k[i4] = (char) (i12 + 97);
            i4++;
            i12++;
        }
        while (i5 <= 61) {
            f1789k[i5] = (char) (i6 + 48);
            i5++;
            i6++;
        }
        char[] cArr = f1789k;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int f4 = f(charArray);
        if (f4 % 4 != 0) {
            return null;
        }
        int i4 = f4 / 4;
        if (i4 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i4 * 3];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < i4 - 1) {
            int i8 = i6 + 1;
            char c4 = charArray[i6];
            if (c(c4)) {
                int i9 = i8 + 1;
                char c5 = charArray[i8];
                if (c(c5)) {
                    int i10 = i9 + 1;
                    char c6 = charArray[i9];
                    if (c(c6)) {
                        int i11 = i10 + 1;
                        char c7 = charArray[i10];
                        if (c(c7)) {
                            byte[] bArr2 = f1788j;
                            byte b4 = bArr2[c4];
                            byte b5 = bArr2[c5];
                            byte b6 = bArr2[c6];
                            byte b7 = bArr2[c7];
                            int i12 = i7 + 1;
                            bArr[i7] = (byte) ((b4 << 2) | (b5 >> 4));
                            int i13 = i12 + 1;
                            bArr[i12] = (byte) (((b5 & 15) << 4) | ((b6 >> 2) & 15));
                            i7 = i13 + 1;
                            bArr[i13] = (byte) ((b6 << 6) | b7);
                            i5++;
                            i6 = i11;
                        }
                    }
                }
            }
            return null;
        }
        int i14 = i6 + 1;
        char c8 = charArray[i6];
        if (c(c8)) {
            int i15 = i14 + 1;
            char c9 = charArray[i14];
            if (c(c9)) {
                byte[] bArr3 = f1788j;
                byte b8 = bArr3[c8];
                byte b9 = bArr3[c9];
                int i16 = i15 + 1;
                char c10 = charArray[i15];
                char c11 = charArray[i16];
                if (c(c10) && c(c11)) {
                    byte b10 = bArr3[c10];
                    byte b11 = bArr3[c11];
                    int i17 = i7 + 1;
                    bArr[i7] = (byte) ((b8 << 2) | (b9 >> 4));
                    bArr[i17] = (byte) (((b9 & 15) << 4) | ((b10 >> 2) & 15));
                    bArr[i17 + 1] = (byte) (b11 | (b10 << 6));
                    return bArr;
                } else if (d(c10) && d(c11)) {
                    if ((b9 & 15) != 0) {
                        return null;
                    }
                    int i18 = i5 * 3;
                    byte[] bArr4 = new byte[i18 + 1];
                    System.arraycopy(bArr, 0, bArr4, 0, i18);
                    bArr4[i7] = (byte) ((b8 << 2) | (b9 >> 4));
                    return bArr4;
                } else if (d(c10) || !d(c11)) {
                    return null;
                } else {
                    byte b12 = bArr3[c10];
                    if ((b12 & 3) != 0) {
                        return null;
                    }
                    int i19 = i5 * 3;
                    byte[] bArr5 = new byte[i19 + 2];
                    System.arraycopy(bArr, 0, bArr5, 0, i19);
                    bArr5[i7] = (byte) ((b8 << 2) | (b9 >> 4));
                    bArr5[i7 + 1] = (byte) (((b12 >> 2) & 15) | ((b9 & 15) << 4));
                    return bArr5;
                }
            }
            return null;
        }
        return null;
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i4 = length % 24;
        int i5 = length / 24;
        char[] cArr = new char[(i4 != 0 ? i5 + 1 : i5) * 4];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < i5) {
            int i9 = i7 + 1;
            byte b4 = bArr[i7];
            int i10 = i9 + 1;
            byte b5 = bArr[i9];
            int i11 = i10 + 1;
            byte b6 = bArr[i10];
            byte b7 = (byte) (b5 & 15);
            byte b8 = (byte) (b4 & 3);
            int i12 = b4 & Byte.MIN_VALUE;
            int i13 = b4 >> 2;
            if (i12 != 0) {
                i13 ^= 192;
            }
            byte b9 = (byte) i13;
            int i14 = b5 & Byte.MIN_VALUE;
            int i15 = b5 >> 4;
            if (i14 != 0) {
                i15 ^= 240;
            }
            byte b10 = (byte) i15;
            int i16 = (b6 & Byte.MIN_VALUE) == 0 ? b6 >> 6 : (b6 >> 6) ^ MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF;
            int i17 = i8 + 1;
            char[] cArr2 = f1789k;
            cArr[i8] = cArr2[b9];
            int i18 = i17 + 1;
            cArr[i17] = cArr2[(b8 << 4) | b10];
            int i19 = i18 + 1;
            cArr[i18] = cArr2[(b7 << 2) | ((byte) i16)];
            cArr[i19] = cArr2[b6 & 63];
            i6++;
            i8 = i19 + 1;
            i7 = i11;
        }
        if (i4 == 8) {
            byte b11 = bArr[i7];
            byte b12 = (byte) (b11 & 3);
            int i20 = b11 & Byte.MIN_VALUE;
            int i21 = b11 >> 2;
            if (i20 != 0) {
                i21 ^= 192;
            }
            int i22 = i8 + 1;
            char[] cArr3 = f1789k;
            cArr[i8] = cArr3[(byte) i21];
            int i23 = i22 + 1;
            cArr[i22] = cArr3[b12 << 4];
            cArr[i23] = '=';
            cArr[i23 + 1] = '=';
        } else if (i4 == 16) {
            byte b13 = bArr[i7];
            byte b14 = bArr[i7 + 1];
            byte b15 = (byte) (b14 & 15);
            byte b16 = (byte) (b13 & 3);
            int i24 = b13 & Byte.MIN_VALUE;
            int i25 = b13 >> 2;
            if (i24 != 0) {
                i25 ^= 192;
            }
            byte b17 = (byte) i25;
            int i26 = b14 & Byte.MIN_VALUE;
            int i27 = b14 >> 4;
            if (i26 != 0) {
                i27 ^= 240;
            }
            int i28 = i8 + 1;
            char[] cArr4 = f1789k;
            cArr[i8] = cArr4[b17];
            int i29 = i28 + 1;
            cArr[i28] = cArr4[((byte) i27) | (b16 << 4)];
            cArr[i29] = cArr4[b15 << 2];
            cArr[i29 + 1] = '=';
        }
        return new String(cArr);
    }

    private static boolean c(char c4) {
        return c4 < '\u0080' && f1788j[c4] != -1;
    }

    private static boolean d(char c4) {
        return c4 == '=';
    }

    private static boolean e(char c4) {
        return c4 == ' ' || c4 == '\r' || c4 == '\n' || c4 == '\t';
    }

    private static int f(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (!e(cArr[i5])) {
                cArr[i4] = cArr[i5];
                i4++;
            }
        }
        return i4;
    }
}
