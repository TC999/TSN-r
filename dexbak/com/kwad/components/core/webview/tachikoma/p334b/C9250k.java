package com.kwad.components.core.webview.tachikoma.p334b;

import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.tachikoma.b.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9250k extends C10482a {
    public int aak;
    public int aal = -1;
    public int aam;

    @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, "insertScreenAdShowStrategy", this.aak);
        C11126t.putValue(jSONObject, "isAutoShow", this.aam);
        int i = this.aal;
        if (i != -1) {
            C11126t.putValue(jSONObject, "triggerType", i);
        }
        return jSONObject;
    }
}
