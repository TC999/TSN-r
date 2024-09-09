package com.bxkj.student.v2.common.utils;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: Base64.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final int f23338a = 128;

    /* renamed from: b  reason: collision with root package name */
    private static final int f23339b = 64;

    /* renamed from: c  reason: collision with root package name */
    private static final int f23340c = 24;

    /* renamed from: d  reason: collision with root package name */
    private static final int f23341d = 8;

    /* renamed from: e  reason: collision with root package name */
    private static final int f23342e = 16;

    /* renamed from: f  reason: collision with root package name */
    private static final int f23343f = 4;

    /* renamed from: g  reason: collision with root package name */
    private static final int f23344g = -128;

    /* renamed from: h  reason: collision with root package name */
    private static final char f23345h = '=';

    /* renamed from: i  reason: collision with root package name */
    private static final boolean f23346i = false;

    /* renamed from: j  reason: collision with root package name */
    private static final byte[] f23347j = new byte[128];

    /* renamed from: k  reason: collision with root package name */
    private static final char[] f23348k = new char[64];

    static {
        int i4;
        int i5;
        int i6 = 0;
        for (int i7 = 0; i7 < 128; i7++) {
            f23347j[i7] = -1;
        }
        for (int i8 = 90; i8 >= 65; i8--) {
            f23347j[i8] = (byte) (i8 - 65);
        }
        int i9 = 122;
        while (true) {
            i4 = 26;
            if (i9 < 97) {
                break;
            }
            f23347j[i9] = (byte) ((i9 - 97) + 26);
            i9--;
        }
        int i10 = 57;
        while (true) {
            i5 = 52;
            if (i10 < 48) {
                break;
            }
            f23347j[i10] = (byte) ((i10 - 48) + 52);
            i10--;
        }
        byte[] bArr = f23347j;
        bArr[43] = 62;
        bArr[47] = 63;
        for (int i11 = 0; i11 <= 25; i11++) {
            f23348k[i11] = (char) (i11 + 65);
        }
        int i12 = 0;
        while (i4 <= 51) {
            f23348k[i4] = (char) (i12 + 97);
            i4++;
            i12++;
        }
        while (i5 <= 61) {
            f23348k[i5] = (char) (i6 + 48);
            i5++;
            i6++;
        }
        char[] cArr = f23348k;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    public static byte[] a(String encoded) {
        if (encoded == null) {
            return null;
        }
        char[] charArray = encoded.toCharArray();
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
                            byte[] bArr2 = f23347j;
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
                byte[] bArr3 = f23347j;
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

    public static String b(byte[] binaryData) {
        if (binaryData == null) {
            return null;
        }
        int length = binaryData.length * 8;
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
            byte b4 = binaryData[i7];
            int i10 = i9 + 1;
            byte b5 = binaryData[i9];
            int i11 = i10 + 1;
            byte b6 = binaryData[i10];
            byte b7 = (byte) (b5 & 15);
            byte b8 = (byte) (b4 & 3);
            byte b9 = (byte) ((b4 & Byte.MIN_VALUE) == 0 ? b4 >> 2 : (b4 >> 2) ^ 192);
            byte b10 = (byte) ((b5 & Byte.MIN_VALUE) == 0 ? b5 >> 4 : (b5 >> 4) ^ 240);
            int i12 = (b6 & Byte.MIN_VALUE) == 0 ? b6 >> 6 : (b6 >> 6) ^ MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF;
            int i13 = i8 + 1;
            char[] cArr2 = f23348k;
            cArr[i8] = cArr2[b9];
            int i14 = i13 + 1;
            cArr[i13] = cArr2[(b8 << 4) | b10];
            int i15 = i14 + 1;
            cArr[i14] = cArr2[(b7 << 2) | ((byte) i12)];
            cArr[i15] = cArr2[b6 & 63];
            i6++;
            i8 = i15 + 1;
            i7 = i11;
        }
        if (i4 == 8) {
            byte b11 = binaryData[i7];
            byte b12 = (byte) (b11 & 3);
            int i16 = (b11 & Byte.MIN_VALUE) == 0 ? b11 >> 2 : (b11 >> 2) ^ 192;
            int i17 = i8 + 1;
            char[] cArr3 = f23348k;
            cArr[i8] = cArr3[(byte) i16];
            int i18 = i17 + 1;
            cArr[i17] = cArr3[b12 << 4];
            cArr[i18] = '=';
            cArr[i18 + 1] = '=';
        } else if (i4 == 16) {
            byte b13 = binaryData[i7];
            byte b14 = binaryData[i7 + 1];
            byte b15 = (byte) (b14 & 15);
            byte b16 = (byte) (b13 & 3);
            byte b17 = (byte) ((b13 & Byte.MIN_VALUE) == 0 ? b13 >> 2 : (b13 >> 2) ^ 192);
            int i19 = (b14 & Byte.MIN_VALUE) == 0 ? b14 >> 4 : (b14 >> 4) ^ 240;
            int i20 = i8 + 1;
            char[] cArr4 = f23348k;
            cArr[i8] = cArr4[b17];
            int i21 = i20 + 1;
            cArr[i20] = cArr4[((byte) i19) | (b16 << 4)];
            cArr[i21] = cArr4[b15 << 2];
            cArr[i21 + 1] = '=';
        }
        return new String(cArr);
    }

    private static boolean c(char octect) {
        return octect < '\u0080' && f23347j[octect] != -1;
    }

    private static boolean d(char octect) {
        return octect == '=';
    }

    private static boolean e(char octect) {
        return octect == ' ' || octect == '\r' || octect == '\n' || octect == '\t';
    }

    private static int f(char[] data) {
        if (data == null) {
            return 0;
        }
        int length = data.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (!e(data[i5])) {
                data[i4] = data[i5];
                i4++;
            }
        }
        return i4;
    }
}
