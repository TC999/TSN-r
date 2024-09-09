package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class cv implements com.kwad.sdk.core.d<AdInfo.AdConversionInfo.DeeplinkItemInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        a2(deeplinkItemInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        return b2(deeplinkItemInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        deeplinkItemInfo.sceneConf = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("sceneConf");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                deeplinkItemInfo.sceneConf.add((Integer) optJSONArray.opt(i4));
            }
        }
        deeplinkItemInfo.areaConf = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("areaConf");
        if (optJSONArray2 != null) {
            for (int i5 = 0; i5 < optJSONArray2.length(); i5++) {
                deeplinkItemInfo.areaConf.add((Integer) optJSONArray2.opt(i5));
            }
        }
        deeplinkItemInfo.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(deeplinkItemInfo.url)) {
            deeplinkItemInfo.url = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "sceneConf", deeplinkItemInfo.sceneConf);
        com.kwad.sdk.utils.t.putValue(jSONObject, "areaConf", deeplinkItemInfo.areaConf);
        String str = deeplinkItemInfo.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "url", deeplinkItemInfo.url);
        }
        return jSONObject;
    }
}
