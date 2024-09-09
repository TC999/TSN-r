package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class al implements com.kwad.sdk.core.d<AdInfo.AdRewardInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        a2(adRewardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        return b2(adRewardInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
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
    private static JSONObject b2(AdInfo.AdRewardInfo adRewardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "skipShowTime", adRewardInfo.skipShowTime);
        com.kwad.sdk.utils.t.putValue(jSONObject, "rewardTime", adRewardInfo.rewardTime);
        int i4 = adRewardInfo.showLandingPage;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showLandingPage", i4);
        }
        boolean z3 = adRewardInfo.rewardVideoEndCardSwitch;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rewardVideoEndCardSwitch", z3);
        }
        boolean z4 = adRewardInfo.recommendAggregateSwitch;
        if (z4) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "recommendAggregateSwitch", z4);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "callBackStrategyInfo", adRewardInfo.callBackStrategyInfo);
        return jSONObject;
    }
}
