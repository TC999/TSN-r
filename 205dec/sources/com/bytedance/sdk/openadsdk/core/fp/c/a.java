package com.bytedance.sdk.openadsdk.core.fp.c;

import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<xk> f33534c;

    public a(xk xkVar) {
        this.f33534c = new WeakReference<>(xkVar);
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, xk xkVar) {
        sVar.c("getPlayTimeCurrent", (com.bytedance.sdk.component.c.ux<?, ?>) new a(xkVar));
    }

    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<xk> weakReference = this.f33534c;
        if (weakReference != null && weakReference.get() != null) {
            xk xkVar = this.f33534c.get();
            jSONObject2.put("currentTime", xkVar != null ? xkVar.me() : 0);
        }
        return jSONObject2;
    }
}
