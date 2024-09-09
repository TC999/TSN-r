package com.bytedance.sdk.openadsdk.core.fp.c;

import com.bytedance.sdk.component.c.sr;
import com.bytedance.sdk.openadsdk.core.xk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class n extends com.bytedance.sdk.component.c.sr<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<xk> f33569c;

    public n(xk xkVar) {
        this.f33569c = new WeakReference<>(xkVar);
    }

    @Override // com.bytedance.sdk.component.c.sr
    protected void sr() {
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, final xk xkVar) {
        sVar.c("commonConvert", new sr.w() { // from class: com.bytedance.sdk.openadsdk.core.fp.c.n.1
            @Override // com.bytedance.sdk.component.c.sr.w
            public com.bytedance.sdk.component.c.sr c() {
                return new n(xk.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.c.sr
    public void c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        com.bytedance.sdk.openadsdk.core.ugeno.gd.c fp;
        JSONObject w3;
        if (com.bytedance.sdk.openadsdk.core.k.sr().z()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[JSB-REQ] version: 3 data=");
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            com.bytedance.sdk.component.utils.a.w("SendCommerceLandingPageMeta", sb.toString());
        }
        WeakReference<xk> weakReference = this.f33569c;
        if (weakReference == null) {
            return;
        }
        xk xkVar = weakReference.get();
        if (xkVar == null) {
            xv();
        } else if (jSONObject == null) {
        } else {
            com.bytedance.sdk.openadsdk.core.u.me c4 = com.bytedance.sdk.openadsdk.core.w.c(jSONObject);
            int optInt = jSONObject.optInt("j_live_saas_param_interaction_type", -1);
            if (c4 == null) {
                return;
            }
            if (c4.ue() == null && (fp = c4.fp()) != null && (w3 = fp.w()) != null) {
                c4.c(com.bytedance.sdk.openadsdk.core.u.bk.c(w3));
            }
            xkVar.c(c4, optInt);
        }
    }
}
