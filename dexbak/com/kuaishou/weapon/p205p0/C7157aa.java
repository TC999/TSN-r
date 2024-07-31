package com.kuaishou.weapon.p205p0;

import java.io.BufferedInputStream;

/* renamed from: com.kuaishou.weapon.p0.aa */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7157aa {

    /* renamed from: a */
    private static volatile C7157aa f24474a;

    private C7157aa() {
    }

    /* renamed from: a */
    public static synchronized C7157aa m34446a() {
        C7157aa c7157aa;
        synchronized (C7157aa.class) {
            if (f24474a == null) {
                synchronized (C7157aa.class) {
                    if (f24474a == null) {
                        f24474a = new C7157aa();
                    }
                }
            }
            c7157aa = f24474a;
        }
        return c7157aa;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m34443b(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L66
            java.lang.String r2 = "sh"
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L66
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L48
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L48
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L48
            byte[] r6 = r6.getBytes()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r2.write(r6)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r6 = 10
            r2.write(r6)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r2.flush()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r2.close()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r1.waitFor()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            java.lang.String r6 = m34445a(r3)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r2.close()     // Catch: java.io.IOException -> L39
        L39:
            r3.close()     // Catch: java.io.IOException -> L3c
        L3c:
            r1.destroy()
            return r6
        L40:
            r6 = move-exception
            goto L46
        L42:
            goto L69
        L44:
            r6 = move-exception
            r3 = r0
        L46:
            r0 = r2
            goto L52
        L48:
            r3 = r0
            goto L69
        L4a:
            r6 = move-exception
            r3 = r0
            goto L52
        L4d:
            r2 = r0
            goto L68
        L4f:
            r6 = move-exception
            r1 = r0
            r3 = r1
        L52:
            if (r0 == 0) goto L59
            r0.close()     // Catch: java.io.IOException -> L58
            goto L59
        L58:
        L59:
            if (r3 == 0) goto L60
            r3.close()     // Catch: java.io.IOException -> L5f
            goto L60
        L5f:
        L60:
            if (r1 == 0) goto L65
            r1.destroy()
        L65:
            throw r6
        L66:
            r1 = r0
            r2 = r1
        L68:
            r3 = r2
        L69:
            if (r2 == 0) goto L70
            r2.close()     // Catch: java.io.IOException -> L6f
            goto L70
        L6f:
        L70:
            if (r3 == 0) goto L77
            r3.close()     // Catch: java.io.IOException -> L76
            goto L77
        L76:
        L77:
            if (r1 == 0) goto L7c
            r1.destroy()
        L7c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p205p0.C7157aa.m34443b(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public String m34444a(String str) {
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m34445a(BufferedInputStream bufferedInputStream) {
        int read;
        if (bufferedInputStream == null) {
            return "";
        }
        byte[] bArr = new byte[512];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                    continue;
                }
            } catch (Exception unused) {
            }
        } while (read >= 512);
        return sb.toString();
    }
}
