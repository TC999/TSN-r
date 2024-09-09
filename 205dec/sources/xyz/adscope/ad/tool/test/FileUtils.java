package xyz.adscope.ad.tool.test;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class FileUtils {
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.RequiresApi(api = 19)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getTestConfig(android.content.Context r7) throws java.io.IOException {
        /*
            r0 = 0
            android.content.res.AssetManager r7 = r7.getAssets()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4c
            java.lang.String r1 = "asnp_test_json_ad_intertiatal"
            java.io.InputStream r7 = r7.open(r1)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4c
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r1.<init>(r7, r2)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3e
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L7e
            r0.<init>()     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L7e
        L1c:
            java.lang.String r3 = r2.readLine()     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L7e
            if (r3 == 0) goto L26
            r0.append(r3)     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L7e
            goto L1c
        L26:
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L7e
            if (r7 == 0) goto L2f
            r7.close()
        L2f:
            r1.close()
            r2.close()
            return r0
        L36:
            r0 = move-exception
            goto L52
        L38:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r1
            r1 = r6
            goto L82
        L3e:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
            goto L52
        L43:
            r1 = move-exception
            goto L4a
        L45:
            r1 = move-exception
            goto L4f
        L47:
            r7 = move-exception
            r1 = r7
            r7 = r0
        L4a:
            r2 = r0
            goto L82
        L4c:
            r7 = move-exception
            r1 = r7
            r7 = r0
        L4f:
            r2 = r0
            r0 = r1
            r1 = r2
        L52:
            java.lang.String r3 = xyz.adscope.ad.constants.Constants.TAG     // Catch: java.lang.Throwable -> L7e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e
            r4.<init>()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r5 = "getTestConfig error is = "
            r4.append(r5)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L7e
            r4.append(r0)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L7e
            xyz.adscope.common.tool.LogUtil.e(r3, r0)     // Catch: java.lang.Throwable -> L7e
            if (r7 == 0) goto L71
            r7.close()
        L71:
            if (r1 == 0) goto L76
            r1.close()
        L76:
            if (r2 == 0) goto L7b
            r2.close()
        L7b:
            java.lang.String r7 = ""
            return r7
        L7e:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L82:
            if (r7 == 0) goto L87
            r7.close()
        L87:
            if (r0 == 0) goto L8c
            r0.close()
        L8c:
            if (r2 == 0) goto L91
            r2.close()
        L91:
            goto L93
        L92:
            throw r1
        L93:
            goto L92
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.ad.tool.test.FileUtils.getTestConfig(android.content.Context):java.lang.String");
    }
}
