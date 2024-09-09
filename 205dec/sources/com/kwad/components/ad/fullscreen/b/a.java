package com.kwad.components.ad.fullscreen.b;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public static void F(Context context) {
        b G = G(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (G == null) {
            G = new b(currentTimeMillis, 1);
        } else if (!G.f(currentTimeMillis)) {
            G.gM = currentTimeMillis;
            G.gN = 1;
        } else {
            G.gN++;
        }
        a(context, G);
    }

    @Nullable
    private static b G(Context context) {
        if (context == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).getString("key_local_info", null));
            b bVar = new b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (Exception e4) {
            c.printStackTraceOnly(e4);
            return null;
        }
    }

    public static boolean a(Context context, AdTemplate adTemplate) {
        b G = G(context);
        return (G == null || !G.w(com.kwad.components.ad.fullscreen.a.b.bO())) && com.kwad.sdk.core.response.b.b.dg(adTemplate);
    }

    private static void a(Context context, b bVar) {
        if (context != null && bVar != null) {
            context.getSharedPreferences("ksadsdk_fullscreen_local_ad_count", 0).edit().putString("key_local_info", bVar.toJson().toString()).apply();
            return;
        }
        c.d("FullScreenLocalHelper", "saveFullScreenLocalInfo illegal arguments.");
    }
}
