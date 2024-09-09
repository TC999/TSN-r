package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ap implements com.kwad.sdk.core.d<AdInfo.AdStyleConfInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        a2(adStyleConfInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        return b2(adStyleConfInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
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
    private static JSONObject b2(AdInfo.AdStyleConfInfo adStyleConfInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "fullScreenSkipShowTime", adStyleConfInfo.fullScreenSkipShowTime);
        com.kwad.sdk.utils.t.putValue(jSONObject, "rewardSkipConfirmSwitch", adStyleConfInfo.rewardSkipConfirmSwitch);
        long j4 = adStyleConfInfo.closeDelaySeconds;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeDelaySeconds", j4);
        }
        long j5 = adStyleConfInfo.playableCloseSeconds;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playableCloseSeconds", j5);
        }
        boolean z3 = adStyleConfInfo.rewardVideoInteractSwitch;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rewardVideoInteractSwitch", z3);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "adShowVideoH5Info", adStyleConfInfo.adShowVideoH5Info);
        boolean z4 = adStyleConfInfo.adPushSwitch;
        if (z4) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adPushSwitch", z4);
        }
        int i4 = adStyleConfInfo.adPushShowAfterTime;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adPushShowAfterTime", i4);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "adPushIntervalTime", adStyleConfInfo.adPushIntervalTime);
        com.kwad.sdk.utils.t.a(jSONObject, "nativeAdInfo", adStyleConfInfo.nativeAdInfo);
        boolean z5 = adStyleConfInfo.useNativeForOuterLiveAd;
        if (z5) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "useNativeForOuterLiveAd", z5);
        }
        int i5 = adStyleConfInfo.adPushDownloadJumpType;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adPushDownloadJumpType", i5);
        }
        int i6 = adStyleConfInfo.actionBarType;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "actionBarType", i6);
        }
        int i7 = adStyleConfInfo.endCardType;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "endCardType", i7);
        }
        int i8 = adStyleConfInfo.confirmCardType;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "confirmCardType", i8);
        }
        int i9 = adStyleConfInfo.innerAdType;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "innerAdType", i9);
        }
        return jSONObject;
    }
}
