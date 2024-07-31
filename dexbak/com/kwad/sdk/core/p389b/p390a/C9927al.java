package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.al */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9927al implements InterfaceC10273d<AdInfo.AdRewardInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        m27220a(adRewardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        return m27219b(adRewardInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27220a(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adRewardInfo.skipShowTime = jSONObject.optInt("skipShowTime", new Integer("30").intValue());
        adRewardInfo.rewardTime = jSONObject.optInt("rewardTime", new Integer("30").intValue());
        adRewardInfo.showLandingPage = jSONObject.optInt("showLandingPage");
        adRewardInfo.rewardVideoEndCardSwitch = jSONObject.optBoolean("rewardVideoEndCardSwitch");
        adRewardInfo.recommendAggregateSwitch = jSONObject.optBoolean("recommendAggregateSwitch");
        AdInfo.CallBackStrategyInfo callBackStrategyInfo = new AdInfo.CallBackStrategyInfo();
        adRewardInfo.callBackStrategyInfo = callBackStrategyInfo;
        callBackStrategyInfo.parseJson(jSONObject.optJSONObject("callBackStrategyInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27219b(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "skipShowTime", adRewardInfo.skipShowTime);
        C11126t.putValue(jSONObject, "rewardTime", adRewardInfo.rewardTime);
        int i = adRewardInfo.showLandingPage;
        if (i != 0) {
            C11126t.putValue(jSONObject, "showLandingPage", i);
        }
        boolean z = adRewardInfo.rewardVideoEndCardSwitch;
        if (z) {
            C11126t.putValue(jSONObject, "rewardVideoEndCardSwitch", z);
        }
        boolean z2 = adRewardInfo.recommendAggregateSwitch;
        if (z2) {
            C11126t.putValue(jSONObject, "recommendAggregateSwitch", z2);
        }
        C11126t.m23678a(jSONObject, "callBackStrategyInfo", adRewardInfo.callBackStrategyInfo);
        return jSONObject;
    }
}
