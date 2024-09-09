package com.baidu.liantian.b;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5Util.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f12148a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

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
            return d(MessageDigest.getInstance("MD5").digest(str2.getBytes()));
        } catch (Throwable unused2) {
            str3 = str2;
            e.a();
            return str3;
        }
    }

    public static String b(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b4 : digest) {
                String upperCase = Integer.toHexString(b4 & 255).toUpperCase();
                if (upperCase.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase);
                sb.append("");
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e4) {
            throw new RuntimeException(e4);
        }
    }

    public static byte[] c(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (Throwable unused) {
            e.a();
            return null;
        }
    }

    private static String d(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 : bArr) {
            if (i4 < 0) {
                i4 += 256;
            }
            StringBuilder sb = new StringBuilder();
            String[] strArr = f12148a;
            sb.append(strArr[i4 / 16]);
            sb.append(strArr[i4 % 16]);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }

    private static String e(byte[] bArr) {
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

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return d(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Throwable unused) {
            e.a();
            return null;
        }
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return null;
        }
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
                String e4 = e(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                    e.a();
                }
                return e4;
            } catch (Throwable unused2) {
                try {
                    e.a();
                    return null;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                            e.a();
                        }
                    }
                }
            }
        } catch (Throwable unused4) {
            fileInputStream = null;
        }
    }
}
