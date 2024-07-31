package com.kuaishou.weapon.p205p0;

import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* renamed from: com.kuaishou.weapon.p0.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7281f {

    /* renamed from: a */
    private static final String[] f24942a = {"0", "1", "2", "3", "4", "5", "6", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_SHARE_TYPE_MINI_PROGRAM, "a", "b", "c", "d", "e", "f"};

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r3 = r3;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m33899a(byte r3) {
        /*
            if (r3 >= 0) goto L4
            int r3 = r3 + 256
        L4:
            int r0 = r3 / 16
            int r3 = r3 % 16
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String[] r2 = com.kuaishou.weapon.p205p0.C7281f.f24942a
            r0 = r2[r0]
            r1.append(r0)
            r3 = r2[r3]
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p205p0.C7281f.m33899a(byte):java.lang.String");
    }

    /* renamed from: b */
    public static String m33895b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length > 0) {
                try {
                } catch (Throwable unused) {
                    return null;
                }
            }
            return m33896a(MessageDigest.getInstance("MD5").digest(bArr));
        }
        return null;
    }

    /* renamed from: c */
    public static String m33894c(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            cArr2[i2] = cArr[(b >>> 4) & 15];
            cArr2[i2 + 1] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    /* renamed from: d */
    public static byte[] m33893d(byte[] bArr) {
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

    /* renamed from: a */
    public static String m33896a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(m33899a(b));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m33897a(String str) {
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
            return m33896a(MessageDigest.getInstance("MD5").digest(str2.getBytes()));
        } catch (Throwable unused2) {
            str3 = str2;
            return str3;
        }
    }

    /* renamed from: a */
    public static String m33898a(File file) {
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
                    String m33894c = m33894c(messageDigest.digest());
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                    return m33894c;
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
