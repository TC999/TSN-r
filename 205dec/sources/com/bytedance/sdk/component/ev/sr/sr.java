package com.bytedance.sdk.component.ev.sr;

import android.content.Context;
import com.bytedance.sdk.component.ev.xv.r;
import java.util.LinkedHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {
    public static void c(Context context, int i4, String str, int i5) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i4 == 1) {
                linkedHashMap.put(c(i5), str);
            }
            xv.xv("MultiProcessFileUtils", "saveData = " + str);
            if (r.c().c(i5).sr() != null) {
                r.c().c(i5).sr().c(context, linkedHashMap);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(android.content.Context r2, int r3, int r4) {
        /*
            java.lang.String r0 = ""
            r1 = 1
            if (r3 == r1) goto L6
            goto L29
        L6:
            com.bytedance.sdk.component.ev.xv.r r3 = com.bytedance.sdk.component.ev.xv.r.c()     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.ev.xv.ux r3 = r3.c(r4)     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.ev.xv.w r3 = r3.sr()     // Catch: java.lang.Exception -> L29
            if (r3 == 0) goto L29
            com.bytedance.sdk.component.ev.xv.r r3 = com.bytedance.sdk.component.ev.xv.r.c()     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.ev.xv.ux r3 = r3.c(r4)     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.ev.xv.w r3 = r3.sr()     // Catch: java.lang.Exception -> L29
            java.lang.String r4 = c(r4)     // Catch: java.lang.Exception -> L29
            java.lang.String r2 = r3.c(r2, r4, r0)     // Catch: java.lang.Exception -> L29
            goto L2a
        L29:
            r2 = r0
        L2a:
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L32
            java.lang.String r0 = java.lang.String.valueOf(r2)
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.ev.sr.sr.c(android.content.Context, int, int):java.lang.String");
    }

    private static String c(int i4) {
        return "tnc_config" + i4;
    }
}
