package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class hp implements com.kwad.sdk.core.d<AdStyleInfo.PlayEndInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayEndInfo playEndInfo, JSONObject jSONObject) {
        a2(playEndInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayEndInfo playEndInfo, JSONObject jSONObject) {
        return b2(playEndInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.PlayEndInfo playEndInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        playEndInfo.type = jSONObject.optInt("type");
        playEndInfo.showLandingPage3 = jSONObject.optInt("showLandingPage3");
        AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo = new AdStyleInfo.PlayEndInfo.AdWebCardInfo();
        playEndInfo.adWebCardInfo = adWebCardInfo;
        adWebCardInfo.parseJson(jSONObject.optJSONObject("adWebCardInfo"));
        AdStyleInfo.PlayEndInfo.EndTopToolBarInfo endTopToolBarInfo = new AdStyleInfo.PlayEndInfo.EndTopToolBarInfo();
        playEndInfo.endTopToolBarInfo = endTopToolBarInfo;
        endTopToolBarInfo.parseJson(jSONObject.optJSONObject("endTopToolBarInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.PlayEndInfo playEndInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = playEndInfo.type;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i4);
        }
        int i5 = playEndInfo.showLandingPage3;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showLandingPage3", i5);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "adWebCardInfo", playEndInfo.adWebCardInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "endTopToolBarInfo", playEndInfo.endTopToolBarInfo);
        return jSONObject;
    }
}
