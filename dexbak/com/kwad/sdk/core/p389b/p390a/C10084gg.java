package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.feed.monitor.FeedPageInfo;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.gg */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10084gg implements InterfaceC10273d<FeedPageInfo.C7599a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(FeedPageInfo.C7599a c7599a, JSONObject jSONObject) {
        m26920a(c7599a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(FeedPageInfo.C7599a c7599a, JSONObject jSONObject) {
        return m26919b(c7599a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26920a(FeedPageInfo.C7599a c7599a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c7599a.materialType = jSONObject.optInt("material_type");
        c7599a.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(c7599a.materialUrl)) {
            c7599a.materialUrl = "";
        }
        c7599a.creativeId = jSONObject.optLong(CampaignEx.JSON_KEY_CREATIVE_ID);
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26919b(FeedPageInfo.C7599a c7599a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c7599a.materialType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "material_type", i);
        }
        String str = c7599a.materialUrl;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "material_url", c7599a.materialUrl);
        }
        long j = c7599a.creativeId;
        if (j != 0) {
            C11126t.putValue(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, j);
        }
        return jSONObject;
    }
}
