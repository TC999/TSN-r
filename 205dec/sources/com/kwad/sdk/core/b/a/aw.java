package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class aw implements com.kwad.sdk.core.d<AdStyleInfo.PlayEndInfo.AdWebCardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        a2(adWebCardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        return b2(adWebCardInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        adWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        adWebCardInfo.cardUrl = jSONObject.optString("cardUrl");
        if (JSONObject.NULL.toString().equals(adWebCardInfo.cardUrl)) {
            adWebCardInfo.cardUrl = "";
        }
        adWebCardInfo.cardData = jSONObject.optString("cardData");
        if (JSONObject.NULL.toString().equals(adWebCardInfo.cardData)) {
            adWebCardInfo.cardData = "";
        }
        adWebCardInfo.cardShowPlayCount = jSONObject.optInt("cardShowPlayCount");
        adWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
        adWebCardInfo.cardDelayTime = jSONObject.optLong("cardDelayTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = adWebCardInfo.typeLandscape;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "typeLandscape", j4);
        }
        long j5 = adWebCardInfo.typePortrait;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "typePortrait", j5);
        }
        String str = adWebCardInfo.cardUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardUrl", adWebCardInfo.cardUrl);
        }
        String str2 = adWebCardInfo.cardData;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardData", adWebCardInfo.cardData);
        }
        int i4 = adWebCardInfo.cardShowPlayCount;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardShowPlayCount", i4);
        }
        long j6 = adWebCardInfo.cardShowTime;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardShowTime", j6);
        }
        long j7 = adWebCardInfo.cardDelayTime;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardDelayTime", j7);
        }
        return jSONObject;
    }
}
