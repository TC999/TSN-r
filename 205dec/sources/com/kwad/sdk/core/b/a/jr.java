package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.s;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class jr implements com.kwad.sdk.core.d<s.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(s.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(s.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(s.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.key = jSONObject.optString(DomainCampaignEx.LOOPBACK_KEY);
        if (JSONObject.NULL.toString().equals(aVar.key)) {
            aVar.key = "";
        }
        aVar.value = jSONObject.optString("value");
        if (JSONObject.NULL.toString().equals(aVar.value)) {
            aVar.value = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(s.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.key;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, DomainCampaignEx.LOOPBACK_KEY, aVar.key);
        }
        String str2 = aVar.value;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "value", aVar.value);
        }
        return jSONObject;
    }
}
