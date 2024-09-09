package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static final MessageDigest f661a = a();

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f662b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f663c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private m() {
    }

    private static MessageDigest a() {
        try {
            return MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String a(String str) {
        byte[] digest;
        MessageDigest messageDigest = f661a;
        if (str == null) {
            return "";
        }
        byte[] bytes = str.getBytes(f662b);
        synchronized (m.class) {
            digest = messageDigest.digest(bytes);
        }
        return a(digest);
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i4 = 0;
        for (byte b4 : bArr) {
            int i5 = i4 + 1;
            char[] cArr2 = f663c;
            cArr[i4] = cArr2[(b4 & 240) >> 4];
            i4 = i5 + 1;
            cArr[i5] = cArr2[b4 & 15];
        }
        return new String(cArr);
    }
}
