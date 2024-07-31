package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.aq */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9932aq implements InterfaceC10273d<AdStyleInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        m27210a(adStyleInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        return m27209b(adStyleInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27210a(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdStyleInfo.PlayDetailInfo playDetailInfo = new AdStyleInfo.PlayDetailInfo();
        adStyleInfo.playDetailInfo = playDetailInfo;
        playDetailInfo.parseJson(jSONObject.optJSONObject("playDetailInfo"));
        AdStyleInfo.PlayEndInfo playEndInfo = new AdStyleInfo.PlayEndInfo();
        adStyleInfo.playEndInfo = playEndInfo;
        playEndInfo.parseJson(jSONObject.optJSONObject("playEndInfo"));
        AdStyleInfo.FeedAdInfo feedAdInfo = new AdStyleInfo.FeedAdInfo();
        adStyleInfo.feedAdInfo = feedAdInfo;
        feedAdInfo.parseJson(jSONObject.optJSONObject("feedAdInfo"));
        AdStyleInfo.AdBrowseInfo adBrowseInfo = new AdStyleInfo.AdBrowseInfo();
        adStyleInfo.adBrowseInfo = adBrowseInfo;
        adBrowseInfo.parseJson(jSONObject.optJSONObject("adBrowseInfo"));
        AdStyleInfo.ExtraDisplayInfo extraDisplayInfo = new AdStyleInfo.ExtraDisplayInfo();
        adStyleInfo.extraDisplayInfo = extraDisplayInfo;
        extraDisplayInfo.parseJson(jSONObject.optJSONObject("extraDisplayInfo"));
        adStyleInfo.playableExtraData = jSONObject.optString("playableExtraData");
        if (JSONObject.NULL.toString().equals(adStyleInfo.playableExtraData)) {
            adStyleInfo.playableExtraData = "";
        }
        adStyleInfo.slideClick = jSONObject.optBoolean("slideClick");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27209b(AdStyleInfo adStyleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.m23678a(jSONObject, "playDetailInfo", adStyleInfo.playDetailInfo);
        C11126t.m23678a(jSONObject, "playEndInfo", adStyleInfo.playEndInfo);
        C11126t.m23678a(jSONObject, "feedAdInfo", adStyleInfo.feedAdInfo);
        C11126t.m23678a(jSONObject, "adBrowseInfo", adStyleInfo.adBrowseInfo);
        C11126t.m23678a(jSONObject, "extraDisplayInfo", adStyleInfo.extraDisplayInfo);
        String str = adStyleInfo.playableExtraData;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "playableExtraData", adStyleInfo.playableExtraData);
        }
        boolean z = adStyleInfo.slideClick;
        if (z) {
            C11126t.putValue(jSONObject, "slideClick", z);
        }
        return jSONObject;
    }
}
