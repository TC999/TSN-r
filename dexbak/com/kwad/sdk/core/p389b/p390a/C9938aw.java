package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.aw */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9938aw implements InterfaceC10273d<AdStyleInfo.PlayEndInfo.AdWebCardInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        m27198a(adWebCardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        return m27197b(adWebCardInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27198a(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
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
    private static JSONObject m27197b(AdStyleInfo.PlayEndInfo.AdWebCardInfo adWebCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = adWebCardInfo.typeLandscape;
        if (j != 0) {
            C11126t.putValue(jSONObject, "typeLandscape", j);
        }
        long j2 = adWebCardInfo.typePortrait;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "typePortrait", j2);
        }
        String str = adWebCardInfo.cardUrl;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "cardUrl", adWebCardInfo.cardUrl);
        }
        String str2 = adWebCardInfo.cardData;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "cardData", adWebCardInfo.cardData);
        }
        int i = adWebCardInfo.cardShowPlayCount;
        if (i != 0) {
            C11126t.putValue(jSONObject, "cardShowPlayCount", i);
        }
        long j3 = adWebCardInfo.cardShowTime;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "cardShowTime", j3);
        }
        long j4 = adWebCardInfo.cardDelayTime;
        if (j4 != 0) {
            C11126t.putValue(jSONObject, "cardDelayTime", j4);
        }
        return jSONObject;
    }
}
