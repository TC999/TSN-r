package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.TncInstanceManager;
import java.util.LinkedHashMap;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class MultiProcessFileUtils {
    /* renamed from: a */
    public static void m58985a(Context context, int i, String str, int i2) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i == 1) {
                linkedHashMap.put(m58987a(i2), str);
            }
            C1003b.m58992a("MultiProcessFileUtils", "saveData = " + str);
            if (TncInstanceManager.m59006a().m59005a(i2).m59021b() != null) {
                TncInstanceManager.m59006a().m59005a(i2).m59021b().mo59044a(context, linkedHashMap);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m58986a(android.content.Context r2, int r3, int r4) {
        /*
            java.lang.String r0 = ""
            r1 = 1
            if (r3 == r1) goto L6
            goto L29
        L6:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.h r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.TncInstanceManager.m59006a()     // Catch: java.lang.Exception -> L29
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.f r3 = r3.m59005a(r4)     // Catch: java.lang.Exception -> L29
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b r3 = r3.m59021b()     // Catch: java.lang.Exception -> L29
            if (r3 == 0) goto L29
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.h r3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.TncInstanceManager.m59006a()     // Catch: java.lang.Exception -> L29
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.f r3 = r3.m59005a(r4)     // Catch: java.lang.Exception -> L29
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b r3 = r3.m59021b()     // Catch: java.lang.Exception -> L29
            java.lang.String r4 = m58987a(r4)     // Catch: java.lang.Exception -> L29
            java.lang.String r2 = r3.mo59045a(r2, r4, r0)     // Catch: java.lang.Exception -> L29
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.MultiProcessFileUtils.m58986a(android.content.Context, int, int):java.lang.String");
    }

    /* renamed from: a */
    private static String m58987a(int i) {
        return "tnc_config" + i;
    }
}
