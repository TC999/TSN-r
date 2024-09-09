package com.kwad.sdk.api.loader;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class s {
    private static final char[] ani = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getFileMD5(File file) {
        Throwable th;
        DigestInputStream digestInputStream;
        Exception e4;
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            digestInputStream = new DigestInputStream(new FileInputStream(file), messageDigest);
        } catch (Exception e5) {
            e4 = e5;
            digestInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            digestInputStream = null;
            b(digestInputStream);
            throw th;
        }
        try {
            try {
                byte[] bArr = new byte[1024];
                for (int read = digestInputStream.read(bArr); read != -1; read = digestInputStream.read(bArr)) {
                }
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder(digest.length * 2);
                for (byte b4 : digest) {
                    int i4 = b4 & 255;
                    if (i4 < 16) {
                        sb.append("0");
                    }
                    sb.append(Integer.toHexString(i4));
                }
                String sb2 = sb.toString();
                b(digestInputStream);
                return sb2;
            } catch (Throwable th3) {
                th = th3;
                b(digestInputStream);
                throw th;
            }
        } catch (Exception e6) {
            e4 = e6;
            e4.printStackTrace();
            b(digestInputStream);
            return "";
        }
    }
}
