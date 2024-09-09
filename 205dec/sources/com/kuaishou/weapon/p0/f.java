package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f38338a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r3 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(byte r3) {
        /*
            if (r3 >= 0) goto L4
            int r3 = r3 + 256
        L4:
            int r0 = r3 / 16
            int r3 = r3 % 16
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String[] r2 = com.kuaishou.weapon.p0.f.f38338a
            r0 = r2[r0]
            r1.append(r0)
            r3 = r2[r3]
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.f.a(byte):java.lang.String");
    }

    public static String b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length > 0) {
                try {
                } catch (Throwable unused) {
                    return null;
                }
            }
            return a(MessageDigest.getInstance("MD5").digest(bArr));
        }
        return null;
    }

    public static String c(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i4 = 0; i4 < bArr.length; i4++) {
            byte b4 = bArr[i4];
            int i5 = i4 * 2;
            cArr2[i5] = cArr[(b4 >>> 4) & 15];
            cArr2[i5 + 1] = cArr[b4 & 15];
        }
        return new String(cArr2);
    }

    public static byte[] d(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length > 0) {
                try {
                } catch (Throwable unused) {
                    return null;
                }
            }
            return MessageDigest.getInstance("MD5").digest(bArr);
        }
        return null;
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b4 : bArr) {
            stringBuffer.append(a(b4));
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        String str2;
        String str3 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str2 = new String(str);
        } catch (Throwable unused) {
        }
        try {
            return a(MessageDigest.getInstance("MD5").digest(str2.getBytes()));
        } catch (Throwable unused2) {
            str3 = str2;
            return str3;
        }
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.exists()) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    String c4 = c(messageDigest.digest());
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                    return c4;
                } catch (Throwable unused2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return null;
                }
            } catch (Throwable unused4) {
                fileInputStream = null;
            }
        }
        return null;
    }
}
