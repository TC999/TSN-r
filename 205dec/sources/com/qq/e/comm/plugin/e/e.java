package com.qq.e.comm.plugin.e;

import android.content.Context;
import android.view.View;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.g0.e eVar) {
        v.a(1130008, com.qq.e.comm.plugin.n0.c.a(eVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.qq.e.comm.plugin.n0.d dVar) {
        v.a(1130016, null, 0, 0, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i4, int i5) {
        v.a(11300010, null, Integer.valueOf(i4), Integer.valueOf(i5), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "cas"
            java.lang.String r1 = "as"
            java.lang.String r2 = ""
            if (r7 == 0) goto L79
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 == 0) goto L10
            goto L79
        L10:
            r3 = 0
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Exception -> L44
            r5.<init>(r8)     // Catch: java.lang.Exception -> L44
            java.lang.String r8 = r5.optString(r1)     // Catch: java.lang.Exception -> L44
            java.lang.String r5 = r5.optString(r0)     // Catch: java.lang.Exception -> L40
            boolean r6 = r8.equals(r5)     // Catch: java.lang.Exception -> L3e
            if (r6 == 0) goto L26
            return
        L26:
            android.content.Context r6 = r7.getApplicationContext()     // Catch: java.lang.Exception -> L3e
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch: java.lang.Exception -> L3e
            java.lang.String r7 = r7.getPackageName()     // Catch: java.lang.Exception -> L3e
            android.content.pm.ApplicationInfo r7 = r6.getApplicationInfo(r7, r4)     // Catch: java.lang.Exception -> L3e
            java.lang.String r2 = r7.sourceDir     // Catch: java.lang.Exception -> L3e
            java.io.File r7 = new java.io.File     // Catch: java.lang.Exception -> L3e
            r7.<init>(r2)     // Catch: java.lang.Exception -> L3e
            goto L49
        L3e:
            r7 = r2
            goto L42
        L40:
            r7 = r2
            r5 = r7
        L42:
            r2 = r8
            goto L46
        L44:
            r7 = r2
            r5 = r7
        L46:
            r8 = r2
            r2 = r7
            r7 = r3
        L49:
            com.qq.e.comm.plugin.n0.d r6 = new com.qq.e.comm.plugin.n0.d
            r6.<init>()
            r6.a(r1, r8)
            r6.a(r0, r5)
            java.lang.String r8 = "dir"
            r6.a(r8, r2)
            if (r7 != 0) goto L5e
            java.lang.String r7 = "null"
            goto L66
        L5e:
            boolean r7 = r7.isDirectory()
            java.lang.String r7 = java.lang.String.valueOf(r7)
        L66:
            java.lang.String r8 = "isDir"
            r6.a(r8, r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            r0 = 11300011(0xac6cab, float:1.5834688E-38)
            com.qq.e.comm.plugin.n0.v.a(r0, r3, r7, r8, r6)
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.e.e.a(android.content.Context, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view, com.qq.e.comm.plugin.g0.e eVar) {
        Context context = view.getContext();
        if (context != null && context.hashCode() == j.b().a()) {
            d1.a("AdView attached activity is start from background " + context);
            v.a(9120010, com.qq.e.comm.plugin.n0.c.a(eVar));
        }
    }
}
