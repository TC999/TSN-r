package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ar */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9933ar implements InterfaceC10273d<AdTemplate> {
    /* renamed from: k */
    private static void m27208k(AdTemplate adTemplate, JSONObject jSONObject) {
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
            for (int i = 0; i < optJSONArray.length(); i++) {
                AdInfo adInfo = new AdInfo();
                adInfo.parseJson(optJSONArray.optJSONObject(i));
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

    /* renamed from: l */
    private static JSONObject m27207l(AdTemplate adTemplate, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adTemplate.mOriginJString;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "mOriginJString", adTemplate.mOriginJString);
        }
        long j = adTemplate.posId;
        if (j != 0) {
            C11126t.putValue(jSONObject, "posId", j);
        }
        int i = adTemplate.adStyle;
        if (i != 0) {
            C11126t.putValue(jSONObject, "adStyle", i);
        }
        int i2 = adTemplate.type;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "type", i2);
        }
        int i3 = adTemplate.contentType;
        if (i3 != 0) {
            C11126t.putValue(jSONObject, "contentType", i3);
        }
        C11126t.putValue(jSONObject, "adInfo", adTemplate.adInfoList);
        String str2 = adTemplate.impAdExtra;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "impAdExtra", adTemplate.impAdExtra);
        }
        long j2 = adTemplate.llsid;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "llsid", j2);
        }
        boolean z = adTemplate.mIsFromContent;
        if (z) {
            C11126t.putValue(jSONObject, "mIsFromContent", z);
        }
        String str3 = adTemplate.extra;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "extra", adTemplate.extra);
        }
        String str4 = adTemplate.mUniqueId;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "mUniqueId", adTemplate.mUniqueId);
        }
        long j3 = adTemplate.mBidEcpm;
        if (j3 != 0) {
            C11126t.putValue(jSONObject, "mBidEcpm", j3);
        }
        C11126t.m23678a(jSONObject, "mAdScene", adTemplate.mAdScene);
        int i4 = adTemplate.realShowType;
        if (i4 != 0) {
            C11126t.putValue(jSONObject, "realShowType", i4);
        }
        int i5 = adTemplate.mInitVoiceStatus;
        if (i5 != 0) {
            C11126t.putValue(jSONObject, "mInitVoiceStatus", i5);
        }
        int i6 = adTemplate.mMediaPlayerType;
        if (i6 != 0) {
            C11126t.putValue(jSONObject, "mMediaPlayerType", i6);
        }
        C11126t.m23678a(jSONObject, "mVideoPlayerStatus", adTemplate.mVideoPlayerStatus);
        C11126t.putValue(jSONObject, "mOutClickTimeParam", adTemplate.mOutClickTimeParam);
        C11126t.putValue(jSONObject, "mVisibleTimeParam", adTemplate.mVisibleTimeParam);
        int i7 = adTemplate.mIsLeftSlipStatus;
        if (i7 != 0) {
            C11126t.putValue(jSONObject, "mIsLeftSlipStatus", i7);
        }
        int i8 = adTemplate.mPhotoResponseType;
        if (i8 != 0) {
            C11126t.putValue(jSONObject, "mPhotoResponseType", i8);
        }
        C11126t.m23678a(jSONObject, "mPageInfo", adTemplate.mPageInfo);
        C11126t.putValue(jSONObject, "mIsForceJumpLandingPage", adTemplate.mIsForceJumpLandingPage);
        boolean z2 = adTemplate.mIsAudioEnable;
        if (z2) {
            C11126t.putValue(jSONObject, "mIsAudioEnable", z2);
        }
        boolean z3 = adTemplate.mRewardVerifyCalled;
        if (z3) {
            C11126t.putValue(jSONObject, "mRewardVerifyCalled", z3);
        }
        boolean z4 = adTemplate.isWebViewDownload;
        if (z4) {
            C11126t.putValue(jSONObject, "isWebViewDownload", z4);
        }
        boolean z5 = adTemplate.watched;
        if (z5) {
            C11126t.putValue(jSONObject, "watched", z5);
        }
        boolean z6 = adTemplate.converted;
        if (z6) {
            C11126t.putValue(jSONObject, "converted", z6);
        }
        C11126t.putValue(jSONObject, "fromCache", adTemplate.fromCache);
        long j4 = adTemplate.loadDataTime;
        if (j4 != 0) {
            C11126t.putValue(jSONObject, "loadDataTime", j4);
        }
        long j5 = adTemplate.showStartTime;
        if (j5 != 0) {
            C11126t.putValue(jSONObject, "showStartTime", j5);
        }
        boolean z7 = adTemplate.notNetworkRequest;
        if (z7) {
            C11126t.putValue(jSONObject, "notNetworkRequest", z7);
        }
        long j6 = adTemplate.downloadDuration;
        if (j6 != 0) {
            C11126t.putValue(jSONObject, "downloadDuration", j6);
        }
        long j7 = adTemplate.adLoadTotalTime;
        if (j7 != 0) {
            C11126t.putValue(jSONObject, "adLoadTotalTime", j7);
        }
        long j8 = adTemplate.adShowStartTimeStamp;
        if (j8 != 0) {
            C11126t.putValue(jSONObject, "adShowStartTimeStamp", j8);
        }
        C11126t.m23678a(jSONObject, "mAdStatusInfo", adTemplate.mAdStatusInfo);
        C11126t.m23678a(jSONObject, "adVideoPreCacheConfig", adTemplate.adVideoPreCacheConfig);
        boolean z8 = adTemplate.isNativeRewardPreview;
        if (z8) {
            C11126t.putValue(jSONObject, "isNativeRewardPreview", z8);
        }
        boolean z9 = adTemplate.mInstallApkFromSDK;
        if (z9) {
            C11126t.putValue(jSONObject, "mInstallApkFromSDK", z9);
        }
        boolean z10 = adTemplate.mInstallApkFormUser;
        if (z10) {
            C11126t.putValue(jSONObject, "mInstallApkFormUser", z10);
        }
        boolean z11 = adTemplate.mClickOpenAppStore;
        if (z11) {
            C11126t.putValue(jSONObject, "mClickOpenAppStore", z11);
        }
        String str5 = adTemplate.mDataLoadTraceElement;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "mDataLoadTraceElement", adTemplate.mDataLoadTraceElement);
        }
        String str6 = adTemplate.mDataCacheTraceElement;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, "mDataCacheTraceElement", adTemplate.mDataCacheTraceElement);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* synthetic */ void mo26477a(AdTemplate adTemplate, JSONObject jSONObject) {
        m27208k(adTemplate, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* synthetic */ JSONObject mo26476b(AdTemplate adTemplate, JSONObject jSONObject) {
        return m27207l(adTemplate, jSONObject);
    }
}
