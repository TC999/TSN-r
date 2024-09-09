package com.tencent.turingfd.sdk.ams.au;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.strictfp  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cstrictfp {
    /* JADX WARN: Removed duplicated region for block: B:11:0x0018 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r5, java.lang.String r6) {
        /*
            r0 = 0
            r1 = 0
            android.content.Context r5 = r5.getApplicationContext()     // Catch: java.lang.Throwable -> L15
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L15
            if (r5 == 0) goto L15
            android.content.pm.PackageInfo r5 = r5.getPackageArchiveInfo(r6, r0)     // Catch: java.lang.Throwable -> L15
            if (r5 == 0) goto L15
            java.lang.String r5 = r5.packageName     // Catch: java.lang.Throwable -> L15
            goto L16
        L15:
            r5 = r1
        L16:
            if (r5 == 0) goto L19
            return r5
        L19:
            java.lang.String r2 = "AndroidManifest.xml"
            r3 = 19
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L5c
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L5c
            java.util.zip.ZipEntry r6 = r4.getEntry(r2)     // Catch: java.lang.Throwable -> L5d
            java.io.InputStream r6 = r4.getInputStream(r6)     // Catch: java.lang.Throwable -> L5d
            com.tencent.turingfd.sdk.ams.au.public r1 = new com.tencent.turingfd.sdk.ams.au.public     // Catch: java.lang.Throwable -> L5a
            r1.<init>()     // Catch: java.lang.Throwable -> L5a
            org.w3c.dom.Document r1 = r1.a(r6)     // Catch: java.lang.Throwable -> L5a
            org.w3c.dom.NodeList r1 = r1.getChildNodes()     // Catch: java.lang.Throwable -> L5a
            org.w3c.dom.Node r0 = r1.item(r0)     // Catch: java.lang.Throwable -> L5a
            org.w3c.dom.NamedNodeMap r0 = r0.getAttributes()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r1 = "package"
            org.w3c.dom.Node r0 = r0.getNamedItem(r1)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r5 = r0.getNodeValue()     // Catch: java.lang.Throwable -> L5a
            com.tencent.turingfd.sdk.ams.au.Ara.a(r6)
            int r6 = com.tencent.turingfd.sdk.ams.au.Cthrows.b()     // Catch: java.lang.Throwable -> L6d
            if (r6 < r3) goto L56
            com.tencent.turingfd.sdk.ams.au.Ara.a(r4)     // Catch: java.lang.Throwable -> L6d
            goto L6d
        L56:
            r4.close()     // Catch: java.lang.Throwable -> L6d
            goto L6d
        L5a:
            r1 = r6
            goto L5d
        L5c:
            r4 = r1
        L5d:
            com.tencent.turingfd.sdk.ams.au.Ara.a(r1)
            int r6 = com.tencent.turingfd.sdk.ams.au.Cthrows.b()     // Catch: java.lang.Throwable -> L6d
            if (r6 < r3) goto L6a
            com.tencent.turingfd.sdk.ams.au.Ara.a(r4)     // Catch: java.lang.Throwable -> L6d
            goto L6d
        L6a:
            r4.close()     // Catch: java.lang.Throwable -> L6d
        L6d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Cstrictfp.a(android.content.Context, java.lang.String):java.lang.String");
    }
}
