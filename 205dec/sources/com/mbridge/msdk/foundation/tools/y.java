package com.mbridge.msdk.foundation.tools;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SameMVEncoder.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class y {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Character, Character> f39940a;

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f39941b;

    /* renamed from: c  reason: collision with root package name */
    private static char[] f39942c;

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f39943d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        f39941b = cArr;
        HashMap hashMap = new HashMap();
        f39940a = hashMap;
        hashMap.put('A', 'v');
        f39940a.put('B', 'S');
        f39940a.put('C', 'o');
        f39940a.put('D', 'a');
        f39940a.put('E', 'j');
        f39940a.put('F', 'c');
        f39940a.put('G', '7');
        f39940a.put('H', 'd');
        f39940a.put('I', 'R');
        f39940a.put('J', 'z');
        f39940a.put('K', 'p');
        f39940a.put('L', 'W');
        f39940a.put('M', 'i');
        f39940a.put('N', 'f');
        f39940a.put('O', 'G');
        f39940a.put('P', 'y');
        f39940a.put('Q', 'N');
        f39940a.put('R', 'x');
        f39940a.put('S', 'Z');
        f39940a.put('T', 'n');
        f39940a.put('U', 'V');
        f39940a.put('V', '5');
        f39940a.put('W', 'k');
        f39940a.put('X', '+');
        f39940a.put('Y', 'D');
        f39940a.put('Z', 'H');
        f39940a.put('a', 'L');
        f39940a.put('b', 'Y');
        f39940a.put('c', 'h');
        f39940a.put('d', 'J');
        f39940a.put('e', '4');
        f39940a.put('f', '6');
        f39940a.put('g', 'l');
        f39940a.put('h', 't');
        f39940a.put('i', '0');
        f39940a.put('j', 'U');
        f39940a.put('k', '3');
        f39940a.put('l', 'Q');
        f39940a.put('m', 'r');
        f39940a.put('n', 'g');
        f39940a.put('o', 'E');
        f39940a.put('p', 'u');
        f39940a.put('q', 'q');
        f39940a.put('r', '8');
        f39940a.put('s', 's');
        f39940a.put('t', 'w');
        f39940a.put('u', '/');
        f39940a.put('v', 'X');
        f39940a.put('w', 'M');
        f39940a.put('x', 'e');
        f39940a.put('y', 'B');
        f39940a.put('z', 'A');
        f39940a.put('0', 'T');
        f39940a.put('1', '2');
        f39940a.put('2', 'F');
        f39940a.put('3', 'b');
        f39940a.put('4', '9');
        f39940a.put('5', 'P');
        f39940a.put('6', '1');
        f39940a.put('7', 'O');
        f39940a.put('8', 'I');
        f39940a.put('9', 'K');
        f39940a.put('+', 'm');
        f39940a.put('/', 'C');
        f39942c = new char[cArr.length];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            char[] cArr2 = f39941b;
            if (i5 >= cArr2.length) {
                break;
            }
            f39942c[i5] = f39940a.get(Character.valueOf(cArr2[i5])).charValue();
            i5++;
        }
        f39943d = new byte[128];
        int i6 = 0;
        while (true) {
            byte[] bArr = f39943d;
            if (i6 >= bArr.length) {
                break;
            }
            bArr[i6] = Byte.MAX_VALUE;
            i6++;
        }
        while (true) {
            char[] cArr3 = f39942c;
            if (i4 >= cArr3.length) {
                return;
            }
            f39943d[cArr3[i4]] = (byte) i4;
            i4++;
        }
    }

    private static int a(char[] cArr, byte[] bArr, int i4) {
        try {
            char c4 = cArr[3] == '=' ? (char) 2 : (char) 3;
            if (cArr[2] == '=') {
                c4 = 1;
            }
            byte[] bArr2 = f39943d;
            byte b4 = bArr2[cArr[0]];
            byte b5 = bArr2[cArr[1]];
            byte b6 = bArr2[cArr[2]];
            byte b7 = bArr2[cArr[3]];
            if (c4 == 1) {
                bArr[i4] = (byte) (((b4 << 2) & MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF) | (3 & (b5 >> 4)));
                return 1;
            } else if (c4 == 2) {
                bArr[i4] = (byte) ((3 & (b5 >> 4)) | ((b4 << 2) & MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF));
                bArr[i4 + 1] = (byte) (((b5 << 4) & 240) | ((b6 >> 2) & 15));
                return 2;
            } else if (c4 == 3) {
                int i5 = i4 + 1;
                bArr[i4] = (byte) (((b4 << 2) & MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF) | ((b5 >> 4) & 3));
                bArr[i5] = (byte) (((b5 << 4) & 240) | ((b6 >> 2) & 15));
                bArr[i5 + 1] = (byte) ((b7 & 63) | ((b6 << 6) & 192));
                return 3;
            } else {
                throw new RuntimeException("Internal Error");
            }
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String b(String str) {
        byte[] bytes = str.getBytes();
        return a(bytes, 0, bytes.length);
    }

    private static byte[] c(String str) {
        int i4;
        try {
            int length = str.length();
            int i5 = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME;
            if (length < 259) {
                i5 = length;
            }
            char[] cArr = new char[i5];
            int i6 = ((length >> 2) * 3) + 3;
            byte[] bArr = new byte[i6];
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 < length) {
                int i10 = i7 + 256;
                if (i10 <= length) {
                    str.getChars(i7, i10, cArr, i9);
                    i4 = i9 + 256;
                } else {
                    str.getChars(i7, length, cArr, i9);
                    i4 = (length - i7) + i9;
                }
                int i11 = i9;
                while (i9 < i4) {
                    char c4 = cArr[i9];
                    if (c4 != '=') {
                        byte[] bArr2 = f39943d;
                        if (c4 < bArr2.length) {
                            if (bArr2[c4] == Byte.MAX_VALUE) {
                            }
                        }
                        i9++;
                    }
                    int i12 = i11 + 1;
                    cArr[i11] = c4;
                    if (i12 == 4) {
                        i8 += a(cArr, bArr, i8);
                        i11 = 0;
                    } else {
                        i11 = i12;
                    }
                    i9++;
                }
                i7 = i10;
                i9 = i11;
            }
            if (i8 == i6) {
                return bArr;
            }
            byte[] bArr3 = new byte[i8];
            System.arraycopy(bArr, 0, bArr3, 0, i8);
            return bArr3;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(String str) {
        byte[] c4 = c(str);
        if (c4 == null || c4.length <= 0) {
            return null;
        }
        return new String(c4);
    }

    private static String a(byte[] bArr, int i4, int i5) {
        if (i5 <= 0) {
            return "";
        }
        try {
            char[] cArr = new char[((i5 / 3) << 2) + 4];
            int i6 = 0;
            while (i5 >= 3) {
                int i7 = ((bArr[i4] & 255) << 16) + ((bArr[i4 + 1] & 255) << 8) + (bArr[i4 + 2] & 255);
                int i8 = i6 + 1;
                char[] cArr2 = f39942c;
                cArr[i6] = cArr2[i7 >> 18];
                int i9 = i8 + 1;
                cArr[i8] = cArr2[(i7 >> 12) & 63];
                int i10 = i9 + 1;
                cArr[i9] = cArr2[(i7 >> 6) & 63];
                i6 = i10 + 1;
                cArr[i10] = cArr2[i7 & 63];
                i4 += 3;
                i5 -= 3;
            }
            if (i5 == 1) {
                int i11 = bArr[i4] & 255;
                int i12 = i6 + 1;
                char[] cArr3 = f39942c;
                cArr[i6] = cArr3[i11 >> 2];
                int i13 = i12 + 1;
                cArr[i12] = cArr3[(i11 << 4) & 63];
                int i14 = i13 + 1;
                cArr[i13] = '=';
                i6 = i14 + 1;
                cArr[i14] = '=';
            } else if (i5 == 2) {
                int i15 = ((bArr[i4] & 255) << 8) + (bArr[i4 + 1] & 255);
                int i16 = i6 + 1;
                char[] cArr4 = f39942c;
                cArr[i6] = cArr4[i15 >> 10];
                int i17 = i16 + 1;
                cArr[i16] = cArr4[(i15 >> 4) & 63];
                int i18 = i17 + 1;
                cArr[i17] = cArr4[(i15 << 2) & 63];
                i6 = i18 + 1;
                cArr[i18] = '=';
            }
            return new String(cArr, 0, i6);
        } catch (Exception unused) {
            return null;
        }
    }
}
