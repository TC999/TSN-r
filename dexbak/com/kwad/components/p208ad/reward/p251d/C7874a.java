package com.kwad.components.p208ad.reward.p251d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.utils.C11137y;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.d.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7874a {
    /* renamed from: N */
    public static void m32113N(@NonNull Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        C7875b c7875b = new C7875b();
        String m23582ce = C11137y.m23582ce(context);
        int i = 0;
        if (!TextUtils.isEmpty(m23582ce)) {
            try {
                c7875b.parseJson(new JSONObject(m23582ce));
                if (m32111c(c7875b.f26496gM, currentTimeMillis)) {
                    i = c7875b.f26497rt;
                }
            } catch (Exception e) {
                C10331c.printStackTraceOnly(e);
            }
        }
        c7875b.f26496gM = currentTimeMillis;
        c7875b.f26497rt = i + 1;
        C11137y.m23607aa(context, c7875b.toJson().toString());
    }

    /* renamed from: b */
    public static boolean m32112b(@NonNull Context context, AdInfo adInfo) {
        if (C10483a.m25955aG(adInfo)) {
            int max = Math.max(C10483a.m25954aH(adInfo) + 1, 1);
            boolean m32109d = m32109d(context, max);
            m32110c(context, max);
            return m32109d && m32108e(context, C10483a.m25953aI(adInfo));
        }
        return false;
    }

    /* renamed from: c */
    private static boolean m32111c(long j, long j2) {
        return j > 0 && j2 > 0 && j / 2460601000L == j2 / 2460601000L;
    }

    /* renamed from: d */
    private static boolean m32109d(@NonNull Context context, int i) {
        return i != 0 && C11137y.m23583cd(context) % i == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0030 A[RETURN] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m32108e(@androidx.annotation.NonNull android.content.Context r7, int r8) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            com.kwad.components.ad.reward.d.b r2 = new com.kwad.components.ad.reward.d.b
            r2.<init>()
            java.lang.String r7 = com.kwad.sdk.utils.C11137y.m23582ce(r7)
            boolean r3 = android.text.TextUtils.isEmpty(r7)
            r4 = 0
            if (r3 != 0) goto L2b
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L27
            r3.<init>(r7)     // Catch: java.lang.Exception -> L27
            r2.parseJson(r3)     // Catch: java.lang.Exception -> L27
            long r5 = r2.f26496gM     // Catch: java.lang.Exception -> L27
            boolean r7 = m32111c(r5, r0)     // Catch: java.lang.Exception -> L27
            if (r7 == 0) goto L2b
            int r7 = r2.f26497rt     // Catch: java.lang.Exception -> L27
            goto L2c
        L27:
            r7 = move-exception
            com.kwad.sdk.core.p397e.C10331c.printStackTraceOnly(r7)
        L2b:
            r7 = 0
        L2c:
            if (r7 >= r8) goto L30
            r7 = 1
            return r7
        L30:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.p208ad.reward.p251d.C7874a.m32108e(android.content.Context, int):boolean");
    }

    /* renamed from: c */
    private static void m32110c(@NonNull Context context, int i) {
        int m23583cd = C11137y.m23583cd(context);
        if (m23583cd % i == 0) {
            C11137y.m23569l(context, 1);
        } else {
            C11137y.m23569l(context, m23583cd + 1);
        }
    }
}
