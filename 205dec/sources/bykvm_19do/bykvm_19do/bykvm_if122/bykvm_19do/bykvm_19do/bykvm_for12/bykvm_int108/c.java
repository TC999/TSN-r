package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.h;
import java.util.LinkedHashMap;

/* compiled from: MultiProcessFileUtils.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c {
    public static void a(Context context, int i4, String str, int i5) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i4 == 1) {
                linkedHashMap.put(a(i5), str);
            }
            b.a("MultiProcessFileUtils", "saveData = " + str);
            if (h.a().a(i5).b() != null) {
                h.a().a(i5).b().a(context, linkedHashMap);
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
    public static java.lang.String a(android.content.Context r2, int r3, int r4) {
        /*
            java.lang.String r0 = ""
            r1 = 1
            if (r3 == r1) goto L6
            goto L29
        L6:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.h r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.h.a()     // Catch: java.lang.Exception -> L29
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.f r3 = r3.a(r4)     // Catch: java.lang.Exception -> L29
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b r3 = r3.b()     // Catch: java.lang.Exception -> L29
            if (r3 == 0) goto L29
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.h r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.h.a()     // Catch: java.lang.Exception -> L29
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.f r3 = r3.a(r4)     // Catch: java.lang.Exception -> L29
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b r3 = r3.b()     // Catch: java.lang.Exception -> L29
            java.lang.String r4 = a(r4)     // Catch: java.lang.Exception -> L29
            java.lang.String r2 = r3.a(r2, r4, r0)     // Catch: java.lang.Exception -> L29
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.c.a(android.content.Context, int, int):java.lang.String");
    }

    private static String a(int i4) {
        return "tnc_config" + i4;
    }
}
