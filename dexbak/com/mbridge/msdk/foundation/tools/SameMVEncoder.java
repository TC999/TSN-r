package com.mbridge.msdk.foundation.tools;

import com.alibaba.fastjson.asm.Opcodes;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.UByte;
import kotlin.jvm.internal.C14354n;
import okio.Utf8;

/* renamed from: com.mbridge.msdk.foundation.tools.y */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SameMVEncoder {

    /* renamed from: a */
    private static Map<Character, Character> f31167a;

    /* renamed from: b */
    private static final char[] f31168b;

    /* renamed from: c */
    private static char[] f31169c;

    /* renamed from: d */
    private static final byte[] f31170d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        f31168b = cArr;
        HashMap hashMap = new HashMap();
        f31167a = hashMap;
        hashMap.put('A', 'v');
        f31167a.put('B', 'S');
        f31167a.put('C', 'o');
        f31167a.put('D', 'a');
        f31167a.put('E', 'j');
        f31167a.put('F', 'c');
        f31167a.put('G', '7');
        f31167a.put('H', 'd');
        f31167a.put('I', 'R');
        f31167a.put('J', 'z');
        f31167a.put('K', 'p');
        f31167a.put('L', 'W');
        f31167a.put('M', 'i');
        f31167a.put('N', 'f');
        f31167a.put('O', 'G');
        f31167a.put('P', 'y');
        f31167a.put('Q', 'N');
        f31167a.put('R', 'x');
        f31167a.put('S', 'Z');
        f31167a.put('T', 'n');
        f31167a.put('U', 'V');
        f31167a.put('V', '5');
        f31167a.put('W', 'k');
        f31167a.put('X', '+');
        f31167a.put('Y', 'D');
        f31167a.put('Z', 'H');
        f31167a.put('a', 'L');
        f31167a.put('b', 'Y');
        f31167a.put('c', 'h');
        f31167a.put('d', 'J');
        f31167a.put('e', '4');
        f31167a.put('f', '6');
        f31167a.put('g', 'l');
        f31167a.put('h', 't');
        f31167a.put('i', '0');
        f31167a.put('j', 'U');
        f31167a.put('k', '3');
        f31167a.put('l', 'Q');
        f31167a.put('m', 'r');
        f31167a.put('n', 'g');
        f31167a.put('o', 'E');
        f31167a.put('p', 'u');
        f31167a.put('q', 'q');
        f31167a.put('r', '8');
        f31167a.put('s', 's');
        f31167a.put('t', 'w');
        f31167a.put('u', '/');
        f31167a.put('v', 'X');
        f31167a.put('w', 'M');
        f31167a.put('x', 'e');
        f31167a.put('y', 'B');
        f31167a.put('z', 'A');
        f31167a.put('0', 'T');
        f31167a.put('1', '2');
        f31167a.put('2', 'F');
        f31167a.put('3', 'b');
        f31167a.put('4', '9');
        f31167a.put('5', 'P');
        f31167a.put('6', '1');
        f31167a.put('7', 'O');
        f31167a.put('8', 'I');
        f31167a.put('9', 'K');
        f31167a.put('+', 'm');
        f31167a.put('/', 'C');
        f31169c = new char[cArr.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            char[] cArr2 = f31168b;
            if (i2 >= cArr2.length) {
                break;
            }
            f31169c[i2] = f31167a.get(Character.valueOf(cArr2[i2])).charValue();
            i2++;
        }
        f31170d = new byte[128];
        int i3 = 0;
        while (true) {
            byte[] bArr = f31170d;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = C14354n.f41155b;
            i3++;
        }
        while (true) {
            char[] cArr3 = f31169c;
            if (i >= cArr3.length) {
                return;
            }
            f31170d[cArr3[i]] = (byte) i;
            i++;
        }
    }

    /* renamed from: a */
    private static int m21730a(char[] cArr, byte[] bArr, int i) {
        try {
            char c = cArr[3] == '=' ? (char) 2 : (char) 3;
            if (cArr[2] == '=') {
                c = 1;
            }
            byte[] bArr2 = f31170d;
            byte b = bArr2[cArr[0]];
            byte b2 = bArr2[cArr[1]];
            byte b3 = bArr2[cArr[2]];
            byte b4 = bArr2[cArr[3]];
            if (c == 1) {
                bArr[i] = (byte) (((b << 2) & 252) | (3 & (b2 >> 4)));
                return 1;
            } else if (c == 2) {
                bArr[i] = (byte) ((3 & (b2 >> 4)) | ((b << 2) & 252));
                bArr[i + 1] = (byte) (((b2 << 4) & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) | ((b3 >> 2) & 15));
                return 2;
            } else if (c == 3) {
                int i2 = i + 1;
                bArr[i] = (byte) (((b << 2) & 252) | ((b2 >> 4) & 3));
                bArr[i2] = (byte) (((b2 << 4) & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) | ((b3 >> 2) & 15));
                bArr[i2 + 1] = (byte) ((b4 & Utf8.REPLACEMENT_BYTE) | ((b3 << 6) & Opcodes.CHECKCAST));
                return 3;
            } else {
                throw new RuntimeException("Internal Error");
            }
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: b */
    public static String m21729b(String str) {
        byte[] bytes = str.getBytes();
        return m21731a(bytes, 0, bytes.length);
    }

    /* renamed from: c */
    private static byte[] m21728c(String str) {
        int i;
        try {
            int length = str.length();
            char[] cArr = new char[length < 259 ? length : 259];
            int i2 = ((length >> 2) * 3) + 3;
            byte[] bArr = new byte[i2];
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < length) {
                int i6 = i3 + 256;
                if (i6 <= length) {
                    str.getChars(i3, i6, cArr, i5);
                    i = i5 + 256;
                } else {
                    str.getChars(i3, length, cArr, i5);
                    i = (length - i3) + i5;
                }
                int i7 = i5;
                while (i5 < i) {
                    char c = cArr[i5];
                    if (c != '=') {
                        byte[] bArr2 = f31170d;
                        if (c < bArr2.length) {
                            if (bArr2[c] == Byte.MAX_VALUE) {
                            }
                        }
                        i5++;
                    }
                    int i8 = i7 + 1;
                    cArr[i7] = c;
                    if (i8 == 4) {
                        i4 += m21730a(cArr, bArr, i4);
                        i7 = 0;
                    } else {
                        i7 = i8;
                    }
                    i5++;
                }
                i3 = i6;
                i5 = i7;
            }
            if (i4 == i2) {
                return bArr;
            }
            byte[] bArr3 = new byte[i4];
            System.arraycopy(bArr, 0, bArr3, 0, i4);
            return bArr3;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m21732a(String str) {
        byte[] m21728c = m21728c(str);
        if (m21728c == null || m21728c.length <= 0) {
            return null;
        }
        return new String(m21728c);
    }

    /* renamed from: a */
    private static String m21731a(byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return "";
        }
        try {
            char[] cArr = new char[((i2 / 3) << 2) + 4];
            int i3 = 0;
            while (i2 >= 3) {
                int i4 = ((bArr[i] & UByte.f41242c) << 16) + ((bArr[i + 1] & UByte.f41242c) << 8) + (bArr[i + 2] & UByte.f41242c);
                int i5 = i3 + 1;
                char[] cArr2 = f31169c;
                cArr[i3] = cArr2[i4 >> 18];
                int i6 = i5 + 1;
                cArr[i5] = cArr2[(i4 >> 12) & 63];
                int i7 = i6 + 1;
                cArr[i6] = cArr2[(i4 >> 6) & 63];
                i3 = i7 + 1;
                cArr[i7] = cArr2[i4 & 63];
                i += 3;
                i2 -= 3;
            }
            if (i2 == 1) {
                int i8 = bArr[i] & UByte.f41242c;
                int i9 = i3 + 1;
                char[] cArr3 = f31169c;
                cArr[i3] = cArr3[i8 >> 2];
                int i10 = i9 + 1;
                cArr[i9] = cArr3[(i8 << 4) & 63];
                int i11 = i10 + 1;
                cArr[i10] = '=';
                i3 = i11 + 1;
                cArr[i11] = '=';
            } else if (i2 == 2) {
                int i12 = ((bArr[i] & UByte.f41242c) << 8) + (bArr[i + 1] & UByte.f41242c);
                int i13 = i3 + 1;
                char[] cArr4 = f31169c;
                cArr[i3] = cArr4[i12 >> 10];
                int i14 = i13 + 1;
                cArr[i13] = cArr4[(i12 >> 4) & 63];
                int i15 = i14 + 1;
                cArr[i14] = cArr4[(i12 << 2) & 63];
                i3 = i15 + 1;
                cArr[i15] = '=';
            }
            return new String(cArr, 0, i3);
        } catch (Exception unused) {
            return null;
        }
    }
}
