package com.amap.api.col.p0463l;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* renamed from: com.amap.api.col.3l.m5 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class SecurityUtil {

    /* renamed from: a */
    private static byte[] f4679a;

    /* renamed from: b */
    private static String[] f4680b = {"kp6SsA", "cHE4dQ", "JKekrA", "XBxOHQ", "CSnpKw", "VwcThw", "wkp6Sg", "1cHE4Q"};

    /* renamed from: c */
    private static int[] f4681c;

    /* renamed from: a */
    private static int m54527a(int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 >> 1) | Integer.MIN_VALUE;
        }
        return (i << i2) | ((i & i3) >>> (32 - i2));
    }

    /* renamed from: b */
    public static String m54526b() {
        SecureRandom secureRandom = new SecureRandom();
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(C1925p4.m54183u("EQUVT"));
            keyGenerator.init(128, secureRandom);
            return Base64Util.m54756a(keyGenerator.generateKey().getEncoded());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: c */
    private static String m54525c(int i) {
        char[] cArr = new char[4];
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = (4 - i2) - 1;
            cArr[i3] = (char) ((i >>> (i2 * 8)) & 255);
            char c = cArr[i3];
            String str = " ";
            for (int i4 = 0; i4 < 32; i4++) {
                str = str + (((Integer.MIN_VALUE >>> i4) & c) >>> (31 - i4));
            }
        }
        return new String(cArr);
    }

    /* renamed from: d */
    public static String m54524d(String str) {
        return C1849l4.m54583d(str);
    }

    /* renamed from: e */
    private static String m54523e(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        if (iArr != null) {
            for (int i = 0; i < iArr.length; i++) {
                sb.append(m54525c(m54527a(m54521g(iArr[i]), i)));
            }
        }
        return sb.toString();
    }

    /* renamed from: f */
    private static byte[] m54522f(byte[] bArr) {
        try {
            if (f4679a == null) {
                f4679a = C1925p4.m54183u("YAAAAAAAAAAAAAAAAAAAAAA").getBytes();
            }
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f4679a);
            SecretKeySpec secretKeySpec = new SecretKeySpec(m54523e(m54519i()).getBytes("UTF-8"), C1925p4.m54183u("EQUVT"));
            Cipher cipher = Cipher.getInstance(C1925p4.m54183u("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: g */
    private static int m54521g(int i) {
        int i2 = 1;
        for (int i3 = 0; i3 < 15; i3++) {
            i2 = (i2 << 2) | 1;
        }
        return ((i & i2) << 1) | (((i2 << 1) & i) >>> 1);
    }

    /* renamed from: h */
    public static String m54520h(String str) {
        try {
            return Base64Util.m54756a(m54522f(str.getBytes("UTF-8")));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: i */
    private static int[] m54519i() {
        int[] iArr = f4681c;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[8];
        int i = 0;
        while (true) {
            String[] strArr = f4680b;
            if (i >= strArr.length) {
                return iArr2;
            }
            byte[] m54718g = Encrypt.m54718g(strArr[i]);
            iArr2[i] = ((m54718g[0] & UByte.f41242c) << 24) | (m54718g[3] & UByte.f41242c) | ((m54718g[2] & UByte.f41242c) << 8) | ((m54718g[1] & UByte.f41242c) << 16);
            i++;
        }
    }
}
