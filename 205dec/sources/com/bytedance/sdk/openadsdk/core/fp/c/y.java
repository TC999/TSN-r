package com.bytedance.sdk.openadsdk.core.fp.c;

import com.bytedance.sdk.openadsdk.core.widget.ev;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class y extends com.bytedance.sdk.component.c.ux<JSONObject, JSONObject> {

    /* renamed from: c  reason: collision with root package name */
    private ev.c f33590c;

    public y(ev.c cVar) {
        this.f33590c = cVar;
    }

    public JSONObject xv() {
        return new JSONObject();
    }

    public static void c(com.bytedance.sdk.component.c.s sVar, ev.c cVar) {
        sVar.c("UgenDownloadDialogInteraction", (com.bytedance.sdk.component.c.ux<?, ?>) new y(cVar));
    }

    @Override // com.bytedance.sdk.component.c.ux
    public JSONObject c(JSONObject jSONObject, com.bytedance.sdk.component.c.f fVar) throws Exception {
        c(jSONObject);
        return xv();
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject == null || this.f33590c == null) {
            return;
        }
        int optInt = jSONObject.optInt("InteractionType");
        if (optInt == 1) {
            this.f33590c.xv(null);
        } else if (optInt == 2) {
            this.f33590c.c(null);
        } else if (optInt == 3) {
            this.f33590c.c();
        } else if (optInt == 4) {
            this.f33590c.w(null);
        } else if (optInt != 5) {
        } else {
            this.f33590c.sr(null);
        }
    }
}
