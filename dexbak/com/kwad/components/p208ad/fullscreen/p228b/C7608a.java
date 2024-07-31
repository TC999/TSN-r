package com.kwad.components.p208ad.fullscreen.p228b;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.components.p208ad.fullscreen.p227a.C7606b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10484b;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.fullscreen.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7608a {
    /* renamed from: F */
    public static void m32792F(Context context) {
        C7609b m32791G = m32791G(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (m32791G == null) {
            m32791G = new C7609b(currentTimeMillis, 1);
        } else if (!m32791G.m32788f(currentTimeMillis)) {
            m32791G.f25858gM = currentTimeMillis;
            m32791G.f25859gN = 1;
        } else {
            m32791G.f25859gN++;
        }
        m32790a(context, m32791G);
    }

    @Nullable
    /* renamed from: G */
    private static C7609b m32791G(Context context) {
        if (context == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).getString("key_local_info", null));
            C7609b c7609b = new C7609b();
            c7609b.parseJson(jSONObject);
            return c7609b;
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m32789a(Context context, AdTemplate adTemplate) {
        C7609b m32791G = m32791G(context);
        return (m32791G == null || !m32791G.m32787w(C7606b.m32795bO())) && C10484b.m25709dg(adTemplate);
    }

    /* renamed from: a */
    private static void m32790a(Context context, C7609b c7609b) {
        if (context != null && c7609b != null) {
            context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).edit().putString("key_local_info", c7609b.toJson().toString()).apply();
            return;
        }
        C10331c.m26254d("FullScreenLocalHelper", "saveFullScreenLocalInfo illegal arguments.");
    }
}
