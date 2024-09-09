package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.request.model.StatusInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class jq implements com.kwad.sdk.core.d<StatusInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(StatusInfo statusInfo, JSONObject jSONObject) {
        a2(statusInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(StatusInfo statusInfo, JSONObject jSONObject) {
        return b2(statusInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        statusInfo.azK = jSONObject.optInt("personalRecommend");
        statusInfo.azL = jSONObject.optInt("programmaticRecommend");
        StatusInfo.SplashAdInfo splashAdInfo = new StatusInfo.SplashAdInfo();
        statusInfo.azM = splashAdInfo;
        splashAdInfo.parseJson(jSONObject.optJSONObject("splashAdInfo"));
        StatusInfo.NativeAdRequestInfo nativeAdRequestInfo = new StatusInfo.NativeAdRequestInfo();
        statusInfo.azN = nativeAdRequestInfo;
        nativeAdRequestInfo.parseJson(jSONObject.optJSONObject("nativeAdInfo"));
        statusInfo.azO = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("taskStats");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                com.kwad.sdk.core.request.model.f fVar = new com.kwad.sdk.core.request.model.f();
                fVar.parseJson(optJSONArray.optJSONObject(i4));
                statusInfo.azO.add(fVar);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(StatusInfo statusInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = statusInfo.azK;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "personalRecommend", i4);
        }
        int i5 = statusInfo.azL;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "programmaticRecommend", i5);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "splashAdInfo", statusInfo.azM);
        com.kwad.sdk.utils.t.a(jSONObject, "nativeAdInfo", statusInfo.azN);
        com.kwad.sdk.utils.t.putValue(jSONObject, "taskStats", statusInfo.azO);
        return jSONObject;
    }
}
