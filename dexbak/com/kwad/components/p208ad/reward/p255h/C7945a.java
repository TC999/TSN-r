package com.kwad.components.p208ad.reward.p255h;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11137y;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.h.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7945a {

    /* renamed from: rM */
    public static long f26655rM = -1;

    /* renamed from: rN */
    public static int f26656rN;

    /* renamed from: H */
    public static void m31965H(Context context) {
        C7946b c7946b = new C7946b();
        if (m31963f(System.currentTimeMillis())) {
            f26656rN++;
        } else {
            f26656rN = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        f26655rM = currentTimeMillis;
        c7946b.f26658rO = f26656rN;
        c7946b.f26657gM = currentTimeMillis;
        C11137y.m23606ab(context, c7946b.toJson().toString());
    }

    /* renamed from: cM */
    public static int m31964cM() {
        if (!m31963f(System.currentTimeMillis())) {
            f26656rN = 0;
        }
        return f26656rN;
    }

    /* renamed from: f */
    private static boolean m31963f(long j) {
        return m31962gV() > 0 && j > 0 && m31962gV() / 2460601000L == j / 2460601000L;
    }

    /* renamed from: gV */
    private static long m31962gV() {
        long j = f26655rM;
        if (j == -1) {
            String m23638LG = C11137y.m23638LG();
            if (TextUtils.isEmpty(m23638LG)) {
                return 0L;
            }
            C7946b c7946b = new C7946b();
            try {
                c7946b.parseJson(new JSONObject(m23638LG));
                f26655rM = c7946b.f26657gM;
                f26656rN = c7946b.f26658rO;
            } catch (Exception e) {
                C10331c.printStackTraceOnly(e);
            }
            return f26655rM;
        }
        return j;
    }
}
