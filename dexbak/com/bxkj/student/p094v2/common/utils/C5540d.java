package com.bxkj.student.p094v2.common.utils;

import com.alibaba.fastjson.asm.Opcodes;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import okio.Utf8;

/* compiled from: Base64.java */
/* renamed from: com.bxkj.student.v2.common.utils.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C5540d {

    /* renamed from: a */
    private static final int f20094a = 128;

    /* renamed from: b */
    private static final int f20095b = 64;

    /* renamed from: c */
    private static final int f20096c = 24;

    /* renamed from: d */
    private static final int f20097d = 8;

    /* renamed from: e */
    private static final int f20098e = 16;

    /* renamed from: f */
    private static final int f20099f = 4;

    /* renamed from: g */
    private static final int f20100g = -128;

    /* renamed from: h */
    private static final char f20101h = '=';

    /* renamed from: i */
    private static final boolean f20102i = false;

    /* renamed from: j */
    private static final byte[] f20103j = new byte[128];

    /* renamed from: k */
    private static final char[] f20104k = new char[64];

    static {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < 128; i4++) {
            f20103j[i4] = -1;
        }
        for (int i5 = 90; i5 >= 65; i5--) {
            f20103j[i5] = (byte) (i5 - 65);
        }
        int i6 = 122;
        while (true) {
            i = 26;
            if (i6 < 97) {
                break;
            }
            f20103j[i6] = (byte) ((i6 - 97) + 26);
            i6--;
        }
        int i7 = 57;
        while (true) {
            i2 = 52;
            if (i7 < 48) {
                break;
            }
            f20103j[i7] = (byte) ((i7 - 48) + 52);
            i7--;
        }
        byte[] bArr = f20103j;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
        for (int i8 = 0; i8 <= 25; i8++) {
            f20104k[i8] = (char) (i8 + 65);
        }
        int i9 = 0;
        while (i <= 51) {
            f20104k[i] = (char) (i9 + 97);
            i++;
            i9++;
        }
        while (i2 <= 61) {
            f20104k[i2] = (char) (i3 + 48);
            i2++;
            i3++;
        }
        char[] cArr = f20104k;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    /* renamed from: a */
    public static byte[] m39143a(String encoded) {
        if (encoded == null) {
            return null;
        }
        char[] charArray = encoded.toCharArray();
        int m39138f = m39138f(charArray);
        if (m39138f % 4 != 0) {
            return null;
        }
        int i = m39138f / 4;
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i * 3];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < i - 1) {
            int i5 = i3 + 1;
            char c = charArray[i3];
            if (m39141c(c)) {
                int i6 = i5 + 1;
                char c2 = charArray[i5];
                if (m39141c(c2)) {
                    int i7 = i6 + 1;
                    char c3 = charArray[i6];
                    if (m39141c(c3)) {
                        int i8 = i7 + 1;
                        char c4 = charArray[i7];
                        if (m39141c(c4)) {
                            byte[] bArr2 = f20103j;
                            byte b = bArr2[c];
                            byte b2 = bArr2[c2];
                            byte b3 = bArr2[c3];
                            byte b4 = bArr2[c4];
                            int i9 = i4 + 1;
                            bArr[i4] = (byte) ((b << 2) | (b2 >> 4));
                            int i10 = i9 + 1;
                            bArr[i9] = (byte) (((b2 & 15) << 4) | ((b3 >> 2) & 15));
                            i4 = i10 + 1;
                            bArr[i10] = (byte) ((b3 << 6) | b4);
                            i2++;
                            i3 = i8;
                        }
                    }
                }
            }
            return null;
        }
        int i11 = i3 + 1;
        char c5 = charArray[i3];
        if (m39141c(c5)) {
            int i12 = i11 + 1;
            char c6 = charArray[i11];
            if (m39141c(c6)) {
                byte[] bArr3 = f20103j;
                byte b5 = bArr3[c5];
                byte b6 = bArr3[c6];
                int i13 = i12 + 1;
                char c7 = charArray[i12];
                char c8 = charArray[i13];
                if (m39141c(c7) && m39141c(c8)) {
                    byte b7 = bArr3[c7];
                    byte b8 = bArr3[c8];
                    int i14 = i4 + 1;
                    bArr[i4] = (byte) ((b5 << 2) | (b6 >> 4));
                    bArr[i14] = (byte) (((b6 & 15) << 4) | ((b7 >> 2) & 15));
                    bArr[i14 + 1] = (byte) (b8 | (b7 << 6));
                    return bArr;
                } else if (m39140d(c7) && m39140d(c8)) {
                    if ((b6 & 15) != 0) {
                        return null;
                    }
                    int i15 = i2 * 3;
                    byte[] bArr4 = new byte[i15 + 1];
                    System.arraycopy(bArr, 0, bArr4, 0, i15);
                    bArr4[i4] = (byte) ((b5 << 2) | (b6 >> 4));
                    return bArr4;
                } else if (m39140d(c7) || !m39140d(c8)) {
                    return null;
                } else {
                    byte b9 = bArr3[c7];
                    if ((b9 & 3) != 0) {
                        return null;
                    }
                    int i16 = i2 * 3;
                    byte[] bArr5 = new byte[i16 + 2];
                    System.arraycopy(bArr, 0, bArr5, 0, i16);
                    bArr5[i4] = (byte) ((b5 << 2) | (b6 >> 4));
                    bArr5[i4 + 1] = (byte) (((b9 >> 2) & 15) | ((b6 & 15) << 4));
                    return bArr5;
                }
            }
            return null;
        }
        return null;
    }

    /* renamed from: b */
    public static String m39142b(byte[] binaryData) {
        if (binaryData == null) {
            return null;
        }
        int length = binaryData.length * 8;
        if (length == 0) {
            return "";
        }
        int i = length % 24;
        int i2 = length / 24;
        char[] cArr = new char[(i != 0 ? i2 + 1 : i2) * 4];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i2) {
            int i6 = i4 + 1;
            byte b = binaryData[i4];
            int i7 = i6 + 1;
            byte b2 = binaryData[i6];
            int i8 = i7 + 1;
            byte b3 = binaryData[i7];
            byte b4 = (byte) (b2 & 15);
            byte b5 = (byte) (b & 3);
            byte b6 = (byte) ((b & Byte.MIN_VALUE) == 0 ? b >> 2 : (b >> 2) ^ Opcodes.CHECKCAST);
            byte b7 = (byte) ((b2 & Byte.MIN_VALUE) == 0 ? b2 >> 4 : (b2 >> 4) ^ GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN);
            int i9 = (b3 & Byte.MIN_VALUE) == 0 ? b3 >> 6 : (b3 >> 6) ^ 252;
            int i10 = i5 + 1;
            char[] cArr2 = f20104k;
            cArr[i5] = cArr2[b6];
            int i11 = i10 + 1;
            cArr[i10] = cArr2[(b5 << 4) | b7];
            int i12 = i11 + 1;
            cArr[i11] = cArr2[(b4 << 2) | ((byte) i9)];
            cArr[i12] = cArr2[b3 & Utf8.REPLACEMENT_BYTE];
            i3++;
            i5 = i12 + 1;
            i4 = i8;
        }
        if (i == 8) {
            byte b8 = binaryData[i4];
            byte b9 = (byte) (b8 & 3);
            int i13 = (b8 & Byte.MIN_VALUE) == 0 ? b8 >> 2 : (b8 >> 2) ^ Opcodes.CHECKCAST;
            int i14 = i5 + 1;
            char[] cArr3 = f20104k;
            cArr[i5] = cArr3[(byte) i13];
            int i15 = i14 + 1;
            cArr[i14] = cArr3[b9 << 4];
            cArr[i15] = f20101h;
            cArr[i15 + 1] = f20101h;
        } else if (i == 16) {
            byte b10 = binaryData[i4];
            byte b11 = binaryData[i4 + 1];
            byte b12 = (byte) (b11 & 15);
            byte b13 = (byte) (b10 & 3);
            byte b14 = (byte) ((b10 & Byte.MIN_VALUE) == 0 ? b10 >> 2 : (b10 >> 2) ^ Opcodes.CHECKCAST);
            int i16 = (b11 & Byte.MIN_VALUE) == 0 ? b11 >> 4 : (b11 >> 4) ^ GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;
            int i17 = i5 + 1;
            char[] cArr4 = f20104k;
            cArr[i5] = cArr4[b14];
            int i18 = i17 + 1;
            cArr[i17] = cArr4[((byte) i16) | (b13 << 4)];
            cArr[i18] = cArr4[b12 << 2];
            cArr[i18 + 1] = f20101h;
        }
        return new String(cArr);
    }

    /* renamed from: c */
    private static boolean m39141c(char octect) {
        return octect < 128 && f20103j[octect] != -1;
    }

    /* renamed from: d */
    private static boolean m39140d(char octect) {
        return octect == '=';
    }

    /* renamed from: e */
    private static boolean m39139e(char octect) {
        return octect == ' ' || octect == '\r' || octect == '\n' || octect == '\t';
    }

    /* renamed from: f */
    private static int m39138f(char[] data) {
        if (data == null) {
            return 0;
        }
        int length = data.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (!m39139e(data[i2])) {
                data[i] = data[i2];
                i++;
            }
        }
        return i;
    }
}
