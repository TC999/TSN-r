package com.yxcorp.kuaishou.addfp.p578c.p579a;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.android.p577b.C13549a;

/* renamed from: com.yxcorp.kuaishou.addfp.c.a.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C13557a {
    /* JADX WARN: Code restructure failed: missing block: B:102:0x015e, code lost:
        if (r1 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0160, code lost:
        r11 = r0;
        r10 = r1;
        r1 = r12;
        r12 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0139, code lost:
        if (r1 == null) goto L34;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x017f A[Catch: IOException -> 0x017b, TryCatch #20 {IOException -> 0x017b, blocks: (B:112:0x0177, B:116:0x017f, B:118:0x0184), top: B:135:0x0177 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0184 A[Catch: IOException -> 0x017b, TRY_LEAVE, TryCatch #20 {IOException -> 0x017b, blocks: (B:112:0x0177, B:116:0x017f, B:118:0x0184), top: B:135:0x0177 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0177 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012d A[Catch: IOException -> 0x0129, TryCatch #11 {IOException -> 0x0129, blocks: (B:76:0x0125, B:80:0x012d, B:82:0x0132), top: B:133:0x0125 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0132 A[Catch: IOException -> 0x0129, TRY_LEAVE, TryCatch #11 {IOException -> 0x0129, blocks: (B:76:0x0125, B:80:0x012d, B:82:0x0132), top: B:133:0x0125 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0152 A[Catch: IOException -> 0x014e, TryCatch #9 {IOException -> 0x014e, blocks: (B:93:0x014a, B:97:0x0152, B:99:0x0157), top: B:130:0x014a }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0157 A[Catch: IOException -> 0x014e, TRY_LEAVE, TryCatch #9 {IOException -> 0x014e, blocks: (B:93:0x014a, B:97:0x0152, B:99:0x0157), top: B:130:0x014a }] */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.yxcorp.kuaishou.addfp.android.p577b.C13553e m12864a(java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.p578c.p579a.C13557a.m12864a(java.lang.String, boolean):com.yxcorp.kuaishou.addfp.android.b.e");
    }

    /* renamed from: a */
    public static String m12868a(int i, String str) {
        String m12887a;
        Context paramContext = KWEGIDDFP.instance().getParamContext();
        if (paramContext == null) {
            return "";
        }
        String[] split = new String(Base64.decode("U3lzdGVtQFNlY3VyZUBHbG9iYWw=", 0)).split("@");
        String str2 = split[0];
        String str3 = split[1];
        String str4 = split[2];
        if (i == 0) {
            m12887a = C13549a.m12887a(paramContext, split[0], str);
            if (TextUtils.isEmpty(m12887a)) {
                m12887a = Settings.System.getString(paramContext.getContentResolver(), str);
            }
        } else if (i == 1) {
            m12887a = C13549a.m12887a(paramContext, split[1], str);
            if (TextUtils.isEmpty(m12887a)) {
                m12887a = Settings.Secure.getString(paramContext.getContentResolver(), str);
            }
        } else if (i == 2) {
            m12887a = C13549a.m12887a(paramContext, split[2], str);
            if (TextUtils.isEmpty(m12887a)) {
                m12887a = Settings.Global.getString(paramContext.getContentResolver(), str);
            }
        } else {
            m12887a = "";
        }
        return m12887a == null ? "" : m12887a;
    }

    /* renamed from: a */
    public static String m12866a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m12865a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d3  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m12869a() {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.p578c.p579a.C13557a.m12869a():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b1 A[Catch: all -> 0x009f, TRY_LEAVE, TryCatch #2 {all -> 0x009f, blocks: (B:37:0x00a9, B:39:0x00b1), top: B:55:0x00a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c7 A[Catch: all -> 0x00ce, TRY_LEAVE, TryCatch #1 {all -> 0x00ce, blocks: (B:3:0x0004, B:6:0x0019, B:8:0x0025, B:19:0x005c, B:21:0x0062, B:24:0x0069, B:26:0x0073, B:30:0x0083, B:32:0x0089, B:33:0x009f, B:41:0x00c1, B:43:0x00c7, B:28:0x0079, B:13:0x003e, B:15:0x004a, B:17:0x0058), top: B:53:0x0004 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m12867a(android.content.Context r11) {
        /*
            java.lang.String r0 = "k_w_o_d_out_dtt"
            java.lang.String r1 = "KWE_N"
            java.lang.String r2 = m12866a(r11, r0)     // Catch: java.lang.Throwable -> Lce
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r4 = "Lm91a2R0ZnQ="
            java.lang.String r5 = "android.permission.WRITE_EXTERNAL_STORAGE"
            java.lang.String r6 = "android.permission.READ_EXTERNAL_STORAGE"
            r7 = 2
            r8 = 1
            r9 = 0
            java.lang.String r10 = ""
            if (r3 == 0) goto L3e
            java.lang.String[] r3 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> Lce
            r3[r9] = r6     // Catch: java.lang.Throwable -> Lce
            r3[r8] = r5     // Catch: java.lang.Throwable -> Lce
            boolean r3 = com.yxcorp.kuaishou.addfp.android.p577b.C13555g.m12875a(r11, r3)     // Catch: java.lang.Throwable -> Lce
            if (r3 == 0) goto L3b
            com.yxcorp.kuaishou.addfp.android.a.d r3 = com.yxcorp.kuaishou.addfp.android.p576a.C13547d.m12896a(r11)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r10 = r3.m12894a(r4)     // Catch: java.lang.Throwable -> Lce
            boolean r3 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> Lce
            if (r3 != 0) goto L5b
            android.content.ContentResolver r3 = r11.getContentResolver()     // Catch: java.lang.Throwable -> L5b
            android.provider.Settings.System.putString(r3, r0, r10)     // Catch: java.lang.Throwable -> L5b
            goto L5b
        L3b:
            java.lang.String r0 = "KWE_PN"
            goto L5c
        L3e:
            java.lang.String[] r0 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> Lce
            r0[r9] = r6     // Catch: java.lang.Throwable -> Lce
            r0[r8] = r5     // Catch: java.lang.Throwable -> Lce
            boolean r0 = com.yxcorp.kuaishou.addfp.android.p577b.C13555g.m12875a(r11, r0)     // Catch: java.lang.Throwable -> Lce
            if (r0 == 0) goto L5b
            com.yxcorp.kuaishou.addfp.android.a.d r0 = com.yxcorp.kuaishou.addfp.android.p576a.C13547d.m12896a(r11)     // Catch: java.lang.Throwable -> Lce
            java.lang.String r10 = r0.m12894a(r4)     // Catch: java.lang.Throwable -> Lce
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> Lce
            if (r0 == 0) goto L5b
            com.yxcorp.kuaishou.addfp.android.p576a.C13547d.m12895a(r11, r2)     // Catch: java.lang.Throwable -> Lce
        L5b:
            r0 = r1
        L5c:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lce
            if (r3 == 0) goto L69
            boolean r3 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> Lce
            if (r3 == 0) goto L69
            goto Ld4
        L69:
            com.yxcorp.kuaishou.addfp.android.a.d r1 = com.yxcorp.kuaishou.addfp.android.p576a.C13547d.m12896a(r11)     // Catch: java.lang.Throwable -> Lce
            java.util.LinkedHashMap r1 = r1.m12891b(r2)     // Catch: java.lang.Throwable -> Lce
            if (r1 == 0) goto L79
            int r2 = r1.size()     // Catch: java.lang.Throwable -> Lce
            if (r2 != 0) goto L81
        L79:
            com.yxcorp.kuaishou.addfp.android.a.d r11 = com.yxcorp.kuaishou.addfp.android.p576a.C13547d.m12896a(r11)     // Catch: java.lang.Throwable -> Lce
            java.util.LinkedHashMap r1 = r11.m12891b(r10)     // Catch: java.lang.Throwable -> Lce
        L81:
            if (r1 == 0) goto Lcc
            int r11 = r1.size()     // Catch: java.lang.Throwable -> Lce
            if (r11 <= 0) goto Lcc
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lce
            java.util.Set r2 = r1.entrySet()     // Catch: java.lang.Throwable -> Lce
            r11.<init>(r2)     // Catch: java.lang.Throwable -> Lce
            int r1 = r1.size()     // Catch: java.lang.Throwable -> Lce
            java.util.ListIterator r11 = r11.listIterator(r1)     // Catch: java.lang.Throwable -> Lce
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lce
            r1.<init>()     // Catch: java.lang.Throwable -> Lce
        L9f:
            boolean r2 = r11.hasPrevious()     // Catch: java.lang.Throwable -> Lce
            if (r2 == 0) goto Lc1
            r2 = 10
            if (r9 >= r2) goto Lc1
            java.lang.Object r2 = r11.previous()     // Catch: java.lang.Throwable -> L9f
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch: java.lang.Throwable -> L9f
            if (r2 == 0) goto Lbe
            java.lang.Object r3 = r2.getKey()     // Catch: java.lang.Throwable -> L9f
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L9f
            java.lang.Object r2 = r2.getValue()     // Catch: java.lang.Throwable -> L9f
            r1.put(r3, r2)     // Catch: java.lang.Throwable -> L9f
        Lbe:
            int r9 = r9 + 1
            goto L9f
        Lc1:
            int r11 = r1.length()     // Catch: java.lang.Throwable -> Lce
            if (r11 <= 0) goto Lcc
            java.lang.String r11 = r1.toString()     // Catch: java.lang.Throwable -> Lce
            return r11
        Lcc:
            r1 = r0
            goto Ld4
        Lce:
            r11 = move-exception
            r11.printStackTrace()
            java.lang.String r1 = "KWE_PE"
        Ld4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.p578c.p579a.C13557a.m12867a(android.content.Context):java.lang.String");
    }
}
