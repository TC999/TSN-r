package com.amap.api.col.p0003l;

import android.text.TextUtils;
import com.amap.api.col.p0003l.ft;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MD5.java */
/* renamed from: com.amap.api.col.3l.m4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class m4 {

    /* compiled from: PrivacyError.java */
    /* renamed from: com.amap.api.col.3l.m4$a */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8336a;

        static {
            int[] iArr = new int[ft.c.values().length];
            f8336a = iArr;
            try {
                iArr[ft.c.ShowUnknowCode.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8336a[ft.c.ShowNoShowCode.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8336a[ft.c.InfoUnknowCode.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8336a[ft.c.InfoNotContainCode.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8336a[ft.c.AgreeUnknowCode.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8336a[ft.c.AgreeNotAgreeCode.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8336a[ft.c.InvaildUserKeyCode.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8336a[ft.c.IllegalArgument.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8336a[ft.c.SuccessCode.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static String a(String str) {
        FileInputStream fileInputStream;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                byte[] bArr = new byte[2048];
                MessageDigest messageDigest = MessageDigest.getInstance(q4.u("ETUQ1"));
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
                            q5.e(th, "MD5", "gfm");
                            return null;
                        } finally {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e4) {
                                    q5.e(e4, "MD5", "gfm");
                                }
                            }
                        }
                    }
                }
                String A = q4.A(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    q5.e(e5, "MD5", "gfm");
                }
                return A;
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static String b(byte[] bArr) {
        return q4.A(c(bArr, q4.u("ETUQ1")));
    }

    public static byte[] c(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable th) {
            q5.e(th, "MD5", "gmb");
            return null;
        }
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        return q4.A(f(str));
    }

    public static String e(String str) {
        return q4.D(g(str));
    }

    private static byte[] f(String str) {
        try {
            return h(str);
        } catch (Throwable th) {
            q5.e(th, "MD5", "gmb");
            return new byte[0];
        }
    }

    private static byte[] g(String str) {
        try {
            return h(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] h(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(q4.u("ETUQ1"));
        messageDigest.update(q4.o(str));
        return messageDigest.digest();
    }
}
