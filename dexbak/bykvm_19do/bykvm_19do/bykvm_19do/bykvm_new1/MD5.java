package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.m */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class MD5 {

    /* renamed from: a */
    private static final MessageDigest f668a = m59173a();

    /* renamed from: b */
    public static final Charset f669b = Charset.forName("UTF-8");

    /* renamed from: c */
    private static final char[] f670c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private MD5() {
    }

    /* renamed from: a */
    private static MessageDigest m59173a() {
        try {
            return MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m59172a(String str) {
        byte[] digest;
        MessageDigest messageDigest = f668a;
        if (str == null) {
            return "";
        }
        byte[] bytes = str.getBytes(f669b);
        synchronized (MD5.class) {
            digest = messageDigest.digest(bytes);
        }
        return m59171a(digest);
    }

    /* renamed from: a */
    public static String m59171a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f670c;
            cArr[i] = cArr2[(b & 240) >> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }
}
