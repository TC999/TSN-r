package com.kwad.sdk.utils;

import android.os.Build;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10738b;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.kwad.sdk.utils.ax */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11032ax {
    /* renamed from: ac */
    public static String m23990ac(File file) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            fileInputStream = new FileInputStream(file);
        } catch (Exception e) {
            e = e;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            C10738b.closeQuietly(fileInputStream2);
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
                        String m24140m = C11010ad.m24140m(messageDigest.digest());
                        C10738b.closeQuietly(fileInputStream);
                        return m24140m;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                C10738b.closeQuietly(fileInputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            C10331c.printStackTraceOnly(e);
            C10738b.closeQuietly(fileInputStream);
            return null;
        }
    }

    /* renamed from: gJ */
    public static String m23989gJ(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[0];
            if (Build.VERSION.SDK_INT >= 19) {
                bArr = messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
            }
            return C11010ad.m24140m(bArr);
        } catch (NoSuchAlgorithmException e) {
            C10331c.printStackTrace(e);
            return null;
        }
    }
}
