package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class cz implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DetailWebCardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        a2(detailWebCardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        return b2(detailWebCardInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        detailWebCardInfo.style = jSONObject.optInt("style");
        detailWebCardInfo.maxTimeOut = jSONObject.optLong("maxTimeOut");
        detailWebCardInfo.typeLandscape = jSONObject.optLong("typeLandscape");
        detailWebCardInfo.typePortrait = jSONObject.optLong("typePortrait");
        detailWebCardInfo.cardUrl = jSONObject.optString("cardUrl");
        if (JSONObject.NULL.toString().equals(detailWebCardInfo.cardUrl)) {
            detailWebCardInfo.cardUrl = "";
        }
        detailWebCardInfo.cardData = jSONObject.optString("cardData");
        if (JSONObject.NULL.toString().equals(detailWebCardInfo.cardData)) {
            detailWebCardInfo.cardData = "";
        }
        detailWebCardInfo.cardShowTime = jSONObject.optLong("cardShowTime");
        detailWebCardInfo.cardType = jSONObject.optInt("cardType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = detailWebCardInfo.style;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "style", i4);
        }
        long j4 = detailWebCardInfo.maxTimeOut;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "maxTimeOut", j4);
        }
        long j5 = detailWebCardInfo.typeLandscape;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "typeLandscape", j5);
        }
        long j6 = detailWebCardInfo.typePortrait;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "typePortrait", j6);
        }
        String str = detailWebCardInfo.cardUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardUrl", detailWebCardInfo.cardUrl);
        }
        String str2 = detailWebCardInfo.cardData;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardData", detailWebCardInfo.cardData);
        }
        long j7 = detailWebCardInfo.cardShowTime;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardShowTime", j7);
        }
        int i5 = detailWebCardInfo.cardType;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardType", i5);
        }
        return jSONObject;
    }
}
