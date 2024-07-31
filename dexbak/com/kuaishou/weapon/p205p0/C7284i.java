package com.kuaishou.weapon.p205p0;

import kotlin.UByte;

/* renamed from: com.kuaishou.weapon.p0.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7284i {
    /* renamed from: a */
    public static byte[] m33862a(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return m33857c(bArr, str);
    }

    /* renamed from: b */
    public static byte[] m33859b(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return m33857c(bArr, str);
    }

    /* renamed from: c */
    private static byte[] m33858c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        byte[] bytes = str.getBytes();
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = m33866a(bytes[i2], bytes[i2 + 1]);
        }
        return bArr;
    }

    /* renamed from: a */
    public static String m33864a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return new String(m33857c(m33858c(str), str2));
    }

    /* renamed from: b */
    private static byte[] m33860b(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return m33857c(str.getBytes(), str2);
    }

    /* renamed from: a */
    private static String m33863a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b : bArr) {
            stringBuffer.append((char) b);
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private static String m33861b(String str) {
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            String hexString = Integer.toHexString(str.charAt(i) & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            str2 = str2 + hexString;
        }
        return str2;
    }

    /* renamed from: c */
    private static byte[] m33857c(byte[] bArr, String str) {
        byte[] m33865a = m33865a(str);
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = ((m33865a[i] & UByte.f41242c) + i2) & 255;
            byte b = m33865a[i];
            m33865a[i] = m33865a[i2];
            m33865a[i2] = b;
            bArr2[i3] = (byte) (m33865a[((m33865a[i] & UByte.f41242c) + (m33865a[i2] & UByte.f41242c)) & 255] ^ bArr[i3]);
        }
        return bArr2;
    }

    /* renamed from: a */
    private static byte[] m33865a(String str) {
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr[i] = (byte) i;
        }
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            i3 = ((bytes[i2] & UByte.f41242c) + (bArr[i4] & UByte.f41242c) + i3) & 255;
            byte b = bArr[i4];
            bArr[i4] = bArr[i3];
            bArr[i3] = b;
            i2 = (i2 + 1) % bytes.length;
        }
        return bArr;
    }

    /* renamed from: a */
    private static byte m33866a(byte b, byte b2) {
        return (byte) (((char) (((char) Byte.decode("0x" + new String(new byte[]{b})).byteValue()) << 4)) ^ ((char) Byte.decode("0x" + new String(new byte[]{b2})).byteValue()));
    }
}
