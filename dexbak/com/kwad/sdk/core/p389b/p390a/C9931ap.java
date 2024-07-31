package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ap */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9931ap implements InterfaceC10273d<AdInfo.AdStyleConfInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        m27212a(adStyleConfInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        return m27211b(adStyleConfInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27212a(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adStyleConfInfo.fullScreenSkipShowTime = jSONObject.optInt("fullScreenSkipShowTime", new Integer("5").intValue());
        adStyleConfInfo.rewardSkipConfirmSwitch = jSONObject.optInt("rewardSkipConfirmSwitch", new Integer("1").intValue());
        adStyleConfInfo.closeDelaySeconds = jSONObject.optLong("closeDelaySeconds");
        adStyleConfInfo.playableCloseSeconds = jSONObject.optLong("playableCloseSeconds");
        adStyleConfInfo.rewardVideoInteractSwitch = jSONObject.optBoolean("rewardVideoInteractSwitch");
        AdInfo.AdShowVideoH5Info adShowVideoH5Info = new AdInfo.AdShowVideoH5Info();
        adStyleConfInfo.adShowVideoH5Info = adShowVideoH5Info;
        adShowVideoH5Info.parseJson(jSONObject.optJSONObject("adShowVideoH5Info"));
        adStyleConfInfo.adPushSwitch = jSONObject.optBoolean("adPushSwitch");
        adStyleConfInfo.adPushShowAfterTime = jSONObject.optInt("adPushShowAfterTime");
        adStyleConfInfo.adPushIntervalTime = jSONObject.optInt("adPushIntervalTime", new Integer("900").intValue());
        AdInfo.NativeAdInfo nativeAdInfo = new AdInfo.NativeAdInfo();
        adStyleConfInfo.nativeAdInfo = nativeAdInfo;
        nativeAdInfo.parseJson(jSONObject.optJSONObject("nativeAdInfo"));
        adStyleConfInfo.useNativeForOuterLiveAd = jSONObject.optBoolean("useNativeForOuterLiveAd");
        adStyleConfInfo.adPushDownloadJumpType = jSONObject.optInt("adPushDownloadJumpType");
        adStyleConfInfo.actionBarType = jSONObject.optInt("actionBarType");
        adStyleConfInfo.endCardType = jSONObject.optInt("endCardType");
        adStyleConfInfo.confirmCardType = jSONObject.optInt("confirmCardType");
        adStyleConfInfo.innerAdType = jSONObject.optInt("innerAdType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27211b(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "fullScreenSkipShowTime", adStyleConfInfo.fullScreenSkipShowTime);
        C11126t.putValue(jSONObject, "rewardSkipConfirmSwitch", adStyleConfInfo.rewardSkipConfirmSwitch);
        long j = adStyleConfInfo.closeDelaySeconds;
        if (j != 0) {
            C11126t.putValue(jSONObject, "closeDelaySeconds", j);
        }
        long j2 = adStyleConfInfo.playableCloseSeconds;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "playableCloseSeconds", j2);
        }
        boolean z = adStyleConfInfo.rewardVideoInteractSwitch;
        if (z) {
            C11126t.putValue(jSONObject, "rewardVideoInteractSwitch", z);
        }
        C11126t.m23678a(jSONObject, "adShowVideoH5Info", adStyleConfInfo.adShowVideoH5Info);
        boolean z2 = adStyleConfInfo.adPushSwitch;
        if (z2) {
            C11126t.putValue(jSONObject, "adPushSwitch", z2);
        }
        int i = adStyleConfInfo.adPushShowAfterTime;
        if (i != 0) {
            C11126t.putValue(jSONObject, "adPushShowAfterTime", i);
        }
        C11126t.putValue(jSONObject, "adPushIntervalTime", adStyleConfInfo.adPushIntervalTime);
        C11126t.m23678a(jSONObject, "nativeAdInfo", adStyleConfInfo.nativeAdInfo);
        boolean z3 = adStyleConfInfo.useNativeForOuterLiveAd;
        if (z3) {
            C11126t.putValue(jSONObject, "useNativeForOuterLiveAd", z3);
        }
        int i2 = adStyleConfInfo.adPushDownloadJumpType;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "adPushDownloadJumpType", i2);
        }
        int i3 = adStyleConfInfo.actionBarType;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "actionBarType", i3);
        }
        int i4 = adStyleConfInfo.endCardType;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "endCardType", i4);
        }
        int i5 = adStyleConfInfo.confirmCardType;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "confirmCardType", i5);
        }
        int i6 = adStyleConfInfo.innerAdType;
        if (i6 != 0) {
            C11126t.putValue(jSONObject, "innerAdType", i6);
        }
        return jSONObject;
    }
}
