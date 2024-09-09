package com.bytedance.sdk.openadsdk.core.eq;

import android.util.Pair;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class wx extends com.bytedance.sdk.component.ev.w.sr {
    public wx(com.bytedance.sdk.component.w.c.a aVar) {
        super(aVar);
    }

    public void c(JSONObject jSONObject, String str) {
        Object obj;
        Pair<Integer, ?> c4 = com.bytedance.sdk.openadsdk.core.xv.r.c().c(jSONObject.toString(), str);
        if (c4 == null || (obj = c4.first) == null) {
            return;
        }
        if (((Integer) obj).intValue() == 4) {
            c("application/octet-stream", (byte[]) c4.second);
            c(true);
            w("x-pglcypher", String.valueOf(c4.first));
            return;
        }
        c((JSONObject) c4.second);
    }

    public void w(JSONObject jSONObject, String str) {
        if (com.bytedance.sdk.openadsdk.core.ls.w().be()) {
            c(jSONObject, str);
        } else {
            xv(com.bytedance.sdk.component.utils.c.c(jSONObject).toString());
        }
    }
}
