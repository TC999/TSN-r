package com.kwad.sdk.core.p389b.p390a;

import com.github.mikephil.charting.utils.Utils;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.an */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9929an implements InterfaceC10273d<AdInfo.AdSplashInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        m27216a(adSplashInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        return m27215b(adSplashInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27216a(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adSplashInfo.logoPosition = jSONObject.optInt("logoPosition", new Integer("1").intValue());
        adSplashInfo.mute = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE, new Integer("1").intValue());
        adSplashInfo.skipType = jSONObject.optInt("skipType");
        adSplashInfo.skipTips = jSONObject.optString("skipTips");
        if (JSONObject.NULL.toString().equals(adSplashInfo.skipTips)) {
            adSplashInfo.skipTips = "";
        }
        adSplashInfo.speakerMuteIconUrl = jSONObject.optString("speakerMuteIconUrl");
        if (JSONObject.NULL.toString().equals(adSplashInfo.speakerMuteIconUrl)) {
            adSplashInfo.speakerMuteIconUrl = "";
        }
        adSplashInfo.speakerIconUrl = jSONObject.optString("speakerIconUrl");
        if (JSONObject.NULL.toString().equals(adSplashInfo.speakerIconUrl)) {
            adSplashInfo.speakerIconUrl = "";
        }
        adSplashInfo.imageDisplaySecond = jSONObject.optInt("imageDisplaySecond", new Integer("5").intValue());
        adSplashInfo.videoDisplaySecond = jSONObject.optInt("videoDisplaySecond", new Integer("5").intValue());
        adSplashInfo.countdownShow = jSONObject.optInt("countdownShow");
        adSplashInfo.fullScreenClickSwitch = jSONObject.optInt("fullScreenClickSwitch");
        adSplashInfo.skipButtonPosition = jSONObject.optInt("skipButtonPosition");
        adSplashInfo.splashShowClickButtonSwitch = jSONObject.optInt("splashShowClickButtonSwitch", new Integer("1").intValue());
        adSplashInfo.skipSecond = jSONObject.optInt("skipSecond");
        adSplashInfo.impressionStatisticalChangeSwitch = jSONObject.optBoolean("impressionStatisticalChangeSwitch");
        adSplashInfo.impressionLimitSize = jSONObject.optDouble("impressionLimitSize");
        AdInfo.CutRuleInfo cutRuleInfo = new AdInfo.CutRuleInfo();
        adSplashInfo.cutRuleInfo = cutRuleInfo;
        cutRuleInfo.parseJson(jSONObject.optJSONObject("cutRuleInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27215b(AdInfo.AdSplashInfo adSplashInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "logoPosition", adSplashInfo.logoPosition);
        C11126t.putValue(jSONObject, CampaignEx.JSON_NATIVE_VIDEO_MUTE, adSplashInfo.mute);
        int i = adSplashInfo.skipType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "skipType", i);
        }
        String str = adSplashInfo.skipTips;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "skipTips", adSplashInfo.skipTips);
        }
        String str2 = adSplashInfo.speakerMuteIconUrl;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "speakerMuteIconUrl", adSplashInfo.speakerMuteIconUrl);
        }
        String str3 = adSplashInfo.speakerIconUrl;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "speakerIconUrl", adSplashInfo.speakerIconUrl);
        }
        C11126t.putValue(jSONObject, "imageDisplaySecond", adSplashInfo.imageDisplaySecond);
        C11126t.putValue(jSONObject, "videoDisplaySecond", adSplashInfo.videoDisplaySecond);
        int i2 = adSplashInfo.countdownShow;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "countdownShow", i2);
        }
        int i3 = adSplashInfo.fullScreenClickSwitch;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "fullScreenClickSwitch", i3);
        }
        int i4 = adSplashInfo.skipButtonPosition;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "skipButtonPosition", i4);
        }
        C11126t.putValue(jSONObject, "splashShowClickButtonSwitch", adSplashInfo.splashShowClickButtonSwitch);
        int i5 = adSplashInfo.skipSecond;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "skipSecond", i5);
        }
        boolean z = adSplashInfo.impressionStatisticalChangeSwitch;
        if (z) {
            C11126t.putValue(jSONObject, "impressionStatisticalChangeSwitch", z);
        }
        double d = adSplashInfo.impressionLimitSize;
        if (d != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "impressionLimitSize", d);
        }
        C11126t.m23678a(jSONObject, "cutRuleInfo", adSplashInfo.cutRuleInfo);
        return jSONObject;
    }
}
