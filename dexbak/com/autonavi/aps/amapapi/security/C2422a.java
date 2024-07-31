package com.autonavi.aps.amapapi.security;

import com.amap.api.col.p0463l.C1849l4;
import com.amap.api.col.p0463l.C1925p4;
import com.amap.api.col.p0463l.C1932r9;
import com.autonavi.aps.amapapi.utils.C2428b;
import io.netty.handler.codec.http.HttpConstants;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Encrypt.java */
/* renamed from: com.autonavi.aps.amapapi.security.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2422a {

    /* renamed from: a */
    private static final char[] f8217a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    private static final byte[] f8218b = {HttpConstants.EQUALS, HttpConstants.EQUALS, 81, 65, 65, 69, 119, 65, 67, 48, 74, 80, 115, 116, 54, 75, 104, 76, 122, 97, 88, 99, 53, 71, 49, 122, 68, 70, 79, 104, 113, 113, 65, 97, 76, 54, 65, 66, 87, 53, 103, 85, 84, 113, 71, 68, 69, 76, 80, 82, 106, 51, 66, 75, 75, 69, 98, 55, 84, 108, 115, 122, 51, 106, 76, 55, 88, 122, 70, 121, 73, 75, 52, 50, 43, 101, 70, 121, 56, 105, 115, 105, 89, 120, 117, 112, 53, 48, 76, 81, 70, 86, 108, 110, 73, 65, 66, 74, 65, 83, 119, 65, 119, 83, 68, 65, 81, 66, 66, 69, 81, 65, 78, 99, 118, 104, 73, 90, 111, 75, 74, 89, 81, 68, 119, 119, 70, 77};

    /* renamed from: c */
    private static final byte[] f8219c;

    /* renamed from: d */
    private static final IvParameterSpec f8220d;

    static {
        byte[] bArr = {0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1};
        f8219c = bArr;
        f8220d = new IvParameterSpec(bArr);
    }

    /* renamed from: a */
    public static byte[] m51454a(byte[] bArr) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(C1932r9.m54021a(new StringBuilder(new String(f8218b)).reverse().toString().getBytes())));
        Cipher cipher = Cipher.getInstance(C1925p4.m54183u("WUlNBL0VDQi9PQUVQV0lUSFNIQS0xQU5ETUdGMVBBRERJTkc"));
        cipher.init(1, generatePublic);
        return cipher.doFinal(bArr);
    }

    /* renamed from: b */
    public static byte[] m51450b(byte[] bArr, String str) {
        try {
            SecretKeySpec m51452b = m51452b(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(m51457a());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, m51452b, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            C2428b.m51299a(th, "Encrypt", "aesDecrypt");
            return null;
        }
    }

    /* renamed from: c */
    private static String m51449c(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            char[] cArr = f8217a;
            sb.append(cArr[(bArr[i] >> 4) & 15]);
            sb.append(cArr[bArr[i] & 15]);
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static SecretKeySpec m51452b(String str) {
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
            C2428b.m51299a(th, "Encrypt", "createKey");
            bArr = null;
        }
        return new SecretKeySpec(bArr, "AES");
    }

    /* renamed from: a */
    public static byte[] m51453a(byte[] bArr, String str) {
        try {
            SecretKeySpec m51452b = m51452b(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(m51457a());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, m51452b, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            C2428b.m51299a(th, "Encrypt", "aesEncrypt");
            return null;
        }
    }

    /* renamed from: a */
    public static String m51456a(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    String m51455a = m51455a("SHA1", str);
                    return m51455a("MD5", m51455a + str);
                }
            } catch (Throwable th) {
                C2428b.m51299a(th, "Encrypt", "generatorKey");
            }
        }
        return null;
    }

    /* renamed from: b */
    public static byte[] m51451b(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[bArr.length - 16];
            System.arraycopy(bArr, 0, bArr2, 0, 16);
            System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(C1925p4.m54182v()));
            return cipher.doFinal(bArr3);
        } catch (Throwable th) {
            C2428b.m51299a(th, "Encrypt", "decryptRsponse length = ".concat(String.valueOf(bArr != null ? bArr.length : 0)));
            return null;
        }
    }

    /* renamed from: a */
    public static String m51455a(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            return m51449c(C1849l4.m54584c(str2.getBytes("UTF-8"), str));
        } catch (Throwable th) {
            C2428b.m51299a(th, "Encrypt", "encode");
            return null;
        }
    }

    /* renamed from: a */
    private static byte[] m51457a() {
        return C1925p4.m54182v();
    }
}
