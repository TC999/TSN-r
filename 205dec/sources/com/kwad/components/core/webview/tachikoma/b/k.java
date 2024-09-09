package com.kwad.components.core.webview.tachikoma.b;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class k extends com.kwad.sdk.core.response.a.a {
    public int aak;
    public int aal = -1;
    public int aam;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.t.putValue(jSONObject, "insertScreenAdShowStrategy", this.aak);
        com.kwad.sdk.utils.t.putValue(jSONObject, "isAutoShow", this.aam);
        int i4 = this.aal;
        if (i4 != -1) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "triggerType", i4);
        }
        return jSONObject;
    }
}
