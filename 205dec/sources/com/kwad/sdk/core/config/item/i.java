package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class i extends b<com.kwad.sdk.core.network.idc.a.b> {
    public i() {
        super("idc", new com.kwad.sdk.core.network.idc.a.b());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(getKey())) != null) {
            com.kwad.sdk.core.network.idc.a.b bVar = new com.kwad.sdk.core.network.idc.a.b();
            bVar.parseJson(optJSONObject);
            setValue(bVar);
            return;
        }
        setValue(CH());
    }
}
