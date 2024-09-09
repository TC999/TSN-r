package com.bytedance.sdk.openadsdk.ev.c;

import com.bytedance.sdk.component.c.s;
import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<xk> f35849c;

    public r(xk xkVar) {
        this.f35849c = new WeakReference<>(xkVar);
    }

    public static void c(s sVar, xk xkVar) {
        sVar.c("startVideoTransform", (com.bytedance.sdk.component.c.ux<?, ?>) new r(xkVar));
    }

    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        xk xkVar;
        JSONObject optJSONObject;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<xk> weakReference = this.f35849c;
        if (weakReference == null || weakReference.get() == null || jSONObject == null || (xkVar = this.f35849c.get()) == null || (optJSONObject = jSONObject.optJSONObject("videoInfo")) == null) {
            return jSONObject2;
        }
        xkVar.c((float) optJSONObject.optDouble("toX"), (float) optJSONObject.optDouble("toY"), (float) optJSONObject.optDouble("pivotX"), (float) optJSONObject.optDouble("pivotY"), jSONObject.optInt("duration"));
        return jSONObject2;
    }
}
