package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class i implements com.kwad.sdk.core.d<AdInfo.AdBaseInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        a2(adBaseInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        return b2(adBaseInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBaseInfo.creativeId = jSONObject.optLong("creativeId");
        adBaseInfo.adSourceType = jSONObject.optInt("adSourceType");
        adBaseInfo.liveStreamId = jSONObject.optString("liveStreamId");
        if (JSONObject.NULL.toString().equals(adBaseInfo.liveStreamId)) {
            adBaseInfo.liveStreamId = "";
        }
        adBaseInfo.universeLiveType = jSONObject.optInt("universeLiveType");
        adBaseInfo.viewCount = jSONObject.optLong("viewCount");
        adBaseInfo.sdkExtraData = jSONObject.optString("sdkExtraData");
        if (JSONObject.NULL.toString().equals(adBaseInfo.sdkExtraData)) {
            adBaseInfo.sdkExtraData = "";
        }
        adBaseInfo.adDescription = jSONObject.optString("adDescription");
        if (JSONObject.NULL.toString().equals(adBaseInfo.adDescription)) {
            adBaseInfo.adDescription = "";
        }
        adBaseInfo.installAppLabel = jSONObject.optString("installAppLabel");
        if (JSONObject.NULL.toString().equals(adBaseInfo.installAppLabel)) {
            adBaseInfo.installAppLabel = "";
        }
        adBaseInfo.openAppLabel = jSONObject.optString("openAppLabel");
        if (JSONObject.NULL.toString().equals(adBaseInfo.openAppLabel)) {
            adBaseInfo.openAppLabel = "";
        }
        adBaseInfo.adMarkIcon = jSONObject.optString("adMarkIcon");
        if (JSONObject.NULL.toString().equals(adBaseInfo.adMarkIcon)) {
            adBaseInfo.adMarkIcon = "";
        }
        adBaseInfo.adGrayMarkIcon = jSONObject.optString("adGrayMarkIcon");
        if (JSONObject.NULL.toString().equals(adBaseInfo.adGrayMarkIcon)) {
            adBaseInfo.adGrayMarkIcon = "";
        }
        adBaseInfo.adSourceDescription = jSONObject.optString("adSourceDescription");
        if (JSONObject.NULL.toString().equals(adBaseInfo.adSourceDescription)) {
            adBaseInfo.adSourceDescription = "";
        }
        adBaseInfo.adOperationType = jSONObject.optInt("adOperationType");
        adBaseInfo.adActionDescription = jSONObject.optString("adActionDescription");
        if (JSONObject.NULL.toString().equals(adBaseInfo.adActionDescription)) {
            adBaseInfo.adActionDescription = "";
        }
        adBaseInfo.adActionBarColor = jSONObject.optString("adActionBarColor");
        if (JSONObject.NULL.toString().equals(adBaseInfo.adActionBarColor)) {
            adBaseInfo.adActionBarColor = "";
        }
        adBaseInfo.adShowDuration = jSONObject.optInt("adShowDuration");
        adBaseInfo.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appName)) {
            adBaseInfo.appName = "";
        }
        adBaseInfo.realAppName = jSONObject.optString("realAppName");
        if (JSONObject.NULL.toString().equals(adBaseInfo.realAppName)) {
            adBaseInfo.realAppName = "";
        }
        adBaseInfo.appIconUrl = jSONObject.optString("appIconUrl");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appIconUrl)) {
            adBaseInfo.appIconUrl = "";
        }
        adBaseInfo.appPackageName = jSONObject.optString("appPackageName");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appPackageName)) {
            adBaseInfo.appPackageName = "";
        }
        adBaseInfo.appScore = jSONObject.optInt("appScore");
        adBaseInfo.appDownloadCountDesc = jSONObject.optString("appDownloadCountDesc");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appDownloadCountDesc)) {
            adBaseInfo.appDownloadCountDesc = "";
        }
        adBaseInfo.appCategory = jSONObject.optString("appCategory");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appCategory)) {
            adBaseInfo.appCategory = "";
        }
        adBaseInfo.appVersion = jSONObject.optString("appVersion");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appVersion)) {
            adBaseInfo.appVersion = "";
        }
        adBaseInfo.corporationName = jSONObject.optString("corporationName");
        if (JSONObject.NULL.toString().equals(adBaseInfo.corporationName)) {
            adBaseInfo.corporationName = "";
        }
        adBaseInfo.packageSize = jSONObject.optLong("packageSize");
        adBaseInfo.appImageUrl = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("appImageUrl");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                adBaseInfo.appImageUrl.add((String) optJSONArray.opt(i4));
            }
        }
        AdInfo.MaterialSize materialSize = new AdInfo.MaterialSize();
        adBaseInfo.appImageSize = materialSize;
        materialSize.parseJson(jSONObject.optJSONObject("appImageSize"));
        adBaseInfo.appDescription = jSONObject.optString("appDescription");
        if (JSONObject.NULL.toString().equals(adBaseInfo.appDescription)) {
            adBaseInfo.appDescription = "";
        }
        adBaseInfo.enableSkipAd = jSONObject.optInt("enableSkipAd");
        adBaseInfo.adCacheSwitch = jSONObject.optInt("adCacheSwitch", new Integer("0").intValue());
        adBaseInfo.adCacheSecond = jSONObject.optLong("adCacheSecond", new Long("1800").longValue());
        adBaseInfo.adCacheStrategy = jSONObject.optInt("adCacheStrategy", new Integer("1").intValue());
        adBaseInfo.adCacheSize = jSONObject.optInt("adCacheSize", new Integer("1").intValue());
        adBaseInfo.skipSecond = jSONObject.optInt("skipSecond");
        adBaseInfo.ecpm = jSONObject.optInt("ecpm");
        adBaseInfo.videoPlayedNS = jSONObject.optString("videoPlayedNS");
        if (JSONObject.NULL.toString().equals(adBaseInfo.videoPlayedNS)) {
            adBaseInfo.videoPlayedNS = "";
        }
        adBaseInfo.videoPlayedNSConfig = jSONObject.optString("videoPlayedNSConfig");
        if (JSONObject.NULL.toString().equals(adBaseInfo.videoPlayedNSConfig)) {
            adBaseInfo.videoPlayedNSConfig = "";
        }
        adBaseInfo.productName = jSONObject.optString("productName");
        if (JSONObject.NULL.toString().equals(adBaseInfo.productName)) {
            adBaseInfo.productName = "";
        }
        ABParams aBParams = new ABParams();
        adBaseInfo.mABParams = aBParams;
        try {
            aBParams.parseJson(new JSONObject(jSONObject.optString("expParam")));
        } catch (Exception unused) {
        }
        adBaseInfo.showUrl = jSONObject.optString("showUrl");
        if (JSONObject.NULL.toString().equals(adBaseInfo.showUrl)) {
            adBaseInfo.showUrl = "";
        }
        adBaseInfo.clickUrl = jSONObject.optString("clickUrl");
        if (JSONObject.NULL.toString().equals(adBaseInfo.clickUrl)) {
            adBaseInfo.clickUrl = "";
        }
        adBaseInfo.convUrl = jSONObject.optString("convUrl");
        if (JSONObject.NULL.toString().equals(adBaseInfo.convUrl)) {
            adBaseInfo.convUrl = "";
        }
        adBaseInfo.adAttributeType = jSONObject.optInt("adAttributeType");
        AdInfo.H5Config h5Config = new AdInfo.H5Config();
        adBaseInfo.apiExpParam = h5Config;
        h5Config.parseJson(jSONObject.optJSONObject("apiExpParam"));
        adBaseInfo.taskType = jSONObject.optInt("taskType");
        adBaseInfo.campaignType = jSONObject.optInt("campaignType");
        adBaseInfo.itemType = jSONObject.optInt("itemType");
        adBaseInfo.industryFirstLevelId = jSONObject.optInt("industryFirstLevelId");
        adBaseInfo.extraClickReward = jSONObject.optBoolean("extraClickReward");
        adBaseInfo.enableClientProofreadTime = jSONObject.optBoolean("enableClientProofreadTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.AdBaseInfo adBaseInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = adBaseInfo.creativeId;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", j4);
        }
        int i4 = adBaseInfo.adSourceType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adSourceType", i4);
        }
        String str = adBaseInfo.liveStreamId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "liveStreamId", adBaseInfo.liveStreamId);
        }
        int i5 = adBaseInfo.universeLiveType;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "universeLiveType", i5);
        }
        long j5 = adBaseInfo.viewCount;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "viewCount", j5);
        }
        String str2 = adBaseInfo.sdkExtraData;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkExtraData", adBaseInfo.sdkExtraData);
        }
        String str3 = adBaseInfo.adDescription;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adDescription", adBaseInfo.adDescription);
        }
        String str4 = adBaseInfo.installAppLabel;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "installAppLabel", adBaseInfo.installAppLabel);
        }
        String str5 = adBaseInfo.openAppLabel;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "openAppLabel", adBaseInfo.openAppLabel);
        }
        String str6 = adBaseInfo.adMarkIcon;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adMarkIcon", adBaseInfo.adMarkIcon);
        }
        String str7 = adBaseInfo.adGrayMarkIcon;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adGrayMarkIcon", adBaseInfo.adGrayMarkIcon);
        }
        String str8 = adBaseInfo.adSourceDescription;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adSourceDescription", adBaseInfo.adSourceDescription);
        }
        int i6 = adBaseInfo.adOperationType;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adOperationType", i6);
        }
        String str9 = adBaseInfo.adActionDescription;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adActionDescription", adBaseInfo.adActionDescription);
        }
        String str10 = adBaseInfo.adActionBarColor;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adActionBarColor", adBaseInfo.adActionBarColor);
        }
        int i7 = adBaseInfo.adShowDuration;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adShowDuration", i7);
        }
        String str11 = adBaseInfo.appName;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", adBaseInfo.appName);
        }
        String str12 = adBaseInfo.realAppName;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "realAppName", adBaseInfo.realAppName);
        }
        String str13 = adBaseInfo.appIconUrl;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appIconUrl", adBaseInfo.appIconUrl);
        }
        String str14 = adBaseInfo.appPackageName;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appPackageName", adBaseInfo.appPackageName);
        }
        int i8 = adBaseInfo.appScore;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appScore", i8);
        }
        String str15 = adBaseInfo.appDownloadCountDesc;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appDownloadCountDesc", adBaseInfo.appDownloadCountDesc);
        }
        String str16 = adBaseInfo.appCategory;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appCategory", adBaseInfo.appCategory);
        }
        String str17 = adBaseInfo.appVersion;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appVersion", adBaseInfo.appVersion);
        }
        String str18 = adBaseInfo.corporationName;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "corporationName", adBaseInfo.corporationName);
        }
        long j6 = adBaseInfo.packageSize;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageSize", j6);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appImageUrl", adBaseInfo.appImageUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "appImageSize", adBaseInfo.appImageSize);
        String str19 = adBaseInfo.appDescription;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appDescription", adBaseInfo.appDescription);
        }
        int i9 = adBaseInfo.enableSkipAd;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enableSkipAd", i9);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "adCacheSwitch", adBaseInfo.adCacheSwitch);
        com.kwad.sdk.utils.t.putValue(jSONObject, "adCacheSecond", adBaseInfo.adCacheSecond);
        com.kwad.sdk.utils.t.putValue(jSONObject, "adCacheStrategy", adBaseInfo.adCacheStrategy);
        com.kwad.sdk.utils.t.putValue(jSONObject, "adCacheSize", adBaseInfo.adCacheSize);
        int i10 = adBaseInfo.skipSecond;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "skipSecond", i10);
        }
        int i11 = adBaseInfo.ecpm;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ecpm", i11);
        }
        String str20 = adBaseInfo.videoPlayedNS;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoPlayedNS", adBaseInfo.videoPlayedNS);
        }
        String str21 = adBaseInfo.videoPlayedNSConfig;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "videoPlayedNSConfig", adBaseInfo.videoPlayedNSConfig);
        }
        String str22 = adBaseInfo.productName;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "productName", adBaseInfo.productName);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "expParam", adBaseInfo.mABParams.toJson().toString());
        String str23 = adBaseInfo.showUrl;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showUrl", adBaseInfo.showUrl);
        }
        String str24 = adBaseInfo.clickUrl;
        if (str24 != null && !str24.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clickUrl", adBaseInfo.clickUrl);
        }
        String str25 = adBaseInfo.convUrl;
        if (str25 != null && !str25.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "convUrl", adBaseInfo.convUrl);
        }
        int i12 = adBaseInfo.adAttributeType;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adAttributeType", i12);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "apiExpParam", adBaseInfo.apiExpParam);
        int i13 = adBaseInfo.taskType;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "taskType", i13);
        }
        int i14 = adBaseInfo.campaignType;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "campaignType", i14);
        }
        int i15 = adBaseInfo.itemType;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemType", i15);
        }
        int i16 = adBaseInfo.industryFirstLevelId;
        if (i16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "industryFirstLevelId", i16);
        }
        boolean z3 = adBaseInfo.extraClickReward;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "extraClickReward", z3);
        }
        boolean z4 = adBaseInfo.enableClientProofreadTime;
        if (z4) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "enableClientProofreadTime", z4);
        }
        return jSONObject;
    }
}