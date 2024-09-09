package com.bytedance.msdk.f;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {
    public static JSONObject c() {
        Map<String, com.bytedance.msdk.adapter.c.xv> w3 = com.bytedance.msdk.sr.w.w.c().w();
        if (w3 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, com.bytedance.msdk.adapter.c.xv> entry : w3.entrySet()) {
            if (entry.getKey() != null) {
                String[] split = entry.getKey().split("\\.");
                if (split.length >= 5) {
                    String str = split[4];
                    try {
                        jSONObject.put(str + "Adapter", entry.getValue().c());
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }
}
