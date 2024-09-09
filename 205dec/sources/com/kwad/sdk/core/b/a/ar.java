package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ar implements com.kwad.sdk.core.d<AdTemplate> {
    private static void k(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTemplate.mOriginJString = jSONObject.optString("mOriginJString");
        if (JSONObject.NULL.toString().equals(adTemplate.mOriginJString)) {
            adTemplate.mOriginJString = "";
        }
        adTemplate.posId = jSONObject.optLong("posId");
        adTemplate.adStyle = jSONObject.optInt("adStyle");
        adTemplate.type = jSONObject.optInt("type");
        adTemplate.contentType = jSONObject.optInt("contentType");
        adTemplate.adInfoList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                AdInfo adInfo = new AdInfo();
                adInfo.parseJson(optJSONArray.optJSONObject(i4));
                adTemplate.adInfoList.add(adInfo);
            }
        }
        adTemplate.impAdExtra = jSONObject.optString("impAdExtra");
        if (JSONObject.NULL.toString().equals(adTemplate.impAdExtra)) {
            adTemplate.impAdExtra = "";
        }
        adTemplate.llsid = jSONObject.optLong("llsid");
        adTemplate.mIsFromContent = jSONObject.optBoolean("mIsFromContent");
        adTemplate.extra = jSONObject.optString("extra");
        if (JSONObject.NULL.toString().equals(adTemplate.extra)) {
            adTemplate.extra = "";
        }
        adTemplate.mUniqueId = jSONObject.optString("mUniqueId");
        if (JSONObject.NULL.toString().equals(adTemplate.mUniqueId)) {
            adTemplate.mUniqueId = "";
        }
        adTemplate.mBidEcpm = jSONObject.optLong("mBidEcpm");
        SceneImpl sceneImpl = new SceneImpl();
        adTemplate.mAdScene = sceneImpl;
        sceneImpl.parseJson(jSONObject.optJSONObject("mAdScene"));
        adTemplate.realShowType = jSONObject.optInt("realShowType");
        adTemplate.mInitVoiceStatus = jSONObject.optInt("mInitVoiceStatus");
        adTemplate.mMediaPlayerType = jSONObject.optInt("mMediaPlayerType");
        VideoPlayerStatus videoPlayerStatus = new VideoPlayerStatus();
        adTemplate.mVideoPlayerStatus = videoPlayerStatus;
        videoPlayerStatus.parseJson(jSONObject.optJSONObject("mVideoPlayerStatus"));
        adTemplate.mOutClickTimeParam = jSONObject.optLong("mOutClickTimeParam", new Long("-1").longValue());
        adTemplate.mVisibleTimeParam = jSONObject.optLong("mVisibleTimeParam", new Long("-1").longValue());
        adTemplate.mIsLeftSlipStatus = jSONObject.optInt("mIsLeftSlipStatus");
        adTemplate.mPhotoResponseType = jSONObject.optInt("mPhotoResponseType");
        PageInfo pageInfo = new PageInfo();
        adTemplate.mPageInfo = pageInfo;
        pageInfo.parseJson(jSONObject.optJSONObject("mPageInfo"));
        adTemplate.mIsForceJumpLandingPage = jSONObject.optBoolean("mIsForceJumpLandingPage", new Boolean("false").booleanValue());
        adTemplate.mIsAudioEnable = jSONObject.optBoolean("mIsAudioEnable");
        adTemplate.mRewardVerifyCalled = jSONObject.optBoolean("mRewardVerifyCalled");
        adTemplate.isWebViewDownload = jSONObject.optBoolean("isWebViewDownload");
        adTemplate.watched = jSONObject.optBoolean("watched");
        adTemplate.converted = jSONObject.optBoolean("converted");
        adTemplate.fromCache = jSONObject.optBoolean("fromCache", new Boolean("false").booleanValue());
        adTemplate.loadDataTime = jSONObject.optLong("loadDataTime");
        adTemplate.showStartTime = jSONObject.optLong("showStartTime");
        adTemplate.notNetworkRequest = jSONObject.optBoolean("notNetworkRequest");
        adTemplate.downloadDuration = jSONObject.optLong("downloadDuration");
        adTemplate.adLoadTotalTime = jSONObject.optLong("adLoadTotalTime");
        adTemplate.adShowStartTimeStamp = jSONObject.optLong("adShowStartTimeStamp");
        AdStatusInfo adStatusInfo = new AdStatusInfo();
        adTemplate.mAdStatusInfo = adStatusInfo;
        adStatusInfo.parseJson(jSONObject.optJSONObject("mAdStatusInfo"));
        AdVideoPreCacheConfig adVideoPreCacheConfig = new AdVideoPreCacheConfig();
        adTemplate.adVideoPreCacheConfig = adVideoPreCacheConfig;
        adVideoPreCacheConfig.parseJson(jSONObject.optJSONObject("adVideoPreCacheConfig"));
        adTemplate.isNativeRewardPreview = jSONObject.optBoolean("isNativeRewardPreview");
        adTemplate.mInstallApkFromSDK = jSONObject.optBoolean("mInstallApkFromSDK");
        adTemplate.mInstallApkFormUser = jSONObject.optBoolean("mInstallApkFormUser");
        adTemplate.mClickOpenAppStore = jSONObject.optBoolean("mClickOpenAppStore");
        adTemplate.mDataLoadTraceElement = jSONObject.optString("mDataLoadTraceElement");
        if (JSONObject.NULL.toString().equals(adTemplate.mDataLoadTraceElement)) {
            adTemplate.mDataLoadTraceElement = "";
        }
        adTemplate.mDataCacheTraceElement = jSONObject.optString("mDataCacheTraceElement");
        if (JSONObject.NULL.toString().equals(adTemplate.mDataCacheTraceElement)) {
            adTemplate.mDataCacheTraceElement = "";
        }
    }

    private static JSONObject l(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adTemplate.mOriginJString;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mOriginJString", adTemplate.mOriginJString);
        }
        long j4 = adTemplate.posId;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posId", j4);
        }
        int i4 = adTemplate.adStyle;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adStyle", i4);
        }
        int i5 = adTemplate.type;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "type", i5);
        }
        int i6 = adTemplate.contentType;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "contentType", i6);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "adInfo", adTemplate.adInfoList);
        String str2 = adTemplate.impAdExtra;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "impAdExtra", adTemplate.impAdExtra);
        }
        long j5 = adTemplate.llsid;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j5);
        }
        boolean z3 = adTemplate.mIsFromContent;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mIsFromContent", z3);
        }
        String str3 = adTemplate.extra;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "extra", adTemplate.extra);
        }
        String str4 = adTemplate.mUniqueId;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mUniqueId", adTemplate.mUniqueId);
        }
        long j6 = adTemplate.mBidEcpm;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mBidEcpm", j6);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "mAdScene", adTemplate.mAdScene);
        int i7 = adTemplate.realShowType;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "realShowType", i7);
        }
        int i8 = adTemplate.mInitVoiceStatus;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mInitVoiceStatus", i8);
        }
        int i9 = adTemplate.mMediaPlayerType;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mMediaPlayerType", i9);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "mVideoPlayerStatus", adTemplate.mVideoPlayerStatus);
        com.kwad.sdk.utils.t.putValue(jSONObject, "mOutClickTimeParam", adTemplate.mOutClickTimeParam);
        com.kwad.sdk.utils.t.putValue(jSONObject, "mVisibleTimeParam", adTemplate.mVisibleTimeParam);
        int i10 = adTemplate.mIsLeftSlipStatus;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mIsLeftSlipStatus", i10);
        }
        int i11 = adTemplate.mPhotoResponseType;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mPhotoResponseType", i11);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "mPageInfo", adTemplate.mPageInfo);
        com.kwad.sdk.utils.t.putValue(jSONObject, "mIsForceJumpLandingPage", adTemplate.mIsForceJumpLandingPage);
        boolean z4 = adTemplate.mIsAudioEnable;
        if (z4) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mIsAudioEnable", z4);
        }
        boolean z5 = adTemplate.mRewardVerifyCalled;
        if (z5) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mRewardVerifyCalled", z5);
        }
        boolean z6 = adTemplate.isWebViewDownload;
        if (z6) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isWebViewDownload", z6);
        }
        boolean z7 = adTemplate.watched;
        if (z7) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "watched", z7);
        }
        boolean z8 = adTemplate.converted;
        if (z8) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "converted", z8);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "fromCache", adTemplate.fromCache);
        long j7 = adTemplate.loadDataTime;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadDataTime", j7);
        }
        long j8 = adTemplate.showStartTime;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showStartTime", j8);
        }
        boolean z9 = adTemplate.notNetworkRequest;
        if (z9) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "notNetworkRequest", z9);
        }
        long j9 = adTemplate.downloadDuration;
        if (j9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadDuration", j9);
        }
        long j10 = adTemplate.adLoadTotalTime;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adLoadTotalTime", j10);
        }
        long j11 = adTemplate.adShowStartTimeStamp;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adShowStartTimeStamp", j11);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "mAdStatusInfo", adTemplate.mAdStatusInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "adVideoPreCacheConfig", adTemplate.adVideoPreCacheConfig);
        boolean z10 = adTemplate.isNativeRewardPreview;
        if (z10) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isNativeRewardPreview", z10);
        }
        boolean z11 = adTemplate.mInstallApkFromSDK;
        if (z11) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mInstallApkFromSDK", z11);
        }
        boolean z12 = adTemplate.mInstallApkFormUser;
        if (z12) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mInstallApkFormUser", z12);
        }
        boolean z13 = adTemplate.mClickOpenAppStore;
        if (z13) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mClickOpenAppStore", z13);
        }
        String str5 = adTemplate.mDataLoadTraceElement;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mDataLoadTraceElement", adTemplate.mDataLoadTraceElement);
        }
        String str6 = adTemplate.mDataCacheTraceElement;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mDataCacheTraceElement", adTemplate.mDataCacheTraceElement);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* synthetic */ void a(AdTemplate adTemplate, JSONObject jSONObject) {
        k(adTemplate, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* synthetic */ JSONObject b(AdTemplate adTemplate, JSONObject jSONObject) {
        return l(adTemplate, jSONObject);
    }
}
