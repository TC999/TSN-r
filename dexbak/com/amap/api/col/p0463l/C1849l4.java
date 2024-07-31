package com.amap.api.col.p0463l;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5.java */
/* renamed from: com.amap.api.col.3l.l4 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class C1849l4 {
    /* renamed from: a */
    public static String m54586a(String str) {
        FileInputStream fileInputStream;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                byte[] bArr = new byte[2048];
                MessageDigest messageDigest = MessageDigest.getInstance(C1925p4.m54183u("ETUQ1"));
                fileInputStream = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            BasicLogHandler.m54177e(th, "MD5", "gfm");
                            return null;
                        } finally {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e) {
                                    BasicLogHandler.m54177e(e, "MD5", "gfm");
                                }
                            }
                        }
                    }
                }
                String m54210A = C1925p4.m54210A(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    BasicLogHandler.m54177e(e2, "MD5", "gfm");
                }
                return m54210A;
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    /* renamed from: b */
    public static String m54585b(byte[] bArr) {
        return C1925p4.m54210A(m54584c(bArr, C1925p4.m54183u("ETUQ1")));
    }

    /* renamed from: c */
    public static byte[] m54584c(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "MD5", "gmb");
            return null;
        }
    }

    /* renamed from: d */
    public static String m54583d(String str) {
        if (str == null) {
            return null;
        }
        return C1925p4.m54210A(m54581f(str));
    }

    /* renamed from: e */
    public static String m54582e(String str) {
        return C1925p4.m54207D(m54580g(str));
    }

    /* renamed from: f */
    private static byte[] m54581f(String str) {
        try {
            return m54579h(str);
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "MD5", "gmb");
            return new byte[0];
        }
    }

    /* renamed from: g */
    private static byte[] m54580g(String str) {
        try {
            return m54579h(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    /* renamed from: h */
    private static byte[] m54579h(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(C1925p4.m54183u("ETUQ1"));
        messageDigest.update(C1925p4.m54189o(str));
        return messageDigest.digest();
    }
}
