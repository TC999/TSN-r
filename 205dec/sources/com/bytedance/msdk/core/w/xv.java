package com.bytedance.msdk.core.w;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {
    public static void c(com.bytedance.msdk.c.ux uxVar, com.bytedance.msdk.api.c.w wVar, Map<String, Object> map) {
        if (com.bytedance.msdk.core.c.w().me()) {
            String u3 = wVar != null ? wVar.u() : null;
            w xk = com.bytedance.msdk.core.c.w().xk();
            if (xk != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("lt_days", Integer.valueOf(xk.c()));
                    jSONObject.putOpt("rule_id", xk.xv(u3));
                } catch (Exception e4) {
                    com.bytedance.msdk.adapter.sr.xv.sr("AdLoadEventManager", "put \u5143\u7d20 \u5f02\u5e38\uff1a" + e4.getMessage());
                }
                try {
                    jSONObject.putOpt("score", Float.valueOf(com.bytedance.msdk.core.w.k().c(u3)));
                } catch (Exception e5) {
                    com.bytedance.msdk.adapter.sr.xv.sr("AdLoadEventManager", "put \u5143\u7d20\u5f02\u5e38\uff1a" + e5.getMessage());
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("dis_c", Integer.valueOf(c.w(u3)));
                    jSONObject2.putOpt("ins_d", Integer.valueOf(c.ux()));
                    jSONObject2.putOpt("act_d", Integer.valueOf(c.w()));
                    jSONObject2.putOpt("act_times", Integer.valueOf(c.sr()));
                    jSONObject.putOpt("active_target", jSONObject2);
                } catch (Exception e6) {
                    com.bytedance.msdk.adapter.sr.xv.sr("AdLoadEventManager", "put \u5143\u7d20\u5f02\u5e38\uff1a" + e6.getMessage());
                }
                if (wVar != null && wVar.yu() != null) {
                    Map<String, Object> yu = wVar.yu();
                    if (yu.containsKey("usePolicy")) {
                        try {
                            jSONObject.putOpt("user_enter", yu.get("usePolicy"));
                        } catch (Exception e7) {
                            com.bytedance.msdk.adapter.sr.xv.sr("AdLoadEventManager", "put \u5143\u7d20\u5f02\u5e38\uff1a" + e7.getMessage());
                        }
                    }
                }
                map.put("dynamic_policy", jSONObject);
            }
        }
    }
}
