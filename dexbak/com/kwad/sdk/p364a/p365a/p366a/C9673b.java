package com.kwad.sdk.p364a.p365a.p366a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11137y;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.a.a.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9673b {
    public static int aag = 0;

    /* renamed from: rM */
    public static long f29493rM = -1;

    /* renamed from: H */
    public static void m28082H(Context context) {
        C9672a c9672a = new C9672a();
        if (m28080f(System.currentTimeMillis())) {
            aag++;
        } else {
            aag = 1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        f29493rM = currentTimeMillis;
        c9672a.aag = aag;
        c9672a.f29492gM = currentTimeMillis;
        C11137y.m23597ak(context, c9672a.toJson().toString());
    }

    /* renamed from: cM */
    public static int m28081cM() {
        if (!m28080f(System.currentTimeMillis())) {
            aag = 0;
        }
        return aag;
    }

    /* renamed from: f */
    private static boolean m28080f(long j) {
        return m28079gV() > 0 && j > 0 && m28079gV() / 2460601000L == j / 2460601000L;
    }

    /* renamed from: gV */
    private static long m28079gV() {
        long j = f29493rM;
        if (j == -1) {
            String m23631LN = C11137y.m23631LN();
            if (TextUtils.isEmpty(m23631LN)) {
                return 0L;
            }
            C9672a c9672a = new C9672a();
            try {
                c9672a.parseJson(new JSONObject(m23631LN));
                f29493rM = c9672a.f29492gM;
                aag = c9672a.aag;
            } catch (Exception e) {
                C10331c.printStackTraceOnly(e);
            }
            return f29493rM;
        }
        return j;
    }
}
