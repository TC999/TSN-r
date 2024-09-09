package com.bytedance.sdk.openadsdk.core.fp.c;

import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<xk> f33536c;

    public bk(xk xkVar) {
        this.f33536c = new WeakReference<>(xkVar);
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, xk xkVar) {
        sVar.c("getSendRewardStatus", (com.bytedance.sdk.component.c.ux<?, ?>) new bk(xkVar));
    }

    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        xk xkVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<xk> weakReference = this.f33536c;
        if (weakReference != null && weakReference.get() != null && (xkVar = this.f33536c.get()) != null) {
            jSONObject2.put("isReward", xkVar.sr());
        }
        return jSONObject2;
    }
}
