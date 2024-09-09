package com.bytedance.sdk.openadsdk.core.bk;

import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.q.ux;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {
    public static void c(String str, long j4) {
        JSONObject w3 = w(str, j4);
        com.bytedance.sdk.component.ev.w.sr w4 = ux.c().w().w();
        w4.c(wv.ev("/api/ad/union/sdk/stats/"));
        w4.xv(w3.toString());
        w4.c(new com.bytedance.sdk.component.ev.c.c() { // from class: com.bytedance.sdk.openadsdk.core.bk.xv.1
            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, com.bytedance.sdk.component.ev.w wVar) {
                if (wVar != null) {
                    a.w("FrequentCallEventHelper", Boolean.valueOf(wVar.ev()), wVar.sr());
                } else {
                    a.xv("FrequentCallEventHelper", "NetResponse is null");
                }
            }

            @Override // com.bytedance.sdk.component.ev.c.c
            public void c(com.bytedance.sdk.component.ev.w.xv xvVar, IOException iOException) {
                a.xv("FrequentCallEventHelper", iOException.getMessage());
            }
        });
    }

    private static JSONObject w(String str, long j4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "over_freq");
            jSONObject.put("rit", str);
            jSONObject.put("ad_sdk_version", eq.xv);
            jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, j4);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
