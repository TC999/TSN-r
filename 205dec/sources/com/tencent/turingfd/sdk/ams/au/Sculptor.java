package com.tencent.turingfd.sdk.ams.au;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Sculptor {
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0045, code lost:
        if (r4 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = ""
            android.content.pm.PackageManager r1 = r3.getPackageManager()     // Catch: java.lang.Throwable -> L44
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch: java.lang.Throwable -> L44
            r2 = 0
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo(r4, r2)     // Catch: java.lang.Throwable -> L44
            int r3 = r3.uid     // Catch: java.lang.Throwable -> L44
            java.lang.String[] r3 = r1.getPackagesForUid(r3)     // Catch: java.lang.Throwable -> L44
            r3 = r3[r2]     // Catch: java.lang.Throwable -> L44
            r4 = 64
            android.content.pm.PackageInfo r3 = r1.getPackageInfo(r3, r4)     // Catch: java.lang.Throwable -> L44
            android.content.pm.Signature[] r3 = r3.signatures     // Catch: java.lang.Throwable -> L44
            r3 = r3[r2]     // Catch: java.lang.Throwable -> L44
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L44
            byte[] r3 = r3.toByteArray()     // Catch: java.lang.Throwable -> L44
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L44
            java.lang.String r3 = "X.509"
            java.security.cert.CertificateFactory r3 = java.security.cert.CertificateFactory.getInstance(r3)     // Catch: java.lang.Throwable -> L42
            java.security.cert.Certificate r3 = r3.generateCertificate(r4)     // Catch: java.lang.Throwable -> L42
            java.security.cert.X509Certificate r3 = (java.security.cert.X509Certificate) r3     // Catch: java.lang.Throwable -> L42
            byte[] r3 = r3.getEncoded()     // Catch: java.lang.Throwable -> L42
            java.lang.String r0 = com.tencent.turingfd.sdk.ams.au.Hydra.a(r3)     // Catch: java.lang.Throwable -> L42
        L3e:
            r4.close()     // Catch: java.lang.Throwable -> L48
            goto L48
        L42:
            goto L45
        L44:
            r4 = 0
        L45:
            if (r4 == 0) goto L48
            goto L3e
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Sculptor.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static List<String> a(File file) throws IOException {
        ArrayList arrayList = new ArrayList();
        JarFile jarFile = new JarFile(file);
        try {
            Certificate[] a4 = a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), new byte[8192]);
            if (a4 != null) {
                for (Certificate certificate : a4) {
                    arrayList.add(Hydra.a(certificate.getEncoded()));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            jarFile.close();
            throw th;
        }
        jarFile.close();
        return arrayList;
    }

    public static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            inputStream = jarFile.getInputStream(jarEntry);
            while (inputStream.read(bArr, 0, bArr.length) != -1) {
                try {
                } catch (IOException unused) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            }
            Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
            try {
                inputStream.close();
            } catch (IOException unused4) {
            }
            return certificates;
        } catch (IOException unused5) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
