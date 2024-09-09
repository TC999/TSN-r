package com.kwad.sdk.core.b.a;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class eg implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.b.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.b.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.b.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.ranger.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.key = jSONObject.optString(DomainCampaignEx.LOOPBACK_KEY);
        if (JSONObject.NULL.toString().equals(aVar.key)) {
            aVar.key = "";
        }
        aVar.value = jSONObject.optInt("value");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.ranger.b.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.key;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, DomainCampaignEx.LOOPBACK_KEY, aVar.key);
        }
        int i4 = aVar.value;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "value", i4);
        }
        return jSONObject;
    }
}
