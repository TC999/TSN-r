package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class dj {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12762a = "error_message";

    /* renamed from: b  reason: collision with root package name */
    public static final String f12763b = "error_code";

    /* renamed from: d  reason: collision with root package name */
    private static volatile dj f12764d;

    /* renamed from: c  reason: collision with root package name */
    protected final bv f12765c = bv.a();

    private dj() {
    }

    public static dj a() {
        if (f12764d == null) {
            synchronized (dj.class) {
                if (f12764d == null) {
                    f12764d = new dj();
                }
            }
        }
        return f12764d;
    }

    public String a(br brVar, String str) {
        if (brVar == null) {
            return "";
        }
        return a(brVar.b() + "", brVar.c(), str);
    }

    public String a(String str, String str2, String str3) {
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "error_message"
            java.lang.String r1 = "msg"
            java.lang.String r2 = ""
            if (r5 == 0) goto L26
            boolean r3 = r5.containsKey(r1)     // Catch: java.lang.Exception -> L26
            if (r3 == 0) goto L19
            java.lang.Object r5 = r5.get(r1)     // Catch: java.lang.Exception -> L26
            com.baidu.mobads.sdk.internal.br r5 = (com.baidu.mobads.sdk.internal.br) r5     // Catch: java.lang.Exception -> L26
            java.lang.String r5 = r4.a(r5, r2)     // Catch: java.lang.Exception -> L26
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.dj.a(java.util.Map):java.lang.String");
    }
}
