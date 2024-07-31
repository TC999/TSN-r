package com.amap.api.col.p047s;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

/* compiled from: SecurityUtil.java */
/* renamed from: com.amap.api.col.s.a2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2018a2 {

    /* renamed from: a */
    private static byte[] f5876a;

    /* renamed from: b */
    private static String[] f5877b = {"kp6SsA", "cHE4dQ", "JKekrA", "XBxOHQ", "CSnpKw", "VwcThw", "wkp6Sg", "1cHE4Q"};

    /* renamed from: c */
    private static int[] f5878c;

    /* renamed from: a */
    private static int m53264a(int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 >> 1) | Integer.MIN_VALUE;
        }
        return (i << i2) | ((i & i3) >>> (32 - i2));
    }

    /* renamed from: b */
    public static String m53263b() {
        SecureRandom secureRandom = new SecureRandom();
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(C2079j1.m52857t("EQUVT"));
            keyGenerator.init(128, secureRandom);
            return C2187v1.m52395a(keyGenerator.generateKey().getEncoded());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: c */
    private static String m53262c(int i) {
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
    public static String m53261d(String str) {
        return C2059g1.m52992a(str);
    }

    /* renamed from: e */
    private static String m53260e(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        if (iArr != null) {
            for (int i = 0; i < iArr.length; i++) {
                sb.append(m53262c(m53264a(m53258g(iArr[i]), i)));
            }
        }
        return sb.toString();
    }

    /* renamed from: f */
    private static byte[] m53259f(byte[] bArr) {
        try {
            if (f5876a == null) {
                f5876a = C2079j1.m52857t("YAAAAAAAAAAAAAAAAAAAAAA").getBytes();
            }
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f5876a);
            SecretKeySpec secretKeySpec = new SecretKeySpec(m53260e(m53256i()).getBytes("UTF-8"), C2079j1.m52857t("EQUVT"));
            Cipher cipher = Cipher.getInstance(C2079j1.m52857t("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: g */
    private static int m53258g(int i) {
        int i2 = 1;
        for (int i3 = 0; i3 < 15; i3++) {
            i2 = (i2 << 2) | 1;
        }
        return ((i & i2) << 1) | (((i2 << 1) & i) >>> 1);
    }

    /* renamed from: h */
    public static String m53257h(String str) {
        try {
            return C2187v1.m52395a(m53259f(str.getBytes("UTF-8")));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: i */
    private static int[] m53256i() {
        int[] iArr = f5878c;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[8];
        int i = 0;
        while (true) {
            String[] strArr = f5877b;
            if (i >= strArr.length) {
                return iArr2;
            }
            byte[] m53090g = C2040d1.m53090g(strArr[i]);
            iArr2[i] = ((m53090g[0] & UByte.f41242c) << 24) | (m53090g[3] & UByte.f41242c) | ((m53090g[2] & UByte.f41242c) << 8) | ((m53090g[1] & UByte.f41242c) << 16);
            i++;
        }
    }
}
