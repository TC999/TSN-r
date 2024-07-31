package com.kwad.sdk.core.p389b.p390a;

import androidx.core.app.NotificationCompat;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.v */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10224v implements InterfaceC10273d<AdInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo adInfo, JSONObject jSONObject) {
        m26640a(adInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo adInfo, JSONObject jSONObject) {
        return m26639b(adInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26640a(AdInfo adInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdInfo.AdBaseInfo adBaseInfo = new AdInfo.AdBaseInfo();
        adInfo.adBaseInfo = adBaseInfo;
        adBaseInfo.parseJson(jSONObject.optJSONObject("adBaseInfo"));
        AdInfo.AdvertiserInfo advertiserInfo = new AdInfo.AdvertiserInfo();
        adInfo.advertiserInfo = advertiserInfo;
        advertiserInfo.parseJson(jSONObject.optJSONObject("advertiserInfo"));
        AdInfo.AdConversionInfo adConversionInfo = new AdInfo.AdConversionInfo();
        adInfo.adConversionInfo = adConversionInfo;
        adConversionInfo.parseJson(jSONObject.optJSONObject("adConversionInfo"));
        AdInfo.AdMaterialInfo adMaterialInfo = new AdInfo.AdMaterialInfo();
        adInfo.adMaterialInfo = adMaterialInfo;
        adMaterialInfo.parseJson(jSONObject.optJSONObject("adMaterialInfo"));
        adInfo.adTrackInfoList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("adTrackInfo");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                AdInfo.AdTrackInfo adTrackInfo = new AdInfo.AdTrackInfo();
                adTrackInfo.parseJson(optJSONArray.optJSONObject(i));
                adInfo.adTrackInfoList.add(adTrackInfo);
            }
        }
        AdInfo.DownloadSafeInfo downloadSafeInfo = new AdInfo.DownloadSafeInfo();
        adInfo.downloadSafeInfo = downloadSafeInfo;
        downloadSafeInfo.parseJson(jSONObject.optJSONObject("downloadSafeInfo"));
        AdInfo.UnDownloadConf unDownloadConf = new AdInfo.UnDownloadConf();
        adInfo.unDownloadConf = unDownloadConf;
        unDownloadConf.parseJson(jSONObject.optJSONObject("unDownloadConf"));
        adInfo.status = jSONObject.optInt("status");
        adInfo.progress = jSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS);
        adInfo.soFarBytes = jSONObject.optLong("soFarBytes");
        adInfo.totalBytes = jSONObject.optLong("totalBytes");
        adInfo.downloadFilePath = jSONObject.optString("downloadFilePath");
        if (JSONObject.NULL.toString().equals(adInfo.downloadFilePath)) {
            adInfo.downloadFilePath = "";
        }
        adInfo.downloadId = jSONObject.optString("downloadId");
        if (JSONObject.NULL.toString().equals(adInfo.downloadId)) {
            adInfo.downloadId = "";
        }
        adInfo.mStartDownloadTime = jSONObject.optLong("mStartDownloadTime");
        AdInfo.AdPreloadInfo adPreloadInfo = new AdInfo.AdPreloadInfo();
        adInfo.adPreloadInfo = adPreloadInfo;
        adPreloadInfo.parseJson(jSONObject.optJSONObject("adPreloadInfo"));
        AdInfo.AdSplashInfo adSplashInfo = new AdInfo.AdSplashInfo();
        adInfo.adSplashInfo = adSplashInfo;
        adSplashInfo.parseJson(jSONObject.optJSONObject("adSplashInfo"));
        AdStyleInfo adStyleInfo = new AdStyleInfo();
        adInfo.adStyleInfo = adStyleInfo;
        adStyleInfo.parseJson(jSONObject.optJSONObject("adStyleInfo"));
        AdStyleInfo adStyleInfo2 = new AdStyleInfo();
        adInfo.adStyleInfo2 = adStyleInfo2;
        adStyleInfo2.parseJson(jSONObject.optJSONObject("adStyleInfo2"));
        AdInfo.AdAggregateInfo adAggregateInfo = new AdInfo.AdAggregateInfo();
        adInfo.adAggregateInfo = adAggregateInfo;
        adAggregateInfo.parseJson(jSONObject.optJSONObject("adAggregateInfo"));
        AdInfo.AdRewardInfo adRewardInfo = new AdInfo.AdRewardInfo();
        adInfo.adRewardInfo = adRewardInfo;
        adRewardInfo.parseJson(jSONObject.optJSONObject("adRewardInfo"));
        adInfo.serverExt = jSONObject.optString("serverExt");
        if (JSONObject.NULL.toString().equals(adInfo.serverExt)) {
            adInfo.serverExt = "";
        }
        AdInfo.AdStyleConfInfo adStyleConfInfo = new AdInfo.AdStyleConfInfo();
        adInfo.adStyleConfInfo = adStyleConfInfo;
        adStyleConfInfo.parseJson(jSONObject.optJSONObject("adStyleConfInfo"));
        AdInfo.FullScreenVideoInfo fullScreenVideoInfo = new AdInfo.FullScreenVideoInfo();
        adInfo.fullScreenVideoInfo = fullScreenVideoInfo;
        fullScreenVideoInfo.parseJson(jSONObject.optJSONObject("fullScreenVideoInfo"));
        AdInfo.AdFeedInfo adFeedInfo = new AdInfo.AdFeedInfo();
        adInfo.adFeedInfo = adFeedInfo;
        adFeedInfo.parseJson(jSONObject.optJSONObject("adFeedInfo"));
        AdInfo.AdInsertScreenInfo adInsertScreenInfo = new AdInfo.AdInsertScreenInfo();
        adInfo.adInsertScreenInfo = adInsertScreenInfo;
        adInsertScreenInfo.parseJson(jSONObject.optJSONObject("adInsertScreenInfo"));
        AdProductInfo adProductInfo = new AdProductInfo();
        adInfo.adProductInfo = adProductInfo;
        adProductInfo.parseJson(jSONObject.optJSONObject("adProductInfo"));
        adInfo.ocpcActionType = jSONObject.optInt("ocpcActionType");
        AdMatrixInfo adMatrixInfo = new AdMatrixInfo();
        adInfo.adMatrixInfo = adMatrixInfo;
        adMatrixInfo.parseJson(jSONObject.optJSONObject("adMatrixInfo"));
        adInfo.trace = jSONObject.optString("trace");
        if (JSONObject.NULL.toString().equals(adInfo.trace)) {
            adInfo.trace = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26639b(AdInfo adInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.m23678a(jSONObject, "adBaseInfo", adInfo.adBaseInfo);
        C11126t.m23678a(jSONObject, "advertiserInfo", adInfo.advertiserInfo);
        C11126t.m23678a(jSONObject, "adConversionInfo", adInfo.adConversionInfo);
        C11126t.m23678a(jSONObject, "adMaterialInfo", adInfo.adMaterialInfo);
        C11126t.putValue(jSONObject, "adTrackInfo", adInfo.adTrackInfoList);
        C11126t.m23678a(jSONObject, "downloadSafeInfo", adInfo.downloadSafeInfo);
        C11126t.m23678a(jSONObject, "unDownloadConf", adInfo.unDownloadConf);
        int i = adInfo.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        int i2 = adInfo.progress;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, NotificationCompat.CATEGORY_PROGRESS, i2);
        }
        long j = adInfo.soFarBytes;
        if (j != 0) {
            C11126t.putValue(jSONObject, "soFarBytes", j);
        }
        long j2 = adInfo.totalBytes;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "totalBytes", j2);
        }
        String str = adInfo.downloadFilePath;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "downloadFilePath", adInfo.downloadFilePath);
        }
        String str2 = adInfo.downloadId;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "downloadId", adInfo.downloadId);
        }
        long j3 = adInfo.mStartDownloadTime;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "mStartDownloadTime", j3);
        }
        C11126t.m23678a(jSONObject, "adPreloadInfo", adInfo.adPreloadInfo);
        C11126t.m23678a(jSONObject, "adSplashInfo", adInfo.adSplashInfo);
        C11126t.m23678a(jSONObject, "adStyleInfo", adInfo.adStyleInfo);
        C11126t.m23678a(jSONObject, "adStyleInfo2", adInfo.adStyleInfo2);
        C11126t.m23678a(jSONObject, "adAggregateInfo", adInfo.adAggregateInfo);
        C11126t.m23678a(jSONObject, "adRewardInfo", adInfo.adRewardInfo);
        String str3 = adInfo.serverExt;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "serverExt", adInfo.serverExt);
        }
        C11126t.m23678a(jSONObject, "adStyleConfInfo", adInfo.adStyleConfInfo);
        C11126t.m23678a(jSONObject, "fullScreenVideoInfo", adInfo.fullScreenVideoInfo);
        C11126t.m23678a(jSONObject, "adFeedInfo", adInfo.adFeedInfo);
        C11126t.m23678a(jSONObject, "adInsertScreenInfo", adInfo.adInsertScreenInfo);
        C11126t.m23678a(jSONObject, "adProductInfo", adInfo.adProductInfo);
        int i3 = adInfo.ocpcActionType;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "ocpcActionType", i3);
        }
        C11126t.m23678a(jSONObject, "adMatrixInfo", adInfo.adMatrixInfo);
        String str4 = adInfo.trace;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "trace", adInfo.trace);
        }
        return jSONObject;
    }
}
