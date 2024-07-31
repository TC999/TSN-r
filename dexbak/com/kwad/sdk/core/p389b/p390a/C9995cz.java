package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.cz */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9995cz implements InterfaceC10273d<AdStyleInfo.PlayDetailInfo.DetailWebCardInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        m27092a(detailWebCardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        return m27091b(detailWebCardInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27092a(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
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
    private static JSONObject m27091b(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = detailWebCardInfo.style;
        if (i != 0) {
            C11126t.putValue(jSONObject, "style", i);
        }
        long j = detailWebCardInfo.maxTimeOut;
        if (j != 0) {
            C11126t.putValue(jSONObject, "maxTimeOut", j);
        }
        long j2 = detailWebCardInfo.typeLandscape;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "typeLandscape", j2);
        }
        long j3 = detailWebCardInfo.typePortrait;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "typePortrait", j3);
        }
        String str = detailWebCardInfo.cardUrl;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "cardUrl", detailWebCardInfo.cardUrl);
        }
        String str2 = detailWebCardInfo.cardData;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "cardData", detailWebCardInfo.cardData);
        }
        long j4 = detailWebCardInfo.cardShowTime;
        if (j4 != 0) {
            C11126t.putValue(jSONObject, "cardShowTime", j4);
        }
        int i2 = detailWebCardInfo.cardType;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "cardType", i2);
        }
        return jSONObject;
    }
}
