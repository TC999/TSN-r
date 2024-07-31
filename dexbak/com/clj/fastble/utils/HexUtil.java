package com.clj.fastble.utils;

import kotlin.UByte;

/* renamed from: com.clj.fastble.utils.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class HexUtil {

    /* renamed from: a */
    private static final char[] f23053a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    private static final char[] f23054b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static byte m35956a(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /* renamed from: b */
    public static byte[] m35955b(char[] cArr) {
        int length = cArr.length;
        if ((length & 1) == 0) {
            byte[] bArr = new byte[length >> 1];
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i + 1;
                i = i3 + 1;
                bArr[i2] = (byte) (((m35944m(cArr[i], i) << 4) | m35944m(cArr[i3], i3)) & 255);
                i2++;
            }
            return bArr;
        }
        throw new RuntimeException("Odd number of characters.");
    }

    /* renamed from: c */
    public static char[] m35954c(byte[] bArr) {
        return m35953d(bArr, true);
    }

    /* renamed from: d */
    public static char[] m35953d(byte[] bArr, boolean z) {
        return m35952e(bArr, z ? f23053a : f23054b);
    }

    /* renamed from: e */
    protected static char[] m35952e(byte[] bArr, char[] cArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return cArr2;
    }

    /* renamed from: f */
    public static String m35951f(byte[] bArr) {
        return m35950g(bArr, true);
    }

    /* renamed from: g */
    public static String m35950g(byte[] bArr, boolean z) {
        return m35949h(bArr, z ? f23053a : f23054b);
    }

    /* renamed from: h */
    protected static String m35949h(byte[] bArr, char[] cArr) {
        return new String(m35952e(bArr, cArr));
    }

    /* renamed from: i */
    public static String m35948i(byte[] bArr, int i) {
        return m35947j(new byte[]{bArr[i]});
    }

    /* renamed from: j */
    public static String m35947j(byte[] bArr) {
        return m35946k(bArr, false);
    }

    /* renamed from: k */
    public static String m35946k(byte[] bArr, boolean z) {
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UByte.f41242c);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            sb.append(hexString);
            if (z) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    /* renamed from: l */
    public static byte[] m35945l(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.trim().toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (m35956a(charArray[i2 + 1]) | (m35956a(charArray[i2]) << 4));
        }
        return bArr;
    }

    /* renamed from: m */
    protected static int m35944m(char c, int i) {
        int digit = Character.digit(c, 16);
        if (digit != -1) {
            return digit;
        }
        throw new RuntimeException("Illegal hexadecimal character " + c + " at index " + i);
    }
}
