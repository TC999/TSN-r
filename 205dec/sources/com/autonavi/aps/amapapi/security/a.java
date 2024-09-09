package com.autonavi.aps.amapapi.security;

import com.amap.api.col.p0003l.m4;
import com.amap.api.col.p0003l.q4;
import com.amap.api.col.p0003l.s9;
import com.autonavi.aps.amapapi.utils.b;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Encrypt.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f11889a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f11890b = {61, 61, 81, 65, 65, 69, 119, 65, 67, 48, 74, 80, 115, 116, 54, 75, 104, 76, 122, 97, 88, 99, 53, 71, 49, 122, 68, 70, 79, 104, 113, 113, 65, 97, 76, 54, 65, 66, 87, 53, 103, 85, 84, 113, 71, 68, 69, 76, 80, 82, 106, 51, 66, 75, 75, 69, 98, 55, 84, 108, 115, 122, 51, 106, 76, 55, 88, 122, 70, 121, 73, 75, 52, 50, 43, 101, 70, 121, 56, 105, 115, 105, 89, 120, 117, 112, 53, 48, 76, 81, 70, 86, 108, 110, 73, 65, 66, 74, 65, 83, 119, 65, 119, 83, 68, 65, 81, 66, 66, 69, 81, 65, 78, 99, 118, 104, 73, 90, 111, 75, 74, 89, 81, 68, 119, 119, 70, 77};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f11891c;

    /* renamed from: d  reason: collision with root package name */
    private static final IvParameterSpec f11892d;

    static {
        byte[] bArr = {0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1};
        f11891c = bArr;
        f11892d = new IvParameterSpec(bArr);
    }

    public static byte[] a(byte[] bArr) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(s9.a(new StringBuilder(new String(f11890b)).reverse().toString().getBytes())));
        Cipher cipher = Cipher.getInstance(q4.u("WUlNBL0VDQi9PQUVQV0lUSFNIQS0xQU5ETUdGMVBBRERJTkc"));
        cipher.init(1, generatePublic);
        return cipher.doFinal(bArr);
    }

    public static byte[] b(byte[] bArr, String str) {
        try {
            SecretKeySpec b4 = b(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(a());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, b4, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            b.a(th, "Encrypt", "aesDecrypt");
            return null;
        }
    }

    private static String c(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length * 2);
        for (int i4 = 0; i4 < length; i4++) {
            char[] cArr = f11889a;
            sb.append(cArr[(bArr[i4] >> 4) & 15]);
            sb.append(cArr[bArr[i4] & 15]);
        }
        return sb.toString();
    }

    private static SecretKeySpec b(String str) {
        byte[] bArr;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append("0");
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes("UTF-8");
        } catch (Throwable th) {
            b.a(th, "Encrypt", "createKey");
            bArr = null;
        }
        return new SecretKeySpec(bArr, "AES");
    }

    public static byte[] a(byte[] bArr, String str) {
        try {
            SecretKeySpec b4 = b(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(a());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, b4, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            b.a(th, "Encrypt", "aesEncrypt");
            return null;
        }
    }

    public static String a(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    String a4 = a("SHA1", str);
                    return a("MD5", a4 + str);
                }
            } catch (Throwable th) {
                b.a(th, "Encrypt", "generatorKey");
            }
        }
        return null;
    }

    public static byte[] b(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[bArr.length - 16];
            System.arraycopy(bArr, 0, bArr2, 0, 16);
            System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(q4.v()));
            return cipher.doFinal(bArr3);
        } catch (Throwable th) {
            b.a(th, "Encrypt", "decryptRsponse length = ".concat(String.valueOf(bArr != null ? bArr.length : 0)));
            return null;
        }
    }

    public static String a(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            return c(m4.c(str2.getBytes("UTF-8"), str));
        } catch (Throwable th) {
            b.a(th, "Encrypt", "encode");
            return null;
        }
    }

    private static byte[] a() {
        return q4.v();
    }
}
