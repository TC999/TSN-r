package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ad {
    static final char[] ani = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String ab(File file) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
            throw th;
        }
        try {
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        String m4 = m(messageDigest.digest());
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                        return m4;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            return null;
        }
    }

    @NonNull
    public static String bu(String str) {
        return TextUtils.isEmpty(str) ? "" : l(str.getBytes());
    }

    public static String gy(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            return toHexString(digest, 0, digest.length);
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
            return "";
        }
    }

    public static String gz(String str) {
        return ab(new File(str));
    }

    public static String l(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            int length = digest.length;
            for (int i4 = 0; i4 < length; i4++) {
                int i5 = digest[i4];
                if (i5 < 0) {
                    i5 += 256;
                }
                if (i5 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i5));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String m(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i4])));
        }
        return stringBuffer.toString();
    }

    public static String toHexString(byte[] bArr, int i4, int i5) {
        ap.checkNotNull(bArr);
        if (i5 + 0 <= bArr.length) {
            int i6 = i5 * 2;
            char[] cArr = new char[i6];
            int i7 = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = bArr[i8 + 0] & 255;
                int i10 = i7 + 1;
                char[] cArr2 = ani;
                cArr[i7] = cArr2[i9 >> 4];
                i7 = i10 + 1;
                cArr[i10] = cArr2[i9 & 15];
            }
            return new String(cArr, 0, i6);
        }
        throw new IndexOutOfBoundsException();
    }
}
