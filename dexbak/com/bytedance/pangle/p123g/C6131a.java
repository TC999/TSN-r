package com.bytedance.pangle.p123g;

import android.content.pm.Signature;
import com.bytedance.pangle.util.C6248d;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* renamed from: com.bytedance.pangle.g.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6131a {

    /* renamed from: a */
    private static final AtomicReference<byte[]> f22014a = new AtomicReference<>();

    /* renamed from: a */
    public static C6153o m37140a(String str) {
        JarFile jarFile = null;
        try {
            try {
                JarFile jarFile2 = new JarFile(str);
                try {
                    ArrayList<JarEntry> arrayList = new ArrayList();
                    JarEntry jarEntry = jarFile2.getJarEntry("AndroidManifest.xml");
                    if (jarEntry != null) {
                        Certificate[][] m37139a = m37139a(jarFile2, jarEntry);
                        if (!C6248d.m36906a(m37139a)) {
                            Signature[] m37129a = C6138d.m37129a(m37139a);
                            Enumeration<JarEntry> entries = jarFile2.entries();
                            while (entries.hasMoreElements()) {
                                JarEntry nextElement = entries.nextElement();
                                if (!nextElement.isDirectory()) {
                                    String name = nextElement.getName();
                                    if (!name.startsWith("META-INF/") && !name.equals("AndroidManifest.xml")) {
                                        arrayList.add(nextElement);
                                    }
                                }
                            }
                            for (JarEntry jarEntry2 : arrayList) {
                                Certificate[][] m37139a2 = m37139a(jarFile2, jarEntry2);
                                if (!C6248d.m36906a(m37139a2)) {
                                    if (!C6153o.m37095a(m37129a, C6138d.m37129a(m37139a2))) {
                                        throw new C6155q(3, "Package " + str + " has mismatched certificates at entry " + jarEntry2.getName());
                                    }
                                } else {
                                    throw new C6155q(4, "Package " + str + " has no certificates at entry " + jarEntry2.getName());
                                }
                            }
                            C6153o c6153o = new C6153o(m37129a, 1, null, null, null);
                            try {
                                jarFile2.close();
                            } catch (Exception unused) {
                            }
                            return c6153o;
                        }
                        throw new C6155q(4, "Package " + str + " has no certificates at entry AndroidManifest.xml");
                    }
                    throw new C6155q(1, "Package " + str + " has no manifest");
                } catch (IOException e) {
                    e = e;
                    throw new C6155q(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (RuntimeException e2) {
                    e = e2;
                    throw new C6155q(4, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (GeneralSecurityException e3) {
                    e = e3;
                    throw new C6155q(2, "Failed to collect certificates from ".concat(String.valueOf(str)), e);
                } catch (Throwable th) {
                    th = th;
                    jarFile = jarFile2;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
            } catch (RuntimeException e5) {
                e = e5;
            } catch (GeneralSecurityException e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0031: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:15:0x0031 */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.security.cert.Certificate[][] m37139a(java.util.jar.JarFile r7, java.util.jar.JarEntry r8) {
        /*
            r0 = 0
            java.io.InputStream r1 = r7.getInputStream(r8)     // Catch: java.lang.Throwable -> L37 java.lang.RuntimeException -> L39 java.io.IOException -> L3b
            java.util.concurrent.atomic.AtomicReference<byte[]> r2 = com.bytedance.pangle.p123g.C6131a.f22014a     // Catch: java.lang.Throwable -> L30 java.lang.RuntimeException -> L33 java.io.IOException -> L35
            java.lang.Object r0 = r2.getAndSet(r0)     // Catch: java.lang.Throwable -> L30 java.lang.RuntimeException -> L33 java.io.IOException -> L35
            byte[] r0 = (byte[]) r0     // Catch: java.lang.Throwable -> L30 java.lang.RuntimeException -> L33 java.io.IOException -> L35
            if (r0 != 0) goto L13
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L30 java.lang.RuntimeException -> L33 java.io.IOException -> L35
        L13:
            int r2 = r0.length     // Catch: java.lang.Throwable -> L30 java.lang.RuntimeException -> L33 java.io.IOException -> L35
            r3 = 0
            int r2 = r1.read(r0, r3, r2)     // Catch: java.lang.Throwable -> L30 java.lang.RuntimeException -> L33 java.io.IOException -> L35
            r4 = -1
            if (r2 != r4) goto L13
            java.util.concurrent.atomic.AtomicReference<byte[]> r2 = com.bytedance.pangle.p123g.C6131a.f22014a     // Catch: java.lang.Throwable -> L30 java.lang.RuntimeException -> L33 java.io.IOException -> L35
            r2.set(r0)     // Catch: java.lang.Throwable -> L30 java.lang.RuntimeException -> L33 java.io.IOException -> L35
            r0 = 1
            java.security.cert.Certificate[][] r0 = new java.security.cert.Certificate[r0]     // Catch: java.lang.Throwable -> L30 java.lang.RuntimeException -> L33 java.io.IOException -> L35
            java.security.cert.Certificate[] r2 = r8.getCertificates()     // Catch: java.lang.Throwable -> L30 java.lang.RuntimeException -> L33 java.io.IOException -> L35
            r0[r3] = r2     // Catch: java.lang.Throwable -> L30 java.lang.RuntimeException -> L33 java.io.IOException -> L35
            r1.close()     // Catch: java.lang.Exception -> L2d java.lang.RuntimeException -> L2e
        L2d:
            return r0
        L2e:
            r7 = move-exception
            throw r7
        L30:
            r7 = move-exception
            r0 = r1
            goto L60
        L33:
            r0 = move-exception
            goto L3f
        L35:
            r0 = move-exception
            goto L3f
        L37:
            r7 = move-exception
            goto L60
        L39:
            r1 = move-exception
            goto L3c
        L3b:
            r1 = move-exception
        L3c:
            r6 = r1
            r1 = r0
            r0 = r6
        L3f:
            com.bytedance.pangle.g.q r2 = new com.bytedance.pangle.g.q     // Catch: java.lang.Throwable -> L30
            r3 = 5
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L30
            java.lang.String r5 = "Failed reading "
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L30
            java.lang.String r8 = r8.getName()     // Catch: java.lang.Throwable -> L30
            r4.append(r8)     // Catch: java.lang.Throwable -> L30
            java.lang.String r8 = " in "
            r4.append(r8)     // Catch: java.lang.Throwable -> L30
            r4.append(r7)     // Catch: java.lang.Throwable -> L30
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L30
            r2.<init>(r3, r7, r0)     // Catch: java.lang.Throwable -> L30
            throw r2     // Catch: java.lang.Throwable -> L30
        L60:
            if (r0 == 0) goto L68
            r0.close()     // Catch: java.lang.RuntimeException -> L66 java.lang.Exception -> L68
            goto L68
        L66:
            r7 = move-exception
            throw r7
        L68:
            goto L6a
        L69:
            throw r7
        L6a:
            goto L69
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.p123g.C6131a.m37139a(java.util.jar.JarFile, java.util.jar.JarEntry):java.security.cert.Certificate[][]");
    }
}
