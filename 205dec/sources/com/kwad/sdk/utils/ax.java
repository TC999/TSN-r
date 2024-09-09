package com.kwad.sdk.utils;

import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ax {
    public static String ac(File file) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
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
                        String m4 = ad.m(messageDigest.digest());
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

    public static String gJ(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[0];
            if (Build.VERSION.SDK_INT >= 19) {
                bArr = messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
            }
            return ad.m(bArr);
        } catch (NoSuchAlgorithmException e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
            return null;
        }
    }
}
