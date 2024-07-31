package com.kwad.sdk.api.loader;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import kotlin.UByte;

/* renamed from: com.kwad.sdk.api.loader.s */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C9756s {
    private static final char[] ani = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    private static void m27848b(Closeable closeable) {
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
        Exception e;
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            digestInputStream = new DigestInputStream(new FileInputStream(file), messageDigest);
        } catch (Exception e2) {
            e = e2;
            digestInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            digestInputStream = null;
            m27848b(digestInputStream);
            throw th;
        }
        try {
            try {
                byte[] bArr = new byte[1024];
                for (int read = digestInputStream.read(bArr); read != -1; read = digestInputStream.read(bArr)) {
                }
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder(digest.length * 2);
                for (byte b : digest) {
                    int i = b & UByte.f41242c;
                    if (i < 16) {
                        sb.append("0");
                    }
                    sb.append(Integer.toHexString(i));
                }
                String sb2 = sb.toString();
                m27848b(digestInputStream);
                return sb2;
            } catch (Throwable th3) {
                th = th3;
                m27848b(digestInputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            m27848b(digestInputStream);
            return "";
        }
    }
}
