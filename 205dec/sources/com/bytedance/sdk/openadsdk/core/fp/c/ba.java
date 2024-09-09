package com.bytedance.sdk.openadsdk.core.fp.c;

import com.bytedance.sdk.openadsdk.core.xk;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ba extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private xk f33535c;

    public ba(xk xkVar) {
        this.f33535c = xkVar;
    }

    public JSONObject xv() {
        JSONObject jSONObject = new JSONObject();
        xk xkVar = this.f33535c;
        if (xkVar == null) {
            try {
                jSONObject.put("code", -1);
                jSONObject.put("codeMsg", "JsObject is null");
                return jSONObject;
            } catch (JSONException e4) {
                throw new RuntimeException(e4);
            }
        }
        return xkVar.k();
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, xk xkVar) {
        sVar.c("ShowUgenDownloadDialog", (com.bytedance.sdk.component.c.ux<?, ?>) new ba(xkVar));
    }

    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        return xv();
    }
}
