package com.baidu.liantian.b;

import android.content.pm.Signature;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: CertUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class d {
    private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            do {
            } while (bufferedInputStream.read(bArr, 0, 8192) != -1);
            bufferedInputStream.close();
            if (jarEntry != null) {
                return jarEntry.getCertificates();
            }
            return null;
        } catch (IOException unused) {
            e.a();
            return null;
        } catch (RuntimeException unused2) {
            e.a();
            return null;
        } catch (Throwable unused3) {
            e.a();
            return null;
        }
    }

    public static PublicKey a(Signature signature) {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
        Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
        try {
            byteArrayInputStream.close();
        } catch (Throwable unused) {
        }
        return generateCertificate.getPublicKey();
    }

    public static PublicKey a(String str) {
        int i4;
        boolean z3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bArr = new byte[8192];
        JarFile jarFile = new JarFile(str);
        Enumeration<JarEntry> entries = jarFile.entries();
        Certificate[] certificateArr = null;
        while (entries.hasMoreElements()) {
            JarEntry nextElement = entries.nextElement();
            if (!nextElement.isDirectory() && !nextElement.getName().startsWith("META-INF/")) {
                Certificate[] a4 = a(jarFile, nextElement, bArr);
                if (a4 == null) {
                    jarFile.close();
                    return null;
                } else if (certificateArr == null) {
                    certificateArr = a4;
                } else {
                    while (i4 < certificateArr.length) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= a4.length) {
                                z3 = false;
                                break;
                            } else if (certificateArr[i4] != null && certificateArr[i4].equals(a4[i5])) {
                                z3 = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        i4 = (z3 && certificateArr.length == a4.length) ? i4 + 1 : 0;
                        jarFile.close();
                        return null;
                    }
                    continue;
                }
            }
        }
        jarFile.close();
        if (certificateArr != null && certificateArr.length > 0) {
            return certificateArr[0].getPublicKey();
        }
        return null;
    }
}
