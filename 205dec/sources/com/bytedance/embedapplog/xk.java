package com.bytedance.embedapplog;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xk extends i {

    /* renamed from: f  reason: collision with root package name */
    private final n f26840f;
    private final Context ux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public xk(Context context, n nVar) {
        super(false, false);
        this.ux = context;
        this.f26840f = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x002b -> B:14:0x002c). Please submit an issue!!! */
    @Override // com.bytedance.embedapplog.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c(org.json.JSONObject r9) {
        /*
            r8 = this;
            r0 = 0
            com.bytedance.embedapplog.n r1 = r8.f26840f     // Catch: java.lang.Exception -> L25
            if (r1 == 0) goto L2b
            boolean r1 = r1.gw()     // Catch: java.lang.Exception -> L25
            if (r1 == 0) goto L18
            android.content.Context r1 = r8.ux     // Catch: java.lang.Exception -> L25
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Exception -> L25
            java.lang.String r2 = "android_id"
            java.lang.String r1 = android.provider.Settings.Secure.getString(r1, r2)     // Catch: java.lang.Exception -> L25
            goto L2c
        L18:
            com.bytedance.embedapplog.n r1 = r8.f26840f     // Catch: java.lang.Exception -> L25
            java.lang.String r1 = r1.vc()     // Catch: java.lang.Exception -> L25
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L25
            if (r2 != 0) goto L2b
            goto L2c
        L25:
            r1 = move-exception
            java.lang.String r2 = ""
            com.bytedance.embedapplog.be.xv(r2, r1)
        L2b:
            r1 = r0
        L2c:
            boolean r2 = com.bytedance.embedapplog.ck.c(r1)
            r3 = 1
            java.lang.String r4 = "openudid"
            if (r2 == 0) goto L3d
            java.lang.String r2 = "9774d56d682e549c"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto Lb3
        L3d:
            android.content.Context r1 = r8.ux
            java.lang.String r2 = "snssdk_openudid"
            r5 = 0
            android.content.SharedPreferences r1 = com.bytedance.sdk.openadsdk.api.plugin.w.w(r1, r2, r5)
            java.lang.String r2 = "custom_b"
            java.lang.String r6 = r1.getString(r2, r0)
            java.lang.String r6 = com.bytedance.embedapplog.ls.w(r6)
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 == 0) goto L5b
            java.lang.String r0 = r1.getString(r4, r0)
            goto L5c
        L5b:
            r0 = r6
        L5c:
            boolean r6 = com.bytedance.embedapplog.ck.c(r0)
            if (r6 != 0) goto Lb2
            java.security.SecureRandom r0 = new java.security.SecureRandom
            r0.<init>()
            java.math.BigInteger r6 = new java.math.BigInteger
            r7 = 64
            r6.<init>(r7, r0)
            r0 = 16
            java.lang.String r0 = r6.toString(r0)
            char r5 = r0.charAt(r5)
            r6 = 45
            if (r5 != r6) goto L80
            java.lang.String r0 = r0.substring(r3)
        L80:
            int r5 = r0.length()
            int r5 = 13 - r5
            if (r5 <= 0) goto L9e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
        L8d:
            if (r5 <= 0) goto L97
            r7 = 70
            r6.append(r7)
            int r5 = r5 + (-1)
            goto L8d
        L97:
            r6.append(r0)
            java.lang.String r0 = r6.toString()
        L9e:
            java.lang.String r5 = "openudid.dat"
            java.lang.String r0 = r8.c(r5, r0)     // Catch: java.lang.Exception -> La4
        La4:
            java.lang.String r5 = com.bytedance.embedapplog.ls.c(r0)
            android.content.SharedPreferences$Editor r1 = r1.edit()
            r1.putString(r2, r5)
            r1.apply()
        Lb2:
            r1 = r0
        Lb3:
            r9.put(r4, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.xk.c(org.json.JSONObject):boolean");
    }
}
