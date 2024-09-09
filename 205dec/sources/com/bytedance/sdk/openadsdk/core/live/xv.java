package com.bytedance.sdk.openadsdk.core.live;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.live.core.ITTLiveHostAction;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements ITTLiveHostAction {
    @Override // com.bytedance.sdk.openadsdk.live.core.ITTLiveHostAction
    public void logEvent(boolean z3, String str, String str2, Map<String, String> map) {
        final JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (!jSONObject.has(entry.getKey())) {
                            jSONObject.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        new c.C0472c().c(str).w(str2).xv("umeng").ux(jSONObject.optString("value")).sr(jSONObject.optString("log_extra")).c(new com.bytedance.sdk.openadsdk.ux.c.c() { // from class: com.bytedance.sdk.openadsdk.core.live.xv.1
            @Override // com.bytedance.sdk.openadsdk.ux.c.c
            public void c(JSONObject jSONObject2) throws JSONException {
                if (!TextUtils.isEmpty(jSONObject.optString("ad_extra_data"))) {
                    jSONObject2.put("ad_extra_data", jSONObject.optString("ad_extra_data"));
                }
                if (!TextUtils.isEmpty(jSONObject.optString("is_other_channel"))) {
                    jSONObject2.put("is_other_channel", jSONObject.optString("is_other_channel"));
                }
                if (jSONObject2.has("is_ad_event")) {
                    return;
                }
                jSONObject2.putOpt("is_ad_event", "1");
            }
        });
    }
}
