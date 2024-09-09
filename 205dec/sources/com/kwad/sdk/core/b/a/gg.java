package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class gg implements com.kwad.sdk.core.d<FeedPageInfo.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedPageInfo.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedPageInfo.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(FeedPageInfo.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.materialType = jSONObject.optInt("material_type");
        aVar.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(aVar.materialUrl)) {
            aVar.materialUrl = "";
        }
        aVar.creativeId = jSONObject.optLong(CampaignEx.JSON_KEY_CREATIVE_ID);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(FeedPageInfo.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = aVar.materialType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_type", i4);
        }
        String str = aVar.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_url", aVar.materialUrl);
        }
        long j4 = aVar.creativeId;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, j4);
        }
        return jSONObject;
    }
}
