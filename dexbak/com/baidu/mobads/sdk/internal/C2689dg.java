package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;

/* renamed from: com.baidu.mobads.sdk.internal.dg */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2689dg {

    /* renamed from: a */
    public static final String f8951a = "error_message";

    /* renamed from: b */
    public static final String f8952b = "error_code";

    /* renamed from: d */
    private static volatile C2689dg f8953d;

    /* renamed from: c */
    protected final C2634bs f8954c = C2634bs.m50744a();

    private C2689dg() {
    }

    /* renamed from: a */
    public static C2689dg m50553a() {
        if (f8953d == null) {
            synchronized (C2689dg.class) {
                if (f8953d == null) {
                    f8953d = new C2689dg();
                }
            }
        }
        return f8953d;
    }

    /* renamed from: a */
    public String m50552a(EnumC2629bo enumC2629bo, String str) {
        if (enumC2629bo == null) {
            return "";
        }
        return m50551a(enumC2629bo.m50776b() + "", enumC2629bo.m50775c(), str);
    }

    /* renamed from: a */
    public String m50551a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append("ErrorCode: [");
            sb.append(str);
            sb.append("];");
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append("ErrorDesc: [");
            sb.append(str2);
            sb.append("];");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(" Extra: [");
            sb.append(str3);
            sb.append("];");
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0026 -> B:11:0x0026). Please submit an issue!!! */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m50550a(java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "error_message"
            java.lang.String r1 = "msg"
            java.lang.String r2 = ""
            if (r5 == 0) goto L26
            boolean r3 = r5.containsKey(r1)     // Catch: java.lang.Exception -> L26
            if (r3 == 0) goto L19
            java.lang.Object r5 = r5.get(r1)     // Catch: java.lang.Exception -> L26
            com.baidu.mobads.sdk.internal.bo r5 = (com.baidu.mobads.sdk.internal.EnumC2629bo) r5     // Catch: java.lang.Exception -> L26
            java.lang.String r5 = r4.m50552a(r5, r2)     // Catch: java.lang.Exception -> L26
            goto L27
        L19:
            boolean r1 = r5.containsKey(r0)     // Catch: java.lang.Exception -> L26
            if (r1 == 0) goto L26
            java.lang.Object r5 = r5.get(r0)     // Catch: java.lang.Exception -> L26
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L26
            goto L27
        L26:
            r5 = r2
        L27:
            if (r5 != 0) goto L2a
            goto L2b
        L2a:
            r2 = r5
        L2b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.C2689dg.m50550a(java.util.Map):java.lang.String");
    }
}
