package com.amap.api.col.s;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SecurityUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a2 {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f9626a;

    /* renamed from: b  reason: collision with root package name */
    private static String[] f9627b = {"kp6SsA", "cHE4dQ", "JKekrA", "XBxOHQ", "CSnpKw", "VwcThw", "wkp6Sg", "1cHE4Q"};

    /* renamed from: c  reason: collision with root package name */
    private static int[] f9628c;

    private static int a(int i4, int i5) {
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 = (i6 >> 1) | Integer.MIN_VALUE;
        }
        return (i4 << i5) | ((i4 & i6) >>> (32 - i5));
    }

    public static String b() {
        SecureRandom secureRandom = new SecureRandom();
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(j1.t("EQUVT"));
            keyGenerator.init(128, secureRandom);
            return v1.a(keyGenerator.generateKey().getEncoded());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String c(int i4) {
        char[] cArr = new char[4];
        for (int i5 = 0; i5 < 4; i5++) {
            int i6 = (4 - i5) - 1;
            cArr[i6] = (char) ((i4 >>> (i5 * 8)) & 255);
            char c4 = cArr[i6];
            String str = " ";
            for (int i7 = 0; i7 < 32; i7++) {
                str = str + (((Integer.MIN_VALUE >>> i7) & c4) >>> (31 - i7));
            }
        }
        return new String(cArr);
    }

    public static String d(String str) {
        return g1.a(str);
    }

    private static String e(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        if (iArr != null) {
            for (int i4 = 0; i4 < iArr.length; i4++) {
                sb.append(c(a(g(iArr[i4]), i4)));
            }
        }
        return sb.toString();
    }

    private static byte[] f(byte[] bArr) {
        try {
            if (f9626a == null) {
                f9626a = j1.t("YAAAAAAAAAAAAAAAAAAAAAA").getBytes();
            }
            IvParameterSpec ivParameterSpec = new IvParameterSpec(f9626a);
            SecretKeySpec secretKeySpec = new SecretKeySpec(e(i()).getBytes("UTF-8"), j1.t("EQUVT"));
            Cipher cipher = Cipher.getInstance(j1.t("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static int g(int i4) {
        int i5 = 1;
        for (int i6 = 0; i6 < 15; i6++) {
            i5 = (i5 << 2) | 1;
        }
        return ((i4 & i5) << 1) | (((i5 << 1) & i4) >>> 1);
    }

    public static String h(String str) {
        try {
            return v1.a(f(str.getBytes("UTF-8")));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static int[] i() {
        int[] iArr = f9628c;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[8];
        int i4 = 0;
        while (true) {
            String[] strArr = f9627b;
            if (i4 >= strArr.length) {
                return iArr2;
            }
            byte[] g4 = d1.g(strArr[i4]);
            iArr2[i4] = ((g4[0] & 255) << 24) | (g4[3] & 255) | ((g4[2] & 255) << 8) | ((g4[1] & 255) << 16);
            i4++;
        }
    }
}
