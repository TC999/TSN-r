package com.bytedance.msdk.f;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class n {

    /* renamed from: w  reason: collision with root package name */
    private static final MessageDigest f28347w = c();

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f28346c = Charset.forName("UTF-8");
    private static final char[] xv = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private n() {
    }

    private static MessageDigest c() {
        try {
            return MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String c(String str) {
        byte[] digest;
        MessageDigest messageDigest = f28347w;
        if (str == null) {
            return "";
        }
        byte[] bytes = str.getBytes(f28346c);
        synchronized (n.class) {
            digest = messageDigest.digest(bytes);
        }
        return c(digest);
    }

    public static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i4 = 0;
        for (byte b4 : bArr) {
            int i5 = i4 + 1;
            char[] cArr2 = xv;
            cArr[i4] = cArr2[(b4 & 240) >> 4];
            i4 = i5 + 1;
            cArr[i5] = cArr2[b4 & 15];
        }
        return new String(cArr);
    }
}
