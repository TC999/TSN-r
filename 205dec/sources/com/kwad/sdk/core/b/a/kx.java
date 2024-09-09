package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.model.WebCloseStatus;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class kx implements com.kwad.sdk.core.d<WebCloseStatus> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        a2(webCloseStatus, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        return b2(webCloseStatus, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        webCloseStatus.interactSuccess = jSONObject.optBoolean("interactSuccess");
        webCloseStatus.closeType = jSONObject.optInt("closeType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z3 = webCloseStatus.interactSuccess;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "interactSuccess", z3);
        }
        int i4 = webCloseStatus.closeType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeType", i4);
        }
        return jSONObject;
    }
}
