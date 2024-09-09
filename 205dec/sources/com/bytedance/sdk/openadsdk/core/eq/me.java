package com.bytedance.sdk.openadsdk.core.eq;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class me {

    /* renamed from: c  reason: collision with root package name */
    private static String f33273c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.FileReader] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.io.FileReader, java.io.Reader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(java.lang.String r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.lang.String r2 = "com.union_test.toutiao"
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            r4.<init>()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            java.lang.String r5 = "data/data/"
            r4.append(r5)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            r4.append(r2)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            java.lang.String r2 = "/"
            r4.append(r2)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            r4.append(r7)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            boolean r7 = r3.exists()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            if (r7 != 0) goto L2d
            return r1
        L2d:
            java.io.FileReader r7 = new java.io.FileReader     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            r7.<init>(r3)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L51
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L51
        L37:
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Exception -> L4c java.lang.Throwable -> L71
            if (r1 == 0) goto L41
            r0.append(r1)     // Catch: java.lang.Exception -> L4c java.lang.Throwable -> L71
            goto L37
        L41:
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L4c java.lang.Throwable -> L71
            r7.close()     // Catch: java.lang.Throwable -> L48
        L48:
            r2.close()     // Catch: java.lang.Throwable -> L4b
        L4b:
            return r0
        L4c:
            r1 = move-exception
            goto L5d
        L4e:
            r0 = move-exception
            r2 = r1
            goto L72
        L51:
            r2 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L5d
        L56:
            r0 = move-exception
            r2 = r1
            goto L73
        L59:
            r7 = move-exception
            r2 = r1
            r1 = r7
            r7 = r2
        L5d:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L71
            if (r7 == 0) goto L67
            r7.close()     // Catch: java.lang.Throwable -> L66
            goto L67
        L66:
        L67:
            if (r2 == 0) goto L6c
            r2.close()     // Catch: java.lang.Throwable -> L6c
        L6c:
            java.lang.String r7 = r0.toString()
            return r7
        L71:
            r0 = move-exception
        L72:
            r1 = r7
        L73:
            if (r1 == 0) goto L7a
            r1.close()     // Catch: java.lang.Throwable -> L79
            goto L7a
        L79:
        L7a:
            if (r2 == 0) goto L7f
            r2.close()     // Catch: java.lang.Throwable -> L7f
        L7f:
            goto L81
        L80:
            throw r0
        L81:
            goto L80
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.eq.me.c(java.lang.String):java.lang.String");
    }

    public static String w(String str) {
        try {
            if (c()) {
                String y3 = com.bytedance.sdk.openadsdk.core.k.sr().y();
                return TextUtils.isEmpty(y3) ? str : Uri.parse(str).buildUpon().appendQueryParameter(w(), y3).appendQueryParameter("aid", "5001121").toString();
            }
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String w() {
        if (TextUtils.isEmpty(f33273c)) {
            f33273c = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return f33273c;
    }

    public static boolean c() {
        if (com.bytedance.sdk.component.utils.a.xv()) {
            return com.bytedance.sdk.openadsdk.core.k.sr().z();
        }
        return false;
    }

    public static String c(String str, String str2) {
        return str.contains("https://api-access.pangolin-sdk-toutiao.com") ? str.replace("https://api-access.pangolin-sdk-toutiao.com", str2) : str;
    }

    public static void c(Map<String, String> map) {
        if (c()) {
            map.put("x-app-id", "5001121");
            String y3 = com.bytedance.sdk.openadsdk.core.k.sr().y();
            if (TextUtils.isEmpty(y3)) {
                return;
            }
            map.put("x-device-id", y3);
        }
    }
}
