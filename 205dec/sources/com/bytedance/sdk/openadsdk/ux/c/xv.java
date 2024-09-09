package com.bytedance.sdk.openadsdk.ux.c;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv implements w {

    /* renamed from: c  reason: collision with root package name */
    w f36306c;

    @Override // com.bytedance.sdk.openadsdk.ux.c.w
    public void c(JSONObject jSONObject) throws JSONException {
        w wVar = this.f36306c;
        if (wVar != null) {
            wVar.c(jSONObject);
        }
        jSONObject.put("event_ts", System.currentTimeMillis());
    }
}
