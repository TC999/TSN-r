package com.amap.api.col.p047s;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5.java */
/* renamed from: com.amap.api.col.s.g1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2059g1 {
    /* renamed from: a */
    public static String m52992a(String str) {
        if (str == null) {
            return null;
        }
        return C2079j1.m52881A(m52988e(str));
    }

    /* renamed from: b */
    public static String m52991b(byte[] bArr) {
        return C2079j1.m52881A(m52990c(bArr, C2079j1.m52857t("ETUQ1")));
    }

    /* renamed from: c */
    private static byte[] m52990c(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable th) {
            C2041d2.m53085e(th, "MD5", "gmb");
            return null;
        }
    }

    /* renamed from: d */
    public static String m52989d(String str) {
        return C2079j1.m52880B(m52987f(str));
    }

    /* renamed from: e */
    private static byte[] m52988e(String str) {
        try {
            return m52986g(str);
        } catch (Throwable th) {
            C2041d2.m53085e(th, "MD5", "gmb");
            return new byte[0];
        }
    }

    /* renamed from: f */
    private static byte[] m52987f(String str) {
        try {
            return m52986g(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    /* renamed from: g */
    private static byte[] m52986g(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(C2079j1.m52857t("ETUQ1"));
        messageDigest.update(C2079j1.m52862o(str));
        return messageDigest.digest();
    }
}
