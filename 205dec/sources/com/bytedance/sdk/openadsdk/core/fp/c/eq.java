package com.bytedance.sdk.openadsdk.core.fp.c;

import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class eq extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<xk> f33542c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.u.me f33543w;

    public eq(xk xkVar, com.bytedance.sdk.openadsdk.core.u.me meVar) {
        this.f33542c = new WeakReference<>(xkVar);
        this.f33543w = meVar;
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, xk xkVar, com.bytedance.sdk.openadsdk.core.u.me meVar) {
        sVar.c("uploadPlayableSignal", (com.bytedance.sdk.component.c.ux<?, ?>) new eq(xkVar, meVar));
    }

    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<xk> weakReference = this.f33542c;
        if (weakReference != null && weakReference.get() != null) {
            com.bytedance.sdk.openadsdk.core.ls.c().c(this.f33543w, jSONObject);
        }
        return jSONObject2;
    }
}
