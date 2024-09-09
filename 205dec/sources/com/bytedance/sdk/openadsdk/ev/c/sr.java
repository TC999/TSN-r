package com.bytedance.sdk.openadsdk.ev.c;

import com.bytedance.sdk.component.c.s;
import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<xk> f35850c;

    public sr(xk xkVar) {
        this.f35850c = new WeakReference<>(xkVar);
    }

    public static void c(s sVar, xk xkVar) {
        sVar.c("rewardPlayAgain", (com.bytedance.sdk.component.c.ux<?, ?>) new sr(xkVar));
    }

    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        xk xkVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<xk> weakReference = this.f35850c;
        if (weakReference == null || weakReference.get() == null || (xkVar = this.f35850c.get()) == null) {
            return jSONObject2;
        }
        xkVar.s();
        return jSONObject2;
    }
}
