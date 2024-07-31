package com.kwad.sdk.core.p389b.p390a;

import com.amap.api.maps.model.amap3dmodeltile.AMap3DTileBuildType;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10212l implements InterfaceC10273d<AdInfo.AdConversionInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        m26664a(adConversionInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        return m26663b(adConversionInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26664a(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adConversionInfo.h5Url = jSONObject.optString("h5Url");
        if (JSONObject.NULL.toString().equals(adConversionInfo.h5Url)) {
            adConversionInfo.h5Url = "";
        }
        adConversionInfo.h5Type = jSONObject.optInt("h5Type");
        adConversionInfo.deeplinkUrl = jSONObject.optString("deeplinkUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.deeplinkUrl)) {
            adConversionInfo.deeplinkUrl = "";
        }
        adConversionInfo.deeplinkConf = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("deeplinkConf");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo = new AdInfo.AdConversionInfo.DeeplinkItemInfo();
                deeplinkItemInfo.parseJson(optJSONArray.optJSONObject(i));
                adConversionInfo.deeplinkConf.add(deeplinkItemInfo);
            }
        }
        adConversionInfo.deeplinkExtra = jSONObject.optString("deeplinkExtra");
        if (JSONObject.NULL.toString().equals(adConversionInfo.deeplinkExtra)) {
            adConversionInfo.deeplinkExtra = "";
        }
        adConversionInfo.appSecondConfirmationSwitch = jSONObject.optBoolean("appSecondConfirmationSwitch");
        adConversionInfo.h5SecondConfirmationSwitch = jSONObject.optBoolean("h5SecondConfirmationSwitch");
        adConversionInfo.appDownloadUrl = jSONObject.optString("appDownloadUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.appDownloadUrl)) {
            adConversionInfo.appDownloadUrl = "";
        }
        adConversionInfo.marketUrl = jSONObject.optString("marketUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.marketUrl)) {
            adConversionInfo.marketUrl = "";
        }
        adConversionInfo.supportThirdDownload = jSONObject.optInt("supportThirdDownload");
        adConversionInfo.retryH5TimeStep = jSONObject.optInt("retryH5TimeStep", new Integer("2000").intValue());
        adConversionInfo.playableUrl = jSONObject.optString("playableUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.playableUrl)) {
            adConversionInfo.playableUrl = "";
        }
        AdInfo.PlayableStyleInfo playableStyleInfo = new AdInfo.PlayableStyleInfo();
        adConversionInfo.playableStyleInfo = playableStyleInfo;
        playableStyleInfo.parseJson(jSONObject.optJSONObject("playableStyleInfo"));
        adConversionInfo.liveServiceToken = jSONObject.optString("liveServiceToken");
        if (JSONObject.NULL.toString().equals(adConversionInfo.liveServiceToken)) {
            adConversionInfo.liveServiceToken = "";
        }
        adConversionInfo.liveVisitorId = jSONObject.optLong("liveVisitorId");
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = new AdInfo.SmallAppJumpInfo();
        adConversionInfo.smallAppJumpInfo = smallAppJumpInfo;
        smallAppJumpInfo.parseJson(jSONObject.optJSONObject("smallAppJumpInfo"));
        adConversionInfo.webUriSourceType = jSONObject.optInt("webUriSourceType");
        adConversionInfo.callbackUrl = jSONObject.optString("callbackUrl");
        if (JSONObject.NULL.toString().equals(adConversionInfo.callbackUrl)) {
            adConversionInfo.callbackUrl = "";
        }
        adConversionInfo.callbackUrlInfo = jSONObject.optString("callbackUrlInfo");
        if (JSONObject.NULL.toString().equals(adConversionInfo.callbackUrlInfo)) {
            adConversionInfo.callbackUrlInfo = "";
        }
        adConversionInfo.blockCallbackIfSpam = jSONObject.optBoolean("blockCallbackIfSpam");
        adConversionInfo.needDeeplinkReplaceAdapta = jSONObject.optBoolean("needDeeplinkReplaceAdapta");
        adConversionInfo.h5DeeplinkLimitedTimeMs = jSONObject.optInt("h5DeeplinkLimitedTimeMs", new Integer("0").intValue());
        adConversionInfo.playableDeeplinkLimitedTimeMs = jSONObject.optInt("playableDeeplinkLimitedTimeMs", new Integer("0").intValue());
        adConversionInfo.isSupportKeepPlaying = jSONObject.optBoolean("isSupportKeepPlaying");
        adConversionInfo.keepPlayingBackOffTime = jSONObject.optLong("keepPlayingBackOffTime", new Long(AMap3DTileBuildType.HOUSING).longValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26663b(AdInfo.AdConversionInfo adConversionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adConversionInfo.h5Url;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "h5Url", adConversionInfo.h5Url);
        }
        int i = adConversionInfo.h5Type;
        if (i != 0) {
            C11126t.putValue(jSONObject, "h5Type", i);
        }
        String str2 = adConversionInfo.deeplinkUrl;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "deeplinkUrl", adConversionInfo.deeplinkUrl);
        }
        C11126t.putValue(jSONObject, "deeplinkConf", adConversionInfo.deeplinkConf);
        String str3 = adConversionInfo.deeplinkExtra;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "deeplinkExtra", adConversionInfo.deeplinkExtra);
        }
        boolean z = adConversionInfo.appSecondConfirmationSwitch;
        if (z) {
            C11126t.putValue(jSONObject, "appSecondConfirmationSwitch", z);
        }
        boolean z2 = adConversionInfo.h5SecondConfirmationSwitch;
        if (z2) {
            C11126t.putValue(jSONObject, "h5SecondConfirmationSwitch", z2);
        }
        String str4 = adConversionInfo.appDownloadUrl;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "appDownloadUrl", adConversionInfo.appDownloadUrl);
        }
        String str5 = adConversionInfo.marketUrl;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "marketUrl", adConversionInfo.marketUrl);
        }
        int i2 = adConversionInfo.supportThirdDownload;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "supportThirdDownload", i2);
        }
        C11126t.putValue(jSONObject, "retryH5TimeStep", adConversionInfo.retryH5TimeStep);
        String str6 = adConversionInfo.playableUrl;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "playableUrl", adConversionInfo.playableUrl);
        }
        C11126t.m23678a(jSONObject, "playableStyleInfo", adConversionInfo.playableStyleInfo);
        String str7 = adConversionInfo.liveServiceToken;
        if (str7 != null && !str7.equals("")) {
            C11126t.putValue(jSONObject, "liveServiceToken", adConversionInfo.liveServiceToken);
        }
        long j = adConversionInfo.liveVisitorId;
        if (j != 0) {
            C11126t.putValue(jSONObject, "liveVisitorId", j);
        }
        C11126t.m23678a(jSONObject, "smallAppJumpInfo", adConversionInfo.smallAppJumpInfo);
        int i3 = adConversionInfo.webUriSourceType;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "webUriSourceType", i3);
        }
        String str8 = adConversionInfo.callbackUrl;
        if (str8 != null && !str8.equals("")) {
            C11126t.putValue(jSONObject, "callbackUrl", adConversionInfo.callbackUrl);
        }
        String str9 = adConversionInfo.callbackUrlInfo;
        if (str9 != null && !str9.equals("")) {
            C11126t.putValue(jSONObject, "callbackUrlInfo", adConversionInfo.callbackUrlInfo);
        }
        boolean z3 = adConversionInfo.blockCallbackIfSpam;
        if (z3) {
            C11126t.putValue(jSONObject, "blockCallbackIfSpam", z3);
        }
        boolean z4 = adConversionInfo.needDeeplinkReplaceAdapta;
        if (z4) {
            C11126t.putValue(jSONObject, "needDeeplinkReplaceAdapta", z4);
        }
        C11126t.putValue(jSONObject, "h5DeeplinkLimitedTimeMs", adConversionInfo.h5DeeplinkLimitedTimeMs);
        C11126t.putValue(jSONObject, "playableDeeplinkLimitedTimeMs", adConversionInfo.playableDeeplinkLimitedTimeMs);
        boolean z5 = adConversionInfo.isSupportKeepPlaying;
        if (z5) {
            C11126t.putValue(jSONObject, "isSupportKeepPlaying", z5);
        }
        C11126t.putValue(jSONObject, "keepPlayingBackOffTime", adConversionInfo.keepPlayingBackOffTime);
        return jSONObject;
    }
}
