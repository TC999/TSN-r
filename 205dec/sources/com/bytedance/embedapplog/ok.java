package com.bytedance.embedapplog;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ok {
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] c(java.lang.String r4) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r1 = 8192(0x2000, float:1.148E-41)
            r0.<init>(r1)
            r1 = 0
            boolean r2 = com.bytedance.embedapplog.c.f()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r3 = "UTF-8"
            if (r2 == 0) goto L21
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L2e
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L2e
            byte[] r4 = r4.getBytes(r3)     // Catch: java.lang.Throwable -> L1e
            r2.write(r4)     // Catch: java.lang.Throwable -> L1e
            r1 = r2
            goto L28
        L1e:
            r4 = move-exception
            r1 = r2
            goto L2f
        L21:
            byte[] r4 = r4.getBytes(r3)     // Catch: java.lang.Throwable -> L2e
            r0.write(r4)     // Catch: java.lang.Throwable -> L2e
        L28:
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.io.IOException -> L38
            goto L3c
        L2e:
            r4 = move-exception
        L2f:
            com.bytedance.embedapplog.be.w(r4)     // Catch: java.lang.Throwable -> L4c
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.io.IOException -> L38
            goto L3c
        L38:
            r4 = move-exception
            com.bytedance.embedapplog.be.w(r4)
        L3c:
            byte[] r4 = r0.toByteArray()
            boolean r0 = com.bytedance.embedapplog.c.f()
            if (r0 == 0) goto L4b
            int r0 = r4.length
            byte[] r4 = com.bytedance.embedapplog.util.TTEncryptUtils.a(r4, r0)
        L4b:
            return r4
        L4c:
            r4 = move-exception
            if (r1 == 0) goto L57
            r1.close()     // Catch: java.io.IOException -> L53
            goto L57
        L53:
            r0 = move-exception
            com.bytedance.embedapplog.be.w(r0)
        L57:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.ok.c(java.lang.String):byte[]");
    }
}
