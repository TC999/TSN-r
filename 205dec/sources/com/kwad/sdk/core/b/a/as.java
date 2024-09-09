package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class as implements com.kwad.sdk.core.d<AdInfo.AdTrackInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        a2(adTrackInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        return b2(adTrackInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTrackInfo.type = jSONObject.optInt("type");
        adTrackInfo.urls = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("url");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                adTrackInfo.urls.add((String) optJSONArray.opt(i4));
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = adTrackInfo.type;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i4);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "url", adTrackInfo.urls);
        return jSONObject;
    }
}
