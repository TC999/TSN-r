package cn.bluemobi.dylan.base.utils;

import com.alibaba.fastjson.asm.Opcodes;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import okio.Utf8;

/* compiled from: Base64.java */
/* renamed from: cn.bluemobi.dylan.base.utils.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class C1138b {

    /* renamed from: a */
    private static final int f1793a = 128;

    /* renamed from: b */
    private static final int f1794b = 64;

    /* renamed from: c */
    private static final int f1795c = 24;

    /* renamed from: d */
    private static final int f1796d = 8;

    /* renamed from: e */
    private static final int f1797e = 16;

    /* renamed from: f */
    private static final int f1798f = 4;

    /* renamed from: g */
    private static final int f1799g = -128;

    /* renamed from: h */
    private static final char f1800h = '=';

    /* renamed from: i */
    private static final boolean f1801i = false;

    /* renamed from: j */
    private static final byte[] f1802j = new byte[128];

    /* renamed from: k */
    private static final char[] f1803k = new char[64];

    static {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < 128; i4++) {
            f1802j[i4] = -1;
        }
        for (int i5 = 90; i5 >= 65; i5--) {
            f1802j[i5] = (byte) (i5 - 65);
        }
        int i6 = 122;
        while (true) {
            i = 26;
            if (i6 < 97) {
                break;
            }
            f1802j[i6] = (byte) ((i6 - 97) + 26);
            i6--;
        }
        int i7 = 57;
        while (true) {
            i2 = 52;
            if (i7 < 48) {
                break;
            }
            f1802j[i7] = (byte) ((i7 - 48) + 52);
            i7--;
        }
        byte[] bArr = f1802j;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
        for (int i8 = 0; i8 <= 25; i8++) {
            f1803k[i8] = (char) (i8 + 65);
        }
        int i9 = 0;
        while (i <= 51) {
            f1803k[i] = (char) (i9 + 97);
            i++;
            i9++;
        }
        while (i2 <= 61) {
            f1803k[i2] = (char) (i3 + 48);
            i2++;
            i3++;
        }
        char[] cArr = f1803k;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    /* renamed from: a */
    public static byte[] m57769a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int m57764f = m57764f(charArray);
        if (m57764f % 4 != 0) {
            return null;
        }
        int i = m57764f / 4;
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
            if (m57767c(c)) {
                int i6 = i5 + 1;
                char c2 = charArray[i5];
                if (m57767c(c2)) {
                    int i7 = i6 + 1;
                    char c3 = charArray[i6];
                    if (m57767c(c3)) {
                        int i8 = i7 + 1;
                        char c4 = charArray[i7];
                        if (m57767c(c4)) {
                            byte[] bArr2 = f1802j;
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
        if (m57767c(c5)) {
            int i12 = i11 + 1;
            char c6 = charArray[i11];
            if (m57767c(c6)) {
                byte[] bArr3 = f1802j;
                byte b5 = bArr3[c5];
                byte b6 = bArr3[c6];
                int i13 = i12 + 1;
                char c7 = charArray[i12];
                char c8 = charArray[i13];
                if (m57767c(c7) && m57767c(c8)) {
                    byte b7 = bArr3[c7];
                    byte b8 = bArr3[c8];
                    int i14 = i4 + 1;
                    bArr[i4] = (byte) ((b5 << 2) | (b6 >> 4));
                    bArr[i14] = (byte) (((b6 & 15) << 4) | ((b7 >> 2) & 15));
                    bArr[i14 + 1] = (byte) (b8 | (b7 << 6));
                    return bArr;
                } else if (m57766d(c7) && m57766d(c8)) {
                    if ((b6 & 15) != 0) {
                        return null;
                    }
                    int i15 = i2 * 3;
                    byte[] bArr4 = new byte[i15 + 1];
                    System.arraycopy(bArr, 0, bArr4, 0, i15);
                    bArr4[i4] = (byte) ((b5 << 2) | (b6 >> 4));
                    return bArr4;
                } else if (m57766d(c7) || !m57766d(c8)) {
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
    public static String m57768b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
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
            byte b = bArr[i4];
            int i7 = i6 + 1;
            byte b2 = bArr[i6];
            int i8 = i7 + 1;
            byte b3 = bArr[i7];
            byte b4 = (byte) (b2 & 15);
            byte b5 = (byte) (b & 3);
            int i9 = b & Byte.MIN_VALUE;
            int i10 = b >> 2;
            if (i9 != 0) {
                i10 ^= Opcodes.CHECKCAST;
            }
            byte b6 = (byte) i10;
            int i11 = b2 & Byte.MIN_VALUE;
            int i12 = b2 >> 4;
            if (i11 != 0) {
                i12 ^= GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;
            }
            byte b7 = (byte) i12;
            int i13 = (b3 & Byte.MIN_VALUE) == 0 ? b3 >> 6 : (b3 >> 6) ^ 252;
            int i14 = i5 + 1;
            char[] cArr2 = f1803k;
            cArr[i5] = cArr2[b6];
            int i15 = i14 + 1;
            cArr[i14] = cArr2[(b5 << 4) | b7];
            int i16 = i15 + 1;
            cArr[i15] = cArr2[(b4 << 2) | ((byte) i13)];
            cArr[i16] = cArr2[b3 & Utf8.REPLACEMENT_BYTE];
            i3++;
            i5 = i16 + 1;
            i4 = i8;
        }
        if (i == 8) {
            byte b8 = bArr[i4];
            byte b9 = (byte) (b8 & 3);
            int i17 = b8 & Byte.MIN_VALUE;
            int i18 = b8 >> 2;
            if (i17 != 0) {
                i18 ^= Opcodes.CHECKCAST;
            }
            int i19 = i5 + 1;
            char[] cArr3 = f1803k;
            cArr[i5] = cArr3[(byte) i18];
            int i20 = i19 + 1;
            cArr[i19] = cArr3[b9 << 4];
            cArr[i20] = f1800h;
            cArr[i20 + 1] = f1800h;
        } else if (i == 16) {
            byte b10 = bArr[i4];
            byte b11 = bArr[i4 + 1];
            byte b12 = (byte) (b11 & 15);
            byte b13 = (byte) (b10 & 3);
            int i21 = b10 & Byte.MIN_VALUE;
            int i22 = b10 >> 2;
            if (i21 != 0) {
                i22 ^= Opcodes.CHECKCAST;
            }
            byte b14 = (byte) i22;
            int i23 = b11 & Byte.MIN_VALUE;
            int i24 = b11 >> 4;
            if (i23 != 0) {
                i24 ^= GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;
            }
            int i25 = i5 + 1;
            char[] cArr4 = f1803k;
            cArr[i5] = cArr4[b14];
            int i26 = i25 + 1;
            cArr[i25] = cArr4[((byte) i24) | (b13 << 4)];
            cArr[i26] = cArr4[b12 << 2];
            cArr[i26 + 1] = f1800h;
        }
        return new String(cArr);
    }

    /* renamed from: c */
    private static boolean m57767c(char c) {
        return c < 128 && f1802j[c] != -1;
    }

    /* renamed from: d */
    private static boolean m57766d(char c) {
        return c == '=';
    }

    /* renamed from: e */
    private static boolean m57765e(char c) {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }

    /* renamed from: f */
    private static int m57764f(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (!m57765e(cArr[i2])) {
                cArr[i] = cArr[i2];
                i++;
            }
        }
        return i;
    }
}
