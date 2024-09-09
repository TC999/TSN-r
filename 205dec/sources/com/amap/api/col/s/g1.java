package com.amap.api.col.s;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MD5.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g1 {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return j1.A(e(str));
    }

    public static String b(byte[] bArr) {
        return j1.A(c(bArr, j1.t("ETUQ1")));
    }

    private static byte[] c(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable th) {
            d2.e(th, "MD5", "gmb");
            return null;
        }
    }

    public static String d(String str) {
        return j1.B(f(str));
    }

    private static byte[] e(String str) {
        try {
            return g(str);
        } catch (Throwable th) {
            d2.e(th, "MD5", "gmb");
            return new byte[0];
        }
    }

    private static byte[] f(String str) {
        try {
            return g(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] g(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(j1.t("ETUQ1"));
        messageDigest.update(j1.o(str));
        return messageDigest.digest();
    }
}
