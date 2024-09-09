package com.kwad.sdk.core.webview.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b implements com.kwad.sdk.core.b {
    public String aEC;
    public String aED;
    public String data;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.aEC = jSONObject.optString("action");
        this.data = jSONObject.optString("data");
        this.aED = jSONObject.optString("callback");
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "action", this.aEC);
        t.putValue(jSONObject, "data", this.data);
        t.putValue(jSONObject, "callback", this.aED);
        return jSONObject;
    }
}
